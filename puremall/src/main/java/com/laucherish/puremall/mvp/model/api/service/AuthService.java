package com.laucherish.puremall.mvp.model.api.service;

import com.laucherish.puremall.mvp.model.entity.BaseResponse;
import com.laucherish.puremall.mvp.model.entity.UserResponse;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Author : liuyangchi.
 * Description : AuthService.
 * Date : 2/2/21.
 */
public interface AuthService {

    @POST("/wx/auth/login")
    Observable<BaseResponse<UserResponse>> login(@Body Map<String, Object> params);
}
