package com.moliying.androidlifehelper.utils;

import org.xutils.DbManager;
import org.xutils.x;

import java.io.File;

/**
 * Created by king on 16/3/10.
 */
public class Dbutils {

    /**
     * 初始化拷贝数据库
     */
    public synchronized static DbManager getDbManager(String path) {

        File newpath = new File(path);
        if (!newpath.exists()){
            newpath.mkdirs();
        }


        DbManager.DaoConfig daoConfig = new DbManager.DaoConfig()
                .setDbName("moliying_shenghuozhushou")
//                .setDbDir(new File(path))
                .setDbVersion(1)
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
                        // TODO: ...
                        // db.addColumn(...);
                        // db.dropTable(...);
                        // ...
                        /*switch (oldVersion){
                            case 5:
                                try {
                                    db.addColumn(DbVersionBean.class,"new2");
                                } catch (DbException e) {
                                    e.printStackTrace();
                                }
                            case 6:
                                    try {
                                        db.addColumn(DbVersionBean.class,"new3");
                                    } catch (DbException e) {
                                        e.printStackTrace();
                                    }
                                break;
                        }*/
                    }
                });
        DbManager db = x.getDb(daoConfig);
        return db;
    }


    private static void updateDb(DbManager db, String tableName) {

       /* try {

            Class<EntityBase> c = (Class<EntityBase>) Class.forName( + tableName);// 把要使用的类加载到内存中,并且把有关这个类的所有信息都存放到对象c中

            if (db.tableIsExist(c)) {

                List<String> dbFildsList = new ArrayList<String>();

                String str = "select * from " + tableName;

                Cursor cursor = db.execQuery(str);

                int count = cursor.getColumnCount();

                for (int i = 0; i < count; i++) {

                    dbFildsList.add(cursor.getColumnName(i));

                }

                cursor.close();

                Field f[] = c.getDeclaredFields();// 把属性的信息提取出来，并且存放到field类的对象中，因为每个field的对象只能存放一个属性的信息所以要用数组去接收

                for (int i = 0; i < f.length; i++) {

                    String fildName = f[i].getName();

                    if (fildName.equals("serialVersionUID")) {

                        continue;

                    }

                    String fildType = f[i].getType().toString();

                    if (!isExist(dbFildsList, fildName)){

                        if (fildType.equals("class Java.lang.String")) {

                            db.execNonQuery("alter table " + tableName + " add " + fildName + " TEXT ");

                        } else if (fildType.equals("int") || fildType.equals("long") || fildType.equals("boolean")) {

                            db.execNonQuery("alter table " + tableName + " add " + fildName + " INTEGER ");

                        }

                    }

                }

            }

        } catch (Exception e) {

        }*/

    }

}
