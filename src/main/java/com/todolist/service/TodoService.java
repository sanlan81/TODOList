package com.todolist.service;

import com.todolist.bean.TodoListBean;
import com.todolist.entity.TodoList;
import com.todolist.entity.User;
import com.todolist.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoListRepository todoListRepository;
    private final UserService userService;

    @Autowired
    public TodoService(TodoListRepository todoListRepository, UserService userService) {
        this.todoListRepository = todoListRepository;
        this.userService = userService;
    }



    public void createTodo(Integer userId, TodoListBean todoListBean) {
        User user = userService.getUser(userId);
        TodoList todoList = new TodoList();
        todoList.setTitle(todoListBean.getTitleTodoList());
        todoList.setUser(user);

        todoListRepository.save(todoList);
    }
}
