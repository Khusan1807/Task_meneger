package uz.nb.simple_trello.dto.project;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.nb.simple_trello.dto.base.GenericDto;


@Getter
@Setter
public class ProjectMemberDto extends GenericDto {

    private Long projectId;
    private Long userId;
    private Boolean lead;

    @Builder(builderMethodName = "childBuilder")
    public ProjectMemberDto(Long id, Long projectId, Long userId, Boolean lead) {
        super(id);
        this.projectId = projectId;
        this.userId = userId;
        this.lead = lead;
    }


}
