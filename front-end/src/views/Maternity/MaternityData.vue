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
                <div class="form-group">
                    <label for="dischargedAlive">{{ $t('msppData.dischargedAlive') }}</label>
                    <Field name="dischargedAlive" type="text" class="form-control" value=0 />
                    <ErrorMessage name="dischargedAlive" class="error-feedback" />
                </div>
                <div class="form-group">
                    <label for="diedBefore48h">{{ $t('msppData.diedBefore48h') }}</label>
                    <Field name="diedBefore48h" type="text" class="form-control" value=0 />
                    <ErrorMessage name="diedBefore48h" class="error-feedback" />
                </div>
                <div class="form-group">
                    <label for="diedAfter48h">{{ $t('msppData.diedAfter48h') }}</label>
                    <Field name="diedAfter48h" type="text" class="form-control" value=0 />
                    <ErrorMessage name="diedAfter48h" class="error-feedback" />
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
                <div class="form-group">
                    <label for="selfDischarged">{{ $t('msppData.selfDischarged') }}</label>
                    <Field name="selfDischarged" type="text" class="form-control" value=0 />
                    <ErrorMessage name="selfDischarged" class="error-feedback" />
                </div>
                <div class="form-group">
                    <label for="stayedInTheWard">{{ $t('msppData.stayedInTheWard') }}</label>
                    <Field name="stayedInTheWard" type="text" class="form-control" value=0 />
                    <ErrorMessage name="stayedInTheWard" class="error-feedback" />
                </div>
                <div class="form-group">
                    <label for="admissions">{{ $t('msppData.admissions') }}</label>
                    <Field name="admissions" type="text" class="form-control" value=0 />
                    <ErrorMessage name="admissions" class="error-feedback" />
                </div>

                <h4 style="color:red; text-align:center">{{ $t('msppData.births') }}</h4>
                <table>
                    <tr>
                        <th>{{ $t('msppData.births') }}</th>
                        <th>{{ $t('msppData.normal') }}</th>
                        <th>{{ $t('msppData.cesarean') }}</th>
                        <th>{{ $t('msppData.instruments') }}</th>
                    </tr>
                    <tr>
                        <td>{{ $t('msppData.weight1_5') }}</td>
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
                        <td>{{ $t('msppData.weight1_5To2_5') }}</td>
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
                        <td>{{ $t('msppData.weight2_5Up') }}</td>
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
                        <td>{{ $t('msppData.notWeighted') }}</td>
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
                        <td>{{ $t('msppData.immediatelyBreastfed') }}</td>
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
                        <td>{{ $t('msppData.skinToSkinTherapy') }}</td>
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
                <h4 style="color:red; text-align:center">{{ $t('msppData.postNatal') }}</h4>

                <div class="form-group">
                <label for="Vitamin_A">{{ $t('msppData.bFWomenVitA') }}</label>
                <Field name="Vitamin_A" type="text" class="form-control" value=0 />
                <ErrorMessage name="Vitamin_A" class="error-feedback" />
                </div>
                <div class="form-group">
                <label for="MUAC_210mm">{{ $t('msppData.bFWomenMUAC') }}</label>
                <Field name="MUAC_210mm" type="text" class="form-control" value=0 />
                <ErrorMessage name="MUAC_210mm" class="error-feedback" />
                </div>
                <div class="form-group">
                <label for="Malnutrition">{{ $t('msppData.bFWomenMalnutrition') }}</label>
                <Field name="Malnutrition" type="text" class="form-control" value=0 />
                <ErrorMessage name="Malnutrition" class="error-feedback" />
                </div>
                <div class="form-group">
                <label for="domestic_visits">{{ $t('msppData.domesticVisits') }}</label>
                <Field name="domestic_visits" type="text" class="form-control" value=0 />
                <ErrorMessage name="domestic_visits" class="error-feedback" />
                </div>
                <table>
                    <tr>
                        <th></th>
                        <th>{{ $t('msppData.hours0_6') }}</th>
                        <th>{{ $t('msppData.hoursDays7_6') }}</th>
                        <th>7-42 {{ $t('msppData.days7_42') }}</th>
                    </tr>
                    <tr>
                        <td>
                        {{ $t('msppData.postNatalConsultations') }}
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
                <h4 style="color:red; text-align:center">{{ $t('msppData.complications') }}</h4>
                <div class="form-group">
                <label for="complications_recorded">{{ $t('msppData.compRec') }}</label>
                <Field name="complications_recorded" type="text" class="form-control" value=0 />
                <ErrorMessage name="complications_recorded" class="error-feedback" />
                </div>
                <div class="form-group">
                <label for="complications_referred">{{ $t('msppData.compRef') }}</label>
                <Field name="complications_referred" type="text" class="form-control" value=0 />
                <ErrorMessage name="complications_referred" class="error-feedback" />
                </div>
                <h4 style="color:red; text-align:center">{{ $t('msppData.numberOfStillborns') }}</h4>
                <div class="form-group">
                <label for="stillborns_maceres">{{ $t('msppData.macerated') }}</label>
                <Field name="stillborns_maceres" type="text" class="form-control" value=0 />
                <ErrorMessage name="stillborns_maceres" class="error-feedback" />
                </div>
                <div class="form-group">
                <label for="stillborns_non_maceres">{{ $t('msppData.notMacerated') }}</label>
                <Field name="stillborns_non_maceres" type="text" class="form-control" value=0 />
                <ErrorMessage name="stillborns_non_maceres" class="error-feedback" />
                </div>
                <h4 style="color:red; text-align:center">{{ $t('msppData.maternalDeathInTheHospital') }}</h4>
                <div class="form-group">
                <label for="in_hospital">{{ $t('msppData.inHospital') }}</label>
                <Field name="in_hospital" type="text" class="form-control" value=0 />
                <ErrorMessage name="in_hospital" class="error-feedback" />
                </div>
                <div class="form-group">
                <label for="in_community">{{ $t('msppData.inTheCommunity') }}</label>
                <Field name="in_community" type="text" class="form-control" value=0 />
                <ErrorMessage name="in_community" class="error-feedback" />
                </div>
                <h4 style="color:red; text-align:center">{{ $t('msppData.supportForWifeAndMother') }}</h4>
                <table>
                    <tr>
                        <th>{{ $t('msppData.periodOfPregnancy') }}</th>
                        <th>{{ $t('msppData.visit1') }}</th>
                        <th>{{ $t('msppData.visit2') }}</th>
                        <th>{{ $t('msppData.visit3') }}</th>
                        <th>{{ $t('msppData.visit4') }}</th>
                        <th>{{ $t('msppData.visit5Up') }}</th>
                        <th>{{ $t('msppData.total') }}</th>
                    </tr>
                    <tr>
                        <td>{{ $t('msppData.months0_3') }}</td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="first_quarter_first_visit" type="text" class="form-control" value=0 />
                            <ErrorMessage name="first_quarter_first_visit" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="first_quarter_second_visit" type="text" class="form-control" value=0 />
                            <ErrorMessage name="first_quarter_second_visit" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="first_quarter_third_visit" type="text" class="form-control" value=0 />
                            <ErrorMessage name="first_quarter_third_visit" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="first_quarter_fourth_visit" type="text" class="form-control" value=0 />
                            <ErrorMessage name="first_quarter_fourth_visit" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="first_quarter_fifth_visit" type="text" class="form-control" value=0 />
                            <ErrorMessage name="first_quarter_fifth_visit" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="first_quarter_total" type="text" class="form-control" value=0 />
                            <ErrorMessage name="first_quarter_total" class="error-feedback" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            {{ $t('msppData.months4_6') }}
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="second_quarter_first_visit" type="text" class="form-control" value=0 />
                            <ErrorMessage name="second_quarter_first_visit" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="second_quarter_second_visit" type="text" class="form-control" value=0 />
                            <ErrorMessage name="second_quarter_second_visit" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="second_quarter_third_visit" type="text" class="form-control" value=0 />
                            <ErrorMessage name="second_quarter_third_visit" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="second_quarter_fourth_visit" type="text" class="form-control" value=0 />
                            <ErrorMessage name="second_quarter_fourth_visit" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="second_quarter_fifth_visit" type="text" class="form-control" value=0 />
                            <ErrorMessage name="second_quarter_fifth_visit" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="second_quarter_total" type="text" class="form-control" value=0 />
                            <ErrorMessage name="second_quarter_total" class="error-feedback" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            {{ $t('msppData.months7_9') }}
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="third_quarter_first_visit" type="text" class="form-control" value=0 />
                            <ErrorMessage name="third_quarter_first_visit" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="third_quarter_second_visit" type="text" class="form-control" value=0 />
                            <ErrorMessage name="third_quarter_second_visit" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="third_quarter_third_visit" type="text" class="form-control" value=0 />
                            <ErrorMessage name="third_quarter_third_visit" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="third_quarter_fourth_visit" type="text" class="form-control" value=0 />
                            <ErrorMessage name="third_quarter_fourth_visit" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="third_quarter_fifth_visit" type="text" class="form-control" value=0 />
                            <ErrorMessage name="third_quarter_fifth_visit" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="third_quarter_total" type="text" class="form-control" value=0 />
                            <ErrorMessage name="third_quarter_total" class="error-feedback" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            {{ $t('msppData.totalVisits') }}
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="total_first_visit" type="text" class="form-control" value=0 />
                            <ErrorMessage name="total_first_visit" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="total_second_visit" type="text" class="form-control" value=0 />
                            <ErrorMessage name="total_second_visit" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="total_third_visit" type="text" class="form-control" value=0 />
                            <ErrorMessage name="total_third_visit" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="total_fourth_visit" type="text" class="form-control" value=0 />
                            <ErrorMessage name="total_fourth_visit" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="total_fifth_visit" type="text" class="form-control" value=0 />
                            <ErrorMessage name="total_fifth_visit" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="total_total" type="text" class="form-control" value=0 />
                            <ErrorMessage name="total_total" class="error-feedback" />
                            </div>
                        </td>
                    </tr>
                </table>
                <h4 style="color:red; text-align:center">{{ $t('msppData.supportForWomenHospital') }}</h4>
                <div class="form-group">
                <label for="pregnancies_at_risk">{{ $t('msppData.numberOfPregnanciesAtRisk') }}</label>
                <Field name="pregnancies_at_risk" type="text" class="form-control" value=0 />
                <ErrorMessage name="pregnancies_at_risk" class="error-feedback" />
                </div>
                <div class="form-group">
                <label for="anemia_pregnant">{{ $t('msppData.caseAnemia') }}</label>
                <Field name="anemia_pregnant" type="text" class="form-control" value=0 />
                <ErrorMessage name="anemia_pregnant" class="error-feedback" />
                </div>
                <div class="form-group">
                <label for="pregnant_iron_folates">{{ $t('msppData.pWIronFolate') }}</label>
                <Field name="pregnant_iron_folates" type="text" class="form-control" value=0 />
                <ErrorMessage name="pregnant_iron_folates" class="error-feedback" />
                </div>
                <div class="form-group">
                <label for="pregnant_iron_deficiency_anemia">{{ $t('msppData.pWIronDef') }}</label>
                <Field name="pregnant_iron_deficiency_anemia" type="text" class="form-control" value=0 />
                <ErrorMessage name="pregnant_iron_deficiency_anemia" class="error-feedback" />
                </div>
                <div class="form-group">
                <label for="pregnant_birth_plan">{{ $t('msppData.pWBirthPlan') }}</label>
                <Field name="pregnant_birth_plan" type="text" class="form-control" value=0 />
                <ErrorMessage name="pregnant_birth_plan" class="error-feedback" />
                </div>
                <div class="form-group">
                <label for="pregnant_malaria_chloroquine">{{ $t('msppData.pWMalaria') }}</label>
                <Field name="pregnant_malaria_chloroquine" type="text" class="form-control" value=0 />
                <ErrorMessage name="pregnant_malaria_chloroquine" class="error-feedback" />
                </div>
                <div class="form-group">
                <label for="pregnant_mosquito_net">{{ $t('msppData.pWMosquito') }}</label>
                <Field name="pregnant_mosquito_net" type="text" class="form-control" value=0 />
                <ErrorMessage name="pregnant_mosquito_net" class="error-feedback" />
                </div>
                <div class="form-group">
                <label for="pregnant_MUAC">{{ $t('msppData.pWMUAC') }}</label>
                <Field name="pregnant_MUAC" type="text" class="form-control" value=0 />
                <ErrorMessage name="pregnant_MUAC" class="error-feedback" />
                </div>

                <h4 style="color:red; text-align:center">{{ $t('msppData.otherServices') }}</h4>
                <div class="form-group">
                <label for="women_iron_folate">{{ $t('msppData.wIronFolate') }}</label>
                <Field name="women_iron_folate" type="text" class="form-control" value=0 />
                <ErrorMessage name="women_iron_folate" class="error-feedback" />
                </div>
                <div class="form-group">
                <label for="women_acetic_inspection">{{ $t('msppData.wAceticAcid') }}</label>
                <Field name="women_acetic_inspection" type="text" class="form-control" value=0 />
                <ErrorMessage name="women_acetic_inspection" class="error-feedback" />
                </div>
                <div class="form-group">
                <label for="women_smear_test">{{ $t('msppData.wSmearTest') }}</label>
                <Field name="women_smear_test" type="text" class="form-control" value=0 />
                <ErrorMessage name="women_smear_test" class="error-feedback" />
                </div>
                <div class="form-group">
                <label for="women_smear_take_care">{{ $t('msppData.wSmearTakenCare') }}</label>
                <Field name="women_smear_take_care" type="text" class="form-control" value=0 />
                <ErrorMessage name="women_smear_take_care" class="error-feedback" />
                </div>
                <div class="form-group">
                <label for="women_postabortion">{{ $t('msppData.wPostabortion') }}</label>
                <Field name="women_postabortion" type="text" class="form-control" value=0 />
                <ErrorMessage name="women_postabortion" class="error-feedback" />
                </div>
                <h4 style="color:red; text-align:center">{{ $t('msppData.deliveries') }}</h4>
                <table>
                    <tr>
                        <th>{{ $t('msppData.ageOfMothers') }}</th>
                        <th>{{ $t('msppData.normal') }}</th>
                        <th>{{ $t('msppData.cesarean') }}</th>
                        <th>{{ $t('msppData.instruments') }}</th>
                    </tr>
                    <tr>
                        <td>
                            {{ $t('msppData.years15') }}
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="mother_age_less_than_fifteen_normal" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mother_age_less_than_fifteen_normal" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="mother_age_less_than_fifteen_cesarienne" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mother_age_less_than_fifteen_cesarienne" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="mother_age_less_than_fifteen_instrumentalse" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mother_age_less_than_fifteen_instrumentalse" class="error-feedback" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            {{ $t('msppData.years15_19') }}
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="mother_age_fifteen_to_nineteen_normal" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mother_age_fifteen_to_nineteen_normal" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="mother_age_fifteen_to_nineteen_cesarienne" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mother_age_fifteen_to_nineteen_cesarienne" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="mother_age_fifteen_to_nineteen_instrumentalse" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mother_age_fifteen_to_nineteen_instrumentalse" class="error-feedback" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            {{ $t('msppData.years20_24') }}
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="mother_age_twenty_to_twenty_four_normal" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mother_age_twenty_to_twenty_four_normal" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="mother_age_twenty_to_twenty_four_cesarienne" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mother_age_twenty_to_twenty_four_cesarienne" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="mother_age_twenty_to_twenty_four_instrumentalse" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mother_age_twenty_to_twenty_four_instrumentalse" class="error-feedback" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            {{ $t('msppData.years25_29') }}
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="mother_age_twenty_five_to_twenty_nine_normal" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mother_age_twenty_five_to_twenty_nine_normal" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="mother_age_twenty_five_to_twenty_nine_cesarienne" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mother_age_twenty_five_to_twenty_nine_cesarienne" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="mother_age_twenty_five_to_twenty_nine_instrumentalse" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mother_age_twenty_five_to_twenty_nine_instrumentalse" class="error-feedback" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            {{ $t('msppData.years30Up') }}
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="mother_age_thirty_plus_normal" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mother_age_thirty_plus_normal" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="mother_age_thirty_plus_cesarienne" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mother_age_thirty_plus_cesarienne" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="mother_age_thirty_plus_instrumentalse" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mother_age_thirty_plus_instrumentalse" class="error-feedback" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            {{ $t('msppData.unknown') }}
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="mother_age_unknown_normal" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mother_age_unknown_normal" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="mother_age_unknown_cesarienne" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mother_age_unknown_cesarienne" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="mother_age_unknown_instrumentalse" type="text" class="form-control" value=0 />
                            <ErrorMessage name="mother_age_unknown_instrumentalse" class="error-feedback" />
                            </div>
                        </td>
                    </tr>
                </table>
                <br>
                <table>
                    <tr>
                        <th>{{ $t('msppData.labourManagement') }}</th>
                        <th>{{ $t('msppData.normal') }}</th>
                        <th>{{ $t('msppData.cesarean') }}</th>
                        <th>{{ $t('msppData.instruments') }}</th>
                    </tr>
                    <tr>
                        <td>
                        {{ $t('msppData.useOfPartograph') }}
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="partograph_normal" type="text" class="form-control" value=0 />
                            <ErrorMessage name="partograph_normal" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="partograph_cesarienne" type="text" class="form-control" value=0 />
                            <ErrorMessage name="partograph_cesarienne" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="partograph_instrumentalse" type="text" class="form-control" value=0 />
                            <ErrorMessage name="partograph_instrumentalse" class="error-feedback" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>{{ $t('msppData.managementLabour3rdYear') }}</td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="labor_normal" type="text" class="form-control" value=0 />
                            <ErrorMessage name="labor_normal" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="labor_cesarienne" type="text" class="form-control" value=0 />
                            <ErrorMessage name="labor_cesarienne" class="error-feedback" />
                            </div>
                        </td>
                        <td>
                            <div class="form-group" style="width=25%">
                            <Field name="labor_instrumentalse" type="text" class="form-control" value=0 />
                            <ErrorMessage name="labor_instrumentalse" class="error-feedback" />
                            </div>
                        </td>
                    </tr>
                </table>
                <div class="form-group">
                    <button class="btn btn-outline-light btn-block" :disabled="loading">
                        <span v-show="loading" class="spinner-border spinner-border-sm"></span>
                        {{ $t('msppData.submit') }}
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