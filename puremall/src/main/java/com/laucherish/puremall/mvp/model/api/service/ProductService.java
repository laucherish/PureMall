package com.laucherish.puremall.mvp.model.api.service;

import com.laucherish.puremall.mvp.model.entity.BaseResponse;
import com.laucherish.puremall.mvp.model.entity.IndexBean;
import com.laucherish.puremall.mvp.model.entity.ProductDetailBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Author : liuyangchi.
 * Description : ProductService.
 * Date : 2020/7/3.
 */
public interface ProductService {

    @GET("/wx/home/index")
    Observable<BaseResponse<IndexBean>> getRecommend();

    @GET("/wx/goods/detail")
    Observable<BaseResponse<ProductDetailBean>> getProductDetail(
            @Query("id") String productId
    );
}
