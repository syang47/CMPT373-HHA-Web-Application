<template>
    <div>
        <h2 class="font-weight-bold display-5 text-dark">{{ $t('msppData.communityHealthForm') }}</h2>
        <DynamicForm :schema="formSchema" :department="department"/>
    </div>
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
        const r: any = yup.number().min(0, "Cannot be negative.").required("Required.").default(0);
        const a: any = yup.number().min(0, "Cannot be negative.").default(0);
        const formSchema = {
            fields: [
                {
                    label: 'deliveries',
                    name: 'deliveries',
                    as: 'text',
                },
                {
                    label: 'ageOfMothers',
                    name: 'ageOfMothers',
                },
                {
                    label: 'years15',
                    name: 'years15',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'years15_19',
                    name: 'years15_19',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'years20_24',
                    name: 'years20_24',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'years25_29',
                    name: 'years25_29',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'years30Up',
                    name: 'years30Up',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'unknown',
                    name: 'unknown',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'births',
                    name: 'births',
                },
                {
                    label: 'weight1_5',
                    name: 'weight1_5',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'weight1_5To2_5',
                    name: 'weight1_5To2_5',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'weight2_5Up',
                    name: 'weight2_5Up',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'notWeighted',
                    name: 'notWeighted',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'immediatelyBreastfed',
                    name: 'immediatelyBreastfed',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'skinToSkinTherapy',
                    name: 'skinToSkinTherapy',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'postNatal',
                    name: 'postNatal',
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
                    label: 'birthControl',
                    name: 'birthControl',
                },
                {
                    label: 'methodsF',
                    name: 'methodsF',
                },
                {
                    label: 'ocp',
                    name: 'ocp',
                    children: [
                        {
                            label: 'years25',
                            name: 'years25',
                            children: [
                                {
                                    label: 'accepting',
                                    name: 'accepting',
                                    as: 'input',
                                    rules: r,
                                },
                                {
                                    label: 'totalUsers',
                                    name: 'totalUsers',
                                    as: 'input',
                                    rules: r,
                                },
                            ]
                        },
                        {
                            label: 'years25Up',
                            name: 'years25Up',
                            children: [
                                {
                                    label: 'accepting',
                                    name: 'accepting',
                                    as: 'input',
                                    rules: r,
                                },
                                {
                                    label: 'totalUsers',
                                    name: 'totalUsers',
                                    as: 'input',
                                    rules: r,
                                },
                            ]
                        },
                    ]
                },
                {
                    label: 'patch',
                    name: 'patch',
                    children: [
                        {
                            label: 'years25',
                            name: 'years25',
                            children: [
                                {
                                    label: 'accepting',
                                    name: 'accepting',
                                    as: 'input',
                                    rules: r,
                                },
                                {
                                    label: 'totalUsers',
                                    name: 'totalUsers',
                                    as: 'input',
                                    rules: r,
                                },
                            ]
                        },
                        {
                            label: 'years25Up',
                            name: 'years25Up',
                            children: [
                                {
                                    label: 'accepting',
                                    name: 'accepting',
                                    as: 'input',
                                    rules: r,
                                },
                                {
                                    label: 'totalUsers',
                                    name: 'totalUsers',
                                    as: 'input',
                                    rules: r,
                                },
                            ]
                        },
                    ]
                },
                {
                    label: 'depoInjection',
                    name: 'depoInjection',
                    children: [
                        {
                            label: 'years25',
                            name: 'years25',
                            children: [
                                {
                                    label: 'accepting',
                                    name: 'accepting',
                                    as: 'input',
                                    rules: r,
                                },
                                {
                                    label: 'totalUsers',
                                    name: 'totalUsers',
                                    as: 'input',
                                    rules: r,
                                },
                            ]
                        },
                        {
                            label: 'years25Up',
                            name: 'years25Up',
                            children: [
                                {
                                    label: 'accepting',
                                    name: 'accepting',
                                    as: 'input',
                                    rules: r,
                                },
                                {
                                    label: 'totalUsers',
                                    name: 'totalUsers',
                                    as: 'input',
                                    rules: r,
                                },
                            ]
                        },
                    ]
                },
                {
                    label: 'implant',
                    name: 'implant',
                    children: [
                        {
                            label: 'years25',
                            name: 'years25',
                            children: [
                                {
                                    label: 'accepting',
                                    name: 'accepting',
                                    as: 'input',
                                    rules: r,
                                },
                                {
                                    label: 'totalUsers',
                                    name: 'totalUsers',
                                    as: 'input',
                                    rules: r,
                                },
                            ]
                        },
                        {
                            label: 'years25Up',
                            name: 'years25Up',
                            children: [
                                {
                                    label: 'accepting',
                                    name: 'accepting',
                                    as: 'input',
                                    rules: r,
                                },
                                {
                                    label: 'totalUsers',
                                    name: 'totalUsers',
                                    as: 'input',
                                    rules: r,
                                },
                            ]
                        },
                    ]
                },
                {
                    label: 'IUD',
                    name: 'IUD',
                    children: [
                        {
                            label: 'years25',
                            name: 'years25',
                            children: [
                                {
                                    label: 'accepting',
                                    name: 'accepting',
                                    as: 'input',
                                    rules: r,
                                },
                                {
                                    label: 'totalUsers',
                                    name: 'totalUsers',
                                    as: 'input',
                                    rules: r,
                                },
                            ]
                        },
                        {
                            label: 'years25Up',
                            name: 'years25Up',
                            children: [
                                {
                                    label: 'accepting',
                                    name: 'accepting',
                                    as: 'input',
                                    rules: r,
                                },
                                {
                                    label: 'totalUsers',
                                    name: 'totalUsers',
                                    as: 'input',
                                    rules: r,
                                },
                            ]
                        },
                    ]
                },
                {
                    label: 'vaginalRing',
                    name: 'vaginalRing',
                    children: [
                        {
                            label: 'years25',
                            name: 'years25',
                            children: [
                                {
                                    label: 'accepting',
                                    name: 'accepting',
                                    as: 'input',
                                    rules: r,
                                },
                                {
                                    label: 'totalUsers',
                                    name: 'totalUsers',
                                    as: 'input',
                                    rules: r,
                                },
                            ]
                        },
                        {
                            label: 'years25Up',
                            name: 'years25Up',
                            children: [
                                {
                                    label: 'accepting',
                                    name: 'accepting',
                                    as: 'input',
                                    rules: r,
                                },
                                {
                                    label: 'totalUsers',
                                    name: 'totalUsers',
                                    as: 'input',
                                    rules: r,
                                },
                            ]
                        },
                    ]
                },
                {
                    label: 'bfAsBirthControl',
                    name: 'bfAsBirthControl',
                    children: [
                        {
                            label: 'years25',
                            name: 'years25',
                            children: [
                                {
                                    label: 'accepting',
                                    name: 'accepting',
                                    as: 'input',
                                    rules: r,
                                },
                                {
                                    label: 'totalUsers',
                                    name: 'totalUsers',
                                    as: 'input',
                                    rules: r,
                                },
                            ]
                        },
                        {
                            label: 'years25Up',
                            name: 'years25Up',
                            children: [
                                {
                                    label: 'accepting',
                                    name: 'accepting',
                                    as: 'input',
                                    rules: r,
                                },
                                {
                                    label: 'totalUsers',
                                    name: 'totalUsers',
                                    as: 'input',
                                    rules: r,
                                },
                            ]
                        },
                    ]
                },
                {
                    label: 'femaleCondom',
                    name: 'femaleCondom',
                    children: [
                        {
                            label: 'years25',
                            name: 'years25',
                            children: [
                                {
                                    label: 'accepting',
                                    name: 'accepting',
                                    as: 'input',
                                    rules: r,
                                },
                                {
                                    label: 'totalUsers',
                                    name: 'totalUsers',
                                    as: 'input',
                                    rules: r,
                                },
                            ]
                        },
                        {
                            label: 'years25Up',
                            name: 'years25Up',
                            children: [
                                {
                                    label: 'accepting',
                                    name: 'accepting',
                                    as: 'input',
                                    rules: r,
                                },
                                {
                                    label: 'totalUsers',
                                    name: 'totalUsers',
                                    as: 'input',
                                    rules: r,
                                },
                            ]
                        },
                    ]
                },
                {
                    label: 'methodsM',
                    name: 'methodsM',
                },
                {
                    label: 'sterilisation',
                    name: 'sterilisation',
                    children: [
                        {
                            label: 'years25',
                            name: 'years25',
                            children: [
                                {
                                    label: 'accepting',
                                    name: 'accepting',
                                    as: 'input',
                                    rules: r,
                                },
                                {
                                    label: 'totalUsers',
                                    name: 'totalUsers',
                                    as: 'input',
                                    rules: r,
                                },
                            ]
                        },
                        {
                            label: 'years25Up',
                            name: 'years25Up',
                            children: [
                                {
                                    label: 'accepting',
                                    name: 'accepting',
                                    as: 'input',
                                    rules: r,
                                },
                                {
                                    label: 'totalUsers',
                                    name: 'totalUsers',
                                    as: 'input',
                                    rules: r,
                                },
                            ]
                        },
                    ]
                },
                {
                    label: 'maleCondom',
                    name: 'maleCondom',
                    children: [
                        {
                            label: 'years25',
                            name: 'years25',
                            children: [
                                {
                                    label: 'accepting',
                                    name: 'accepting',
                                    as: 'input',
                                    rules: r,
                                },
                                {
                                    label: 'totalUsers',
                                    name: 'totalUsers',
                                    as: 'input',
                                    rules: r,
                                },
                            ]
                        },
                        {
                            label: 'years25Up',
                            name: 'years25Up',
                            children: [
                                {
                                    label: 'accepting',
                                    name: 'accepting',
                                    as: 'input',
                                    rules: r,
                                },
                                {
                                    label: 'totalUsers',
                                    name: 'totalUsers',
                                    as: 'input',
                                    rules: r,
                                },
                            ]
                        },
                    ]
                },
                {
                    label: 'vasectomy',
                    name: 'vasectomy',
                    children: [
                        {
                            label: 'years25',
                            name: 'years25',
                            children: [
                                {
                                    label: 'accepting',
                                    name: 'accepting',
                                    as: 'input',
                                    rules: r,
                                },
                                {
                                    label: 'totalUsers',
                                    name: 'totalUsers',
                                    as: 'input',
                                    rules: r,
                                },
                            ]
                        },
                        {
                            label: 'years25Up',
                            name: 'years25Up',
                            children: [
                                {
                                    label: 'accepting',
                                    name: 'accepting',
                                    as: 'input',
                                    rules: r,
                                },
                                {
                                    label: 'totalUsers',
                                    name: 'totalUsers',
                                    as: 'input',
                                    rules: r,
                                },
                            ]
                        },
                    ]
                },
                {
                    label: 'sterilisationAmount',
                    name: 'sterilisationAmount',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'vasectomyAmount',
                    name: 'vasectomyAmount',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'contraceptivesDist',
                    name: 'contraceptivesDist',
                },
                {
                    label: 'ocpCycle',
                    name: 'ocpCycle',
                    children: [
                        {
                            label: 'quantity',
                            name: 'quantity',
                            as: 'input',
                            rules: r,
                        },
                        {
                            label: 'daysOutStock',
                            name: 'daysOutStock',
                            as: 'input',
                            rules: r,
                        },
                    ]
                },
                {
                    label: 'patchCycle',
                    name: 'patchCycle',
                    children: [
                        {
                            label: 'quantity',
                            name: 'quantity',
                            as: 'input',
                            rules: r,
                        },
                        {
                            label: 'daysOutStock',
                            name: 'daysOutStock',
                            as: 'input',
                            rules: r,
                        },
                    ]
                },
                {
                    label: 'depoInjectionVial',
                    name: 'depoInjectionVial',
                    children: [
                        {
                            label: 'quantity',
                            name: 'quantity',
                            as: 'input',
                            rules: r,
                        },
                        {
                            label: 'daysOutStock',
                            name: 'daysOutStock',
                            as: 'input',
                            rules: r,
                        },
                    ]
                },
                {
                    label: 'implantPacket',
                    name: 'implantPacket',
                    children: [
                        {
                            label: 'quantity',
                            name: 'quantity',
                            as: 'input',
                            rules: r,
                        },
                        {
                            label: 'daysOutStock',
                            name: 'daysOutStock',
                            as: 'input',
                            rules: r,
                        },
                    ]
                },
                {
                    label: 'IUDPiece',
                    name: 'IUDPiece',
                    children: [
                        {
                            label: 'quantity',
                            name: 'quantity',
                            as: 'input',
                            rules: r,
                        },
                        {
                            label: 'daysOutStock',
                            name: 'daysOutStock',
                            as: 'input',
                            rules: r,
                        },
                    ]
                },
                {
                    label: 'vaginalRingPiece',
                    name: 'vaginalRingPiece',
                    children: [
                        {
                            label: 'quantity',
                            name: 'quantity',
                            as: 'input',
                            rules: r,
                        },
                        {
                            label: 'daysOutStock',
                            name: 'daysOutStock',
                            as: 'input',
                            rules: r,
                        },
                    ]
                },
                {
                    label: 'femaleCondomPiece',
                    name: 'femaleCondomPiece',
                    children: [
                        {
                            label: 'quantity',
                            name: 'quantity',
                            as: 'input',
                            rules: r,
                        },
                        {
                            label: 'daysOutStock',
                            name: 'daysOutStock',
                            as: 'input',
                            rules: r,
                        },
                    ]
                },
                {
                    label: 'maleCondomPiece',
                    name: 'maleCondomPiece',
                    children: [
                        {
                            label: 'quantity',
                            name: 'quantity',
                            as: 'input',
                            rules: r,
                        },
                        {
                            label: 'daysOutStock',
                            name: 'daysOutStock',
                            as: 'input',
                            rules: r,
                        },
                    ]
                },
            ],
        };
        return {
            formSchema,
            department: "community_health",
        };
    },
});
</script>