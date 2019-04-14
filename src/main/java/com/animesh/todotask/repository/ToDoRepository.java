package com.animesh.todotask.repository;

import com.animesh.todotask.model.ToDoItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("toDoRepository")
public interface ToDoRepository extends CrudRepository<ToDoItem,Long> {
}
