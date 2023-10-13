package com.abimael.example.todolist.task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    ITaskRepository taskRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody TaskModel taskModel, HttpServletRequest request) {

        var idUser = getIdUser(request);

        taskModel.setIdUser((UUID) idUser);

        var task = this.taskRepository.save(taskModel);

        var currentDate = LocalDateTime.now();

        if (taskModel.getStartAt().isBefore(currentDate) || taskModel.getEndAt().isBefore(currentDate)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("A data de início / data de término deve ser maio que a data atual");
        }
        if (taskModel.getStartAt().isAfter(taskModel.getEndAt())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("A data de início deve ser menor que a data de término");
        }

        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    public Object getIdUser(HttpServletRequest request) {

        return request.getAttribute("idUser");
    }

    @GetMapping("/")
    public List<TaskModel> findTaskByIdUser(HttpServletRequest request) {
        var idUser = getIdUser(request);

        return this.taskRepository.findByIdUser((UUID) idUser);
    }

    // Este método esta parcialmente pronto, falta tratar o capos que estão sendo
    // salvo como null
    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody TaskModel taskModel, @PathVariable UUID id, HttpServletRequest request) {
        var idUser = getIdUser(request);

        var task = this.taskRepository.findById(id).orElse(null);

        if (task == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tarefa não encontrada!");
        }
        if (!task.getIdUser().equals(idUser)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Usuário não tem permissão para alterar essa tarefa!");
        }

        //Falta implementar
        // Utils.copyNonNullProperties(taskModel, task)

        taskModel.setIdUser((UUID) idUser);

        taskModel.setId(id);

        var taskUpdated = this.taskRepository.save(taskModel);

        return ResponseEntity.ok().body(taskUpdated);
    }

}
