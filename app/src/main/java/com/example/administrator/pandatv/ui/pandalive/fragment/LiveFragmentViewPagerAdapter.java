package com.example.administrator.pandatv.ui.pandalive.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by li on 2017/7/30.
 */
//
public class LiveFragmentViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;
    private String[] str = {"多视角直播","边看边聊"};

    public LiveFragmentViewPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return str[position];
    }
}
