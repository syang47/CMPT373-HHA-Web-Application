package hha.website;

import hha.website.models.CaseStudy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseStudyRepository extends JpaRepository<CaseStudy, Integer> {

    @Query("SELECT DISTINCT caseStudyType FROM CaseStudy")
    List<String> queryCaseStudyTypes();
}
