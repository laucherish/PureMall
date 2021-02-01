package com.laucherish.puremall.mvp.ui.adapter;

import com.laucherish.puremall.app.base.BaseSupportFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @Author 张迁-zhangqian
 * @Data 2018/6/6 下午4:19
 * @Package com.zack.shop.mvp.ui.adapter
 **/
public class ItemTitlePagerAdapter extends FragmentPagerAdapter {
    private String[] titleArray;
    private List<BaseSupportFragment> fragmentList;

    public ItemTitlePagerAdapter(FragmentManager fm, List<BaseSupportFragment> fragmentList, String[] titleArray) {
        super(fm);
        this.fragmentList = fragmentList;
        this.titleArray = titleArray;
    }

    public void setFramentData(List<BaseSupportFragment> fragmentList) {
        this.fragmentList = fragmentList;
        notifyDataSetChanged();
    }

    public void setTitleData(String[] titleArray) {
        this.titleArray = titleArray;
        notifyDataSetChanged();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleArray[position];
    }

    @Override
    public int getCount() {
        return titleArray.length;
    }

    @Override
    public BaseSupportFragment getItem(int position) {
        return fragmentList.get(position);
    }
}

