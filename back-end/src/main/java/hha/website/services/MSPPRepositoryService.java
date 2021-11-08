package hha.website.services;

import hha.website.MSPPRepository;
import hha.website.models.Department;
import hha.website.models.MSPPRequirement;
import hha.website.models.MSPPRequirementDTO;
import hha.website.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

@Service
@Transactional
public class MSPPRepositoryService {
    @Autowired
    private MSPPRepository msppRepository;
    @Autowired
    private HHADepartmentService hhaDepartmentService;

    public MSPPRequirement save(User user, MSPPRequirementDTO data) {
        MSPPRequirement entry = new MSPPRequirement();
        entry.setUser(user);
        entry.setDateSubmitted(LocalDate.now());
        // TimeZone timeZone = TimeZone.getTimeZone("GMT");
        // entry.setDateSubmitted(Calendar.getInstance(timeZone));

        entry.setBedDays(data.getBedDays());
        entry.setPatientDays(data.getPatientDays());
        entry.setHospitalized(data.getHospitalized());
        entry.setDischargedAlive(data.getDischargedAlive());
        entry.setDiedBefore48h(data.getDiedBefore48h());
        entry.setDiedAfter48h(data.getDiedAfter48h());
        entry.setDaysHospitalised(data.getDaysHospitalised());
        entry.setReferrals(data.getReferrals());
        entry.setTransfers(data.getTransfers());
        entry.setSelfDischarged(data.getSelfDischarged());
        entry.setStayedInTheWard(data.getStayedInTheWard());
        entry.setAdmissions(data.getAdmissions());
        entry.setBedsAvailable(data.getBedsAvailable());


        entry.setWeight_less_normal(data.getWeight_less_normal());
        entry.setWeight_less_cesarienne(data.getWeight_less_cesarienne());
        entry.setWeight_less_instrumentalse(data.getWeight_less_instrumentalse());
        entry.setWeight_within_normal(data.getWeight_within_normal());
        entry.setWeight_within_cesarienne(data.getWeight_within_cesarienne());
        entry.setWeight_within_instrumentalse(data.getWeight_within_instrumentalse());
        entry.setWeight_more_normal(data.getWeight_more_normal());
        entry.setWeight_more_cesarienne(data.getWeight_more_cesarienne());
        entry.setWeight_more_instrumentalse(data.getWeight_more_instrumentalse());
        entry.setVitamin_A(data.getVitamin_A());
        entry.setMUAC_210mm(data.getMUAC_210mm());
        entry.setMalnutrition(data.getMalnutrition());
        entry.setDomestic_visits(data.getDomestic_visits());
        entry.setPost_natal_first(data.getPost_natal_first());
        entry.setPost_natal_second(data.getPost_natal_second());
        entry.setPost_natal_third(data.getPost_natal_third());
        entry.setComplications_recorded(data.getComplications_recorded());
        entry.setComplications_referred(data.getComplications_referred());
        entry.setStillborns_maceres(data.getStillborns_maceres());
        entry.setStillborns_non_maceres(data.getStillborns_non_maceres());
        entry.setIn_hospital(data.getIn_hospital());
        entry.setIn_community(data.getIn_community());
        entry.setFirst_quarter_first_visit(data.getFirst_quarter_first_visit());
        entry.setFirst_quarter_second_visit(data.getFirst_quarter_second_visit());
        entry.setFirst_quarter_third_visit(data.getFirst_quarter_third_visit());
        entry.setFirst_quarter_fourth_visit(data.getFirst_quarter_fourth_visit());
        entry.setFirst_quarter_fifth_visit(data.getFirst_quarter_fifth_visit());
        entry.setFirst_quarter_total(data.getFirst_quarter_total());
        entry.setSecond_quarter_first_visit(data.getSecond_quarter_first_visit());
        entry.setSecond_quarter_second_visit(data.getSecond_quarter_second_visit());
        entry.setSecond_quarter_third_visit(data.getSecond_quarter_third_visit());
        entry.setSecond_quarter_fourth_visit(data.getSecond_quarter_fourth_visit());
        entry.setSecond_quarter_fifth_visit(data.getSecond_quarter_fifth_visit());
        entry.setSecond_quarter_total(data.getSecond_quarter_total());
        entry.setThird_quarter_first_visit(data.getThird_quarter_first_visit());
        entry.setThird_quarter_second_visit(data.getThird_quarter_second_visit());
        entry.setThird_quarter_third_visit(data.getThird_quarter_third_visit());
        entry.setThird_quarter_fourth_visit(data.getThird_quarter_fourth_visit());
        entry.setThird_quarter_fifth_visit(data.getThird_quarter_fifth_visit());
        entry.setThird_quarter_total(data.getThird_quarter_total());
        entry.setTotal_first_visit(data.getTotal_first_visit());
        entry.setTotal_second_visit(data.getTotal_second_visit());
        entry.setTotal_third_visit(data.getTotal_third_visit());
        entry.setTotal_fourth_visit(data.getTotal_fourth_visit());
        entry.setTotal_fifth_visit(data.getTotal_fifth_visit());
        entry.setTotal_total(data.getTotal_total());
        entry.setPregnancies_at_risk(data.getPregnancies_at_risk());
        entry.setAnemia_pregnant(data.getAnemia_pregnant());
        entry.setPregnant_iron_folates(data.getPregnant_iron_folates());
        entry.setPregnant_iron_deficiency_anemia(data.getPregnant_iron_deficiency_anemia());
        entry.setPregnant_birth_plan(data.getPregnant_birth_plan());
        entry.setPregnant_malaria_chloroquine(data.getPregnant_malaria_chloroquine());
        entry.setPregnant_mosquito_net(data.getPregnant_mosquito_net());
        entry.setPregnant_MUAC(data.getPregnant_MUAC());
        entry.setWomen_acetic_inspection(data.getWomen_acetic_inspection());
        entry.setWomen_smear_test(data.getWomen_smear_test());
        entry.setWomen_smear_take_care(data.getWomen_smear_take_care());
        entry.setWomen_postabortion(data.getWomen_postabortion());
        entry.setMother_age_less_than_fifteen_normal(data.getMother_age_less_than_fifteen_normal());
        entry.setMother_age_less_than_fifteen_cesarienne(data.getMother_age_less_than_fifteen_cesarienne());
        entry.setMother_age_less_than_fifteen_instrumentalse(data.getMother_age_less_than_fifteen_instrumentalse());
        entry.setMother_age_fifteen_to_nineteen_normal(data.getMother_age_fifteen_to_nineteen_normal());
        entry.setMother_age_fifteen_to_nineteen_cesarienne(data.getMother_age_fifteen_to_nineteen_cesarienne());
        entry.setMother_age_fifteen_to_nineteen_instrumentalse(data.getMother_age_fifteen_to_nineteen_instrumentalse());
        entry.setMother_age_twenty_to_twenty_four_normal(data.getMother_age_twenty_to_twenty_four_normal());
        entry.setMother_age_twenty_to_twenty_four_cesarienne(data.getMother_age_twenty_to_twenty_four_cesarienne());
        entry.setMother_age_twenty_to_twenty_four_instrumentalse(data.getMother_age_twenty_to_twenty_four_instrumentalse());
        entry.setMother_age_twenty_five_to_twenty_nine_normal(data.getMother_age_twenty_five_to_twenty_nine_normal());
        entry.setMother_age_twenty_five_to_twenty_nine_cesarienne(data.getMother_age_twenty_five_to_twenty_nine_cesarienne());
        entry.setMother_age_twenty_five_to_twenty_nine_instrumentalse(data.getMother_age_twenty_five_to_twenty_nine_instrumentalse());
        entry.setMother_age_thirty_plus_normal(data.getMother_age_thirty_plus_normal());
        entry.setMother_age_thirty_plus_cesarienne(data.getMother_age_thirty_plus_cesarienne());
        entry.setMother_age_thirty_plus_instrumentalse(data.getMother_age_thirty_plus_instrumentalse());
        entry.setMother_age_unknown_normal(data.getMother_age_unknown_normal());
        entry.setMother_age_unknown_cesarienne(data.getMother_age_unknown_cesarienne());
        entry.setMother_age_unknown_instrumentalse(data.getMother_age_unknown_instrumentalse());
        entry.setPartograph_normal(data.getPartograph_normal());
        entry.setPartograph_cesarienne(data.getPartograph_cesarienne());
        entry.setPartograph_instrumentalse(data.getPartograph_instrumentalse());
        entry.setLabor_normal(data.getLabor_normal());
        entry.setLabor_cesarienne(data.getLabor_cesarienne());
        entry.setLabor_instrumentalse(data.getLabor_instrumentalse());

        hhaDepartmentService.addASubmittedReport(user);
        System.out.println("entry saved");
        return msppRepository.save(entry);
    }

    public List<MSPPRequirement> listAllData() {
        return msppRepository.findAll();
    }

    public MSPPRequirement getAForm(Integer documentId) {
        return msppRepository.findByid(documentId);
    }

    public List<MSPPRequirement> listByIdAndDate(Integer id, LocalDate date) {
        return msppRepository.findByidAndDateSubmitted(id, date);
    }
    
    /*
    public Collection<String> listDistinctItemsInField() {
        return msppRepository.queryDistinctField();
    }*/
}
