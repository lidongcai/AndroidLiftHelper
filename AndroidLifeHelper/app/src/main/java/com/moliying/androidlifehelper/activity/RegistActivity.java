package com.moliying.androidlifehelper.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.moliying.androidlifehelper.R;
import com.moliying.androidlifehelper.bean.UserModelBean;
import com.moliying.androidlifehelper.consts.ConstKey;
import com.moliying.androidlifehelper.consts.ModelConster;
import com.moliying.androidlifehelper.model.UserModelDao;
import com.moliying.androidlifehelper.utils.SharedXmlUtil;
import com.moliying.androidlifehelper.view.MyLineEditText;

import org.xutils.ex.DbException;

public class RegistActivity extends AppCompatActivity implements View.OnClickListener {
    private MyLineEditText mUsernameEditText,mPasswordEditText;
    private Button mRegistButton;
    private TextView mLoginTextView;
    private boolean isName,isPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        //加载视图控件
        initView();
    }

    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            //用户名限定2到16位
            if (mUsernameEditText.getText().toString().trim().matches("^([\\S\\s]){2,16}")){
                mUsernameEditText.setImageVisible(true);
                isName = true;
            }else {
                mUsernameEditText.setImageVisible(false);
                isName = false;
            }
            //密码限定6到16位
            if (mPasswordEditText.getText().toString().trim().matches("^([\\S\\s]){6,16}")){
                mPasswordEditText.setImageVisible(true);
                isPassword = true;
            }else {
                mPasswordEditText.setImageVisible(false);
                isPassword = false;
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void initView() {
        mUsernameEditText = (MyLineEditText) findViewById(R.id.username_regist_edittext);
        mPasswordEditText = (MyLineEditText) findViewById(R.id.password_regist_edittext);
        mRegistButton = (Button) findViewById(R.id.submit_regist_button);
        mLoginTextView = (TextView) findViewById(R.id.login_regist_textview);

        //设置控件的监听
        mRegistButton.setOnClickListener(this);
        mLoginTextView.setOnClickListener(this);
        //edittext加入观察者
        mUsernameEditText.addTextChangedListener(watcher);
        mPasswordEditText.addTextChangedListener(watcher);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.submit_regist_button:
                submitRegist();
                break;
            case R.id.login_regist_textview:
                startActivity(new Intent(RegistActivity.this,LoginActivity.class));
                finish();
                break;
            default:
                break;
        }
    }

    private void submitRegist() {
        //保存数据库用户信息
        String username = mUsernameEditText.getText().toString().trim();
        String password = mPasswordEditText.getText().toString().trim();

        if (isName && isPassword){
            //保存数据库
            UserModelBean userModelBean = new UserModelBean();
            userModelBean.setUsername(username);
            userModelBean.setPassword(password);

            Toast.makeText(this,"保存数据"+ModelConster.userPath,Toast.LENGTH_SHORT).show();

            try {
                UserModelDao.saveUser(userModelBean);
            } catch (DbException e) {
                e.printStackTrace();
            }
            new SharedXmlUtil(this).write(ConstKey.LOGINUSERNAME,username);
            startActivity(new Intent(RegistActivity.this, MainActivity.class));
            finish();
        }
    }
}
