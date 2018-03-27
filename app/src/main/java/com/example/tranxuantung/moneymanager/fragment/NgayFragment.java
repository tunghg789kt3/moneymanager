package com.example.tranxuantung.moneymanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tranxuantung.moneymanager.R;

/**
 * Created by TranXuanTung on 22/03/2018.
 */

public class NgayFragment extends Fragment{

    public NgayFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ngay, container, false);
    }
}
