package uz.nb.simple_trello.entity.task;

import lombok.Getter;
import lombok.Setter;
import uz.nb.simple_trello.entity.base.Auditable;
import uz.nb.simple_trello.entity.project.Project;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Task extends Auditable {

    @Column(nullable = false)
    private String name;

    private String description;


    private String level;

    private Long priority;

    @Column( nullable = false)
    private Long projectId;

    @Column(columnDefinition = " timestamp ")
    private LocalDateTime deadline;

    private boolean completed;
    private Long userId;


}
