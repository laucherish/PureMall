package com.laucherish.puremall.mvp.model.entity;

import com.laucherish.puremall.mvp.model.api.Api;

import java.io.Serializable;

/**
 * Author : liuyangchi.
 * Description : BaseResponse.
 * Date : 2020/7/1.
 */
public class BaseResponse<T> implements Serializable {
    private T data;
    private int errno;
    private String errmsg;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    /**
     * 请求是否成功
     *
     * @return
     */
    public boolean isSuccess() {
        return errno == Api.REQUEST_SUCCESS;
    }
}
