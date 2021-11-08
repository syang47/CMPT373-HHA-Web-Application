package hha.website;

import hha.website.models.MSPPRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.persistence.ColumnResult;

@Repository
public interface MSPPRepository extends JpaRepository<MSPPRequirement, Integer> {
    MSPPRequirement findByid(Integer id);

    public List<MSPPRequirement> findByidAndDateSubmitted(Integer id, LocalDate date);
    
    
}
