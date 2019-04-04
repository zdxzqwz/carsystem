package com.it.global;

import java.util.List;
import com.it.bean.DriverInfo;
import com.it.bean.PageBean;
/**
 * 
* @ClassName: IDriverInfo 
* @Description: TODO(驾驶员档案功能接口) 
* @author lijing
* @date 2019年3月13日 下午7:36:59 
*
 */
public interface IDriverInfo {


	// 添加驾驶员记录
	boolean addDriver(DriverInfo driver);

	// 删除驾驶员记录
	boolean delDriver(DriverInfo driver);

	// 修改驾驶员记录
	boolean updDriver(DriverInfo driver);

	// 查询单个
	DriverInfo findByIdDriver(DriverInfo driver);

	// 查询所有 分页和模糊查询
	List<DriverInfo> queryAllDriver(PageBean pageBean, DriverInfo driver);
	List<DriverInfo> queryAllDriver( DriverInfo driver);

	// 查询总记录数
	int DriverCount(DriverInfo driver);

	// 删除多条记录
	int DriverDelete(String delIds);

}


