package com.todolist.controller;

import com.todolist.bean.TodoListBean;
import com.todolist.service.TodoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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
}
