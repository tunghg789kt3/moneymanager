package com.example.tranxuantung.moneymanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tranxuantung.moneymanager.DoiTuong.DTTaiKhoan;
import com.example.tranxuantung.moneymanager.R;
import com.example.tranxuantung.moneymanager.database.Data;

import java.text.SimpleDateFormat;

public class ThuFragment extends Fragment {
    EditText edtNgayThu, edtTaikhoanThu, edtDanhmucThu, edtSotienThu, edtDoituongThu, ghiChuThu;
    Button btnAddThu, btnErase;
    Data data;
    long ngayHT;

    public ThuFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thu, container, false);
        edtNgayThu = (EditText)view.findViewById(R.id.edtNgayThu);
        edtTaikhoanThu = (EditText)view.findViewById(R.id.edtTaikhoanThu);
        edtDanhmucThu = (EditText)view.findViewById(R.id.edtDanhmucThu);
        edtSotienThu = (EditText)view.findViewById(R.id.edtSotienThu);
        edtDoituongThu = (EditText)view.findViewById(R.id.edtDoituongThu);
        ghiChuThu = (EditText)view.findViewById(R.id.ghiChuThu);
        ngayHT = System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        edtNgayThu.setText(formatter.format(ngayHT));

        btnAddThu = (Button)view.findViewById(R.id.btnAddThu);
        btnErase = (Button)view.findViewById(R.id.btnErase);

        data = new Data(getContext());

        btnAddThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taikhoanThu = edtTaikhoanThu.getText().toString().trim();
                String danhmucThu = edtDanhmucThu.getText().toString().trim();
                double sotienThu = Double.parseDouble(edtTaikhoanThu.getText().toString().trim());
                String doituongThu = edtDoituongThu.getText().toString().trim();
                String ghichuThu = ghiChuThu.getText().toString().trim();
                DTTaiKhoan dtTaiKhoan = new DTTaiKhoan(ngayHT, taikhoanThu, danhmucThu, sotienThu, doituongThu, ghichuThu);

                if (data.saveThu(dtTaiKhoan)){
                    Toast.makeText(getContext(), "Đã lưu thành công!", Toast.LENGTH_SHORT).show();
                }else Toast.makeText(getContext(), "Lỗi!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
