/* 
	Description:
		ZK Essentials
	History:
		Created by dennis

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/
package com.mafurrasoft.dev.cap_04.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.mafurrasoft.dev.dao.TodoDao;
import com.mafurrasoft.dev.entity.Priority;
import com.mafurrasoft.dev.entity.Todo;
import com.mafurrasoft.dev.services.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

@Service("todoListService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TodoListServiceImpl implements TodoListService {

	@Autowired
	private TodoDao todoDao;

	private static Date dayAfter(int d){
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, d);
		return c.getTime();
	}
	
	/** synchronized is just because we use static userList in this demo to prevent concurrent access **/
	public synchronized List<Todo>getTodoList() {
		return this.todoDao.queryAll();
	}
	
	/** synchronized is just because we use static userList in this demo to prevent concurrent access **/
	public synchronized Todo getTodo(Integer id){

			Todo todoTemp = new Todo();
			todoTemp.setId(id);
			return this.todoDao.get(todoTemp);

	}
	
	/** synchronized is just because we use static userList in this demo to prevent concurrent access **/
	public synchronized Todo saveTodo(Todo todo){
		return this.todoDao.save(todo);
	}
	
	/** synchronized is just because we use static userList in this demo to prevent concurrent access **/
	public synchronized Todo updateTodo(Todo todo){
		if(todo.getId()==null){
			throw new IllegalArgumentException("cann't save a null-id todo, save it first");
		}else{
			return this.todoDao.update(todo);
		}
	}
	
	/** synchronized is just because we use static userList in this demo to prevent concurrent access **/
	public synchronized void deleteTodo(Todo todo){
		this.todoDao.delete(todo);
	}

}
