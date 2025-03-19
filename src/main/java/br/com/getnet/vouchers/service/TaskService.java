package br.com.getnet.vouchers.service;

import br.com.getnet.vouchers.exception.InvalidTaskException;
import br.com.getnet.vouchers.model.Task;
import br.com.getnet.vouchers.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@AllArgsConstructor
@Service
public class TaskService {

    private TaskRepository taskRepository;

    public List<Task> list() throws InvalidTaskException {

        return taskRepository.findAll();

    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }
}
