package com.laucherish.puremall.mvp.ui.adapter;

import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.laucherish.puremall.R;
import com.laucherish.puremall.mvp.model.entity.CategoryBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Author : liuyangchi.
 * Description : CategoryLeftAdapter.
 * Date : 2020/7/7.
 */
public class CategoryLeftAdapter extends BaseQuickAdapter<CategoryBean, BaseViewHolder> {

    private int selectedPosition = 0;

    public CategoryLeftAdapter(@Nullable List<CategoryBean> data) {
        super(R.layout.item_left_category, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, CategoryBean bean) {
        TextView tvContent = helper.getView(R.id.tv_item);
        tvContent.setText(bean.name);
        helper.setText(R.id.tv_item, bean.name);
        if (helper.getAdapterPosition() == selectedPosition) {
            tvContent.getPaint().setFakeBoldText(true);
            helper.getView(R.id.ll_item).setBackgroundColor(mContext.getResources().getColor(R.color.normal_back_ground));
            helper.getView(R.id.iv_select).setVisibility(View.VISIBLE);
        } else {
            tvContent.getPaint().setFakeBoldText(false);
            helper.getView(R.id.ll_item).setBackgroundColor(mContext.getResources().getColor(R.color.divider_color));
            helper.getView(R.id.iv_select).setVisibility(View.GONE);
        }
    }

    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
        notifyDataSetChanged();
    }
}
