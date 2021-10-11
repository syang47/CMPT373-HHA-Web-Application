<template>

    <Form class="background" @submit="handleData" :validation-schema="dataSchema">
        <div class="signup-form text-monospace">
            <div class="text-center">
                <h2 class="font-weight-bold display-5 text-dark text-monospace">MSPP Data Entry Form</h2>
            </div>
            <div v-if="!successful">
                <div class="form-group">
                    <label for="bedAvailable">Beds Available</label>
                    <Field name="bedAvailable" type="text" class="form-control" value=0 />
                    <ErrorMessage name="bedAvailable" class="error-feedback" />
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

                <h4 style="color:red; text-align:center">Births</h4>
                <table>
                    <tr>
                        <th>Births</th>
                        <th>Normal</th>
                        <th>Césarienne</th>
                        <th>Instrumentalsé</th>
                    </tr>
                    <tr>
                        <td>Weight&#60;1.5kg</td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="weight_less_normal" type="text" class="form-control" value=0 />
                            <ErrorMessage name="weight_less_Normal" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="weight_less_cesarienne" type="text" class="form-control" value=0 />
                            <ErrorMessage name="weight_less_cesarienne" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="weight_less_instrumentalse" type="text" class="form-control" value=0 />
                            <ErrorMessage name="weight_less_instrumentalse" class="error-feedback" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>1.5kg&LessSlantEqual;Weight&#60;2.5kg</td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="weight_within_normal" type="text" class="form-control" value=0 />
                            <ErrorMessage name="weight_within_normal" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="weight_within_cesarienne" type="text" class="form-control" value=0 />
                            <ErrorMessage name="weight_within_cesarienne" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="weight_within_instrumentalse" type="text" class="form-control" value=0 />
                            <ErrorMessage name="weight_within_instrumentalse" class="error-feedback" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>2.5kg&#x02A7E;Weight</td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="weight_more_normal" type="text" class="form-control" value=0 />
                            <ErrorMessage name="weight_more_normal" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="weight_more_cesarienne" type="text" class="form-control" value=0 />
                            <ErrorMessage name="weight_more_cesarienne" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="weight_more_instrumentalse" type="text" class="form-control" value=0 />
                            <ErrorMessage name="weight_more_instrumentalse" class="error-feedback" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Not Weighted</td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="not_weighted_normal" type="text" class="form-control" value=0 />
                            <ErrorMessage name="not_weighted_normal" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="not_weighted_cesarienne" type="text" class="form-control" value=0 />
                            <ErrorMessage name="not_weighted_cesarienne" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="not_weighted_instrumentalse" type="text" class="form-control" value=0 />
                            <ErrorMessage name="not_weighted_instrumentalse" class="error-feedback" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Immediately breastfed</td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="immediately_breastfed_normal" type="text" class="form-control" value=0 />
                            <ErrorMessage name="immediately_breastfed_normal" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="immediately_breastfed_cesarienne" type="text" class="form-control" value=0 />
                            <ErrorMessage name="immediately_breastfed_cesarienne" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="immediately_breastfed_instrumentalse" type="text" class="form-control" value=0 />
                            <ErrorMessage name="immediately_breastfed_instrumentalse" class="error-feedback" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Skin to Skin Therapy</td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="skin_therapy_normal" type="text" class="form-control" value=0 />
                            <ErrorMessage name="skin_therapy_normal" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="skin_therapy_cesarienne" type="text" class="form-control" value=0 />
                            <ErrorMessage name="skin_therapy_cesarienne" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="skin_therapy_instrumentalse" type="text" class="form-control" value=0 />
                            <ErrorMessage name="skin_therapy_instrumentalse" class="error-feedback" />
                            </div>
                        </td>
                    </tr>
                </table>
                <h4 style="color:red; text-align:center">Post Natal</h4>

                <div class="form-group">
                <label for="Vitamin_A">Breastfeeding Women Receiving Vitamin A</label>
                <Field name="Vitamin_A" type="text" class="form-control" value=0 />
                <ErrorMessage name="Vitamin_A" class="error-feedback" />
                </div>
                <div class="form-group">
                <label for="MUAC_210mm">Breastfeeding Women with MUAC&#60;210mm </label>
                <Field name="MUAC_210mm" type="text" class="form-control" value=0 />
                <ErrorMessage name="MUAC_210mm" class="error-feedback" />
                </div>
                <div class="form-group">
                <label for="Malnutrition">Breastfeeding Women with Malnutrition Support</label>
                <Field name="Malnutrition" type="text" class="form-control" value=0 />
                <ErrorMessage name="Malnutrition" class="error-feedback" />
                </div>
                <div class="form-group">
                <label for="domestic_visits">Domestic Visits in 0-3 Days</label>
                <Field name="domestic_visits" type="text" class="form-control" value=0 />
                <ErrorMessage name="domestic_visits" class="error-feedback" />
                </div>
                <table>
                    <tr>
                        <th></th>
                        <th>0-6 heures</th>
                        <th>7h-6 jours</th>
                        <th>7-42 jours</th>
                    </tr>
                    <tr>
                        <td>
                        Post natal consultations
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="post_natal_first" type="text" class="form-control" value=0 />
                            <ErrorMessage name="post_natal_first" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="post_natal_second" type="text" class="form-control" value=0 />
                            <ErrorMessage name="post_natal_second" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="post_natal_third" type="text" class="form-control" value=0 />
                            <ErrorMessage name="post_natal_third" class="error-feedback" />
                            </div>
                        </td>
                    </tr>
                </table>
                <h4 style="color:red; text-align:center">Complications</h4>
                <div class="form-group">
                <label for="complications_recorded">Number of obstetric complications recorded</label>
                <Field name="complications_recorded" type="text" class="form-control" value=0 />
                <ErrorMessage name="complications_recorded" class="error-feedback" />
                </div>
                <div class="form-group">
                <label for="complications_referred">Number of obstetric complications referred</label>
                <Field name="complications_referred" type="text" class="form-control" value=0 />
                <ErrorMessage name="complications_referred" class="error-feedback" />
                </div>
                <h4 style="color:red; text-align:center">Number of Stillborns</h4>
                <div class="form-group">
                <label for="stillborns_maceres">Macérés</label>
                <Field name="stillborns_maceres" type="text" class="form-control" value=0 />
                <ErrorMessage name="stillborns_maceres" class="error-feedback" />
                </div>
                <div class="form-group">
                <label for="stillborns_non_maceres">Non Macérés</label>
                <Field name="stillborns_non_maceres" type="text" class="form-control" value=0 />
                <ErrorMessage name="stillborns_non_maceres" class="error-feedback" />
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
    <div
    v-if="message"
    class="alert alert-danger"
    :class="successful ? 'alert-success' : 'alert-danger'"
    >
        {{ message }}
    </div>
<form method="GET" id="my_form"></form>

</template>

<script lang="ts" type="text/typescript">
import { Vue } from "vue-class-component";
import { defineComponent } from 'vue'
import { Form, Field, ErrorMessage } from "vee-validate";
import * as yup from "yup";
export default defineComponent({
    name: "MSPP",
    components: {
        Form,
        Field,
        ErrorMessage,
    },
    data() {
        const dataSchema = yup.object().shape({
            bedsAvailable: yup
                .number(),
                //.min(0, "Cannot be negative.")
                //.required("Required."),
            bedDays: yup
                .number(),
            patientDays: yup
                .number(),
            hospitalized: yup
                .number(),
            dischargedAlive: yup
                .number(),
            diedBefore48h: yup
                .number(),
            diedAfter48h: yup
                .number(),
            daysHospitalized: yup
                .number(),
            referrals: yup
                .number(),
            transfers: yup
                .number(),
            selfDischarged: yup
                .number(),
            stayedInTheWard: yup
                .number(),
            admissions: yup
                .number(),
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
            if(token != null && token.username.includes("admin") ) {
                this.$axios.post("/api/maternity/datainput", entry, {
                    headers: {
                        'Authorization': `Bearer ${token.jwt}`
                    }
                }).then(response => {
                        this.message = "test";
                        this.successful = true;
                        this.loading = false;
                        console.log("entry successful: " + this.successful);
                        this.$router.push('/');
                    }
                ).catch((error: any) => {
                      this.message =
                          (error.response &&
                          error.response.data &&
                          error.response.data.message) ||
                          error.message;
                      this.successful = false;
                      this.loading = false;
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
        width: 600px;
        margin: 0 auto;
        padding: 30px 0;
    }
    .signup-form h2{
        color: #636363;
        margin: 0 0 15px;
        position: realtive;
        text-align: center;
    }
    .signup-form .form-group{
        margin-bottm: 20px;
    }
    .category-heading{
        font-size:20px;
    }
    table, th, td {
      border:1px solid black;
    }
</style>