package uz.nb.simple_trello.reposiroty.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.nb.simple_trello.entity.auth.AuthRole;

import java.util.Optional;

public interface AuthRoleRepository extends JpaRepository<AuthRole, Long> {
    Optional<AuthRole> getAuthRoleById(Long id);

}
