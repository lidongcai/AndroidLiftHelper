package com.moliying.androidlifehelper.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.moliying.androidlifehelper.R;

/**
 * 本地SharedPreferences数据保存读取工具类
 * 
 * @author 李栋才
 * 
 */
public class SharedXmlUtil {

	public static SharedXmlUtil mSharedXmlUtil;
	private SharedPreferences mShared;
	private Editor mEditor;

	public SharedXmlUtil(Context context, String filename) {
		mShared = context.getSharedPreferences(filename, Context.MODE_PRIVATE);
		mEditor = mShared.edit();
	}

	public SharedXmlUtil(Context context) {
		mShared = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);
		mEditor = mShared.edit();
	}

	public void write(String key, String value) {
		mEditor.putString(key, value);
		mEditor.commit();
	}

	public void write(String key, boolean value) {
		mEditor.putBoolean(key, value);
		mEditor.commit();
	}

	public void write(String key, int value) {
		mEditor.putInt(key, value);
		mEditor.commit();
	}

	public void write(String key, float value) {
		mEditor.putFloat(key, value);
		mEditor.commit();
	}

	public void write(String key, long value) {
		mEditor.putLong(key, value);
		mEditor.commit();
	}

	public String read(String key, String defValue) {
		return mShared.getString(key, defValue);
	}

	public boolean read(String key, boolean defValue) {
		return mShared.getBoolean(key, defValue);
	}

	public int read(String key, int defValue) {
		return mShared.getInt(key, defValue);
	}

	public float read(String key, float defValue) {
		return mShared.getFloat(key, defValue);
	}

	public long read(String key, long defValue) {
		return mShared.getLong(key, defValue);
	}

	public void delete(String key) {
		mEditor.remove(key);
		mEditor.commit();
	}
}
