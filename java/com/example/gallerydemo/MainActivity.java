package com.example.gallerydemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    static final String names[]={"Apple","Banana","Oranges","grapes","kiwi"};
    static final String desc[]={"Apple varieties","Banana varieties","Oranges varieties","grapes varieties","kiwi varieties"};
    static final int fruits[]={R.drawable.apple,R.drawable.banana,R.drawable.orange,R.drawable.grapes,R.drawable.kiwi};
         @Override
    protected void onCreate(Bundle savedInstanceState) {
             super.onCreate(savedInstanceState);
             setContentView(R.layout.activity_main);
             gridView=findViewById(R.id.grid);
             gridView.setNumColumns(2);
         //    gridView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,countries));

             gridView.setAdapter(new MyAdapter(this));
         }

    private class MyAdapter extends BaseAdapter {
             Context context;
        public MyAdapter(MainActivity mainActivity) {
            context=mainActivity;
        }


        @Override
        public int getCount() {
            return names.length;
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
            View view1=LayoutInflater.from(context).inflate(R.layout.layout2,viewGroup,false);
            ImageView img=view1.findViewById(R.id.imageView3);
            TextView t1=view1.findViewById(R.id.textView3);
            t1.setText(names[i]);
            Button b1=view1.findViewById(R.id.button3);
            img.setImageResource(fruits[i]);
            view1.setLayoutParams(new GridLayoutManager.LayoutParams(700,1000));
            img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view1.setPadding(20,20,20,20);

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                     Intent intent=new Intent(MainActivity.this,MainActivity3.class);
                     intent.putExtra("name",names[i]);
                     intent.putExtra("image",fruits[i]);
                     startActivity(intent);
                }
            });
            return view1;
        }
    }
}