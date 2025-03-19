package br.com.getnet.vouchers.controller;

import br.com.getnet.vouchers.controller.dto.request.TaskRequestDTO;
import br.com.getnet.vouchers.controller.dto.response.TaskResponseDTO;
import br.com.getnet.vouchers.exception.InvalidTaskException;
import br.com.getnet.vouchers.model.Task;
import br.com.getnet.vouchers.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> list() throws InvalidTaskException {

        List<Task> tasks = taskService.list();
        List<TaskResponseDTO> taskResponseDTOS = tasks.stream().map(task -> TaskResponseDTO.builder()
                        .id(task.getId())
                        .description(task.getDescription())
                        .build())
            .collect(Collectors.toList());

        return new ResponseEntity<>(
                taskResponseDTOS,
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> save(@RequestBody TaskRequestDTO taskRequestDTO) throws InvalidTaskException {

        Task task = taskService.save(
                Task.builder()
                        .id(taskRequestDTO.getId())
                        .description(taskRequestDTO.getDescription())
                        .build()
        );

        return new ResponseEntity<>(
                TaskResponseDTO.builder()
                        .id(task.getId())
                        .description(task.getDescription())
                        .build(),
                HttpStatus.OK
        );
    }

}
