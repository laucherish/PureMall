package com.laucherish.puremall.mvp.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;
import com.laucherish.puremall.R;
import com.laucherish.puremall.mvp.model.entity.ProductBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Author : liuyangchi.
 * Description : RecommendQuickAdapter.
 * Date : 2020/7/3.
 */
public class RecommendQuickAdapter extends BaseQuickAdapter<ProductBean, BaseViewHolder> {

    public RecommendQuickAdapter(@Nullable List<ProductBean> data) {
        super(R.layout.item_product, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder holder, ProductBean bean) {
        holder.setText(R.id.tv_product_name, bean.name);
        holder.setText(R.id.tv_product_desc, bean.brief);
        holder.setText(R.id.tv_product_price, String.valueOf(bean.retailPrice));
        ArmsUtils.obtainAppComponentFromContext(mContext)
                .imageLoader()
                .loadImage(mContext,
                        ImageConfigImpl
                                .builder()
                                .url(bean.picUrl)
                                .imageView(holder.getView(R.id.iv_product))
                                .build());
    }
}
