package com.example.finalproject_test;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainScreen extends AppCompatActivity {
    Button btnChonTheLoai;
    ImageButton btnDiemDanh, btnThoat;
    Dialog DiemDanh_dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnChonTheLoai=(Button) findViewById(R.id.TheThao);
        btnDiemDanh=(ImageButton) findViewById(R.id.DiemDanh);

        btnChonTheLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreen.this, activity_choose_mode.class);
                startActivity(intent);
            }
        });

//        DiemDanh_dialog = new Dialog(MainScreen.this);
//        DiemDanh_dialog.setContentView(R.layout.dailycheckin_popup);
       // DiemDanh_dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//        DiemDanh_dialog.setCancelable(false);
        btnDiemDanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup();
            }
        });

    }
    private void showPopup() {
        // Tạo Dialog mới
        Dialog dialog = new Dialog(MainScreen.this, R.style.CustomDialog);

        // Đặt layout cho Dialog
        dialog.setContentView(R.layout.dailycheckin_popup);
        btnThoat=dialog.findViewById(R.id.Thoat);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        WindowManager.LayoutParams layoutParams = dialog.getWindow().getAttributes();
        layoutParams.gravity = Gravity.TOP;
        layoutParams.y = 10;
        dialog.getWindow().setAttributes(layoutParams);
        dialog.show();
    }
}