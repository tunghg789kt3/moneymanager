package com.example.tranxuantung.moneymanager.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.tranxuantung.moneymanager.fragment.ChiFragment;

import com.example.tranxuantung.moneymanager.fragment.ChuyenKhoanFragment;

import com.example.tranxuantung.moneymanager.fragment.ThuFragment;


public class AddPageAdapter extends FragmentStatePagerAdapter {
    public AddPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new ChiFragment();
                break;
            case 1:
                fragment = new ThuFragment();
                break;
            case 2:
                fragment = new ChuyenKhoanFragment();
                break;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Chi";
                break;
            case 1:
                title = "Thu";
                break;
            case 2:
                title = "Chuyển Khoản";
                break;

        }
        return title;
    }
}
