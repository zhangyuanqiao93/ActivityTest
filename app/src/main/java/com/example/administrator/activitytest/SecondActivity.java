package com.example.administrator.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button button2 = (Button) findViewById(R.id.button2);
        //绑定Button时间,数据回传到FirstActivity
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("data_return","Hello FirstActivity");
                setResult(RESULT_OK,intent);//第一个参数是RESULT_OK，第二个参数是数据回传
                finish();//销毁当前活动
            }
        });
//
//        String s = getIntent().getExtras().getString("test");
//        Log.e("tag",s);
        Intent intent = getIntent();//启动SecondActivity的Intent，然后调用getStringExtra方法传入值，或者是getBooleanExtra()
        String Data = intent.getExtras().getString("extra_data");
        Log.d("SecondActivity",  Data);
    }
}
