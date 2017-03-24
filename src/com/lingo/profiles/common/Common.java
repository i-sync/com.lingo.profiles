package com.lingo.profiles.common;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lingo.profiles.bean.Profile;

public class Common {

	/**
	 * get session model form request
	 * 
	 * @param request
	 * @param classType
	 * @return
	 */
	public static <T> T getModel(HttpServletRequest request, String name, Class<T> classType) {
		T t;
		ObjectMapper mapper = new ObjectMapper();
		Object obj = request.getSession().getAttribute(name);
		t = mapper.convertValue(obj, classType);
		return t;
	}

	/**
	 * get pid
	 * 
	 * @param request
	 * @return
	 */
	public static int getPid(HttpServletRequest request) {
		Profile data = getModel(request, "user", Profile.class);
		return data == null ? 0 : data.getId();
	}
	
	/**
	 * get file path by type
	 * @param type
	 * @param name
	 * @return
	 */
	public static String getFilePath(HttpServletRequest request, String type, String name)
	{
		return request.getServletContext().getRealPath(String.format("/images/%s/%s", type, name));
	}
	/**
	 * get file resource url
	 * @param request
	 * @param type
	 * @param name
	 * @return
	 * @throws MalformedURLException
	 */
	public static URL getFileUrl(HttpServletRequest request, String type, String name) throws MalformedURLException
	{		
		return request.getServletContext().getResource(String.format("/images/%s/%s", type, name));
	}
	
	/**
	 * save file to disc
	 * @param request
	 * @param file
	 * @param type
	 * @return newFileName
	 */
	public static String saveFile(HttpServletRequest request, MultipartFile file, String type)
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmssSSS");
		String fileName = file.getName();
		String newFileExt = fileName.substring(fileName.lastIndexOf("."));
		String newFileName = String.format("%s%s", df.format(new Date()), newFileExt);
		String newFilePath = getFilePath(request, type, newFileName);
		File newFile = new File(newFilePath);
		try (InputStream input = file.getInputStream()) {
		    Files.copy(input, newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LingoLogger.logger.error(e);
			return "";
		}
		LingoLogger.logger.info(String.format("save file :%s", newFilePath ));
		return newFileName;
	}
}
