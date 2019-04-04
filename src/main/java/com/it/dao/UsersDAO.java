package com.it.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.it.bean.Users;
import com.it.utils.JDBCUtils;

public class UsersDAO {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	/*
	 * 
	 */
	
	public Users login(Users users) {
		 //编写sql
		String sql = "SELECT u.*,r.`roleName` FROM `users` u,`role` r WHERE u.`roleId`=r.`roleId` AND u.`user_id`='"+users.getUser_id()+"' AND u.`user_pwd`='"+users.getUser_pwd()+"'";
		//2 打印sql
		 System.out.println(" 登录功能 sql-->"+sql);
		 //3 处理参数
		 //Object params[] = {users.getUser_id(),users.getUser_pwd()};
		
		 Users users1 = null;
		 try {
			users1 =  queryRunner.query(sql, new BeanHandler<Users>(Users.class));
		 } catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("登录失败!");
		}
		finally {
			//释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		return users1;

	}
	/*
	 * 增加一条用户记录
	 */
	public boolean addUsers(Users users) {
		System.out.println("users-->"+users);
		// 1 编写sql
		String sql = "insert into `carsystem`.`users`(`roleId`,`user_pwd`,`user_name`,`user_sex`,`user_addr`,`user_phone`,`create_time`,`user_inputer`) " + 
				" VALUES (?,?,?,?,?,?,?,?)";
		//打印sql
		
		//处理参数
		Object params[] = {users.getRoleId(),users.getUser_pwd(),users.getUser_name(),users.getUser_sex(),users.getUser_addr(),users.getUser_phone(),users.getCreate_time(),users.getUser_inputer()};
		System.out.println("sql--->" +sql);
		//定义标志位
		try {
			int rows = queryRunner.update(sql, params);
			return rows > 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				throw new Exception("添加失败!!");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			// 释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		return false;
		
	}
	
	
	
	
	/*
	 * 删除一条用户记录
	 * 
	 */
	
	public boolean delUsers(Users users) {
		//编写sql
		String sql = "delete from users where user_id=?";
		//打印sql
		System.out.println("用户删除记录sql-->" +sql);
		//定义标志位
		Object params[] = {users.getUser_id()};
		try {
			int rows = queryRunner.update(sql, params);
			return rows > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			throw new RuntimeException("删除失败!!");
		} finally {
			// 释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}

	}

	
	
	/*
	 * 修改一条用户记录
	 * 
	 */
	public boolean updUsers(Users users) {
		//1编写sql
		String sql = "update users set roleId=?, user_pwd=?,user_name=?,user_sex=?,user_addr=?,user_phone=?,user_inputer=? where user_id=?";
		//打印sql
		System.out.println("sql-->" + sql);
		System.out.println(users);
		//3处理参数
		Object params[] =  {users.getRoleId(),users.getUser_pwd(),users.getUser_name(),users.getUser_sex(),users.getUser_addr(),users.getUser_phone(),users.getUser_inputer(),users.getUser_id()};
		//定义标志位
		try {
			int rs = queryRunner.update(sql, params);
			return rs>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("修改失败!!");
		} finally {
			// 释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}

		
	}
	/*
	 * 查询所有信息
	 */
	public List<Users> queryAllUsers(Users users) {
		
		 //编写sql
		String sql = "SELECT u.*,r.`roleName` FROM `users` u,`role` r WHERE u.`roleId`=r.`roleId`  ";
		if(users!=null){
			//判定账户名的文本框的合法性
			// "" null判定
			if(!"".equals(users.getUser_name()) && users.getUser_name()!=null) {
				
				//拼接sql
				sql+="and user_name like '%"+users.getUser_name()+"%' ";
			}
			if(!"".equals(users.getUser_phone()) && users.getUser_phone()!=null) {
				sql+= "and user_mobile like '%"+users.getUser_phone()+ "%'";
			
			}
			
			
		}
		
		System.out.println("sql-->"+sql);
		//存放所有Users信息
		List<Users> listU = null;
		try {
			listU = queryRunner.query(sql, new BeanListHandler<>(Users.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询数据失败!");
		} 
		finally {
			//释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		return listU;
	}

		/*
		 * 查询单个
		 */
	public Users findUsersById(Users users) {
		 //编写sql
		String sql = "SELECT u.*,r.`roleName` FROM `users` u,`role` r WHERE u.`roleId`=r.`roleId` AND u.`user_id`=?";
		//2 打印sql
		 System.out.println("sql-->"+sql);
		 //3 处理参数
		 Object params[] = {users.getUser_id()};
		 
		 Users users1 = null;
		 try {
			users1 =  queryRunner.query(sql, new BeanHandler<Users>(Users.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询单个数据失败!");
		}
		finally {
			//释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		return users1;
		
	}
	/*
	 * 删除多条记录
	 */
	public int userDelete(String delIds) {
		System.out.println(delIds);
		String sql = "delete from  users where user_id in (" + delIds + ")";
		 System.out.println("sql--->"+sql);
		try {
			return queryRunner.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
}
	/*
	 * 
	 * 修改密码
	 * 
	 */
	 public boolean pwdUsers(Users users) {
		//1编写sql
			String sql = "update users set user_pwd=? where user_id=?";
			//打印sql
			System.out.println("sql-->" + sql);
			//System.out.println(users);
			//3处理参数
			Object params[] = {users.getUser_pwd(),users.getUser_id()};
			
			try {
			   int rs = queryRunner.update(sql, params);
				return rs>0;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("修改失败!!");
			} finally {
				// 释放资源到数据库连接池
				try {
					DbUtils.close(JDBCUtils.getConnections());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("关闭资源失败!");
				}
			}
		
		 
	 }
	 
	 /**
	  * 
	 * @Description: 通过角色id查看该角色下有没有用户
	 * @version: v1.0.0
	 * @author: Only soul
	 * @date: 2019年3月25日 下午7:37:18
	  */
	 public boolean existUserWithRoleId(String roleId) {
		 String sql = "select * from users where roleId=?";
			Users user=null;
			try {
				user = queryRunner.query(sql, new BeanHandler<>(Users.class), roleId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(user!=null){
				return true;
			}else{
				return false;
			}
		}
}





































