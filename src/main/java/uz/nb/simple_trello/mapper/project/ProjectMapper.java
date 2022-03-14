package uz.nb.simple_trello.mapper.project;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.nb.simple_trello.dto.project.ProjectCreateDto;
import uz.nb.simple_trello.dto.project.ProjectDto;
import uz.nb.simple_trello.dto.project.ProjectUpdateDto;
import uz.nb.simple_trello.entity.project.Project;
import uz.nb.simple_trello.mapper.base.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ProjectMapper extends BaseMapper<
        Project,
        ProjectDto,
        ProjectCreateDto,
        ProjectUpdateDto>, uz.nb.simple_trello.mapper.base.Mapper {

    @Override
     ProjectDto toDto(Project project) ;

    @Override
     List<ProjectDto> toDto(List<Project> e) ;

    @Override
     Project fromCreateDto(ProjectCreateDto projectCreateDto) ;


    @Override
     Project fromUpdateDto(ProjectUpdateDto projectUpdateDto) ;
}
