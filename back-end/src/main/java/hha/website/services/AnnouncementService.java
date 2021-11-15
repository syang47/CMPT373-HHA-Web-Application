package hha.website.services;

import hha.website.AnnouncementRepository;
import hha.website.models.AnnouncementDTO;
import hha.website.models.Announcement;
import hha.website.models.MessageBoard;
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

    public Announcement save(AnnouncementDTO data, MultipartFile monthlyPhoto, MultipartFile annualPhoto) {
        Announcement entry = new Announcement();
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        entry.setDateSubmitted(Calendar.getInstance(timeZone));

        Optional<MultipartFile> annualPhotoBytes = Optional.ofNullable(annualPhoto);
        annualPhotoBytes.ifPresent(p -> {
            try{
                entry.setAnnualPhoto(p.getBytes());
                entry.setAnnualPhotoType(p.getContentType());
            } catch(IOException e) {
                e.printStackTrace();
            }
        });

        Optional<MultipartFile> monthlyPhotoBytes = Optional.ofNullable(monthlyPhoto);
        monthlyPhotoBytes.ifPresent(p -> {
            try{
                entry.setMonthlyPhoto(p.getBytes());
                entry.setMonthlyPhotoType(p.getContentType());
            } catch(IOException e) {
                e.printStackTrace();
            }
        });

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
