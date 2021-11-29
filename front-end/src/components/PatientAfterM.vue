<template>
    <FieldArray name="diedAfter48hPatient" v-slot="{ fields, push, remove }">
        <fieldset
            class="form-group"
            v-for="(field, idx) in fields"
            :key="field.key"
        >
        <div class="my-3">
          <legend style="color:green; text-align:center">Patient {{ idx+1 }}</legend>
        </div>
        <div class="mb-3">
          <label :for="`diedAfter48hAge_${idx}`">Age</label>
          <Field class="form-control"
                  :id="`diedAfter48hAge_${idx}`" 
                  @input="$emit('update:modelValue', Object.keys(fields).length)"
                  :name="`diedAfter48hPatient[${idx}].diedAfter48hAge`" />
          <ErrorMessage :name="`diedAfter48hPatient[${idx}].diedAfter48hAge`" class="error-feedback" />
        </div>

        <div class="mb-3">
          <label :for="`diedAfter48hCause_${idx}`">Cause of Death</label>
          <Field class="form-control"
                  :id="`diedAfter48hCause_${idx}`"
                  :name="`diedAfter48hPatient[${idx}].diedAfter48hCause`" />
          <ErrorMessage :name="`diedAfter48hPatient[${idx}].diedAfter48hCause`" class="error-feedback" />
        </div>

        <button class="btn btn-danger btn-block" type="button" @click="remove(idx)">Remove patient</button>
        </fieldset>

        <button class="btn btn-primary btn-block" type="button" @click="push({ diedBefore48hAge: '', diedBefore48hCause: '' })">
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