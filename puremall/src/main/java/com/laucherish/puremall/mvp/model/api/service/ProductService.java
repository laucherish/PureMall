package com.laucherish.puremall.mvp.model.api.service;

import com.laucherish.puremall.mvp.model.entity.BaseResponse;
import com.laucherish.puremall.mvp.model.entity.IndexBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Author : liuyangchi.
 * Description : ProductService.
 * Date : 2020/7/3.
 */
public interface ProductService {

    @GET("/wx/home/index")
    Observable<BaseResponse<IndexBean>> getRecommend();
}
