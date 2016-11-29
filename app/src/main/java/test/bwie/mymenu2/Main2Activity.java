package test.bwie.mymenu2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //得到启动当前Activity的Intent
        Intent intent = getIntent();
        String mydata = intent.getStringExtra("mydata");
        Log.e("Activity2",mydata);

    }

    public void huichuan(View v){

        Intent intent = new Intent();
        intent.putExtra("returndata","申赵星回来");
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Intent intent = new Intent();
        intent.putExtra("returndata","I love you");
        setResult(RESULT_OK,intent);
        finish();

    }
}
