package com.moliying.androidlifehelper.guide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.moliying.androidlifehelper.R;
import com.moliying.androidlifehelper.activity.LoginActivity;
import com.moliying.androidlifehelper.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    private ViewPager mViewPager;
    //图片id的数组
    private int[] mImageIdArray;
    //图片的集合
    private List<View> mViewList;

    private ViewGroup mViewGroup;
    private ImageView mImageView;
    private ImageView[] mImageViewArray;

    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        mButton = (Button) findViewById(R.id.view_pager_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewPagerActivity.this, LoginActivity.class));
                finish();
            }
        });

        initViewpager();
        initViewPagerTag();

    }

    private void initViewPagerTag() {
        mViewGroup = (ViewGroup) findViewById(R.id.viewpager_tag_viewgroup);
        mImageViewArray = new ImageView[mViewList.size()];
        for (int i = 0;i<mViewList.size();i++){
            mImageView = new ImageView(this);
            mImageView.setLayoutParams(new ViewGroup.LayoutParams(20,20));
            mImageView.setPadding(30,0,30,0);
            mImageViewArray[i] = mImageView;
            if (i == 0){
                mImageView.setBackgroundResource(R.mipmap.viewpager_tag_on);
            }else {
                mImageView.setBackgroundResource(R.mipmap.viewpager_tag_off);
            }

            mViewGroup.addView(mImageViewArray[i]);
        }
    }

    private void initViewpager() {
        mViewPager = (ViewPager) findViewById(R.id.first_viewpager);
        mImageIdArray = new int[]{R.drawable.guide01,R.drawable.guide02,R.drawable.guide03,R.drawable.guide04,R.drawable.guide05};

        mViewList = new ArrayList<View>();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT
                ,LinearLayout.LayoutParams.MATCH_PARENT);

        //循环创建view并进入集合
        for (int i = 0;i<mImageIdArray.length;i++){
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(params);
            imageView.setBackgroundResource(mImageIdArray[i]);

            mViewList.add(imageView);
        }

        mViewPager.setAdapter(new GuidePagerAdapter(mViewList));
        mViewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        //循环设置当前页的标记图
        for (int i = 0;i<mImageViewArray.length;i++){
            mImageViewArray[position].setBackgroundResource(R.mipmap.viewpager_tag_on);
            if (position != i){
                mImageViewArray[i].setBackgroundResource(R.mipmap.viewpager_tag_off);
            }
        }
        //判断是否最后一页，是显示button
        if (position == mImageViewArray.length -1){
            mButton.setVisibility(View.VISIBLE);
        }else {
            mButton.setVisibility(View.GONE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
