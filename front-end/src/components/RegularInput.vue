<template>
    <div v-if="field.label">
      <label :style="c" :for="field.name">{{ $t(field.label) }} </label>
    </div>
    <Field :as="field.as" :id="field.name" :name="field.name" :rules="field.rules" :value="modelValue" :placeholder="modelValue"
      @input="$emit('update:modelValue', $event.target.value)" class="form-control" />
    <ErrorMessage :name="field.name" class="error-feedback" />
</template>

<script lang="ts" type="text/typescript">
import { Field, ErrorMessage } from 'vee-validate';
import { defineComponent } from 'vue';
export default defineComponent({
  name: 'RegularInput',
  components: {
    Field,
    ErrorMessage
  },
  props: {
    field: {
      type: Object,
      required: true,
    },
    modelValue: {
    },
    c: {
      type:String
    }
  },
  emits: ['update:modelValue']
});
</script>