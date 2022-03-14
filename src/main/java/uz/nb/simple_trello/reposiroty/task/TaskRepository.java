package uz.nb.simple_trello.reposiroty.task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.nb.simple_trello.dto.task.TaskCreateDto;
import uz.nb.simple_trello.dto.task.TaskDto;
import uz.nb.simple_trello.entity.organization.Organization;
import uz.nb.simple_trello.entity.task.Task;
import uz.nb.simple_trello.reposiroty.base.AbstractRepository;

import java.beans.BeanProperty;
import java.util.List;
import java.util.Optional;

/**
 * @Author Husan Narzullayev
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long>, AbstractRepository {

    List<Task> findTasksByProjectId(Long id);


    List<Task> findTasksByUserId(Long id);



}
