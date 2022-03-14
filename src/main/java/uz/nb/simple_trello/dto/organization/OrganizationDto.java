package uz.nb.simple_trello.dto.organization;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import uz.nb.simple_trello.dto.base.GenericDto;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
public class OrganizationDto extends GenericDto {

    private String name;
    private String logo;
    private String code;
    private String gmail;
    private String location;
    private Long owner;
    private Long createdBy;
    private LocalDateTime createdAt;


    @Builder(builderMethodName = "childBuilder")
    public OrganizationDto(Long id, String name, String logo, String code, String location, String gmail, Long owner, Long createdBy, LocalDateTime createdAt) {
        super(id);
        this.name = name;
        this.logo = logo;
        this.code = code;
        this.gmail = gmail;
        this.location = location;
        this.owner = owner;
        this.createdAt = createdAt;
        this.createdBy = createdBy;

    }
}

