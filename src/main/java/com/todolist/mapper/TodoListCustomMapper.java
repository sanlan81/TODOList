package com.todolist.mapper;

import com.todolist.bean.TodoListBean;
import com.todolist.entity.TodoList;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TodoListCustomMapper extends CustomMapper<TodoList, TodoListBean> {

    @Override
    public void mapAtoB(TodoList todoList, TodoListBean todoListBean, MappingContext context) {
        Optional.ofNullable(todoList.getId())
                .ifPresent(todoListBean::setId);

        Optional.ofNullable(todoList.getTitle())
                .ifPresent(todoListBean::setTitleTodoList);

    }
}
