package com.example.administrator.activitytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

        PopupMenu popMenu;
        Menu menu;
        Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);/*调用当前方法setContentView来给活动加一个布局，
        通常传入一个id，调用R.layout.first_layout可以得到first_layout.xml布局的id，
        然后将这个值传入setContentView()方法*/

        button1= (Button) findViewById(R.id.button);
//      setOnClickListener(0为按钮注册一个监听器，点击按钮就会执行onClick()方法，因此弹出方法在onClick()方法中;
        popMenu = new PopupMenu(this,findViewById(R.id.button));
        menu = popMenu.getMenu();
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main,menu);

        popMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.add_item:
                        Toast.makeText(FirstActivity.this,"You clicked Add",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.remove_item:
                        Toast.makeText(FirstActivity.this,"You clicked Remove",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                }
                return true;
            }
        });
     button1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            popMenu.show();
         }
     });






    }
}
