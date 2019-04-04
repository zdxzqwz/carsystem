package com.it.global;

import java.util.List;

import com.it.bean.Out_Car;
import com.it.bean.PageBean;

/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: IOut_CarServices.java
* @Description: 出车表的功能接口
*
* @version: v1.0.0
* @author: Only soul
* @date: 2019年3月12日 上午11:18:07 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年3月12日     Only soul           v1.0.0               修改原因
 */
public interface IOut_CarServices {
	//添加出车记录
	boolean addOutCar(Out_Car out_car); 
	//删除出车记录
	boolean delOutCar(Out_Car out_car);
	//修改出车记录
	boolean updOutCar(Out_Car out_car);
	//查询单个
	Out_Car findByIdOutCar(Out_Car out_car);
	//查询所有  分页和模糊查询
	List<Out_Car> queryAllOutCar(PageBean pageBean,Out_Car out_car);
	//查询总记录数
	int outCarCount(Out_Car out_car);
	//删除多条记录
	int outCarDelete(String delIds);
	//按驾驶员编号查询
	boolean findByDriId(String dri_id);
	//按车牌号查询
	boolean findBycarId(String car_id);
}
