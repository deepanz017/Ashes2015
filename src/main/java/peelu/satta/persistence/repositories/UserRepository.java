package peelu.satta.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import peelu.satta.persistence.entity.User;



public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
    public User findById(Long id);
}
