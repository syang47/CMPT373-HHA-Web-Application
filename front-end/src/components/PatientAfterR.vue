<template>
    <FieldArray name="diedAfter48hPatient" v-slot="{ fields, push, remove }">
        <fieldset
            class="form-group"
            v-for="(field, idx) in fields"
            :key="field.key"
        >
        <!-- Radio buttons -->
        <div>
            <legend>{{ $t('patient.patient') }} {{ idx+1 }} {{ $t('patient.diagnosis') }}: </legend>
            <div class="form-check">
                <Field class="form-check-input" id="option1" :name="`diedAfter48hPatient[${idx}].diedAfter48hOption`" type="radio" value="SCI"></Field>
                <label class="form-check-label" for="option1">{{ $t('patient.sci') }}</label>
            </div>
            <div class="form-check">
                <Field class="form-check-input" id="option2" :name="`diedAfter48hPatient[${idx}].diedAfter48hOption`" type="radio" value="CVA"></Field>
                <label class="form-check-label" for="option2">{{ $t('patient.cva') }}</label>
            </div>
            <div class="form-check">
                <Field class="form-check-input" id="option3" :name="`diedAfter48hPatient[${idx}].diedAfter48hOption`" type="radio" value="Other"></Field>
                <label class="form-check-label" for="option3">{{ $t('patient.other') }}</label>
            </div>
            <br>
            <br>
            <ErrorMessage :name="`diedAfter48hPatient[${idx}].diedAfter48hOption`" class="error-feedback" />
        </div>

        <!-- Input boxed list -->
        <div>
            <br>
            <div class="my-3">
                <label :for="`diedAfter48hAge_${idx}`">{{ $t('patient.age') }}</label>
                <Field class="form-control"
                    :id="`diedAfter48hAge_${idx}`" 
                    @input="$emit('update:modelValue', Object.keys(fields).length)"
                    :name="`diedAfter48hPatient[${idx}].diedAfter48hAge`" />
                <ErrorMessage :name="`diedAfter48hPatient[${idx}].diedAfter48hAge`" class="error-feedback" />
            </div>
            <br>
            <div class="my-3">
                <legend :for="`diedAfter48hCause_${idx}`">{{ $t('patient.patient') }} {{ idx+1 }} {{ $t('patient.causeOfDeath') }}</legend>
                <Field class="form-control"
                    :id="`diedAfter48hCause_${idx}`"
                    :name="`diedAfter48hPatient[${idx}].diedAfter48hCause`" />
                <ErrorMessage :name="`diedAfter48hPatient[${idx}].diedAfter48hCause`" class="error-feedback" />
            </div>
        </div>

        <button class="btn btn-danger btn-block" type="button" @click="remove(idx)">{{ $t('patient.removePatient') }}</button>
        </fieldset>

        <button class="btn btn-primary btn-block" type="button" @click="push({ 
            diedAfter48hOption: '', 
            diedAfter48hAge: '', 
            diedAfter48hCause: '', 
            })">
        {{ $t('patient.newPatient') }}
        </button>
    </FieldArray>

</template>

<script lang="ts" type="text/typescript">
import { FieldArray, Field, ErrorMessage } from 'vee-validate';
import { defineComponent } from 'vue';
export default defineComponent({
  name: 'PatientRehab',
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