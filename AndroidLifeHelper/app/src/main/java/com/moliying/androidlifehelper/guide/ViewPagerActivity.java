package com.moliying.androidlifehelper.guide;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.moliying.androidlifehelper.R;
import com.moliying.androidlifehelper.base.BaseActivity;

public class ViewPagerActivity extends BaseActivity {
    private ViewPager mViewPager;
    //图片id的数组
    private int[] mImageIdArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        mViewPager = (ViewPager) findViewById(R.id.first_viewpager);

        mImageIdArray = new int[]{R.drawable.guide01,R.drawable.guide02,R.drawable.guide03,R.drawable.guide04,R.drawable.guide05};

    }
}
