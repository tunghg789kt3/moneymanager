package com.example.tranxuantung.moneymanager.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tranxuantung.moneymanager.DoiTuong.DTTaiKhoan;
import com.example.tranxuantung.moneymanager.R;
import com.example.tranxuantung.moneymanager.adapter.CustomChuKi;
import com.example.tranxuantung.moneymanager.database.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by TranXuanTung on 22/03/2018.
 */

public class ChukiFragment extends Fragment {
    Data data;
    ArrayList<DTTaiKhoan> arrThu,arrChi;
    ListView lvThu,lvChi;
    CustomChuKi customThu,customChi;
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private Date date;
    private TextView tvTongThu,tvTongChi,tvTong;

    public ChukiFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_chuki, container, false);
        lvThu= (ListView)view.findViewById(R.id.lvThu);
        lvChi = (ListView)view.findViewById(R.id.lvChi);
        tvTongThu = (TextView)view.findViewById(R.id.tvTongThu);
        tvTongChi = (TextView)view.findViewById(R.id.tvTongChi);
        tvTong = (TextView)view.findViewById(R.id.tvTong);
        data = new Data(getContext());
        arrThu = data.getDataThu();
        arrChi = data.getDataChi();
        double tongThu= 0;
        for (int i = 0;i<arrThu.size();i++){
            double thu = arrThu.get(i).getSotien();
            tongThu +=thu;
        }
        tvTongThu.setText(String.format("%,.2f",tongThu));
        double tongChi= 0;
        for (int i = 0;i<arrChi.size();i++){
            double chi = arrChi.get(i).getSotien();
            tongChi +=chi;
        }
        tvTongChi.setText(String.format("%,.2f",tongChi));
        tvTong.setText(String.format("%,.2f",(tongThu-tongChi)));

        customThu = new CustomChuKi(getContext(),R.layout.customlistview_chuki,arrThu);
        lvThu.setAdapter(customThu);
        customChi = new CustomChuKi(getContext(),R.layout.customlistview_chuki,arrChi);
        lvChi.setAdapter(customChi);


        registerForContextMenu(lvThu);
        registerForContextMenu(lvChi);
        return view;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
            MenuInflater menuInflater = getActivity().getMenuInflater();
        if (v.getId() == R.id.lvThu) {
            menuInflater.inflate(R.menu.lv_chuky_menu, menu);
        }if(v.getId()==R.id.lvChi){
            menuInflater.inflate(R.menu.lv_chi, menu);
        }

    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo ();
        switch (item.getItemId()){
            case R.id.itemEdit:
                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.fragment_thu);
                EditText edtNgay = (EditText)dialog.findViewById(R.id.edtNgayThu);
                final EditText edtSotien = (EditText)dialog.findViewById(R.id.edtSotienThu);
                final EditText edtTaiKhoan = (EditText)dialog.findViewById(R.id.edtTaikhoanThu);
                final EditText edtDanhMuc = (EditText)dialog.findViewById(R.id.edtDanhmucThu);
                Button btnOK=(Button)dialog.findViewById(R.id.btnAddThu);
                date = new Date(arrThu.get(info.position).getDate());
                edtNgay.setText(df.format(date));
                edtSotien.setText(String.valueOf(arrThu.get(info.position).getSotien())+"đ");
                edtTaiKhoan.setText(arrThu.get(info.position).getTaikhoan());
                edtDanhMuc.setText(arrThu.get(info.position).getDanhmuc());
                btnOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DTTaiKhoan dtTaiKhoan = new DTTaiKhoan(arrThu.get(info.position).getId(),edtTaiKhoan.getText().toString(),edtDanhMuc.getText().toString(),Double.parseDouble(edtSotien.getText().toString()));
                        if(data.updateNote(dtTaiKhoan)){
                            arrThu = data.getDataThu();
                            customThu=new CustomChuKi(getContext(),R.layout.customlistview_chuki,arrThu);
                        lvThu.setAdapter(customThu);
                        dialog.dismiss();
                        }
                    }
                });

                dialog.show();
                break;
            case R.id.itemChiSua:
                final Dialog dialogSua = new Dialog(getContext());
                dialogSua.setContentView(R.layout.fragment_thu);
                EditText edtNgayChi = (EditText)dialogSua.findViewById(R.id.edtNgayThu);
                final EditText edtSotienChi = (EditText)dialogSua.findViewById(R.id.edtSotienThu);
                final EditText edtTaiKhoanChi = (EditText)dialogSua.findViewById(R.id.edtTaikhoanThu);
                final EditText edtDanhMucChi = (EditText)dialogSua.findViewById(R.id.edtDanhmucThu);
                Button btnOKChi=(Button)dialogSua.findViewById(R.id.btnAddThu);
                date = new Date(arrChi.get(info.position).getDate());
                edtNgayChi.setText(df.format(date));
                edtSotienChi.setText(String.valueOf(arrChi.get(info.position).getSotien())+"đ");
                edtTaiKhoanChi.setText(arrChi.get(info.position).getTaikhoan());
                edtDanhMucChi.setText(arrChi.get(info.position).getDanhmuc());
                btnOKChi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DTTaiKhoan dtTaiKhoan = new DTTaiKhoan(arrChi.get(info.position).getId(),edtTaiKhoanChi.getText().toString(),edtDanhMucChi.getText().toString(),Double.parseDouble(edtSotienChi.getText().toString()));
                        if(data.updateChi(dtTaiKhoan)){
                            arrChi = data.getDataChi();
                            customThu=new CustomChuKi(getContext(),R.layout.customlistview_chuki,arrChi);
                            lvChi.setAdapter(customThu);
                            double tongChi= 0;
                            for (int i = 0;i<arrChi.size();i++){
                                double chi = arrChi.get(i).getSotien();
                                tongChi +=chi;
                            }
                            tvTongChi.setText(String.format("%,.2f",tongChi));
                            tvTong.setText(String.format("%,.2f",(Double.parseDouble(tvTongThu.getText().toString().replaceAll("[,.]",""))-tongChi)));
                            dialogSua.dismiss();
                        }
                    }
                });

                dialogSua.show();
                break;
            case R.id.itemXoa:
                data.deleteNote(arrThu.get(info.position));
                arrThu.remove(arrThu.get(info.position));
                customThu.notifyDataSetChanged();
                double tongThu= 0;
                for (int i = 0;i<arrThu.size();i++){
                    double thu = arrThu.get(i).getSotien();
                    tongThu +=thu;
                }
                tvTongThu.setText(String.format("%,.2f",tongThu));
                Log.e("tong Thu: ",tongThu+"");
                String th = tvTongChi.getText().toString();
                String h = th.substring(0,th.length()-2).replaceAll("[,.]","");
                tvTong.setText(String.format("%,.2f",(tongThu-Double.parseDouble(h))));
                Log.e("df: ",h);
                break;

            case R.id.itemChiXoa:
                data.deleteChi(arrChi.get(info.position));
                arrChi.remove(arrChi.get(info.position));
                customChi.notifyDataSetChanged();
                double tongChi= 0;
                for (int i = 0;i<arrChi.size();i++){
                    double chi = arrChi.get(i).getSotien();
                    tongChi += chi;
                }
                tvTongChi.setText(String.format("%,.2f",tongChi));
                double dc = Double.parseDouble(tvTongThu.getText().toString().replace(",",""));
                tvTong.setText(String.format("%,.2f",(dc-tongChi)));
                break;
        }
        return super.onContextItemSelected(item);
    }
}
