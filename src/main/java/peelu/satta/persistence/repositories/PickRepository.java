package peelu.satta.persistence.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import peelu.satta.persistence.entity.Pick;

public interface PickRepository extends JpaRepository<Pick, Long> {
    Pick findByUserIdAndMatchId(Long userId, Long matchId);
}
