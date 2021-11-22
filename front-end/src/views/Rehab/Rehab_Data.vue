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


                            <!-- Radio buttons -->
                            <div>
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
                                <br>
                                <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveOption`" class="error-feedback" />
                            </div>


                            <!-- Input boxed list -->
                            <div>
                                <legend :for="`dischargedAlivePatientNo_${idx}`" style="color:green"><strong>Patient {{ idx+1 }}: No. Days in Rehab Unit from admission to discharge: </strong></legend>
                                <br>
                                <Field class="form-control"
                                    type="number"
                                    :id="`dischargedAlivePatientNo_${idx}`" 
                                    :name="`dischargedAlivePatient[${idx}].dischargedAlivePatientNo`" />
                                <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAlivePatientNo`" class="error-feedback" />


                                <br>
                                <label style="color:green"><strong>Discharge Reason</strong></label>
                                <br>
                                <label :for="`dischargedAliveAllGoals_${idx}`">All goals met</label>
                                <Field class="form-control"
                                    :id="`dischargedAliveAllGoals_${idx}`"
                                    type="number"
                                    :name="`dischargedAlivePatient[${idx}].dischargedAliveAllGoals`" />
                                <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveAllGoals`" class="error-feedback" />
                                <br>
                                <label :for="`dischargedAliveGoalsPartially_${idx}`">Goals partially met, sufficient for discharge</label>
                                <Field class="form-control"
                                    :id="`dischargedAliveGoalsPartially_${idx}`"
                                    type="number"
                                    :name="`dischargedAlivePatient[${idx}].dischargedAliveGoalsPartially`" />
                                <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveGoalsPartially`" class="error-feedback" />
                                <br>
                                <label :for="`dischargedAliveNoGoals_${idx}`">Goals not met, discharged for alternate reason</label>
                                <Field class="form-control"
                                    :id="`dischargedAliveNoGoals_${idx}`"
                                    type="number"
                                    :name="`dischargedAlivePatient[${idx}].dischargedAliveNoGoals`" />
                                <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveNoGoals`" class="error-feedback" />


                                <br>
                                <label style="color:green"><strong>Discharge Outcome (ADLs/Self-Care)</strong></label>
                                <br>
                                <label :for="`dischargedAliveADLsIndependent_${idx}`">Independent </label>
                                <Field class="form-control"
                                    :id="`dischargedAliveADLsIndependent_${idx}`"
                                    type="number"
                                    :name="`dischargedAlivePatient[${idx}].dischargedAliveADLsIndependent`" />
                                <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveADLsIndependent`" class="error-feedback" />
                                <br>
                                <label :for="`dischargedAliveADLsModifiedIndependent_${idx}`">Modified Independent</label>
                                <Field class="form-control"
                                    :id="`dischargedAliveADLsModifiedIndependent_${idx}`"
                                    type="number"
                                    :name="`dischargedAlivePatient[${idx}].dischargedAliveADLsModifiedIndependent`" />
                                <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveADLsModifiedIndependent`" class="error-feedback" />
                                <br>
                                <label :for="`dischargedAliveADLsSupervision_${idx}`">Supervision</label>
                                <Field class="form-control"
                                    :id="`dischargedAliveADLsSupervision_${idx}`"
                                    type="number"
                                    :name="`dischargedAlivePatient[${idx}].dischargedAliveADLsSupervision`" />
                                <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveADLsSupervision`" class="error-feedback" />
                                <br>
                                <label :for="`dischargedAliveADLsMinimumAssistance_${idx}`">Minimum Assistance</label>
                                <Field class="form-control"
                                    :id="`dischargedAliveADLsMinimumAssistance_${idx}`"
                                    type="number"
                                    :name="`dischargedAlivePatient[${idx}].dischargedAliveADLsMinimumAssistance`" />
                                <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveADLsMinimumAssistance`" class="error-feedback" />
                                <br>
                                <label :for="`dischargedAliveADLsModerateAssistance_${idx}`">Moderate Assistance</label>
                                <Field class="form-control"
                                    :id="`dischargedAliveADLsModerateAssistance_${idx}`"
                                    type="number"
                                    :name="`dischargedAlivePatient[${idx}].dischargedAliveADLsModerateAssistance`" />
                                <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveADLsModerateAssistance`" class="error-feedback" />
                                <br>
                                <label :for="`dischargedAliveADLsMaximumAssistance_${idx}`">Maximum Assistance</label>
                                <Field class="form-control"
                                    :id="`dischargedAliveADLsMaximumAssistance_${idx}`"
                                    type="number"
                                    :name="`dischargedAlivePatient[${idx}].dischargedAliveADLsMaximumAssistance`" />
                                <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveADLsMaximumAssistance`" class="error-feedback" />
                                <br>
                                <label :for="`dischargedAliveADLsDependent_${idx}`">Dependent</label>
                                <Field class="form-control"
                                    :id="`dischargedAliveADLsDependent_${idx}`"
                                    type="number"
                                    :name="`dischargedAlivePatient[${idx}].dischargedAliveADLsDependent`" />
                                <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveADLsDependent`" class="error-feedback" />


                                <br>
                                <label style="color:green"><strong>Discharge Outcome (Transfers and Mobility)</strong></label>
                                <br>
                                <label :for="`dischargedAliveTransfersIndependent_${idx}`">Independent </label>
                                <Field class="form-control"
                                    :id="`dischargedAliveTransfersIndependent_${idx}`"
                                    type="number"
                                    :name="`dischargedAlivePatient[${idx}].dischargedAliveTransfersIndependent`" />
                                <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveTransfersIndependent`" class="error-feedback" />
                                <br>
                                <label :for="`dischargedAliveTransfersModifiedIndependent_${idx}`">Modified Independent</label>
                                <Field class="form-control"
                                    :id="`dischargedAliveTransfersModifiedIndependent_${idx}`"
                                    type="number"
                                    :name="`dischargedAlivePatient[${idx}].dischargedAliveTransfersModifiedIndependent`" />
                                <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveTransfersModifiedIndependent`" class="error-feedback" />
                                <br>
                                <label :for="`dischargedAliveTransfersSupervision_${idx}`">Supervision</label>
                                <Field class="form-control"
                                    :id="`dischargedAliveTransfersSupervision_${idx}`"
                                    type="number"
                                    :name="`dischargedAlivePatient[${idx}].dischargedAliveTransfersSupervision`" />
                                <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveTransfersSupervision`" class="error-feedback" />
                                <br>
                                <label :for="`dischargedAliveTransfersMinimumAssistance_${idx}`">Minimum Assistance</label>
                                <Field class="form-control"
                                    :id="`dischargedAliveTransfersMinimumAssistance_${idx}`"
                                    type="number"
                                    :name="`dischargedAlivePatient[${idx}].dischargedAliveTransfersMinimumAssistance`" />
                                <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveTransfersMinimumAssistance`" class="error-feedback" />
                                <br>
                                <label :for="`dischargedAliveTransfersModerateAssistance_${idx}`">Moderate Assistance</label>
                                <Field class="form-control"
                                    :id="`dischargedAliveTransfersModerateAssistance_${idx}`"
                                    type="number"
                                    :name="`dischargedAlivePatient[${idx}].dischargedAliveTransfersModerateAssistance`" />
                                <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveTransfersModerateAssistance`" class="error-feedback" />
                                <br>
                                <label :for="`dischargedAliveTransfersMaximumAssistance_${idx}`">Maximum Assistance</label>
                                <Field class="form-control"
                                    :id="`dischargedAliveTransfersMaximumAssistance_${idx}`"
                                    type="number"
                                    :name="`dischargedAlivePatient[${idx}].dischargedAliveTransfersMaximumAssistance`" />
                                <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveTransfersMaximumAssistance`" class="error-feedback" />
                                <br>
                                <label :for="`dischargedAliveTransfersDependent_${idx}`">Dependent</label>
                                <Field class="form-control"
                                    :id="`dischargedAliveTransfersDependent_${idx}`"
                                    type="number"
                                    :name="`dischargedAlivePatient[${idx}].dischargedAliveTransfersDependent`" />
                                <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveTransfersDependent`" class="error-feedback" />


                                <br>
                                <label style="color:green"><strong>Mobility Aid/Assistive Device Given?</strong></label>
                                <br>
                                <label :for="`dischargedAliveWheelchair_${idx}`">Wheelchair</label>
                                <Field class="form-control"
                                    :id="`dischargedAliveWheelchair_${idx}`"
                                    type="number"
                                    :name="`dischargedAlivePatient[${idx}].dischargedAliveWheelchair`" />
                                <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveWheelchair`" class="error-feedback" />
                                <br>
                                <label :for="`dischargedAliveWalker_${idx}`">Walker</label>
                                <Field class="form-control"
                                    :id="`dischargedAliveWalker_${idx}`"
                                    type="number"
                                    :name="`dischargedAlivePatient[${idx}].dischargedAliveWalker`" />
                                <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveWalker`" class="error-feedback" />
                                <br>
                                <label :for="`dischargedAliveCane_${idx}`">Cane</label>
                                <Field class="form-control"
                                    :id="`dischargedAliveCane_${idx}`"
                                    type="number"
                                    :name="`dischargedAlivePatient[${idx}].dischargedAliveCane`" />
                                <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveCane`" class="error-feedback" />
                                <br>
                                <label :for="`dischargedAliveCrutches_${idx}`">Crutches</label>
                                <Field class="form-control"
                                    :id="`dischargedAliveCrutches_${idx}`"
                                    type="number"
                                    :name="`dischargedAlivePatient[${idx}].dischargedAliveCrutches`" />
                                <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveCrutches`" class="error-feedback" />


                                <br>
                                <label style="color:green"><strong>Discharge Location</strong></label>
                                <br>
                                <label :for="`dischargedAliveHomeAlone_${idx}`">Return home, alone</label>
                                <Field class="form-control"
                                    :id="`dischargedAliveHomeAlone_${idx}`"
                                    type="number"
                                    :name="`dischargedAlivePatient[${idx}].dischargedAliveHomeAlone`" />
                                <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveHomeAlone`" class="error-feedback" />
                                <br>
                                <label :for="`dischargedAliveHomeWithOther_${idx}`">Return home, with family/caregiver(s)</label>
                                <Field class="form-control"
                                    :id="`dischargedAliveHomeWithOther_${idx}`"
                                    type="number"
                                    :name="`dischargedAlivePatient[${idx}].dischargedAliveHomeWithOther`" />
                                <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveHomeWithOther`" class="error-feedback" />
                                <br>
                                <label :for="`dischargedAliveHospital_${idx}`">Admitted to hospital</label>
                                <Field class="form-control"
                                    :id="`dischargedAliveHospital_${idx}`"
                                    type="number"
                                    :name="`dischargedAlivePatient[${idx}].dischargedAliveHospital`" />
                                <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveHospital`" class="error-feedback" />


                                <br>
                                <label style="color:green"><strong>Discharge Employment Status</strong></label>
                                <br>
                                <label :for="`dischargedAliveEmployed_${idx}`">Employed</label>
                                <Field class="form-control"
                                    :id="`dischargedAliveEmployed_${idx}`"
                                    type="number"
                                    :name="`dischargedAlivePatient[${idx}].dischargedAliveEmployed`" />
                                <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveEmployed`" class="error-feedback" />
                                <br>
                                <label :for="`dischargedAliveUnableToFindWork_${idx}`">Unemployed, unable to find work</label>
                                <Field class="form-control"
                                    :id="`dischargedAliveUnableToFindWork_${idx}`"
                                    type="number"
                                    :name="`dischargedAlivePatient[${idx}].dischargedAliveUnableToFindWork`" />
                                <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveUnableToFindWork`" class="error-feedback" />
                                <br>
                                <label :for="`dischargedAliveDueToCondition_${idx}`">Unemployed, due to condition</label>
                                <Field class="form-control"
                                    :id="`dischargedAliveDueToCondition_${idx}`"
                                    type="number"
                                    :name="`dischargedAlivePatient[${idx}].dischargedAliveDueToCondition`" />
                                <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveDueToCondition`" class="error-feedback" />
                                <br>
                                <label :for="`dischargedAliveRetired_${idx}`">Retired, not working due to age</label>
                                <Field class="form-control"
                                    :id="`dischargedAliveRetired_${idx}`"
                                    type="number"
                                    :name="`dischargedAlivePatient[${idx}].dischargedAliveRetired`" />
                                <ErrorMessage :name="`dischargedAlivePatient[${idx}].dischargedAliveRetired`" class="error-feedback" />
                            </div>

                            

                            <button class="btn btn-outline-light btn-block" type="button" @click="remove(idx)">Remove patient X</button>
                            </fieldset>

                            <button class="btn btn-outline-light btn-block" type="button" @click="push({ 
                                dischargedAliveOption: '',

                                dischargedAlivePatientNo: '',

                                dischargedAliveAllGoals: '',
                                dischargedAliveGoalsPartially: '',
                                dischargedAliveNoGoals: '',

                                dischargedAliveADLsIndependent: '',
                                dischargedAliveADLsModifiedIndependent: '',
                                dischargedAliveADLsSupervision: '',
                                dischargedAliveADLsMinimumAssistance: '',
                                dischargedAliveADLsModerateAssistance: '',
                                dischargedAliveADLsMaximumAssistance: '',
                                dischargedAliveADLsDependent: '',

                                dischargedAliveTransfersIndependent: '',
                                dischargedAliveTransfersModifiedIndependent: '',
                                dischargedAliveTransfersSupervision: '',
                                dischargedAliveTransfersMinimumAssistance: '',
                                dischargedAliveTransfersModerateAssistance: '',
                                dischargedAliveTransfersMaximumAssistance: '',
                                dischargedAliveTransfersDependent: '',

                                dischargedAliveWheelchair: '',
                                dischargedAliveWalker: '',
                                dischargedAliveCane: '',
                                dischargedAliveCrutches: '',

                                dischargedAliveHomeAlone: '',
                                dischargedAliveHomeWithOther: '',
                                dischargedAliveHospital: '',

                                dischargedAliveEmployed: '',
                                dischargedAliveUnableToFindWork: '',
                                dischargedAliveDueToCondition: '',
                                dischargedAliveRetired: '',
                                })">
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
                            <legend style="color:green"><strong> Patient {{ idx+1 }}: </strong></legend>

                            <!-- Radio buttons -->
                            <div>
                                <legend>Patient {{ idx+1 }} Diagnosis: </legend>
                                <div class="form-check">
                                    <Field class="form-check-input" id="option1" :name="`diedBefore48hPatient[${idx}].diedBefore48hOption`" type="radio" value="SCI"></Field>
                                    <label class="form-check-label" for="option1"> SCI</label>
                                </div>
                                <div class="form-check">
                                    <Field class="form-check-input" id="option2" :name="`diedBefore48hPatient[${idx}].diedBefore48hOption`" type="radio" value="CVA"></Field>
                                    <label class="form-check-label" for="option2"> CVA</label>
                                </div>
                                <div class="form-check">
                                    <Field class="form-check-input" id="option3" :name="`diedBefore48hPatient[${idx}].diedBefore48hOption`" type="radio" value="Other"></Field>
                                    <label class="form-check-label" for="option3"> Other</label>
                                </div>
                                <br>
                                <br>
                                <ErrorMessage :name="`diedBefore48hPatient[${idx}].diedBefore48hOption`" class="error-feedback" />
                            </div>

                            <!-- Input boxed list -->
                            <div>
                                <br>
                                <label :for="`diedBefore48hAge_${idx}`">Age</label>
                                <Field class="form-control"
                                    :id="`diedBefore48hAge_${idx}`" 
                                    type="numbere"
                                    :name="`diedBefore48hPatient[${idx}].diedBefore48hAge`" />
                                <ErrorMessage :name="`diedBefore48hPatient[${idx}].diedBefore48hAge`" class="error-feedback" />
                                <br>
                                <legend :for="`diedBefore48hCause_${idx}`">Patient {{ idx+1 }} Cause of Death</legend>
                                <Field class="form-control"
                                    :id="`diedBefore48hCause_${idx}`"
                                    :name="`diedBefore48hPatient[${idx}].diedBefore48hCause`" />
                                <ErrorMessage :name="`diedBefore48hPatient[${idx}].diedBefore48hCause`" class="error-feedback" />
                            </div>

                            <button class="btn btn-outline-light btn-block" type="button" @click="remove(idx)">Remove patient X</button>
                            </fieldset>

                            <button class="btn btn-outline-light btn-block" type="button" @click="push({ 
                                diedBefore48hOption: '', 
                                diedBefore48hAge: '', 
                                diedBefore48hCause: '', 
                                })">
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
                            <!-- Radio buttons -->
                            <div>
                                <legend>Patient {{ idx+1 }} Diagnosis: </legend>
                                <div class="form-check">
                                    <Field class="form-check-input" id="option1" :name="`diedAfter48hPatient[${idx}].diedAfter48hOption`" type="radio" value="SCI"></Field>
                                    <label class="form-check-label" for="option1"> SCI</label>
                                </div>
                                <div class="form-check">
                                    <Field class="form-check-input" id="option2" :name="`diedAfter48hPatient[${idx}].diedAfter48hOption`" type="radio" value="CVA"></Field>
                                    <label class="form-check-label" for="option2"> CVA</label>
                                </div>
                                <div class="form-check">
                                    <Field class="form-check-input" id="option3" :name="`diedAfter48hPatient[${idx}].diedAfter48hOption`" type="radio" value="Other"></Field>
                                    <label class="form-check-label" for="option3"> Other</label>
                                </div>
                                <br>
                                <br>
                                <ErrorMessage :name="`diedAfter48hPatient[${idx}].diedAfter48hOption`" class="error-feedback" />
                            </div>

                            <!-- Input boxed list -->
                            <div>
                                <br>
                                <label :for="`diedAfter48hAge_${idx}`">Age</label>
                                <Field class="form-control"
                                    :id="`diedAfter48hAge_${idx}`" 
                                    type="numbere"
                                    :name="`diedAfter48hPatient[${idx}].diedAfter48hAge`" />
                                <ErrorMessage :name="`diedAfter48hPatient[${idx}].diedAfter48hAge`" class="error-feedback" />
                                <br>
                                <legend :for="`diedAfter48hCause_${idx}`">Patient {{ idx+1 }} Cause of Death</legend>
                                <Field class="form-control"
                                    :id="`diedAfter48hCause_${idx}`"
                                    :name="`diedAfter48hPatient[${idx}].diedAfter48hCause`" />
                                <ErrorMessage :name="`diedAfter48hPatient[${idx}].diedAfter48hCause`" class="error-feedback" />
                            </div>

                            <button class="btn btn-outline-light btn-block" type="button" @click="remove(idx)">Remove patient X</button>
                            </fieldset>

                            <button class="btn btn-outline-light btn-block" type="button" @click="push({ 
                                diedAfter48hOption: '', 
                                diedAfter48hAge: '', 
                                diedAfter48hCause: '', 
                                })">
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
                    <!-- Todo: this additional form need to be translated -->
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

                <div>
                     <!-- Todo: this additional form need to be translated -->
                    <div class="form-group">
                        <label for="stayedInTheWard">{{ $t('msppData.stayedInTheWard') }}</label>
                        <Field name="stayedInTheWard" type="text" class="form-control" value=0 id="stayedInTheWard" v-on:keyup="checkStayedInTheWard()"/>
                        <ErrorMessage name="stayedInTheWard" class="error-feedback" />
                    </div>

                    <div>
                        <div v-if="stayedInTheWardMor" class="form-group">
                            <h4 style="color:green">Reason Not Yet Discharged </h4>
                            <label for="reasonNotReady">Not ready from therapy standpoint</label>
                            <Field name="reasonNotReady" type="text" class="form-control" value=0 />
                            <ErrorMessage name="reasonNotReady" class="error-feedback" />
                        </div>
                        <div v-if="stayedInTheWardMor" class="form-group">
                            <label for="reasonWoundCare">Wound Care</label>
                            <Field name="reasonWoundCare" type="text" class="form-control" value=0 />
                            <ErrorMessage name="reasonWoundCare" class="error-feedback" />
                        </div>
                        <div v-if="stayedInTheWardMor" class="form-group">
                            <label for="otherMedicalReason">Other medical reason (such as IV medication)</label>
                            <Field name="otherMedicalReason" type="text" class="form-control" value=0 />
                            <ErrorMessage name="otherMedicalReason" class="error-feedback" />
                        </div>
                        <div v-if="stayedInTheWardMor" class="form-group">
                            <label for="reasonFinancial">Financial/no place to discharge to</label>
                            <Field name="reasonFinancial" type="text" class="form-control" value=0 />
                            <ErrorMessage name="reasonFinancial" class="error-feedback" />
                        </div>
                    </div>

                    <div>
                        <div v-if="stayedInTheWardMor" class="form-group">
                            <h4 style="color:green">Length of Stay of Current Inpatients </h4>
                            <label for="length1_3m">1-3 months</label>
                            <Field name="length1_3m" type="text" class="form-control" value=0 />
                            <ErrorMessage name="length1_3m" class="error-feedback" />
                        </div>
                        <div v-if="stayedInTheWardMor" class="form-group">
                            <label for="length3_6m">3-6 months</label>
                            <Field name="length3_6m" type="text" class="form-control" value=0 />
                            <ErrorMessage name="length3_6m" class="error-feedback" />
                        </div>
                        <div v-if="stayedInTheWardMor" class="form-group">
                            <label for="length6m_1y">6 months - 1 year</label>
                            <Field name="length6m_1y" type="text" class="form-control" value=0 />
                            <ErrorMessage name="length6m_1y" class="error-feedback" />
                        </div>
                        <div v-if="stayedInTheWardMor" class="form-group">
                            <label for="length1_2y">1-2 years</label>
                            <Field name="length1_2y" type="text" class="form-control" value=0 />
                            <ErrorMessage name="length1_2y" class="error-feedback" />
                        </div>
                        <div v-if="stayedInTheWardMor" class="form-group">
                            <label for="length2_3y">2-3 years</label>
                            <Field name="length2_3y" type="text" class="form-control" value=0 />
                            <ErrorMessage name="length2_3y" class="error-feedback" />
                        </div>
                        <div v-if="stayedInTheWardMor" class="form-group">
                            <label for="length3_y">3+ years</label>
                            <Field name="length3_y" type="text" class="form-control" value=0 />
                            <ErrorMessage name="length3_y" class="error-feedback" />
                        </div>
                    </div>

                </div>


                <div>
                    <!-- Todo: this additional form need to be translated -->
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
                            <Field name="fromOther" type="text" class="form-control" />
                            <ErrorMessage name="fromOther" class="error-feedback" />
                        </div>
                    </div>

                    <div>
                        <div v-if="admissionsMor" class="form-group">
                            <h4 style="color:green">Main Condition</h4>
                            <label for="mainCoditionTetraplegia">SCI - tetraplegia</label>
                            <Field name="mainCoditionTetraplegia" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionTetraplegia" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionComplete">Complete</label>
                            <Field name="mainCoditionComplete" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionComplete" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionIncomplete">Incomplete</label>
                            <Field name="mainCoditionIncomplete" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionIncomplete" class="error-feedback" />
                        </div>
                        <!-- Injury: C -->
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionC1">Level of Injury: C1</label>
                            <Field name="mainCoditionC1" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionC1" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionC2">Level of Injury: C2</label>
                            <Field name="mainCoditionC2" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionC2" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionC3">Level of Injury: C3</label>
                            <Field name="mainCoditionC3" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionC3" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionC4">Level of Injury: C4</label>
                            <Field name="mainCoditionC4" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionC4" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionC5">Level of Injury: C5</label>
                            <Field name="mainCoditionC5" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionC5" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionC6">Level of Injury: C6</label>
                            <Field name="mainCoditionC6" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionC6" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionC7">Level of Injury: C7</label>
                            <Field name="mainCoditionC7" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionC7" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionC8">Level of Injury: C8</label>
                            <Field name="mainCoditionC8" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionC8" class="error-feedback" />
                        </div>
                        <!-- Injury: T1 -->
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionT1">Level of Injury: T1</label>
                            <Field name="mainCoditionT1" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionT1" class="error-feedback" />
                        </div>
                    </div>

                    <div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionParaplegia">SCI - paraplegia</label>
                            <Field name="mainCoditionParaplegia" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionParaplegia" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionComplete2">Complete</label>
                            <Field name="mainCoditionComplete2" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionComplete2" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionIncomplete2">Incomplete</label>
                            <Field name="mainCoditionIncomplete2" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionIncomplete2" class="error-feedback" />
                        </div>
                        <!-- Injury: T -->
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionT2">Level of Injury: T2</label>
                            <Field name="mainCoditionT2" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionT2" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionT3">Level of Injury: T3</label>
                            <Field name="mainCoditionT3" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionT3" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionT4">Level of Injury: T4</label>
                            <Field name="mainCoditionT4" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionT4" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionT5">Level of Injury: T5</label>
                            <Field name="mainCoditionT5" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionT5" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionT6">Level of Injury: T6</label>
                            <Field name="mainCoditionT6" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionT6" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionT7">Level of Injury: T7</label>
                            <Field name="mainCoditionT7" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionT7" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionT8">Level of Injury: T8</label>
                            <Field name="mainCoditionT8" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionT8" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionT9">Level of Injury: T9</label>
                            <Field name="mainCoditionT9" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionT9" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionT10">Level of Injury: T10</label>
                            <Field name="mainCoditionT10" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionT10" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionT11">Level of Injury: T11</label>
                            <Field name="mainCoditionT11" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionT11" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionT12">Level of Injury: T12</label>
                            <Field name="mainCoditionT12" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionT12" class="error-feedback" />
                        </div>
                        <!-- Injury: L -->
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionL1">Level of Injury: L1</label>
                            <Field name="mainCoditionL1" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionTL1" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionL2">Level of Injury: L2</label>
                            <Field name="mainCoditionL2" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionL2" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionL3">Level of Injury: L3</label>
                            <Field name="mainCoditionL3" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionL3" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionL4">Level of Injury: L4</label>
                            <Field name="mainCoditionL4" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionL4" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionL5">Level of Injury: L5</label>
                            <Field name="mainCoditionL5" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionL5" class="error-feedback" />
                        </div>
                        <!-- Injury: S -->
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionS1">Level of Injury: S1</label>
                            <Field name="mainCoditionS1" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionS1" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionS2">Level of Injury: S2</label>
                            <Field name="mainCoditionS2" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionS2" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionS3">Level of Injury: S3</label>
                            <Field name="mainCoditionS3" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionS3" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionS4">Level of Injury: S4</label>
                            <Field name="mainCoditionS4" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionS4" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionS5">Level of Injury: S5</label>
                            <Field name="mainCoditionS5" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionS5" class="error-feedback" />
                        </div>
                    </div>

                    <div>
                        <div v-if="admissionsMor" class="form-group">
                            <h4 style="color:blue">Cause of SCI</h4>
                            <label for="SCITransportAccident">Transport Accident</label>
                            <Field name="SCITransportAccident" type="text" class="form-control" value=0 />
                            <ErrorMessage name="SCITransportAccident" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="SCIFall">Fall</label>
                            <Field name="SCIFall" type="text" class="form-control" value=0 />
                            <ErrorMessage name="SCIFall" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="SCIAssault">Assault</label>
                            <Field name="SCIAssault" type="text" class="form-control" value=0 />
                            <ErrorMessage name="SCIAssault" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="SCISports">Sports</label>
                            <Field name="SCISports" type="text" class="form-control" value=0 />
                            <ErrorMessage name="SCISports" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="SCINonTraumaticSpinalCordDysfunction">Non-traumatic spinal cord dysfunction</label>
                            <Field name="SCINonTraumaticSpinalCordDysfunction" type="text" class="form-control" value=0 />
                            <ErrorMessage name="SCINonTraumaticSpinalCordDysfunction" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="SCIMedical">Medical/surgical complication</label>
                            <Field name="SCIMedical" type="text" class="form-control" value=0 />
                            <ErrorMessage name="SCIMedical" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="SCIOtherTraumaticReason">Other traumatic reason</label>
                            <Field name="SCIOtherTraumaticReason" type="text" class="form-control" value=0 />
                            <ErrorMessage name="SCIOtherTraumaticReason" class="error-feedback" />
                        </div>
                    </div>

                    <div>
                        <div v-if="admissionsMor" class="form-group">
                            <h4 style="color:blue">Age</h4>
                            <label for="SCIAge0_5">Age 0-5</label>
                            <Field name="SCIAge0_5" type="text" class="form-control" value=0 />
                            <ErrorMessage name="SCIAge0_5" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="SCIAge6_11">Age 6-11</label>
                            <Field name="SCIAge6_11" type="text" class="form-control" value=0 />
                            <ErrorMessage name="SCIAge6_11" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="SCIAge12_18">Age 12-18</label>
                            <Field name="SCIAge12_18" type="text" class="form-control" value=0 />
                            <ErrorMessage name="SCIAge12_18" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="SCIAge18_30">Age 18-30</label>
                            <Field name="SCIAge18_30" type="text" class="form-control" value=0 />
                            <ErrorMessage name="SCIAge18_30" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="SCIAge31_50">Age 31-50</label>
                            <Field name="SCIAge31_50" type="text" class="form-control" value=0 />
                            <ErrorMessage name="SCIAge31_50" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="SCIAge51_70">Age 51-70</label>
                            <Field name="SCIAge51_70" type="text" class="form-control" value=0 />
                            <ErrorMessage name="SCIAge51_70" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="SCIAge70">Age 70+</label>
                            <Field name="SCIAge70" type="text" class="form-control" value=0 />
                            <ErrorMessage name="SCIAge70" class="error-feedback" />
                        </div>
                    </div>

                    <div>
                        <div v-if="admissionsMor" class="form-group">
                            <h4 style="color:blue">Gender</h4>
                            <label for="SCIMale">Male</label>
                            <Field name="SCIMale" type="text" class="form-control" value=0 />
                            <ErrorMessage name="SCIMale" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="SCIFemale">Female</label>
                            <Field name="SCIFemale" type="text" class="form-control" value=0 />
                            <ErrorMessage name="SCIFemale" class="error-feedback" />
                        </div>
                    </div>

                    <div>
                        <div v-if="admissionsMor" class="form-group">
                            <h4 style="color:green">Main Condition - Cont.</h4>
                            <label for="mainCoditionStroke">Stroke/ CVA</label>
                            <Field name="mainCoditionStroke" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionStroke" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionFracturedHip">Fractured hip</label>
                            <Field name="mainCoditionFracturedHip" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionFracturedHip" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionFracturedLongBones">Fractured long bones</label>
                            <Field name="mainCoditionFracturedLongBones" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionFracturedLongBones" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionNeurodegenerativeDisease">Neurodegenerative Disease</label>
                            <Field name="mainCoditionNeurodegenerativeDisease" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionNeurodegenerativeDisease" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionHeadInjury">Head injury</label>
                            <Field name="mainCoditionHeadInjury" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionHeadInjury" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionWoundCare">Wound Care</label>
                            <Field name="mainCoditionWoundCare" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionWoundCare" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionOtherMedical">Other medical</label>
                            <Field name="mainCoditionOtherMedical" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionOtherMedical" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="mainCoditionOtherTrauma">Other trauma</label>
                            <Field name="mainCoditionOtherTrauma" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mainCoditionOtherTrauma" class="error-feedback" />
                        </div>
                    </div>

                    <div>
                        <div v-if="admissionsMor" class="form-group">
                            <h4 style="color:green">Time from Injury until Admitted to Rehab</h4>
                            <label for="timeLessThan1m">Less than 1 month</label>
                            <Field name="timeLessThan1m" type="text" class="form-control" value=0 />
                            <ErrorMessage name="timeLessThan1m" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="time1_2m">1-2 months</label>
                            <Field name="time1_2m" type="text" class="form-control" value=0 />
                            <ErrorMessage name="time1_2m" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="time3m">3 months</label>
                            <Field name="time3m" type="text" class="form-control" value=0 />
                            <ErrorMessage name="time3m" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="time6m">6 months </label>
                            <Field name="time6m" type="text" class="form-control" value=0 />
                            <ErrorMessage name="time6m" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="time1y">1 year</label>
                            <Field name="time1y" type="text" class="form-control" value=0 />
                            <ErrorMessage name="time1y" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="time2y">2 years</label>
                            <Field name="time2y" type="text" class="form-control" value=0 />
                            <ErrorMessage name="time2y" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="timeMoreThan3y">3+ years</label>
                            <Field name="timeMoreThan3y" type="text" class="form-control" value=0 />
                            <ErrorMessage name="timeMoreThan3y" class="error-feedback" />
                        </div>
                    </div>

                </div>

                <div>
                     <!-- Todo: this additional form need to be translated -->
                    <div class="form-group">
                        <label for="numberOfOutpatients">Number of outpatients</label>
                        <Field name="numberOfOutpatients" type="text" class="form-control" value=0 id="numberOfOutpatients" v-on:keyup="checkNumberOfOutpatients()"/>
                        <ErrorMessage name="numberOfOutpatients" class="error-feedback" />
                    </div>

                    <div>
                        <div v-if="numberOfOutpatientsMor" class="form-group">
                            <label for="returningOutpatients">Returning outpatients</label>
                            <Field name="returningOutpatients" type="text" class="form-control" value=0 />
                            <ErrorMessage name="returningOutpatients" class="error-feedback" />
                        </div>

                        <div>
                            <div v-if="numberOfOutpatientsMor" class="form-group">
                                <label for="newOutpatient">New outpatient initial evaluations</label>
                                <Field name="newOutpatient" type="text" class="form-control" value=0 id="newOutpatient" v-on:keyup="checkNewOutpatient()"/>
                                <ErrorMessage name="newOutpatient" class="error-feedback" />
                            </div>

                            <div>
                                <div v-if="newOutpatientMor" class="form-group">
                                    <h4 style="color:green">Main Condition of New Patients</h4>
                                    <label for="newSCIParaplegia">SCI - paraplegia</label>
                                    <Field name="newSCIParaplegia" type="text" class="form-control" value=0 />
                                    <ErrorMessage name="newSCIParaplegia" class="error-feedback" />
                                </div>
                                <div v-if="newOutpatientMor" class="form-group">
                                    <label for="newSCITetraplegia">SCI - tetraplegia</label>
                                    <Field name="newSCITetraplegia" type="text" class="form-control" value=0 />
                                    <ErrorMessage name="newSCITetraplegia" class="error-feedback" />
                                </div>
                                <div v-if="newOutpatientMor" class="form-group">
                                    <label for="newStroke">Stroke/ CVA</label>
                                    <Field name="newStroke" type="text" class="form-control" value=0 />
                                    <ErrorMessage name="newStroke" class="error-feedback" />
                                </div>
                                <div v-if="newOutpatientMor" class="form-group">
                                    <label for="newFracturedHip">Fractured hip</label>
                                    <Field name="newFracturedHip" type="text" class="form-control" value=0 />
                                    <ErrorMessage name="newFracturedHip" class="error-feedback" />
                                </div>
                                <div v-if="newOutpatientMor" class="form-group">
                                    <label for="newFracturedLongBones">Fractured long bones</label>
                                    <Field name="newFracturedLongBones" type="text" class="form-control" value=0 />
                                    <ErrorMessage name="newFracturedLongBones" class="error-feedback" />
                                </div>
                                <div v-if="newOutpatientMor" class="form-group">
                                    <label for="newNeurodegenerativeDisease">Neurodegenerative Disease</label>
                                    <Field name="newNeurodegenerativeDisease" type="text" class="form-control" value=0 />
                                    <ErrorMessage name="newNeurodegenerativeDisease" class="error-feedback" />
                                </div>
                                <div v-if="newOutpatientMor" class="form-group">
                                    <label for="newHeadInjury">Head injury</label>
                                    <Field name="newHeadInjury" type="text" class="form-control" value=0 />
                                    <ErrorMessage name="newHeadInjury" class="error-feedback" />
                                </div>
                                <div v-if="newOutpatientMor" class="form-group">
                                    <label for="newWoundCare">Wound Care</label>
                                    <Field name="newWoundCare" type="text" class="form-control" value=0 />
                                    <ErrorMessage name="newWoundCare" class="error-feedback" />
                                </div>
                                <div v-if="newOutpatientMor" class="form-group">
                                    <label for="newCerebralPalsy">Cerebral Palsy</label>
                                    <Field name="newCerebralPalsy" type="text" class="form-control" value=0 />
                                    <ErrorMessage name="newCerebralPalsy" class="error-feedback" />
                                </div>
                                <div v-if="newOutpatientMor" class="form-group">
                                    <label for="newDownSyndromel">Down Syndrome</label>
                                    <Field name="newDownSyndromel" type="text" class="form-control" value=0 />
                                    <ErrorMessage name="newDownSyndromel" class="error-feedback" />
                                </div>
                                <div v-if="newOutpatientMor" class="form-group">
                                    <label for="newOther">Other</label>
                                    <Field name="newOther" type="text" class="form-control" value=0 />
                                    <ErrorMessage name="newOther" class="error-feedback" />
                                </div>
                            </div>
                            
                            <div>
                                <div v-if="newOutpatientMor" class="form-group">
                                    <h4 style="color:green">Age of New patients</h4>
                                    <label for="newAge0_5">Age 0-5</label>
                                    <Field name="newAge0_5" type="text" class="form-control" value=0 />
                                    <ErrorMessage name="newAge0_5" class="error-feedback" />
                                </div>
                                <div v-if="newOutpatientMor" class="form-group">
                                    <label for="newAge6_11">Age 6-11</label>
                                    <Field name="newAge6_11" type="text" class="form-control" value=0 />
                                    <ErrorMessage name="newAge6_11" class="error-feedback" />
                                </div>
                                <div v-if="newOutpatientMor" class="form-group">
                                    <label for="newAge12_18">Age 12-18</label>
                                    <Field name="newAge12_18" type="text" class="form-control" value=0 />
                                    <ErrorMessage name="newAge12_18" class="error-feedback" />
                                </div>
                                <div v-if="newOutpatientMor" class="form-group">
                                    <label for="newAge18_30">Age 18-30</label>
                                    <Field name="newAge18_30" type="text" class="form-control" value=0 />
                                    <ErrorMessage name="newAge18_30" class="error-feedback" />
                                </div>
                                <div v-if="newOutpatientMor" class="form-group">
                                    <label for="newAge31_50">Age 31-50</label>
                                    <Field name="newAge31_50" type="text" class="form-control" value=0 />
                                    <ErrorMessage name="newAge31_50" class="error-feedback" />
                                </div>
                                <div v-if="newOutpatientMor" class="form-group">
                                    <label for="newAge51_70">Age 51-70</label>
                                    <Field name="newAge51_70" type="text" class="form-control" value=0 />
                                    <ErrorMessage name="newAge51_70" class="error-feedback" />
                                </div>
                                <div v-if="newOutpatientMor" class="form-group">
                                    <label for="newAge70">Age 70+</label>
                                    <Field name="newAge70" type="text" class="form-control" value=0 />
                                    <ErrorMessage name="newAge70" class="error-feedback" />
                                </div>
                            </div>

                            <div>
                                <div v-if="newOutpatientMor" class="form-group">
                                    <h4 style="color:green">Gender of New patients</h4>
                                    <label for="newMale">Male</label>
                                    <Field name="newMale" type="text" class="form-control" value=0 />
                                    <ErrorMessage name="newMale" class="error-feedback" />
                                </div>
                                <div v-if="newOutpatientMor" class="form-group">
                                    <label for="newFemale">Female</label>
                                    <Field name="newFemale" type="text" class="form-control" value=0 />
                                    <ErrorMessage name="newFemale" class="error-feedback" />
                                </div>
                            </div>

                            
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
    name: "Rehab_Data",
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
                    diedBefore48hOption: yup
                        .string()
                        .required("Must choose an option.")
                        .default(""),
                    diedBefore48hAge: yup
                        .string()
                        .required("Required.")
                        .default("0"),
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
                    diedAfter48hOption: yup
                        .string()
                        .required("Must choose an option.")
                        .default(""),
                    diedAfter48hAge: yup
                        .string()
                        .required("Required.")
                        .default("0"),
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

                    dischargedAlivePatientNo: yup
                        .string()
                        .required("Required.")
                        .default("0"),

                    dischargedAliveAllGoals: yup
                        .string()
                        .required("Required.")
                        .default("0"),
                    dischargedAliveGoalsPartially: yup
                        .string()
                        .required("Required.")
                        .default("0"),
                    dischargedAliveNoGoals: yup
                        .string()
                        .required("Required.")
                        .default("0"),
                    
                    dischargedAliveADLsIndependent: yup
                        .string()
                        .required("Required.")
                        .default("0"),
                    dischargedAliveADLsModifiedIndependent: yup
                        .string()
                        .required("Required.")
                        .default("0"),
                    dischargedAliveADLsSupervision: yup
                        .string()
                        .required("Required.")
                        .default("0"),
                    dischargedAliveADLsMinimumAssistance: yup
                        .string()
                        .required("Required.")
                        .default("0"),
                    dischargedAliveADLsModerateAssistance: yup
                        .string()
                        .required("Required.")
                        .default("0"),
                    dischargedAliveADLsMaximumAssistance: yup
                        .string()
                        .required("Required.")
                        .default("0"),
                    dischargedAliveADLsDependent: yup
                        .string()
                        .required("Required.")
                        .default("0"),

                    dischargedAliveTransfersIndependent: yup
                        .string()
                        .required("Required.")
                        .default("0"),
                    dischargedAliveTransfersModifiedIndependent: yup
                        .string()
                        .required("Required.")
                        .default("0"),
                    dischargedAliveTransfersSupervision: yup
                        .string()
                        .required("Required.")
                        .default("0"),
                    dischargedAliveTransfersMinimumAssistance: yup
                        .string()
                        .required("Required.")
                        .default("0"),
                    dischargedAliveTransfersModerateAssistance: yup
                        .string()
                        .required("Required.")
                        .default("0"),
                    dischargedAliveTransfersMaximumAssistance: yup
                        .string()
                        .required("Required.")
                        .default("0"),
                    dischargedAliveTransfersDependent: yup
                        .string()
                        .required("Required.")
                        .default("0"),

                    dischargedAliveWheelchair: yup
                        .string()
                        .required("Required.")
                        .default("0"),
                    dischargedAliveWalker: yup
                        .string()
                        .required("Required.")
                        .default("0"),
                    dischargedAliveCane: yup
                        .string()
                        .required("Required.")
                        .default("0"),
                    dischargedAliveCrutches: yup
                        .string()
                        .required("Required.")
                        .default("0"),

                    dischargedAliveHomeAlone: yup
                        .string()
                        .required("Required.")
                        .default("0"),
                    dischargedAliveHomeWithOther: yup
                        .string()
                        .required("Required.")
                        .default("0"),
                    dischargedAliveHospital: yup
                        .string()
                        .required("Required.")
                        .default("0"),

                    dischargedAliveEmployed: yup
                        .string()
                        .required("Required.")
                        .default("0"),
                    dischargedAliveUnableToFindWork: yup
                        .string()
                        .required("Required.")
                        .default("0"),
                    dischargedAliveDueToCondition: yup
                        .string()
                        .required("Required.")
                        .default("0"),
                    dischargedAliveRetired: yup
                        .string()
                        .required("Required.")
                        .default("0"),

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
            reasonNotReady: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            reasonWoundCare: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            otherMedicalReason: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            reasonFinancial: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            length1_3m: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            length3_6m: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            length6m_1y: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            length1_2y: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            length2_3y: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            length3_y: yup
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
            mainCoditionTetraplegia: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionComplete: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionIncomplete: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionC1: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionC2: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionC3: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionC4: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionC5: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionC6: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionC7: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionC8: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionT1: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionParaplegia: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionComplete2: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionIncomplete2: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionT2: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionT3: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionT4: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionT5: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionT6: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionT7: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionT8: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionT9: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionT10: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionT11: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionT12: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionL1: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionL2: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionL3: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionL4: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionL5: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionS1: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionS2: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionS3: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionS4: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionS5: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            SCITransportAccident: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            SCIFall: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            SCIAssault: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            SCISports: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            SCINonTraumaticSpinalCordDysfunction: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            SCIMedical: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            SCIOtherTraumaticReason: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            SCIAge0_5: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            SCIAge6_11: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            SCIAge12_18: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            SCIAge18_30: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            SCIAge31_50: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            SCIAge51_70: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            SCIAge70: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            SCIMale: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            SCIFemale: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionStroke: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionFracturedHip: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionFracturedLongBones: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionNeurodegenerativeDisease: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionHeadInjury: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionWoundCare: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionOtherMedical: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            mainCoditionOtherTrauma: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            timeLessThan1m: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            time1_2m: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            time3m: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            time6m: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            time1y: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            time2y: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            timeMoreThan3y: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),

            numberOfOutpatients: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            returningOutpatients: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            newOutpatient: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            newSCIParaplegia: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            newSCITetraplegia: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            newStroke: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            newFracturedHip: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            newFracturedLongBones: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            newNeurodegenerativeDisease: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            newHeadInjury: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            newWoundCare: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            newCerebralPalsy: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            newDownSyndromel: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            newOther: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            newAge0_5: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            newAge6_11: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            newAge12_18: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            newAge18_30: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            newAge31_50: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            newAge51_70: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            newAge70: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            newMale: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            newFemale: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
  
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
            stayedInTheWardMor: false,
            numberOfOutpatientsMor: false,
            newOutpatientMor: false,
            dataSchema,
        };
    },
    methods: {
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
        checkStayedInTheWard() {
            let number: number = (document as any).getElementById("stayedInTheWard").value;
            if (number > 0) {
                this.stayedInTheWardMor = true;
            } else {
                this.stayedInTheWardMor = false;
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
        checkNumberOfOutpatients() {
            let number: number = (document as any).getElementById("numberOfOutpatients").value;
            if (number > 0) {
                this.numberOfOutpatientsMor = true;
            } else {
                this.numberOfOutpatientsMor = false;
            }
        },
        checkNewOutpatient() {
            let number: number = (document as any).getElementById("newOutpatient").value;
            if (number > 0) {
                this.newOutpatientMor = true;
            } else {
                this.newOutpatientMor = false;
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