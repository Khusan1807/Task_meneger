package uz.nb.simple_trello.entity.organization;

import lombok.Getter;
import lombok.Setter;
import uz.nb.simple_trello.entity.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;


@Getter
@Setter
@Entity
public class Organization extends Auditable {

    @Column(nullable = false, length = 100)
    private String name;

    private String logo;

    @Column(nullable = false, unique = true)
    private String gmail;

    @Column(unique = true, nullable = false)
    private String code;

    private String location;

    private Long owner;


}
