package com.todolist.service;

import com.todolist.bean.TodoItemBean;
import com.todolist.bean.TodoListTitleBean;
import com.todolist.entity.TodoList;
import com.todolist.entity.User;
import com.todolist.repository.TodoListRepository;
import com.todolist.repository.UserRepository;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoListRepository todoListRepository;
    private final UserService userService;
    private final UserRepository userRepository;
    private final MapperFacade mapperFacade;

    @Autowired
    public TodoService(TodoListRepository todoListRepository, UserService userService, UserRepository userRepository, MapperFacade mapperFacade) {
        this.todoListRepository = todoListRepository;
        this.userService = userService;
        this.userRepository = userRepository;
        this.mapperFacade = mapperFacade;
    }



    public void createTodo(String name, String todoListBean) {

        User user = userRepository.findOneByFirstName(name);

        TodoList todoList = new TodoList();
        todoList.setTitle(todoListBean);
        todoList.setCompleted(false);
        todoList.setUser(user);

        todoListRepository.save(todoList);
    }

   /* public List<TodoList> getTodoItems(String name) {

        User user = userRepository.findOneByFirstName(name);
       return user.getTodoList();
    }*/

    public List<TodoItemBean> getTodoItems(String name) {
        User user = userRepository.findOneByFirstName(name);

        return mapperFacade.mapAsList(user.getTodoList(), TodoItemBean.class);
    }

    public void deleteTodo(String name, Integer todoListId) {
        userService.getUser(name);

        TodoList todo = todoListRepository.findOne(todoListId);
        todoListRepository.delete(todoListId);

    }

    public void markTodo(String name, Integer todoItem, TodoListTitleBean todoListTitleBean) {

        userService.getUser(name);
        TodoList todo = todoListRepository.findOne(todoItem);
        todo.setCompleted(todoListTitleBean.getCompleted());
        todo.setTitle(todoListTitleBean.getTitle());
        todoListRepository.save(todo);
    }


}
