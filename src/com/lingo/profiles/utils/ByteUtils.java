package com.lingo.profiles.utils;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ByteUtils {
	public static byte[] GetByteFromResultSet(ResultSet rs, String fieldName) {
		byte[] bytes = null;
		try {
			Blob blob = rs.getBlob(fieldName);
			int len = (int) blob.length();
			bytes = blob.getBytes(1, len);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bytes;
	}
}
