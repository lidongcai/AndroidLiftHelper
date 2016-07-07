package com.moliying.androidlifehelper.model;

import com.moliying.androidlifehelper.bean.UserModelBean;
import com.moliying.androidlifehelper.consts.ModelConster;
import com.moliying.androidlifehelper.utils.Dbutils;

import org.xutils.ex.DbException;

/**
 * Created by ldc on 2016/7/6.
 */
public class UserModelDao {
    public static void saveUser(UserModelBean userModelBean) throws DbException {
        Dbutils.getDbManager(ModelConster.PATH).save(userModelBean);
    }

    public static UserModelBean selectUser(String username) throws DbException {
        UserModelBean user = Dbutils.getDbManager(ModelConster.PATH).findById(UserModelBean.class, username);

        if (user != null){
            return user;
        }else {
            return null;
        }

    }
}
