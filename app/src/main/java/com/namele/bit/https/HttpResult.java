package com.namele.bit.https;

/**
 * Created by yangbo on 2018/3/1
 */

public class HttpResult<T> {

    private int code;
    private String msg;
    private T assets;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String message) {
        this.msg = message;
    }

    public T getData() {
        return assets;
    }

    public void setData(T data) {
        this.assets = data;
    }

    public boolean isOk() {
        return code == 1000;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "code=" + code +
                ", message='" + msg + '\'' +
                (assets == null ? "" : (", data=" + assets)) +
                '}';
    }
}
