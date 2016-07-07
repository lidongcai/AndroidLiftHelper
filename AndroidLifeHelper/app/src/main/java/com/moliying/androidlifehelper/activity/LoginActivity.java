package com.moliying.androidlifehelper.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.moliying.androidlifehelper.R;
import com.moliying.androidlifehelper.base.BaseActivity;
import com.moliying.androidlifehelper.bean.UserModelBean;
import com.moliying.androidlifehelper.consts.ConstKey;
import com.moliying.androidlifehelper.model.UserModelDao;
import com.moliying.androidlifehelper.utils.SharedXmlUtil;
import com.moliying.androidlifehelper.view.MyLineEditText;

import org.xutils.ex.DbException;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private MyLineEditText mUsernameEditText,mPasswordEditText;
    private Button mLoginButton;
    private TextView mRegistTextView;
    private boolean isName,isPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
        mUsernameEditText = (MyLineEditText) findViewById(R.id.username_login_edittext);
        mPasswordEditText = (MyLineEditText) findViewById(R.id.password_login_edittext);
        mLoginButton = (Button) findViewById(R.id.submit_login_button);
        mRegistTextView = (TextView) findViewById(R.id.regist_login_textview);

        //设置控件的监听
        mLoginButton.setOnClickListener(this);
        mRegistTextView.setOnClickListener(this);
        //edittext加入观察者
        mUsernameEditText.addTextChangedListener(watcher);
        mPasswordEditText.addTextChangedListener(watcher);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.submit_login_button:
                submitLogin();
                break;
            case R.id.regist_login_textview:
                startActivity(new Intent(LoginActivity.this,RegistActivity.class));
                finish();
                break;
            default:
                break;
        }
    }

    private void submitLogin() {
        //查询数据库验证用户名和密码是否登录成功，通过跳转，否则错误提示用户
        String username = mUsernameEditText.getText().toString().trim();
        String password = mPasswordEditText.getText().toString().trim();

        if (isName && isPassword){
            //查询数据库
            UserModelBean userModelBean1 = null;
            try {
                userModelBean1 = UserModelDao.selectUser(username);
            } catch (DbException e) {
                e.printStackTrace();
            }

            if (userModelBean1 == null){
                Toast.makeText(this,"您输入的姓名或密码有误，请重新输入",Toast.LENGTH_SHORT).show();
                return;
            }
        if ((username.equals(userModelBean1.getUsername()) && (password.equals(userModelBean1.getPassword())))){
            new SharedXmlUtil(this).write(ConstKey.LOGINUSERNAME,username);
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }else {
            Toast.makeText(this,"您输入的姓名或密码有误，请重新输入",Toast.LENGTH_SHORT).show();
        }

        }


    }
}
