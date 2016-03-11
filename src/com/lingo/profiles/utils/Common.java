package com.lingo.profiles.utils;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.lingo.profiles.bean.Social;
import com.lingo.profiles.common.LingoLogger;

public class Common {
	public static String ServiceURL;
	
	public static int PageSize;
	public static String PageType;
	
	public static String EmailHost;
	public static String EmailPort;
	public static String EmailFrom;
	public static String EmailUser;
	public static String EmailPwd;
	public static String EmailAuth;
	public static String EmailTo;
	
	public static String ImagePath;
	
	public static int GalleryPageSize;
	
	public static String DefaultCharacter;
	
	static
	{
		readConfig();
	}
	
	private static void readConfig()
	{	
		InputStream in = Common.class.getClassLoader()
				.getResourceAsStream("config.properties");
		//
		Properties pro = new Properties();
		try {
			pro.load(in);
		} catch (IOException e) {
			LingoLogger.logger.error(e);
			System.out.println("读取配置文件信息发送错误，错误信息如下：");
			e.printStackTrace();
		}
		//
		ServiceURL = pro.getProperty("serviceUrl");
		
		PageSize= Integer.parseInt(pro.getProperty("pageSize","20"));
		PageType = pro.getProperty("pageType","English");
		
		EmailHost = pro.getProperty("emailHost");
		EmailPort = pro.getProperty("emailPort");
		EmailFrom = pro.getProperty("emailFrom");
		EmailUser = pro.getProperty("emailUser");
		EmailPwd = pro.getProperty("emailPwd");
		EmailAuth = pro.getProperty("emailAuth","false");
		EmailTo = pro.getProperty("emailTo");
		
		ImagePath= pro.getProperty("imagePath");
		
		GalleryPageSize= Integer.parseInt(pro.getProperty("galleryPageSize","6"));
		
		DefaultCharacter=pro.getProperty("defaultCharacter");
		//System.out.println(String.format("%1$s,%2$s,%3$s,%4$s", ServiceURL,EmailHost,EmailPort,EmailFrom));
	}
	
	
	/**
	 * get social icon
	 * @return
	 */
	public static List<Social> getSocialIcon()
	{
		List<Social> list = new ArrayList<Social>();
		InputStream in = Common.class.getClassLoader()
				.getResourceAsStream("social.xml");
		SAXReader reader = new SAXReader();
		Document document =null;
		try {
			document = reader.read(in);
		} catch (DocumentException e) {
			LingoLogger.logger.error(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Element classElement = document.getRootElement();
		List<? extends Node> nodes = document.selectNodes("/root/item");
		for(Node node : nodes)
		{
			list.add(new Social(Integer.parseInt(node.valueOf("@id")),node.valueOf("@icon"),node.valueOf("@name"), node.valueOf("@bg")));			
		}
		return list;
	}
	
	/*
	 * get string md5
	 */
	public static String getMD5(String source) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }
}
