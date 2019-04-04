package com.it.global;

import java.util.List;


import com.it.bean.PageBean;
import com.it.bean.Rp_Driver;

public interface IRp_Driver {
	// 添加出车记录
		boolean addRp_Driver(Rp_Driver rp_driver);

		// 删除出车记录
		boolean delCar(Rp_Driver rp_driver);

		// 修改出车记录
		boolean updCar(Rp_Driver rp_driver);

		// 查询单个
		Rp_Driver findByIdCar(Rp_Driver rp_driver);

		// 查询所有 分页和模糊查询
		List<Rp_Driver> queryAllCar(PageBean pageBean, Rp_Driver rp_driver);
		List<Rp_Driver> queryAllCar( Rp_Driver rp_driver);

		// 查询总记录数
		int CarCount(Rp_Driver rp_driver);

		// 删除多条记录
		int CarDelete(String delIds);
}
