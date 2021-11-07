package hha.website;

import hha.website.models.AdditionalMSPP;
import hha.website.models.MSPPRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalMSPPRepository extends JpaRepository<AdditionalMSPP, Integer> {
    AdditionalMSPP findBymsppRequirementData(MSPPRequirement msppRequirementData);
}
