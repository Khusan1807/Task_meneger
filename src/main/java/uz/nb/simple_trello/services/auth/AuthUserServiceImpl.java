package uz.nb.simple_trello.services.auth;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.nb.simple_trello.config.security.UserDetailsService;
import uz.nb.simple_trello.criteria.GenericCriteria;
import uz.nb.simple_trello.dto.auth.AuthUserCreateDto;
import uz.nb.simple_trello.dto.auth.AuthUserDto;
import uz.nb.simple_trello.dto.auth.AuthUserUpdateDto;
import uz.nb.simple_trello.dto.auth.LoginDto;
import uz.nb.simple_trello.entity.auth.AuthUser;
import uz.nb.simple_trello.entity.base.AuditAwareImpl;
import uz.nb.simple_trello.mapper.auth.AuthUserMapper;
import uz.nb.simple_trello.reposiroty.auth.AuthRoleRepository;
import uz.nb.simple_trello.reposiroty.auth.AuthUserRepository;
import uz.nb.simple_trello.services.base.AbstractService;
import uz.nb.simple_trello.utils.BaseUtils;
import uz.nb.simple_trello.utils.validators.auth.AuthUserValidator;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthUserServiceImpl extends
        AbstractService<AuthUserRepository, AuthUserMapper, AuthUserValidator>
        implements AuthUserService {


    private final PasswordEncoder encoder;
    private final AuthRoleRepository authRoleRepository;
    private final AuditAwareImpl auditAware;
    private UserDetailsService userDetailsService;

    protected AuthUserServiceImpl(AuthUserRepository repository,
                                  AuthUserMapper mapper,
                                  AuthUserValidator validator,
                                  BaseUtils baseUtils, PasswordEncoder encoder, AuthRoleRepository authRoleRepository, AuditAwareImpl auditAware, UserDetailsService userDetailsService) {
        super(repository, mapper, validator, baseUtils);
        this.encoder = encoder;
        this.authRoleRepository = authRoleRepository;
        this.auditAware = auditAware;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Long create(AuthUserCreateDto createDto) {
        createDto.setRole(authRoleRepository.getAuthRoleById(createDto.getRoleId()).get());
        AuthUser user = mapper.fromCreateDto(createDto);
        user.setPassword(encoder.encode(createDto.getPassword()));
        user.setOrganizationId(auditAware.getCredentials().getOrganizationId());
        user.setCreatedBy(new AuditAwareImpl().getCurrentAuditor().get());
        user.setCode(UUID.randomUUID());
        if (createDto.getPassword().equals(createDto.getConPassword()))
            repository.save(user);
        else {
            System.out.println("Error");
        }
        return user.getId();
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public void update(AuthUserUpdateDto updateDto) {
        AuthUser user = repository.findAuthUserById(updateDto.getId());
        AuthUser user1 = mapper.fromUpdateDto(updateDto);
        user1.setId(updateDto.getId());
        user1.setCode(user.getCode());
        user1.setPassword(user.getPassword());
        user1.setRole(user.getRole());
        user1.setOrganizationId(user.getOrganizationId());
        user1.setCreatedBy(user.getCreatedBy());
        user1.setActive(true);
        repository.save(user1);

    }

    @Override
    public void deleteAllProjects(Long id) {

    }


    @Override
    public List<AuthUserDto> getAll(GenericCriteria criteria) {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public AuthUserDto get(Long id) {
        return mapper.toDto(repository.findAuthUserById(id));
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }


    @Override
    public List<AuthUserDto> usersList() {
        List<AuthUser> all = repository.findAllUsers();
        return mapper.toDto(all);

    }


    @Override
    public AuthUserDto user(Long id) {
        return mapper.toDto(repository.findAuthUserById(id));
    }

    @Override
    public List<AuthUserDto> usersLists(Long id) {
        Long userId = auditAware.getCredentials().getId();
        return mapper.toDto(repository.findAuthUsersByOrganizationId(id,userId));
    }

    @Override
    public Long createByAdmin(AuthUserCreateDto createDto) {
        createDto.setRole(authRoleRepository.getAuthRoleById(createDto.getRoleId()).get());
        AuthUser user = mapper.fromCreateDto(createDto);
        user.setPassword(encoder.encode(createDto.getPassword()));
        user.setCreatedBy(new AuditAwareImpl().getCurrentAuditor().get());
        user.setCode(UUID.randomUUID());
        if (createDto.getPassword().equals(createDto.getConPassword()))
            repository.save(user);
        else {
            System.out.println("Error");
        }
        return user.getId();
    }

    @Override
    public void login(LoginDto dto) {
        Optional<AuthUser> authUser = repository.findAuthUserByUsername(dto.getUsername());
        if (authUser.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        if (!encoder.matches(dto.getPassword(), authUser.get().getPassword())) {
            throw new UsernameNotFoundException("User not found");
        }
        userDetailsService.loadUserByUsername(dto.getUsername());
    }

}
