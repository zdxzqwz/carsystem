package com.it.global;
/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: IReturn_Car.java
* @Description: 还车功能
*
* @version: v1.0.0
* @author: Only soul
* @date: 2019年3月15日 上午9:14:30 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年3月15日     Only soul           v1.0.0               修改原因
 */

import java.util.List;
import com.it.bean.PageBean;
import com.it.bean.Return_Car;

public interface IReturn_Car {
	//查询所有
	List<Return_Car> queryAllReturnCar(PageBean pageBean,Return_Car returncar,String datemin,String datemax);
	//添加还车纪录
	boolean addReturnCar(Return_Car returncar);
	//删除还车纪录
	boolean delReturnCar(Return_Car returncar);
	//修改还车记录
	boolean updReturnCar(Return_Car returncar);
	//查询单个
	Return_Car findById(Return_Car returncar);
	//查询总记录数
	int returnCarCount(Return_Car returncar);
	//删除多条记录
	int returnCarDelete(String delIds);
	//按驾驶员编号查询
	boolean findByDriId(String dri_id);
	//按车牌号查询
	boolean findBycarId(String car_id);
	
}
