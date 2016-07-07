package com.moliying.androidlifehelper.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.moliying.androidlifehelper.R;
import com.moliying.androidlifehelper.base.BaseActivity;
import com.moliying.androidlifehelper.guide.ViewPagerActivity;
import com.moliying.androidlifehelper.utils.SharedXmlUtil;

public class SpalshActivity extends BaseActivity {

    private static final String FIRST_RUN_APP = "firstapp";
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
                    startActivity(new Intent(SpalshActivity.this, ViewPagerActivity.class));
                    SpalshActivity.this.finish();
                }else {
                    startActivity(new Intent(SpalshActivity.this,LoginActivity.class));
                    SpalshActivity.this.finish();
                }
            }
        },2000);
    }
}
