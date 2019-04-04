package com.it.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.it.bean.Auth;
import com.it.utils.JDBCUtils;
/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: AuthDAO.java
* @Description: 权限表的dao层
*
* @version: v1.0.0
* @author: Only soul
* @date: 2019年3月22日 下午4:14:44 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年3月22日     Only soul           v1.0.0               修改原因
 */
public class AuthDAO {
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	/**
	 * 
	* @Description: 添加权限信息
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月22日 下午4:20:31
	 */
	public boolean addAuth(Auth auth) {
		String sql = "INSERT INTO `carsystem`.`authority`(`authName`,`authPath`,`parentId`,`authDescription`,`state`,`iconCls`,`background`) " + 
				"VALUES ('"+auth.getAuthName()+"','"+auth.getAuthPath()+"','"+auth.getParentId()+"','"+auth.getAuthDescription()+"','"+auth.getState()+"','"+auth.getIconCls()+"','"+auth.getBackground()+"');";
		try {
			return qr.update(sql)>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("");
		}finally {
			//释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		
		//return false;
	}

	/**
	 * 
	* @Description: 删除权限信息
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月22日 下午4:20:47
	 */
	public boolean delAuth(Auth auth) {
		String sql = "delete from authority where authId="+auth.getAuthId();
		try {
			return qr.update(sql)>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 
	* @Description: 修改权限信息
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月22日 下午4:20:58
	 */
	public boolean updAuth(Auth auth) {
		String sql = "UPDATE `carsystem`.`authority` "
				+ "SET `authName` = '"+auth.getAuthName()+"',`authPath` = '"+auth.getAuthPath()+"',`authDescription` = '"+auth.getAuthDescription()+"',`state` = '"+auth.getState()+"',`iconCls` = '"+auth.getIconCls()+"' " + 
				"WHERE `authId` = '"+auth.getAuthId()+"';";
		try {
			return qr.update(sql)>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 
	* @Description: 按id查询单个
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月22日 下午4:21:08
	 */
	public boolean findById(Auth auth) {
		
		return false;
	}

	/**
	 * 
	* @Description: 查询所有权限信息
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月22日 下午4:21:21
	 */
	public List<Auth> queryAllAuth(Auth auth) {
		String sql = "SELECT * FROM `authority` ";
		List<Auth> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<Auth>(Auth.class));
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
	* @Description: 按登陆用户的id查找该角色对应的权限id
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月22日 下午4:21:40
	 */
	public List<Auth> queryAllByUserId(String user_id) {
		String sql = "SELECT * FROM `authority` WHERE authId IN (SELECT authId FROM `role_auth`WHERE roleId IN(SELECT roleId FROM `users`WHERE user_id='"+user_id+"'))";
		List<Auth> list = null;
		try {
			list = qr.query(sql.toString(), new BeanListHandler<Auth>(Auth.class));
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
	* @Description: 按登陆用户的角色id查找该角色对应的权限id
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月22日 下午4:21:40
	 */
	public List<Auth> queryAllByRoleId(String roleId) {
		String sql = "SELECT * FROM `authority` WHERE authId IN (SELECT authId FROM `role_auth`WHERE roleId ='"+roleId+"')";
		List<Auth> list = null;
		try {
			list = qr.query(sql.toString(), new BeanListHandler<Auth>(Auth.class));
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
	* @Description: 查询该节点下有没有子节点
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月25日 上午10:51:30
	 */
	public boolean isLeaf(Auth auth) {
		String sql = "SELECT * FROM `authority` WHERE parentId="+auth.getParentId();
		Auth auth2 = null;
		try {
			auth2 = qr.query(sql, new BeanHandler<Auth>(Auth.class));
			if(auth2!=null) {
				return true	;
			}
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
		return false;
	}
	/**
	 * 
	* @Description: 通过权限id修改state状态
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月25日 上午10:53:35
	 */
	public int updateStateByAuthId(String state, String authId) {
		String sql = "update authority set state=? where authId=?";
		Object params[] = { state, authId };
		try {
			return qr.update(sql, params);
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
		return 0;
	}
	
	public int getAuthCountByParentId(String parentId) {
		String sql = "select count(*) as total from authority where parentId="+parentId;
		Number num;
		try {
			num = (Number)qr.query(sql, new ScalarHandler<>());
			return num.intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
}
