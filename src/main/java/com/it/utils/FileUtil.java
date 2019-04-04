package com.it.utils;

import java.util.UUID;
/**
 * 
* @ClassName: FileUtil 
* @Description: TODO(Files的帮助类) 
* @author lijing
* @date 2019年3月22日 上午9:27:24 
*
 */
public class FileUtil {
	/**
	 * 
	* @Title: getRealPath 
	* @Description: TODO(生成新的文件名) 
	* @param @param parent
	* @param @param filename
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String getRealPath(String parent,String filename){
		String path =parent+"\\"+UUID.randomUUID()+getExt(filename);
		return path;
	}
	/**
	 * 
	* @Title: getExt 
	* @Description: TODO(文件拓展名) 
	* @param @param filename
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String getExt(String filename){
		if(filename.lastIndexOf('.')!=-1){
			return filename.substring(filename.lastIndexOf('.'));
		}return "";
	}
}
