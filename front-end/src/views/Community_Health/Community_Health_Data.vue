<style>

    .background {
        height: 100%;
        position: absolute;
        width: 100%;
        overflow: auto;
    }

</style>

<template>
    <DynamicForm :schema="formSchema" :department="department" :formTitle="formTitle"/>
</template>

<script lang="ts" type="text/typescript">

import { defineComponent } from 'vue'
import * as yup from "yup";
import DynamicForm from '@/components/DynamicForm.vue';
export default defineComponent({
    name: "Community_Health_Data",
    components: {
        DynamicForm
    },
    data() {
        const r: any = yup.number().min(0, "Cannot be negative. / Ne peut pas être négatif.").required("Required. / Obligatoire.");
        const a: any = yup.number().min(0, "Cannot be negative. / Ne peut pas être négatif.");
        const formSchema = {
            fields: [
                {
                    header: 'msppData.deliveries',
                },
                {
                    th: ["msppData.ageOfMothers", "msppData.matronsTrained", "msppData.others"],
                    rows: [
                        [
                            {
                                rowName: "msppData.years15",
                            },
                            {
                                name: '15_or_younger_matron_trained',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: '15_or_younger_others',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.years15_19",
                            },
                            {
                                name: '15_19_matron_trained',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: '15_19_others',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.years20_24",
                            },
                            {
                                name: '20_24_matron_trained',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: '20_24_others',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.years25_29",
                            },
                            {
                                name: '25_29_matron_trained',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: '25_29_others',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.years30Up"
                            },
                            {
                                name: '30Up_matron_trained',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: '30Up_others',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.unknown",
                            },
                            {
                                name: 'unknown_matron_trained',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'unknown_others',
                                as: 'input',
                                rules: r,
                            },
                        ]
                    ]
                },
                {
                    header: 'msppData.births',
                },
                {
                    th: ["msppData.births", "msppData.matrons", "msppData.others"],
                    rows: [
                        [
                            {
                                rowName: "msppData.weight1_5",
                            },
                            {
                                name: 'weight1_5_matron',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'weight1_5_others',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.weight1_5To2_5",
                            },
                            {
                                name: 'weight1_5To2_5_matron',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'weight1_5To2_5_others',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.weight2_5Up",
                            },
                            {
                                name: 'weight2_5Up_matron',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'weight2_5Up_others',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.notWeighed",
                            },
                            {
                                name: 'not_weighed_matron',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'not_weighed_others',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.immediatelyBreastfed",
                            },
                            {
                                name: 'immediately_breastfed_matron',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'immediately_breastfed_others',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.skinToSkinTherapy",
                            },
                            {
                                name: 'skin_to_skin_therapy_matron',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'skin_to_skin_therapy_others',
                                as: 'input',
                                rules: r,
                            },
                        ],
                    ]
                },
                {
                    header: 'msppData.postNatal',
                },
                {
                    th: ["msppData.postNatal", "msppData.matrons", "msppData.others"],
                    rows: [
                        [
                            {
                                rowName: "msppData.breastfeeding_WomenVitA",
                            },
                            {
                                name: 'breastfeeding_women_receiving_vitaminA_matron',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'breastfeeding_women_receiving_vitaminA_others',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.breastfeeding_WomenMUAC",
                            },
                            {
                                name: 'breastfeeding_women_with_MUAC<210mm_matron',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'breastfeeding_women_with_MUAC<210mm_others',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.breastfeeding_WomenMalnutrition",
                            },
                            {
                                name: 'breastfeeding_women_with_malnutrition_matron',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'breastfeeding_women_with_malnutrition_others',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.domesticVisits",
                            },
                            {
                                name: 'domestic_visits_within_3_days_matron',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'domestic_visits_within_3_days_others',
                                as: 'input',
                                rules: r,
                            },
                        ],
                    ]
                },
                {
                    header: 'msppData.birthControl',
                },
                {
                    th: ["msppData.birthControl", "msppData.accepting", "msppData.accepting", "msppData.totalUsers", "msppData.totalUsers"],
                },
                {
                    th: ["msppData.methods_sex", "msppData.years25", "msppData.years25Up", "msppData.years25", "msppData.years25Up"],
                    rows: [
                        [
                            {
                                rowName: "msppData.ocp",
                            },
                            {
                                name: 'accepting_under_25_ocp',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'accepting_25Up_ocp',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'total_users_under_25_ocp',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'total_users_25Up_ocp',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.patch",
                            },
                            {
                                name: 'accepting_under_25_patch',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'accepting_25Up_patch',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'total_users_under_25_patch',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'total_users_25Up_patch',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.depoInjection",
                            },
                            {
                                name: 'accepting_under_25_depo_injection',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'accepting_25Up_depo_injection',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'total_users_under_25_depo_injection',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'total_users_25Up_depo_injection',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.implant",
                            },
                            {
                                name: 'accepting_under_25_implant',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'accepting_25Up_implant',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'total_users_under_25_implant',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'total_users_25Up_implant',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.IUD",
                            },
                            {
                                name: 'accepting_under_25_IUD',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'accepting_25Up_IUD',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'total_users_under_25_IUD',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'total_users_25Up_IUD',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.vaginalRing",
                            },
                            {
                                name: 'accepting_under_25_vaginal_ring',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'accepting_25Up_vaginal_ring',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'total_users_under_25_vaginal_ring',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'total_users_25Up_vaginal_ring',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.bfAsBirthControl",
                            },
                            {
                                name: 'accepting_under_25_breastfeeding_birth_control',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'accepting_25Up_breastfeeding_birth_control',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'total_users_under_25_breastfeeding_birth_control',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'total_users_25Up_breastfeeding_birth_control',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.femaleCondom",
                            },
                            {
                                name: 'accepting_under_25_female_condom',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'accepting_25Up_female_condom',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'total_users_under_25_female_condom',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'total_users_25Up_female_condom',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.sterilisation",
                            },
                            {
                                name: 'accepting_under_25_sterilisation',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'accepting_25Up_sterilisation',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'total_users_under_25_sterilisation',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'total_users_25Up_sterilisation',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.maleCondom",
                            },
                            {
                                name: 'accepting_under_25_male_condom',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'accepting_25Up_male_condom',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'total_users_under_25_male_condom',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'total_users_25Up_male_condom',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.vasectomy",
                            },
                            {
                                name: 'accepting_under_25_vasectomy',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'accepting_25Up_vasectomy',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'total_users_under_25_vasectomy',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'total_users_25Up_vasectomy',
                                as: 'input',
                                rules: r,
                            },
                        ],
                    ]
                },
                {
                    header: "msppData.contraceptivesDist",
                },
                {
                    th: ["msppData.unit", "msppData.quantity", "msppData.daysOutStockMonth"],
                    rows: [
                        [
                            {
                                rowName: "msppData.ocpCycle",
                            },
                            {
                                name: 'quantity_ocpCycle',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'days_out_of_stock_ocpCycle',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.patchCycle",
                            },
                            {
                                name: 'quantity_patchCycle',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'days_out_of_stock_patchCycle',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.depoInjectionVial",
                            },
                            {
                                name: 'quantity_depoInjectionVial',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'days_out_of_stock_depoInjectionVial',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.implantPacket",
                            },
                            {
                                name: 'quantity_implantPacket',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'days_out_of_stock_implantPacket',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.IUDPiece",
                            },
                            {
                                name: 'quantity_IUDPeice',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'days_out_of_stock_IUDPeice',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.vaginalRingPiece",
                            },
                            {
                                name: 'quantity_vaginalRingPiece',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'days_out_of_stock_vaginalRingPiece',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.femaleCondom",
                            },
                            {
                                name: 'quantity_femaleCondom',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'days_out_of_stock_femaleCondom',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.maleCondom",
                            },
                            {
                                name: 'quantity_maleCondom',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'days_out_of_stock_maleCondom',
                                as: 'input',
                                rules: r,
                            },
                        ],
                    ]
                },
                {
                    header: "msppData.ccvOperations",
                },
                {
                    label: 'msppData.sterilisation',
                    name: 'ccv_sterilisation',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'msppData.vasectomy',
                    name: 'ccv_vasectomy',
                    as: 'input',
                    rules: r,
                },
                {
                    header: "msppData.vaccinesConsumables",
                },
                {
                    th: ["msppData.typeOfVaccine", "msppData.quantityAvailableMonth", "msppData.balanceEndOfMonth", "msppData.daysOutStock"],
                    rows: [
                        [
                            {
                                rowName: "msppData.bcg",
                            },
                            {
                                name: 'quantity_available_bcg',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'balance_end_of_month_bcg',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'days_out_of_stock_bcg',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.vpo",
                            },
                            {
                                name: 'quantity_available_vpo',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'balance_end_of_month_vpo',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'days_out_of_stock_vpo',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.penta",
                            },
                            {
                                name: 'quantity_available_penta',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'balance_end_of_month_penta',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'days_out_of_stock_penta',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.rota",
                            },
                            {
                                name: 'quantity_available_rota',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'balance_end_of_month_rota',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'days_out_of_stock_rota',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.rr",
                            },
                            {
                                name: 'quantity_available_rr',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'balance_end_of_month_r',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'days_out_of_stock_r',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.dT",
                            },
                            {
                                name: 'quantity_available_dT',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'balance_end_of_month_dT',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'days_out_of_stock_dT',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.vpi",
                            },
                            {
                                name: 'quantity_available_vpi',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'balance_end_of_month_vpi',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'days_out_of_stock_vpi',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.flu",
                            },
                            {
                                name: 'quantity_available_flu',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'balance_end_of_month_flu',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'days_out_of_stock_flu',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.dtp",
                            },
                            {
                                name: 'quantity_available_dtp',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'balance_end_of_month_dtp',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'days_out_of_stock_dtp',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.covid_19",
                            },
                            {
                                name: 'quantity_available_covid_19',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'balance_end_of_month_covid_19',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'days_out_of_stock_covid_19',
                                as: 'input',
                                rules: r,
                            },
                        ],
                    ]
                },
                {
                    th: ["msppData.consumables", "msppData.quantityAvailableMonth", "msppData.balanceEndOfMonth", "msppData.daysOutStock"],
                    rows: [
                        [
                            {
                                rowName: "msppData.sab_005",
                            },
                            {
                                name: 'quantity_available_sab_005',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'balance_end_of_month_sab_005',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'days_out_of_stock_sab_005',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.sab_05",
                            },
                            {
                                name: 'quantity_available_sab_05',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'balance_end_of_month_sab_05',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'days_out_of_stock_sab_05',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.sdil_2",
                            },
                            {
                                name: 'quantity_available_sdil_2',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'balance_end_of_month_sdil_2',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'days_out_of_stock_sdil_2',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.sdil_5",
                            },
                            {
                                name: 'quantity_available_sdil_5',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'balance_end_of_month_sdil_5',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'days_out_of_stock_sdil_5',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.secondaryBoxes",
                            },
                            {
                                name: 'quantity_available_secondaryBoxes',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'balance_end_of_month_secondaryBoxes',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'days_out_of_stock_secondaryBoxes',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.cotton",
                            },
                            {
                                name: 'quantity_available_cotton',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'balance_end_of_month_cotton',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'days_out_of_stock_cotton',
                                as: 'input',
                                rules: r,
                            },
                        ],
                    ]
                },
                {
                    header: "msppData.vaccination",
                },
                {
                    header: "msppData.girl",
                },
                {
                    th: ["msppData.vaccine", "msppData.months0_11", "msppData.months0_11", "msppData.months12_32", "msppData.months12_32"],
                },
                {
                    th: ["msppData.vaccine", "msppData.instAb", "msppData.commAb", "msppData.instAb", "msppData.commAb"],
                    rows: [
                        [
                            {
                                rowName: "msppData.bcg",
                            },
                            {
                                name: 'inst_girl_0_11_months_bcg',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_girl_0_11_months_bcg',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.vpoPolio1",
                            },
                            {
                                name: 'inst_girl_0_11_months_vpoPolio1',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_girl_0_11_months_vpoPolio1',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.vpoPolio2",
                            },
                            {
                                name: 'inst_girl_0_11_months_vpoPolio2',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_girl_0_11_months_vpoPolio2',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.vpoPolio3",
                            },
                            {
                                name: 'inst_girl_0_11_months_vpoPolio3',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_girl_0_11_months_vpoPolio3',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.rappelVPO",
                            },
                            {
                                name: 'inst_girl_0_11_months_rappelVPO',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_girl_0_11_months_rappelVPO',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.vpi",
                            },
                            {
                                name: 'inst_girl_0_11_months_vpi',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_girl_0_11_months_vpi',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.penta1",
                            },
                            {
                                name: 'inst_girl_0_11_months_penta1',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_girl_0_11_months_penta1',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.penta2",
                            },
                            {
                                name: 'inst_girl_0_11_months_penta2',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_girl_0_11_months_penta2',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.penta3",
                            },
                            {
                                name: 'inst_girl_0_11_months_penta3',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_girl_0_11_months_penta3',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.rota1",
                            },
                            {
                                name: 'inst_girl_0_11_months_rota1',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_girl_0_11_months_rota1',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.rota2",
                            },
                            {
                                name: 'inst_girl_0_11_months_rota2',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_girl_0_11_months_rota2',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.rr1",
                            },
                            {
                                name: 'inst_girl_0_11_months_rr1',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_girl_0_11_months_rr1',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.rr2",
                            },
                            {
                                name: 'inst_girl_0_11_months_rr2', // Need to remove from table
                            },
                            {
                                name: 'comm_girl_0_11_months_rr2', // Need to remove from table
                            },
                            {
                                name: 'inst_girl_12_32_months_rr2',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_girl_12_32_months_rr2',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.flu1",
                            },
                            {
                                name: 'inst_girl_0_11_months_flu1',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_girl_0_11_months_flu1',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.flu2",
                            },
                            {
                                name: 'inst_girl_0_11_months_flu2',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_girl_0_11_months_flu2',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.flu3",
                            },
                            {
                                name: 'inst_girl_0_11_months_flu3',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_girl_0_11_months_flu3',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.dtpRappel",
                            },
                            {
                                name: 'inst_girl_0_11_months_dtpRappel', // Need to remove from table
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_girl_0_11_months_dtpRappel', // Need to remove from table
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'inst_girl_12_32_months_dtpRappel',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_girl_12_32_months_dtpRappel',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.ecv",
                            },
                            {
                                name: 'inst_girl_0_11_months_ecv',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_girl_0_11_months_ecv',
                                as: 'input',
                                rules: r,
                            },
                        ],
                    ]
                },
                {
                    header: "msppData.boy",
                },
                {
                    th: ["msppData.vaccine", "msppData.months0_11", "msppData.months0_11", "msppData.months12_32", "msppData.months12_32"],
                },
                {
                    th: ["msppData.vaccine", "msppData.instAb", "msppData.commAb", "msppData.instAb", "msppData.commAb"],
                    rows: [
                        [
                            {
                                rowName: "msppData.bcg",
                            },
                            {
                                name: 'inst_boy_0_11_months_bcg',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_boy_0_11_months_bcg',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.vpoPolio1",
                            },
                            {
                                name: 'inst_boy_0_11_months_vpoPolio1',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_boy_0_11_months_vpoPolio1',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.vpoPolio2",
                            },
                            {
                                name: 'inst_boy_0_11_months_vpoPolio2',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_boy_0_11_months_vpoPolio2',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.vpoPolio3",
                            },
                            {
                                name: 'inst_boy_0_11_months_vpoPolio3',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_boy_0_11_months_vpoPolio3',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.rappelVPO",
                            },
                            {
                                name: 'inst_boy_0_11_months_rappelVPO',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_boy_0_11_months_rappelVPO',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.vpi",
                            },
                            {
                                name: 'inst_boy_0_11_months_vpi',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_boy_0_11_months_vpi',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.penta1",
                            },
                            {
                                name: 'inst_boy_0_11_months_penta1',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_boy_0_11_months_penta1',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.penta2",
                            },
                            {
                                name: 'inst_boy_0_11_months_penta2',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_boy_0_11_months_penta2',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.penta3",
                            },
                            {
                                name: 'inst_boy_0_11_months_penta3',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_boy_0_11_months_penta3',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.rota1",
                            },
                            {
                                name: 'inst_boy_0_11_months_rota1',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_boy_0_11_months_rota1',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.rota2",
                            },
                            {
                                name: 'inst_boy_0_11_months_rota2',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_boy_0_11_months_rota2',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.rr1",
                            },
                            {
                                name: 'inst_boy_0_11_months_rr1',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_boy_0_11_months_rr1',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.rr2",
                            },
                            {
                                name: 'inst_boy_0_11_months_rr2', // Need to remove from table
                            },
                            {
                                name: 'comm_boy_0_11_months_rr2', // Need to remove from table
                            },
                            {
                                name: 'inst_boy_12_32_months_rr2',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_boy_12_32_months_rr2',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.flu1",
                            },
                            {
                                name: 'inst_boy_0_11_months_flu1',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_boy_0_11_months_flu1',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.flu2",
                            },
                            {
                                name: 'inst_boy_0_11_months_flu2',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_boy_0_11_months_flu2',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.flu3",
                            },
                            {
                                name: 'inst_boy_0_11_months_flu3',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_boy_0_11_months_flu3',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.dtpRappel",
                            },
                            {
                                name: 'inst_boy_0_11_months_dtpRappel', // Need to remove from table
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_boy_0_11_months_dtpRappel', // Need to remove from table
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'inst_boy_12_32_months_dtpRappel',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_boy_12_32_months_dtpRappel',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.ecv",
                            },
                            {
                                name: 'inst_boy_0_11_months_ecv',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_boy_0_11_months_ecv',
                                as: 'input',
                                rules: r,
                            },
                        ],
                    ]
                },
                {
                    header: "msppData.vaccineDoses",
                },
                {
                    th: ["msppData.vaccine", "msppData.used", "msppData.administered"],
                    rows: [
                        [
                            {
                                rowName: "msppData.bcg",
                            },
                            {
                                name: 'used_doses_bcg',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'administered_bcg',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.vpo",
                            },
                            {
                                name: 'used_doses_vpo',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'administered_vpo',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.vpi",
                            },
                            {
                                name: 'used_doses_vpi',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'administered_vpi',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.penta",
                            },
                            {
                                name: 'used_doses_penta',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'administered_penta',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.rota",
                            },
                            {
                                name: 'used_doses_rota',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'administered_rota',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.rr",
                            },
                            {
                                name: 'used_doses_rr',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'administered_rr',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.flu",
                            },
                            {
                                name: 'used_doses_flu',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'administered_flu',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.dtp",
                            },
                            {
                                name: 'used_doses_dtp',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'administered_dtp',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.ecv",
                            },
                            {
                                name: 'used_doses_ecv',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'administered_ecv',
                                as: 'input',
                                rules: r,
                            },
                        ],
                    ]
                },
                {
                    header: "msppData.pregnantWomen",
                },
                {
                    th: ["msppData.vaccine", "msppData.instAb", "msppData.commAb"],
                    rows: [
                        [
                            {
                                rowName: "msppData.dT1",
                            },
                            {
                                name: 'inst_dT1',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_dT1',
                                as: 'input',
                                rules: r,
                            },
                        ],
                        [
                            {
                                rowName: "msppData.dT2Up",
                            },
                            {
                                name: 'inst_dT2',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'comm_dT2',
                                as: 'input',
                                rules: r,
                            },
                        ],
                    ]
                },
                {
                    th: ["msppData.total", "msppData.used", "msppData.administered"],
                    rows: [
                        [
                            {
                                rowName: "msppData.dT1_and_dT2",
                            },
                            {
                                name: 'both_used',
                                as: 'input',
                                rules: r,
                            },
                            {
                                name: 'both_administered',
                                as: 'input',
                                rules: r,
                            },
                        ],
                    ]
                },
            ],
        };
        return {
            formSchema,
            department: "community_health",
            formTitle: 'msppData.communityHealthForm'
        };
    },
});

</script>
