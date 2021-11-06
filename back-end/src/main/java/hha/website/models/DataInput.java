package hha.website.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
@Table(name="datainput")
public class DataInput{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column
    private String monthly;

    @Column 
    private String annual;

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