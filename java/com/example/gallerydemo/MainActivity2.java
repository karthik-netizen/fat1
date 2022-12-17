package com.example.gallerydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
Button b1;
TextView t1;
ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b1=findViewById(R.id.button2);
        t1=findViewById(R.id.textView2);
        img=findViewById(R.id.imageView);
        Intent i=getIntent();
        b1.setText("buy");
        t1.setText(i.getStringExtra("desc").toString());
        img.setImageResource(i.getIntExtra("image",0));

    }
}