package hha.website;

import hha.website.models.MSPPRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MSPPRepository extends JpaRepository<MSPPRequirement, Integer> {
    MSPPRequirement findByDepartment(String department);

}
