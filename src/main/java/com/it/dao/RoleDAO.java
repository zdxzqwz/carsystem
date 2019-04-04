package com.it.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import com.it.bean.Role;
import com.it.utils.JDBCUtils;

/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: RoleDAO.java
* @Description: 角色表的dao层
*
* @version: v1.0.0
* @author: Only soul
* @date: 2019年3月22日 下午4:28:42 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年3月22日     Only soul           v1.0.0               修改原因
 */
public class RoleDAO {
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	public boolean addRole(Role role, String authId) {
		String sql = "INSERT INTO `carsystem`.`role`(`roleName`,`roleInfo`) VALUES ('"+role.getRoleName()+"','"+role.getRoleInfo()+"');";
		System.out.println("添加角色sql---->"+sql);
		try {
			if(qr.update(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加角色失败");
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

	
	public boolean delRole(Role role) {
		String sql = "DELETE FROM role WHERE roleId in ("+role.getRoleId()+")";
		System.out.println("删除角色sql---->"+sql);
		try {
			if(qr.update(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除角色失败");
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
	* @Description: 修改角色信息
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月23日 下午5:45:31
	 */
	public boolean updRole(Role role, String authId) {
		String sql = "UPDATE `carsystem`.`role`"
				+ "SET `roleName` = '"+role.getRoleName()+"',`roleInfo` = '"+role.getRoleInfo()+"'"
				+ "WHERE `roleId` = '"+role.getRoleId()+"';";
		System.out.println("修改角色sql---->"+sql);
		try {
			if(qr.update(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("修改角色失败");
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

	
	public Role findByIdRole(Role role) {
		
		return null;
	}

	
	public List<Role> queryAllRole(Role role) {
		String sql = "select * from role ";
		System.out.println("带分页和模糊查询的查询所有sql-->"+sql);
		List<Role> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<Role>(Role.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败");
		}finally {
			//释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		return list;
	}
	/**
	 * 
	* @Description: 查询角色个数
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月23日 下午4:36:56
	 */
	public int roleCount(Role role) {
		StringBuffer sql = new StringBuffer("select count(*) as total from role ");
		Number num;
		try {
			num = (Number)qr.query(sql.toString(),new ScalarHandler<>());
		
			return num.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询数据个数失败!");
		}finally {
			//释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		//return num;
	}
}
