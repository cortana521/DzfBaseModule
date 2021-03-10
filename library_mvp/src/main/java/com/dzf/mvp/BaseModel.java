package com.dzf.mvp;

public class BaseModel {

    //     "status": true,
    //      "msg": "修改密码成功",
    //       "code": 200

    private boolean status;
    private String msg;
    private int code;
    private String vote_cut;

    public boolean getStatus() {
        return status; 
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) { 
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getVote_cut() {
        return vote_cut;
    }

    public void setVote_cut(String vote_cut) {
        this.vote_cut = vote_cut;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", code=" + code +
                ", vote_cut='" + vote_cut + '\'' +
                '}';
    }
}
