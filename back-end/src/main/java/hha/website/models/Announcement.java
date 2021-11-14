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
    private String monthly;

    @Column 
    private String annual;

    @Lob
    @Column
    private byte[] monthlyPhoto;

    @Lob
    @Column
    private byte[] annualPhoto;

    @Column
    private String monthlyPhotoType;

    @Column
    private String annualPhotoType;

    public Calendar getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(Calendar dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public String getMonthly(){
        return monthly;
    }
    public void setMonthly(String monthly){
        this.monthly = monthly;
    }

    public String getAnnual(){
        return annual;
    }
    public void setAnnual(String annual){
        this.annual = annual;
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

    public byte[] getAnnualPhoto() {
        return annualPhoto;
    }

    public void setAnnualPhoto(byte[] annualPhoto) {
        this.annualPhoto = annualPhoto;
    }

    public String getMonthlyPhotoType() {
        return monthlyPhotoType;
    }

    public void setMonthlyPhotoType(String monthlyPhotoType) {
        this.monthlyPhotoType = monthlyPhotoType;
    }

    public String getAnnualPhotoType() {
        return annualPhotoType;
    }

    public void setAnnualPhotoType(String annualPhotoType) {
        this.annualPhotoType = annualPhotoType;
    }
}