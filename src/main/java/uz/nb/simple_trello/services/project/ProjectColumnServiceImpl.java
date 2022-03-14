package uz.nb.simple_trello.services.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.nb.simple_trello.criteria.GenericCriteria;
import uz.nb.simple_trello.dto.project.ProjectColumnCreateDto;
import uz.nb.simple_trello.dto.project.ProjectColumnDto;
import uz.nb.simple_trello.dto.project.ProjectColumnUpdateDto;
import uz.nb.simple_trello.entity.project.Project;
import uz.nb.simple_trello.entity.project.ProjectColumn;
import uz.nb.simple_trello.mapper.project.ProjectColumnMapper;
import uz.nb.simple_trello.reposiroty.project.ProjectColumnRepository;
import uz.nb.simple_trello.services.base.AbstractService;
import uz.nb.simple_trello.utils.BaseUtils;
import uz.nb.simple_trello.utils.validators.project.ProjectColumnValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @Author Aziza Tojiboyeva
 */
@Service
public class ProjectColumnServiceImpl extends AbstractService<
        ProjectColumnRepository,
        ProjectColumnMapper,
        ProjectColumnValidator
        > implements ProjectColumnService{

    @Autowired
    protected ProjectColumnServiceImpl(
            ProjectColumnRepository repository,
            ProjectColumnMapper mapper,
            ProjectColumnValidator validator,
            BaseUtils baseUtils) {
        super(repository, mapper, validator, baseUtils);
    }


    @Override
    public Long create(ProjectColumnCreateDto createDto) {
        Project project = repository.findProject(createDto.getProject_id());

        if (Objects.isNull(project)) {
            throw new RuntimeException("Wrong data");
        }
        ProjectColumn projectColumn = mapper.fromCreateDto(createDto);
        projectColumn.setActive(true);

        return repository.save(projectColumn).getId();
    }

    @Override
    public void delete(Long id) {
        Optional<ProjectColumn> projectColumn = repository.findById(id);
        if (projectColumn.isPresent()) {
            throw new RuntimeException("Project column not found!!!");
        }
        repository.delete(projectColumn.get());;
    }

    @Override
    public void update(ProjectColumnUpdateDto updateDto) {
        ProjectColumn pr = mapper.fromUpdateDto(updateDto);
        repository.save(pr);
    }

    @Override
    public void deleteAllProjects(Long id) {
        repository.findProjectOrgId(id);

    }


    @Override
    public List<ProjectColumnDto> getAll(GenericCriteria criteria) {
        List<ProjectColumn> projectColumns = repository.findAll();
        List<ProjectColumnDto> projectColumnsDto = new ArrayList<>();

        for (ProjectColumn projectColumn : projectColumns) {
            ProjectColumnDto dto = mapper.toDto(projectColumn);
            projectColumnsDto.add(dto);
        }

        return projectColumnsDto;
    }

    @Override
    public ProjectColumnDto get(Long id) {
        ProjectColumn projectColumn = repository.getById(id);
        if (Objects.isNull(projectColumn)) {
            throw new RuntimeException("PR column not found");
        }
        ProjectColumnDto newDto = mapper.toDto(projectColumn);
        return newDto;
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }
}
