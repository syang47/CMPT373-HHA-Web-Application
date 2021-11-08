<template>

    <Form @submit="handleData" :validation-schema="dataSchema">
        <div class="signup-form text-monospace">
            <div class="text-center">
                <h2 class="font-weight-bold display-5 text-dark text-monospace">{{ $t('caseStudyForm.caseStudyForm') }}</h2>
            </div>
            <div v-if="!successful">
                <div class="form-group">
                    <label for="caseStudyType">{{ $t('caseStudyForm.selectCSType') }}</label>
                    <Field v-model="caseStudySelected" v-slot="{ value }" name="caseStudyType" as="select">
                        <option v-for="d in caseStudyTypes" :key="d" :value="d" :selected="value && value.includes(d)">{{ d }}</option>
                    </Field>
                </div>
                <div v-if="caseStudySelected == 'patient_story'">
                    <h4 style="color:red; text-align:center">{{ $t('caseStudyForm.pStory') }}</h4>
                    <div class="form-group text-center">
                        <label for="patientName">{{ $t('caseStudyForm.pName') }}</label>
                        <Field name="patientName" type="text" class="form-control" />
                        <ErrorMessage name="patientName" class="error-feedback" />
                    </div>
                    <div class="form-group text-center">
                        <label for="patientAge">{{ $t('caseStudyForm.pAge') }}</label>
                        <Field name="patientAge" type="text" class="form-control" />
                        <ErrorMessage name="patientAge" class="error-feedback" />
                    </div>
                    <div class="form-group text-center">
                        <label for="patientOrigin">{{ $t('caseStudyForm.pFrom') }}</label>
                        <Field name="patientOrigin" type="text" class="form-control" />
                        <ErrorMessage name="patientOrigin" class="error-feedback" />
                    </div>
                    <div class="form-group text-center">
                        <label for="patientReasoning">{{ $t('caseStudyForm.pChoose') }}</label>
                        <Field name="patientReasoning" type="text" class="form-control" />
                        <ErrorMessage name="patientReasoning" class="error-feedback" />
                    </div>
                    <div class="form-group text-center">
                        <label for="patientDuration">{{ $t('caseStudyForm.pHowLongHCBH') }}</label>
                        <Field name="patientDuration" type="text" class="form-control" />
                        <ErrorMessage name="patientDuration" class="error-feedback" />
                    </div>
                    <div class="form-group text-center">
                        <label for="patientDiagnosis">{{ $t('caseStudyForm.diagnosis') }}</label>
                        <Field name="patientDiagnosis" type="text" class="form-control" />
                        <ErrorMessage name="patientDiagnosis" class="error-feedback" />
                    </div>
                    <p style="text-align:center">{{ $t('caseStudyForm.morePersonalElements') }}</p>
                </div>
                <div v-if="caseStudySelected == 'staff_recognition'">
                    <h4 style="color:red; text-align:center">{{ $t('caseStudyForm.sRecognition') }}</h4>
                    <div class="form-group text-center">
                        <label for="staffName">{{ $t('caseStudyForm.sName') }}</label>
                        <Field name="staffName" type="text" class="form-control" />
                        <ErrorMessage name="staffName" class="error-feedback" />
                    </div>
                    <div class="form-group text-center">
                        <label for="staffTitle">{{ $t('caseStudyForm.roleJob') }}</label>
                        <Field name="staffTitle" type="text" class="form-control" />
                        <ErrorMessage name="staffTitle" class="error-feedback" />
                    </div>
                    <div class="form-group text-center">
                        <label for="staffDepartment">{{ $t('caseStudyForm.whatDept') }}</label>
                        <Field name="staffDepartment" type="text" class="form-control" />
                        <ErrorMessage name="staffDepartment" class="error-feedback" />
                    </div>
                    <div class="form-group text-center">
                        <label for="staffEmploymentDuration">{{ $t('caseStudyForm.sHowLongHCBH') }}</label>
                        <Field name="staffEmploymentDuration" type="text" class="form-control" />
                        <ErrorMessage name="staffEmploymentDuration" class="error-feedback" />
                    </div>
                    <div class="form-group text-center">
                        <label for="staffEnjoymentPoints">{{ $t('caseStudyForm.enjoyHCBH') }}</label>
                        <Field name="staffEnjoymentPoints" type="text" class="form-control" />
                        <ErrorMessage name="staffEnjoymentPoints" class="error-feedback" />
                    </div>
                    <p style="text-align:center">{{ $t('caseStudyForm.sRecognise') }}</p>
                </div>
                <div v-if="caseStudySelected == 'training_session'">
                    <h4 style="color:red; text-align:center">{{ $t('caseStudyForm.tSession') }}</h4>
                    <div class="form-group text-center">
                        <label for="trainingDate">{{ $t('caseStudyForm.tDate') }}</label>
                        <Field name="trainingDate" type="text" class="form-control" />
                        <ErrorMessage name="trainingDate" class="error-feedback" />
                    </div>
                    <div class="form-group text-center">
                        <label for="trainingSubject">{{ $t('caseStudyForm.tAbout') }}</label>
                        <Field name="trainingSubject" type="text" class="form-control" />
                        <ErrorMessage name="trainingSubject" class="error-feedback" />
                    </div>
                    <div class="form-group text-center">
                        <label for="trainingConductor">{{ $t('caseStudyForm.tConducted') }}</label>
                        <Field name="trainingConductor" type="text" class="form-control" />
                        <ErrorMessage name="trainingConductor" class="error-feedback" />
                    </div>
                    <div class="form-group text-center">
                        <label for="trainingAttendees">{{ $t('caseStudyForm.tAttend') }}</label>
                        <Field name="trainingAttendees" type="text" class="form-control" />
                        <ErrorMessage name="trainingAttendees" class="error-feedback" />
                    </div>
                    <div class="form-group text-center">
                        <label for="trainingBenefits">{{ $t('caseStudyForm.tBenefit') }}</label>
                        <Field name="trainingBenefits" type="text" class="form-control" />
                        <ErrorMessage name="trainingBenefits" class="error-feedback" />
                    </div>
                    <p style="text-align:center">{{ $t('caseStudyForm.generalSummary') }}</p>
                </div>
                <div v-if="caseStudySelected == 'equipment_received'">
                    <h4 style="color:red; text-align:center">{{ $t('caseStudyForm.eReceived') }}</h4>
                    <div class="form-group text-center">
                        <label for="equipmentReceived">{{ $t('caseStudyForm.eWhat') }} </label>
                        <Field name="equipmentReceived" type="text" class="form-control" />
                        <ErrorMessage name="equipmentReceived" class="error-feedback" />
                    </div>
                    <div class="form-group text-center">
                        <label for="equipmentDepartmentTo">{{ $t('caseStudyForm.eDept') }}</label>
                        <Field name="equipmentDepartmentTo" type="text" class="form-control" />
                        <ErrorMessage name="equipmentDepartmentTo" class="error-feedback" />
                    </div>
                    <div class="form-group text-center">
                        <label for="equipmentFrom">{{ $t('caseStudyForm.eFrom') }}</label>
                        <Field name="equipmentFrom" type="text" class="form-control" />
                        <ErrorMessage name="equipmentFrom" class="error-feedback" />
                    </div>
                    <div class="form-group text-center">
                        <label for="equipmentOrigin">{{ $t('caseStudyForm.eDonatePurchase') }}</label>
                        <Field name="equipmentOrigin" type="text" class="form-control" />
                        <ErrorMessage name="equipmentOrigin" class="error-feedback" />
                    </div>
                    <div class="form-group text-center">
                        <label for="equipmentUsage">{{ $t('caseStudyForm.eDo') }}</label>
                        <Field name="equipmentUsage" type="text" class="form-control" />
                        <ErrorMessage name="equipmentUsage" class="error-feedback" />
                    </div>
                    <p style="text-align:center">{{ $t('caseStudyForm.eBenefit') }}</p>
                </div>
                <div v-if="caseStudySelected == 'other'">
                    <h4 style="color:red; text-align:center">{{ $t('caseStudyForm.other') }}</h4>
                    <p style="text-align:center">{{ $t('caseStudyForm.eExtra') }}</p>
                </div>

                <div class="form-group text-center" v-if="caseStudySelected != null">
                    <Field name="story" type="text" class="form-control" />
                    <ErrorMessage name="story" class="error-feedback" />
                </div>


                <div class="form-group text-center">
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

    <div v-if="message" class="alert alert-danger" :class="successful ? 'alert-success' : 'alert-danger'">
        {{ message }}
    </div>
</template>

<script lang="ts" type="text/typescript">
import { defineComponent } from 'vue'
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
                formData.append("data", entry);
                formData.append('file', entry.photo);
                console.log(entry);

                this.$axios.post("/api/casestudyinput", entry, {
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