<template>

<div class="main-content">
    <div class="card shadow-none bg-none">
        <div class="card-body">
          <div class="card has-bg form-box">
            <div class="card-body">
              <Form @submit="handleData" v-slot="{ validate }" >
            <div class="signup-form">
              <h2 class="font-weight-bold display-5 text-dark">{{ $t(formTitle) }}</h2>
              <div
                v-for="field in schema.fields"
                :key="field"
              >
                <div class="mb-3">
                  <!-- HEADER -->
                  <h4 v-if="field.header" style="color:red; text-align:center">{{ $t(field.header) }}</h4>
                  <!-- TABLE -->
                  <div v-else-if="field.th">
                    <table>
                      <thead>
                        <tr>
                          <th v-for="(column, index) in field.th" :key="index"> {{ $t(column) }} </th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr v-for="(column, colIndex) in field.rows" :key="colIndex">
                          <td v-for="(data, i) in column" :key="i">
                            <div v-if="data.rowName"> {{ $t(data.rowName) }}</div>
                            <div v-else>
                              <RegularInput :field="data" />
                            </div>
                          </td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                  <!-- Meternity: PATIENTS FORM1 -->
                  <div v-else-if="field.patientBeforeM">
                    <RegularInput :field="field" v-model="s[field.name]" :modelValue="s[field.name]"/>
                    <PatientBeforeM v-model="s[field.name]" />
                  </div>
                  <!-- Meternity: PATIENTS FORM2 -->
                  <div v-else-if="field.patientAfterM">
                    <RegularInput :field="field" v-model="s[field.name]" :modelValue="s[field.name]"/>
                    <PatientAfterM v-model="s[field.name]" />
                  </div>

                  <!--Rehab:  PATIENTS FORM1 -->
                  <div v-else-if="field.specPatient">
                    <RegularInput :field="field" v-model="s[field.name]" :modelValue="s[field.name]"/>
                    <SpecialPatient v-model="s[field.name]" />
                  </div>

                  <!--Rehab: PATIENTS FORM2 -->
                  <div v-else-if="field.patientBeforeR">
                    <RegularInput :field="field" v-model="s[field.name]" :modelValue="s[field.name]"/>
                    <PatientBeforeR v-model="s[field.name]" />
                  </div>

                  <!--Rehab: PATIENTS FORM3 -->
                  <div v-else-if="field.patientAfterR">
                    <RegularInput :field="field" v-model="s[field.name]" :modelValue="s[field.name]"/>
                    <PatientAfterR v-model="s[field.name]" />
                  </div>

                  <!-- REGULAR INPUTS -->
                  <div v-else>
                    <RegularInput :field="field" v-model="s[field.name]" />
                  </div>
                  
                  <!-- ADDITIONAL REGULAR INPUTS -->
                  <template v-if="field.children && field.children.length && s[field.name] > 0">
                    <div class="signup-form"
                      v-for="cField in field.children"
                      :key="cField"
                    >
                      <h4 v-if="cField.header" style="color:green; text-align:center">{{ $t(cField.header) }}</h4>
                      <h4 v-else-if="cField.blueHeader" style="color:blue; text-align:center">{{ $t(cField.blueHeader) }}</h4>
                      <div v-else>
                        <RegularInput :field="cField" v-model="s[cField.name]" />
                      </div>
                    </div>
                  </template>

                </div>
              </div>
              <div class="mb-3">
                <button class="btn btn-secondary btn-block" :disabled="loading" @click="validate">
                  <span v-show="loading" class="spinner-border spinner-border-sm"></span>
                  {{ $t('msppData.submit') }}
                </button>
              </div>
            </div>
          </Form>
            </div>
          </div>
        </div>
    </div>
</div>
</template>

<script lang="ts" type="text/typescript">
import { Form } from 'vee-validate';
import RegularInput from './RegularInput.vue';
import PatientBeforeM from './PatientBeforeM.vue';
import PatientAfterM from './PatientAfterM.vue'
import SpecialPatient from './SpecialPatient.vue'
import PatientBeforeR from './PatientBeforeR.vue'
import PatientAfterR from './PatientAfterR.vue'
import { defineComponent } from 'vue';
export default defineComponent({
  name: 'DynamicForm',
  components: {
    Form,
    RegularInput,
    PatientBeforeM,
    PatientAfterM,
    SpecialPatient,
    PatientBeforeR,
    PatientAfterR,

  },
  data() {
    return {
      successful: false,
      loading: false,
      message: "",
      s: this.schema.fields,
      cColor: "color:green",
      field: {} as any,
    }
  },
  props: {
    schema: {
      type: Object,
      required: true,
    },
    department: {
      type: String,
      required: true,
    },
    formTitle: {
      type: String,
      required: true
    }
  },
  methods: {
    handleData(entry) {
      let token = JSON.parse(localStorage.getItem('user')!);
      if(token != null) {

        var requiredKeys:string[] = [];
        for(let i in this.schema.fields) {
          if(this.schema.fields[i].rules != undefined){
            if(this.schema.fields[i].rules.exclusiveTests.required){
              requiredKeys.push(this.schema.fields[i].name);
            }
          }
        }
        var requiredMSPPData = Object.fromEntries(Object.entries(entry).filter(([key, value]) => requiredKeys.includes(key)));
        var additionalData = Object.fromEntries(Object.entries(entry).filter(([key, value]) => !requiredKeys.includes(key)));

        requiredMSPPData.department = this.department;

        let d = [JSON.stringify(requiredMSPPData), JSON.stringify(additionalData)];
        this.$axios.post("/api/mspp/submit", d, {
          headers: {
            'Authorization': `Bearer ${token.jwt}`
          }
        }).then(response => {
          this.message = response.data;
          this.successful = true;
          this.loading = false;
          alert("entry submitted");
        }).catch((error: any) => {
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
});;
</script>

<style scoped>
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
        max-width: 400px;
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
    table, th, td {
      border:1px solid black;
    }

</style>