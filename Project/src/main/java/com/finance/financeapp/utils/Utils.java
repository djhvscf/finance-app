package com.finance.financeapp.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.ServletContext;

import com.sun.jersey.core.header.FormDataContentDisposition;


public class Utils {
	
	private static String RESOURCES_PATH = "/resources/rent-images/";
	private static String HOST_PATH = "http://localhost:8080";
	
	// save uploaded file to new location
	public static String writeToFile(InputStream uploadedInputStream,FormDataContentDisposition fileDetail,ServletContext servletContext) {
		
		String extension = getExtension(fileDetail.getFileName(),".").toLowerCase();
		String consecutiveName = ""+new Date().getTime();
		
		String uploadedFileLocation = servletContext.getRealPath("") + RESOURCES_PATH + consecutiveName + extension;
		String databaseFileName = HOST_PATH + servletContext.getContextPath() + RESOURCES_PATH + consecutiveName + extension;
		
		try {
			OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];
 
			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			
			out.flush();
			out.close();
		} catch (IOException e) {
			uploadedFileLocation = "";
			e.printStackTrace();
		}
		return databaseFileName;	 
	}
	
	private static String getExtension(String filename, String extensionSeparator) {
	    int dot = filename.lastIndexOf(extensionSeparator);
	    return "."+filename.substring(dot + 1);
	}

}
