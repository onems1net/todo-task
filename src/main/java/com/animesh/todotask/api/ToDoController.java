package com.animesh.todotask.api;

import com.animesh.todotask.model.ToDoItem;
import com.animesh.todotask.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/test/1.0")
public class ToDoController {
    @Autowired
    ToDoService toDoService;

    @GetMapping("/todo/{id}")
    public @ResponseBody
    ResponseEntity<ToDoItem> get(@PathVariable(name = "id") long id) {
        return new ResponseEntity<ToDoItem>(toDoService.get(id), HttpStatus.OK);
    }

    @PostMapping("/todo/add")
    public @ResponseBody
    ResponseEntity<ToDoItem> add(@RequestBody ToDoItem toDoItem) {
        return new ResponseEntity<ToDoItem>(toDoService.add(toDoItem), HttpStatus.OK);
    }

    @PatchMapping("/todo/{id}")
    public @ResponseBody
    ResponseEntity<ToDoItem> patch(@RequestBody ToDoItem newToDoItem,@PathVariable(name = "id") long id) {
        return new ResponseEntity<ToDoItem>(toDoService.patch(newToDoItem,id), HttpStatus.OK);
    }
}
