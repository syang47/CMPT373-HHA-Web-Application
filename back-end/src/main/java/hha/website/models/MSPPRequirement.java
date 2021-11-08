package hha.website.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.Calendar;

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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "additionaldata_id", referencedColumnName = "id")
    @JsonIgnore
    private AdditionalMSPP additionalData;

    @Column
    private Integer bedsAvailable;
    @Column
    private Integer bedDays;
    @Column
    private Integer patientDays;
    @Column
    private Integer hospitalized;
    @Column
    private Integer dischargedAlive;
    @Column
    private Integer diedBefore48h;
    @Column
    private Integer diedAfter48h;
    @Column
    private Integer daysHospitalised;
    @Column
    private Integer referrals;
    @Column
    private Integer transfers;
    @Column
    private Integer selfDischarged;
    @Column
    private Integer stayedInTheWard;
    @Column
    private Integer admissions;


    @Column
    private Integer weight_less_normal;
    @Column
    private Integer weight_less_cesarienne;
    @Column
    private Integer weight_less_instrumentalse;
    @Column
    private Integer weight_within_normal;
    @Column
    private Integer weight_within_cesarienne;
    @Column
    private Integer weight_within_instrumentalse;
    @Column
    private Integer weight_more_normal;
    @Column
    private Integer weight_more_cesarienne;
    @Column
    private Integer weight_more_instrumentalse;

    @Column
    private Integer Vitamin_A;
    @Column
    private Integer MUAC_210mm;
    @Column
    private Integer Malnutrition;
    @Column
    private Integer domestic_visits;
    @Column
    private Integer post_natal_first;
    @Column
    private Integer post_natal_second;
    @Column
    private Integer post_natal_third;
    @Column
    private Integer complications_recorded;
    @Column
    private Integer complications_referred;
    @Column
    private Integer stillborns_maceres;
    @Column
    private Integer stillborns_non_maceres;
    @Column
    private Integer in_hospital;
    @Column
    private Integer in_community;
    @Column
    private Integer first_quarter_first_visit;
    @Column
    private Integer first_quarter_second_visit;
    @Column
    private Integer first_quarter_third_visit;
    @Column
    private Integer first_quarter_fourth_visit;
    @Column
    private Integer first_quarter_fifth_visit;
    @Column
    private Integer first_quarter_total;
    @Column
    private Integer second_quarter_first_visit;
    @Column
    private Integer second_quarter_second_visit;
    @Column
    private Integer second_quarter_third_visit;
    @Column
    private Integer second_quarter_fourth_visit;
    @Column
    private Integer second_quarter_fifth_visit;
    @Column
    private Integer second_quarter_total;
    @Column
    private Integer third_quarter_first_visit;
    @Column
    private Integer third_quarter_second_visit;
    @Column
    private Integer third_quarter_third_visit;
    @Column
    private Integer third_quarter_fourth_visit;
    @Column
    private Integer third_quarter_fifth_visit;
    @Column
    private Integer third_quarter_total;
    @Column
    private Integer total_first_visit;
    @Column
    private Integer total_second_visit;
    @Column
    private Integer total_third_visit;
    @Column
    private Integer total_fourth_visit;
    @Column
    private Integer total_fifth_visit;
    @Column
    private Integer total_total;
    @Column
    private Integer pregnancies_at_risk;
    @Column
    private Integer anemia_pregnant;
    @Column
    private Integer pregnant_iron_folates;
    @Column
    private Integer pregnant_iron_deficiency_anemia;
    @Column
    private Integer pregnant_birth_plan;
    @Column
    private Integer pregnant_malaria_chloroquine;
    @Column
    private Integer pregnant_mosquito_net;
    @Column
    private Integer pregnant_MUAC;
    @Column
    private Integer women_acetic_inspection;
    @Column
    private Integer women_smear_test;
    @Column
    private Integer women_smear_take_care;
    @Column
    private Integer women_postabortion;
    @Column
    private Integer mother_age_less_than_fifteen_normal;
    @Column
    private Integer mother_age_less_than_fifteen_cesarienne;
    @Column
    private Integer mother_age_less_than_fifteen_instrumentalse;
    @Column
    private Integer mother_age_fifteen_to_nineteen_normal;
    @Column
    private Integer mother_age_fifteen_to_nineteen_cesarienne;
    @Column
    private Integer mother_age_fifteen_to_nineteen_instrumentalse;
    @Column
    private Integer mother_age_twenty_to_twenty_four_normal;
    @Column
    private Integer mother_age_twenty_to_twenty_four_cesarienne;
    @Column
    private Integer mother_age_twenty_to_twenty_four_instrumentalse;
    @Column
    private Integer mother_age_twenty_five_to_twenty_nine_normal;
    @Column
    private Integer mother_age_twenty_five_to_twenty_nine_cesarienne;
    @Column
    private Integer mother_age_twenty_five_to_twenty_nine_instrumentalse;
    @Column
    private Integer mother_age_thirty_plus_normal;
    @Column
    private Integer mother_age_thirty_plus_cesarienne;
    @Column
    private Integer mother_age_thirty_plus_instrumentalse;
    @Column
    private Integer mother_age_unknown_normal;
    @Column
    private Integer mother_age_unknown_cesarienne;
    @Column
    private Integer mother_age_unknown_instrumentalse;
    @Column
    private Integer partograph_normal;
    @Column
    private Integer partograph_cesarienne;
    @Column
    private Integer partograph_instrumentalse;
    @Column
    private Integer labor_normal;
    @Column
    private Integer labor_cesarienne;
    @Column
    private Integer labor_instrumentalse;


    public Integer getId() {
        return id;
    }

    public Calendar getDateSubmitted() {
        return dateSubmitted;
    }

    public User getUser() {
        return user;
    }

    public Integer getBedsAvailable() {
        return bedsAvailable;
    }

    public Integer getBedDays() {
        return bedDays;
    }

    public Integer getPatientDays() {
        return patientDays;
    }

    public Integer getHospitalized() {
        return hospitalized;
    }

    public Integer getDischargedAlive() {
        return dischargedAlive;
    }

    public Integer getDiedBefore48h() {
        return diedBefore48h;
    }

    public Integer getDiedAfter48h() {
        return diedAfter48h;
    }

    public Integer getDaysHospitalised() {
        return daysHospitalised;
    }

    public Integer getReferrals() {
        return referrals;
    }

    public Integer getTransfers() {
        return transfers;
    }

    public Integer getSelfDischarged() {
        return selfDischarged;
    }

    public Integer getStayedInTheWard() {
        return stayedInTheWard;
    }

    public Integer getAdmissions() {
        return admissions;
    }

    public Integer getWeight_less_normal() {
        return weight_less_normal;
    }

    public Integer getWeight_less_cesarienne() {
        return weight_less_cesarienne;
    }

    public Integer getWeight_less_instrumentalse() {
        return weight_less_instrumentalse;
    }

    public Integer getWeight_within_normal() {
        return weight_within_normal;
    }

    public Integer getWeight_within_cesarienne() {
        return weight_within_cesarienne;
    }

    public Integer getWeight_within_instrumentalse() {
        return weight_within_instrumentalse;
    }

    public Integer getWeight_more_normal() {
        return weight_more_normal;
    }

    public Integer getWeight_more_cesarienne() {
        return weight_more_cesarienne;
    }

    public Integer getWeight_more_instrumentalse() {
        return weight_more_instrumentalse;
    }

    public Integer getVitamin_A() {
        return Vitamin_A;
    }

    public Integer getMUAC_210mm() {
        return MUAC_210mm;
    }

    public Integer getMalnutrition() {
        return Malnutrition;
    }

    public Integer getDomestic_visits() {
        return domestic_visits;
    }

    public Integer getPost_natal_first() {
        return post_natal_first;
    }

    public Integer getPost_natal_second() {
        return post_natal_second;
    }

    public Integer getPost_natal_third() {
        return post_natal_third;
    }

    public Integer getComplications_recorded() {
        return complications_recorded;
    }

    public Integer getComplications_referred() {
        return complications_referred;
    }

    public Integer getStillborns_maceres() {
        return stillborns_maceres;
    }

    public Integer getStillborns_non_maceres() {
        return stillborns_non_maceres;
    }

    public Integer getIn_hospital() {
        return in_hospital;
    }

    public Integer getIn_community() {
        return in_community;
    }

    public Integer getFirst_quarter_first_visit() {
        return first_quarter_first_visit;
    }

    public Integer getFirst_quarter_second_visit() {
        return first_quarter_second_visit;
    }

    public Integer getFirst_quarter_third_visit() {
        return first_quarter_third_visit;
    }

    public Integer getFirst_quarter_fourth_visit() {
        return first_quarter_fourth_visit;
    }

    public Integer getFirst_quarter_fifth_visit() {
        return first_quarter_fifth_visit;
    }

    public Integer getFirst_quarter_total() {
        return first_quarter_total;
    }

    public Integer getSecond_quarter_first_visit() {
        return second_quarter_first_visit;
    }

    public Integer getSecond_quarter_second_visit() {
        return second_quarter_second_visit;
    }

    public Integer getSecond_quarter_third_visit() {
        return second_quarter_third_visit;
    }

    public Integer getSecond_quarter_fourth_visit() {
        return second_quarter_fourth_visit;
    }

    public Integer getSecond_quarter_fifth_visit() {
        return second_quarter_fifth_visit;
    }

    public Integer getSecond_quarter_total() {
        return second_quarter_total;
    }

    public Integer getThird_quarter_first_visit() {
        return third_quarter_first_visit;
    }

    public Integer getThird_quarter_second_visit() {
        return third_quarter_second_visit;
    }

    public Integer getThird_quarter_third_visit() {
        return third_quarter_third_visit;
    }

    public Integer getThird_quarter_fourth_visit() {
        return third_quarter_fourth_visit;
    }

    public Integer getThird_quarter_fifth_visit() {
        return third_quarter_fifth_visit;
    }

    public Integer getThird_quarter_total() {
        return third_quarter_total;
    }

    public Integer getTotal_first_visit() {
        return total_first_visit;
    }

    public Integer getTotal_second_visit() {
        return total_second_visit;
    }

    public Integer getTotal_third_visit() {
        return total_third_visit;
    }

    public Integer getTotal_fourth_visit() {
        return total_fourth_visit;
    }

    public Integer getTotal_fifth_visit() {
        return total_fifth_visit;
    }

    public Integer getTotal_total() {
        return total_total;
    }

    public Integer getPregnancies_at_risk() {
        return pregnancies_at_risk;
    }

    public Integer getAnemia_pregnant() {
        return anemia_pregnant;
    }

    public Integer getPregnant_iron_folates() {
        return pregnant_iron_folates;
    }

    public Integer getPregnant_iron_deficiency_anemia() {
        return pregnant_iron_deficiency_anemia;
    }

    public Integer getPregnant_birth_plan() {
        return pregnant_birth_plan;
    }

    public Integer getPregnant_malaria_chloroquine() {
        return pregnant_malaria_chloroquine;
    }

    public Integer getPregnant_mosquito_net() {
        return pregnant_mosquito_net;
    }

    public Integer getPregnant_MUAC() {
        return pregnant_MUAC;
    }

    public Integer getWomen_acetic_inspection() {
        return women_acetic_inspection;
    }

    public Integer getWomen_smear_test() {
        return women_smear_test;
    }

    public Integer getWomen_smear_take_care() {
        return women_smear_take_care;
    }

    public Integer getWomen_postabortion() {
        return women_postabortion;
    }

    public Integer getMother_age_less_than_fifteen_normal() {
        return mother_age_less_than_fifteen_normal;
    }

    public Integer getMother_age_less_than_fifteen_cesarienne() {
        return mother_age_less_than_fifteen_cesarienne;
    }

    public Integer getMother_age_less_than_fifteen_instrumentalse() {
        return mother_age_less_than_fifteen_instrumentalse;
    }

    public Integer getMother_age_fifteen_to_nineteen_normal() {
        return mother_age_fifteen_to_nineteen_normal;
    }

    public Integer getMother_age_fifteen_to_nineteen_cesarienne() {
        return mother_age_fifteen_to_nineteen_cesarienne;
    }

    public Integer getMother_age_fifteen_to_nineteen_instrumentalse() {
        return mother_age_fifteen_to_nineteen_instrumentalse;
    }

    public Integer getMother_age_twenty_to_twenty_four_normal() {
        return mother_age_twenty_to_twenty_four_normal;
    }

    public Integer getMother_age_twenty_to_twenty_four_cesarienne() {
        return mother_age_twenty_to_twenty_four_cesarienne;
    }

    public Integer getMother_age_twenty_to_twenty_four_instrumentalse() {
        return mother_age_twenty_to_twenty_four_instrumentalse;
    }

    public Integer getMother_age_twenty_five_to_twenty_nine_normal() {
        return mother_age_twenty_five_to_twenty_nine_normal;
    }

    public Integer getMother_age_twenty_five_to_twenty_nine_cesarienne() {
        return mother_age_twenty_five_to_twenty_nine_cesarienne;
    }

    public Integer getMother_age_twenty_five_to_twenty_nine_instrumentalse() {
        return mother_age_twenty_five_to_twenty_nine_instrumentalse;
    }

    public Integer getMother_age_thirty_plus_normal() {
        return mother_age_thirty_plus_normal;
    }

    public Integer getMother_age_thirty_plus_cesarienne() {
        return mother_age_thirty_plus_cesarienne;
    }

    public Integer getMother_age_thirty_plus_instrumentalse() {
        return mother_age_thirty_plus_instrumentalse;
    }

    public Integer getMother_age_unknown_normal() {
        return mother_age_unknown_normal;
    }

    public Integer getMother_age_unknown_cesarienne() {
        return mother_age_unknown_cesarienne;
    }

    public Integer getMother_age_unknown_instrumentalse() {
        return mother_age_unknown_instrumentalse;
    }

    public Integer getPartograph_normal() {
        return partograph_normal;
    }

    public Integer getPartograph_cesarienne() {
        return partograph_cesarienne;
    }

    public Integer getPartograph_instrumentalse() {
        return partograph_instrumentalse;
    }

    public Integer getLabor_normal() {
        return labor_normal;
    }

    public Integer getLabor_cesarienne() {
        return labor_cesarienne;
    }

    public Integer getLabor_instrumentalse() {
        return labor_instrumentalse;
    }

    public void setDateSubmitted(Calendar dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBedsAvailable(Integer bedsAvailable) {
        this.bedsAvailable = bedsAvailable;
    }

    public void setBedDays(Integer bedDays) {
        this.bedDays = bedDays;
    }

    public void setPatientDays(Integer patientDays) {
        this.patientDays = patientDays;
    }

    public void setHospitalized(Integer hospitalized) {
        this.hospitalized = hospitalized;
    }

    public void setDischargedAlive(Integer dischargedAlive) {
        this.dischargedAlive = dischargedAlive;
    }

    public void setDiedBefore48h(Integer diedBefore48h) {
        this.diedBefore48h = diedBefore48h;
    }

    public void setDiedAfter48h(Integer diedAfter48h) {
        this.diedAfter48h = diedAfter48h;
    }

    public void setDaysHospitalised(Integer daysHospitalised) {
        this.daysHospitalised = daysHospitalised;
    }

    public void setReferrals(Integer referrals) {
        this.referrals = referrals;
    }

    public void setTransfers(Integer transfers) {
        this.transfers = transfers;
    }

    public void setSelfDischarged(Integer selfDischarged) {
        this.selfDischarged = selfDischarged;
    }

    public void setStayedInTheWard(Integer stayedInTheWard) {
        this.stayedInTheWard = stayedInTheWard;
    }

    public void setAdmissions(Integer admissions) {
        this.admissions = admissions;
    }


    public void setWeight_less_normal(Integer weight_less_normal) {
        this.weight_less_normal = weight_less_normal;
    }

    public void setWeight_less_cesarienne(Integer weight_less_cesarienne) {
        this.weight_less_cesarienne = weight_less_cesarienne;
    }

    public void setWeight_less_instrumentalse(Integer weight_less_instrumentalse) {
        this.weight_less_instrumentalse = weight_less_instrumentalse;
    }

    public void setWeight_within_normal(Integer weight_within_normal) {
        this.weight_within_normal = weight_within_normal;
    }

    public void setWeight_within_cesarienne(Integer weight_within_cesarienne) {
        this.weight_within_cesarienne = weight_within_cesarienne;
    }

    public void setWeight_within_instrumentalse(Integer weight_within_instrumentalse) {
        this.weight_within_instrumentalse = weight_within_instrumentalse;
    }

    public void setWeight_more_normal(Integer weight_more_normal) {
        this.weight_more_normal = weight_more_normal;
    }

    public void setWeight_more_cesarienne(Integer weight_more_cesarienne) {
        this.weight_more_cesarienne = weight_more_cesarienne;
    }

    public void setWeight_more_instrumentalse(Integer weight_more_instrumentalse) {
        this.weight_more_instrumentalse = weight_more_instrumentalse;
    }

    public void setVitamin_A(Integer vitamin_A) {
        Vitamin_A = vitamin_A;
    }

    public void setMUAC_210mm(Integer MUAC_210mm) {
        this.MUAC_210mm = MUAC_210mm;
    }

    public void setMalnutrition(Integer malnutrition) {
        Malnutrition = malnutrition;
    }

    public void setDomestic_visits(Integer domestic_visits) {
        this.domestic_visits = domestic_visits;
    }

    public void setPost_natal_first(Integer post_natal_first) {
        this.post_natal_first = post_natal_first;
    }

    public void setPost_natal_second(Integer post_natal_second) {
        this.post_natal_second = post_natal_second;
    }

    public void setPost_natal_third(Integer post_natal_third) {
        this.post_natal_third = post_natal_third;
    }

    public void setComplications_recorded(Integer complications_recorded) {
        this.complications_recorded = complications_recorded;
    }

    public void setComplications_referred(Integer complications_referred) {
        this.complications_referred = complications_referred;
    }

    public void setStillborns_maceres(Integer stillborns_maceres) {
        this.stillborns_maceres = stillborns_maceres;
    }

    public void setStillborns_non_maceres(Integer stillborns_non_maceres) {
        this.stillborns_non_maceres = stillborns_non_maceres;
    }

    public void setIn_hospital(Integer in_hospital) {
        this.in_hospital = in_hospital;
    }

    public void setIn_community(Integer in_community) {
        this.in_community = in_community;
    }

    public void setFirst_quarter_first_visit(Integer first_quarter_first_visit) {
        this.first_quarter_first_visit = first_quarter_first_visit;
    }

    public void setFirst_quarter_second_visit(Integer first_quarter_second_visit) {
        this.first_quarter_second_visit = first_quarter_second_visit;
    }

    public void setFirst_quarter_third_visit(Integer first_quarter_third_visit) {
        this.first_quarter_third_visit = first_quarter_third_visit;
    }

    public void setFirst_quarter_fourth_visit(Integer first_quarter_fourth_visit) {
        this.first_quarter_fourth_visit = first_quarter_fourth_visit;
    }

    public void setFirst_quarter_fifth_visit(Integer first_quarter_fifth_visit) {
        this.first_quarter_fifth_visit = first_quarter_fifth_visit;
    }

    public void setFirst_quarter_total(Integer first_quarter_total) {
        this.first_quarter_total = first_quarter_total;
    }

    public void setSecond_quarter_first_visit(Integer second_quarter_first_visit) {
        this.second_quarter_first_visit = second_quarter_first_visit;
    }

    public void setSecond_quarter_second_visit(Integer second_quarter_second_visit) {
        this.second_quarter_second_visit = second_quarter_second_visit;
    }

    public void setSecond_quarter_third_visit(Integer second_quarter_third_visit) {
        this.second_quarter_third_visit = second_quarter_third_visit;
    }

    public void setSecond_quarter_fourth_visit(Integer second_quarter_fourth_visit) {
        this.second_quarter_fourth_visit = second_quarter_fourth_visit;
    }

    public void setSecond_quarter_fifth_visit(Integer second_quarter_fifth_visit) {
        this.second_quarter_fifth_visit = second_quarter_fifth_visit;
    }

    public void setSecond_quarter_total(Integer second_quarter_total) {
        this.second_quarter_total = second_quarter_total;
    }

    public void setThird_quarter_first_visit(Integer third_quarter_first_visit) {
        this.third_quarter_first_visit = third_quarter_first_visit;
    }

    public void setThird_quarter_second_visit(Integer third_quarter_second_visit) {
        this.third_quarter_second_visit = third_quarter_second_visit;
    }

    public void setThird_quarter_third_visit(Integer third_quarter_third_visit) {
        this.third_quarter_third_visit = third_quarter_third_visit;
    }

    public void setThird_quarter_fourth_visit(Integer third_quarter_fourth_visit) {
        this.third_quarter_fourth_visit = third_quarter_fourth_visit;
    }

    public void setThird_quarter_fifth_visit(Integer third_quarter_fifth_visit) {
        this.third_quarter_fifth_visit = third_quarter_fifth_visit;
    }

    public void setThird_quarter_total(Integer third_quarter_total) {
        this.third_quarter_total = third_quarter_total;
    }

    public void setTotal_first_visit(Integer total_first_visit) {
        this.total_first_visit = total_first_visit;
    }

    public void setTotal_second_visit(Integer total_second_visit) {
        this.total_second_visit = total_second_visit;
    }

    public void setTotal_third_visit(Integer total_third_visit) {
        this.total_third_visit = total_third_visit;
    }

    public void setTotal_fourth_visit(Integer total_fourth_visit) {
        this.total_fourth_visit = total_fourth_visit;
    }

    public void setTotal_fifth_visit(Integer total_fifth_visit) {
        this.total_fifth_visit = total_fifth_visit;
    }

    public void setTotal_total(Integer total_total) {
        this.total_total = total_total;
    }

    public void setPregnancies_at_risk(Integer pregnancies_at_risk) {
        this.pregnancies_at_risk = pregnancies_at_risk;
    }

    public void setAnemia_pregnant(Integer anemia_pregnant) {
        this.anemia_pregnant = anemia_pregnant;
    }

    public void setPregnant_iron_folates(Integer pregnant_iron_folates) {
        this.pregnant_iron_folates = pregnant_iron_folates;
    }

    public void setPregnant_iron_deficiency_anemia(Integer pregnant_iron_deficiency_anemia) {
        this.pregnant_iron_deficiency_anemia = pregnant_iron_deficiency_anemia;
    }

    public void setPregnant_birth_plan(Integer pregnant_birth_plan) {
        this.pregnant_birth_plan = pregnant_birth_plan;
    }

    public void setPregnant_malaria_chloroquine(Integer pregnant_malaria_chloroquine) {
        this.pregnant_malaria_chloroquine = pregnant_malaria_chloroquine;
    }

    public void setPregnant_mosquito_net(Integer pregnant_mosquito_net) {
        this.pregnant_mosquito_net = pregnant_mosquito_net;
    }

    public void setPregnant_MUAC(Integer pregnant_MUAC) {
        this.pregnant_MUAC = pregnant_MUAC;
    }

    public void setWomen_acetic_inspection(Integer women_acetic_inspection) {
        this.women_acetic_inspection = women_acetic_inspection;
    }

    public void setWomen_smear_test(Integer women_smear_test) {
        this.women_smear_test = women_smear_test;
    }

    public void setWomen_smear_take_care(Integer women_smear_take_care) {
        this.women_smear_take_care = women_smear_take_care;
    }

    public void setWomen_postabortion(Integer women_postabortion) {
        this.women_postabortion = women_postabortion;
    }

    public void setMother_age_less_than_fifteen_normal(Integer mother_age_less_than_fifteen_normal) {
        this.mother_age_less_than_fifteen_normal = mother_age_less_than_fifteen_normal;
    }

    public void setMother_age_less_than_fifteen_cesarienne(Integer mother_age_less_than_fifteen_cesarienne) {
        this.mother_age_less_than_fifteen_cesarienne = mother_age_less_than_fifteen_cesarienne;
    }

    public void setMother_age_less_than_fifteen_instrumentalse(Integer mother_age_less_than_fifteen_instrumentalse) {
        this.mother_age_less_than_fifteen_instrumentalse = mother_age_less_than_fifteen_instrumentalse;
    }

    public void setMother_age_fifteen_to_nineteen_normal(Integer mother_age_fifteen_to_nineteen_normal) {
        this.mother_age_fifteen_to_nineteen_normal = mother_age_fifteen_to_nineteen_normal;
    }

    public void setMother_age_fifteen_to_nineteen_cesarienne(Integer mother_age_fifteen_to_nineteen_cesarienne) {
        this.mother_age_fifteen_to_nineteen_cesarienne = mother_age_fifteen_to_nineteen_cesarienne;
    }

    public void setMother_age_fifteen_to_nineteen_instrumentalse(Integer mother_age_fifteen_to_nineteen_instrumentalse) {
        this.mother_age_fifteen_to_nineteen_instrumentalse = mother_age_fifteen_to_nineteen_instrumentalse;
    }

    public void setMother_age_twenty_to_twenty_four_normal(Integer mother_age_twenty_to_twenty_four_normal) {
        this.mother_age_twenty_to_twenty_four_normal = mother_age_twenty_to_twenty_four_normal;
    }

    public void setMother_age_twenty_to_twenty_four_cesarienne(Integer mother_age_twenty_to_twenty_four_cesarienne) {
        this.mother_age_twenty_to_twenty_four_cesarienne = mother_age_twenty_to_twenty_four_cesarienne;
    }

    public void setMother_age_twenty_to_twenty_four_instrumentalse(Integer mother_age_twenty_to_twenty_four_instrumentalse) {
        this.mother_age_twenty_to_twenty_four_instrumentalse = mother_age_twenty_to_twenty_four_instrumentalse;
    }

    public void setMother_age_twenty_five_to_twenty_nine_normal(Integer mother_age_twenty_five_to_twenty_nine_normal) {
        this.mother_age_twenty_five_to_twenty_nine_normal = mother_age_twenty_five_to_twenty_nine_normal;
    }

    public void setMother_age_twenty_five_to_twenty_nine_cesarienne(Integer mother_age_twenty_five_to_twenty_nine_cesarienne) {
        this.mother_age_twenty_five_to_twenty_nine_cesarienne = mother_age_twenty_five_to_twenty_nine_cesarienne;
    }

    public void setMother_age_twenty_five_to_twenty_nine_instrumentalse(Integer mother_age_twenty_five_to_twenty_nine_instrumentalse) {
        this.mother_age_twenty_five_to_twenty_nine_instrumentalse = mother_age_twenty_five_to_twenty_nine_instrumentalse;
    }

    public void setMother_age_thirty_plus_normal(Integer mother_age_thirty_plus_normal) {
        this.mother_age_thirty_plus_normal = mother_age_thirty_plus_normal;
    }

    public void setMother_age_thirty_plus_cesarienne(Integer mother_age_thirty_plus_cesarienne) {
        this.mother_age_thirty_plus_cesarienne = mother_age_thirty_plus_cesarienne;
    }

    public void setMother_age_thirty_plus_instrumentalse(Integer mother_age_thirty_plus_instrumentalse) {
        this.mother_age_thirty_plus_instrumentalse = mother_age_thirty_plus_instrumentalse;
    }

    public void setMother_age_unknown_normal(Integer mother_age_unknown_normal) {
        this.mother_age_unknown_normal = mother_age_unknown_normal;
    }

    public void setMother_age_unknown_cesarienne(Integer mother_age_unknown_cesarienne) {
        this.mother_age_unknown_cesarienne = mother_age_unknown_cesarienne;
    }

    public void setMother_age_unknown_instrumentalse(Integer mother_age_unknown_instrumentalse) {
        this.mother_age_unknown_instrumentalse = mother_age_unknown_instrumentalse;
    }

    public void setPartograph_normal(Integer partograph_normal) {
        this.partograph_normal = partograph_normal;
    }

    public void setPartograph_cesarienne(Integer partograph_cesarienne) {
        this.partograph_cesarienne = partograph_cesarienne;
    }

    public void setPartograph_instrumentalse(Integer partograph_instrumentalse) {
        this.partograph_instrumentalse = partograph_instrumentalse;
    }

    public void setLabor_normal(Integer labor_normal) {
        this.labor_normal = labor_normal;
    }

    public void setLabor_cesarienne(Integer labor_cesarienne) {
        this.labor_cesarienne = labor_cesarienne;
    }

    public void setLabor_instrumentalse(Integer labor_instrumentalse) {
        this.labor_instrumentalse = labor_instrumentalse;
    }


}
