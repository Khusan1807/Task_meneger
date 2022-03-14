package uz.nb.simple_trello.dto.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.nb.simple_trello.dto.base.GenericDto;

@Setter
@Getter
public class CommentUpdateDto extends GenericDto {

    private String commentBody;

    @Builder(builderMethodName = "childBuilder")
    public CommentUpdateDto(Long id, String commentBody) {
        super(id);
        this.commentBody = commentBody;
    }

}
