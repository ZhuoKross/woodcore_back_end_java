package com.crud.crudProyecto.service;

import com.crud.crudProyecto.entity.TaskEntity;
import com.crud.crudProyecto.repository.TaskRepository;
import org.hibernate.query.sqm.mutation.internal.TableKeyExpressionCollector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<TaskEntity> getAll(){
        try {

            List<TaskEntity> taskEntityList = new ArrayList<>();

            taskEntityList.addAll(taskRepository.findAll());

            return taskEntityList;

        }catch (Exception e){
            throw new Error("Error al obtener tareas: ", e);
        }
    }


    public void update(Long id_task, TaskEntity taskEntity){

        Optional<TaskEntity> entityTaskOpt = taskRepository.findById(id_task);

        if(entityTaskOpt.isEmpty()){
            throw new Error("Error al actualizar tarea: ");
        }

        TaskEntity entityTask = entityTaskOpt.get();



        entityTask.setEncargado(taskEntity.getEncargado());
        entityTask.setNombre_tarea(taskEntity.getNombre_tarea());
        entityTask.setEstado(taskEntity.getEstado());
        entityTask.setPrioridad(taskEntity.getPrioridad());
        entityTask.setResumen(taskEntity.getResumen());

        taskRepository.save(entityTask);


    }


    public void create(TaskEntity taskEntity){
        try {
            taskRepository.save(taskEntity);
        }catch (Exception e){
            throw new Error("Error al crear tarea: ", e);
        }
    }

    public void delete(long id_task){
        try{

            taskRepository.deleteById(id_task);

        }catch (Exception e){
            throw new Error("Error al eliminar tarea: ", e);
        }
    }
}
