package com.moliying.androidlifehelper.guide;

import android.support.v4.view.PagerAdapter;
import android.view.View;

/**
 * Created by ldc on 2016/7/6.
 */
public class MyPagerAdapter extends PagerAdapter {
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }
}
