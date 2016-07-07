package com.moliying.androidlifehelper.utils;


import android.content.Context;
import android.widget.Toast;

/**
 * 封装的自定义Toast提示信息类
 * 
 * @author 李栋才
 * 
 */
public class ToastUtil {
	public static final int TOAST_SHOW_LONG_TIME = Toast.LENGTH_LONG;
	public static final int TOAST_SHOW_SHORT_TIME = Toast.LENGTH_SHORT;
	private static Toast _sToast;

	public static void longShow(Context context, CharSequence text) {
		show(context, text, TOAST_SHOW_LONG_TIME);
	}

	public static void longShow(Context context, CharSequence text,
			int gravity, int xOffset, int yOffset) {
		show(context, text, TOAST_SHOW_LONG_TIME, gravity, xOffset, yOffset);
	}

	public static void longShow(Context context, int textResId) {
		show(context, textResId, TOAST_SHOW_LONG_TIME);
	}

	public static void longShow(Context context, int textResId, int gravity,
			int xOffset, int yOffset) {
		show(context, textResId, TOAST_SHOW_LONG_TIME, gravity, xOffset,
				yOffset);
	}

	public static void shortShow(Context context, CharSequence text) {
		show(context, text, TOAST_SHOW_SHORT_TIME);
	}

	public static void shortShow(Context context, CharSequence text,
			int gravity, int xOffset, int yOffset) {
		show(context, text, TOAST_SHOW_SHORT_TIME, gravity, xOffset, yOffset);
	}

	public static void shortShow(Context context, int textResId) {
		show(context, textResId, TOAST_SHOW_SHORT_TIME);
	}

	public static void shortShow(Context context, int textResId, int gravity,
			int xOffset, int yOffset) {
		show(context, textResId, TOAST_SHOW_SHORT_TIME, gravity, xOffset,
				yOffset);
	}

	/**
	 * 显示一个系统Toast提示信息
	 * 
	 * @param context
	 *            android上下文
	 * @param text
	 *            提示文本信息
	 * @param duration
	 *            显示时长,请使用Toast常量
	 */
	public static void show(Context context, CharSequence text, int duration) {
		try {
			if (_sToast != null) {
				_sToast.cancel();
			}
			_sToast = Toast.makeText(context, text, duration);
			_sToast.show();
		} catch (Exception e) {
		}
	}

	/**
	 * 显示一个系统Toast提示信息
	 * 
	 * @param context
	 *            android上下文
	 * @param text
	 *            提示文本信息
	 * @param duration
	 *            显示时长,请使用Toast常量
	 * @param gravity
	 *            Toast相对位置
	 * @param xOffset
	 *            Toast显示位置X坐标偏移像素值
	 * @param yOffset
	 *            Toast显示位置Y坐标偏移像素值
	 */
	public static void show(Context context, CharSequence text, int duration,
			int gravity, int xOffset, int yOffset) {
		try {
			if (context == null) {
				return;
			}
			if (_sToast != null) {
				_sToast.cancel();
			}
			_sToast = Toast.makeText(context, text, duration);
			_sToast.setGravity(gravity, xOffset, yOffset);
			_sToast.show();
		} catch (Exception e) {
		}
	}

	/**
	 * 显示一个系统Toast提示信息
	 * 
	 * @param context
	 *            android上下文
	 * @param resId
	 *            提示文本信息字符串资源ID
	 * @param duration
	 *            显示时长,请使用Toast常量
	 */
	public static void show(Context context, int resId, int duration) {
		try {
			if (context == null) {
				return;
			}
			if (_sToast != null) {
				_sToast.cancel();
			}
			_sToast = Toast.makeText(context, resId, duration);
			_sToast.show();
		} catch (Exception e) {
		}
	}

	/**
	 * 显示一个系统Toast提示信息
	 * 
	 * @param context
	 *            android上下文
	 * @param resId
	 *            提示文本信息字符串资源ID
	 * @param duration
	 *            显示时长,请使用Toast常量
	 * @param gravity
	 *            Toast相对位置
	 * @param xOffset
	 *            Toast显示位置X坐标偏移像素值
	 * @param yOffset
	 *            Toast显示位置Y坐标偏移像素值
	 */
	public static void show(Context context, int resId, int duration,
			int gravity, int xOffset, int yOffset) {
		try {
			if (context == null) {
				return;
			}
			if (_sToast != null) {
				_sToast.cancel();
			}
			_sToast = Toast.makeText(context, resId, duration);
			_sToast.setGravity(gravity, xOffset, yOffset);
			_sToast.show();
		} catch (Exception e) {
		}
	}
}
