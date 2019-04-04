package com.it.services;

import java.util.List;

import com.it.bean.Files;
import com.it.bean.PageBean;
import com.it.dao.FilesDao;
import com.it.global.IFiles;

public class FilesImpl implements IFiles {

	
	FilesDao fid=new FilesDao();
	@Override
	public boolean addFiles(Files files) {
		// TODO Auto-generated method stub
		return fid.addFiles(files);
	}

	@Override
	public boolean delFiles(Files files) {
		// TODO Auto-generated method stub
		return fid.delFiles(files);
	}

	@Override
	public boolean updFiles(Files files) {
		// TODO Auto-generated method stub
		return fid.updFiles(files);
	}

	@Override
	public Files findByIdFiles(Files files) {
		// TODO Auto-generated method stub
		return fid.findByIdFiles(files);
	}

	@Override
	public List<Files> queryAllFiles(PageBean pageBean,Files files) {
		
		return fid.queryAllFiles(pageBean,files);
	}

	@Override
	public int FileCount(Files files) {
		// TODO Auto-generated method stub
		return fid.FileCount(files);
	}

	@Override
	public int FileDelete(String delIds) {
		// TODO Auto-generated method stub
		return fid.FileDelete(delIds);
	}
	

}
