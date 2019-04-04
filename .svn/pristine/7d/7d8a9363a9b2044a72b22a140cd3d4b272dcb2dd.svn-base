package com.it.dao;
/*
 * 评议表dao层
 */

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import com.it.bean.Driver_Comment;
import com.it.bean.Return_Car;
import com.it.utils.JDBCUtils;

public class CommentDao {
     QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());//获取连接池
     
     public boolean delCommentByFk(Return_Car returncar) {
    	//编写sql语句
    	 String sql="DELETE\r\n" + 
    	 		"FROM `carsystem`.`comment`\r\n" + 
    	 		"WHERE `ret_id` = ?;";
    	 //打印sql语句
    	 System.out.println("删除语句-----》"+sql);
    	 //处理参数
    	 Object prams[]= {returncar.getRet_id()};
		try {
			int row=qr.update(sql, prams);
			return row>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("删除评议记录失败！！");
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
     
     /*
      * 增加
      */
     public boolean addComment(Driver_Comment comt) {
    	 //编写sql语句
    	 String sql="INSERT INTO `carsystem`.`comment`(`ret_id`,`cmt_quality`,`cmt_performance`,`cmt_safety`,`cmt_propose`,`cmt_month`)" + 
    	 		"VALUES (?,?,?,?,?,?)";
    	 //打印sql语句
    	 System.out.println("增加语句-----》"+sql);
    	 //处理参数
    	 Object prams[]= {comt.getRet_id(),comt.getCmt_quality(),comt.getCmt_performance(),comt.getCmt_safety(),comt.getCmt_propose(),comt.getCmt_month()};
		try {
			int row=qr.update(sql, prams);
			System.out.println("row"+row);
			return row>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("添加评议记录失败！！");
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
     //删除
     public boolean delComment(Driver_Comment comt) {
    	 //编写sql语句
    	 String sql="DELETE\r\n" + 
    	 		"FROM `carsystem`.`comment`\r\n" + 
    	 		"WHERE `cmt_id` = ?;";
    	 //打印sql语句
    	 System.out.println("删除语句-----》"+sql);
    	 //处理参数
    	 Object prams[]= {comt.getCmt_id()};
		try {
			int row=qr.update(sql, prams);
			return row>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("删除评议记录失败！！");
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
     //修改评议记录
     //查询所有
     public List<Object[]> queryAllcomment(){
    	 String sql = "SELECT c.*,r.`ret_id`,d.`dri_name`,d.`dri_id`\r\n" + 
    	 		" FROM `comment` c,`return_car` r,`driver_info` d\r\n" + 
    	 		" WHERE c.`ret_id`=r.`ret_id`AND r.`dri_id`= d.`dri_id`  ";
		List<Object[]> listU=null;
		 
		try {

			listU=qr.query(sql,new ArrayListHandler());
		
			System.out.println(listU);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询数据失败");
		}finally {
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
     //查询单个
     @SuppressWarnings("deprecation")
	public List<Object[]> findById(Driver_Comment comt) {
    	 //编写sql
    	 String sql = "SELECT c.*,r.`ret_id`,d.`dri_name`,d.`dri_id`\r\n" + 
     	 		" FROM `comment` c,`return_car` r,`driver_info` d\r\n" + 
     	 		" WHERE c.`ret_id`=r.`ret_id`AND r.`dri_id`= d.`dri_id` AND c.cmt_id=? ";
    	 List<Object[]> listU=null;
    	 //打印sql
    	 System.out.println(sql);
    	 //处理参数
    	 Object prams[]= {comt.getCmt_id()};
    	 
    	 try {
			listU=qr.query(sql, prams, new ArrayListHandler());
			System.out.println("查询单个----》"+listU.get(0)[0]);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
     //修改
     public boolean updComment(Driver_Comment comt) {
    	 //sql语句
    	 String sql="UPDATE `carsystem`.`comment`" + 
    	 		"SET  `ret_id` = ?," + 
    	 		"  `cmt_quality` = ?," + 
    	 		"  `cmt_performance` =?," + 
    	 		"  `cmt_safety` = ?," + 
    	 		"  `cmt_propose` = ?," + 
    	 		"  `cmt_month` =? " + 
    	 		"WHERE `cmt_id` =?; ";
    	 //打印sql
    	 System.out.println(sql);
    	 //处理参数
    	 Object params[]= {comt.getRet_id(),comt.getCmt_quality(),comt.getCmt_performance(),comt.getCmt_safety(),comt.getCmt_propose(),comt.getCmt_month(),comt.getCmt_id()};
		try {
			int rows=qr.update(sql, params);
			return rows>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("修改数据失败");
		}finally {
			//释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
	
    	
    	 
     }
 	//模糊查询
	  public List<Object[]> find(String  name,Integer id ) {
		  //编写sql
		  String sql="SELECT c.*,r.`ret_id`,d.`dri_name`,d.`dri_id`\r\n" + 
		  		"FROM `comment` c,`return_car` r,`driver_info` d\r\n" + 
		  		"WHERE c.`ret_id`=r.`ret_id`AND r.`dri_id`= d.`dri_id` ";
		  if(!"".equals(name) && name!=null) {
				
				//拼接sql
				sql+="AND d.dri_name LIKE '%"+name+"%'  ";
				
			}
		  if(!"".equals(id) && id!=null) {
				
				//拼接sql
				sql+="AND d.dri_id LIKE '%"+id+"%'  ";
				
			}
		  System.out.println(sql);
		  List<Object[]> listU=null;
		  try {
			listU=qr.query(sql,new ArrayListHandler());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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

} 
