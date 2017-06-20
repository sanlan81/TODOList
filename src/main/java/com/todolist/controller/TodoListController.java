package com.todolist.controller;

import com.todolist.bean.TodoListBean;
import com.todolist.entity.TodoList;
import com.todolist.service.TodoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users/todolist")
@Api(value = "users todolist")
public class TodoListController {

    private final TodoService todoService;


    @Autowired
    public TodoListController(TodoService todoService) {
        this.todoService = todoService;

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "create todo list", httpMethod = "POST")
    public void createTodoList(Authentication authentication, @RequestBody TodoListBean todoListBean) {
        todoService.createTodo(authentication.getName(), todoListBean.getTitleTodoList());
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "get todo list Items", httpMethod = "GET")
    public List<TodoList> getTodoListItems(Authentication authentication) {
        return todoService.getTodoItems(authentication.getName());
    }

    @RequestMapping(value = "{todoItemId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "delete todo list", httpMethod = "DELETE")
    public void deleteTodoList(Authentication authentication, @PathVariable Integer todoItemId) {
        todoService.deleteTodo(authentication.getName(), todoItemId);
    }

    @RequestMapping(value = "/{todoItem}", method = RequestMethod.PUT)
    @ApiOperation(value = "mark todoItem", httpMethod = "PUT")
    public void markTodoItem(Authentication authentication, @PathVariable Integer todoItem ){
        todoService.markTodo(authentication.getName(), todoItem);
    }
}
