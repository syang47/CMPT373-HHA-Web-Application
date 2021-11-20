<template>
    <DynamicForm :schema="formSchema" :department="department" :formTitle="formTitle"/>
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
                    label: 'msppData.bedsAvailable',
                    name: 'bedsAvailable',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'msppData.bedDays',
                    name: 'bedDays',
                    as: 'input',
                    rules: r
                },
                {
                    label: 'msppData.patientDays',
                    name: 'patientDays',
                    as: 'input',
                    rules: r
                },
                {
                    label: 'msppData.hospitalised',
                    name: 'hospitalised',
                    as: 'input',
                    rules: r,
                    children: [
                        {
                            label: 'msppData.hospitalisedNICU',
                            name: 'hospitalisedNICU',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.hospitalisedPAED',
                            name: 'hospitalisedPAED',
                            as: 'input',
                            rules: a
                        },
                    ]
                },
                {
                    label: 'msppData.dischargedAlive',
                    name: 'dischargedAlive',
                    as: 'input',
                    rules: r,
                    children: [
                        {
                            label: 'msppData.ofTotalDischargedNICU',
                            name: 'NICUDischarged',
                            as: 'input',
                            rules: a
                        },
                    ]
                },
                {
                    label: 'msppData.diedBefore48h',
                    name: 'diedBefore48h',
                    as: 'input',
                    rules: r,
                    children: [
                        {
                            label: 'msppData.diedNICUBefore48h',
                            name: 'diedInNICUBefore48',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.diedPAEDBefore48h',
                            name: 'diedInPaedBefore48',
                            as: 'input',
                            rules: a
                        },
                    ]
                },
                {
                    label: 'msppData.diedAfter48h',
                    name: 'diedAfter48h',
                    as: 'input',
                    rules: r,
                    children: [
                        {
                            label: 'msppData.diedNICUAfter48h',
                            name: 'diedInNICUAfter48',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.diedNICUAfter48h',
                            name: 'diedInPaedAfter48',
                            as: 'input',
                            rules: a
                        },
                    ]
                },
                {
                    label: 'msppData.daysHospitalised',
                    name: 'daysHospitalised',
                    as: 'input',
                    rules: r
                },
                {
                    label: 'msppData.referrals',
                    name: 'referrals',
                    as: 'input',
                    rules: r
                },
                {
                    label: 'msppData.transfers',
                    name: 'transfers',
                    as: 'input',
                    rules: r
                },
                {
                    label: 'msppData.selfDischarged',
                    name: 'selfDischarged',
                    as: 'input',
                    rules: r,
                    children: [
                        {
                            header: 'msppData.reasonSelfDischarge'
                        },
                        {
                            label: 'msppData.financeCare',
                            name: 'financeCannotAfford',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.financeAvoidPay',
                            name: 'financeAvoidPay',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.religiousCultural',
                            name: 'reasonCultural',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.personalFamily',
                            name: 'reasonPersonal',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.other',
                            name: 'otherReason',
                            as: 'input',
                            rules: a
                        },
                    ]
                },
                {
                    label: 'msppData.stayedInTheWard',
                    name: 'stayedInTheWard',
                    as: 'input',
                    rules: r
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
                            rules: a
                        },
                        {
                            header: 'msppData.ageOfInfant'
                        },
                        {
                            label: 'msppData.extremePreterm',
                            name: 'admissionsExtremelyPreterm',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.veryPreterm',
                            name: 'admissionsVeryPreterm',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.modToLatePreterm',
                            name: 'admissionsModerateToLatePreterm',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.fullTerm',
                            name: 'admissionsFullTerm',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.olderThanNeonate',
                            name: 'admissionsOlderThanNeonate',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.age4w_5y',
                            name: 'admissionsAge4WeeksTo5',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.age6_11',
                            name: 'admissionsAge6To11',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.age12_18',
                            name: 'admissionsAge12To18',
                            as: 'input',
                            rules: a
                        },
                        {
                            header: 'msppData.gender'
                        },
                        {
                            label: 'msppData.male',
                            name: 'admissionsMale',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.female',
                            name: 'admissionsFemale',
                            as: 'input',
                            rules: a
                        },
                        {
                            header: 'msppData.mainCond'
                        },
                        {
                            label: 'msppData.respiratoryArrest',
                            name: 'admissionsRespiratoryArrest',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.traumaticInjury',
                            name: 'admissionsTraumaticInjury',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.septicShock',
                            name: 'admissionsSepticShock',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.hypoShock',
                            name: 'admissionsHypovolemicShock',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.seizureConvulsion',
                            name: 'admissionsSeizures',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.poisoning',
                            name: 'admissionsPoisoning',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.altMentalStatus',
                            name: 'admissionsAlteredMentalStatus',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.gastro',
                            name: 'admissionsGastroenteritis',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.hemorrhage',
                            name: 'admissionsHemorrhage',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.hypothermia',
                            name: 'admissionsHypothermia',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.cardiacAnomaly',
                            name: 'admissionsCardiacCongenitalAnomaly',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.otherAnomaly',
                            name: 'admissionsOtherCongenitalAnomaly',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.malnutrition',
                            name: 'admissionsMalnutrition',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.meningitis',
                            name: 'admissionsMeningitis',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.communityPneum',
                            name: 'admissionsCommunityAcquiredPneumonia',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.aspirationPneum',
                            name: 'admissionsAspirationPneumonia',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.modPrematurity',
                            name: 'admissionsModeratePrematurity',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.severePrematurity',
                            name: 'admissionsSeverePrematurity',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.otherMedical',
                            name: 'admissionsOtherMedical',
                            as: 'input',
                            rules: yup.string()
                        },
                    ]
                },
                
                {
                    label: 'msppData.numberOfOutpatients',
                    name: 'numberOfOutpatients',
                    as: 'input',
                    children: [
                        {
                            header: 'age'
                        },
                        {
                            label: 'msppData.extremePreterm',
                            name: 'numberOfOutpatientsExtremelyPreterm',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.veryPreterm',
                            name: 'numberOfOutpatientsVeryPreterm',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.modToLatePreterm',
                            name: 'numberOfOutpatientsModerateToLatePreterm',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.fullTerm',
                            name: 'numberOfOutpatientsFullTerm',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.olderThanNeonate',
                            name: 'numberOfOutpatientsOlderThanNeonate',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.age4w_5y',
                            name: 'numberOfOutpatientsAge4WeeksTo5',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.age6_11',
                            name: 'numberOfOutpatientsAge6To11',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.age12_18',
                            name: 'numberOfOutpatientsAge12To18',
                            as: 'input',
                            rules: a
                        },
                        {
                            header: 'msppData.mainCond'
                        },
                        {
                            label: 'msppData.respiratoryArrest',
                            name: 'numberOfOutpatientsRespiratoryArrest',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.traumaticInjury',
                            name: 'numberOfOutpatientsTraumaticInjury',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.septicShock',
                            name: 'numberOfOutpatientsSepticShock',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.hypoShock',
                            name: 'numberOfOutpatientsHypovolemicShock',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.seizureConvulsion',
                            name: 'numberOfOutpatientsSeizures',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.poisoning',
                            name: 'numberOfOutpatientsPoisoning',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.altMentalStatus',
                            name: 'numberOfOutpatientsAlteredMentalStatus',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.gastro',
                            name: 'numberOfOutpatientsGastroenteritis',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.hemorrhage',
                            name: 'numberOfOutpatientsHemorrhage',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.hypothermia',
                            name: 'numberOfOutpatientsHypothermia',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.cardiacAnomaly',
                            name: 'numberOfOutpatientsCardiacCongenitalAnomaly',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.otherAnomaly',
                            name: 'numberOfOutpatientsOtherCongenitalAnomaly',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.malnutrition',
                            name: 'numberOfOutpatientsMalnutrition',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.meningitis',
                            name: 'numberOfOutpatientsMeningitis',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.communityPneum',
                            name: 'numberOfOutpatientsCommunityAcquiredPneumonia',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.aspirationPneum',
                            name: 'numberOfOutpatientsAspirationPneumonia',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.modPrematurity',
                            name: 'numberOfOutpatientsModeratePrematurity',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.severePrematurity',
                            name: 'numberOfOutpatientsSeverePrematurity',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.otherMedical',
                            name: 'numberOfOutpatientsOtherMedical',
                            as: 'input',
                            rules: yup.string()
                        },
                        {
                            header: 'msppData.gender'
                        },
                        {
                            label: 'msppData.boy',
                            name: 'admissionsMale',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.girl',
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
            formTitle: 'msppData.nicupaedForm'
        };
    },
});
</script>