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
            
        const r: any = yup.number().min(0, "Cannot be negative.").required("Required.");
        const a: any = yup.number().min(0, "Cannot be negative.");
        const formSchema: any = {
            fields: [
                {
                    label: 'bedsAvailable',
                    name: 'bedsAvailable',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'bedDays',
                    name: 'bedDays',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'patientDays',
                    name: 'patientDays',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'hospitalized',
                    name: 'hospitalized',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'dischargedAlive',
                    name: 'dischargedAlive',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'diedBefore48h',
                    name: 'diedBefore48h',
                    as: 'input',
                    rules: r,
                    patient: 1
                },
                {
                    label: 'diedAfter48h',
                    name: 'diedAfter48h',
                    as: 'input',
                    rules: r,
                    patient: 1
                },
                {
                    label: 'daysHospitalized',
                    name: 'daysHospitalized',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'referrals',
                    name: 'referrals',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'transfers',
                    name: 'transfers',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'selfDischarged',
                    name: 'selfDischarged',
                    as: 'input',
                    rules: r,
                    children: [
                        {
                            label: 'financeCannotAfford',
                            name: 'financeCannotAfford',
                            as: 'input',
                            rules: a,
                        },
                        {
                            label: 'financeAvoidPay',
                            name: 'financeAvoidPay',
                            as: 'input',
                            rules: a,
                        },
                        {
                            label: 'reasonCultural',
                            name: 'reasonCultural',
                            as: 'input',
                            rules: a,
                        },
                        {
                            label: 'reasonPersonal',
                            name: 'reasonPersonal',
                            as: 'input',
                            rules: a,
                        },
                        {
                            label: 'otherReason',
                            name: 'otherReason',
                            as: 'input',
                            rules: a,
                        },
                    ]
                },
                {
                    label: 'stayedInTheWard',
                    name: 'stayedInTheWard',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'admissions',
                    name: 'admissions',
                    as: 'input',
                    rules: r,
                    children: [
                        {
                            header: 'wherePatientsComeFrom'
                        },
                        {
                            label: 'fromQuarterMorin',
                            name: 'fromQuarterMorin',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'fromCapHaitian',
                            name: 'fromCapHaitian',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'fromDepartmentNord',
                            name: 'fromDepartmentNord',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'fromOther',
                            name: 'fromOther',
                            as: 'input',
                            rules: yup.string()
                        },
                    ]
                },
                {
                    header: "births",
                },
                {
                    th: ["births", "normal", "cesarean", "instruments"],
                    rows: [
                        [
                            {
                                rowName: "weight1_5",
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
                                rowName: "weight1_5To2_5",
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
                                rowName: "weight2_5Up",
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
                                rowName: "notWeighted",
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
                                rowName: "immediatelyBreastfed",
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
                                rowName: "skinToSkinTherapy",
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
                    header: "postNatal",
                },
                {
                    label: 'bFWomenVitA',
                    name: 'bFWomenVitA',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'bFWomenMUAC',
                    name: 'bFWomenMUAC',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'bFWomenMalnutrition',
                    name: 'bFWomenMalnutrition',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'domesticVisits',
                    name: 'domesticVisits',
                    as: 'input',
                    rules: r,
                },
                {
                    th: ["", "hours0_6", "hoursDays7_6", "days7_42"],
                    rows: [
                        [
                            {
                                rowName: "postNatalConsultations",
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
                    header: 'complications'
                },
                {
                    label: 'compRec',
                    name: 'compRec',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'compRef',
                    name: 'compRef',
                    as: 'input',
                    rules: r,
                },
                {
                    header: 'numberOfStillborns'
                },
                {
                    label: 'macerated',
                    name: 'macerated',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'notMacerated',
                    name: 'notMacerated',
                    as: 'input',
                    rules: r,
                },
                {
                    header: 'maternalDeathInTheHospital'
                },
                {
                    label: 'inHospital',
                    name: 'inHospital',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'inTheCommunity',
                    name: 'inTheCommunity',
                    as: 'input',
                    rules: r,
                },
                {
                    header: 'supportForWifeAndMother'
                },
                {
                    th: ["periodOfPregnancy", "visit1", "visit2", "visit3", "visit4", "visit5Up", "total"],
                    rows: [
                        [
                            {
                                rowName: "months0_3",
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
                                rowName: "months4_6",
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
                                rowName: "months7_9",
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
                                rowName: "totalVisits",
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
                    header: 'supportForWomenHospital'
                },
                {
                    label: 'numberOfPregnanciesAtRisk',
                    name: 'numberOfPregnanciesAtRisk',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'caseAnemia',
                    name: 'caseAnemia',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'pWIronFolate',
                    name: 'pWIronFolate',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'pWIronDef',
                    name: 'pWIronDef',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'pWBirthPlan',
                    name: 'pWBirthPlan',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'pWMalaria',
                    name: 'pWMalaria',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'pWMosquito',
                    name: 'pWMosquito',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'pWMUAC',
                    name: 'pWMUAC',
                    as: 'input',
                    rules: r,
                },
                {
                    header: 'otherServices'
                },
                {
                    label: 'wIronFolate',
                    name: 'wIronFolate',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'wAceticAcid',
                    name: 'wAceticAcid',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'wSmearTest',
                    name: 'wSmearTest',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'wSmearTakenCare',
                    name: 'wSmearTakenCare',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'wPostabortion',
                    name: 'wPostabortion',
                    as: 'input',
                    rules: r,
                },
                {
                    header:'deliveries'
                },
                {
                    th: ["ageOfMothers", "normal", "cesarean", "instruments"],
                    rows: [
                        [
                            {
                                rowName: "years15",
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
                                rowName: "years15_19",
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
                                rowName: "years20_24",
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
                                rowName: "years25_29",
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
                                rowName: "years30Up",
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
                                rowName: "unknown",
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
                    header:'deliveries'
                },
                {
                    th: ["labourManagement", "normal", "cesarean", "instruments"],
                    rows: [
                        [
                            {
                                rowName: "useOfPartograph",
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
                                rowName: "managementLabour3rdYear",
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
                    header: 'Main Condition of Patient'
                },
                {
                    label: 'uncomplicatedLabour',
                    name: 'uncomplicatedLabour',
                    as: 'input',
                    rules: a,
                },
                {
                    label: 'heartFailure',
                    name: 'heartFailure',
                    as: 'input',
                    rules: a,
                },
                {
                    label: 'preEclampsia',
                    name: 'preEclampsia',
                    as: 'input',
                    rules: a,
                },
                {
                    label: 'respiratoryProblems',
                    name: 'respiratoryProblems',
                    as: 'input',
                    rules: a,
                },
                {
                    label: 'cSectionSiteInfection',
                    name: 'cSectionSiteInfection',
                    as: 'input',
                    rules: a,
                },
                {
                    label: 'otherMedical',
                    name: 'otherMedical',
                    as: 'input',
                    rules: a,
                },
                {
                    label: 'trauma',
                    name: 'trauma',
                    as: 'input',
                    rules: a,
                },
            ]
        }
        return {
            formSchema,
            department: "maternity",
            formTitle: 'msppData.rehabForm'
        };
    }
});
</script>