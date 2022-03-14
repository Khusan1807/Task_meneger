package uz.nb.simple_trello.dto.project;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import uz.nb.simple_trello.dto.base.Dto;
import uz.nb.simple_trello.entity.organization.Organization;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectCreateDto implements Dto {
    private String name;
    private String description;
    private String tz;

    private Long organizationId;


}
