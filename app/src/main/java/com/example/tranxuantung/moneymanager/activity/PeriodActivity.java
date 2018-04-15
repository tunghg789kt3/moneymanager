package com.example.tranxuantung.moneymanager.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;
import com.example.tranxuantung.moneymanager.R;
import com.example.tranxuantung.moneymanager.adapter.ChukiPagerAdapter;

public class PeriodActivity extends AppCompatActivity {
    private ViewPager pager;
    private TabLayout tabLayout;
    private FloatingActionButton addthuchi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_period);
        addControl();
        addthuchi =  findViewById(R.id.floattingButton);
        addthuchi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PeriodActivity.this, AddThuChiActivity.class);
                startActivity(intent);
            }
        });
    }
    private void addControl(){
        pager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        FragmentManager manager = getSupportFragmentManager();
        ChukiPagerAdapter adapter = new ChukiPagerAdapter(manager);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(adapter);
        }
}
