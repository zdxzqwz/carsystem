package com.it.services;

import java.util.List;

import com.it.bean.Driver_Comment;
import com.it.bean.Return_Car;
import com.it.dao.CommentDao;
import com.it.global.IComment;

public class Commentlmpl implements IComment {
   CommentDao dao=new CommentDao();
	@Override
	//添加
	public boolean addComment(Driver_Comment comt) {
		// TODO Auto-generated method stub
		return dao.addComment(comt);
	}

	@Override
	public boolean delComment(Driver_Comment comt) {
		// TODO Auto-generated method stub
		return dao.delComment(comt);
	}
//修改
	@Override
	public boolean updComment(Driver_Comment comt) {
		// TODO Auto-generated method stub
		return dao.updComment(comt);
	}

	

	

	@Override
	public int ComtCount(Driver_Comment comt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Driver_CommentDelete(String delIds) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Object[]> queryAllcomment() {
		// TODO Auto-generated method stub
		return dao.queryAllcomment();
	}

	@Override
	public List<Object[]> findById(Driver_Comment comt) {
		// TODO Auto-generated method stub
		return dao.findById(comt);
	}

	@Override
	public List<Object[]> find(String  name,Integer id) {
		// TODO Auto-generated method stub
		return dao.find(name, id);
	}

	@Override
	public boolean delCommentByFk(Return_Car returncar) {
		// TODO Auto-generated method stub
		return dao.delCommentByFk(returncar);
	}

}
