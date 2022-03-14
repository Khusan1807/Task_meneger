package uz.nb.simple_trello.services.task;

import org.springframework.stereotype.Service;
import uz.nb.simple_trello.criteria.GenericCriteria;
import uz.nb.simple_trello.dto.task.TaskCreateDto;
import uz.nb.simple_trello.dto.task.TaskDto;
import uz.nb.simple_trello.dto.task.TaskUpdateDto;
import uz.nb.simple_trello.entity.organization.Organization;
import uz.nb.simple_trello.entity.task.Task;
import uz.nb.simple_trello.mapper.task.TaskMapper;
import uz.nb.simple_trello.reposiroty.task.TaskRepository;
import uz.nb.simple_trello.services.base.AbstractService;
import uz.nb.simple_trello.services.organization.OrganizationService;
import uz.nb.simple_trello.utils.BaseUtils;
import uz.nb.simple_trello.utils.validators.task.TaskValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author Husan Narzullayev
 */
@Service
public class TaskServiceImpl extends AbstractService<
        TaskRepository,
        TaskMapper,
        TaskValidator
        >
        implements TaskService {


    private final OrganizationService organizationService;
    protected TaskServiceImpl(TaskRepository repository, TaskMapper mapper, TaskValidator validator, BaseUtils baseUtils, OrganizationService organizationService) {
        super(repository, mapper, validator, baseUtils);
        this.organizationService = organizationService;
    }

    @Override
    public Long create(TaskCreateDto createDto) {
        Task task = mapper.fromCreateDto(createDto);
        return repository.save(task).getId();

    }

    @Override
    public void delete(Long id) {
        Optional<Task> task = repository.findById(id);
        if (task.isEmpty()) {
            throw new RuntimeException("User not found");
        }

    }


    @Override
    public void update(TaskUpdateDto updateDto) {
        Task task = mapper.fromUpdateDto(updateDto);
        repository.save(task);
    }

    @Override
    public void deleteAllProjects(Long id) {

    }

    @Override
    public List<TaskDto> getAll(GenericCriteria criteria) {
        List<Task> tasks = repository.findAll();
        List<TaskDto> tasksD = new ArrayList<>();
        for (Task task : tasks) {
            TaskDto taskDto = mapper.toDto(task);
            tasksD.add(taskDto);
        }
        return tasksD;
    }

    @Override
    public TaskDto get(Long id) {
        Optional<Task> task = repository.findById(id);
        return mapper.toDto(task.get());
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }

    @Override
    public List<Task> getAllTasks(Long id) {
        return repository.findTasksByProjectId(id);
    }

    @Override
    public List<Task> getAllTasksUserId(Long id) {
        return repository.findTasksByUserId(id);
    }


}
