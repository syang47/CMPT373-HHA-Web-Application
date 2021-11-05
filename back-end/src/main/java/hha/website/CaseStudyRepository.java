package hha.website;

import hha.website.models.CaseStudy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseStudyRepository extends JpaRepository<CaseStudy, Integer> {

}
