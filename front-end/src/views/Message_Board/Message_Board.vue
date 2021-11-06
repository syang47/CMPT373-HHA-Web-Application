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

.rectangle-leader-board {
      width: 1210px;
      height: 110px;
      padding: 2px 2px 2px 2px;
      border-radius: 10px;
      border: 1px solid #797979;
      background-color: #7a4183;
      box-sizing: border-box;
      box-shadow: 5px 5px 5px 0px rgba(0, 0, 0, 0.35);
      display: flex;
      align-items: center;
      justify-content: center;
    }


</style>

<template>
  <div class="container-fluid"> 
    <button class="button">  
    <h1 class="rectangle-leader-board">Add Message</h1> 
    </button>
  </div>
</template>

<script lang="ts" type="text/typescript">
import { Vue } from "vue-class-component";
import { defineComponent } from 'vue'
import { Form, Field, ErrorMessage } from "vee-validate";
import * as yup from "yup";

export default class Message_Board extends Vue {
    goToDataInput(): void {
        this.$router.push('/message_board/submit');
    };
}

</script>


