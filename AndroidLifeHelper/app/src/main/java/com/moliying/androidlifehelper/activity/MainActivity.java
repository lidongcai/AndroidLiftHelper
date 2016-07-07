package com.moliying.androidlifehelper.activity;

import android.os.Bundle;
import android.widget.Toast;

import com.moliying.androidlifehelper.R;
import com.moliying.androidlifehelper.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    //返回键按两次退出
    private long firstTime;

    @Override
    public void onBackPressed() {
        if (firstTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            System.exit(0);
        } else {
            Toast.makeText(this,"再按一次退出程序",Toast.LENGTH_SHORT).show();

        }
        firstTime = System.currentTimeMillis();

    }
}
