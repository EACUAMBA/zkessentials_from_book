package com.mafurrasoft.dev.dao;

import com.mafurrasoft.dev.entity.Todo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.zkoss.zk.ui.select.annotation.VariableResolver;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("todoDao")
public class TodoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<Todo> queryAll(){
        Query query = this.entityManager.createQuery("select t from Todo t");
        List<Todo> todoList = query.getResultList();
        return todoList;
    }

    @Transactional
    public Todo save(Todo todo){
        this.entityManager.persist(todo);
        return todo;
    }

    @Transactional
    public Todo update(Todo todo){
        return this.entityManager.merge(todo);
    }

    @Transactional
    public void delete(Todo todo){
        Todo t = this.get(todo);
        if(t != null){
            this.entityManager.remove(t);
        }

    }

    public Todo get(Todo todo){
        TypedQuery<Todo>  todoTypedQuery=  this.entityManager.createQuery("select t from Todo t where t.id = :id ", Todo.class);
        todoTypedQuery.setParameter("id", todo.getId());
        Todo t = todoTypedQuery.getSingleResult();
        return t;
    }
}
