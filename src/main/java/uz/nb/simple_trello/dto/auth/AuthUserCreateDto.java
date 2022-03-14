package uz.nb.simple_trello.dto.auth;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import uz.nb.simple_trello.dto.base.Dto;
import uz.nb.simple_trello.entity.auth.AuthRole;
import uz.nb.simple_trello.entity.auth.AuthUser;

import javax.management.relation.Role;
import java.util.UUID;

@Getter
@Setter
@ToString
public class AuthUserCreateDto implements Dto {
    private String username;
    private String email;
    private String phoneNumber;
    private String password;
    private String conPassword;
    private AuthRole role;
    private Long roleId;
    private Long OrganizationId;

}
