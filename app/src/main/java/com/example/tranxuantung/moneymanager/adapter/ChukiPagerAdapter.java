package com.example.tranxuantung.moneymanager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.tranxuantung.moneymanager.fragment.ChukiFragment;
import com.example.tranxuantung.moneymanager.fragment.NgayFragment;
import com.example.tranxuantung.moneymanager.fragment.ThangFragment;
import com.example.tranxuantung.moneymanager.fragment.TongFragment;

/**
 * Created by TranXuanTung on 22/03/2018.
 */

public class ChukiPagerAdapter extends FragmentStatePagerAdapter {
    public ChukiPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new ChukiFragment();
                break;
            case 1:
                fragment = new NgayFragment();
                break;
            case 2:
                fragment = new ThangFragment();
                break;
            case 3:
                fragment = new TongFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Chu Kì";
                break;
            case 1:
                title = "Ngày";
                break;
            case 2:
                title = "Tháng";
                break;
            case 3:
                title = "Tổng";
                break;
        }
        return title;
    }
}


