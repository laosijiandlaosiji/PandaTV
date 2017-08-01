package com.example.administrator.pandatv.ui.pandalive;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by li on 2017/7/30.
 */

public class PandaLiveViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;
    private List<String> str;

    public PandaLiveViewPagerAdapter(FragmentManager fm,List<Fragment> list,List<String> str) {
        super(fm);
        this.list = list;
        this.str = str;
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
        return str.get(position);
    }
}
