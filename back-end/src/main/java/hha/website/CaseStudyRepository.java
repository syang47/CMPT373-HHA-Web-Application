package hha.website;
import hha.website.models.CaseStudy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

@Repository
public interface CaseStudyRepository extends JpaRepository<CaseStudy, Integer> {

    @Query("SELECT DISTINCT caseStudyType FROM CaseStudy")
    List<String> queryCaseStudyTypes();

    List<CaseStudy> findAll();

    Optional<CaseStudy> findByCaseStudyOfTheMonth(String month);

}
