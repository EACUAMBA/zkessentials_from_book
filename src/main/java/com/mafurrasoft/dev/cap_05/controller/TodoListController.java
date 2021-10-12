package com.mafurrasoft.dev.cap_05.controller;

import com.mafurrasoft.dev.entity.Priority;
import com.mafurrasoft.dev.entity.Todo;
import com.mafurrasoft.dev.services.TodoListService;
import com.mafurrasoft.dev.cap_05.service.TodoListServiceImpl;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.*;

import java.util.List;

public class TodoListController extends SelectorComposer<Component> {

    @Wire
    Listbox todoListbox;

    @Wire
    Radiogroup selectedTodoPriority;

    @Wire
    Textbox tarefaTextbox;

    /*DetailView*/
    @Wire
    Checkbox feitoCheckbox;
    @Wire
    Textbox tarefaAssunto;
    @Wire
    Datebox tarefaDatebox;
    @Wire
    Textbox descricaoTarefa;
    @Wire
    Button actualizarTarefaBt;
    @Wire
    Button recarregarTarefaBt;
    @Wire
    Button fecharTarefaBt;
    @Wire
    East tarefaDetalhesBlock;

    TodoListService todoListService = new TodoListServiceImpl();

    ListModelList<Todo> todoListModelList;
    ListModelList<Priority> priorityListModelList;
    Todo selectedTodo;

    @Override
    public void doAfterCompose(Component component) throws Exception {
        super.doAfterCompose(component);
        List<Todo> todoList = todoListService.getTodoList();
        todoListModelList = new ListModelList<Todo>(todoList);
        todoListbox.setModel(todoListModelList);

        priorityListModelList = new ListModelList<Priority>(Priority.values());
        selectedTodoPriority.setModel(priorityListModelList);
    }

    @Listen("onClick = #adicionarTarefaButton; onOK = #tarefaTextbox")
    public void doTodoAdd() {
        String subject = this.tarefaTextbox.getValue();
        if (subject.isEmpty()) {
            Clients.showNotification("Não tem nada a fazer?", this.tarefaTextbox);
            return;
        }

        selectedTodo = todoListService.saveTodo(new Todo(subject));
        todoListModelList.add(selectedTodo);
        todoListModelList.addToSelection(selectedTodo);

        refreshDetaillView();

        tarefaTextbox.setValue("");

    }

    @Listen("onClick = #todoListbox")
    public void carregarTelaDetalhesAoClicarNaTarefa(){
        if(this.todoListModelList.getSelection().isEmpty()){
            selectedTodo = null;
        }else {
            this.selectedTodo = this.todoListModelList.getSelection().iterator().next();
        }
        this.refreshDetaillView();
    }



    public void refreshDetaillView() {
        boolean temSelecionado = !this.todoListModelList.getSelection().isEmpty();
        if (temSelecionado) {

            this.tarefaDetalhesBlock.setVisible(true);
            this.feitoCheckbox.setChecked(this.selectedTodo.isComplete());
            this.tarefaAssunto.setValue(this.selectedTodo.getSubject());
            this.descricaoTarefa.setValue(this.selectedTodo.getDescription());
            this.tarefaDatebox.setValue(this.selectedTodo.getDate());
            this.priorityListModelList.addToSelection(this.selectedTodo.getPriority());

            this.actualizarTarefaBt.setDisabled(false);
        }else {
            this.tarefaDetalhesBlock.setVisible(false);
            this.feitoCheckbox.setChecked(false);
            this.tarefaAssunto.setValue("");
            this.descricaoTarefa.setValue("");
            this.tarefaDatebox.setValue(null);
            this.priorityListModelList.clearSelection();

            this.actualizarTarefaBt.setDisabled(true);
        }
    }

    @Listen("onClick = #actualizarTarefaBt")
    public void actualizarTarefa(){
        Todo todoTemp = Todo.clone(this.selectedTodo);
        todoTemp.setComplete(this.feitoCheckbox.isChecked());
        todoTemp.setDate(tarefaDatebox.getValue());
        todoTemp.setDescription(descricaoTarefa.getValue());
        todoTemp.setPriority(priorityListModelList.getSelection().iterator().next());
        todoTemp.setSubject(tarefaAssunto.getValue());


        Todo savedTodo = this.todoListService.updateTodo(todoTemp);
        this.todoListModelList.set(this.todoListModelList.indexOf(todoTemp), todoTemp);

        Clients.showNotification("Actualizado com sucesso");

    }

    @Listen("onClick = #recarregarTarefaBt")
    public void recarregarDados(){
        this.refreshDetaillView();
    }
    @Listen("onClick = #fecharTarefaBt")
    public void fecharTelaDetalhes(){
        this.tarefaDetalhesBlock.setVisible(false);
    }

    @Listen("onChecarTarefa = #todoListbox")
    public void definirTarefaComoConcluida(ForwardEvent forwardEvent){
        Checkbox tarefaCheckbox = (Checkbox)forwardEvent.getOrigin().getTarget();
        Listitem listitem = (Listitem)tarefaCheckbox.getParent().getParent();

        boolean concluiou = tarefaCheckbox.isChecked();
        Todo todo = listitem.<Todo>getValue();
        todo.setComplete(concluiou);
        this.todoListService.updateTodo(todo);

        if(todo.equals(this.selectedTodo)){
            selectedTodo = todo;
            refreshDetaillView();
        }

        listitem.setSclass(concluiou ? "complete-todo" : "");
    }

    @Listen("onTarefaApagar = #todoListbox")
    public void apagarTarefa(ForwardEvent forwardEvent){
        Button apagarButton = (Button) forwardEvent.getOrigin().getTarget();

        Listitem listitem = (Listitem) apagarButton.getParent().getParent();

        Todo todo = listitem.<Todo>getValue();

        this.todoListService.deleteTodo(todo);

        this.todoListModelList.remove(todo);

        if(this.selectedTodo.equals(todo)) {
            this.selectedTodo = null;
            this.refreshDetaillView();
        }
    }
}
