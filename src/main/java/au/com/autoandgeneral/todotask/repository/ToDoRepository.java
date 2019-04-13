package au.com.autoandgeneral.todotask.repository;

import au.com.autoandgeneral.todotask.model.ToDoItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("toDoRepository")
public interface ToDoRepository extends CrudRepository<ToDoItem,Long> {
}
