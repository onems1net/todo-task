package com.animesh.todotask.service;

import com.animesh.todotask.exception.ToDoItemNotFoundException;
import com.animesh.todotask.model.ToDoItem;
import com.animesh.todotask.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("toDoService")
public class ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;

    public ToDoItem get(long id) {
        return toDoRepository.findById(id).orElseThrow(() -> new ToDoItemNotFoundException(id));
    }

    public ToDoItem add(ToDoItem toDoItem) {
        return toDoRepository.save(toDoItem);
    }

    public ToDoItem patch(ToDoItem newToDoItem, long id) {
        return toDoRepository.findById(id).map(toDoItem -> {
            toDoItem.setText(newToDoItem.getText());
            toDoItem.setCompleted(newToDoItem.isCompleted());
            return toDoRepository.save(toDoItem);
        }).orElseThrow(() -> new ToDoItemNotFoundException(id));
    }
}
