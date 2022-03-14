package uz.nb.simple_trello.reposiroty.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.nb.simple_trello.entity.project.Project;
import uz.nb.simple_trello.entity.project.ProjectColumn;
import uz.nb.simple_trello.reposiroty.base.AbstractRepository;

import java.util.List;

public interface ProjectColumnRepository extends JpaRepository<ProjectColumn, Long>, AbstractRepository {

    @Query("select p from Project p where p.id = :project_id")
    Project findProject(Long project_id);

    @Query("select p from Project p where p.organizationId = :orgId")
    Project findProjectOrgId(Long orgId);

}
