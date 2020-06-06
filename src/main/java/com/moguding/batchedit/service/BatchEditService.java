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
        //审核总结
        log.info("审核总结");
        batch(Constant.SUMMARY_JSON, Constant.SUMMARY_MIN_SIZE_NUM);
    }

    /**
     * 单个审核
     * @param json
     * @param sizeNum
     */
    public void batch(String json, int sizeNum) {
        //获取学生集合
        List<Student> data = getStudentList(json);

        data.forEach(student -> {
            //别太快，太快容易被发现
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }

            //根据ReportId获取单个学生信息
            Student stuEntity = getStudent(student.getReportId());

            Student stu = null;
            //字数
            int wordNum = stuEntity.getContent().length();
            log.info(stuEntity.getUsername()+"同学字数:"+wordNum);
            //sizeNum ----->  100:周报大于字数，500：月报大于字数，2500：总结大于字数
            if (stuEntity.getContent().isEmpty() || wordNum < sizeNum) {
                //判断是否是总结，总结逻辑另外处理，不满2500字驳回，2500-3000字，分值区间70-80；3000字以上，分值区间80-90
                if (sizeNum == Constant.SUMMARY_MIN_SIZE_NUM) {
                    //不满2500字驳回
                    stu = new Student(student.getReportId(), Constant.STATE_ERROR);
                    log.info(stuEntity.getUsername()+"同学总结已驳回！");
                } else {
                    //周报，月报手下留情去掉了驳回，改成给两颗星吧！  stu【批阅号，分数（星星百分比分数），已审核状态，星星】
                    stu = new Student(student.getReportId(), Constant.SCORE * Constant.Stars.TWO.getNum(),
                            Constant.STATE_OK, Constant.Stars.TWO.getNum());
                    log.info(stuEntity.getUsername()+"同学字数不满足，两颗星！");
                }
            } else {
                //判断是否是总结
                if (sizeNum == Constant.SUMMARY_MIN_SIZE_NUM) {
                    int score;
                    //如果是总结字数是2500-3000字
                    if (wordNum < Constant.SUMMARY_SIZE_NUM) {
                        //分数区间70-80
                        score = RandomNum(Constant.SCORE_SEVENTY, Constant.SCORE_EIGHTY);
                    //如果是总结字数是3000字以上
                    } else {
                        //分数区间80-90
                        score = RandomNum(Constant.SCORE_EIGHTY, Constant.SCORE_NINETY);
                    }
                    log.info(stuEntity.getUsername()+"同学分数："+score);
                    //stu【批阅号，分数，已审核状态】
                    stu = new Student(student.getReportId(), score, Constant.STATE_OK);
                } else {
                    //周报，月报获取随机星星4-5
                    int stars = RandomNum(Constant.Stars.FOUR.getNum(), Constant.Stars.FIVE.getNum());
                    log.info("{}:的随机星星》》》》》》》》》》》》》》{}", stuEntity.getUsername(), stars);
                    //stu【批阅号，分数（星星百分比分数），已审核状态，星星】
                    stu = new Student(student.getReportId(), Constant.SCORE * stars, Constant.STATE_OK, stars);
                }
            }
            //转成json
            String stuJson = JSONObject.toJSONString(stu);
            String updateJson = HttpUtil.sendPost(Constant.UPDATE_URL, stuJson, AUTHORIZATION);
            //返回修改状态
            log.info("审核返回结果：{}", updateJson);
        });
    }

    /**
     * 获取学生集合
     * @return
     */
    public List<Student> getStudentList(String json) {
        //获取json
        String result = HttpUtil.sendPost(Constant.GET_LIST_URL, json, AUTHORIZATION);
        //转成对象，获取data数据
        List<Student> data = JSONObject.parseObject(result, ListStudentResult.class).getData();
        log.info("获取学生信息集合：{}", data);

        return data;
    }

    /**
     * 根据ReportId获取单个学生
     * @param reportId
     * @return
     */
    public Student getStudent(String reportId) {
        //转成json
        Student getStu = new Student(reportId);
        String toStuJson = JSONObject.toJSONString(getStu);
        //获取单个学生提交信息
        String getStuJson = HttpUtil.sendPost(Constant.GET_STUDENT_URL, toStuJson, AUTHORIZATION);
        //json转对象
        Student stuEntity = JSONObject.parseObject(getStuJson, OneStudentResult.class).getData();
        log.info("获取{}学生信息：{}", stuEntity.getUsername(), getStuJson);

        return stuEntity;
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
