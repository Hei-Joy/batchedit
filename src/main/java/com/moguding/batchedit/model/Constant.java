package com.moguding.batchedit.model;

/**
 * @author yxb
 * @version 1.0
 * @description TODO
 * @date 2020/6/5 13:35
 */
public class Constant {

    /**
     * 学生集合URL
     */
    public static final String GET_LIST_URL = "https://api.moguding.net:9000/practice/paper/v1/list";
    /**
     * 获取单个学生URL
     */
    public static final String GET_STUDENT_URL = "https://api.moguding.net:9000/practice/paper/v1/info";
    /**
     * 修改URL
     */
    public static final String UPDATE_URL = "https://api.moguding.net:9000/practice/paper/v1/audit";
    /**
     * 周报json
     * 懒得封装成对象再转json了
     */
    public static final String WEEK_JSON = "{\"currPage\":1,\"pageSize\":1000000,\"batchId\":\"87256fa0fa61554485f0aee99ae4793d\",\"classId\":\"\",\"teaId\":\"\",\"reportType\":\"week\",\"planId\":\"\",\"state\":0,\"studentNumber\":\"\",\"startTime\":\"\",\"endTime\":\"\"}";
    /**
     * 月报json
     * 懒得封装成对象再转json了
     */
    public static final String MONTH_JSON = "{\"currPage\":1,\"pageSize\":1000000,\"batchId\":\"87256fa0fa61554485f0aee99ae4793d\",\"classId\":\"\",\"teaId\":\"\",\"reportType\":\"month\",\"planId\":\"\",\"state\":0,\"studentNumber\":\"\",\"startTime\":\"\",\"endTime\":\"\"}";
    /**
     * 总结json
     * 懒得封装成对象再转json了
     */
    public static final String SUMMARY_JSON = "{\"currPage\":1,\"pageSize\":1000000,\"batchId\":\"87256fa0fa61554485f0aee99ae4793d\",\"classId\":\"\",\"teaId\":\"\",\"reportType\":\"summary\",\"planId\":\"\",\"state\":0,\"studentNumber\":\"\",\"startTime\":\"\",\"endTime\":\"\"}";
    /**
     * 周报字数
     */
    public static final int WEEK_SIZE_NUM = 100;
    /**
     * 月报字数
     */
    public static final int MONTH_SIZE_NUM = 500;
    /**
     * 总结最低字数限制
     */
    public static final int SUMMARY_MIN_SIZE_NUM = 2500;
    /**
     * 总结字数
     */
    public static final int SUMMARY_SIZE_NUM = 3000;
    /**
     * 星星分数比例
     */
    public static final int SCORE = 20;
    /**
     * 已经批改状态
     */
    public static final int STATE_OK = 1;
    /**
     * 驳回批改状态
     */
    public static final int STATE_ERROR = 2;
    /**
     * 分数70
     */
    public static final int SCORE_SEVENTY = 70;
    /**
     * 分数80
     */
    public static final int SCORE_EIGHTY = 80;
    /**
     * 分数90
     */
    public static final int SCORE_NINETY = 90;


    /**
     * 好久没用枚举了，总感觉怪怪的
     * 星星数
     */
    public enum Stars {

        ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5);

        private int num;

        Stars(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }
    }


}
