package uz.nb.simple_trello.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.nb.simple_trello.dto.base.GenericDto;

import javax.persistence.Column;

@Setter
@Getter
@Builder(builderMethodName = "childBuilder")
public class AuthUserUpdateDto extends GenericDto {
    private String username;
    private String email;
    private String phoneNumber;

}
