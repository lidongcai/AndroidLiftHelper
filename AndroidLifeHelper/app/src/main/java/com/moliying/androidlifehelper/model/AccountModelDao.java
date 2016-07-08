package com.moliying.androidlifehelper.model;

import com.moliying.androidlifehelper.bean.AccountModelBean;
import com.moliying.androidlifehelper.consts.ModelConster;
import com.moliying.androidlifehelper.utils.Dbutils;

import org.xutils.ex.DbException;

/**
 * Created by ldc on 2016/7/8.
 */
public class AccountModelDao {
    public static void saveAccount(AccountModelBean accountModelBean) throws DbException {
        Dbutils.getDbManager(ModelConster.PATH).save(accountModelBean);
    }
//    public static List<AccountModelBean> selectAccount(String username){
//        Dbutils.getDbManager(ModelConster.PATH).selector();
//    }
}
