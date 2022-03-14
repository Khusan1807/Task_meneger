package uz.nb.simple_trello.dto.organization;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.nb.simple_trello.dto.base.GenericDto;

@Getter
@Setter
public class OrganizationUpdateDto extends GenericDto {
    private String name;
    private String code;
    private String gmail;


    public OrganizationUpdateDto(Long id, String name, String code, String email) {
        super(id);
        this.name = name;
        this.code = code;
        this.gmail = email;
    }
}
