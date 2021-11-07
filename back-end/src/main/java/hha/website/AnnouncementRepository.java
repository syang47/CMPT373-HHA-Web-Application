package hha.website;

import hha.website.models.Announcement;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, String>{
    
    @Query("SELECT monthly FROM Announcement")
    List<String> queryMonthly();

    @Query("SELECT annual FROM Announcement")
    List<String> queryAnnually();
}
