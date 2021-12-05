package hha.website;

import hha.website.models.MSPPRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;

@Repository
public interface MSPPRepository extends JpaRepository<MSPPRequirement, Integer> {

    List<MSPPRequirement> findByidAndDateSubmitted(Integer id, Calendar date);
    List<MSPPRequirement> findAdditionalDataById(Integer id);
    List<MSPPRequirement> findRequiredMSPPDataById(Integer id);

}
