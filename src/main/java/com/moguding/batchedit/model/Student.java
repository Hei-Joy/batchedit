package com.moguding.batchedit.model;

/**
 * @author admin
 */
public class Student {

    /**
     * 周报，月报，或者总结id
     */
    private String reportId;
    /**
     * 分数
     */
    private Integer score;
    /**
     * 状态
     */
    private int state;
    /**
     * 星星
     */
    private double starNum;
    /**
     * 内容
     */
    private String content;
    /**
     * 姓名
     */
    private String username;


    public Student(String reportId, int state) {
        this.reportId = reportId;
        this.state = state;
    }

    public Student(String reportId) {
        this.reportId = reportId;
    }

    public Student(String reportId, Integer score, int state) {
        this.reportId = reportId;
        this.score = score;
        this.state = state;
    }

    public Student(String reportId, Integer score, int state, double starNum) {
        this.reportId = reportId;
        this.score = score;
        this.state = state;
        this.starNum = starNum;
    }

    /**
     * 必须加全参构造方法，不然fastjson封装不进对象，已经踩坑
     * @param reportId
     * @param score
     * @param state
     * @param starNum
     * @param content
     * @param username
     */
    public Student(String reportId, Integer score, int state, double starNum, String content, String username) {
        this.reportId = reportId;
        this.score = score;
        this.state = state;
        this.starNum = starNum;
        this.content = content;
        this.username = username;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public double getStarNum() {
        return starNum;
    }

    public void setStarNum(double starNum) {
        this.starNum = starNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Student{" +
                "reportId='" + reportId + '\'' +
                ", score=" + score +
                ", state=" + state +
                ", starNum=" + starNum +
                ", content='" + content + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
