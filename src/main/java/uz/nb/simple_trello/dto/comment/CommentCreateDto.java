package uz.nb.simple_trello.dto.comment;

import lombok.Getter;
import lombok.Setter;
import uz.nb.simple_trello.dto.base.Dto;

@Setter
@Getter
public class CommentCreateDto implements Dto {
    private String commentBody;
    private Long taskId;
    private Long commentType;

}
