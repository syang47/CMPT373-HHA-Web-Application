package hha.website;

import hha.website.models.DeadLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeadLineRepository extends JpaRepository<DeadLine,Integer> {
}
