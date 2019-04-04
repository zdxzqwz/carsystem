package com.it.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.it.bean.Region;
import com.it.utils.JDBCUtils;
import com.it.utils.StringUtil;

public class RegionDao {

	/**
	 * 获取连接池
	 */
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
    /**
     * 
    * @Title: addRegion 
    * @Description: TODO(添加所属大区记录) 
    * @param @param reg    设定文件 
    * @return void    返回类型 
    * @throws
     */
	public void addRegion(Region reg) {
		// 1 编写sql
		String sql = "insert into region values(?,?)";
		// 2 打印sql
		System.out.println("添加所属大区sql---->" + sql);
		// 3 处理参数
		Object params[] = { reg.getReg_id(), reg.getReg_name() };

		try {
			 qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			throw new RuntimeException("添加失败!!");
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
    * @Title: updRegion 
    * @Description: TODO(修改所属大区信息) 
    * @param @param reg    设定文件 
    * @return void    返回类型 
    * @throws
     */
	public void updRegion(Region reg) {
		// 1 编写sql
		String sql = "update  region set reg_name=? where reg_id=?";
		// 2 打印sql
		System.out.println("修改所属大区sql---->" + sql);
		// 3 处理参数
		Object params[] = { reg.getReg_name(), reg.getReg_id() };

		try {
			 qr.update(sql, params);
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
    * @Title: delRegion 
    * @Description: TODO(删除所属大区信息) 
    * @param @param reg    设定文件 
    * @return void    返回类型 
    * @throws
     */
	public void delRegion(Region reg) {
		// 1 编写sql
		String sql = "delete from region where reg_id=? ";
		// 2 打印sql
		System.out.println("删除所属大区信息sql-->" + sql);
		// 3 处理参数
		Object params[] = { reg.getReg_id() };
		try {
			 qr.update(sql, params);
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
    /**
     * 
    * @Title: queryAll 
    * @Description: TODO(查询所有大区信息) 
    * @param @param reg
    * @param @return    设定文件 
    * @return List<Region>    返回类型 
    * @throws
     */
	public List<Region> queryAll(Region reg) {
		// 1 编写sql
		StringBuffer sql = new StringBuffer("select * from region where 1=1 ");

		if (reg != null) {
			if (StringUtil.isNotEmpty(reg.getReg_id())) {
				sql.append(" and reg_id like '%" + reg.getReg_id() + "%'");
			}
			if (StringUtil.isNotEmpty(reg.getReg_name())) {
				sql.append(" and reg_id like '%" + reg.getReg_name() + "%'");
			}
		}
		// 2 打印sql
		System.out.println("查询所有所属大区信息sql---->" + sql);
		List<Region> listR = null;
		try {
			listR = qr.query(sql.toString(), new BeanListHandler<Region>(Region.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询数据失败!");
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
		// 执行
		return listR;
	}
    /**
     * 
    * @Title: findById 
    * @Description: TODO(查询单个大区信息) 
    * @param @param reg
    * @param @return    设定文件 
    * @return Region    返回类型 
    * @throws
     */
	public Region findById(Region reg) {
		// 编写sql
		String sql = "select * from region where reg_id= ? ";
		// 2 打印sql
		System.out.println("查询单个大区sql---->" + sql);
		// 3 处理参数
		Object params[] = { reg.getReg_id() };
		Region regs = null;
		try {
			regs = qr.query(sql, new BeanHandler<Region>(Region.class), params);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询单个数据失败!");
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
		return regs;
	}
}
