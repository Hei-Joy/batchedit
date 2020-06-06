package com.moguding.batchedit.model;

import java.util.List;

/**
 * @author yxb
 * @version 1.0
 * @description TODO
 * @date 2020/6/6 16:44
 */
public class SupplementaryStu {

    /**
     * 补签id
     */
    private String attendanceId;

    /**
     * 审核状态
     */
    private int applyState;


    /**
     * 用户名
     */
    private String username;

    public SupplementaryStu(String attendanceId, int applyState, String username) {
        this.attendanceId = attendanceId;
        this.applyState = applyState;
        this.username = username;
    }

    public String getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(String attendanceId) {
        this.attendanceId = attendanceId;
    }

    public int getApplyState() {
        return applyState;
    }

    public void setApplyState(int applyState) {
        this.applyState = applyState;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "SupplementaryStu{" +
                "attendanceId='" + attendanceId + '\'' +
                ", applyState=" + applyState +
                ", username='" + username + '\'' +
                '}';
    }
}
