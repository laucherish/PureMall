package com.laucherish.puremall.mvp.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Author : liuyangchi.
 * Description : ProductDetailBean.
 * Date : 1/20/21.
 */
public class ProductDetailBean implements Serializable {

    /**
     * userHasCollect
     */ /**
     * specificationList : [{"name":"规格","valueList":[{"id":1,"goodsId":1181000,
     * "specification":"规格","value":"1.5m床垫*1+枕头*2","picUrl":"","addTime":"2018-02-01 08:00:00",
     * "updateTime":"2018-02-01 08:00:00","deleted":false},{"id":2,"goodsId":1181000,
     * "specification":"规格","value":"1.8m床垫*1+枕头*2","picUrl":"","addTime":"2018-02-01 08:00:00",
     * "updateTime":"2018-02-01 08:00:00","deleted":false}]},{"name":"颜色","valueList":[{"id":3,
     * "goodsId":1181000,"specification":"颜色","value":"浅杏粉","picUrl":"http://yanxuan.nosdn.127
     * .net/10022c73fa7aa75c2c0d736e96cc56d5.png?quality=90&thumbnail=200x200&imageView",
     * "addTime":"2018-02-01 08:00:00","updateTime":"2018-02-01 08:00:00","deleted":false},{"id
     * ":4,"goodsId":1181000,"specification":"颜色","value":"玛瑙红","picUrl":"http://yanxuan.nosdn
     * .127.net/29442127f431a1a1801c195905319427.png?quality=90&thumbnail=200x200&imageView",
     * "addTime":"2018-02-01 08:00:00","updateTime":"2018-02-01 08:00:00","deleted":false},{"id
     * ":5,"goodsId":1181000,"specification":"颜色","value":"烟白灰","picUrl":"http://yanxuan.nosdn
     * .127.net/36f64a7161b67e7fb8ea45be32ecfa25.png?quality=90&thumbnail=200x200&imageView",
     * "addTime":"2018-02-01 08:00:00","updateTime":"2018-02-01 08:00:00","deleted":false}]}]
     * groupon : []
     * issue : [{"id":1,"question":"购买运费如何收取？","answer":"单笔订单金额（不含运费）满88元免邮费；不满88元，每单收取10元运费。\n
     * (港澳台地区需满","addTime":"2018-02-01 08:00:00","updateTime":"2018-02-01 08:00:00",
     * "deleted":false},{"id":2,"question":"使用什么快递发货？",
     * "answer":"严选默认使用顺丰快递发货（个别商品使用其他快递），配送范围覆盖全国大部分地区（港澳台地区除","addTime":"2018-02-01 08:00:00",
     * "updateTime":"2018-02-01 08:00:00","deleted":false},{"id":3,"question":"如何申请退货？",
     * "answer":"1.自收到商品之日起30日内，顾客可申请无忧退货，退款将原路返还，不同的银行处理时间不同，","addTime":"2018-02-01 08:00:00",
     * "updateTime":"2018-02-01 08:00:00","deleted":false},{"id":4,"question":"如何开具发票？",
     * "answer":"1.如需开具普通发票，请在下单时选择\u201c我要开发票\u201d并填写相关信息（APP仅限2.4.0及以","addTime":"2018-02-01
     * 08:00:00","updateTime":"2018-02-01 08:00:00","deleted":false}]
     * userHasCollect : 0
     * shareImage :
     * comment : {"data":[{"addTime":"2020-02-11 05:16:00",
     * "picList":["http://localhost:8080/wx/storage/fetch/0bowbmr9eymb0hl19rhu.jpg"],
     * "adminContent":"gggg","nickname":"老池","id":1012,"avatar":"https://thirdwx.qlogo
     * .cn/mmopen/vi_32
     * /gr8UpN0WbqITryKv51ul5vGhMHNXmruaP4A8wh2cb38bARxhXno8sahicBA74AiaaroFEgJLErmhGiaL8JC8Tf7sQ
     * /132","content":"呃呃呃呃呃呃呃呃呃"},{"addTime":"2018-02-01 08:00:00","picList":["https://yanxuan
     * .nosdn.127.net/218783173f303ec6d8766810951d0790.jpg"],"adminContent":"",
     * "nickname":"user123","id":1,"avatar":"","content":"布料很厚实，触感不错，洗过之后不缩水不掉色"}],"count":97}
     * share : false
     * attribute : [{"id":870,"goodsId":1181000,"attribute":"规格","value":"组合一：AB面独立弹簧床垫
     * 进口乳胶150*200cm*1+可水洗抗菌防螨丝羽绒枕*2。\n组合二：AB面独立弹簧床垫 进口乳胶180*200cm*1+可水洗抗菌防螨丝羽绒枕*2",
     * "addTime":"2018-02-01 08:00:00","updateTime":"2018-02-01 08:00:00","deleted":false},{"id
     * ":871,"goodsId":1181000,"attribute":"重要提醒",
     * "value":"活动时间：5月8日0点-5月14日24点。\n请在以上时间段内购买，其余时间均不可享受组合装优惠。","addTime":"2018-02-01
     * 08:00:00","updateTime":"2018-02-01 08:00:00","deleted":false}]
     * brand : {"id":1001020,"name":"Ralph Lauren制造商","desc":"我们与Ralph Lauren
     * Home的制造商成功接洽，掌握先进的生产设备，传承品牌工艺和工序。追求生活品质的你，值得拥有。","picUrl":"http://yanxuan.nosdn.127
     * .net/9df78eb751eae2546bd3ee7e61c9b854.png","sortOrder":20,"floorPrice":29,
     * "addTime":"2018-02-01 08:00:00","updateTime":"2018-02-01 08:00:00","deleted":false}
     * productList : [{"id":1,"goodsId":1181000,"specifications":["1.5m床垫*1+枕头*2","浅杏粉"],
     * "price":999,"number":100,"url":"http://yanxuan.nosdn.127
     * .net/1f67b1970ee20fd572b7202da0ff705d.png","addTime":"2018-02-01 08:00:00",
     * "updateTime":"2018-02-01 08:00:00","deleted":false},{"id":2,"goodsId":1181000,
     * "specifications":["1.5m床垫*1+枕头*2","玛瑙红"],"price":1500,"number":198,
     * "url":"quality=90&thumbnail=200x200&imageView","addTime":"2018-02-01 08:00:00",
     * "updateTime":"2018-11-08 01:14:01","deleted":false},{"id":3,"goodsId":1181000,
     * "specifications":["1.5m床垫*1+枕头*2","烟白灰"],"price":1000,"number":300,"url":"http://yanxuan
     * .nosdn.127.net/36f64a7161b67e7fb8ea45be32ecfa25
     * .png?quality=90&thumbnail=200x200&imageView","addTime":"2018-02-01 08:00:00",
     * "updateTime":"2018-02-01 08:00:00","deleted":false},{"id":4,"goodsId":1181000,
     * "specifications":["1.8m床垫*1+枕头*2","浅杏粉"],"price":1001,"number":400,"url":"http://yanxuan
     * .nosdn.127.net/10022c73fa7aa75c2c0d736e96cc56d5
     * .png?quality=90&thumbnail=200x200&imageView","addTime":"2018-02-01 08:00:00",
     * "updateTime":"2018-02-01 08:00:00","deleted":false},{"id":5,"goodsId":1181000,
     * "specifications":["1.8m床垫*1+枕头*2","玛瑙红"],"price":2000,"number":2,
     * "url":"quality=90&thumbnail=200x200&imageView","addTime":"2018-02-01 08:00:00",
     * "updateTime":"2018-02-01 08:00:00","deleted":false},{"id":6,"goodsId":1181000,
     * "specifications":["1.8m床垫*1+枕头*2","烟白灰"],"price":3000,"number":0,"url":"http://yanxuan
     * .nosdn.127.net/36f64a7161b67e7fb8ea45be32ecfa25
     * .png?quality=90&thumbnail=200x200&imageView","addTime":"2018-02-01 08:00:00",
     * "updateTime":"2018-02-01 08:00:00","deleted":false}]
     * info : {"id":1181000,"goodsSn":"1181000","name":"母亲节礼物-舒适安睡组合","categoryId":1008008,
     * "brandId":1001020,"gallery":["http://yanxuan.nosdn.127
     * .net/355efbcc32981aa3b7869ca07ee47dac.jpg","http://yanxuan.nosdn.127
     * .net/43e283df216881037b70d8b34f8846d3.jpg","http://yanxuan.nosdn.127
     * .net/12e41d7e5dabaf9150a8bb45c41cf422.jpg","http://yanxuan.nosdn.127
     * .net/5c1d28e86ccb89980e6054a49571cdec.jpg"],"keywords":"","brief":"安心舒适是最好的礼物",
     * "isOnSale":true,"sortOrder":1,"picUrl":"http://yanxuan.nosdn.127
     * .net/1f67b1970ee20fd572b7202da0ff705d.png","shareUrl":"","isNew":true,"isHot":false,
     * "unit":"件","counterPrice":2618,"retailPrice":2598,"addTime":"2018-02-01 08:00:00",
     * "updateTime":"2018-02-01 08:00:00","deleted":false,"detail":""}
     */

    public int userHasCollect;
    /**
     * shareImage
     */
    public String shareImage;
    /**
     * comment
     */
    public CommentBean comment;
    /**
     * share
     */
    public boolean share;
    /**
     * brand
     */
    public BrandBean brand;
    /**
     * info
     */
    public InfoBean info;
    /**
     * specificationList
     */
    public List<SpecificationListBean> specificationList;
    /**
     * groupon
     */
    public List<?> groupon;
    /**
     * issue
     */
    public List<IssueBean> issue;
    /**
     * attribute
     */
    public List<AttributeBean> attribute;
    /**
     * productList
     */
    public List<ProductListBean> productList;

    public static class CommentBean {
        /**
         * count
         */ /**
         * data : [{"addTime":"2020-02-11 05:16:00",
         * "picList":["http://localhost:8080/wx/storage/fetch/0bowbmr9eymb0hl19rhu.jpg"],
         * "adminContent":"gggg","nickname":"老池","id":1012,"avatar":"https://thirdwx.qlogo
         * .cn/mmopen/vi_32
         * /gr8UpN0WbqITryKv51ul5vGhMHNXmruaP4A8wh2cb38bARxhXno8sahicBA74AiaaroFEgJLErmhGiaL8JC8Tf7sQ/132","content":"呃呃呃呃呃呃呃呃呃"},{"addTime":"2018-02-01 08:00:00","picList":["https://yanxuan.nosdn.127.net/218783173f303ec6d8766810951d0790.jpg"],"adminContent":"","nickname":"user123","id":1,"avatar":"","content":"布料很厚实，触感不错，洗过之后不缩水不掉色"}]
         * count : 97
         */

        public int count;
        /**
         * data
         */
        public List<DataBean> data;

        public static class DataBean {
            /**
             * addTime
             */ /**
             * addTime : 2020-02-11 05:16:00
             * picList : ["http://localhost:8080/wx/storage/fetch/0bowbmr9eymb0hl19rhu.jpg"]
             * adminContent : gggg
             * nickname : 老池
             * id : 1012
             * avatar : https://thirdwx.qlogo
             * .cn/mmopen/vi_32
             * /gr8UpN0WbqITryKv51ul5vGhMHNXmruaP4A8wh2cb38bARxhXno8sahicBA74AiaaroFEgJLErmhGiaL8JC8Tf7sQ/132
             * content : 呃呃呃呃呃呃呃呃呃
             */

            public String addTime;
            /**
             * adminContent
             */
            public String adminContent;
            /**
             * nickname
             */
            public String nickname;
            /**
             * id
             */
            public int id;
            /**
             * avatar
             */
            public String avatar;
            /**
             * content
             */
            public String content;
            /**
             * picList
             */
            public List<String> picList;
        }
    }

    public static class BrandBean {
        /**
         * id
         */ /**
         * id : 1001020
         * name : Ralph Lauren制造商
         * desc : 我们与Ralph Lauren Home的制造商成功接洽，掌握先进的生产设备，传承品牌工艺和工序。追求生活品质的你，值得拥有。
         * picUrl : http://yanxuan.nosdn.127.net/9df78eb751eae2546bd3ee7e61c9b854.png
         * sortOrder : 20
         * floorPrice : 29
         * addTime : 2018-02-01 08:00:00
         * updateTime : 2018-02-01 08:00:00
         * deleted : false
         */

        public int id;
        /**
         * name
         */
        public String name;
        /**
         * desc
         */
        public String desc;
        /**
         * picUrl
         */
        public String picUrl;
        /**
         * sortOrder
         */
        public int sortOrder;
        /**
         * floorPrice
         */
        public int floorPrice;
        /**
         * addTime
         */
        public String addTime;
        /**
         * updateTime
         */
        public String updateTime;
        /**
         * deleted
         */
        public boolean deleted;
    }

    public static class InfoBean {
        /**
         * id
         */ /**
         * id : 1181000
         * goodsSn : 1181000
         * name : 母亲节礼物-舒适安睡组合
         * categoryId : 1008008
         * brandId : 1001020
         * gallery : ["http://yanxuan.nosdn.127.net/355efbcc32981aa3b7869ca07ee47dac.jpg",
         * "http://yanxuan.nosdn.127.net/43e283df216881037b70d8b34f8846d3.jpg","http://yanxuan
         * .nosdn.127.net/12e41d7e5dabaf9150a8bb45c41cf422.jpg","http://yanxuan.nosdn.127
         * .net/5c1d28e86ccb89980e6054a49571cdec.jpg"]
         * keywords :
         * brief : 安心舒适是最好的礼物
         * isOnSale : true
         * sortOrder : 1
         * picUrl : http://yanxuan.nosdn.127.net/1f67b1970ee20fd572b7202da0ff705d.png
         * shareUrl :
         * isNew : true
         * isHot : false
         * unit : 件
         * counterPrice : 2618
         * retailPrice : 2598
         * addTime : 2018-02-01 08:00:00
         * updateTime : 2018-02-01 08:00:00
         * deleted : false
         * detail :
         * */

        public int id;
        /**
         * goodsSn
         */
        public String goodsSn;
        /**
         * name
         */
        public String name;
        /**
         * categoryId
         */
        public int categoryId;
        /**
         * brandId
         */
        public int brandId;
        /**
         * keywords
         */
        public String keywords;
        /**
         * brief
         */
        public String brief;
        /**
         * isOnSale
         */
        public boolean isOnSale;
        /**
         * sortOrder
         */
        public int sortOrder;
        /**
         * picUrl
         */
        public String picUrl;
        /**
         * shareUrl
         */
        public String shareUrl;
        /**
         * isNew
         */
        public boolean isNew;
        /**
         * isHot
         */
        public boolean isHot;
        /**
         * unit
         */
        public String unit;
        /**
         * counterPrice
         */
        public int counterPrice;
        /**
         * retailPrice
         */
        public int retailPrice;
        /**
         * addTime
         */
        public String addTime;
        /**
         * updateTime
         */
        public String updateTime;
        /**
         * deleted
         */
        public boolean deleted;
        /**
         * detail
         */
        public String detail;
        /**
         * gallery
         */
        public List<String> gallery;
    }

    public static class SpecificationListBean {
        /**
         * name
         */ /**
         * name : 规格
         * valueList : [{"id":1,"goodsId":1181000,"specification":"规格","value":"1.5m床垫*1+枕头*2","picUrl":"","addTime":"2018-02-01 08:00:00","updateTime":"2018-02-01 08:00:00","deleted":false},{"id":2,"goodsId":1181000,"specification":"规格","value":"1.8m床垫*1+枕头*2","picUrl":"","addTime":"2018-02-01 08:00:00","updateTime":"2018-02-01 08:00:00","deleted":false}]
         */

        public String name;
        /**
         * valueList
         */
        public List<ValueListBean> valueList;

        public static class ValueListBean {
            /**
             * id
             */ /**
             * id : 1
             * goodsId : 1181000
             * specification : 规格
             * value : 1.5m床垫*1+枕头*2
             * picUrl :
             * addTime : 2018-02-01 08:00:00
             * updateTime : 2018-02-01 08:00:00
             * deleted : false
             */

            public int id;
            /**
             * goodsId
             */
            public int goodsId;
            /**
             * specification
             */
            public String specification;
            /**
             * value
             */
            public String value;
            /**
             * picUrl
             */
            public String picUrl;
            /**
             * addTime
             */
            public String addTime;
            /**
             * updateTime
             */
            public String updateTime;
            /**
             * deleted
             */
            public boolean deleted;
        }
    }

    public static class IssueBean {
        /**
         * id
         */ /**
         * id : 1
         * question : 购买运费如何收取？
         * answer : 单笔订单金额（不含运费）满88元免邮费；不满88元，每单收取10元运费。
         (港澳台地区需满
         * addTime : 2018-02-01 08:00:00
         * updateTime : 2018-02-01 08:00:00
         * deleted : false
         */

        public int id;
        /**
         * question
         */
        public String question;
        /**
         * answer
         */
        public String answer;
        /**
         * addTime
         */
        public String addTime;
        /**
         * updateTime
         */
        public String updateTime;
        /**
         * deleted
         */
        public boolean deleted;
    }

    public static class AttributeBean {
        /**
         * id
         */ /**
         * id : 870
         * goodsId : 1181000
         * attribute : 规格
         * value : 组合一：AB面独立弹簧床垫 进口乳胶150*200cm*1+可水洗抗菌防螨丝羽绒枕*2。
         组合二：AB面独立弹簧床垫 进口乳胶180*200cm*1+可水洗抗菌防螨丝羽绒枕*2
         * addTime : 2018-02-01 08:00:00
         * updateTime : 2018-02-01 08:00:00
         * deleted : false
         */

        public int id;
        /**
         * goodsId
         */
        public int goodsId;
        /**
         * attribute
         */
        public String attribute;
        /**
         * value
         */
        public String value;
        /**
         * addTime
         */
        public String addTime;
        /**
         * updateTime
         */
        public String updateTime;
        /**
         * deleted
         */
        public boolean deleted;
    }

    public static class ProductListBean {
        /**
         * id
         */ /**
         * id : 1
         * goodsId : 1181000
         * specifications : ["1.5m床垫*1+枕头*2","浅杏粉"]
         * price : 999
         * number : 100
         * url : http://yanxuan.nosdn.127.net/1f67b1970ee20fd572b7202da0ff705d.png
         * addTime : 2018-02-01 08:00:00
         * updateTime : 2018-02-01 08:00:00
         * deleted : false
         */

        public int id;
        /**
         * goodsId
         */
        public int goodsId;
        /**
         * price
         */
        public int price;
        /**
         * number
         */
        public int number;
        /**
         * url
         */
        public String url;
        /**
         * addTime
         */
        public String addTime;
        /**
         * updateTime
         */
        public String updateTime;
        /**
         * deleted
         */
        public boolean deleted;
        /**
         * specifications
         */
        public List<String> specifications;
    }
}
