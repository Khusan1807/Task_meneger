package uz.nb.simple_trello.reposiroty.project;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.nb.simple_trello.entity.project.ProjectMember;
import uz.nb.simple_trello.reposiroty.base.AbstractRepository;



public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Long>, AbstractRepository{
}
