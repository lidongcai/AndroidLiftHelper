package com.moliying.androidlifehelper.base;
import android.app.Application;

import org.xutils.x;

/**
 * Created by ldc on 2016/7/6.
 */
public class BaseApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
