<template>
    <div>
        <h2 class="font-weight-bold display-5 text-dark">{{ $t('msppData.nicupaedForm') }}</h2>
        <DynamicForm :schema="formSchema" :department="department"/>
    </div>
</template>

<script lang="ts" type="text/typescript">
import { defineComponent } from 'vue'
import * as yup from "yup";
import DynamicForm from '@/components/DynamicForm.vue';
export default defineComponent({
    name: "Rehab_Data",
    components: {
        DynamicForm
    },
    data() {
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
                    rules: r
                },
                {
                    label: 'patientDays',
                    name: 'patientDays',
                    as: 'input',
                    rules: r
                },
                {
                    label: 'hospitalised',
                    name: 'hospitalised',
                    as: 'input',
                    rules: r,
                    children: [
                        {
                            label: 'hospitalisedNICU',
                            name: 'hospitalisedNICU',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'hospitalisedPAED',
                            name: 'hospitalisedPAED',
                            as: 'input',
                            rules: a
                        },
                    ]
                },
                {
                    label: 'dischargedAlive',
                    name: 'dischargedAlive',
                    as: 'input',
                    rules: r,
                    children: [
                        {
                            label: 'NICUDischarged',
                            name: 'NICUDischarged',
                            as: 'input',
                            rules: a
                        },
                    ]
                },
                {
                    label: 'diedBefore48h',
                    name: 'diedBefore48h',
                    as: 'input',
                    rules: r,
                    children: [
                        {
                            label: 'diedInNICUBefore48',
                            name: 'diedInNICUBefore48',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'diedInPaedBefore48',
                            name: 'diedInPaedBefore48',
                            as: 'input',
                            rules: a
                        },
                    ]
                },
                {
                    label: 'diedAfter48h',
                    name: 'diedAfter48h',
                    as: 'input',
                    rules: r,
                    children: [
                        {
                            label: 'diedInNICUAfter48',
                            name: 'diedInNICUAfter48',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'diedInPaedAfter48',
                            name: 'diedInPaedAfter48',
                            as: 'input',
                            rules: a
                        },
                    ]
                },
                {
                    label: 'daysHospitalised',
                    name: 'daysHospitalised',
                    as: 'input',
                    rules: r
                },
                {
                    label: 'referrals',
                    name: 'referrals',
                    as: 'input',
                    rules: r
                },
                {
                    label: 'transfers',
                    name: 'transfers',
                    as: 'input',
                    rules: r
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
                            rules: a
                        },
                        {
                            label: 'financeAvoidPay',
                            name: 'financeAvoidPay',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'reasonCultural',
                            name: 'reasonCultural',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'reasonPersonal',
                            name: 'reasonPersonal',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'otherReason',
                            name: 'otherReason',
                            as: 'input',
                            rules: a
                        },
                    ]
                },
                {
                    label: 'stayedInTheWard',
                    name: 'stayedInTheWard',
                    as: 'input',
                    rules: r
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
                            rules: a
                        },
                        {
                            header: 'ageOfInfant'
                        },
                        {
                            label: 'admissionsExtremelyPreterm',
                            name: 'admissionsExtremelyPreterm',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'admissionsVeryPreterm',
                            name: 'admissionsVeryPreterm',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'admissionsModerateToLatePreterm',
                            name: 'admissionsModerateToLatePreterm',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'admissionsFullTerm',
                            name: 'admissionsFullTerm',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'admissionsOlderThanNeonate',
                            name: 'admissionsOlderThanNeonate',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'admissionsAge4WeeksTo5',
                            name: 'admissionsAge4WeeksTo5',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'admissionsAge6To11',
                            name: 'admissionsAge6To11',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'admissionsAge12To18',
                            name: 'admissionsAge12To18',
                            as: 'input',
                            rules: a
                        },
                        {
                            header: 'gender'
                        },
                        {
                            label: 'admissionsMale',
                            name: 'admissionsMale',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'admissionsFemale',
                            name: 'admissionsFemale',
                            as: 'input',
                            rules: a
                        },
                        {
                            header: 'mainCond'
                        },
                        {
                            label: 'admissionsRespiratoryArrest',
                            name: 'admissionsRespiratoryArrest',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'admissionsTraumaticInjury',
                            name: 'admissionsTraumaticInjury',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'admissionsSepticShock',
                            name: 'admissionsSepticShock',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'admissionsHypovolemicShock',
                            name: 'admissionsHypovolemicShock',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'admissionsSeizures',
                            name: 'admissionsSeizures',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'admissionsPoisoning',
                            name: 'admissionsPoisoning',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'admissionsAlteredMentalStatus',
                            name: 'admissionsAlteredMentalStatus',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'admissionsGastroenteritis',
                            name: 'admissionsGastroenteritis',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'admissionsHemorrhage',
                            name: 'admissionsHemorrhage',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'admissionsHypothermia',
                            name: 'admissionsHypothermia',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'admissionsCardiacCongenitalAnomaly',
                            name: 'admissionsCardiacCongenitalAnomaly',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'admissionsOtherCongenitalAnomaly',
                            name: 'admissionsOtherCongenitalAnomaly',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'admissionsMalnutrition',
                            name: 'admissionsMalnutrition',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'admissionsMeningitis',
                            name: 'admissionsMeningitis',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'admissionsCommunityAcquiredPneumonia',
                            name: 'admissionsCommunityAcquiredPneumonia',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'admissionsAspirationPneumonia',
                            name: 'admissionsAspirationPneumonia',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'admissionsModeratePrematurity',
                            name: 'admissionsModeratePrematurity',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'admissionsSeverePrematurity',
                            name: 'admissionsSeverePrematurity',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'admissionsOtherMedical',
                            name: 'admissionsOtherMedical',
                            as: 'input',
                            rules: yup.string()
                        },
                    ]
                },
                
                {
                    label: 'numberOfOutpatients',
                    name: 'numberOfOutpatients',
                    as: 'input',
                    children: [
                        {
                            header: 'age'
                        },
                        {
                            label: 'numberOfOutpatientsExtremelyPreterm',
                            name: 'numberOfOutpatientsExtremelyPreterm',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'numberOfOutpatientsVeryPreterm',
                            name: 'numberOfOutpatientsVeryPreterm',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'numberOfOutpatientsModerateToLatePreterm',
                            name: 'numberOfOutpatientsModerateToLatePreterm',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'numberOfOutpatientsFullTerm',
                            name: 'numberOfOutpatientsFullTerm',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'numberOfOutpatientsOlderThanNeonate',
                            name: 'numberOfOutpatientsOlderThanNeonate',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'numberOfOutpatientsAge4WeeksTo5',
                            name: 'numberOfOutpatientsAge4WeeksTo5',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'numberOfOutpatientsAge6To11',
                            name: 'numberOfOutpatientsAge6To11',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'numberOfOutpatientsAge12To18',
                            name: 'numberOfOutpatientsAge12To18',
                            as: 'input',
                            rules: a
                        },
                        {
                            header: 'mainCond'
                        },
                        {
                            label: 'numberOfOutpatientsRespiratoryArrest',
                            name: 'numberOfOutpatientsRespiratoryArrest',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'numberOfOutpatientsTraumaticInjury',
                            name: 'numberOfOutpatientsTraumaticInjury',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'numberOfOutpatientsSepticShock',
                            name: 'numberOfOutpatientsSepticShock',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'numberOfOutpatientsHypovolemicShock',
                            name: 'numberOfOutpatientsHypovolemicShock',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'numberOfOutpatientsSeizures',
                            name: 'numberOfOutpatientsSeizures',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'numberOfOutpatientsPoisoning',
                            name: 'numberOfOutpatientsPoisoning',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'numberOfOutpatientsAlteredMentalStatus',
                            name: 'numberOfOutpatientsAlteredMentalStatus',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'numberOfOutpatientsGastroenteritis',
                            name: 'numberOfOutpatientsGastroenteritis',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'numberOfOutpatientsHemorrhage',
                            name: 'numberOfOutpatientsHemorrhage',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'numberOfOutpatientsHypothermia',
                            name: 'numberOfOutpatientsHypothermia',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'numberOfOutpatientsCardiacCongenitalAnomaly',
                            name: 'numberOfOutpatientsCardiacCongenitalAnomaly',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'numberOfOutpatientsOtherCongenitalAnomaly',
                            name: 'numberOfOutpatientsOtherCongenitalAnomaly',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'numberOfOutpatientsMalnutrition',
                            name: 'numberOfOutpatientsMalnutrition',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'numberOfOutpatientsMeningitis',
                            name: 'numberOfOutpatientsMeningitis',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'numberOfOutpatientsCommunityAcquiredPneumonia',
                            name: 'numberOfOutpatientsCommunityAcquiredPneumonia',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'numberOfOutpatientsAspirationPneumonia',
                            name: 'numberOfOutpatientsAspirationPneumonia',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'numberOfOutpatientsModeratePrematurity',
                            name: 'numberOfOutpatientsModeratePrematurity',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'numberOfOutpatientsSeverePrematurity',
                            name: 'numberOfOutpatientsSeverePrematurity',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'numberOfOutpatientsOtherMedical',
                            name: 'numberOfOutpatientsOtherMedical',
                            as: 'input',
                            rules: yup.string()
                        },
                        {
                            header: 'gender'
                        },
                        {
                            label: 'admissionsMale',
                            name: 'admissionsMale',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'admissionsFemale',
                            name: 'admissionsFemale',
                            as: 'input',
                            rules: a
                        },
                    ]
                },
            ],
        };
        return {
            formSchema,
            department: "NICU_PAED",
        };
    },
});
</script>