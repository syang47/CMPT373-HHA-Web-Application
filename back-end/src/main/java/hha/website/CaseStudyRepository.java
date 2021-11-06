package hha.website;
import hha.website.models.CaseStudy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.Collection;

@Repository
public interface CaseStudyRepository extends JpaRepository<CaseStudy, Integer> {
    CaseStudy findByTitle(String casestudytitle);
    
    @Query("SELECT DISTINCT title FROM CaseStudy")
    Collection<String> queryDistinctField();

    @Query("SELECT MAX(d.points) FROM CaseStudy d")
    Collection<Integer> queryBestCasestudy();
    
    @Query("SELECT DISTINCT d.status FROM CaseStudy d")
    Collection<Boolean> querySubmissionStatus();

    @Query("SELECT COUNT(d.title) FROM CaseStudy d")
    Collection<Integer> queryTotalReportsField();
}
