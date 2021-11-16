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

<style>
   .background {
        height: 100%;
        position: relative;
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
    .signup-form{
        width: 400px;
        margin: 0 auto;
        padding: 30px 0;
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
</style>