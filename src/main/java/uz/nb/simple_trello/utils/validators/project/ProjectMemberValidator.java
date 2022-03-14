package uz.nb.simple_trello.utils.validators.project;

import org.springframework.stereotype.Component;
import uz.nb.simple_trello.dto.project.ProjectMemberCreateDto;
import uz.nb.simple_trello.dto.project.ProjectMemberUpdateDto;
import uz.nb.simple_trello.exceptions.ValidationException;
import uz.nb.simple_trello.utils.BaseUtils;
import uz.nb.simple_trello.utils.validators.AbstractValidator;

@Component
public class ProjectMemberValidator extends AbstractValidator<
        ProjectMemberCreateDto,
        ProjectMemberUpdateDto,
        Long> {

    protected ProjectMemberValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(ProjectMemberCreateDto projectMemberCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(ProjectMemberUpdateDto cd) throws ValidationException {

    }
}






