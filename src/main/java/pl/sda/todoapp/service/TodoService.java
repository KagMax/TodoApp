package pl.sda.todoapp.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import pl.sda.todoapp.model.Todo;
import pl.sda.todoapp.model.repository.TodoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getList() {
        return todoRepository.findAll();
    }

    public Todo getById(int id) {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if (todoOptional.isPresent()) {
            return todoOptional.get();
        }

        throw new EntityNotFoundException();
    }

    public void saveOrUpdate(Todo todo) {
        todoRepository.save(todo);
    }
}
