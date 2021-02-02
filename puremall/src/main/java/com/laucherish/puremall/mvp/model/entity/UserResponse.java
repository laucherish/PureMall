package com.laucherish.puremall.mvp.model.entity;

import java.io.Serializable;

/**
 * Author : liuyangchi.
 * Description : UserResponse.
 * Date : 2/2/21.
 */
public class UserResponse implements Serializable {

    /**
     * userInfo : {"nickName":"user123","avatarUrl":""}
     * token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9
     * .eyJzdWIiOiJ0aGlzIGlzIHB1cmVtYWxsIHRva2VuIiwiYXVkIjoiTUlOSUFQUCIsImlzcyI6IlBVUkVNQUxMIiwiZXhwIjoxNjE0ODI4NDE1LCJ1c2VySWQiOjEsImlhdCI6MTYxMjIzNjQxNX0.i01XR8wk3ZH51D9sGsSMm3k_z9e8-kPKBUu-2wo9jeo
     */

    public UserInfoBean userInfo;
    public String token;

    public static class UserInfoBean implements Serializable {
        /**
         * nickName : user123
         * avatarUrl :
         */

        public String nickName;
        public String avatarUrl;
    }
}
