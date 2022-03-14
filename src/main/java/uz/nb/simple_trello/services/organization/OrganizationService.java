package uz.nb.simple_trello.services.organization;

import uz.nb.simple_trello.criteria.GenericCriteria;
import uz.nb.simple_trello.dto.organization.OrganizationCreateDto;
import uz.nb.simple_trello.dto.organization.OrganizationDto;
import uz.nb.simple_trello.dto.organization.OrganizationUpdateDto;
import uz.nb.simple_trello.entity.organization.Organization;
import uz.nb.simple_trello.services.base.GenericCrudService;

import java.util.List;


public interface OrganizationService extends GenericCrudService<
        OrganizationDto,
        OrganizationCreateDto,
        OrganizationUpdateDto,
        GenericCriteria,
        Long> {
    List<Organization> getOrganizations(Long id);
}
