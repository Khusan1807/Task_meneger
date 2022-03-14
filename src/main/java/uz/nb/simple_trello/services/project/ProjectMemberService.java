package uz.nb.simple_trello.services.project;

import uz.nb.simple_trello.criteria.GenericCriteria;
import uz.nb.simple_trello.dto.project.*;
import uz.nb.simple_trello.services.base.GenericCrudService;

public interface ProjectMemberService extends GenericCrudService<
        ProjectMemberDto,
        ProjectMemberCreateDto,
        ProjectMemberUpdateDto,
        GenericCriteria,
        Long> {
}
