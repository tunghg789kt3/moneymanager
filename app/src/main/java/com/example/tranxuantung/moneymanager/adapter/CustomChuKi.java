package com.example.tranxuantung.moneymanager.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.tranxuantung.moneymanager.DoiTuong.DTTaiKhoan;
import com.example.tranxuantung.moneymanager.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomChuKi extends ArrayAdapter<DTTaiKhoan> {
    Date date;
    private Context context;
    private int resource;
    private ArrayList<DTTaiKhoan> arrContact;
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public CustomChuKi(Context context, int resource, ArrayList<DTTaiKhoan> arrContact) {
        super(context, resource, arrContact);
        this.context = context;
        this.resource = resource;
        this.arrContact = arrContact;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable  View convertView, @NonNull ViewGroup parent) {
        View viewd=convertView;
        ViewHolder viewHolder;
        if(viewd==null){
            viewd = LayoutInflater.from(context).inflate(R.layout.customlistview_chuki,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.tvDate = (TextView)viewd.findViewById(R.id.tvDate);
            viewHolder.tvDanhMuc = (TextView)viewd.findViewById(R.id.tvDanhMuc);
            viewHolder.tvSotien = (TextView)viewd.findViewById(R.id.tvSotien);
            viewHolder.tvTaiKhoan = (TextView)viewd.findViewById(R.id.tvTaiKhoan);
            viewd.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)viewd.getTag();
        }
        date = new Date(arrContact.get(position).getDate());
        viewHolder.tvDate.setText(df.format(date));
        viewHolder.tvTaiKhoan.setText(String.valueOf(arrContact.get(position).getTaikhoan()));
        viewHolder.tvSotien.setText(String.format("%,.2f",arrContact.get(position).getSotien()));
        viewHolder.tvDanhMuc.setText(String.valueOf(arrContact.get(position).getDanhmuc()));

        return viewd;
    }
    public class ViewHolder {
        TextView tvDate, tvDanhMuc, tvTaiKhoan,tvSotien;

    }
}
