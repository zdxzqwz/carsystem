package com.it.global;

import java.util.List;
import com.it.bean.Files;
import com.it.bean.PageBean;

/**
 * 
* @ClassName: IFiles 
* @Description: TODO(定义了Files类的功能性接口) 
* @author lijing
* @date 2019年3月22日 上午9:21:18 
*
 */
public interface IFiles {

	// 添加一条file信息
	boolean addFiles(Files files);

	// 删除一条file信息
	boolean delFiles(Files files);

	// 修改一条file信息
	boolean updFiles(Files files);

	// 删除一条file信息
	Files findByIdFiles(Files files);
	
	//查询所有file信息
	List<Files> queryAllFiles(PageBean pageBean,Files files);
	
	// 查询总记录数
	int FileCount(Files files);

	// 删除多条记录
	int FileDelete(String delIds);

}
