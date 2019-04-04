package com.it.global;

import java.util.List;

import com.it.bean.Expense;

/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: IExpense.java
* @Description: 费用功能接口
*
* @version: v1.0.0
* @author: Only soul
* @date: 2019年3月19日 下午8:51:22 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年3月19日     Only soul           v1.0.0               修改原因
 */
public interface IExpense {
	//添加费用纪录
	boolean addExpense(Expense expense);
	//删除费用记录
	boolean delExpense(Expense expense);
	//修改费用记录
	boolean updExpense(Expense expense);
	//查询所有
	List<Expense> queryAllExpense(Expense expense);
	//查询单个
	Expense findByIdExpense(Expense expense);
}
