package br.com.getnet.vouchers.controller;

import br.com.getnet.vouchers.controller.dto.response.TaskResponseDTO;
import br.com.getnet.vouchers.exception.InvalidTaskException;
import br.com.getnet.vouchers.model.Task;
import br.com.getnet.vouchers.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> list() throws InvalidTaskException {

        List<Task> tasks = taskService.list();
        List<TaskResponseDTO> taskResponseDTOS = tasks.stream().map(task -> TaskResponseDTO.builder()
                        .description(task.getDescription())
                        .build())
            .collect(Collectors.toList());

        return new ResponseEntity<>(
                taskResponseDTOS,
                HttpStatus.OK
        );
    }

}
