package uz.nb.simple_trello.reposiroty.organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.nb.simple_trello.entity.organization.Organization;
import uz.nb.simple_trello.reposiroty.base.AbstractRepository;

import java.util.List;

public interface OrganizationRepository extends JpaRepository<Organization, Long>, AbstractRepository {

    List<Organization> findOrganizationById(Long id);

    @Query(value = "select * from Organization o order by o.id asc ", nativeQuery = true)
    List<Organization> findAllOrg();
}
