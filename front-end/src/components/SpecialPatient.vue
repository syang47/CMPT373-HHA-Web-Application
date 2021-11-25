<template>
<FieldArray name="dischargedAlivePatient" v-slot="{ fields, push, remove }">
    <fieldset
        class="form-group"
        v-for="(field, idx) in fields"
        :key="field.key" 
    >
    <legend style="color:green"><strong>Patient {{ idx+1 }} Discharged Diagnosis: </strong></legend>


    <!-- Radio buttons -->
    <div>
        <div class="form-check">
            <Field class="form-check-input" id="option1" :name="`dischargedAlivePatient[${idx}].dischargedAliveOption`" type="radio" value="SCI"></Field>
            <label class="form-check-label" for="option1"> SCI</label>
        </div>
        <div class="form-check">
            <Field class="form-check-input" id="option2" :name="`dischargedAlivePatient[${idx}].dischargedAliveOption`" type="radio" value="Stroke"></Field>
            <label class="form-check-label" for="option2"> Stroke</label>
        </div>
        <div class="form-check">
            <Field class="form-check-input" id="option3" :name="`dischargedAlivePatient[${idx}].dischargedAliveOption`" type="radio" value="Other"></Field>
            <label class="form-check-label" for="option3"> Other</label>
        </div>
        <br>
        <br>
        <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveOption`" class="error-feedback" />
    </div>


    <!-- Input boxed list -->
    <div>
        <legend :for="`dischargedAlivePatientNo_${idx}`" style="color:green"><strong>Patient {{ idx+1 }}: No. Days in Rehab Unit from admission to discharge: </strong></legend>
        <br>
        <Field class="form-control"
            type="number"
            :id="`dischargedAlivePatientNo_${idx}`" 
            :name="`dischargedAlivePatient[${idx}].dischargedAlivePatientNo`"
            @input="$emit('update:modelValue', Object.keys(fields).length)"/>
        <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAlivePatientNo`" class="error-feedback" />


        <br>
        <label style="color:green"><strong>Discharge Reason</strong></label>
        <br>
        <label :for="`dischargedAliveAllGoals_${idx}`">All goals met</label>
        <Field class="form-control"
            :id="`dischargedAliveAllGoals_${idx}`"
            @input="$emit('update:modelValue', Object.keys(fields).length)"
            :name="`dischargedAlivePatient[${idx}].dischargedAliveAllGoals`" />
        <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveAllGoals`" class="error-feedback" />
        <br>
        <label :for="`dischargedAliveGoalsPartially_${idx}`">Goals partially met, sufficient for discharge</label>
        <Field class="form-control"
            :id="`dischargedAliveGoalsPartially_${idx}`"
            @input="$emit('update:modelValue', Object.keys(fields).length)"/>
            :name="`dischargedAlivePatient[${idx}].dischargedAliveGoalsPartially`" />
        <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveGoalsPartially`" class="error-feedback" />
        <br>
        <label :for="`dischargedAliveNoGoals_${idx}`">Goals not met, discharged for alternate reason</label>
        <Field class="form-control"
            :id="`dischargedAliveNoGoals_${idx}`"
            @input="$emit('update:modelValue', Object.keys(fields).length)"
            :name="`dischargedAlivePatient[${idx}].dischargedAliveNoGoals`" />
        <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveNoGoals`" class="error-feedback" />


        <br>
        <label style="color:green"><strong>Discharge Outcome (ADLs/Self-Care)</strong></label>
        <br>
        <label :for="`dischargedAliveADLsIndependent_${idx}`">Independent </label>
        <Field class="form-control"
            :id="`dischargedAliveADLsIndependent_${idx}`"
            @input="$emit('update:modelValue', Object.keys(fields).length)"
            :name="`dischargedAlivePatient[${idx}].dischargedAliveADLsIndependent`" />
        <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveADLsIndependent`" class="error-feedback" />
        <br>
        <label :for="`dischargedAliveADLsModifiedIndependent_${idx}`">Modified Independent</label>
        <Field class="form-control"
            :id="`dischargedAliveADLsModifiedIndependent_${idx}`"
            @input="$emit('update:modelValue', Object.keys(fields).length)"
            :name="`dischargedAlivePatient[${idx}].dischargedAliveADLsModifiedIndependent`" />
        <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveADLsModifiedIndependent`" class="error-feedback" />
        <br>
        <label :for="`dischargedAliveADLsSupervision_${idx}`">Supervision</label>
        <Field class="form-control"
            :id="`dischargedAliveADLsSupervision_${idx}`"
            @input="$emit('update:modelValue', Object.keys(fields).length)"
            :name="`dischargedAlivePatient[${idx}].dischargedAliveADLsSupervision`" />
        <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveADLsSupervision`" class="error-feedback" />
        <br>
        <label :for="`dischargedAliveADLsMinimumAssistance_${idx}`">Minimum Assistance</label>
        <Field class="form-control"
            :id="`dischargedAliveADLsMinimumAssistance_${idx}`"
            @input="$emit('update:modelValue', Object.keys(fields).length)"
            :name="`dischargedAlivePatient[${idx}].dischargedAliveADLsMinimumAssistance`" />
        <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveADLsMinimumAssistance`" class="error-feedback" />
        <br>
        <label :for="`dischargedAliveADLsModerateAssistance_${idx}`">Moderate Assistance</label>
        <Field class="form-control"
            :id="`dischargedAliveADLsModerateAssistance_${idx}`"
            @input="$emit('update:modelValue', Object.keys(fields).length)"
            :name="`dischargedAlivePatient[${idx}].dischargedAliveADLsModerateAssistance`" />
        <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveADLsModerateAssistance`" class="error-feedback" />
        <br>
        <label :for="`dischargedAliveADLsMaximumAssistance_${idx}`">Maximum Assistance</label>
        <Field class="form-control"
            :id="`dischargedAliveADLsMaximumAssistance_${idx}`"
            @input="$emit('update:modelValue', Object.keys(fields).length)"
            :name="`dischargedAlivePatient[${idx}].dischargedAliveADLsMaximumAssistance`" />
        <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveADLsMaximumAssistance`" class="error-feedback" />
        <br>
        <label :for="`dischargedAliveADLsDependent_${idx}`">Dependent</label>
        <Field class="form-control"
            :id="`dischargedAliveADLsDependent_${idx}`"
            @input="$emit('update:modelValue', Object.keys(fields).length)"
            :name="`dischargedAlivePatient[${idx}].dischargedAliveADLsDependent`" />
        <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveADLsDependent`" class="error-feedback" />


        <br>
        <label style="color:green"><strong>Discharge Outcome (Transfers and Mobility)</strong></label>
        <br>
        <label :for="`dischargedAliveTransfersIndependent_${idx}`">Independent </label>
        <Field class="form-control"
            :id="`dischargedAliveTransfersIndependent_${idx}`"
            @input="$emit('update:modelValue', Object.keys(fields).length)"
            :name="`dischargedAlivePatient[${idx}].dischargedAliveTransfersIndependent`" />
        <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveTransfersIndependent`" class="error-feedback" />
        <br>
        <label :for="`dischargedAliveTransfersModifiedIndependent_${idx}`">Modified Independent</label>
        <Field class="form-control"
            :id="`dischargedAliveTransfersModifiedIndependent_${idx}`"
            @input="$emit('update:modelValue', Object.keys(fields).length)"
            :name="`dischargedAlivePatient[${idx}].dischargedAliveTransfersModifiedIndependent`" />
        <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveTransfersModifiedIndependent`" class="error-feedback" />
        <br>
        <label :for="`dischargedAliveTransfersSupervision_${idx}`">Supervision</label>
        <Field class="form-control"
            :id="`dischargedAliveTransfersSupervision_${idx}`"
            @input="$emit('update:modelValue', Object.keys(fields).length)"
            :name="`dischargedAlivePatient[${idx}].dischargedAliveTransfersSupervision`" />
        <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveTransfersSupervision`" class="error-feedback" />
        <br>
        <label :for="`dischargedAliveTransfersMinimumAssistance_${idx}`">Minimum Assistance</label>
        <Field class="form-control"
            :id="`dischargedAliveTransfersMinimumAssistance_${idx}`"
            @input="$emit('update:modelValue', Object.keys(fields).length)"
            :name="`dischargedAlivePatient[${idx}].dischargedAliveTransfersMinimumAssistance`" />
        <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveTransfersMinimumAssistance`" class="error-feedback" />
        <br>
        <label :for="`dischargedAliveTransfersModerateAssistance_${idx}`">Moderate Assistance</label>
        <Field class="form-control"
            :id="`dischargedAliveTransfersModerateAssistance_${idx}`"
            @input="$emit('update:modelValue', Object.keys(fields).length)"
            :name="`dischargedAlivePatient[${idx}].dischargedAliveTransfersModerateAssistance`" />
        <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveTransfersModerateAssistance`" class="error-feedback" />
        <br>
        <label :for="`dischargedAliveTransfersMaximumAssistance_${idx}`">Maximum Assistance</label>
        <Field class="form-control"
            :id="`dischargedAliveTransfersMaximumAssistance_${idx}`"
            @input="$emit('update:modelValue', Object.keys(fields).length)"
            :name="`dischargedAlivePatient[${idx}].dischargedAliveTransfersMaximumAssistance`" />
        <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveTransfersMaximumAssistance`" class="error-feedback" />
        <br>
        <label :for="`dischargedAliveTransfersDependent_${idx}`">Dependent</label>
        <Field class="form-control"
            :id="`dischargedAliveTransfersDependent_${idx}`"
            @input="$emit('update:modelValue', Object.keys(fields).length)"
            :name="`dischargedAlivePatient[${idx}].dischargedAliveTransfersDependent`" />
        <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveTransfersDependent`" class="error-feedback" />


        <br>
        <label style="color:green"><strong>Mobility Aid/Assistive Device Given?</strong></label>
        <br>
        <label :for="`dischargedAliveWheelchair_${idx}`">Wheelchair</label>
        <Field class="form-control"
            :id="`dischargedAliveWheelchair_${idx}`"
            @input="$emit('update:modelValue', Object.keys(fields).length)"
            :name="`dischargedAlivePatient[${idx}].dischargedAliveWheelchair`" />
        <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveWheelchair`" class="error-feedback" />
        <br>
        <label :for="`dischargedAliveWalker_${idx}`">Walker</label>
        <Field class="form-control"
            :id="`dischargedAliveWalker_${idx}`"
            @input="$emit('update:modelValue', Object.keys(fields).length)"
            :name="`dischargedAlivePatient[${idx}].dischargedAliveWalker`" />
        <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveWalker`" class="error-feedback" />
        <br>
        <label :for="`dischargedAliveCane_${idx}`">Cane</label>
        <Field class="form-control"
            :id="`dischargedAliveCane_${idx}`"
            @input="$emit('update:modelValue', Object.keys(fields).length)"
            :name="`dischargedAlivePatient[${idx}].dischargedAliveCane`" />
        <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveCane`" class="error-feedback" />
        <br>
        <label :for="`dischargedAliveCrutches_${idx}`">Crutches</label>
        <Field class="form-control"
            :id="`dischargedAliveCrutches_${idx}`"
            @input="$emit('update:modelValue', Object.keys(fields).length)"
            :name="`dischargedAlivePatient[${idx}].dischargedAliveCrutches`" />
        <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveCrutches`" class="error-feedback" />


        <br>
        <label style="color:green"><strong>Discharge Location</strong></label>
        <br>
        <label :for="`dischargedAliveHomeAlone_${idx}`">Return home, alone</label>
        <Field class="form-control"
            :id="`dischargedAliveHomeAlone_${idx}`"
            @input="$emit('update:modelValue', Object.keys(fields).length)"
            :name="`dischargedAlivePatient[${idx}].dischargedAliveHomeAlone`" />
        <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveHomeAlone`" class="error-feedback" />
        <br>
        <label :for="`dischargedAliveHomeWithOther_${idx}`">Return home, with family/caregiver(s)</label>
        <Field class="form-control"
            :id="`dischargedAliveHomeWithOther_${idx}`"
            @input="$emit('update:modelValue', Object.keys(fields).length)"
            :name="`dischargedAlivePatient[${idx}].dischargedAliveHomeWithOther`" />
        <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveHomeWithOther`" class="error-feedback" />
        <br>
        <label :for="`dischargedAliveHospital_${idx}`">Admitted to hospital</label>
        <Field class="form-control"
            :id="`dischargedAliveHospital_${idx}`"
            @input="$emit('update:modelValue', Object.keys(fields).length)"
            :name="`dischargedAlivePatient[${idx}].dischargedAliveHospital`" />
        <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveHospital`" class="error-feedback" />


        <br>
        <label style="color:green"><strong>Discharge Employment Status</strong></label>
        <br>
        <label :for="`dischargedAliveEmployed_${idx}`">Employed</label>
        <Field class="form-control"
            :id="`dischargedAliveEmployed_${idx}`"
            @input="$emit('update:modelValue', Object.keys(fields).length)"
            :name="`dischargedAlivePatient[${idx}].dischargedAliveEmployed`" />
        <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveEmployed`" class="error-feedback" />
        <br>
        <label :for="`dischargedAliveUnableToFindWork_${idx}`">Unemployed, unable to find work</label>
        <Field class="form-control"
            :id="`dischargedAliveUnableToFindWork_${idx}`"
            @input="$emit('update:modelValue', Object.keys(fields).length)"
            :name="`dischargedAlivePatient[${idx}].dischargedAliveUnableToFindWork`" />
        <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveUnableToFindWork`" class="error-feedback" />
        <br>
        <label :for="`dischargedAliveDueToCondition_${idx}`">Unemployed, due to condition</label>
        <Field class="form-control"
            :id="`dischargedAliveDueToCondition_${idx}`"
            @input="$emit('update:modelValue', Object.keys(fields).length)"
            :name="`dischargedAlivePatient[${idx}].dischargedAliveDueToCondition`" />
        <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveDueToCondition`" class="error-feedback" />
        <br>
        <label :for="`dischargedAliveRetired_${idx}`">Retired, not working due to age</label>
        <Field class="form-control"
            :id="`dischargedAliveRetired_${idx}`"
            @input="$emit('update:modelValue', Object.keys(fields).length)"
            :name="`dischargedAlivePatient[${idx}].dischargedAliveRetired`" />
        <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveRetired`" class="error-feedback" />
    </div>

    

    <button class="btn btn-outline-light btn-block" type="button" @click="remove(idx)">Remove patient X</button>
    </fieldset>

    <button class="btn btn-outline-light btn-block" type="button" @click="push({ 
        dischargedAliveOption: '',

        dischargedAlivePatientNo: '',

        dischargedAliveAllGoals: '',
        dischargedAliveGoalsPartially: '',
        dischargedAliveNoGoals: '',

        dischargedAliveADLsIndependent: '',
        dischargedAliveADLsModifiedIndependent: '',
        dischargedAliveADLsSupervision: '',
        dischargedAliveADLsMinimumAssistance: '',
        dischargedAliveADLsModerateAssistance: '',
        dischargedAliveADLsMaximumAssistance: '',
        dischargedAliveADLsDependent: '',

        dischargedAliveTransfersIndependent: '',
        dischargedAliveTransfersModifiedIndependent: '',
        dischargedAliveTransfersSupervision: '',
        dischargedAliveTransfersMinimumAssistance: '',
        dischargedAliveTransfersModerateAssistance: '',
        dischargedAliveTransfersMaximumAssistance: '',
        dischargedAliveTransfersDependent: '',

        dischargedAliveWheelchair: '',
        dischargedAliveWalker: '',
        dischargedAliveCane: '',
        dischargedAliveCrutches: '',

        dischargedAliveHomeAlone: '',
        dischargedAliveHomeWithOther: '',
        dischargedAliveHospital: '',

        dischargedAliveEmployed: '',
        dischargedAliveUnableToFindWork: '',
        dischargedAliveDueToCondition: '',
        dischargedAliveRetired: '',
        })">
    New Patient + 
    </button>
</FieldArray>
</template>

<script lang="ts" type="text/typescript">
import { FieldArray, Field, ErrorMessage } from 'vee-validate';
import { defineComponent } from 'vue';
export default defineComponent({
  name: 'Patient',
  components: {
    FieldArray,
    Field,
    ErrorMessage
  },
  props: {
    modelValue: {
        
    },
  },
  emits: ['update:modelValue']
});
</script>