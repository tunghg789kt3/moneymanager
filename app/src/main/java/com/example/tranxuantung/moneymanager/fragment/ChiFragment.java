package com.example.tranxuantung.moneymanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

public class ChiFragment extends Fragment {
    EditText edtNgayChi, edtTaikhoanChi, edtDanhmucChi, edtSotienChi, edtDoituongChi, edtGhichuChi;
    Button btnAddChi, btnEraseChi;
    Data data;
    long ngayHT;

    public ChiFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chi, container, false);
        edtNgayChi = (EditText) view.findViewById(R.id.edtNgayChi);
        edtTaikhoanChi = (EditText) view.findViewById(R.id.edtTaikhoanChi);
        edtDanhmucChi = (EditText) view.findViewById(R.id.edtDanhmucChi);
        edtSotienChi = (EditText) view.findViewById(R.id.edtSotienChi);
        edtDoituongChi = (EditText) view.findViewById(R.id.edtDoituongChi);
        edtGhichuChi = (EditText) view.findViewById(R.id.edtGhichuChi);
        ngayHT = System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        edtNgayChi.setText(formatter.format(ngayHT));

        btnAddChi = (Button) view.findViewById(R.id.btnAddChi);
        btnEraseChi = (Button) view.findViewById(R.id.btnEraseChi);

        data = new Data(getContext());

        btnAddChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String taikhoanChi = edtTaikhoanChi.getText().toString().trim();
                String danhmucChi = edtDanhmucChi.getText().toString().trim();
                String sotienChiText = edtSotienChi.getText().toString().trim();

                String doituongChi = edtDoituongChi.getText().toString().trim();
                String ghichuChi = edtGhichuChi.getText().toString().trim();

                if (taikhoanChi.equals("")) {
                    Toast.makeText(getContext(), "Tài khoản không được để trống!", Toast.LENGTH_SHORT).show();
                    edtTaikhoanChi.requestFocus();
                }else if (danhmucChi.equals("")){
                    Toast.makeText(getContext(), "Danh mục không được để trống!", Toast.LENGTH_SHORT).show();
                    edtDanhmucChi.requestFocus();
                }else if (sotienChiText.equals("")){
                    Toast.makeText(getContext(), "Số tiền không được để trống!", Toast.LENGTH_SHORT).show();
                    edtSotienChi.requestFocus();
                }else if (doituongChi.equals("")){
                    Toast.makeText(getContext(), "Đối tượng không được để trống!", Toast.LENGTH_SHORT).show();
                    edtDoituongChi.requestFocus();
                }else{
                    double sotienChi = Double.parseDouble(sotienChiText);
                    DTTaiKhoan dtTaiKhoan = new DTTaiKhoan(ngayHT, taikhoanChi, danhmucChi, sotienChi, doituongChi, ghichuChi);
                    if (data.saveChi(dtTaiKhoan)) {
                        Toast.makeText(getContext(), "Đã lưu thành công!", Toast.LENGTH_SHORT).show();
                    } else Toast.makeText(getContext(), "Lỗi!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnEraseChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtTaikhoanChi.setText("");
                edtDanhmucChi.setText("");
                edtSotienChi.setText("");
                edtDoituongChi.setText("");
                edtGhichuChi.setText("");
            }
        });

        return view;
    }
}
