package com.lingo.profiles.utils;

import java.io.UnsupportedEncodingException;

public class StringUtils {

	public StringUtils() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 字符串转码
	 * 
	 * @param context
	 *            字符串内容
	 * @param sCode
	 *            来源编码
	 * @param dCode
	 *            目标编码
	 * @return
	 */
	public static String ConvertString(String context, String sCode,
			String dCode) {
		try {
			return new String(context.getBytes(sCode), dCode);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return context;
	}

	/**
	 * 字符串转码
	 * @param context 字符串内容
	 * @param dCode 目标编码
	 * @return
	 */
	public static String ConvertString(String context, String dCode) {
		try {
			return new String(context.getBytes(System
					.getProperty("file.encoding")), dCode);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return context;

	}
}