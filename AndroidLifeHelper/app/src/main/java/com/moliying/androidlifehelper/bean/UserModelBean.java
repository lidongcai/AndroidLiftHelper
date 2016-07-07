package com.moliying.androidlifehelper.bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by ldc on 2016/7/6.
 */
@Table(name = "UserModelBean")
public class UserModelBean{
    @Column(name = "id",autoGen = true)
    private int id;
    @Column(name = "username",isId = true,autoGen = false)
    private String username;
    @Column(name = "password")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
