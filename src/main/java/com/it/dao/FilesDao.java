package com.it.dao;
import java.io.File;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.it.bean.Files;
import com.it.bean.PageBean;
import com.it.global.IFiles;
import com.it.services.FilesImpl;
import com.it.utils.JDBCUtils;
import com.it.utils.StringUtil;
/**
 * 
* @ClassName: FilesDao 
* @Description: TODO(Files类的底层) 
* @author lijing
* @date 2019年3月22日 下午2:13:38 
*
 */
public class FilesDao {
 
	/**
	 * 获取连接池
	 */
	QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
    /**
     * 
    * @Title: addFiles 
    * @Description: TODO(添加一条Files记录) 
    * @param @param files
    * @param @return    设定文件 
    * @return boolean    返回类型 
    * @throws
     */
	public boolean addFiles(Files files) {
		// 1.编写sql
		String sql = "INSERT INTO carsystem.files (f_id,f_name,f_path) VALUES (?,?,?) ";
		// 2.打印sql
		System.out.println("----addFiles sql---->" + sql);
		// 3.处理参数
		Object[] param = { files.getF_id(), files.getF_name(), files.getF_path() };
		// 定位标识符
		try {
			int row = qr.update(sql, param);
			return row > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加Files失败！！");
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

	/**
	 * 
	* @Title: delFiles 
	* @Description: TODO(删除一条Files记录) 
	* @param @param files
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public boolean delFiles(Files files) {
		// 1.编写sql
		String sql = "DELETE FROM carsystem.files WHERE f_id = ?";
		// 2.打印sql
		System.out.println("----delFiles sql----->" + sql);
		// 3.处理参数
		Object[] param = { files.getF_id() };
		// 定位标志位
		try {
			int row = qr.update(sql, param);
			return row > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除Files失败！！");
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

	/**
	 * 
	* @Title: updFiles 
	* @Description: TODO(修改一条Files记录) 
	* @param @param files
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public boolean updFiles(Files files) {
		//1.编写sql
		String sql="update files set f_name=?,f_path=?  where f_id= ? ";
		//2.打印sql
		System.out.println("-----updFiles  sql---->"+sql);
		//3.处理参数
		Object[] param= { files.getF_name(), files.getF_path(),files.getF_id()};
		//4.定位标志位
		try {
			int row = qr.update(sql, param);
			return row>0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("修改Files失败！！");
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

	/**
	 * 
	* @Title: findByIdFiles 
	* @Description: TODO(查找一条Files记录) 
	* @param @param files
	* @param @return    设定文件 
	* @return Files    返回类型 
	* @throws
	 */
	public Files findByIdFiles(Files files) {
		//1.编写sql
		String sql="select * from files where f_id='"+files.getF_id()+"'";
		//2.打印sql
		System.out.println("-----fingByIdFiles  sql----->"+sql);
		//3.生成对象
		Files file1=null;
		try {
			file1=qr.query(sql,new BeanHandler<Files>(Files.class));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查找失败！！");
		}finally {
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败！！");
			}
		}
		return file1;
	}

	/**
	 * 
	* @Title: queryAllFiles 
	* @Description: TODO(带分页的查询所有) 
	* @param @param pageBean
	* @param @param files
	* @param @return    设定文件 
	* @return List<Files>    返回类型 
	* @throws
	 */
	public List<Files> queryAllFiles(PageBean pageBean, Files files) {
		// 1.编写sql
		StringBuffer sql = new StringBuffer("select * from files where 1=1 ");
		// "" null
		if (files != null) {
			if (StringUtil.isNotEmpty(files.getF_id())) {
				sql.append("and f_id like '%" + files.getF_id() + "%'");
			}
			if (StringUtil.isNotEmpty(files.getF_name())) {
				sql.append("and f_name like '%" + files.getF_name() + "%'");
			}
		}
		if(pageBean!=null) {
			sql.append(" limit " + pageBean.getStart() + "," + pageBean.getRows());
		}
		// 2.打印sql
		System.out.println("------queryAllFiles  sql------>" + sql.toString());
		// 3.生成存储集合 List<Files>
		List<Files> list = null;
		try {
			list = qr.query(sql.toString(), new BeanListHandler<Files>(Files.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询所有Files失败！");
		} finally {
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败！");
			}
		}
		return list;
	}
    /**
     * 
    * @Title: FileCount 
    * @Description: TODO(查询记录总数) 
    * @param @param files
    * @param @return    设定文件 
    * @return int    返回类型 
    * @throws
     */
	public int FileCount(Files files) {
		// 1.编写sql
		StringBuffer sb = new StringBuffer("select count(*) from files where 1=1 ");
		// 有条件判断条件，重新拼接sql

		Number num;
		try {
			num = (Number) qr.query(sb.toString(), new ScalarHandler<>());

			return num.intValue();
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
	}
    
	/**
	 * 
	* @Title: FileDelete 
	* @Description: TODO(删除多条记录) 
	* @param @param delIds
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	
	public int FileDelete(String delIds) {
		System.out.println(delIds);

		if (StringUtil.isNotEmpty(delIds)) {
			//对delIds进行截取 获String数组;
			String[] delList = delIds.split("','");
			// 实现文件删除
			File fileItem;
			String f_id;
			String f_path;
			Files files = new Files();
			IFiles ifile = new FilesImpl();
			Files file2 = new Files();
			// 遍历数组获取f_id
			for (int i = 0; i < delList.length; i++) {
				f_id = delList[i].toString();
				// 判断delList是否为空 null
				if (StringUtil.isNotEmpty(f_id)) {

					files.setF_id(f_id);
					System.out.println(files);
				}

				file2 = ifile.findByIdFiles(files);
				System.out.println("file2-------------->" + file2);
				if (file2 != null) {
					f_path = file2.getF_path();
					System.out.println("----f_path----->" + f_path);
					if (StringUtil.isNotEmpty(f_path)) {

						fileItem = new File(f_path);
						if (fileItem.exists()) {
							boolean flag = fileItem.delete();
							if (flag) {
								System.out.println("删除路径下文件成功！！");

							} 
						}else {
							System.out.println(f_id + "文件已被作者删除！");
							
						}
					}
				}
			}
			// 数据库删除数据
			// 1.编写sql
			String sql = "delete from  files where f_id in ('" + delIds + "')";
			// 2.执行 定位标志位
			int row;
			try {
				row = qr.update(sql);
				return row;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("删除文件失败!");
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
		return 0;

	}
}