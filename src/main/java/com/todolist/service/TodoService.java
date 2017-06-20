package com.todolist.service;

import com.todolist.entity.TodoList;
import com.todolist.entity.User;
import com.todolist.repository.TodoListRepository;
import com.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoListRepository todoListRepository;
    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public TodoService(TodoListRepository todoListRepository, UserService userService, UserRepository userRepository) {
        this.todoListRepository = todoListRepository;
        this.userService = userService;
        this.userRepository = userRepository;
    }



    public void createTodo(String name, String todoListBean) {

        User user = userRepository.findOneByFirstName(name);

        TodoList todoList = new TodoList();
        todoList.setTitle(todoListBean);
        todoList.setUser(user);

        todoListRepository.save(todoList);
    }
}
