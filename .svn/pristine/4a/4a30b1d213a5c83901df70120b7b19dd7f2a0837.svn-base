package com.it.global;

import java.util.List;

import com.it.bean.Driver_Comment;
import com.it.bean.Return_Car;

/*
 * 驾驶员评议接口
 */
public interface IComment {
	// 添加评议记录
		boolean addComment(Driver_Comment comt);

		// 删除评议记录
		boolean delComment(Driver_Comment comt);

		// 修改评议记录
		boolean updComment(Driver_Comment comt);

		// 查询单个
		List<Object[]> findById(Driver_Comment comt) ;

		// 查询所有 
		
	    List<Object[]> queryAllcomment();
	    //分页和模糊查询
	    List<Object[]> find(String  name,Integer id) ;
		// 查询总记录数
		int ComtCount(Driver_Comment comt);

		// 删除多条记录
		int Driver_CommentDelete(String delIds);
		//按照外键删除
		boolean delCommentByFk(Return_Car returncar);
}
