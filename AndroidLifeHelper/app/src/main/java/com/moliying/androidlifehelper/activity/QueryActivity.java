package com.moliying.androidlifehelper.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.moliying.androidlifehelper.R;
import com.moliying.androidlifehelper.adapter.RecyclerViewQueryAdapter;
import com.moliying.androidlifehelper.bean.AccountModelBean;
import com.moliying.androidlifehelper.consts.ConstKey;
import com.moliying.androidlifehelper.model.AccountModelDao;
import com.moliying.androidlifehelper.utils.SharedXmlUtil;

import org.xutils.ex.DbException;

import java.util.List;

public class QueryActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        String name = new SharedXmlUtil(this).read(ConstKey.LOGINUSERNAME,"");
        try {
            List<AccountModelBean> list = AccountModelDao.selectAccount(name);
            Log.i("acclist",list.size()+"");
            mRecyclerView.setAdapter(new RecyclerViewQueryAdapter(list));
        } catch (DbException e) {
            e.printStackTrace();
        }
    }
}
