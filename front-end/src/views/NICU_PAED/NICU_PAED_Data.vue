<template>

    <Form class="background" @submit="handleData" :validation-schema="dataSchema">
        <div class="signup-form text-monospace">
            <div class="text-center">
                <h2 class="font-weight-bold display-5 text-dark text-monospace">NICU/PAED MSPP Data Entry Form</h2>
            </div>
            <div v-if="!successful">
                <div class="form-group">
                    <label for="bedsAvailable">Beds Available</label>
                    <Field name="bedsAvailable" type="text" class="form-control" value=0 />
                    <ErrorMessage name="bedsAvailable" class="error-feedback" />
                </div>
                <div class="form-group">
                    <label for="bedDays">Bed Days</label>
                    <Field name="bedDays" type="text" class="form-control" value=0 />
                    <ErrorMessage name="bedDays" class="error-feedback" />
                </div>
                <div class="form-group">
                    <label for="patientDays">Patient Days</label>
                    <Field name="patientDays" type="text" class="form-control" value=0 />
                    <ErrorMessage name="patientDays" class="error-feedback" />
                </div>
                <div class="form-group">
                    <label for="hospitalized">Hospitalized</label>
                    <Field name="hospitalized" type="text" class="form-control" value=0 />
                    <ErrorMessage name="hospitalized" class="error-feedback" />
                </div>
                <div class="form-group">
                    <label for="dischargedAlive">Discharged Alive</label>
                    <Field name="dischargedAlive" type="text" class="form-control" value=0 />
                    <ErrorMessage name="dischargedAlive" class="error-feedback" />
                </div>
                <div class="form-group">
                    <label for="diedBefore48h">Died Before 48h</label>
                    <Field name="diedBefore48h" type="text" class="form-control" value=0 />
                    <ErrorMessage name="diedBefore48h" class="error-feedback" />
                </div>
                <div class="form-group">
                    <label for="diedAfter48h">Died After 48h</label>
                    <Field name="diedAfter48h" type="text" class="form-control" value=0 />
                    <ErrorMessage name="diedAfter48h" class="error-feedback" />
                </div>
                <div class="form-group">
                    <label for="daysHospitalised">Days Hospitalised</label>
                    <Field name="daysHospitalised" type="text" class="form-control" value=0 />
                    <ErrorMessage name="daysHospitalised" class="error-feedback" />
                </div>
                <div class="form-group">
                    <label for="referrals">Referrals</label>
                    <Field name="referrals" type="text" class="form-control" value=0 />
                    <ErrorMessage name="referrals" class="error-feedback" />
                </div>
                <div class="form-group">
                    <label for="transfers">Transfers</label>
                    <Field name="transfers" type="text" class="form-control" value=0 />
                    <ErrorMessage name="transfers" class="error-feedback" />
                </div>
                <div class="form-group">
                    <label for="selfDischarged">Self Discharged</label>
                    <Field name="selfDischarged" type="text" class="form-control" value=0 />
                    <ErrorMessage name="selfDischarged" class="error-feedback" />
                </div>
                <div class="form-group">
                    <label for="stayedInTheWard">Stayed In The Ward</label>
                    <Field name="stayedInTheWard" type="text" class="form-control" value=0 />
                    <ErrorMessage name="stayedInTheWard" class="error-feedback" />
                </div>
                <div class="form-group">
                    <label for="admissions">Admissions</label>
                    <Field name="admissions" type="text" class="form-control" value=0 />
                    <ErrorMessage name="admissions" class="error-feedback" />
                </div>
                <div class="form-group">
                    <button class="btn btn-outline-light btn-block" :disabled="loading">
                        <span v-show="loading" class="spinner-border spinner-border-sm"></span>
                        Submit
                    </button>
                </div>
            </div>
        </div>
    </Form>
    <div v-if="message" class="alert alert-danger" :class="successful ? 'alert-success' : 'alert-danger'">
        {{ message }}
    </div>
</template>

<script lang="ts" type="text/typescript">
import { Vue } from "vue-class-component";
import { defineComponent } from 'vue'
import { Form, Field, ErrorMessage } from "vee-validate";
import * as yup from "yup";
export default defineComponent({
    name: "NICU_PAED_Data",
    components: {
        Form,
        Field,
        ErrorMessage,
    },
    data() {
        const dataSchema = yup.object().shape({
            bedsAvailable: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            bedDays: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            patientDays: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            hospitalized: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            dischargedAlive: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            diedBefore48h: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            diedAfter48h: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            daysHospitalized: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            referrals: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            transfers: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            selfDischarged: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            stayedInTheWard: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            admissions: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
        });
        return {
            successful: false,
            loading: false,
            message: "",
            dataSchema,
        };
    },
    methods: {
        handleData(entry) {
            let token = JSON.parse(localStorage.getItem('user')!);
            if(token != null) {
                entry.department = token.roles[0].authority;
                this.$axios.post("/api/datainput", entry, {
                    headers: {
                        'Authorization': `Bearer ${token.jwt}`
                    }
                }).then(response => {
                        this.message = response.data;
                        this.successful = true;
                        this.loading = false;
                        if(response != null) {
                            console.log("entry successful: " + this.successful);
                            this.$router.push("/");
                        } else {
                            alert("entry could not be submitted");
                        }
                    }
                ).catch((error: any) => {
                      this.message =
                          (error.response &&
                          error.response.data &&
                          error.response.data.message) ||
                          error.message;
                      this.successful = false;
                      this.loading = false;
                      alert("entry could not be submitted");
                });
            }
        },

    }
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
        margin-bottm: 20px;
    }
</style>