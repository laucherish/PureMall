package com.laucherish.puremall.mvp.model.entity;

import java.io.Serializable;

/**
 * Author : liuyangchi.
 * Description : ProductBean.
 * Date : 2020/7/3.
 */
public class ProductBean implements Serializable {
    /**
     * id : 1006002
     * name : 轻奢纯棉刺绣水洗四件套
     * brief : 设计师原款，精致绣花
     * picUrl : http://yanxuan.nosdn.127.net/8ab2d3287af0cefa2cc539e40600621d.png
     * isNew : false
     * isHot : false
     * counterPrice : 919
     * retailPrice : 899
     */

    public int id;
    public String name;
    public String brief;
    public String picUrl;
    public boolean isNew;
    public boolean isHot;
    public int counterPrice;
    public int retailPrice;
}
