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
    EditText edtNgayThu, edtTaikhoanThu, edtDanhmucThu, edtSotienThu, edtDoituongThu, edtGhichuThu;
    Button btnAddThu, btnEraseThu;
    Data data;
    long ngayHT;

    public ThuFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thu, container, false);
        edtNgayThu = (EditText) view.findViewById(R.id.edtNgayThu);
        edtTaikhoanThu = (EditText) view.findViewById(R.id.edtTaikhoanThu);
        edtDanhmucThu = (EditText) view.findViewById(R.id.edtDanhmucThu);
        edtSotienThu = (EditText) view.findViewById(R.id.edtSotienThu);
        edtDoituongThu = (EditText) view.findViewById(R.id.edtDoituongThu);
        edtGhichuThu = (EditText) view.findViewById(R.id.edtGhichuThu);
        ngayHT = System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        edtNgayThu.setText(formatter.format(ngayHT));

        btnAddThu = (Button) view.findViewById(R.id.btnAddThu);
        btnEraseThu = (Button) view.findViewById(R.id.btnEraseThu);

        data = new Data(getContext());

        btnAddThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taikhoanThu = edtTaikhoanThu.getText().toString().trim();
                String danhmucThu = edtDanhmucThu.getText().toString().trim();
                String sotienThuText = edtSotienThu.getText().toString().trim();
                String doituongThu = edtDoituongThu.getText().toString().trim();
                String ghichuThu = edtGhichuThu.getText().toString().trim();


                if (taikhoanThu.equals("")) {
                    Toast.makeText(getContext(), "Tài khoản không được để trống!", Toast.LENGTH_SHORT).show();
                    edtTaikhoanThu.requestFocus();
                }else if (danhmucThu.equals("")){
                    Toast.makeText(getContext(), "Danh mục không được để trống!", Toast.LENGTH_SHORT).show();
                    edtDanhmucThu.requestFocus();
                }else if (sotienThuText.equals("")){
                    Toast.makeText(getContext(), "Số tiền không được để trống!", Toast.LENGTH_SHORT).show();
                    edtSotienThu.requestFocus();
                }else if (doituongThu.equals("")){
                    Toast.makeText(getContext(), "Đối tượng không được để trống!", Toast.LENGTH_SHORT).show();
                    edtDoituongThu.requestFocus();
                }else{
                    double sotienThu = Double.parseDouble(sotienThuText);
                    DTTaiKhoan dtTaiKhoan = new DTTaiKhoan(ngayHT, taikhoanThu, danhmucThu, sotienThu, doituongThu, ghichuThu);
                    if (data.saveThu(dtTaiKhoan)) {
                        Toast.makeText(getContext(), "Đã lưu thành công!", Toast.LENGTH_SHORT).show();
                    } else Toast.makeText(getContext(), "Lỗi!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnEraseThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtTaikhoanThu.setText("");
                edtDanhmucThu.setText("");
                edtSotienThu.setText("");
                edtDoituongThu.setText("");
                edtGhichuThu.setText("");
            }
        });

        return view;
    }
}
