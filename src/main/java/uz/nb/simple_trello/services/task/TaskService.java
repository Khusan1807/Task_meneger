package uz.nb.simple_trello.services.task;

import org.springframework.stereotype.Service;
import uz.nb.simple_trello.criteria.GenericCriteria;
import uz.nb.simple_trello.dto.task.TaskCreateDto;
import uz.nb.simple_trello.dto.task.TaskDto;
import uz.nb.simple_trello.dto.task.TaskUpdateDto;
import uz.nb.simple_trello.entity.organization.Organization;
import uz.nb.simple_trello.entity.task.Task;
import uz.nb.simple_trello.services.base.GenericCrudService;

import java.util.List;
public interface TaskService extends GenericCrudService<
        TaskDto,
        TaskCreateDto,
        TaskUpdateDto,
        GenericCriteria,
        Long
        > {
    List<Task> getAllTasks(Long id);
    List<Task> getAllTasksUserId(Long id);

}
