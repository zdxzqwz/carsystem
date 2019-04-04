package com.it.utils;
/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: StringUtil.java
* @Description: 字符串处理工具类
*
* @version: v1.0.0
* @author: Only soul
* @date: 2019年3月12日 上午11:08:42 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年3月12日     Only soul           v1.0.0               修改原因
 */
public class StringUtil {

	public static boolean isEmpty(String str){
		if("".equals(str)|| str==null){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isNotEmpty(String str){
		if(!"".equals(str)&&str!=null){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean existStrArr(String str,String []strArr){
		for(int i=0;i<strArr.length;i++){
			if(strArr[i].equals(str)){
				return true;
			}
		}
		return false;
	}
}
