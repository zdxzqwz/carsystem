package com.it.services;

import java.util.List;

import com.it.bean.Expense;
import com.it.dao.ExpenseDAO;
import com.it.global.IExpense;
/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: ExpenseServices.java
* @Description: 费用表的服务层
*
* @version: v1.0.0
* @author: Only soul
* @date: 2019年3月19日 下午8:59:36 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年3月19日     Only soul           v1.0.0               修改原因
 */
public class ExpenseServices implements IExpense {
	ExpenseDAO dao = new ExpenseDAO();
	@Override
	public boolean addExpense(Expense expense) {
		// TODO Auto-generated method stub
		return dao.addExpense(expense);
	}

	@Override
	public boolean delExpense(Expense expense) {
		// TODO Auto-generated method stub
		return dao.delExpense(expense);
	}

	@Override
	public boolean updExpense(Expense expense) {
		// TODO Auto-generated method stub
		return dao.updExpense(expense);
	}

	@Override
	public List<Expense> queryAllExpense(Expense expense) {
		// TODO Auto-generated method stub
		return dao.queryAllExpense(expense);
	}

	@Override
	public Expense findByIdExpense(Expense expense) {
		// TODO Auto-generated method stub
		return dao.findByIdExpense(expense);
	}

}
