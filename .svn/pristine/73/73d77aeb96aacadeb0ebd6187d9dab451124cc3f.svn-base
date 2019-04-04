package com.it.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import com.it.bean.Role;
import com.it.bean.Role_Auth;
import com.it.utils.JDBCUtils;

public class Role_AuthDAO {
	
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	/**
	 * 
	* @Description: 添加角色权限
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月22日 下午5:00:47
	 */
	public boolean addRoleAuth(Role_Auth roleauth) {
		
		return false;
	}

	/**
	 * 
	* @Description: 删除角色权限
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月22日 下午5:01:08
	 */
	public boolean delRoleAuth(Role_Auth roleauth) {
		String sql = "DELETE FROM `carsystem`.`role_auth` WHERE `roleId` = '"+roleauth.getRoleId()+"'";
		System.out.println("删除角色权限sql---->"+sql);
		try {
			if(qr.update(sql.toString())>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除失败");
		}finally {
			//释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		return false;
	}

	/**
	 * 
	* @Description: 修改角色权限
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月22日 下午5:01:25
	 */
	public boolean updRoleAuth(Role_Auth roleauth) {
		if(this.delRoleAuth(roleauth)) {
			String authId[] = roleauth.getAuthId().split(",");
			//StringBuffer sql1 = new StringBuffer();
			String sql = null;
			for (int i = 0; i < authId.length; i++) {
				sql = "INSERT INTO `carsystem`.`role_auth`(`roleId`,`authId`) VALUES ('"+roleauth.getRoleId()+"','"+authId[i]+"');";
				try {
					qr.update(sql.toString());
					System.out.println("授权sql---->"+sql);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					//释放资源到数据库连接池
					try {
						DbUtils.close(JDBCUtils.getConnections());
					} catch (SQLException e) {
						e.printStackTrace();
						throw new RuntimeException("关闭资源失败!");
					}
				}
			}
			
			
		}
		
		return false;
	}

	/**
	 * 
	* @Description: 查询所有角色ID对应的权限
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月22日 下午5:01:34
	 */
	public String queryAll(Role role) {
		
		return null;
	}

	/**
	 * 
	* @Description: 查询外键
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月22日 下午5:02:06
	 */
	public boolean queryFK(String column, String id) {
		
		return false;
	}

	/**
	 * 
	* @Description: 删除外键
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月22日 下午5:02:41
	 */
	public boolean deleteFK(String column, String id) {
		
		return false;
	}
}
