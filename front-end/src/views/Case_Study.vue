<style scoped>

    .box {
        width: 100%;
        height: 100%;
        background: #00000060;
        position: absolute;
        box-sizing: border-box;
        padding: 40px;
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
        position: relative;
        overflow-y: auto;
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

<template>
<div class="main-content">
    <div class="card shadow-none">
      <div class="card-body">
        <Form @submit="handleData" :validation-schema="dataSchema">
            <div class="text-center">
                <div class="text-center mb-3">
                    <h2 class="font-weight-bold display-5 text-dark mb-3">{{ $t('caseStudyForm.caseStudyForm') }}</h2>
                </div>
                <div v-if="!successful" class="text-center">
                    <div class="form-group mb-3">
                        <label for="caseStudyType">{{ $t('caseStudyForm.selectCSType') }}</label>
                        <Field v-model="caseStudySelected" v-slot="{ value }" name="caseStudyType" as="select">
                            <option v-for="d in caseStudyTypes" :key="d" :value="d" :selected="value && value.includes(d)">{{ d }}</option>
                        </Field>
                    </div>
                    <div v-if="caseStudySelected == 'patient_story'">
                        <h2 class="mb-3" style="color:red; text-align:center">{{ $t('caseStudyForm.pStory') }}</h2>
                        <div class="form-group text-center mb-3">
                            <label for="patientName">{{ $t('caseStudyForm.pName') }}</label>
                            <div style="width: 60%; margin:0 auto;">
                                <Field name="patientName" v-slot="{ field }" class="form-control" >
                                    <textarea name="patientName" v-bind="field" type="text" style="width: 100%; max-width: 100%;"/>
                                </Field>
                            </div>
                            <ErrorMessage name="patientName" class="error-feedback" />
                        </div>
                        <div class="form-group text-center mb-3">
                            <label for="patientAge">{{ $t('caseStudyForm.pAge') }}</label>
                            <div style="width: 60%; margin:0 auto;">
                                <Field name="patientAge" v-slot="{ field }" class="form-control" >
                                    <textarea name="patientAge" v-bind="field" type="text" style="width: 100%; max-width: 100%;"/>
                                </Field>
                            </div>
                            <ErrorMessage name="patientAge" class="error-feedback" />
                        </div>
                        <div class="form-group text-center mb-3">
                            <label for="patientOrigin">{{ $t('caseStudyForm.pFrom') }}</label>
                            <div style="width: 60%; margin:0 auto;">
                                <Field name="patientOrigin" v-slot="{ field }" class="form-control" >
                                    <textarea name="patientOrigin" v-bind="field" type="text" style="width: 100%; max-width: 100%;"/>
                                </Field>
                            </div>
                            <ErrorMessage name="patientOrigin" class="error-feedback" />
                        </div>
                        <div class="form-group text-center mb-3">
                            <label for="patientReasoning">{{ $t('caseStudyForm.pChoose') }}</label>
                            <div style="width: 60%; margin:0 auto;">
                                <Field name="patientReasoning" v-slot="{ field }" class="form-control" >
                                    <textarea name="patientReasoning" v-bind="field" type="text" style="width: 100%; max-width: 100%;"/>
                                </Field>
                            </div>
                            <ErrorMessage name="patientReasoning" class="error-feedback" />
                        </div>
                        <div class="form-group text-center mb-3">
                            <label for="patientDuration">{{ $t('caseStudyForm.pHowLongHCBH') }}</label>
                            <div style="width: 60%; margin:0 auto;">
                                <Field name="patientDuration" v-slot="{ field }" class="form-control" >
                                    <textarea name="patientDuration" v-bind="field" type="text" style="width: 100%; max-width: 100%;"/>
                                </Field>
                            </div>
                            <ErrorMessage name="patientDuration" class="error-feedback" />
                        </div>
                        <div class="form-group text-center mb-3">
                            <label for="patientDiagnosis">{{ $t('caseStudyForm.diagnosis') }}</label>
                            <div style="width: 60%; margin:0 auto;">
                                <Field name="patientDiagnosis" v-slot="{ field }" class="form-control" >
                                    <textarea name="patientDiagnosis" v-bind="field" type="text" style="width: 100%; max-width: 100%;"/>
                                </Field>
                            </div>
                            <ErrorMessage name="patientDiagnosis" class="error-feedback" />
                        </div>
                        <p style="text-align:center">{{ $t('caseStudyForm.morePersonalElements') }}</p>
                    </div>
                    <div v-if="caseStudySelected == 'staff_recognition'">
                        <h2 class="mb-3" style="color:red; text-align:center">{{ $t('caseStudyForm.sRecognition') }}</h2>
                        <div class="form-group text-center mb-3">
                            <label for="staffName">{{ $t('caseStudyForm.sName') }}</label>
                            <div style="width: 60%; margin:0 auto;">
                                <Field name="staffName" v-slot="{ field }" class="form-control" >
                                    <textarea name="staffName" v-bind="field" type="text" style="width: 100%; max-width: 100%;"/>
                                </Field>
                            </div>
                            <ErrorMessage name="staffName" class="error-feedback" />
                        </div>
                        <div class="form-group text-center mb-3">
                            <label for="staffTitle">{{ $t('caseStudyForm.roleJob') }}</label>
                            <div style="width: 60%; margin:0 auto;">
                                <Field name="staffTitle" v-slot="{ field }" class="form-control" >
                                    <textarea name="staffTitle" v-bind="field" type="text" style="width: 100%; max-width: 100%;"/>
                                </Field>
                            </div>
                            <ErrorMessage name="staffTitle" class="error-feedback" />
                        </div>
                        <div class="form-group text-center mb-3">
                            <label for="staffDepartment">{{ $t('caseStudyForm.whatDept') }}</label>
                            <div style="width: 60%; margin:0 auto;">
                                <Field name="staffDepartment" v-slot="{ field }" class="form-control" >
                                    <textarea name="staffDepartment" v-bind="field" type="text" style="width: 100%; max-width: 100%;"/>
                                </Field>
                            </div>
                            <ErrorMessage name="staffDepartment" class="error-feedback" />
                        </div>
                        <div class="form-group text-center mb-3">
                            <label for="staffEmploymentDuration">{{ $t('caseStudyForm.sHowLongHCBH') }}</label>
                            <div style="width: 60%; margin:0 auto;">
                                <Field name="staffEmploymentDuration" v-slot="{ field }" class="form-control" >
                                    <textarea name="staffEmploymentDuration" v-bind="field" type="text" style="width: 100%; max-width: 100%;"/>
                                </Field>
                            </div>
                            <ErrorMessage name="staffEmploymentDuration" class="error-feedback" />
                        </div>
                        <div class="form-group text-center mb-3">
                            <label for="staffEnjoymentPoints">{{ $t('caseStudyForm.enjoyHCBH') }}</label>
                            <div style="width: 60%; margin:0 auto;">
                                <Field name="staffEnjoymentPoints" v-slot="{ field }" class="form-control" >
                                    <textarea name="staffEnjoymentPoints" v-bind="field" type="text" style="width: 100%; max-width: 100%;"/>
                                </Field>
                            </div>
                            <ErrorMessage name="staffEnjoymentPoints" class="error-feedback" />
                        </div>
                        <p style="text-align:center">{{ $t('caseStudyForm.sRecognise') }}</p>
                    </div>
                    <div v-if="caseStudySelected == 'training_session'">
                        <h2 class="mb-3" style="color:red; text-align:center">{{ $t('caseStudyForm.tSession') }}</h2>
                        <div class="form-group text-center mb-3">
                            <label for="trainingDate">{{ $t('caseStudyForm.tDate') }}</label>
                            <div style="width: 60%; margin:0 auto;">
                                <Field name="trainingDate" v-slot="{ field }" class="form-control" >
                                    <textarea name="trainingDate" v-bind="field" type="text" style="width: 100%; max-width: 100%;"/>
                                </Field>
                            </div>
                            <ErrorMessage name="trainingDate" class="error-feedback" />
                        </div>
                        <div class="form-group text-center mb-3">
                            <label for="trainingSubject">{{ $t('caseStudyForm.tAbout') }}</label>
                            <div style="width: 60%; margin:0 auto;">
                                <Field name="trainingSubject" v-slot="{ field }" class="form-control" >
                                    <textarea name="trainingSubject" v-bind="field" type="text" style="width: 100%; max-width: 100%;"/>
                                </Field>
                            </div>
                            <ErrorMessage name="trainingSubject" class="error-feedback" />
                        </div>
                        <div class="form-group text-center mb-3">
                            <label for="trainingConductor">{{ $t('caseStudyForm.tConducted') }}</label>
                            <div style="width: 60%; margin:0 auto;">
                                <Field name="trainingConductor" v-slot="{ field }" class="form-control" >
                                    <textarea name="trainingConductor" v-bind="field" type="text" style="width: 100%; max-width: 100%;"/>
                                </Field>
                            </div>
                            <ErrorMessage name="trainingConductor" class="error-feedback" />
                        </div>
                        <div class="form-group text-center mb-3">
                            <label for="trainingAttendees">{{ $t('caseStudyForm.tAttend') }}</label>
                            <div style="width: 60%; margin:0 auto;">
                                <Field name="trainingAttendees" v-slot="{ field }" class="form-control" >
                                    <textarea name="trainingAttendees" v-bind="field" type="text" style="width: 100%; max-width: 100%;"/>
                                </Field>
                            </div>
                            <ErrorMessage name="trainingAttendees" class="error-feedback" />
                        </div>
                        <div class="form-group text-center mb-3">
                            <label for="trainingBenefits">{{ $t('caseStudyForm.tBenefit') }}</label>
                            <div style="width: 60%; margin:0 auto;">
                                <Field name="trainingBenefits" v-slot="{ field }" class="form-control" >
                                    <textarea name="trainingBenefits" v-bind="field" type="text" style="width: 100%; max-width: 100%;"/>
                                </Field>
                            </div>
                            <ErrorMessage name="trainingBenefits" class="error-feedback" />
                        </div>
                        <p style="text-align:center">{{ $t('caseStudyForm.generalSummary') }}</p>
                    </div>
                    <div v-if="caseStudySelected == 'equipment_received'">
                        <h2 class="mb-3" style="color:red; text-align:center">{{ $t('caseStudyForm.eReceived') }}</h2>
                        <div class="form-group text-center mb-3">
                            <label for="equipmentReceived">{{ $t('caseStudyForm.eWhat') }} </label>
                            <div style="width: 60%; margin:0 auto;">
                                <Field name="equipmentReceived" v-slot="{ field }" class="form-control" >
                                    <textarea name="equipmentReceived" v-bind="field" type="text" style="width: 100%; max-width: 100%;"/>
                                </Field>
                            </div>
                            <ErrorMessage name="equipmentReceived" class="error-feedback" />
                        </div>
                        <div class="form-group text-center mb-3">
                            <label for="equipmentDepartmentTo">{{ $t('caseStudyForm.eDept') }}</label>
                            <div style="width: 60%; margin:0 auto;">
                                <Field name="equipmentDepartmentTo" v-slot="{ field }" class="form-control" >
                                    <textarea name="equipmentDepartmentTo" v-bind="field" type="text" style="width: 100%; max-width: 100%;"/>
                                </Field>
                            </div>
                            <ErrorMessage name="equipmentDepartmentTo" class="error-feedback" />
                        </div>
                        <div class="form-group text-center mb-3">
                            <label for="equipmentFrom">{{ $t('caseStudyForm.eFrom') }}</label>
                            <div style="width: 60%; margin:0 auto;">
                                <Field name="equipmentFrom" v-slot="{ field }" class="form-control" >
                                    <textarea name="equipmentFrom" v-bind="field" type="text" style="width: 100%; max-width: 100%;"/>
                                </Field>
                            </div>
                            <ErrorMessage name="equipmentFrom" class="error-feedback" />
                        </div>
                        <div class="form-group text-center mb-3">
                            <label for="equipmentOrigin">{{ $t('caseStudyForm.eDonatePurchase') }}</label>
                            <div style="width: 60%; margin:0 auto;">
                                <Field name="equipmentOrigin" v-slot="{ field }" class="form-control" >
                                    <textarea name="equipmentOrigin" v-bind="field" type="text" style="width: 100%; max-width: 100%;"/>
                                </Field>
                            </div>
                            <ErrorMessage name="equipmentOrigin" class="error-feedback" />
                        </div>
                        <div class="form-group text-center mb-3">
                            <label for="equipmentUsage">{{ $t('caseStudyForm.eDo') }}</label>
                            <div style="width: 60%; margin:0 auto;">
                                <Field name="equipmentUsage" v-slot="{ field }" class="form-control" >
                                    <textarea name="equipmentUsage" v-bind="field" type="text" style="width: 100%; max-width: 100%;"/>
                                </Field>
                            </div>
                            <ErrorMessage name="equipmentUsage" class="error-feedback" />
                        </div>
                        <p style="text-align:center">{{ $t('caseStudyForm.eBenefit') }}</p>
                    </div>
                    <div v-if="caseStudySelected == 'other'">
                        <h2 class="mb-3" style="color:red; text-align:center">{{ $t('caseStudyForm.other') }}</h2>
                        <p style="text-align:center">{{ $t('caseStudyForm.eExtra') }}</p>
                    </div>

                    <div class="form-group text-center mb-3" v-if="caseStudySelected != null">
                        <div style="width: 60%; margin:0 auto;">
                            <Field name="story" v-slot="{ field }" class="form-control" >
                                <textarea name="story" v-bind="field" type="text" style="width: 100%; max-width: 100%;"/>
                            </Field>
                        </div>
                        <ErrorMessage name="story" class="error-feedback" />
                    </div>


                    <div class="form-group text-center mb-3">
                        <Field name="permission" type="checkbox" :value="true"/>
                        <label for="permission">{{ $t('caseStudyForm.disclaimer') }}</label>
                        <ErrorMessage name="permission" class="error-feedback" />
                    </div>
                    <div class="form-group">
                        <label for="photo">{{ $t('caseStudyForm.addPhoto') }}</label>
                        <Field name="photo" type="file" rules="image" />
                        <ErrorMessage name="photo" class="error-feedback" />
                    </div>

                    <div class="form-group">
                        <button class="btn btn-outline-light btn-block" :disabled="loading">
                            <span v-show="loading" class="spinner-border spinner-border-sm"></span>
                            {{ $t('caseStudyForm.submit') }}
                        </button>
                    </div>
                </div>
            </div>
        </Form>
      </div>
    </div>
</div>

    <div v-if="message" class="alert alert-danger" :class="successful ? 'alert-success' : 'alert-danger'">
        {{ message }}
    </div>

</template>

<script lang="ts" type="text/typescript">

import { defineComponent } from 'vue';
import { Form, Field, ErrorMessage } from "vee-validate";
import * as yup from "yup";
export default defineComponent({
    name: "Case_Study",
    components: {
        Form,
        Field,
        ErrorMessage,
    },
    data: function() {
        const supportedFileTypes = ["image/jpg", "image/jpeg", "image/gif", "image/png"];
        const dataSchema = yup.object().shape({
            photo: yup
                .mixed()
                .notRequired()
                .default("-")
                .test(
                    "fileTypeCheck",
                    "Unsupported file type",
                    (value) => { 
                        return supportedFileTypes.includes(value[0].type) || value == "-";
                    }
                ),
            caseStudyType: yup
                .string(),
            permission: yup
                .boolean()
                .required("Must get permission to share."),

        });
        return {
            successful: false,
            loading: false,
            message: "",
            caseStudyTypes: ["patient_story", "staff_recognition", "training_session", "equipment_received", "other"],
            caseStudySelected: null,
            dataSchema,
        };
    },
    methods: {

        handleData(entry) {
            let token = JSON.parse(localStorage.getItem('user')!);
            if(token != null) {
                entry.caseStudyType = this.caseStudySelected;

                let formData = new FormData();
                if(entry.photo){
                    for(let p of entry.photo){
                        formData.append("file", p);
                    }
                }
                
                delete entry["permission"];
                delete entry["photo"];
                formData.append("data", new Blob([JSON.stringify(entry)], {
                                type: "application/json"
                            }));

                // for (var key of formData.entries()) {
                //     console.log(key[0] + ', ' + key[1]);
                // }
                this.$axios.post("/api/casestudyinput", formData, {
                    headers: {
                        'Authorization': `Bearer ${token.jwt}`,
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

