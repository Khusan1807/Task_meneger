package uz.nb.simple_trello.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import uz.nb.simple_trello.dto.base.GenericDto;
import uz.nb.simple_trello.entity.auth.AuthRole;
import uz.nb.simple_trello.entity.auth.AuthUser;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@Builder(builderMethodName = "childBuilder")
public class AuthUserDto extends GenericDto {
    private Long id;
    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    private boolean isSuperUser;
    private Long organizationId;
    private UUID code;
    private AuthRole role;
    private boolean active = true;
    private boolean blocked;
    protected Long createdBy;

    protected LocalDateTime createdAt;
    protected Long lastModifiedBy;
    protected LocalDateTime lastModifiedAt;

}
