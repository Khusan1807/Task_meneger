package uz.nb.simple_trello.dto.project;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.nb.simple_trello.dto.base.Dto;

@Getter
@Setter
@Builder
public class ProjectMemberCreateDto implements Dto {

    private Long projectId;
    private Long userId;
    private Boolean lead;


    public ProjectMemberCreateDto(Long projectId, Long userId, Boolean lead) {
        this.projectId = projectId;
        this.userId = userId;
        this.lead = lead;
    }


}
