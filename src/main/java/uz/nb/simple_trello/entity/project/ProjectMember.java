package uz.nb.simple_trello.entity.project;

import lombok.Getter;
import lombok.Setter;
import uz.nb.simple_trello.entity.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Table(name = "project_member", schema = "public")
public class ProjectMember extends Auditable {


    @Column(name = "project_id",nullable = false)
    private Long projectId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "is_lead")
    private Boolean lead;

}