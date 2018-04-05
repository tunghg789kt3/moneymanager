package com.example.tranxuantung.moneymanager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.tranxuantung.moneymanager.fragment.ChukiFragment;
import com.example.tranxuantung.moneymanager.fragment.TuanFragment;
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
                fragment = new TuanFragment();
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
                title = "Chu ki";
                break;
            case 1:
                title = "Tuan";
                break;
            case 2:
                title = "Thang";
                break;
            case 3:
                title = "Tong";
                break;
        }
        return title;
    }
}


