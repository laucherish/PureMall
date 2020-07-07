package com.laucherish.puremall.mvp.model.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Author : liuyangchi.
 * Description : CategoryBean.
 * Date : 2020/7/7.
 */
public class CategoryBean implements MultiItemEntity {

    /**
     * id : 1005000
     * name : 居家
     * keywords :
     * desc : 回家，放松身心
     * pid : 0
     * iconUrl : http://yanxuan.nosdn.127.net/a45c2c262a476fea0b9fc684fed91ef5.png
     * picUrl : http://yanxuan.nosdn.127.net/e8bf0cf08cf7eda21606ab191762e35c.png
     * level : L1
     * sortOrder : 2
     * addTime : 2018-02-01 00:00:00
     * updateTime : 2018-02-01 00:00:00
     * deleted : false
     */

    public int id;
    public String name;
    public String keywords;
    public String desc;
    public int pid;
    public String iconUrl;
    public String picUrl;
    public String level;
    public int sortOrder;
    public String addTime;
    public String updateTime;
    public boolean deleted;

    final public static int ITEM = 1;
    final public static int HEADER = 0;

    private int itemType = 1;

    @Override
    public int getItemType() {
        return itemType;
    }
}
