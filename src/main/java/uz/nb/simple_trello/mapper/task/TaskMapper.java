package uz.nb.simple_trello.mapper.task;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import uz.nb.simple_trello.dto.task.TaskCreateDto;
import uz.nb.simple_trello.dto.task.TaskDto;
import uz.nb.simple_trello.dto.task.TaskUpdateDto;
import uz.nb.simple_trello.entity.task.Task;
import uz.nb.simple_trello.mapper.base.BaseMapper;

import java.util.List;


@Component
@Mapper(componentModel = "spring")
public interface TaskMapper extends BaseMapper<
        Task,
        TaskDto,
        TaskCreateDto,
        TaskUpdateDto
        > {

    @Override
     TaskDto toDto(Task task);

    @Override
     List<TaskDto> toDto(List<Task> e);

    @Override
     Task fromCreateDto(TaskCreateDto taskCreateDto);

}
