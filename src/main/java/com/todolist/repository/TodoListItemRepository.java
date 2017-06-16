package com.todolist.repository;


import com.todolist.entity.TodoListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListItemRepository extends JpaRepository<TodoListItem, Integer> {
}