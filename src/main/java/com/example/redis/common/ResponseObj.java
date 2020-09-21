package com.example.redis.common;

import java.io.Serializable;

/**
 * @author chengliujie
 * @date 2020-04-14 13:37
 * @description:
 */
public class ResponseObj<T> implements Serializable {
    private static final long serialVersionUID = -3546286994645927974L;

    public static final String CODE_SUCCESS = "111111";
    public static final String CODE_FAILED = "999999";

    /**
     * 反馈编号
     */
    private String retCode;

    private String retSubCode;

    private String retMsg;

    private String retType;

    private T retData;

    public ResponseObj() {
    }

    public ResponseObj(String retCode, String retMsg, T retData) {
        this.retCode = retCode;
        this.retMsg = retMsg;
        this.retData = retData;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetSubCode() {
        return retSubCode;
    }

    public void setRetSubCode(String retSubCode) {
        this.retSubCode = retSubCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public String getRetType() {
        return retType;
    }

    public void setRetType(String retType) {
        this.retType = retType;
    }

    public T getRetData() {
        return retData;
    }

    public void setRetData(T retData) {
        this.retData = retData;
    }

    public static ResponseObj success() {
        return new ResponseObj("111111", null, null);
    }

    public static ResponseObj success(String retMsg) {
        return new ResponseObj("111111", retMsg, (Object) null);
    }

    public static ResponseObj failed() {
        return new ResponseObj("999999", (String) null, (Object) null);
    }
}
