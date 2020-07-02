package com.laucherish.puremall.mvp.model.entity;

import java.util.List;

/**
 * Author : liuyangchi.
 * Description : IndexBean.
 * Date : 2020/7/2.
 */
public class IndexBean {

    public List<NewGoodsListBean> newGoodsList;
    public List<CouponListBean> couponList;
    public List<ChannelBean> channel;
    public List<GrouponListBean> grouponList;
    public List<BannerBean> banner;
    public List<BrandListBean> brandList;
    public List<HotGoodsListBean> hotGoodsList;
    public List<TopicListBean> topicList;
    public List<FloorGoodsListBean> floorGoodsList;

    public static class NewGoodsListBean {
        /**
         * id : 1116011
         * name : 蔓越莓曲奇 200克
         * brief : 酥脆奶香，甜酸回味
         * picUrl : http://yanxuan.nosdn.127.net/767b370d07f3973500db54900bcbd2a7.png
         * isNew : true
         * isHot : true
         * counterPrice : 56
         * retailPrice : 36
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

    public static class CouponListBean {
        /**
         * id : 1
         * name : 限时满减券
         * desc : 全场通用
         * tag : 无限制
         * discount : 5
         * min : 99
         * days : 10
         */

        public int id;
        public String name;
        public String desc;
        public String tag;
        public int discount;
        public int min;
        public int days;
    }

    public static class ChannelBean {
        /**
         * id : 1005000
         * name : 居家
         * iconUrl : http://yanxuan.nosdn.127.net/a45c2c262a476fea0b9fc684fed91ef5.png
         */

        public int id;
        public String name;
        public String iconUrl;
    }

    public static class GrouponListBean {
        /**
         * id : 1110016
         * name : 天然硅胶宠物除毛按摩刷
         * brief : 顺滑平面，猫狗通用，去除死毛
         * picUrl : http://yanxuan.nosdn.127.net/3bd73b7279a83d1cbb50c0e45778e6d6.png
         * counterPrice : 59
         * retailPrice : 39
         * grouponPrice : 0
         * grouponDiscount : 39
         * grouponMember : 2
         * expireTime : 2020-12-31 00:00:00
         */

        public int id;
        public String name;
        public String brief;
        public String picUrl;
        public int counterPrice;
        public int retailPrice;
        public int grouponPrice;
        public int grouponDiscount;
        public int grouponMember;
        public String expireTime;
    }

    public static class BannerBean {
        /**
         * id : 1
         * name : 合作 谁是你的菜
         * link :
         * url : http://yanxuan.nosdn.127.net/65091eebc48899298171c2eb6696fe27.jpg
         * position : 1
         * content : 合作 谁是你的菜
         * enabled : true
         * addTime : 2018-02-01 00:00:00
         * updateTime : 2018-02-01 00:00:00
         * deleted : false
         */

        public int id;
        public String name;
        public String link;
        public String url;
        public int position;
        public String content;
        public boolean enabled;
        public String addTime;
        public String updateTime;
        public boolean deleted;
    }

    public static class BrandListBean {
        /**
         * id : 1001000
         * name : MUJI制造商
         * desc : 严选精选了MUJI制造商和生产原料，
         用几乎零利润的价格，剔除品牌溢价，
         让用户享受原品牌的品质生活。
         * picUrl : http://yanxuan.nosdn.127.net/1541445967645114dd75f6b0edc4762d.png
         * floorPrice : 12.9
         */

        public int id;
        public String name;
        public String desc;
        public String picUrl;
        public double floorPrice;
    }

    public static class HotGoodsListBean {
        /**
         * id : 1006013
         * name : 双宫茧桑蚕丝被 空调被
         * brief : 一级桑蚕丝，吸湿透气柔软
         * picUrl : http://yanxuan.nosdn.127.net/583812520c68ca7995b6fac4c67ae2c7.png
         * isNew : false
         * isHot : true
         * counterPrice : 719
         * retailPrice : 699
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

    public static class TopicListBean {
        /**
         * id : 264
         * title : 设计师们推荐的应季好物
         * subtitle : 原创设计春款系列上新
         * price : 29.9
         * readCount : 77.7k
         * picUrl : https://yanxuan.nosdn.127.net/14918201901050274.jpg
         */

        public int id;
        public String title;
        public String subtitle;
        public double price;
        public String readCount;
        public String picUrl;
    }

    public static class FloorGoodsListBean {
        /**
         * name : 居家
         * goodsList : [{"id":1006002,"name":"轻奢纯棉刺绣水洗四件套","brief":"设计师原款，精致绣花",
         * "picUrl":"http://yanxuan.nosdn.127.net/8ab2d3287af0cefa2cc539e40600621d.png","isNew":false,"isHot":false,"counterPrice":919,"retailPrice":899},{"id":1006007,"name":"秋冬保暖加厚澳洲羊毛被","brief":"臻品级澳洲进口羊毛","picUrl":"http://yanxuan.nosdn.127.net/66425d1ed50b3968fed27c822fdd32e0.png","isNew":false,"isHot":false,"counterPrice":479,"retailPrice":459},{"id":1006013,"name":"双宫茧桑蚕丝被 空调被","brief":"一级桑蚕丝，吸湿透气柔软","picUrl":"http://yanxuan.nosdn.127.net/583812520c68ca7995b6fac4c67ae2c7.png","isNew":false,"isHot":true,"counterPrice":719,"retailPrice":699},{"id":1006014,"name":"双宫茧桑蚕丝被 子母被","brief":"双层子母被，四季皆可使用","picUrl":"http://yanxuan.nosdn.127.net/2b537159f0f789034bf8c4b339c43750.png","isNew":false,"isHot":true,"counterPrice":14199,"retailPrice":1399}]
         * id : 1005000
         */

        public String name;
        public int id;
        public List<GoodsListBean> goodsList;

        public static class GoodsListBean {
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
    }
}
