package com.mafurrasoft.dev.cap_05.viewmodel;

import com.mafurrasoft.dev.cap_05.service.TodoListServiceImpl;
import com.mafurrasoft.dev.cap_05.viewmodel.validator.TodoValidator;
import com.mafurrasoft.dev.entity.Priority;
import com.mafurrasoft.dev.entity.Todo;
import com.mafurrasoft.dev.services.TodoListService;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.lang.Strings;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.ListModelList;

import java.util.Arrays;
import java.util.List;

public class TodoListViewModel {
    private TodoListService todoListService =new TodoListServiceImpl();
    private String subject;
    private ListModelList<Todo> todoListModelList;
    Todo selectedTodo;

    TodoValidator tv = new TodoValidator();

    public List<Priority> getPriorityList(){
        return Arrays.asList(Priority.values());
    }

    @Init //Metodo inicial, no inicio do noddo method vamos carregar as informações
    public void init(){
        List<Todo> todoList = this.todoListService.getTodoList();

        this.todoListModelList = new ListModelList<Todo>(todoList);
    }

    @Command
    @NotifyChange({"selectedTodo"})
    public void recarregar(){

    }

    @Command
    public void actualizar(){

            Todo t = this.todoListService.updateTodo(this.selectedTodo);
            this.todoListModelList.set(this.todoListModelList.indexOf(t), t);

    }

    @Command
    @NotifyChange({"selectedTodo", "subject"})
    public void addTodo(){
       if(Strings.isBlank(subject)){
           Clients.showNotification("Não há nada a fazer?");
       }else{
           Todo todo = new Todo(subject);
           todo = this.todoListService.saveTodo(todo);
           this.todoListModelList.add(todo);

           this.selectedTodo = todo;
           this.subject = null;
       }

    }

    @Command("completeTodo")
    public void completeTodo2(@BindingParam("todo") Todo todo){
        Todo todoTemp = this.todoListService.updateTodo(todo);
//        this.todoListModelList.set(this.todoListModelList.indexOf(todoTemp), todoTemp);
        if(todoTemp.equals(this.selectedTodo)){
            this.selectedTodo = todoTemp;

            BindUtils.postNotifyChange(null, null, this, "selectedTodo");
        }
    }

    @Command
//    @NotifyChange({"selectedTodo"})
    public void removeTodo(@BindingParam("todo") Todo todo){
        this.todoListService.deleteTodo(todo);
        this.todoListModelList.remove(todo);
        if(todo.equals(this.selectedTodo)){
            selectedTodo = null;
            BindUtils.postNotifyChange(null, null, this, "selectedTodo");
        }
    }

    @Command
    @NotifyChange({"selectedTodo"})
    public void fecharDetalhes(){
        this.selectedTodo = null;
        this.todoListModelList.clearSelection();
    }

    public ListModelList<Todo> getTodoListModelList(){
        return this.todoListModelList;
    }

    public Todo getSelectedTodo() {
        return selectedTodo;
    }
    public void setSelectedTodo(Todo todo) {
        this.selectedTodo = todo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Validator getTodoValidator(){
        return this.tv;
    }
}
