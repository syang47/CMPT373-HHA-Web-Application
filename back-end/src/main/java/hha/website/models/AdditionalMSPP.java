package hha.website.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import hha.website.HashMapConverter;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name="additionalMSPPData")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdditionalMSPP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(mappedBy = "additionalData", fetch = FetchType.LAZY)
    @JsonIgnore
    private MSPPRequirement msppRequirementData;

    @Lob
    @Convert(converter = HashMapConverter.class)
    private Map<String, Object> additionalMSPPData;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MSPPRequirement getMsppRequirementData() {
        return msppRequirementData;
    }

    public void setMsppRequirementData(MSPPRequirement msppRequirementData) {
        this.msppRequirementData = msppRequirementData;
    }

    public Map<String, Object> getAdditionalMSPPData() {
        return additionalMSPPData;
    }

    public void setAdditionalMSPPData(Map<String, Object> additionalMSPPData) {
        this.additionalMSPPData = additionalMSPPData;
    }
}
