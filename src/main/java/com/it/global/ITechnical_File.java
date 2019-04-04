package com.it.global;
import java.util.List;

import com.it.bean.Technical_File;
import com.it.bean.PageBean;

/**
 * 
* @ClassName: ITechnical_File 
* @Description: TODO(车辆技术档案的功能接口) 
* @author lijing
* @date 2019年3月12日 下午9:21:41 
*
 */
public interface ITechnical_File {

	//添加车辆技术档案记录
	boolean addTechFile(Technical_File tf); 
	//删除车辆技术档案记录
	boolean delTechFile(Technical_File tf);
	//修改车辆技术档案记录
	boolean updTechFile(Technical_File tf);
	//查询单个
	Technical_File findByIdTechFile(Technical_File tf);
	// 查询所有 分页和模糊查询
	List<Technical_File> queryAllTechnical_File(PageBean pageBean, Technical_File tf);
	List<Technical_File> queryAllTechnical_File( Technical_File tf);

	// 查询总记录数
	int Technical_FileCount(Technical_File tf);

	// 删除多条记录
	int Technical_FileDelete(String delIds);

	//按车牌号查询
	boolean findBycarId(String car_id);

	
	
}
