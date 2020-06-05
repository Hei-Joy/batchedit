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
    private int score;
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


    public Student(String reportId, int score, int state, double starNum, String content, String username) {
        this.reportId = reportId;
        this.score = score;
        this.state = state;
        this.starNum = starNum;
        this.content = content;
        this.username = username;
    }

    public Student(String reportId) {
        this.reportId = reportId;
    }

    public Student(String reportId, int score, int state, double starNum) {
        this.reportId = reportId;
        this.score = score;
        this.state = state;
        this.starNum = starNum;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
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
