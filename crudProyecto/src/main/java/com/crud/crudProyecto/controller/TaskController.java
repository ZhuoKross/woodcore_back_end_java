package com.crud.crudProyecto.controller;

import com.crud.crudProyecto.entity.TaskEntity;
import com.crud.crudProyecto.service.TaskService;
import org.hibernate.query.sqm.mutation.internal.TableKeyExpressionCollector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("/all")
    public List<TaskEntity> getAll (){
        List<TaskEntity> taskEntityList = taskService.getAll();

        return taskEntityList;
    }


    @PostMapping("/create")
    public void create (@RequestBody TaskEntity taskEntity){
        taskService.create(taskEntity);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") Long id_task, @RequestBody TaskEntity taskEntity){

        try {

            taskService.update(id_task, taskEntity);

        }catch (Exception e){
            throw new Error("Error al actualizar Tarea(Controller): ", e);
        }
    }


    @DeleteMapping("/delete/{id}")
    public void delete (@PathVariable("id") Long id_task){
        try {
            taskService.delete(id_task);
        }catch (Exception e){
            throw new Error("Error al eliminar Tarea (Controller): ", e);
        }
    }
}
