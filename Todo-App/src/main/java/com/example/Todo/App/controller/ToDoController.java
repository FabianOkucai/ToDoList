package com.example.Todo.App.controller;

import com.example.Todo.App.model.ToDo;
import com.example.Todo.App.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/todo")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    // Get all ToDo items
    @GetMapping("/all")
    public ResponseEntity<List<ToDo>> getAllToDoItems() {
        List<ToDo> todoList = toDoService.getAllToDoItems();
        return new ResponseEntity<>(todoList, HttpStatus.OK);
    }

    // Get ToDo item by ID
    @GetMapping("/{id}")
    public ResponseEntity<ToDo> getToDoItemById(@PathVariable("id") Long id) {
        ToDo todo = toDoService.getToDoItemById(id);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    // Update ToDo item status to "Completed"
    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateToDoStatus(@PathVariable("id") Long id) {
        boolean updated = toDoService.updateStatus(id);
        if (updated) {
            return new ResponseEntity<>("Status updated to Completed.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update status.", HttpStatus.BAD_REQUEST);
        }
    }

    // Save or update a ToDo item
    @PostMapping("/save")
    public ResponseEntity<String> saveOrUpdateToDoItem(@RequestBody ToDo todo) {
        boolean isSaved = toDoService.saveOrUpdateToDoItem(todo);
        if (isSaved) {
            return new ResponseEntity<>("ToDo item saved/updated successfully.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to save/update ToDo item.", HttpStatus.BAD_REQUEST);
        }
    }

    // Delete a ToDo item by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteToDoItem(@PathVariable("id") Long id) {
        toDoService.deleteToDoItem(id);
        return new ResponseEntity<>("ToDo item deleted successfully.", HttpStatus.OK);
    }
}
