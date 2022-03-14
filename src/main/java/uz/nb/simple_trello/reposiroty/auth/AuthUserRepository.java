package uz.nb.simple_trello.reposiroty.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.nb.simple_trello.dto.auth.AuthUserDto;
import uz.nb.simple_trello.entity.auth.AuthUser;
import uz.nb.simple_trello.reposiroty.base.AbstractRepository;

import java.util.List;
import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long>, AbstractRepository {
    Optional<AuthUser> findAuthUserByUsername(String username);


    AuthUser findAuthUserById(Long id);

    @Query("from AuthUser a where  not a.role.id='1' order by a.id asc ")
    List<AuthUser> findAllUsers();

    @Query(value = "from AuthUser a where a.organizationId=:id and not a.id=:userId   order by a.id asc ")
    List<AuthUser> findAuthUsersByOrganizationId(@Param("id") Long id,  @Param("userId") Long userId);
}
