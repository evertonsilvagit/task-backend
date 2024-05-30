package br.com.getnet.vouchers.service;

import br.com.getnet.vouchers.exception.InvalidTaskException;
import br.com.getnet.vouchers.model.Task;
import br.com.getnet.vouchers.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class TaskService {

    private TaskRepository taskRepository;

    public List<Task> list() throws InvalidTaskException {

        return taskRepository.findAll();

    }

    public Task criar(String description) {
        return taskRepository.save(
                Task.builder()
                    .id(UUID.randomUUID().toString())
                    .description(description)
                .build()
        );
    }
}
