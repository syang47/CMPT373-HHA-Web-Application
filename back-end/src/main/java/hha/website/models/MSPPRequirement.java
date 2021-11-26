package hha.website.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import hha.website.HashMapConverter;
import net.bytebuddy.asm.Advice.Local;

import java.io.IOException;
import java.util.Calendar;
import java.util.Map;

import javax.persistence.*;

@Entity
@Table(name="MSPPData")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MSPPRequirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Calendar dateSubmitted;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private Department department;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "additionaldata_id", referencedColumnName = "id")
    @JsonIgnore
    private AdditionalMSPP additionalData;

    @Lob
    @Convert(converter = HashMapConverter.class)
    private Map<String, Object> requiredMSPPData;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(Calendar dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public AdditionalMSPP getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(AdditionalMSPP additionalData) {
        this.additionalData = additionalData;
    }

    public Map<String, Object> getRequiredMSPPData() {
        return requiredMSPPData;
    }

    public void setRequiredMSPPData(Map<String, Object> requiredMSPPData) {
        this.requiredMSPPData = requiredMSPPData;
    }
}
