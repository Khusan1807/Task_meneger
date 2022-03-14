package uz.nb.simple_trello.dto.organization;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import uz.nb.simple_trello.dto.base.Dto;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationCreateDto implements Dto {
    private String name;
    private MultipartFile logo;
    private String code;
    private String gmail;
    private Long createdBy;
    private LocalDateTime createdAt;


}
