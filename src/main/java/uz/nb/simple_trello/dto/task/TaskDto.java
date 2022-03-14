package uz.nb.simple_trello.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.nb.simple_trello.dto.base.GenericDto;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder(builderMethodName = "childBuilder")
public class TaskDto extends GenericDto {

    private String name;
    private String description;
    private Long level;
    private Long priority;
    private LocalDateTime deadline;
    private Long projectId;
    private Long columnId;

}