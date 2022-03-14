package uz.nb.simple_trello.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.nb.simple_trello.dto.base.GenericDto;
import uz.nb.simple_trello.entity.organization.Organization;


@Setter
@Getter
public class ProjectDto extends GenericDto {
    private String name;
    private String description;
    private Long organizationId;
    private String tz;
    private boolean closed;

    @Builder(builderMethodName = "childBuilder")
    public ProjectDto(Long id, String name, Long organizationId, String description, boolean closed, String tz) {
        super(id);
        this.name = name;
        this.description = description;
        this.organizationId = organizationId;
        this.closed = closed;
        this.tz = tz;
    }
}
