package com.example.tranxuantung.moneymanager.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.tranxuantung.moneymanager.R;
import com.example.tranxuantung.moneymanager.adapter.AddPageAdapter;
import com.example.tranxuantung.moneymanager.adapter.ChukiPagerAdapter;

public class AddThuChiActivity extends AppCompatActivity {
    private ViewPager pager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_thu_chi);
        addControl();
    }
    private void addControl(){
        pager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        FragmentManager manager = getSupportFragmentManager();
        AddPageAdapter adapter = new AddPageAdapter(manager);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(adapter);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this, "ok em yêu", Toast.LENGTH_SHORT).show();

    }
}
