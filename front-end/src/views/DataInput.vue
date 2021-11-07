<template>
    <h1 style="color:#000000;">Awards</h1>
    <Form @submit="handleData" :validation-schema="datainputSchema">
        <div class="form-group">
            <label for="monthly">Monthly</label>
            <Field name="monthly" type="text" class="form-control" />
        </div>
        <div class="form-group">
            <label for="annual">Annual</label>
            <Field name="annual" type="text" class="form-control" />
        </div>
        <div class="form-group">
            <button class="btn btn-secondary" type="submit" value="Submit">Submit</button>
        </div>
    </Form>
</template>

<script lang="ts" type="text/typescript">
import { defineComponent } from 'vue'
import axios from 'axios';
import * as yup from "yup";
import {Form, Field} from "vee-validate";
export default defineComponent({
    name: "DataInput",
    components: {
        Form,
        Field
    },
    data: function() {
        const datainputSchema = yup.object().shape({
            monthly: yup.string().required(),
            annual: yup.string().required()
        });
        return {
            datainputSchema,
            message: " ",
        };
    },
    methods: {
        handleData(entry) {
            let self = this;
            const token = JSON.parse(localStorage.getItem('user')!);
            this.$axios.post("/datainput", entry, {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`
                }
            }).then(response => {
                this.message = response.data;
                if(response != null) {
                    console.log("entry success");
                    this.$router.push("/leadersboard");                    
                } else {
                    alert("entry is empty");
                }
                // this.$router.push("/leadersboard");
            }).catch((error: any) => {
                this.message = (error.response && error.response.data && error.response.data.message) || error.message;
                alert("couldn't save")
            });
        }
    }
});

</script>