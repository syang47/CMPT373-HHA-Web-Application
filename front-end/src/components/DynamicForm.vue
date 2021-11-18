<template>
  <Form class="background" @submit="handleData" v-slot="{ validate }" >
    <div class="signup-form"
      v-for="field in schema.fields"
      :key="field"
    >
      <div class="form-group">
        <!-- HEADER -->
        <h4 v-if="field.header" style="color:green">{{ $t('msppData.'+ field.header) }}</h4>
        <!-- REGULAR INPUTS -->
        <div v-else>
          <RegularInput :field="field" v-model="s[field.name]"/>
        </div>
        <template v-if="field.children && field.children.length && s[field.name] > 0">
          <div class="signup-form"
            v-for="cField in field.children"
            :key="cField"
          >
            <h4 v-if="cField.header" style="color:green">{{ $t('msppData.'+ cField.header) }}</h4>
            <div v-else>
              <RegularInput :c="cColor" :field="cField" v-model="s[cField.name]" />
            </div>
          </div>
        </template>
      </div>
    </div>
    <div class="form-group">
      <button class="btn btn-outline-light btn-block" :disabled="loading" @click="validate">
        <span v-show="loading" class="spinner-border spinner-border-sm"></span>
        {{ $t('msppData.submit') }}
      </button>
    </div>
  </Form>
</template>

<script lang="ts" type="text/typescript">
import { Form, Field, ErrorMessage } from 'vee-validate';
import RegularInput from './RegularInput.vue';
import { defineComponent } from 'vue';
export default defineComponent({
  name: 'DynamicForm',
  components: {
    Form,
    RegularInput
  },
  data() {
    return {
      successful: false,
      loading: false,
      message: "",
      s: this.schema,
      cColor: "color:green"
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
        this.$axios.post("/api/datainput", d, {
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