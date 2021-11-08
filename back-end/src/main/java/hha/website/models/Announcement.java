package hha.website.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="announcements")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Calendar dateSubmitted;

    @Column
    private String monthly;

    @Column 
    private String annual;

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


}