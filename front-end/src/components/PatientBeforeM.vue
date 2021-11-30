<template>
    <FieldArray name="diedBefore48hPatient" v-slot="{ fields, push, remove }" >
        <fieldset
            class="form-group"
            v-for="(field, idx) in fields"
            :key="field.key"
        >
        <legend style="color:green; text-align:center">Patient {{ idx+1 }}</legend>
        <label :for="`diedBefore48hAge_${idx}`">Age</label>
        <Field class="form-control"
                :id="`diedBefore48hAge_${idx}`" 
                :name="`diedBefore48hPatient[${idx}].diedBefore48hAge`" :value="modelValue"
                @input="$emit('update:modelValue', Object.keys(fields).length)"/>
        <ErrorMessage :name="`diedBefore48hPatient[${idx}].diedBefore48hAge`" class="error-feedback" />

        <label :for="`diedBefore48hCause_${idx}`">Cause of Death</label>
        <Field class="form-control"
                :id="`diedBefore48hCause_${idx}`"
                :name="`diedBefore48hPatient[${idx}].diedBefore48hCause`" />
        <ErrorMessage :name="`diedBefore48hPatient[${idx}].diedBefore48hCause`" class="error-feedback" />

        <button class="btn btn-outline-light btn-block" type="button" @click="remove(idx)">Remove patient</button>
        </fieldset>

        <button class="btn btn-outline-light btn-block" type="button" @click="push({ diedBefore48hAge: '', diedBefore48hCause: '' })">
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