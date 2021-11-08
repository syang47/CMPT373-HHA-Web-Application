<template>
    <Form class="background" @submit="handleData" :validation-schema="dataSchema">
        <div class="signup-form text-monospace">
            <div class="text-center">
                <h2 class="font-weight-bold display-5 text-dark text-monospace">{{ $t('msppData.nicupaedForm') }}</h2>
            </div>
            <div v-if="!successful">
                <div class="form-group">
                    <label for="bedsAvailable">{{ $t('msppData.bedsAvailable') }}</label>
                    <Field name="bedsAvailable" type="text" class="form-control" value=0 />
                    <ErrorMessage name="bedsAvailable" class="error-feedback" />
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

                <div>
                    <div class="form-group">
                        <label for="hospitalized">{{ $t('msppData.hospitalised') }}</label>
                        <Field name="hospitalized" id="hospitalized" type="text" class="form-control" v-on:keyup="checkHospitalized()" value=0 />
                        <ErrorMessage name="hospitalized" class="error-feedback" />
                    </div>
                    <div v-if="hospitalizedMor" class="form-group">
                        <label for="hospitalizedNICU">{{ $t('msppData.hospitalisedNICU') }}</label>
                        <Field name="hospitalizedNICU" type="text" class="form-control" value=0 />
                        <ErrorMessage name="hospitalizedNICU" class="error-feedback" />
                    </div>
                    <div v-if="hospitalizedMor" class="form-group">
                        <label for="hospitalizedPaed">{{ $t('msppData.hospitalisedPAED') }}</label>
                        <Field name="hospitalizedPaed" type="text" class="form-control" value=0 />
                        <ErrorMessage name="hospitalizedPaed" class="error-feedback" />
                    </div>
                </div>


                <div>
                    <div class="form-group">
                        <label for="dischargedAlive">{{ $t('msppData.dischargedAlive') }}</label>
                        <Field name="dischargedAlive" id="dischargedAlive" type="text" class="form-control" v-on:keyup="checkDischargedAlive()" value=0 />
                        <ErrorMessage name="dischargedAlive" class="error-feedback" />
                    </div>
                    <div v-if="dischargedAliveMor" class="form-group">
                        <label for="NICUDischarged">{{ $t('msppData.ofTotalDischargedNICU') }}</label>
                        <Field name="NICUDischarged" type="text" class="form-control" value=0 />
                        <ErrorMessage name="NICUDischarged" class="error-feedback" />
                    </div>
                </div>


                <div>
                    <div class="form-group">
                        <label for="diedBefore48h">{{ $t('msppData.diedBefore48h') }}</label>
                        <Field name="diedBefore48h" id="diedBefore48h" type="text" class="form-control" v-on:keyup="checkDiedBefore48h()" value=0 />
                        <ErrorMessage name="diedBefore48h" class="error-feedback" />
                    </div>
                    <div v-if="diedBefore48hMor" class="form-group">
                        <label for="diedInNICUBefore48">{{ $t('msppData.diedNICUBefore48h') }}</label>
                        <Field name="diedInNICUBefore48" type="text" class="form-control" value=0 />
                        <ErrorMessage name="diedInNICUBefore48" class="error-feedback" />
                    </div>
                    <div v-if="diedBefore48hMor" class="form-group">
                        <label for="diedInPaedBefore48">{{ $t('msppData.diedPAEDBefore48h') }}</label>
                        <Field name="diedInPaedBefore48" type="text" class="form-control"  value=0 />
                        <ErrorMessage name="diedInPaedBefore48" class="error-feedback" />
                    </div>
                </div>


                <div>
                    <div class="form-group">
                        <label for="diedAfter48h">{{ $t('msppData.diedAfter48h') }}</label>
                        <Field name="diedAfter48h" type="text" class="form-control" id="diedAfter48h" v-on:keyup="checkDiedAfter48h()" value=0 />
                        <ErrorMessage name="diedAfter48h" class="error-feedback" />
                    </div>
                    <div v-if="diedAfter48hMor" class="form-group">
                        <label for="diedInNICUAfter48">{{ $t('msppData.diedNICUAfter48h') }}</label>
                        <Field name="diedInNICUAfter48" type="text" class="form-control"  value=0 />
                        <ErrorMessage name="diedInNICUAfter48" class="error-feedback" />
                    </div>
                    <div v-if="diedBefore48hMor" class="form-group">
                        <label for="diedInPaedAfter48">{{ $t('msppData.diedPAEDAfter48h') }}</label>
                        <Field name="diedInPaedAfter48" type="text" class="form-control"  value=0 />
                        <ErrorMessage name="diedInPaedAfter48" class="error-feedback" />
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
                        <h4>{{ $t('msppData.reasonSelfDischarge') }}</h4>
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
                            <h4>{{ $t('msppData.wherePatientsComeFrom') }}</h4>
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
                    <div>
                        <div v-if="admissionsMor" class="form-group">
                            <h4>{{ $t('msppData.ageOfInfant') }}</h4>
                            <label for="admissionsExtremelyPreterm">{{ $t('msppData.extremePreterm') }}</label>
                            <Field name="admissionsExtremelyPreterm" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsExtremelyPreterm" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="admissionsVeryPreterm">{{ $t('msppData.veryPreterm') }}</label>
                            <Field name="admissionsVeryPreterm" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsVeryPreterm" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="admissionsModerateToLatePreterm">{{ $t('msppData.modToLatePreterm') }}</label>
                            <Field name="admissionsModerateToLatePreterm" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsModerateToLatePreterm" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="admissionsFullTerm">{{ $t('msppData.fullTerm') }}</label>
                            <Field name="admissionsFullTerm" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsFullTerm" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="admissionsOlderThanNeonate">{{ $t('msppData.olderThanNeonate') }}</label>
                            <Field name="admissionsOlderThanNeonate" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsOlderThanNeonate" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="admissionsAge4WeeksTo5">{{ $t('msppData.age4w_5y') }}</label>
                            <Field name="admissionsAge4WeeksTo5" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsAge4WeeksTo5" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="admissionsAge6To11">{{ $t('msppData.age6_11') }}</label>
                            <Field name="admissionsAge6To11" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsAge6To11" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="admissionsAge12To18">{{ $t('msppData.age12_18') }}</label>
                            <Field name="admissionsAge12To18" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsAge12To18" class="error-feedback" />
                        </div>
                    </div>
                    <div>
                        <div v-if="admissionsMor" class="form-group">
                            <h4>{{ $t('msppData.gender') }}</h4>
                            <label for="admissionsMale">{{ $t('msppData.male') }}</label>
                            <Field name="admissionsMale" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsMale" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="admissionsFemale">{{ $t('msppData.female') }}</label>
                            <Field name="admissionsFemale" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsFemale" class="error-feedback" />
                        </div>
                    </div>
                    <div>
                        <div v-if="admissionsMor" class="form-group">
                            <h4>{{ $t('msppData.mainCond') }}</h4>
                            <label for="admissionsRespiratoryArrest">{{ $t('msppData.respiratoryArrest') }}</label>
                            <Field name="admissionsRespiratoryArrest" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsRespiratoryArrest" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="admissionsTraumaticInjury">{{ $t('msppData.traumaticInjury') }}</label>
                            <Field name="admissionsTraumaticInjury" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsTraumaticInjury" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="admissionsSepticShock">{{ $t('msppData.septicShock') }}</label>
                            <Field name="admissionsSepticShock" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsSepticShock" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="admissionsHypovolemicShock">{{ $t('msppData.hypoShock') }}</label>
                            <Field name="admissionsHypovolemicShock" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsHypovolemicShock" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="admissionsSeizures">{{ $t('msppData.seizureConvulsion') }}</label>
                            <Field name="admissionsSeizures" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsSeizures" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="admissionsPoisoning">{{ $t('msppData.poisoning') }}</label>
                            <Field name="admissionsPoisoning" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsPoisoning" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="admissionsAlteredMentalStatus">{{ $t('msppData.altMentalStatus') }}</label>
                            <Field name="admissionsAlteredMentalStatus" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsAlteredMentalStatus" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="admissionsGastroenteritis">{{ $t('msppData.gastro') }}</label>
                            <Field name="admissionsGastroenteritis" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsGastroenteritis" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="admissionsHemorrhage">{{ $t('msppData.hemorrhage') }}</label>
                            <Field name="admissionsHemorrhage" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsHemorrhage" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="admissionsHypothermia">{{ $t('msppData.hypothermia') }}</label>
                            <Field name="admissionsHypothermia" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsHypothermia" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="admissionsCardiacCongenitalAnomaly">{{ $t('msppData.cardiacAnomaly') }}</label>
                            <Field name="admissionsCardiacCongenitalAnomaly" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsCardiacCongenitalAnomaly" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="admissionsOtherCongenitalAnomaly">{{ $t('msppData.otherAnomaly') }}</label>
                            <Field name="admissionsOtherCongenitalAnomaly" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsOtherCongenitalAnomaly" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="admissionsMalnutrition">{{ $t('msppData.malnutrition') }}</label>
                            <Field name="admissionsMalnutrition" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsMalnutrition" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="admissionsMeningitis">{{ $t('msppData.meningitis') }}</label>
                            <Field name="admissionsMeningitis" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsMeningitis" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="admissionsCommunityAcquiredPneumonia">{{ $t('msppData.communityPneum') }}</label>
                            <Field name="admissionsCommunityAcquiredPneumonia" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsCommunityAcquiredPneumonia" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="admissionsAspirationPneumonia">{{ $t('msppData.aspirationPneum') }}</label>
                            <Field name="admissionsAspirationPneumonia" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsAspirationPneumonia" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="admissionsModeratePrematurity">{{ $t('msppData.modPrematurity') }}</label>
                            <Field name="admissionsModeratePrematurity" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsModeratePrematurity" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="admissionsSeverePrematurity">{{ $t('msppData.severePrematurity') }}</label>
                            <Field name="admissionsSeverePrematurity" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsSeverePrematurity" class="error-feedback" />
                        </div>
                        <div v-if="admissionsMor" class="form-group">
                            <label for="admissionsOtherMedical">{{ $t('msppData.otherMedical') }}</label>
                            <Field name="admissionsOtherMedical" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsOtherMedical" class="error-feedback" />
                        </div>
                    </div>
                </div>


                <div>
                    <div class="form-group">
                        <label for="numberOfOutpatients">{{ $t('msppData.numberOfOutPatients') }}</label>
                        <Field name="numberOfOutpatients" type="text" class="form-control" id="numberOfOutpatients" v-on:keyup="checkNumberOfOutpatients()" value=0 />
                        <ErrorMessage name="numberOfOutpatients" class="error-feedback" />
                    </div>
                    <div>
                        <div v-if="numberOfOutpatientsMor" class="form-group">
                            <h4>{{ $t('msppData.age') }}</h4>
                            <label for="numberOfOutpatientsExtremelyPreterm">{{ $t('msppData.extremePreterm') }}</label>
                            <Field name="numberOfOutpatientsExtremelyPreterm" type="text" class="form-control" value=0 />
                            <ErrorMessage name="numberOfOutpatientsExtremelyPreterm" class="error-feedback" />
                        </div>
                        <div v-if="numberOfOutpatientsMor" class="form-group">
                            <label for="numberOfOutpatientsVeryPreterm">{{ $t('msppData.veryPreterm') }}</label>
                            <Field name="numberOfOutpatientsVeryPreterm" type="text" class="form-control" value=0 />
                            <ErrorMessage name="numberOfOutpatientsVeryPreterm" class="error-feedback" />
                        </div>
                        <div v-if="numberOfOutpatientsMor" class="form-group">
                            <label for="numberOfOutpatientsModerateToLatePreterm">{{ $t('msppData.modToLatePreterm') }}</label>
                            <Field name="numberOfOutpatientsModerateToLatePreterm" type="text" class="form-control" value=0 />
                            <ErrorMessage name="numberOfOutpatientsModerateToLatePreterm" class="error-feedback" />
                        </div>
                        <div v-if="numberOfOutpatientsMor" class="form-group">
                            <label for="numberOfOutpatientsFullTerm">{{ $t('msppData.fullTerm') }}</label>
                            <Field name="numberOfOutpatientsFullTerm" type="text" class="form-control" value=0 />
                            <ErrorMessage name="numberOfOutpatientsFullTerm" class="error-feedback" />
                        </div>
                        <div v-if="numberOfOutpatientsMor" class="form-group">
                            <label for="numberOfOutpatientsOlderThanNeonate">{{ $t('msppData.olderThanNeonate') }}</label>
                            <Field name="numberOfOutpatientsOlderThanNeonate" type="text" class="form-control" value=0 />
                            <ErrorMessage name="numberOfOutpatientsOlderThanNeonate" class="error-feedback" />
                        </div>
                        <div v-if="numberOfOutpatientsMor" class="form-group">
                            <label for="numberOfOutpatientsAge4WeeksTo5">{{ $t('msppData.age4w_5y') }}</label>
                            <Field name="numberOfOutpatientsAge4WeeksTo5" type="text" class="form-control" value=0 />
                            <ErrorMessage name="numberOfOutpatientsAge4WeeksTo5" class="error-feedback" />
                        </div>
                        <div v-if="numberOfOutpatientsMor" class="form-group">
                            <label for="numberOfOutpatientsAge6To11">{{ $t('msppData.age6_11') }}</label>
                            <Field name="numberOfOutpatientsAge6To11" type="text" class="form-control" value=0 />
                            <ErrorMessage name="numberOfOutpatientsAge6To11" class="error-feedback" />
                        </div>
                        <div v-if="numberOfOutpatientsMor" class="form-group">
                            <label for="numberOfOutpatientsAge12To18">{{ $t('msppData.age12_18') }}</label>
                            <Field name="numberOfOutpatientsAge12To18" type="text" class="form-control" value=0 />
                            <ErrorMessage name="numberOfOutpatientsAge12To18" class="error-feedback" />
                        </div>
                    </div>
                    <div>
                        <div v-if="numberOfOutpatientsMor" class="form-group">
                            <h4>Main Condition</h4>
                            <label for="numberOfOutpatientsRespiratoryArrest">{{ $t('msppData.respiratoryArrest') }}</label>
                            <Field name="numberOfOutpatientsRespiratoryArrest" type="text" class="form-control" value=0 />
                            <ErrorMessage name="numberOfOutpatientsRespiratoryArrest" class="error-feedback" />
                        </div>
                        <div v-if="numberOfOutpatientsMor" class="form-group">
                            <label for="numberOfOutpatientsTraumaticInjury">{{ $t('msppData.traumaticInjury') }}</label>
                            <Field name="numberOfOutpatientsTraumaticInjury" type="text" class="form-control" value=0 />
                            <ErrorMessage name="numberOfOutpatientsTraumaticInjury" class="error-feedback" />
                        </div>
                        <div v-if="numberOfOutpatientsMor" class="form-group">
                            <label for="numberOfOutpatientsSepticShock">{{ $t('msppData.septicShock') }}</label>
                            <Field name="numberOfOutpatientsSepticShock" type="text" class="form-control" value=0 />
                            <ErrorMessage name="numberOfOutpatientsSepticShock" class="error-feedback" />
                        </div>
                        <div v-if="numberOfOutpatientsMor" class="form-group">
                            <label for="numberOfOutpatientsHypovolemicShock">{{ $t('msppData.hypoShock') }}</label>
                            <Field name="numberOfOutpatientsHypovolemicShock" type="text" class="form-control" value=0 />
                            <ErrorMessage name="numberOfOutpatientsHypovolemicShock" class="error-feedback" />
                        </div>
                        <div v-if="numberOfOutpatientsMor" class="form-group">
                            <label for="numberOfOutpatientsSeizures">{{ $t('msppData.seizureConvulsion') }}</label>
                            <Field name="numberOfOutpatientsSeizures" type="text" class="form-control" value=0 />
                            <ErrorMessage name="numberOfOutpatientsSeizures" class="error-feedback" />
                        </div>
                        <div v-if="numberOfOutpatientsMor" class="form-group">
                            <label for="numberOfOutpatientsPoisoning">{{ $t('msppData.poisoning') }}</label>
                            <Field name="numberOfOutpatientsPoisoning" type="text" class="form-control" value=0 />
                            <ErrorMessage name="numberOfOutpatientsPoisoning" class="error-feedback" />
                        </div>
                        <div v-if="numberOfOutpatientsMor" class="form-group">
                            <label for="numberOfOutpatientsAlteredMentalStatus">{{ $t('msppData.altMentalStatus') }}</label>
                            <Field name="numberOfOutpatientsAlteredMentalStatus" type="text" class="form-control" value=0 />
                            <ErrorMessage name="numberOfOutpatientsAlteredMentalStatus" class="error-feedback" />
                        </div>
                        <div v-if="numberOfOutpatientsMor" class="form-group">
                            <label for="numberOfOutpatientsGastroenteritis">{{ $t('msppData.gastro') }}</label>
                            <Field name="numberOfOutpatientsGastroenteritis" type="text" class="form-control" value=0 />
                            <ErrorMessage name="numberOfOutpatientsGastroenteritis" class="error-feedback" />
                        </div>
                        <div v-if="numberOfOutpatientsMor" class="form-group">
                            <label for="numberOfOutpatientsHemorrhage">{{ $t('msppData.hemorrhage') }}</label>
                            <Field name="numberOfOutpatientsHemorrhage" type="text" class="form-control" value=0 />
                            <ErrorMessage name="numberOfOutpatientsHemorrhage" class="error-feedback" />
                        </div>
                        <div v-if="numberOfOutpatientsMor" class="form-group">
                            <label for="numberOfOutpatientsHypothermia">{{ $t('msppData.hypothermia') }}</label>
                            <Field name="numberOfOutpatientsHypothermia" type="text" class="form-control" value=0 />
                            <ErrorMessage name="numberOfOutpatientsHypothermia" class="error-feedback" />
                        </div>
                        <div v-if="numberOfOutpatientsMor" class="form-group">
                            <label for="numberOfOutpatientsCardiacCongenitalAnomaly">{{ $t('msppData.cardiacAnomaly') }}</label>
                            <Field name="numberOfOutpatientsCardiacCongenitalAnomaly" type="text" class="form-control" value=0 />
                            <ErrorMessage name="numberOfOutpatientsCardiacCongenitalAnomaly" class="error-feedback" />
                        </div>
                        <div v-if="numberOfOutpatientsMor" class="form-group">
                            <label for="numberOfOutpatientsOtherCongenitalAnomaly">{{ $t('msppData.otherAnomaly') }}</label>
                            <Field name="numberOfOutpatientsOtherCongenitalAnomaly" type="text" class="form-control" value=0 />
                            <ErrorMessage name="numberOfOutpatientsOtherCongenitalAnomaly" class="error-feedback" />
                        </div>
                        <div v-if="numberOfOutpatientsMor" class="form-group">
                            <label for="numberOfOutpatientsMalnutrition">{{ $t('msppData.malnutrition') }}</label>
                            <Field name="numberOfOutpatientsMalnutrition" type="text" class="form-control" value=0 />
                            <ErrorMessage name="numberOfOutpatientsMalnutrition" class="error-feedback" />
                        </div>
                        <div v-if="numberOfOutpatientsMor" class="form-group">
                            <label for="numberOfOutpatientsMeningitis">{{ $t('msppData.meningitis') }}</label>
                            <Field name="numberOfOutpatientsMeningitis" type="text" class="form-control" value=0 />
                            <ErrorMessage name="numberOfOutpatientsMeningitis" class="error-feedback" />
                        </div>
                        <div v-if="numberOfOutpatientsMor" class="form-group">
                            <label for="numberOfOutpatientsCommunityAcquiredPneumonia">{{ $t('msppData.communityPneum') }}</label>
                            <Field name="numberOfOutpatientsCommunityAcquiredPneumonia" type="text" class="form-control" value=0 />
                            <ErrorMessage name="numberOfOutpatientsCommunityAcquiredPneumonia" class="error-feedback" />
                        </div>
                        <div v-if="numberOfOutpatientsMor" class="form-group">
                            <label for="numberOfOutpatientsAspirationPneumonia">{{ $t('msppData.aspirationPneum') }}</label>
                            <Field name="numberOfOutpatientsAspirationPneumonia" type="text" class="form-control" value=0 />
                            <ErrorMessage name="numberOfOutpatientsAspirationPneumonia" class="error-feedback" />
                        </div>
                        <div v-if="numberOfOutpatientsMor" class="form-group">
                            <label for="numberOfOutpatientsModeratePrematurity">{{ $t('msppData.modPrematurity') }}</label>
                            <Field name="numberOfOutpatientsModeratePrematurity" type="text" class="form-control" value=0 />
                            <ErrorMessage name="numberOfOutpatientsModeratePrematurity" class="error-feedback" />
                        </div>
                        <div v-if="numberOfOutpatientsMor" class="form-group">
                            <label for="numberOfOutpatientsSeverePrematurity">{{ $t('msppData.severePrematurity') }}</label>
                            <Field name="numberOfOutpatientsSeverePrematurity" type="text" class="form-control" value=0 />
                            <ErrorMessage name="numberOfOutpatientsSeverePrematurity" class="error-feedback" />
                        </div>
                        <div v-if="numberOfOutpatientsMor" class="form-group">
                            <label for="numberOfOutpatientsOtherMedical">{{ $t('msppData.otherMedical') }}</label>
                            <Field name="numberOfOutpatientsOtherMedical" type="text" class="form-control" value=0 />
                            <ErrorMessage name="numberOfOutpatientsOtherMedical" class="error-feedback" />
                        </div>
                    </div>
                    <div>
                        <div v-if="numberOfOutpatientsMor" class="form-group">
                            <h4>{{ $t('msppData.gender') }}</h4>
                            <label for="boy">{{ $t('msppData.boy') }}</label>
                            <Field name="admissionsMale" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsMale" class="error-feedback" />
                        </div>
                        <div v-if="numberOfOutpatientsMor" class="form-group">
                            <label for="girl">{{ $t('msppData.girl') }}</label>
                            <Field name="admissionsFemale" type="text" class="form-control" value=0 />
                            <ErrorMessage name="admissionsFemale" class="error-feedback" />
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
</template>

<script lang="ts" type="text/typescript">
import { defineComponent } from 'vue'
import { Form, Field, ErrorMessage } from "vee-validate";
import * as yup from "yup";
export default defineComponent({
    name: "Rehab_Data",
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
            hospitalizedNICU: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            hospitalizedPaed: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),


            dischargedAlive: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            NICUDischarged: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),


            diedBefore48h: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            diedInNICUBefore48: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            diedInPaedBefore48: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),


            diedAfter48h: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            diedInNICUAfter48: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            diedInPaedAfter48: yup
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
            admissionsExtremelyPreterm: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            admissionsVeryPreterm: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            admissionsModerateToLatePreterm: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            admissionsFullTerm: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            admissionsOlderThanNeonate: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            admissionsAge4WeeksTo5: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            admissionsAge6To11: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            admissionsAge12To18: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            admissionsMale: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            admissionsFemale: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            admissionsRespiratoryArrest: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            admissionsTraumaticInjury: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            admissionsSepticShock: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            admissionsHypovolemicShock: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            admissionsSeizures: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            admissionsPoisoning: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            admissionsAlteredMentalStatus: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            admissionsGastroenteritis: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            admissionsHemorrhage: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            admissionsHypothermia: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            admissionsCardiacCongenitalAnomaly: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            admissionsOtherCongenitalAnomaly: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            admissionsMalnutrition: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            admissionsMeningitis: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            admissionsCommunityAcquiredPneumonia: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            admissionsAspirationPneumonia: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            admissionsModeratePrematurity: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            admissionsSeverePrematurity: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            admissionsOtherMedical: yup
                .string()
                .default(""),


            numberOfOutpatients: yup
                .number()
                .min(0, "Cannot be negative.")
                .default(0),
            numberOfOutpatientsExtremelyPreterm: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            numberOfOutpatientsVeryPreterm: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            numberOfOutpatientsModerateToLatePreterm: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            numberOfOutpatientsFullTerm: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            numberOfOutpatientsOlderThanNeonate: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            numberOfOutpatientsAge4WeeksTo5: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            numberOfOutpatientsAge6To11: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            numberOfOutpatientsAge12To18: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            numberOfOutpatientsRespiratoryArrest: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            numberOfOutpatientsTraumaticInjury: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            numberOfOutpatientsSepticShock: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            numberOfOutpatientsHypovolemicShock: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            numberOfOutpatientsSeizures: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            numberOfOutpatientsPoisoning: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            numberOfOutpatientsAlteredMentalStatus: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            numberOfOutpatientsGastroenteritis: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            numberOfOutpatientsHemorrhage: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            numberOfOutpatientsHypothermia: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            numberOfOutpatientsCardiacCongenitalAnomaly: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            numberOfOutpatientsOtherCongenitalAnomaly: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            numberOfOutpatientsMalnutrition: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            numberOfOutpatientsMeningitis: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            numberOfOutpatientsCommunityAcquiredPneumonia: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            numberOfOutpatientsAspirationPneumonia: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            numberOfOutpatientsModeratePrematurity: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            numberOfOutpatientsSeverePrematurity: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            numberOfOutpatientsOtherMedical: yup
                .string()
                .default(""),
            boy: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
            girl: yup
                .number()
                .min(0, "Cannot be negative.")
                .required("Required.")
                .default(0),
        });
        return {
            successful: false,
            loading: false,
            message: "",
            hospitalizedMor: false,
            dischargedAliveMor: false,
            diedBefore48hMor: false,
            diedAfter48hMor: false,
            selfDischargedMor: false,
            admissionsMor: false,
            numberOfOutpatientsMor: false,
            dataSchema,
        };
    },
    methods: {
        checkHospitalized() {
            let number: number = (document as any).getElementById("hospitalized").value;
            if (number > 0) {
                this.hospitalizedMor = true;
            } else {
                this.hospitalizedMor = false;
            }
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
        checkNumberOfOutpatients() {
            let number: number = (document as any).getElementById("numberOfOutpatients").value;
            if (number > 0) {
                this.numberOfOutpatientsMor = true;
            } else {
                this.numberOfOutpatientsMor = false;
            }
        },
        handleData(entry) {
            let token = JSON.parse(localStorage.getItem('user')!);
            if(token != null) {
                entry.department = "NICU_PAED";
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
        margin-bottom: 20px;
    }
</style>