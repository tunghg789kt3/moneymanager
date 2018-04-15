package com.example.tranxuantung.moneymanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tranxuantung.moneymanager.DoiTuong.DTTaiKhoan;
import com.example.tranxuantung.moneymanager.R;
import com.example.tranxuantung.moneymanager.database.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by TranXuanTung on 22/03/2018.
 */

public class TuanFragment extends Fragment{
    Data data;
    ArrayList<DTTaiKhoan> arrThu,arrChi;
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private Date date;
    private TextView tvThuTuan,tvChiTuan,tvCongTuan;

    public TuanFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_tuan, container, false);
        tvThuTuan = (TextView)view.findViewById(R.id.tvThuTuan);
        tvChiTuan = (TextView)view.findViewById(R.id.tvChiTuan);
        tvCongTuan = (TextView)view.findViewById(R.id.tvCongTuan);
        data = new Data(getContext());
        arrThu = data.getDataThu();
        arrChi = data.getDataChi();

        double tongThu= 0;
        for (int i = 0;i<arrThu.size();i++){
            double thu = arrThu.get(i).getSotien();
            tongThu +=thu;
        }
        tvThuTuan.setText(String.format("%,.2f",tongThu));
        double tongChi= 0;
        for (int i = 0;i<arrChi.size();i++){
            double chi = arrChi.get(i).getSotien();
            tongChi +=chi;
        }
        tvChiTuan.setText(String.format("%,.2f",tongChi));
        tvCongTuan.setText(String.format("%,.2f",(tongThu-tongChi)));


        return view;
    }
}
