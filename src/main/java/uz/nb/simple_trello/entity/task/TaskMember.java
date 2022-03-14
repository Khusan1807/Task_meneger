package uz.nb.simple_trello.entity.task;

import lombok.Getter;
import lombok.Setter;
import uz.nb.simple_trello.entity.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Setter
@Getter
@Entity
public class TaskMember extends Auditable {

    @Column(name = "column_id", nullable = false)
    private Long task_id;

    @Column(name = "user_id", nullable = false)
    private Long userId;


}
