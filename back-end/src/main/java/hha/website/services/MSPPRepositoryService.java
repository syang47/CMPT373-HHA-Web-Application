package hha.website.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hha.website.AdditionalMSPPRepository;
import hha.website.MSPPRepository;
import hha.website.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.*;

@Service
@Transactional
public class MSPPRepositoryService {
    @Autowired
    private MSPPRepository msppRepository;
    @Autowired
    private HHADepartmentService hhaDepartmentService;
    @Autowired
    private AdditionalMSPPRepository additionalMSPPRepository;

    public String save(User user, String requiredMSPPDataJson, String additionalDataJson) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        MSPPRequirement entry = new MSPPRequirement();
        Map<String, Object> data;
        try {
            data = objectMapper.readValue(requiredMSPPDataJson, Map.class);
            Optional<Department> dep = hhaDepartmentService.loadDepartmentByDepartmentName(data.remove("department").toString());
            dep.ifPresent(entry::setDepartment);
            entry.setRequiredMSPPData(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw e;
        }

        entry.setUser(user);
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        entry.setDateSubmitted(Calendar.getInstance(timeZone));

        hhaDepartmentService.addASubmittedReport(user);



        AdditionalMSPP additionalData = new AdditionalMSPP();
        additionalData.setMsppRequirementData(entry);
        try {
            data = objectMapper.readValue(additionalDataJson, Map.class);
            additionalData.setAdditionalMSPPData(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw e;
        }
        System.out.println("additional entry saved");
        additionalMSPPRepository.save(additionalData);


        entry.setAdditionalData(additionalData);
        System.out.println("required entry saved");
        msppRepository.save(entry);
        return "saved";
    }

    public List<MSPPRequirement> listAllData() {
        return msppRepository.findAll();
    }

    public MSPPRequirement getAForm(Integer documentId) {
        return msppRepository.findById(documentId).get();
    }

    public List<MSPPRequirement> listByIdAndDate(Integer id, Calendar date) {
        return msppRepository.findByidAndDateSubmitted(id, date);
    }
    
    public List<List<Object>> listAllMsppData() {
        List<List<Object>> msppData = new ArrayList<>();
        for(MSPPRequirement d : msppRepository.findAll()) {
            List<Object> dData = new ArrayList<>();
            dData.add(d.getId());
            dData.add(d.getDateSubmitted().getTime().toString());
            dData.add(d.getUser().getUsername());
            dData.add(d.getDepartment());
            dData.add(d.getAdditionalData());
            dData.add(d.getRequiredMSPPData());
            msppData.add(dData);
        }
        return msppData;
    }

    public void deleteForm(Integer documentId){
        System.out.println("form deleted");
        msppRepository.deleteById(documentId);
    }

    public MSPPRequirement editRequiredForm(Integer documentId, String requiredMSPPDataJson) throws JsonProcessingException{
        Optional<MSPPRequirement> requiredFormToUpdate = msppRepository.findById(documentId);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> data;
        try {
            data = objectMapper.readValue(requiredMSPPDataJson, Map.class);
            requiredFormToUpdate.get().setRequiredMSPPData(data);
            return requiredFormToUpdate.get();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
