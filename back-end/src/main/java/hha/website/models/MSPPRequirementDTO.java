package hha.website.models;

import javax.persistence.Column;

public class MSPPRequirementDTO {

    private Integer bedDays;
    private Integer patientDays;
    private Integer hospitalized;
    private Integer dischargedAlive;
    private Integer diedBefore48h;
    private Integer diedAfter48h;
    private Integer daysHospitalised;
    private Integer referrals;
    private Integer transfers;
    private Integer selfDischarged;
    private Integer stayedInTheWard;
    private Integer admissions;
    private Integer bedsAvailable;


    private Integer weight_less_normal;
    private Integer weight_less_cesarienne;
    private Integer weight_less_instrumentalse;
    private Integer weight_within_normal;
    private Integer weight_within_cesarienne;
    private Integer weight_within_instrumentalse;
    private Integer weight_more_normal;
    private Integer weight_more_cesarienne;
    private Integer weight_more_instrumentalse;
    private Integer Vitamin_A;
    private Integer MUAC_210mm;
    private Integer Malnutrition;
    private Integer domestic_visits;
    private Integer post_natal_first;
    private Integer post_natal_second;
    private Integer post_natal_third;
    private Integer complications_recorded;
    private Integer complications_referred;
    private Integer stillborns_maceres;
    private Integer stillborns_non_maceres;
    private Integer in_hospital;
    private Integer in_community;
    private Integer first_quarter_first_visit;
    private Integer first_quarter_second_visit;
    private Integer first_quarter_third_visit;
    private Integer first_quarter_fourth_visit;
    private Integer first_quarter_fifth_visit;
    private Integer first_quarter_total;
    private Integer second_quarter_first_visit;
    private Integer second_quarter_second_visit;
    private Integer second_quarter_third_visit;
    private Integer second_quarter_fourth_visit;
    private Integer second_quarter_fifth_visit;
    private Integer second_quarter_total;
    private Integer third_quarter_first_visit;
    private Integer third_quarter_second_visit;
    private Integer third_quarter_third_visit;
    private Integer third_quarter_fourth_visit;
    private Integer third_quarter_fifth_visit;
    private Integer third_quarter_total;
    private Integer total_first_visit;
    private Integer total_second_visit;
    private Integer total_third_visit;
    private Integer total_fourth_visit;
    private Integer total_fifth_visit;
    private Integer total_total;
    private Integer pregnancies_at_risk;
    private Integer anemia_pregnant;
    private Integer pregnant_iron_folates;
    private Integer pregnant_iron_deficiency_anemia;
    private Integer pregnant_birth_plan;
    private Integer pregnant_malaria_chloroquine;
    private Integer pregnant_mosquito_net;
    private Integer pregnant_MUAC;
    private Integer women_acetic_inspection;
    private Integer women_smear_test;
    private Integer women_smear_take_care;
    private Integer women_postabortion;
    private Integer mother_age_less_than_fifteen_normal;
    private Integer mother_age_less_than_fifteen_cesarienne;
    private Integer mother_age_less_than_fifteen_instrumentalse;
    private Integer mother_age_fifteen_to_nineteen_normal;
    private Integer mother_age_fifteen_to_nineteen_cesarienne;
    private Integer mother_age_fifteen_to_nineteen_instrumentalse;
    private Integer mother_age_twenty_to_twenty_four_normal;
    private Integer mother_age_twenty_to_twenty_four_cesarienne;
    private Integer mother_age_twenty_to_twenty_four_instrumentalse;
    private Integer mother_age_twenty_five_to_twenty_nine_normal;
    private Integer mother_age_twenty_five_to_twenty_nine_cesarienne;
    private Integer mother_age_twenty_five_to_twenty_nine_instrumentalse;
    private Integer mother_age_thirty_plus_normal;
    private Integer mother_age_thirty_plus_cesarienne;
    private Integer mother_age_thirty_plus_instrumentalse;
    private Integer mother_age_unknown_normal;
    private Integer mother_age_unknown_cesarienne;
    private Integer mother_age_unknown_instrumentalse;
    private Integer partograph_normal;
    private Integer partograph_cesarienne;
    private Integer partograph_instrumentalse;
    private Integer labor_normal;
    private Integer labor_cesarienne;
    private Integer labor_instrumentalse;

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
}
