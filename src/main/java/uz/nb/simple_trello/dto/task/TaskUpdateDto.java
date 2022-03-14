package uz.nb.simple_trello.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.nb.simple_trello.dto.base.GenericDto;

import java.time.LocalDateTime;

/**
 * @Author Aziza Tojiboyeva
 */
@Setter
@Getter
@Builder(builderMethodName = "childBuilder")
public class TaskUpdateDto extends GenericDto {

    private String name;
    private String description;
//    private Long level;
//    private Long priority;
    private LocalDateTime deadline;

}
