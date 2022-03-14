package uz.nb.simple_trello.dto.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.nb.simple_trello.dto.base.GenericDto;

/**
 * @Author Aziza Tojiboyeva
 */
@Setter
@Getter
public class CommentDto extends GenericDto {
    private String commentBody;
    private Long taskId;
    private Long commentType;


    @Builder(builderMethodName = "childBuilder")
    public CommentDto(Long id, String commentBody, Long taskId, Long commentType) {
        super(id);
        this.commentBody = commentBody;
        this.taskId = taskId;
        this.commentType = commentType;
    }

}
