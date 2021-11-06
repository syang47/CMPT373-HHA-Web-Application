package hha.website;

import hha.website.models.DataInput;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DataInputRepository extends JpaRepository<DataInput, String>{
    @Query("SELECT d.monthly FROM DataInput d")
    Collection<String> queryMonthlyItem();

    @Query("SELECT d.annual FROM DataInput d")
    Collection<String> queryAnnualItem();
    
    @Query("SELECT d.monthly, d.annual FROM DataInput d")
    Collection<String> queryAllItem();
}
