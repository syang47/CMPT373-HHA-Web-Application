<style>
* {
  margin: 0;
  padding: 0;
}

.btn:hover {
  border-radius: 10px;
  color: #fff;
  box-shadow: 0 0 5px 0 #c6fafe, 0 0 25px 0 #c6fafe, 0 0 50px 0 #c6fafe,
    0 0 100px 0 #c6fafe;
}
</style>

<template>
  <div class="container-fluid"> 
    <h1 class="display-2 text-center text-dark">NICU/PAED</h1> 
    <h1 class="display-2 text-center text-dark">NICU/PAED</h1> 
    <h1 class="display-2 text-center text-dark">NICU/PAED</h1> 
    <h1 class="display-2 text-center text-dark">NICU/PAED</h1> 
    <h1 class="display-2 text-center text-dark">NICU/PAED</h1> 
    <h1 class="display-2 text-center text-dark">NICU/PAED</h1> 
  </div>
</template>

<script lang="ts" type="text/typescript">
import { Vue } from "vue-class-component";
import { defineComponent } from 'vue'
import { Form, Field, ErrorMessage } from "vee-validate";
import * as yup from "yup";

export default class Message_Board extends Vue {
    goToMessageBoard(): void {
        this.$router.push('/Message_Board/submit');
    };
}
</script>


