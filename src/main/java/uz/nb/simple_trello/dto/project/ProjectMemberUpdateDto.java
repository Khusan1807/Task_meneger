package uz.nb.simple_trello.dto.project;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.nb.simple_trello.dto.base.GenericDto;

@Getter
@Setter
@NoArgsConstructor
public class ProjectMemberUpdateDto extends GenericDto {
    private Long projectId;
    private Long userId;
    private Boolean lead;

    @Builder(builderMethodName = "childBuilder")
    public ProjectMemberUpdateDto(Long projectId, Long userId, Boolean lead) {
        this.projectId = projectId;
        this.userId = userId;
        this.lead = lead;
    }
}
