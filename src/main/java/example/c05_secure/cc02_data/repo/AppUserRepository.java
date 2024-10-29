package example.c05_secure.cc02_data.repo;

import example.c05_secure.cc02_data.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findOneByUsername(String name);
}
