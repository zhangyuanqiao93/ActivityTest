package com.example.administrator.activitytest;

import android.content.Intent;
import android.os.PersistableBundle;
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

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return","Hello FirstActivity");
        setResult(RESULT_OK,intent);//第一个参数是RESULT_OK，第二个参数是数据回传
        finish();//销毁当前活动

    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onStart() {
        super.onStart();//
    }

    @Override
    protected void onResume() {
        super.onResume();//准备好和用户交互时调用，这个活动一定出于栈顶且在活动状态；
    }

    @Override
    protected void onPause() {
        super.onPause();//准备去启动或者恢复另一个活动的时候去调用；
        // 消耗一些CPU，来保存一些关键的数据，同时在执行的时候一定要快；
    }

    @Override
    protected void onStop() {
        super.onStop();//活动完全不可见的时候调用，和onPause()的区别在于：
        // 如果启动一个新的活动是对话框的形式的话，调用onPause()而不调用onStop()
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();//在活动销毁的时候调用，之后的活动状态将变为销毁状态
    }

    @Override
    protected void onRestart() {
        super.onRestart();//活动由停止状态到活动状态转换时调用，也就是活动重新被启动。
    }
}
