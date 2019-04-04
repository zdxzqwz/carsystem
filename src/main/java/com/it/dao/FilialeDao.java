package com.it.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.it.bean.Filiale;
import com.it.bean.Region;
import com.it.utils.JDBCUtils;
import com.it.utils.StringUtil;
/**
 * 
* @ClassName: FilialeDao 
* @Description: TODO(分公司dao) 
* @author lijing
* @date 2019年3月13日 下午11:00:40 
*
 */
public class FilialeDao {
	
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
    /**
     * 
    * @Title: addFiliale 
    * @Description: TODO(添加分公司记录) 
    * @param @param fil    设定文件 
    * @return void    返回类型 
    * @throws
     */
	public void addFiliale(Filiale fil) {
		// 1 编写sql
		String sql = "insert into filiale values(?,?,?)";
		// 2 打印sql
		System.out.println("添加分公司sql---->" + sql);
		// 3 处理参数
		Object params[] = { fil.getFil_id(), fil.getReg_id(), fil.getFil_name() };

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
    * @Title: updFiliale 
    * @Description: TODO(修改分公司记录) 
    * @param @param fil    设定文件 
    * @return void    返回类型 
    * @throws
     */
	public void updFiliale(Filiale fil) {
		// 1 编写sql
		String sql = "update  filiale set fil_name=?,reg_id=? where fil_id=?";
		// 2 打印sql
		System.out.println("修改分公司记录sql-->" + sql);
		// 3 处理参数
		Object params[] = { fil.getFil_name(), fil.getReg_id(), fil.getFil_id() };

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
	* @Title: delFiliale 
	* @Description: TODO(删除分公司记录) 
	* @param @param fil    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void delFiliale(Filiale fil) {
		//1. 编写sql
		String sql="DELETE FROM filiale WHERE fil_id = ? ;";
		//2.打印sql
		System.out.println("删除分公司记录sql----->"+sql);
		//3.处理参数
		Object[] param= {fil.getFil_id()};
		//定位标志位
		try {
		    qr.update(sql, param);
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
				throw new RuntimeException("关闭资源失败!!");
			}

		}
	}

	/**
	 * 
	* @Title: queryAll 
	* @Description: TODO(查询所有分公司记录) 
	* @param @param fil
	* @param @return    设定文件 
	* @return List<Filiale>    返回类型 
	* @throws
	 */
	public List<Filiale> queryAll(Filiale fil) {
		//1.编写sql
		StringBuffer sql=new StringBuffer("select * from filiale where 1=1 ");
		if(fil!=null) {
			if(StringUtil.isNotEmpty(fil.getFil_id())) {
				sql.append(" and fil_id like '%"+fil.getFil_id()+"%'");
			}
			if(StringUtil.isNotEmpty(fil.getFil_name())) {
				sql.append(" and fil_name like '%"+fil.getFil_name()+"%'");
			}
		}
		//2.打印sql
		System.out.println("查询分公司sql----->"+sql);
		//3.存放分公司的集合 List<Filiale>
		List<Filiale> listf=null;
		try {
			listf=qr.query(sql.toString(),new BeanListHandler<Filiale>(Filiale.class) );
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
				throw new RuntimeException("关闭资源失败!!");
			}
		}

		return listf;
	}
    /**
     * 
    * @Title: findById 
    * @Description: TODO(查找单个) 
    * @param @param fil
    * @param @return    设定文件 
    * @return Filiale    返回类型 
    * @throws
     */
	public Filiale findById(Filiale fil) {
		// 1.编写sql
		String sql = "select * from filiale where fil_id=" + fil.getFil_id() + "";
		// 2.打印sql
		System.out.println("查询分公司sql----->" + sql);
		// 3.生成对象
		Filiale fil1 = null;
		try {
			fil1 = qr.query(sql, new BeanHandler<Filiale>(Filiale.class));
		} catch (SQLException e) {
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
		return fil1;

	}
    /**
     * 
    * @Title: queryFilialesByRegionId 
    * @Description: TODO(通过大区Id 查找所属大区 的分公司记录) 
    * @param @param reg
    * @param @return    设定文件 
    * @return List<Filiale>    返回类型 
    * @throws
     */
	public List<Filiale> queryFilialesByRegionId(Region reg) {
		// 1.编写sql
		StringBuffer sql = new StringBuffer("select * from filiale where 1=1 ");
		if (reg!= null) {
             System.out.println(reg.getReg_id());
			if (StringUtil.isNotEmpty(reg.getReg_id())) {
				sql.append(" and reg_id like '%" + reg.getReg_id() + "%'");
			}
		}
		// 2.打印sql
		System.out.println("查询分公司sql----->" + sql);
		// 3.存放分公司的集合 List<Filiale>
		List<Filiale> listf = null;
		try {
			listf = qr.query(sql.toString(), new BeanListHandler<Filiale>(Filiale.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询失败！！");
		} finally {
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!!");
			}
		}

		return listf;
	}

}
