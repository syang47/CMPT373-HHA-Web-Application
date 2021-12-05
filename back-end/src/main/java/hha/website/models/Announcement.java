package hha.website.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="announcements")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Calendar dateSubmitted;

    @Column
    private String info;

    @Column
    private String month;

    @Lob
    @Column
    private byte[] monthlyPhoto;

    @Column
    private String monthlyPhotoType;

    public Calendar getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(Calendar dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public String getMonth(){
        return month;
    }

    public void setMonth(String month){
        this.month = month;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getMonthlyPhoto() {
        return monthlyPhoto;
    }

    public void setMonthlyPhoto(byte[] monthlyPhoto) {
        this.monthlyPhoto = monthlyPhoto;
    }

    public String getMonthlyPhotoType() {
        return monthlyPhotoType;
    }

    public void setMonthlyPhotoType(String monthlyPhotoType) {
        this.monthlyPhotoType = monthlyPhotoType;
    }
}