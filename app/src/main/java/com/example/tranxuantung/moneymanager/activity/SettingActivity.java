package com.example.tranxuantung.moneymanager.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.tranxuantung.moneymanager.R;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout lnSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        lnSetting = findViewById(R.id.lnSetting);
        lnSetting.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.lnSetting:


                break;
        }
    }
}
