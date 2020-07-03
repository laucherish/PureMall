package com.laucherish.puremall.mvp.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;
import com.laucherish.puremall.mvp.model.entity.IndexBean;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Author : liuyangchi.
 * Description : ImageBannerAdapter.
 * Date : 2020/7/3.
 */
public class ImageBannerAdapter extends BannerAdapter<IndexBean.BannerBean, ImageBannerAdapter.BannerViewHolder> {

    private Context context;

    public ImageBannerAdapter(Context context, List<IndexBean.BannerBean> data) {
        super(data);
        this.context = context;
    }

    //创建ViewHolder，可以用viewType这个字段来区分不同的ViewHolder
    @Override
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        //注意，必须设置为match_parent，这个是viewpager2强制要求的
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new BannerViewHolder(imageView);
    }

    @Override
    public void onBindView(BannerViewHolder holder, IndexBean.BannerBean data, int position, int size) {
        ArmsUtils.obtainAppComponentFromContext(context)
                .imageLoader()
                .loadImage(context,
                ImageConfigImpl
                        .builder()
                        .url(data.url)
                        .imageView(holder.imageView)
                        .build());
    }

    static class BannerViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public BannerViewHolder(@NonNull ImageView view) {
            super(view);
            this.imageView = view;
        }
    }
}
