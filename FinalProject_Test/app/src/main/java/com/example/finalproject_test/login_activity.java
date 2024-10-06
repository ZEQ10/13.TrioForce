package com.example.finalproject_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login_activity extends AppCompatActivity {
    TextView tvDK;
    Button btnDN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tvDK=(TextView) findViewById(R.id.formDangKy);
        btnDN=(Button) findViewById(R.id.buttonDangNhap);
        tvDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyensangDangKy = new Intent(login_activity.this, activity_signup.class);
                startActivity(chuyensangDangKy);
            }
        });
        btnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyensangManHinhChinh = new Intent(login_activity.this, MainScreen.class);
                startActivity(chuyensangManHinhChinh);
            }
        });
    }
}