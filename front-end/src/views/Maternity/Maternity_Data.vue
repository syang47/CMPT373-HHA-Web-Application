<template>
    <DynamicForm :schema="formSchema" :department="department" :formTitle="formTitle"/>
</template>

<script lang="ts" type="text/typescript">
import { defineComponent } from 'vue'
import * as yup from "yup";
import DynamicForm from '@/components/DynamicForm.vue';
export default defineComponent({
    name: "Maternity_Data",
    components: {
        DynamicForm,
    },
    data() {
            
        const r: any = yup.number().min(0, "Cannot be negative. / Ne peut pas être négatif.").required("Required. / Obligatoire.");
        const a: any = yup.number().min(0, "Cannot be negative. / Ne peut pas être négatif.");
        const formSchema: any = {
            fields: [
                {
                    label: 'msppData.bedsAvailable',
                    name: 'bedsAvailable',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'msppData.bedDays',
                    name: 'bedDays',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'msppData.patientDays',
                    name: 'patientDays',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'msppData.hospitalised',
                    name: 'hospitalised',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'msppData.dischargedAlive',
                    name: 'dischargedAlive',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'msppData.diedBefore48h',
                    name: 'diedBefore48h',
                    as: 'input',
                    rules: r,
                    patientBeforeM: 1
                },
                {
                    label: 'msppData.diedAfter48h',
                    name: 'diedAfter48h',
                    as: 'input',
                    rules: r,
                    patientAfterM: 1
                },
                {
                    label: 'msppData.daysHospitalised',
                    name: 'daysHospitalized',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'msppData.referrals',
                    name: 'referrals',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'msppData.transfers',
                    name: 'transfers',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'msppData.reasonSelfDischarge',
                    name: 'selfDischarged',
                    as: 'input',
                    rules: r,
                    children: [
                        {
                            label: 'msppData.financeCare',
                            name: 'financeCannotAfford',
                            as: 'input',
                            rules: a,
                        },
                        {
                            label: 'msppData.financeAvoidPay',
                            name: 'financeAvoidPay',
                            as: 'input',
                            rules: a,
                        },
                        {
                            label: 'msppData.religiousCultural',
                            name: 'reasonCultural',
                            as: 'input',
                            rules: a,
                        },
                        {
                            label: 'msppData.personalFamily',
                            name: 'reasonPersonal',
                            as: 'input',
                            rules: a,
                        },
                        {
                            label: 'msppData.other',
                            name: 'otherReason',
                            as: 'input',
                            rules: a,
                        },
                    ]
                },
                {
                    label: 'msppData.stayedInTheWard',
                    name: 'stayedInTheWard',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'msppData.admissions',
                    name: 'admissions',
                    as: 'input',
                    rules: r,
                    children: [
                        {
                            header: 'msppData.wherePatientsComeFrom'
                        },
                        {
                            label: 'msppData.quMo',
                            name: 'fromQuarterMorin',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.capHai',
                            name: 'fromCapHaitian',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.deptNord',
                            name: 'fromDepartmentNord',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.otherDept',
                            name: 'fromOther',
                            as: 'input',
                            rules: yup.string()
                        },
                    ]
                },
                {
                    header: "msppData.births",
                },
                {
                    th: ["msppData.births", "msppData.normal", "msppData.cesarean", "msppData.instruments"],
                    rows: [
                        [
                            {
                                rowName: "msppData.weight1_5",
                            },
                            {
                                name: 'weight_less_normal',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'weight_less_cesarienne',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'weight_less_instrumentalse',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.weight1_5To2_5",
                            },
                            {
                                name: 'weight_within_normal',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'weight_within_cesarienne',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'weight_within_instrumentalse',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.weight2_5Up",
                            },
                            {
                                name: 'weight_more_normal',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'weight_more_cesarienne',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'weight_more_instrumentalse',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.notWeighed",
                            },
                            {
                                name: 'not_weighted_normal',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'not_weighted_cesarienne',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'not_weighted_instrumentalse',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.immediatelyBreastfed",
                            },
                            {
                                name: 'immediately_breastfed_normal',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'immediately_breastfed_cesarienne',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'immediately_breastfed_instrumentalse',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.skinToSkinTherapy",
                            },
                            {
                                name: 'skin_therapy_normal',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'skin_therapy_cesarienne',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'skin_therapy_instrumentalse',
                                as: 'input',
                                rules: r,
                            },
                        ],
                    ]
                },
                {
                    header: "msppData.postNatal",
                },
                {
                    label: 'msppData.breastfeeding_WomenVitA',
                    name: 'breastfeeding_WomenVitA',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'msppData.breastfeeding_WomenMUAC',
                    name: 'breastfeeding_WomenMUAC',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'msppData.breastfeeding_WomenMalnutrition',
                    name: 'breastfeeding_WomenMalnutrition',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'msppData.domesticVisits',
                    name: 'domesticVisits',
                    as: 'input',
                    rules: r,
                },
                {
                    th: ["msppData.blank", "msppData.hours0_6", "msppData.hoursDays7_6", "msppData.days7_42"],
                    rows: [
                        [
                            {
                                rowName: "msppData.postNatalConsultations",
                            },
                            {
                                name: 'post_natal_first',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'post_natal_second',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'post_natal_third',
                                as: 'input',
                                rules: r,
                            },
                        ],
                    ]
                },
                {
                    header: 'msppData.complications'
                },
                {
                    label: 'msppData.compRec',
                    name: 'complications_recorded',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'msppData.compRef',
                    name: 'complications_referred',
                    as: 'input',
                    rules: r,
                },
                {
                    header: 'msppData.numberOfStillborns'
                },
                {
                    label: 'msppData.macerated',
                    name: 'stillborns_maceres',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'msppData.notMacerated',
                    name: 'stillborns_non_maceres',
                    as: 'input',
                    rules: r,
                },
                {
                    header: 'msppData.maternalDeathInTheHospital'
                },
                {
                    label: 'msppData.inHospital',
                    name: 'inHospital',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'msppData.inTheCommunity',
                    name: 'inTheCommunity',
                    as: 'input',
                    rules: r,
                },
                {
                    header: 'msppData.supportForWifeAndMother'
                },
                {
                    th: ["msppData.periodOfPregnancy", "msppData.visit1", "msppData.visit2", "msppData.visit3", "msppData.visit4", "msppData.visit5Up", "msppData.total"],
                    rows: [
                        [
                            {
                                rowName: "msppData.months0_3",
                            },
                            {
                                name: 'first_quarter_first_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'first_quarter_second_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'first_quarter_third_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'first_quarter_fourth_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'first_quarter_fifth_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'first_quarter_total',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.months4_6",
                            },
                            {
                                name: 'second_quarter_first_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'second_quarter_second_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'second_quarter_third_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'second_quarter_fourth_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'second_quarter_fifth_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'second_quarter_total',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.months7_9",
                            },
                            {
                                name: 'third_quarter_first_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'third_quarter_second_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'third_quarter_third_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'third_quarter_fourth_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'third_quarter_fifth_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'third_quarter_total',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.totalVisits",
                            },
                            {
                                name: 'total_first_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'total_second_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'total_third_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'total_fourth_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'total_fifth_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'total_total',
                                as: 'input',
                                rules: r,
                            },
                        ]
                    ]
                },
                {
                    header: 'msppData.supportForWomenHospital'
                },
                {
                    label: 'msppData.numberOfPregnanciesAtRisk',
                    name: 'pregnancies_at_risk',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'msppData.caseAnemia',
                    name: 'anemia_pregnant',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'msppData.pWIronFolate',
                    name: 'pregnant_iron_folates',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'msppData.pWIronDef',
                    name: 'pregnant_iron_deficiency_anemia',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'msppData.pWBirthPlan',
                    name: 'pregnant_birth_plan',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'msppData.pWMalaria',
                    name: 'pregnant_malaria_chloroquine',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'msppData.pWMosquito',
                    name: 'pregnant_mosquito_net',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'msppData.pWMuac',
                    name: 'pregnant_MUAC',
                    as: 'input',
                    rules: r,
                },
                {
                    header: 'msppData.otherServices'
                },
                {
                    label: 'msppData.wIronFolate',
                    name: 'women_iron_folate',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'msppData.wAceticAcid',
                    name: 'women_acetic_inspection',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'msppData.wSmearTest',
                    name: 'women_smear_test',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'msppData.wSmearTakenCare',
                    name: 'women_smear_take_care',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'msppData.wPostabortion',
                    name: 'women_postabortion',
                    as: 'input',
                    rules: r,
                },
                {
                    header:'msppData.deliveries'
                },
                {
                    th: ["msppData.ageOfMothers", "msppData.normal", "msppData.cesarean", "msppData.instruments"],
                    rows: [
                        [
                            {
                                rowName: "msppData.years15",
                            },
                            {
                                name: 'mother_age_less_than_fifteen_normal',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'mother_age_less_than_fifteen_cesarienne',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'mother_age_less_than_fifteen_instrumentalse',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.years15_19",
                            },
                            {
                                name: 'mother_age_fifteen_to_nineteen_normal',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'mother_age_fifteen_to_nineteen_cesarienne',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'mother_age_fifteen_to_nineteen_instrumentalse',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.years20_24",
                            },
                            {
                                name: 'mother_age_twenty_to_twenty_four_normal',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'mother_age_twenty_to_twenty_four_cesarienne',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'mother_age_twenty_to_twenty_four_instrumentalse',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.years25_29",
                            },
                            {
                                name: 'mother_age_twenty_five_to_twenty_nine_normal',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'mother_age_twenty_five_to_twenty_nine_cesarienne',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'mother_age_twenty_five_to_twenty_nine_instrumentalse',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.years30Up",
                            },
                            {
                                name: 'mother_age_thirty_plus_normal',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'mother_age_thirty_plus_cesarienne',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'mother_age_thirty_plus_instrumentalse',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.unknown",
                            },
                            {
                                name: 'mother_age_unknown_normal',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'mother_age_unknown_cesarienne',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'mother_age_unknown_instrumentalse',
                                as: 'input',
                                rules: r,
                            },
                        ],
                    ]
                },
                {
                    header:'msppData.deliveries'
                },
                {
                    th: ["msppData.labourManagement", "msppData.normal", "msppData.cesarean", "msppData.instruments"],
                    rows: [
                        [
                            {
                                rowName: "msppData.useOfPartograph",
                            },
                            {
                                name: 'partograph_normal',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'partograph_cesarienne',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'partograph_instrumentalse',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.managementLabour3rdYear",
                            },
                            {
                                name: 'labor_normal',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'labor_cesarienne',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'labor_instrumentalse',
                                as: 'input',
                                rules: r,
                            },
                        ],
                    ]
                },
                {
                    header: 'msppData.mainCond'
                },
                {
                    label: 'msppData.uncomplicatedLabour',
                    name: 'uncomplicatedLabour',
                    as: 'input',
                    rules: a,
                },
                {
                    label: 'msppData.heartFailure',
                    name: 'heartFailure',
                    as: 'input',
                    rules: a,
                },
                {
                    label: 'msppData.preEclampsia',
                    name: 'preEclampsia',
                    as: 'input',
                    rules: a,
                },
                {
                    label: 'msppData.respiratoryProblems',
                    name: 'respiratoryProblems',
                    as: 'input',
                    rules: a,
                },
                {
                    label: 'msppData.cSectionSiteInfection',
                    name: 'cSectionSiteInfection',
                    as: 'input',
                    rules: a,
                },
                {
                    label: 'msppData.otherMedical',
                    name: 'otherMedical',
                    as: 'input',
                    rules: a,
                },
                {
                    label: 'msppData.trauma',
                    name: 'trauma',
                    as: 'input',
                    rules: a,
                },
            ]
        }
        return {
            formSchema,
            department: "maternity",
            formTitle: 'msppData.maternityForm'
        };
    }
});
</script>
