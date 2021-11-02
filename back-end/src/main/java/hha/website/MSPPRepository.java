package hha.website;

import hha.website.models.MSPPRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface MSPPRepository extends JpaRepository<MSPPRequirement, Integer> {
    //MSPPRequirement findByDepartment(String department);

    @Query("SELECT DISTINCT department FROM MSPPRequirement")
    Collection<String> queryDistinctField();
}
