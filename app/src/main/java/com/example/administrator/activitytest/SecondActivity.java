package com.example.administrator.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
//
//        String s = getIntent().getExtras().getString("test");
//        Log.e("tag",s);
        Intent intent = getIntent();//启动SecondActivity的Intent，然后调用getStringExtra方法传入值，或者是getBooleanExtra()
        String Data = intent.getExtras().getString("extra_data");
        //??????

        Log.d("SecondActivity",  Data);
    }
}
