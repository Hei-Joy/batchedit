package com.moguding.batchedit.model;

import java.util.List;

/**
 * @author yxb
 * @version 1.0
 * @description TODO
 * @date 2020/6/4 16:41
 */
public class OneStudentResult {
    /**
     * 状态
     */
    private String code;
    /**
     * 消息
     */
    private String msg;
    /**
     * 数据
     */
    private Student data;

    public OneStudentResult(String code, String msg, Student data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Student getData() {
        return data;
    }

    public void setData(Student data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "OneStudent{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
