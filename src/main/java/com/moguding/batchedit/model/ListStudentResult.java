package com.moguding.batchedit.model;

import java.util.List;

/**
 * @author admin
 */
public class ListStudentResult<T> {

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
    private List<T> data;

    public ListStudentResult(String code, String msg, List<T> data) {
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

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ListStudentResult{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
