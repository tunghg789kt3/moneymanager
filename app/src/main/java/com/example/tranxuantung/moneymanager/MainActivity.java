package com.example.tranxuantung.moneymanager;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.tranxuantung.moneymanager.activity.AccountActivity;
import com.example.tranxuantung.moneymanager.activity.PeriodActivity;
import com.example.tranxuantung.moneymanager.activity.SettingActivity;
import com.example.tranxuantung.moneymanager.activity.StatisticsActivity;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        TabHost.TabSpec spec;
        Intent intent;

        spec = tabHost.newTabSpec("period");
        spec.setIndicator("Chu kì");
        intent = new Intent(this, PeriodActivity.class);
        spec.setContent(intent);
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("statistics");
        spec.setIndicator("Thống kê");
        intent = new Intent(this, StatisticsActivity.class);
        spec.setContent(intent);
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("account");
        spec.setIndicator("Tài khoản");
        intent = new Intent(this, AccountActivity.class);
        spec.setContent(intent);
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("setting");
        spec.setIndicator("Cài đặt");
        intent = new Intent(this, SettingActivity.class);
        spec.setContent(intent);
        tabHost.addTab(spec);
        setTabColor(tabHost);
        tabHost.setCurrentTab(0);
    }
    private void setTabColor(TabHost tabHost) {
        try {
            for (int i=0; i < tabHost.getTabWidget().getChildCount();i++) {
                TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title); //Unselected Tabs
                if (tv != null) {
                    tv.setTypeface(Typeface.SANS_SERIF);
                    tv.setAllCaps(false);
                    tv.setTextSize(11);
                }
//                TextView tv2 = (TextView) tabHost.getCurrentTabView().findViewById(android.R.id.title); // Selected Tab
//                if (tv2 != null) {
//                    tv2.setTypeface(Typeface.SANS_SERIF);
//                    tv2.setAllCaps(false);
//                }
            }
        } catch (ClassCastException e) {
            // A precaution, in case Google changes from a TextView on the tabs.
        }
    }

}
