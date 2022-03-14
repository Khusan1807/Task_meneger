package uz.nb.simple_trello.entity.auth;

import lombok.Getter;
import lombok.Setter;
import uz.nb.simple_trello.entity.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class AuthPermission extends Auditable {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;

}
