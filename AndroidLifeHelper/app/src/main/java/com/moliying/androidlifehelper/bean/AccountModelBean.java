package com.moliying.androidlifehelper.bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by ldc on 2016/7/8.
 */
@Table(name = "AccountModelBean")
public class AccountModelBean {
    @Column(name = "id",isId = true,autoGen = true)
    private int id;
    @Column(name = "time")
    private String time;
    @Column(name = "username")
    private String username;
    @Column(name = "projectname")
    private String projectname;
    @Column(name = "money")
    private String money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
