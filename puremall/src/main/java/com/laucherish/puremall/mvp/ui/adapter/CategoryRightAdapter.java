package com.laucherish.puremall.mvp.ui.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jess.arms.utils.ArmsUtils;
import com.laucherish.puremall.R;
import com.laucherish.puremall.mvp.model.entity.CategoryBean;

import java.util.List;

import androidx.annotation.NonNull;

/**
 * Author : liuyangchi.
 * Description : CategoryRightAdapter.
 * Date : 2020/7/7.
 */
public class CategoryRightAdapter extends BaseMultiItemQuickAdapter<CategoryBean, BaseViewHolder> {

    public CategoryRightAdapter(List<CategoryBean> data) {
        super(data);
        addItemType(CategoryBean.ITEM, R.layout.item_right_category);
        addItemType(CategoryBean.HEADER, R.layout.header_right_category);

        setSpanSizeLookup((gridLayoutManager, position) -> {
            if (getData().get(position).getItemType() == CategoryBean.HEADER) {
                return 3;
            } else {
                return 1;
            }
        });
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, CategoryBean bean) {
        switch (bean.getItemType()) {
            case CategoryBean.HEADER:
                helper.setText(R.id.tv_header, bean.name);
                break;
            case CategoryBean.ITEM:
                helper.setText(R.id.tv_item, bean.name);
                if (!ArmsUtils.isEmpty(bean.name)) {
                    Glide.with(mContext).load(bean.picUrl).into(((ImageView) helper.getView(R.id.iv_item)));
                }
                break;
        }
    }
}
