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
        // const diedBefore48hSchema = yup.object().shape({
        //     diedBefore48hPatient: yup
        //         .array()
        //         .of(
        //         yup.object().shape({
        //             diedBefore48hAge: yup
        //                 .number()
        //                 .min(0, "Cannot be negative.")
        //                 .required("Required.")
        //                 .default(0),
        //             diedBefore48hCause: yup
        //                 .string()
        //                 .required("Required.")
        //                 .default(""),
        //         })
        //     )
        //     .strict(),
        // });
        // const diedAfter48hSchema= yup.object().shape({
        //     diedAfter48hPatient: yup
        //         .array()
        //         .of(
        //         yup.object().shape({
        //             diedAfter48hAge: yup
        //                 .number()
        //                 .min(0, "Cannot be negative.")
        //                 .required("Required.")
        //                 .default(0),
        //             diedAfter48hCause: yup
        //                 .string()
        //                 .required("Required.")
        //                 .default(""),
        //         })
        //     )
        //     .strict(),
        // });
        // const dataSchema = yup.object().shape({
            
        //     weight_less_normal: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     weight_less_cesarienne: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     weight_less_instrumentalse: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     weight_within_normal: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     weight_within_cesarienne: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     weight_within_instrumentalse: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     weight_more_normal: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     weight_more_cesarienne: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     weight_more_instrumentalse: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     Vitamin_A: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     MUAC_210mm: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     Malnutrition: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     domestic_visits: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     post_natal_first: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     post_natal_second: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     post_natal_third: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     complications_recorded: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     complications_referred: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     stillborns_maceres: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     stillborns_non_maceres: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     in_hospital: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     in_community: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     first_quarter_first_visit: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     first_quarter_second_visit: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     first_quarter_third_visit: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     first_quarter_fourth_visit: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     first_quarter_fifth_visit: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     first_quarter_total: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     second_quarter_first_visit: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     second_quarter_second_visit: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     second_quarter_third_visit: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     second_quarter_fourth_visit: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     second_quarter_fifth_visit: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     second_quarter_total: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     third_quarter_first_visit: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     third_quarter_second_visit: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     third_quarter_third_visit: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     third_quarter_fourth_visit: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     third_quarter_fifth_visit: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     third_quarter_total: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     total_first_visit: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     total_second_visit: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     total_third_visit: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     total_fourth_visit: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     total_fifth_visit: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     total_total: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     pregnancies_at_risk: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     anemia_pregnant: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     pregnant_iron_folates: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     pregnant_iron_deficiency_anemia: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     pregnant_birth_plan: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     pregnant_malaria_chloroquine: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     pregnant_mosquito_net: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     pregnant_MUAC: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     women_acetic_inspection: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     women_smear_test: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     women_smear_take_care: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     women_postabortion: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     mother_age_less_than_fifteen_normal: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     mother_age_less_than_fifteen_cesarienne: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     mother_age_less_than_fifteen_instrumentalse: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     mother_age_fifteen_to_nineteen_normal: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     mother_age_fifteen_to_nineteen_cesarienne: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     mother_age_fifteen_to_nineteen_instrumentalse: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     mother_age_twenty_to_twenty_four_normal: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     mother_age_twenty_to_twenty_four_cesarienne: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     mother_age_twenty_to_twenty_four_instrumentalse: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     mother_age_twenty_five_to_twenty_nine_normal: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     mother_age_twenty_five_to_twenty_nine_cesarienne: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     mother_age_twenty_five_to_twenty_nine_instrumentalse: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     mother_age_thirty_plus_normal: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     mother_age_thirty_plus_cesarienne: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     mother_age_thirty_plus_instrumentalse: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     mother_age_unknown_normal: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     mother_age_unknown_cesarienne: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     mother_age_unknown_instrumentalse: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     partograph_normal: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     partograph_cesarienne: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     partograph_instrumentalse: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     labor_normal: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     labor_cesarienne: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     labor_instrumentalse: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),

        //     uncomplicatedLabour: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     heartFailure: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     preEclampsia: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     respiratoryProblems: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     cSectionSiteInfection: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     otherMedical: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),
        //     trauma: yup
        //         .number()
        //         .min(0, "Cannot be negative.")
        //         .required("Required.")
        //         .default(0),

            
        const r: any = yup.number().min(0, "Cannot be negative.").required("Required.");
        const a: any = yup.number().min(0, "Cannot be negative.");
        const formSchema = {
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
                },
                {
                    label: 'diedAfter48h',
                    name: 'diedAfter48h',
                    as: 'input',
                    rules: r,
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
                                label: 'weight_less_normal',
                                name: 'weight_less_normal',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'weight_less_cesarienne',
                                name: 'weight_less_cesarienne',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'weight_less_instrumentalse',
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
                                label: 'weight_within_normal',
                                name: 'weight_within_normal',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'weight_within_cesarienne',
                                name: 'weight_within_cesarienne',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'weight_within_instrumentalse',
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
                                label: 'weight_more_normal',
                                name: 'weight_more_normal',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'weight_more_cesarienne',
                                name: 'weight_more_cesarienne',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'weight_more_instrumentalse',
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
                                label: 'not_weighted_normal',
                                name: 'not_weighted_normal',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'not_weighted_cesarienne',
                                name: 'not_weighted_cesarienne',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'not_weighted_instrumentalse',
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
                                label: 'immediately_breastfed_normal',
                                name: 'immediately_breastfed_normal',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'immediately_breastfed_cesarienne',
                                name: 'immediately_breastfed_cesarienne',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'immediately_breastfed_instrumentalse',
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
                                label: 'skin_therapy_normal',
                                name: 'skin_therapy_normal',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'skin_therapy_cesarienne',
                                name: 'skin_therapy_cesarienne',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'skin_therapy_instrumentalse',
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
                                label: 'post_natal_first',
                                name: 'post_natal_first',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'post_natal_second',
                                name: 'post_natal_second',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'post_natal_third',
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
                                label: 'first_quarter_first_visit',
                                name: 'first_quarter_first_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'first_quarter_second_visit',
                                name: 'first_quarter_second_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'first_quarter_third_visit',
                                name: 'first_quarter_third_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'first_quarter_fourth_visit',
                                name: 'first_quarter_fourth_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'first_quarter_fifth_visit',
                                name: 'first_quarter_fifth_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'first_quarter_total',
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
                                label: 'second_quarter_first_visit',
                                name: 'second_quarter_first_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'second_quarter_second_visit',
                                name: 'second_quarter_second_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'second_quarter_third_visit',
                                name: 'second_quarter_third_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'second_quarter_fourth_visit',
                                name: 'second_quarter_fourth_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'second_quarter_fifth_visit',
                                name: 'second_quarter_fifth_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'second_quarter_total',
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
                                label: 'third_quarter_first_visit',
                                name: 'third_quarter_first_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'third_quarter_second_visit',
                                name: 'third_quarter_second_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'third_quarter_third_visit',
                                name: 'third_quarter_third_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'third_quarter_fourth_visit',
                                name: 'third_quarter_fourth_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'third_quarter_fifth_visit',
                                name: 'third_quarter_fifth_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'third_quarter_total',
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
                                label: 'total_first_visit',
                                name: 'total_first_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'total_second_visit',
                                name: 'total_second_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'total_third_visit',
                                name: 'total_third_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'total_fourth_visit',
                                name: 'total_fourth_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'total_fifth_visit',
                                name: 'total_fifth_visit',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'total_total',
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
                                label: 'mother_age_less_than_fifteen_normal',
                                name: 'mother_age_less_than_fifteen_normal',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'mother_age_less_than_fifteen_cesarienne',
                                name: 'mother_age_less_than_fifteen_cesarienne',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'mother_age_less_than_fifteen_instrumentalse',
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
                                label: 'mother_age_fifteen_to_nineteen_normal',
                                name: 'mother_age_fifteen_to_nineteen_normal',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'mother_age_fifteen_to_nineteen_cesarienne',
                                name: 'mother_age_fifteen_to_nineteen_cesarienne',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'mother_age_fifteen_to_nineteen_instrumentalse',
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
                                label: 'mother_age_twenty_to_twenty_four_normal',
                                name: 'mother_age_twenty_to_twenty_four_normal',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'mother_age_twenty_to_twenty_four_cesarienne',
                                name: 'mother_age_twenty_to_twenty_four_cesarienne',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'mother_age_twenty_to_twenty_four_instrumentalse',
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
                                label: 'mother_age_twenty_five_to_twenty_nine_normal',
                                name: 'mother_age_twenty_five_to_twenty_nine_normal',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'mother_age_twenty_five_to_twenty_nine_cesarienne',
                                name: 'mother_age_twenty_five_to_twenty_nine_cesarienne',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'mother_age_twenty_five_to_twenty_nine_instrumentalse',
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
                                label: 'mother_age_thirty_plus_normal',
                                name: 'mother_age_thirty_plus_normal',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'mother_age_thirty_plus_cesarienne',
                                name: 'mother_age_thirty_plus_cesarienne',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'mother_age_thirty_plus_instrumentalse',
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
                                label: 'mother_age_unknown_normal',
                                name: 'mother_age_unknown_normal',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'mother_age_unknown_cesarienne',
                                name: 'mother_age_unknown_cesarienne',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'mother_age_unknown_instrumentalse',
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
                                label: 'partograph_normal',
                                name: 'partograph_normal',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'partograph_cesarienne',
                                name: 'partograph_cesarienne',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'partograph_instrumentalse',
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
                                label: 'labor_normal',
                                name: 'labor_normal',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'labor_cesarienne',
                                name: 'labor_cesarienne',
                                as: 'input',
                                rules: r,
                            },
                            {
                                label: 'labor_instrumentalse',
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
                    rules: r,
                },
                {
                    label: 'heartFailure',
                    name: 'heartFailure',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'preEclampsia',
                    name: 'preEclampsia',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'respiratoryProblems',
                    name: 'respiratoryProblems',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'cSectionSiteInfection',
                    name: 'cSectionSiteInfection',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'otherMedical',
                    name: 'otherMedical',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'trauma',
                    name: 'trauma',
                    as: 'input',
                    rules: r,
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