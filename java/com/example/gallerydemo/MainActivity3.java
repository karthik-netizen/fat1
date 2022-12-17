package com.example.gallerydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
ImageView imageView;
TextView t1;
Button b1;
Gallery gallery;
    static final int fruits[]={R.drawable.banana,R.drawable.banana,R.drawable.banana,R.drawable.banana,R.drawable.banana};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        gallery=findViewById(R.id.gal);
        t1=findViewById(R.id.textView5);
        b1=findViewById(R.id.button5);
        Intent intent=getIntent();
        t1.setText(intent.getStringExtra("name"));
        gallery.setAdapter(new myAdapt(this));
        b1.setText("Add to cart");
    }

    private class myAdapt extends BaseAdapter {
        Context mycontext;
        public myAdapt(MainActivity3 mainActivity3) {

            mycontext=mainActivity3;
        }

        @Override
        public int getCount() {
            return fruits.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView img=new ImageView(mycontext);
            img.setImageResource(fruits[i]);
            img.setPadding(20,20,20,20);
            img.setLayoutParams(new Gallery.LayoutParams(600,600));
            img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return img;
        }
    }
}