package uz.nb.simple_trello.reposiroty.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.nb.simple_trello.dto.organization.OrganizationDto;
import uz.nb.simple_trello.dto.project.ProjectDto;
import uz.nb.simple_trello.entity.project.Project;
import uz.nb.simple_trello.reposiroty.base.AbstractRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long>, AbstractRepository {

    @Query("select u from Project u where u.organizationId=:id")
    List<Project> findPro(@Param("id") Long id);


}
