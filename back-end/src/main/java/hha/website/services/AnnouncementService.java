package hha.website.services;

import hha.website.AnnouncementRepository;
import hha.website.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import javax.transaction.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class AnnouncementService {

    @Autowired
    private AnnouncementRepository announcementRepository;

    public Announcement save(AnnouncementDTO data, MultipartFile monthlyPhoto) {
        Announcement entry = new Announcement();
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        entry.setDateSubmitted(Calendar.getInstance(timeZone));
        entry.setInfo(data.getMonthly());


        Optional<MultipartFile> monthlyPhotoBytes = Optional.ofNullable(monthlyPhoto);
        monthlyPhotoBytes.ifPresent(p -> {
            try{
                entry.setMonthlyPhoto(p.getBytes());
                entry.setMonthlyPhotoType(p.getContentType());
            } catch(IOException e) {
                e.printStackTrace();
            }
        });

        entry.setMonth(data.getMonth());
        return announcementRepository.save(entry);
    }

    public List<List<Object>> listMonthlyAnnouncements(String month) {
        List<List<Object>> monthlyAnnouncement = new ArrayList<>();
        for(Announcement a : announcementRepository.findByMonth(month)){
            List<Object> aData = new ArrayList<>();
            aData.add(a.getId());
            aData.add(a.getDateSubmitted().getTime().toString());
            aData.add(a.getMonth());
            aData.add(a.getMonthlyPhotoType());
            aData.add(a.getMonthlyPhoto());
            monthlyAnnouncement.add(aData);
        }
        return monthlyAnnouncement;
    }

    public void deleteAnAnnouncement(Integer id){
        Optional<Announcement> announcementToDelete = announcementRepository.findById(id);
        announcementToDelete.ifPresent(c -> announcementRepository.deleteById(id));
    }
}
