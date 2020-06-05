package com.moguding.batchedit.service;

import com.alibaba.fastjson.JSONObject;
import com.moguding.batchedit.model.*;
import com.moguding.batchedit.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * @author yxb
 * @version 1.0
 * @description TODO
 * @date 2020/6/3 17:55
 */
@Slf4j
@Service
public class BatchEditService {


    @Value("${authorization}")
    private String AUTHORIZATION;


    /**
     *一起审核
     */
    public void batheAll() {
        //审核周报
        log.info("审核周报");
        batch(Constant.WEEK_JSON, Constant.WEEK_SIZE_NUM);
        //审核月报
        log.info("审核月报");
        batch(Constant.MONTH_JSON, Constant.MONTH_SIZE_NUM);
    }

    /**
     * 单个审核
     * @param json
     * @param sizeNum
     */
    public void batch(String json, int sizeNum) {
        //获取json
        String result = HttpUtil.sendPost(Constant.GET_LIST_URL, json, AUTHORIZATION);
        //转成对象，获取data数据
        List<Student> data = JSONObject.parseObject(result, ListStudentResult.class).getData();
        log.info("获取学生信息集合：{}", data);

        data.forEach(student -> {
            //别太快，太快容易被发现
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            //转成json
            Student getStu = new Student(student.getReportId());
            String toStuJson = JSONObject.toJSONString(getStu);
            //获取单个学生提交信息
            String getStuJson = HttpUtil.sendPost(Constant.GET_STUDENT_URL, toStuJson, AUTHORIZATION);
            Student stuEntity = JSONObject.parseObject(getStuJson, OneStudentResult.class).getData();
            log.info("获取{}学生信息：{}", stuEntity.getUsername(), getStuJson);

            Student stu = null;
            //sizeNum ----->  100:周报大于字数，500：月报大于字数，3000：总结大于字数
            if (stuEntity.getContent().isEmpty() || stuEntity.getContent().length() < sizeNum) {

                //手下留情去掉了驳回，改成给两颗星吧！  stu【批阅号，分数（星星百分比分数），已审核状态，星星】
                stu = new Student(student.getReportId(), Constant.SCORE * Constant.Stars.TWO.getNum(),
                        Constant.STATE, Constant.Stars.TWO.getNum());

            } else {

                int stars = RandomNum(Constant.Stars.FOUR.getNum(), Constant.Stars.FIVE.getNum());
                log.info("{}:的随机星星》》》》》》》》》》》》》》{}", stuEntity.getUsername(), stars);
                //stu【批阅号，分数（星星百分比分数），已审核状态，星星】
                stu = new Student(student.getReportId(), Constant.SCORE * stars, Constant.STATE, stars);

            }
            //转成json
            String stuJson = JSONObject.toJSONString(stu);
            String updateJson = HttpUtil.sendPost(Constant.UPDATE_URL, stuJson, AUTHORIZATION);
            //返回修改状态
            log.info("审核返回结果：{}", updateJson);
        });
    }

    /**
     * 随机数区间
     * @return
     */
    public int RandomNum(int start, int end) {

        //产生随机数区间内方法
        int number = new Random().nextInt(end - start + 1) + start;

        return number;
    }

}
