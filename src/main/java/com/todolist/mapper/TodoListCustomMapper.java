package com.todolist.mapper;

import com.todolist.bean.TodoItemBean;
import com.todolist.entity.TodoList;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TodoListCustomMapper extends CustomMapper<TodoList, TodoItemBean> {

    @Override
    public void mapAtoB(TodoList todoList, TodoItemBean todoItemBean, MappingContext context) {
        Optional.ofNullable(todoList.getId())
                .ifPresent(todoItemBean::setId);

        Optional.ofNullable(todoList.getTitle())
                .ifPresent(todoItemBean::setTitle);

    }
}
