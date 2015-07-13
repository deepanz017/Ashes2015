package peelu.satta.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import peelu.satta.persistence.entity.User;


/**
 * Created by dabroal on 12/07/15.
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
