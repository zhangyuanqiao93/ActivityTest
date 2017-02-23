package com.example.administrator.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.gms.common.api.GoogleApiClient;


public class FirstActivity extends AppCompatActivity {

    PopupMenu popMenu;
    Menu menu;
    Button button1;
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);/*调用当前方法setContentView来给活动加一个布局，
        通常传入一个id，调用R.layout.first_layout可以得到first_layout.xml布局的id，
        然后将这个值传入setContentView()方法*/

        button1 = (Button) findViewById(R.id.button);
//        button2 = (Button) findViewById(R.id.button2);
//      setOnClickListener(0为按钮注册一个监听器，点击按钮就会执行onClick()方法，因此弹出方法在onClick()方法中;


        popMenu = new PopupMenu(this, findViewById(R.id.button));
        menu = popMenu.getMenu();
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);

        popMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.add_item:
                        Toast.makeText(FirstActivity.this, "You clicked Add", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.remove_item:
                        Toast.makeText(FirstActivity.this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                }
                return true;
            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(FirstActivity.this,"Fuck Off",Toast.LENGTH_SHORT).show();
//                finish();
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                Bundle bundle =new Bundle();
//                bundle.putString("test","android");
//                intent.putExtra("test",bundle);
//                Intent intent = new Intent("com.example.administrator.activitytest.ACTION_START");
//                intent.addCategory("com.example.administrator.activitytest.ACTION_START");
                String Data = "Hello SecondActivity";
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("extra_data",Data);
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:10086"));
                FirstActivity.this.startActivity(intent);
            }
        });

//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//              /*  popMenu.show();*/
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                Bundle bundle =new Bundle();
//                bundle.putString("test","android");
//                intent.putExtras(bundle);
////                Intent intent = new Intent(com.example.administrator.ACTION_START);
//
//                FirstActivity.this.startActivity(intent);//启动活动FirstActivity
//            }
//        });
}
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()) {
            case R.id.add_item:
                Toast.makeText(FirstActivity.this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(FirstActivity.this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
}
