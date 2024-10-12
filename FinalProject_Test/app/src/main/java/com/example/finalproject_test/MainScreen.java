package com.example.finalproject_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainScreen extends AppCompatActivity {

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
        Button play = findViewById(R.id.btnChoiNgay);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent (MainScreen.this, RandomQuiz.class);
                startActivity(it);
                finish();
            }
        });
        Button TheThao = findViewById(R.id.TheThao);
        TheThao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainScreen.this, ExampleForQuizStart.class);
                startActivity(it);
                finish();
            }
        });
        Button khoaHoc = findViewById(R.id.KhoaHoc);
        khoaHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainScreen.this, ExampleQuizPlayWithTopic.class);
                startActivity(it);
                finish();
            }
        });
      Button vanHoc = findViewById(R.id.VanHoc);
      vanHoc.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent it = new Intent(MainScreen.this, ExampleQuizPlayWithTopic.class);
              startActivity(it);
              finish();
          }
      });
        Button lichSu = findViewById(R.id.LichSu);
        lichSu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainScreen.this, ExampleQuizPlayWithTopic.class);
                startActivity(it);
                finish();
            }
        });
        ImageButton btnUser = findViewById(R.id.User);
        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainScreen.this, AccountProfile.class);
                startActivity(it);
                finish();
            }
        });
    }
}