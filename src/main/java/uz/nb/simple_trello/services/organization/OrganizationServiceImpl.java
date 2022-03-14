package uz.nb.simple_trello.services.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.nb.simple_trello.criteria.GenericCriteria;
import uz.nb.simple_trello.dto.organization.OrganizationCreateDto;
import uz.nb.simple_trello.dto.organization.OrganizationDto;
import uz.nb.simple_trello.dto.organization.OrganizationUpdateDto;
import uz.nb.simple_trello.entity.base.AuditAwareImpl;
import uz.nb.simple_trello.entity.organization.Organization;
import uz.nb.simple_trello.mapper.organization.OrganizationMapper;
import uz.nb.simple_trello.reposiroty.organization.OrganizationRepository;
import uz.nb.simple_trello.services.base.AbstractService;
import uz.nb.simple_trello.services.file.FileStorageService;
import uz.nb.simple_trello.services.project.ProjectService;
import uz.nb.simple_trello.utils.BaseUtils;
import uz.nb.simple_trello.utils.validators.organization.OrganizationValidator;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationServiceImpl extends
        AbstractService<OrganizationRepository, OrganizationMapper, OrganizationValidator>
        implements OrganizationService {

    private final FileStorageService fileStorageService;
    private final ProjectService projectService;
    private final AuditAwareImpl auditAware;

    @Autowired
    protected OrganizationServiceImpl(OrganizationRepository repository,
                                      OrganizationMapper mapper,
                                      OrganizationValidator validator,
                                      BaseUtils baseUtils,
                                      FileStorageService fileStorageService, ProjectService projectService, AuditAwareImpl auditAware) {
        super(repository, mapper, validator, baseUtils);
        this.fileStorageService = fileStorageService;
        this.projectService = projectService;
        this.auditAware = auditAware;
    }

    @Override
    public Long create(OrganizationCreateDto createDto) {
        MultipartFile file = createDto.getLogo();
        String logoPath = fileStorageService.store(file);
        Organization organization = mapper.fromCreateDto(createDto);
        organization.setLogo(logoPath);
        organization.setOwner(new AuditAwareImpl().getCurrentAuditor().get());
        organization.setCreatedBy(new AuditAwareImpl().getCurrentAuditor().get());
        organization.setLastModifiedBy(new AuditAwareImpl().getCurrentAuditor().get());
        repository.save(organization);
        return organization.getId();
    }


    @Override
    public void delete(Long id) {
        projectService.deleteAllProjects(id);
        repository.deleteById(id);
    }

    @Override
    public void update(OrganizationUpdateDto updateDto) {
        Optional<Organization> byId = repository.findById(updateDto.getId());
        Organization organization = mapper.fromUpdateDto(updateDto);
        organization.setLogo(byId.get().getLogo());
        organization.setId(updateDto.getId());
        organization.setOwner(byId.get().getOwner());
        repository.save(organization);
    }

    @Override
    public void deleteAllProjects(Long id) {

    }

    @Override
    public List<OrganizationDto> getAll(GenericCriteria criteria) {
        return mapper.toDto(repository.findAllOrg());
    }

    @Override
    public OrganizationDto get(Long id) {
        Organization organization = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Not Found");
        });
        OrganizationDto dto = mapper.toDto(organization);
        return dto;
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }

    @Override
    public List<Organization> getOrganizations(Long id) {
        return repository.findOrganizationById(id);
    }
}
