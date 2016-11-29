package test.bwie.mymenu2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import static test.bwie.mymenu2.R.id.bt4;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        Button bt = (Button) findViewById(R.id.bt);
        Button bt2 = (Button) findViewById(R.id.bt2);
        Button bt4 = (Button) findViewById(R.id.bt4);
        Button bt5 = (Button) findViewById(R.id.bt5);
        Button bt6 = (Button) findViewById(R.id.bt6);
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });


        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("me");
                intent.addCategory("my");
                startActivity(intent);

            }
        });
        //加传值
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "申赵星";
                Intent  intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("mydata",data);
//                startActivity(intent);
                startActivityForResult(intent,1);
            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {//通过请求码确定是哪个Activity传过来的数据
            case 1:
                if(resultCode==RESULT_OK){
                    String returndata = data.getStringExtra("returndata");
                    Log.e("ReturnData",returndata);
                }
                break;

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.mymenu,menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.add_menu:
                Toast.makeText(MainActivity.this,"呵呵",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_menu:
                Toast.makeText(MainActivity.this,"哈哈",Toast.LENGTH_SHORT).show();
                break;

        }

        return true;
    }
}
