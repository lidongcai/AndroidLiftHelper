package com.moliying.androidlifehelper.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.moliying.androidlifehelper.R;
import com.moliying.androidlifehelper.consts.ConstKey;
import com.moliying.androidlifehelper.utils.SharedXmlUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mNameEditText,mMoneyEditText;
    private Button mSaveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        initView();
    }

    private void initView() {
        mNameEditText = (EditText) findViewById(R.id.account_name);
        mMoneyEditText = (EditText) findViewById(R.id.account_money);
        mSaveButton = (Button) findViewById(R.id.save_button);
        mSaveButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String projectName = mNameEditText.getText().toString().trim();
        String money = mMoneyEditText.getText().toString().trim();
        String userName = new SharedXmlUtil(this).read(ConstKey.LOGINUSERNAME, "");

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(date);



    }
}
