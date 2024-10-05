package com.example.Todo.App.service;

import com.example.Todo.App.model.ToDo;

import java.util.List;

public interface ToDoService {
    List<ToDo> getAllToDoItems();

    ToDo getToDoItemById(Long id);

    boolean updateStatus(Long id);

    boolean saveOrUpdateToDoItem(ToDo todo);

    void deleteToDoItem(Long id);


}
