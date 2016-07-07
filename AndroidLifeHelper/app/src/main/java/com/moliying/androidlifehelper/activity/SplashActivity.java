package com.moliying.androidlifehelper.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.moliying.androidlifehelper.R;
import com.moliying.androidlifehelper.base.BaseActivity;
import com.moliying.androidlifehelper.guide.ViewPagerActivity;
import com.moliying.androidlifehelper.utils.SharedXmlUtil;

public class SplashActivity extends BaseActivity {
    private final int SPLASH_START_TIME = 2000;
    private final String FIRST_RUN_APP = "firstapp";
    private SharedXmlUtil mSharedXmlUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);
        mSharedXmlUtil = new SharedXmlUtil(this);

        final boolean first = mSharedXmlUtil.read(FIRST_RUN_APP, true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (first){
                    mSharedXmlUtil.write(FIRST_RUN_APP,false);
                    startActivity(new Intent(SplashActivity.this, ViewPagerActivity.class));
                    SplashActivity.this.finish();
                }else {
                    startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                    SplashActivity.this.finish();
                }
            }
        },SPLASH_START_TIME);
    }
}
