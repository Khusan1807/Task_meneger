package uz.nb.simple_trello.entity.comment;

import lombok.Getter;
import lombok.Setter;
import uz.nb.simple_trello.entity.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Setter
@Getter
@Entity
public class Comment extends Auditable {

    @Column(nullable = false)
    private String commentBode;

   @Column(name = "task_id", nullable = false)
    private Long task_id;


   @Column(name = "type_id", nullable = false)
    private Long commentType;

}
