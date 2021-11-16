<template>

    <Form class="background" @submit="handleData" :validation-schema="dataSchema">
        <div class="signup-form text-monospace">
            <div class="text-center">
                <h2 class="font-weight-bold display-5 text-dark text-monospace">{{ $t('msppData.msppForm') }}</h2>
            </div>
            <div v-if="!successful">

                <div class="form-group">
                    <label for="bedAvailable">{{ $t('msppData.bedsAvailable') }}</label>
                    <Field name="bedAvailable" type="text" class="form-control" value=0 />
                    <ErrorMessage name="bedAvailable" class="error-feedback" />
                </div>

                <div class="form-group">
                    <label for="bedDays">{{ $t('msppData.bedDays') }}</label>
                    <Field name="bedDays" type="text" class="form-control" value=0 />
                    <ErrorMessage name="bedDays" class="error-feedback" />
                </div>

                <div class="form-group">
                    <label for="patientDays">{{ $t('msppData.patientDays') }}</label>
                    <Field name="patientDays" type="text" class="form-control" value=0 />
                    <ErrorMessage name="patientDays" class="error-feedback" />
                </div>

                <div class="form-group">
                    <label for="hospitalized">{{ $t('msppData.hospitalised') }}</label>
                    <Field name="hospitalized" type="text" class="form-control" value=0 />
                    <ErrorMessage name="hospitalized" class="error-feedback" />
                </div>

                <div>
                    <!-- Todo: this additional form need to be translated -->
                    <div class="form-group">
                        <label for="dischargedAlive">{{ $t('msppData.dischargedAlive') }}</label>
                        <Field name="dischargedAlive" type="text" class="form-control" value=0 id="dischargedAlive" v-on:keyup="checkDischargedAlive()"/>
                        <ErrorMessage name="dischargedAlive" class="error-feedback" />
                    </div>
                    <div v-if="dischargedAliveMor">
                        <FieldArray name="dischargedAlivePatient" v-slot="{ fields, push, remove }">
                            <fieldset
                                class="form-group"
                                v-for="(field, idx) in fields"
                                :key="field.key" 
                            >
                            <legend style="color:green"><strong>Patient {{ idx+1 }} Discharged Diagnosis: </strong></legend>
                            <!-- Drop box -->
                            <!-- <legend style="color:green">Patient {{ idx+1 }}</legend>
                            <select class="btn btn-light dropdown-toggle" v-model="init" :name="`dischargedAlivePatient[${idx}].dischargedAliveOption`" as="select" @change="checkOption(init)">
                                <option class="dropdown-item" v-for="option in options" :key="option" :value="option"> 
                                {{ option }}
                                </option>
                            </select> -->

                            <!-- Radio buttons -->
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
                            <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveOption`" class="error-feedback" />

                            <button class="btn btn-outline-light btn-block" type="button" @click="remove(idx)">Remove patient X</button>
                            </fieldset>

                            <button class="btn btn-outline-light btn-block" type="button" @click="push({ dischargedAliveOption: ''})">
                            New Patient + 
                            </button>
                        </FieldArray>
                    </div>    
                </div>


                <div>
                    <!-- Todo: this additional form need to be translated -->
                    <div class="form-group">
                        <label for="diedBefore48h">{{ $t('msppData.diedBefore48h') }}</label>
                        <Field name="diedBefore48h" type="text" class="form-control"  id="diedBefore48h" v-on:keyup="checkDiedBefore48h()" value=0 />
                        <ErrorMessage name="diedBefore48h" class="error-feedback" />
                    </div>
                    <div v-if="diedBefore48hMor">
                        <FieldArray name="diedBefore48hPatient" v-slot="{ fields, push, remove }">
                            <fieldset
                                class="form-group"
                                v-for="(field, idx) in fields"
                                :key="field.key"
                            >
                            <legend style="color:green">Patient {{ idx+1 }}</legend>
                            <label :for="`diedBefore48hAge_${idx}`">Age</label>
                            <Field class="form-control"
                                   :id="`diedBefore48hAge_${idx}`" 
                                   :name="`diedBefore48hPatient[${idx}].diedBefore48hAge`" />
                            <ErrorMessage :name="`diedBefore48hPatient[${idx}].diedBefore48hAge`" class="error-feedback" />

                            <label :for="`diedBefore48hCause_${idx}`">Cause of Death</label>
                            <Field class="form-control"
                                   :id="`diedBefore48hCause_${idx}`"
                                   :name="`diedBefore48hPatient[${idx}].diedBefore48hCause`" />
                            <ErrorMessage :name="`diedBefore48hPatient[${idx}].diedBefore48hCause`" class="error-feedback" />

                            <button class="btn btn-outline-light btn-block" type="button" @click="remove(idx)">Remove patient X</button>
                            </fieldset>

                            <button class="btn btn-outline-light btn-block" type="button" @click="push({ diedBefore48hAge: '', diedBefore48hCause: '' })">
                            New Patient + 
                            </button>
                        </FieldArray>
                    </div>
                </div>


                <div>
                    <!-- Todo: this additional form need to be translated -->
                    <div class="form-group">
                        <label for="diedAfter48h">{{ $t('msppData.diedAfter48h') }}</label>
                        <Field name="diedAfter48h" type="text" class="form-control" id="diedAfter48h" v-on:keyup="checkDiedAfter48h()" value=0 />
                        <ErrorMessage name="diedAfter48h" class="error-feedback" />
                    </div>
                    <div v-if="diedAfter48hMor">
                        <FieldArray name="diedAfter48hPatient" v-slot="{ fields, push, remove }">
                            <fieldset
                                class="form-group"
                                v-for="(field, idx) in fields"
                                :key="field.key"
                            >
                            <legend style="color:green">Patient {{ idx+1 }}</legend>
                            <label :for="`diedAfter48hAge_${idx}`">Age</label>
                            <Field class="form-control"
                                   :id="`diedAfter48hAge_${idx}`" 
                                   :name="`diedAfter48hPatient[${idx}].diedAfter48hAge`" />
                            <ErrorMessage :name="`diedAfter48hPatient[${idx}].diedAfter48hAge`" class="error-feedback" />

                            <label :for="`diedAfter48hCause_${idx}`">Cause of Death</label>
                            <Field class="form-control"
                                   :id="`diedAfter48hCause_${idx}`"
                                   :name="`diedAfter48hPatient[${idx}].diedAfter48hCause`" />
                            <ErrorMessage :name="`diedAfter48hPatient[${idx}].diedAfter48hCause`" class="error-feedback" />

                            <button class="btn btn-outline-light btn-block" type="button" @click="remove(idx)">Remove patient X</button>
                            </fieldset>

                            <button class="btn btn-outline-light btn-block" type="button" @click="push({ diedBefore48hAge: '', diedBefore48hCause: '' })">
                            New Patient + 
                            </button>
                        </FieldArray>
                    </div>
                </div>


                <div class="form-group">
                    <label for="daysHospitalised">{{ $t('msppData.daysHospitalised') }}</label>
                    <Field name="daysHospitalised" type="text" class="form-control" value=0 />
                    <ErrorMessage name="daysHospitalised" class="error-feedback" />
                </div>

                <div class="form-group">
                    <label for="referrals">{{ $t('msppData.referrals') }}</label>
                    <Field name="referrals" type="text" class="form-control" value=0 />
                    <ErrorMessage name="referrals" class="error-feedback" />
                </div>
                
                <div class="form-group">
                    <label for="transfers">{{ $t('msppData.transfers') }}</label>
                    <Field name="transfers" type="text" class="form-control" value=0 />
                    <ErrorMessage name="transfers" class="error-feedback" />
                </div>



                <div>
                    <div class="form-group">
                        <label for="selfDischarged">{{ $t('msppData.selfDischarged') }}</label>
                        <Field name="selfDischarged" type="text" class="form-control" id="selfDischarged" v-on:keyup="checkSelfDischarged()" value=0 />
                        <ErrorMessage name="selfDischarged" class="error-feedback" />
                    </div>
                    <div v-if="selfDischargedMor" class="form-group">
                        <h4 style="color:green">{{ $t('msppData.reasonSelfDischarge') }}</h4>
                        <label for="financeCannotAfford">{{ $t('msppData.financeCare') }}</label>
                        <Field name="financeCannotAfford" type="text" class="form-control" value=0 />
                        <ErrorMessage name="financeCannotAfford" class="error-feedback" />
                    </div>
                    <div v-if="selfDischargedMor" class="form-group">
                        <label for="financeAvoidPay">{{ $t('msppData.financeAvoidPay') }}</label>
                        <Field name="financeAvoidPay" type="text" class="form-control" value=0 />
                        <ErrorMessage name="financeAvoidPay" class="error-feedback" />
                    </div>
                    <div v-if="selfDischargedMor" class="form-group">
                        <label for="reasonCultural">{{ $t('msppData.religiousCultural') }}</label>
                        <Field name="reasonCultural" type="text" class="form-control" value=0 />
                        <ErrorMessage name="reasonCultural" class="error-feedback" />
                    </div>
                    <div v-if="selfDischargedMor" class="form-group">
                        <label for="reasonPersonal">{{ $t('msppData.personalFamily') }}</label>
                        <Field name="reasonPersonal" type="text" class="form-control" value=0 />
                        <ErrorMessage name="reasonPersonal" class="error-feedback" />
                    </div>
                    <div v-if="selfDischargedMor" class="form-group">
                        <label for="otherReason">{{ $t('msppData.other') }}</label>
                        <Field name="otherReason" type="text" class="form-control" value=0 />
                        <ErrorMessage name="otherReason" class="error-feedback" />
                    </div>
                </div>

                
                <div class="form-group">
                    <label for="stayedInTheWard">{{ $t('msppData.stayedInTheWard') }}</label>
                    <Field name="stayedInTheWard" type="text" class="form-control" value=0 />
                    <ErrorMessage name="stayedInTheWard" class="error-feedback" />
                </div>


                <div>
                    <div class="form-group">
                            <label for="admissions">{{ $t('msppData.admissions') }}</label>
                            <Field name="admissions" type="text" class="form-control" id="admissions" v-on:keyup="checkAdmissions()" value=0 />
                            <ErrorMessage name="admissions" class="error-feedback" />
                    </div>
                    <div>
                        <div v-if="admissionsMor" class="form-group">
                            <h4 style="color:green">{{ $t('msppData.wherePatientsComeFrom') }}</h4>
                            <label for="fromQuarterMorin">{{ $t('msppData.quMo') }}</label>
                            <Field name="fromQuarterMorin" type="text" class="form-control" value=0 />
                            <ErrorMessage name="fromQuarterMorin" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="fromCapHaitian">{{ $t('msppData.capHai') }}</label>
                            <Field name="fromCapHaitian" type="text" class="form-control" value=0 />
                            <ErrorMessage name="fromCapHaitian" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="fromDepartmentNord">{{ $t('msppData.deptNord') }}</label>
                            <Field name="fromDepartmentNord" type="text" class="form-control" value=0 />
                            <ErrorMessage name="fromDepartmentNord" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="fromOther">{{ $t('msppData.otherDept') }}</label>
                            <Field name="fromOther" type="text" class="form-control" value=0 />
                            <ErrorMessage name="fromOther" class="error-feedback" />
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <button class="btn btn-outline-light btn-block" :disabled="loading">
                        <span v-show="loading" class="spinner-border spinner-border-sm"></span>
                        {{ $t('msppData.submit') }}
                    </button>
                </div>
            </div>
        </div>
    </Form>
    <div v-if="message" class="alert alert-danger" :class="successful ? 'alert-success' : 'alert-danger'">
        {{ message }}
    </div>
<form method="GET" id="my_form"></form>

</template>

<script lang="ts" type="text/typescript">
import { defineComponent } from 'vue'
import { Form, Field, ErrorMessage, FieldArray } from "vee-validate";
import * as yup from "yup";
export default defineComponent({
    name: "Maternity_Data",
    components: {
        Form,
        Field,
        ErrorMessage,
        FieldArray,
    },
    data() {
        const dataSchema = yup.object().shape({
            diedBefore48hPatient: yup
                .array()
                .of(
                yup.object().shape({
                    diedBefore48hAge: yup
                        .number()
                        .min(0, "Cannot be negative.")
                        .required("Required.")
                        .default(0),
                    diedBefore48hCause: yup
                        .string()
                        .required("Required.")
                        .default(""),
                })
            )
            .strict(),

            diedAfter48hPatient: yup
                .array()
                .of(
                yup.object().shape({
                    diedAfter48hAge: yup
                        .number()
                        .min(0, "Cannot be negative.")
                        .required("Required.")
                        .default(0),
                    diedAfter48hCause: yup
                        .string()
                        .required("Required.")
                        .default(""),
                })
            )
            .strict(),

            dischargedAlivePatient: yup
                .array()
                .of(
                yup.object().shape({
                    dischargedAliveOption: yup
                        .string()
                        .required("Must choose an option.")
                        .default(""),
                })
            )
            .strict(),

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
            financeCannotAfford: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            financeAvoidPay: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            reasonCultural: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            reasonPersonal: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            otherReason: yup
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
            fromQuarterMorin: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            fromCapHaitian: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            fromDepartmentNord: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            fromOther: yup
                .string()
                .default(""),
            
        });
        return {
            successful: false,
            loading: false,
            message: "",
            selfDischargedMor: false,
            admissionsMor: false,
            diedBefore48hMor: false,
            diedAfter48hMor: false,
            dischargedAliveMor: false,
            options: ["SCI", "Stroke", "Other"],
            init: "",
            dataSchema,
        };
    },
    methods: {
        checkOption (value) {
            console.log(value);
        },
        checkDischargedAlive() {
            let number: number = (document as any).getElementById("dischargedAlive").value;
            if (number > 0) {
                this.dischargedAliveMor = true;
            } else {
                this.dischargedAliveMor = false;
            }
        },
        checkDiedBefore48h() {
            let number: number = (document as any).getElementById("diedBefore48h").value;
            if (number > 0) {
                this.diedBefore48hMor = true;
            } else {
                this.diedBefore48hMor = false;
            }
        },
        checkDiedAfter48h() {
            let number: number = (document as any).getElementById("diedAfter48h").value;
            if (number > 0) {
                this.diedAfter48hMor = true;
            } else {
                this.diedAfter48hMor = false;
            }
        },
        checkSelfDischarged() {
            let number: number = (document as any).getElementById("selfDischarged").value;
            if (number > 0) {
                this.selfDischargedMor = true;
            } else {
                this.selfDischargedMor = false;
            }
        },
        checkAdmissions() {
            let number: number = (document as any).getElementById("admissions").value;
            if (number > 0) {
                this.admissionsMor = true;
            } else {
                this.admissionsMor = false;
            }
        },
        handleData(entry) {
            let token = JSON.parse(localStorage.getItem('user')!);
            if(token != null) {
                entry.department = "rehab";
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
        position: absolute;
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
        position: relative;
        text-align: center;
    }
    .signup-form .form-group{
        margin-bottom: 20px;
    }
    .category-heading{
        font-size:20px;
    }
    table, th, td {
      border:1px solid black;
    }
</style>