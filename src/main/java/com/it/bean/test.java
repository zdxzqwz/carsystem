package com.it.bean;

import java.util.List;

import com.it.dao.CheckDao;


public class test {
//	public static void main(String[] args) {
//		   CommentDao dao=new CommentDao();
//		   List<Object[]> listU= dao.queryAllcomment();
//		   for (int i = 0; i < listU.size(); i++) {
//			for (int j = 0; j < listU.get(i).length; j++) {
//				System.out.print( listU.get(i)[j]+"\t");
//
//			}
//			System.out.println();
//		}
//	}
	public static void main(String[] args) {
		CheckDao dao=new CheckDao();
		User_Check ck = new User_Check();
		List<User_Check> list=dao.queryAll(ck);
		for (User_Check user_Check : list) {
			System.out.println(user_Check.getCk_user_id());
		}
	}
   
}
