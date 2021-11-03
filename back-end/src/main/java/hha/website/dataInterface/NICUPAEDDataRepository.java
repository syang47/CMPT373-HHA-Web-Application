package hha.website.dataInterface;

import hha.website.models.datainput.NICUPAEDData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface NICUPAEDDataRepository extends JpaRepository<NICUPAEDData, Integer> {
}

