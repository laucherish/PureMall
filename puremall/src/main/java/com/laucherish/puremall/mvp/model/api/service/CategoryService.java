package com.laucherish.puremall.mvp.model.api.service;

import com.laucherish.puremall.mvp.model.entity.BaseResponse;
import com.laucherish.puremall.mvp.model.entity.CategoryListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Author : liuyangchi.
 * Description : CategoryService.
 * Date : 2020/7/7.
 */
public interface CategoryService {

    @GET("/wx/catalog/index")
    Observable<BaseResponse<CategoryListBean>> getCategoryList();

    @GET("/wx/catalog/current")
    Observable<BaseResponse<CategoryListBean>> getCategory(@Query("id") int id);
}
