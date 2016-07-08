package com.moliying.androidlifehelper.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.moliying.androidlifehelper.R;
import com.moliying.androidlifehelper.base.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private final int ACCOUNTING = 0;
    private final int QUERYSTATUS = 1;
    private GridView mGridView;

    private int mImageArray[];
    private String mTextString[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGridView = (GridView) findViewById(R.id.main_home_gridview);
        mGridView.setOnItemClickListener(this);

        mImageArray = new int[]{R.mipmap.grid_payout,R.mipmap.grid_bill,R.mipmap.grid_account_book,R.mipmap.grid_category,R.mipmap.grid_report,R.mipmap.grid_user};
        mTextString = new String[]{"记账单","查询账单","读书会","存款","消费详情","个人信息"};

        //准备要添加的数据条目
        List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        for (int i = 0; i < 6; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", mImageArray[i]);//添加图像资源的ID
            item.put("textItem", mTextString[i]);//按序号添加ItemText
            items.add(item);
        }

        //实例化一个适配器
        SimpleAdapter adapter = new SimpleAdapter(this, items, R.layout.item_home_grid_view,
                new String[]{"imageItem", "textItem"},
                new int[]{R.id.item_home_grid_view_image_imageview, R.id.item_home_grid_view_text_textview});

        mGridView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position){
                case ACCOUNTING:
                    startActivity(new Intent(this,AccountActivity.class));
                    break;
                case QUERYSTATUS:
                    startActivity(new Intent(this,QueryActivity.class));
                    break;
            }
    }

    //返回键按两次退出
    private long firstTime;

    @Override
    public void onBackPressed() {
        if (firstTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            System.exit(0);
        } else {
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();

        }
        firstTime = System.currentTimeMillis();

    }
}
