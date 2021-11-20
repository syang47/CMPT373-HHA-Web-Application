<style>

    .background {
        height: 100%;
        position: absolute;
        width: 100%;
        overflow: auto;
    }

</style>

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
        const formSchema = {
            fields: [
                {
                    label: 'bedsAvailable',
                    name: 'bedsAvailable',
                    as: 'input',
                    rules: yup.number().min(0, "Cannot be negative.").required("Required.").default(0),
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