package com.example.finalproject_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activity_signup extends AppCompatActivity {
    Button btnDK;
    TextView tvDN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnDK=(Button) findViewById(R.id.buttonDangKy);
        tvDN=(TextView) findViewById(R.id.formDangNhap);
        tvDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyensangDangNhap = new Intent(activity_signup.this, login_activity.class);
                startActivity(chuyensangDangNhap);
            }
        });
        btnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyensangManHinhChinh = new Intent(activity_signup.this, MainScreen.class);
                startActivity(chuyensangManHinhChinh);
                Toast.makeText(activity_signup.this, "Đăng nhập thành công!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}