package com.it.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.it.bean.User_Check;
import com.it.utils.JDBCUtils;

public class CheckDao {
	  QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
	  public boolean addCheck(User_Check ck) {
		  //编写sql
		  String sql="INSERT INTO `carsystem`.`checked` ( `ck_user_id`, `ck_cowa`, `ck_schedule`,`ck_standard`,`ck_propose`,`ck_month`)	VALUES (?,?,?,?,?,?);";
		 //打印sql
		  System.out.println(sql);
		  //处理参数
		  Object params[]= {ck.getCk_user_id(),ck.getCk_cowa(),ck.getCk_schedule(),ck.getCk_standard(),ck.getCk_propose(),ck.getCk_month()};
		  try {
			int rows=qr.update(sql, params);
			return rows>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("添加考核失败！！");
		} finally {
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败！！");
			}
		}
	  }
//查询所有模糊查询
	  public List<User_Check>  queryAll(User_Check ck) {
		  //编写sql
		  String sql="SELECT `checked`.* ,`users`.`user_name`\r\n" + 
		  		"FROM `users`,`checked`\r\n" + 
		  		"WHERE `checked`.`ck_user_id`=`users`.`user_id`";
		 if(!"".equals(ck.getUser_name()) &&ck.getUser_name()!=null) {
		 	  sql+="AND `users`.`user_name`LIKE'%"+ck.getUser_name()+"%'";
					  }
		 if(!"".equals(ck.getCk_user_id())) {
			 sql+="AND `checked`.`ck_user_id`LIKE '%"+ck.getCk_user_id()+"%'";
		 }
		  //打印sql
		  System.out.println(sql);
		  //处理参数
		  
		  try {
			List<User_Check> uc=qr.query(sql,  new BeanListHandler<User_Check>(User_Check.class));
			System.out.println(uc);
			return uc;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询失败！！");
		}finally {
			try {
				DbUtils.close(JDBCUtils.getConnections());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败！！");
			}
		}
		
		  
	  }
	  //查询单个
	  public User_Check findById(User_Check ck) {
		  //编写sql
		  String sql= "SELECT `checked`.* ,`users`.`user_name`FROM `users`,`checked`WHERE `checked`.`ck_user_id`=`users`.`user_id`AND ck_id="+ck.getCk_id()+"";
		  //打印sql
		  System.out.println(sql);
		  try {
				User_Check uc=qr.query(sql,  new BeanHandler<User_Check>(User_Check.class));
				System.out.println(uc);
				return uc;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("查询失败！！");
			}finally {
				try {
					DbUtils.close(JDBCUtils.getConnections());
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("关闭资源失败！！");
				}
			}
		  
		
		  
	  }
	  public boolean  updCheck(User_Check ck) {
		  //编写sql
		  String sql="UPDATE `carsystem`.`checked`SET `ck_user_id` = ?,`ck_cowa` = ?,`ck_schedule` =?,`ck_standard` = ?,`ck_propose` =?,`ck_month` = ?\r\n" + 
		  		"WHERE `ck_id` = ?;";
		  //打印sql
		  System.out.println(sql);
		  //处理参数
		  Object prams[]= {ck.getCk_user_id(),ck.getCk_cowa(),ck.getCk_schedule(),ck.getCk_standard(),ck.getCk_propose(),ck.getCk_month(),ck.getCk_id()};
		  try {
			int rows =qr.update(sql, prams);
			return rows>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("修改失败！！");
		}finally {
			try {
				DbUtils.close(JDBCUtils.getConnections());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败！！");
			}
		}
		
		  
	  }
	  //删除
	  public boolean  delCheck(User_Check ck) {
		  //编写sql
		  String sql="delete  from  `carsystem`.`checked` where `ck_id` = "+ck.getCk_id()+";";
		  //打印sql
		  System.out.println(sql);
		  try {
			int rows = qr.update(sql);
			return rows>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("删除失败！！");
		}finally {
			try {
				DbUtils.close(JDBCUtils.getConnections());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败！！");
			}
		}

		  
	  }
}
