package com.laucherish.puremall.mvp.ui.widget;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Author : liuyangchi.
 * Description : RecommendItemDecoration.
 * Date : 2020/7/3.
 */
public class RecommendItemDecoration extends RecyclerView.ItemDecoration {

    private int space;

    public RecommendItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view,
                               @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        if (position!=0){
            if (position % 2 == 1) {
                outRect.left = space;
                outRect.right = space;
                outRect.bottom = space;
            } else {
                outRect.right = space;
                outRect.bottom = space;
            }
        }
    }
}
