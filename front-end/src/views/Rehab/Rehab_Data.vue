<style>

    .background {
        height: 100%;
        position: absolute;
        width: 100%;
        overflow: auto;
    }
    .form-control{
        height: 40px;
        box-shadow: none;
        color: #969fa4;
    }
    .form-control:focus{
        border-color: #5cb85c;
    }
    .signup-form h2{
        color: #636363;
        margin: 0 0 15px;
        position: relative;
        text-align: center;
    }
    .signup-form .form-group{
        margin-bottom: 20px;
    }
    .category-heading{
        font-size:20px;
    }
    table, th, td {
      border:1px solid black;
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
    name: "Rehab_Data",
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
                    specPatient: 1,
                },
                {
                    label: 'msppData.diedBefore48h',
                    name: 'diedBefore48h',
                    as: 'input',
                    rules: r,
                    patientBeforeR: 1
                },
                {
                    label: 'msppData.diedAfter48h',
                    name: 'diedAfter48h',
                    as: 'input',
                    rules: r,
                    patientAfterR: 1
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
                    children: [
                        {
                            header: 'msppData.reasonNotYetDischarged'
                        },
                        {
                            label: 'msppData.reasonNotReady',
                            name: 'reasonNotReady',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.reasonWoundCare',
                            name: 'reasonWoundCare',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.otherMedicalReason',
                            name: 'otherMedicalReason',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.reasonFinancial',
                            name: 'reasonFinancial',
                            as: 'input',
                            rules: a
                        },
                        {
                            header: 'msppData.lengthOfStayOfCurrentInpatients'
                        },
                        {
                            label: 'msppData.length1_3m',
                            name: 'length1_3m',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.length3_6m',
                            name: 'length3_6m',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.length6m_1y',
                            name: 'length6m_1y',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.length1_2y',
                            name: 'length1_2y',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.length2_3y',
                            name: 'length2_3y',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.length3_y',
                            name: 'length3_y',
                            as: 'input',
                            rules: a
                        },
                    ]
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

                        {
                            header: 'msppData.mainCondition'
                        },
                        {
                            label: 'msppData.mainConditionTetraplegia',
                            name: 'mainConditionTetraplegia',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionComplete',
                            name: 'mainConditionComplete',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionIncomplete',
                            name: 'mainConditionIncomplete',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionC1',
                            name: 'mainConditionC1',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionC2',
                            name: 'mainConditionC2',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionC3',
                            name: 'mainConditionC3',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionC4',
                            name: 'mainConditionC4',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionC5',
                            name: 'mainConditionC5',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionC6',
                            name: 'mainConditionC6',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionC7',
                            name: 'mainConditionC7',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionC8',
                            name: 'mainConditionC8',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionT1',
                            name: 'mainConditionT1',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionParaplegia',
                            name: 'mainConditionParaplegia',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionComplete2',
                            name: 'mainConditionComplete2',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionIncomplete2',
                            name: 'mainConditionIncomplete2',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionT2',
                            name: 'mainConditionT2',
                            as: 'input',
                            rules: a
                        },

                        {
                            label: 'msppData.mainConditionC4',
                            name: 'mainConditionC4',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionC5',
                            name: 'mainConditionC5',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionC6',
                            name: 'mainConditionC6',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionC7',
                            name: 'mainConditionC7',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionC8',
                            name: 'mainConditionC8',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionT1',
                            name: 'mainConditionT1',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionParaplegia',
                            name: 'mainConditionParaplegia',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionComplete2',
                            name: 'mainConditionComplete2',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionIncomplete2',
                            name: 'mainConditionIncomplete2',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionT2',
                            name: 'mainConditionT2',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionT3',
                            name: 'mainConditionT3',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionT4',
                            name: 'mainConditionT4',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionT5',
                            name: 'mainConditionT5',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionT6',
                            name: 'mainConditionT6',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionT7',
                            name: 'mainConditionT7',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionT8',
                            name: 'mainConditionT8',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionT9',
                            name: 'mainConditionT9',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionT10',
                            name: 'mainConditionT10',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionT11',
                            name: 'mainConditionT11',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionT12',
                            name: 'mainConditionT12',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionL1',
                            name: 'mainConditionL1',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionL2',
                            name: 'mainConditionL2',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionL3',
                            name: 'mainConditionL3',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionL4',
                            name: 'mainConditionL4',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionL5',
                            name: 'mainConditionL5',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionS1',
                            name: 'mainConditionS1',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionS2',
                            name: 'mainConditionS2',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionS3',
                            name: 'mainConditionS3',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionS4',
                            name: 'mainConditionS4',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionS5',
                            name: 'mainConditionS5',
                            as: 'input',
                            rules: a
                        },

                        {
                            blueHeader: 'msppData.causeOfSCI'
                        },
                        {
                            label: 'msppData.SCITransportAccident',
                            name: 'SCITransportAccident',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.SCIFall',
                            name: 'SCIFall',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.SCIAssault',
                            name: 'SCIAssault',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.SCISports',
                            name: 'SCISports',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.SCINonTraumaticSpinalCordDysfunction',
                            name: 'SCINonTraumaticSpinalCordDysfunction',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.SCIMedical',
                            name: 'SCIMedical',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.SCIOtherTraumaticReason',
                            name: 'SCIOtherTraumaticReason',
                            as: 'input',
                            rules: a
                        },
                        
                        {
                            blueHeader: 'msppData.ageRehab'
                        },
                        {
                            label: 'msppData.SCIAge0_5',
                            name: 'SCIAge0_5',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.SCIAge6_11',
                            name: 'SCIAge6_11',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.SCIAge12_18',
                            name: 'SCIAge12_18',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.SCIAge18_30',
                            name: 'SCIAge18_30',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.SCIAge31_50',
                            name: 'SCIAge31_50',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.SCIAge51_70',
                            name: 'SCIAge51_70',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.SCIAge70',
                            name: 'SCIAge70',
                            as: 'input',
                            rules: a
                        },

                        {
                            blueHeader: 'msppData.genderRehab'
                        },
                        {
                            label: 'msppData.SCIMale',
                            name: 'SCIMale',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.SCIFemale',
                            name: 'SCIFemale',
                            as: 'input',
                            rules: a
                        },

                        {
                            header: 'msppData.mainConditionCont'
                        },
                        {
                            label: 'msppData.mainConditionStroke',
                            name: 'mainConditionStroke',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionFracturedHip',
                            name: 'mainConditionFracturedHip',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionFracturedLongBones',
                            name: 'mainConditionFracturedLongBones',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionNeurodegenerativeDisease',
                            name: 'mainConditionNeurodegenerativeDisease',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionHeadInjury',
                            name: 'mainConditionHeadInjury',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionWoundCare',
                            name: 'mainConditionWoundCare',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionOtherMedical',
                            name: 'mainConditionOtherMedical',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.mainConditionOtherTrauma',
                            name: 'mainConditionOtherTrauma',
                            as: 'input',
                            rules: a
                        },

                        {
                            header: 'msppData.timeFromInjury'
                        },
                        {
                            label: 'msppData.timeLessThan1m',
                            name: 'timeLessThan1m',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.time1_2m',
                            name: 'time1_2m',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.time3m',
                            name: 'time3m',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.time6m',
                            name: 'time6m',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.time1y',
                            name: 'time1y',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.time2y',
                            name: 'time2y',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.timeMoreThan3y',
                            name: 'timeMoreThan3y',
                            as: 'input',
                            rules: a
                        },
                    ]
                },
                {
                    label: 'msppData.numberOfOutpatients',
                    name: 'numberOfOutpatients',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'msppData.returningOutpatients',
                    name: 'returningOutpatients',
                    as: 'input',
                    rules: r,
                },
                {
                    label: 'msppData.newOutpatient',
                    name: 'newOutpatient',
                    as: 'input',
                    rules: r,
                    children: [
                        {
                            header: 'msppData.mainConditionOfNewPatients'
                        },
                        {
                            label: 'msppData.newSCIParaplegia',
                            name: 'newSCIParaplegia',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.newSCITetraplegia',
                            name: 'newSCITetraplegia',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.newStroke',
                            name: 'newStroke',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.newFracturedHip',
                            name: 'newFracturedHip',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.newFracturedLongBones',
                            name: 'newFracturedLongBones',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.newNeurodegenerativeDisease',
                            name: 'newNeurodegenerativeDisease',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.newHeadInjury',
                            name: 'newHeadInjury',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.newWoundCare',
                            name: 'newWoundCare',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.newCerebralPalsy',
                            name: 'newCerebralPalsy',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.newDownSyndromel',
                            name: 'newDownSyndromel',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.newOther',
                            name: 'newOther',
                            as: 'input',
                            rules: a
                        },

                        {
                            header: 'msppData.ageOfNewpatients'
                        },
                        {
                            label: 'msppData.newAge0_5',
                            name: 'newAge0_5',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.newAge6_11',
                            name: 'newAge6_11',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.newAge12_18',
                            name: 'newAge12_18',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.newAge18_30',
                            name: 'newAge18_30',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.newAge31_50',
                            name: 'newAge31_50',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.newAge51_70',
                            name: 'newAge51_70',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.newAge70',
                            name: 'newAge70',
                            as: 'input',
                            rules: a
                        },

                        {
                            header: 'msppData.genderOfNewpatients'
                        },
                        {
                            label: 'msppData.newMale',
                            name: 'newMale',
                            as: 'input',
                            rules: a
                        },
                        {
                            label: 'msppData.newFemale',
                            name: 'newFemale',
                            as: 'input',
                            rules: a
                        }
                    ]
                }
            ]
        };   
        return {
            formSchema,
            department: "Rehab",
            formTitle: 'msppData.rehabForm'
        };
    }
});
</script>

