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

public class ExampleForQuizStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_example_for_quiz_start);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
       ImageButton btnBack = findViewById(R.id.imagebtnBack);
       btnBack.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent( ExampleForQuizStart.this, MainScreen.class);
               startActivity(intent);
               finish();
           }
       });
       Button btnTiepTuc = findViewById(R.id.btnTiepTuc);
       btnTiepTuc.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent it = new Intent(ExampleForQuizStart.this, activity_example_for_quiz_end.class)   ;
               startActivity(it);
               finish();
           }
       });


    }
}