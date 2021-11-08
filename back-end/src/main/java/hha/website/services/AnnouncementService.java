package hha.website.services;

import hha.website.AnnouncementRepository;
import hha.website.models.AnnouncementDTO;
import hha.website.models.Announcement;
import hha.website.models.MessageBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.TimeZone;
import javax.transaction.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class AnnouncementService {

    @Autowired
    private AnnouncementRepository announcementRepository;

    public Announcement save(AnnouncementDTO data) {
        Announcement entry = new Announcement();
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        entry.setDateSubmitted(Calendar.getInstance(timeZone));
        entry.setAnnual(data.getAnnual());
        entry.setMonthly(data.getMonthly());
        return announcementRepository.save(entry);
    }
    public List<String> listAField(String field) {
        if(field.equals("monthly")) {
            return announcementRepository.queryMonthly();
        } else if(field.equals("annual")) {
            return announcementRepository.queryAnnually();
        }
        return null;
    }
}
