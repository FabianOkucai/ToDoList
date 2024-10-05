package com.example.Todo.App.service.impl;

import com.example.Todo.App.model.ToDo;
import com.example.Todo.App.repo.ToDoRepo;
import com.example.Todo.App.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    ToDoRepo repo;

    @Override
    public List<ToDo> getAllToDoItems() {
        ArrayList<ToDo> todoList = new ArrayList<> ();
        repo.findAll().forEach(todo -> todoList.add(todo));
        return todoList;
    }
    @Override
    public ToDo getToDoItemById(Long id) {
        return repo.findById(id).get();

    }
    public boolean updateStatus(Long id) {
        ToDo todo = getToDoItemById(id);
        todo.setStatus("Completed");

        return saveOrUpdateToDoItem(todo);
    }
    public boolean saveOrUpdateToDoItem(ToDo todo) {
//        todo.setStatus("Pe");
        ToDo updateObj = repo.save(todo);

        if (getToDoItemById(updateObj.getId()) != null){
            return true;
        }
        return false;
    }
    @Override
    public void deleteToDoItem(Long id) {
        repo.deleteById(id);

    }



}
