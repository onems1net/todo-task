package au.com.autoandgeneral.todotask.exception;

public class ToDoItemNotFoundException extends RuntimeException {
    public ToDoItemNotFoundException(long id) {
        super("ToDo item with id "+id + " not found");
    }
}
