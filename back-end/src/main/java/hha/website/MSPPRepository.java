package hha.website;

import hha.website.models.MSPPRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface MSPPRepository extends JpaRepository<MSPPRequirement, Integer> {
    //MSPPRequirement findByDepartment(String department);

    @Query("SELECT DISTINCT department FROM MSPPRequirement")
    Collection<String> queryDistinctField();

    List<MSPPRequirement> findAll();
}
