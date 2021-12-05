<style scoped>

.box {
  width: 100%;
  height: 100%;
  background: #00000060;
  box-sizing: border-box;
  display: block;
  padding: 40px;
}

</style>

<template>

  <div class="main-content">
    <div class="card shadow-none">
      <div class="card-body">
          <div class="card has-bg">
            <div class="card-body">
            <div class="text-center">
              <h2 class="display-5">{{ $t('messageBoard.messageBoard') }}</h2>
            </div>
            <div v-if="hasPermissions">
              
              <div class="mb-3">
                <button class="btn btn-primary" @click="show = !show">{{ $t('messageBoard.addMessage') }}</button>
              </div>
                <Form v-if="show" @submit="handleData" :validation-schema="dataSchema">
                  <div class="mb-3">
                    <label class="mb-2" for="title">{{ $t('messageBoard.title') }}</label>
                    <Field name="title" type="text" class="form-control" />
                    <ErrorMessage name="title" class="error-feedback" />
                  </div>
                  <div class="mb-3">
                    <label class="mb-2" for="messageToPost">{{ $t('messageBoard.message') }}</label>
                    <Field name="messageToPost" type="text" class="form-control" />
                    <ErrorMessage name="messageToPost" class="error-feedback" />
                  </div>
                  <div class="mb-3">
                    <button class="btn btn-secondary btn-block" :disabled="loading">
                        <span v-show="loading" class="spinner-border spinner-border-sm"></span>
                        {{ $t('msppData.submit') }}
                    </button>
                  </div>
                </Form>
              
            </div>
            <div :key="rerender">
              <div class="card">
                <div class="card-body" v-for="m in messages" :key="m" @click="showMessage(m)">
                  <h1 class="mb-2" style="text-align:left">
                    <p class="text-dark">{{ m.title }} <span class="font-weight-normal">({{"Posted on " + m.dateSubmitted.substring(0, 10) + " at " + m.dateSubmitted.substring(11, 16) + "GMT by " + m.username}})</span></p>
                  </h1>
                  <div v-if="m.show">
                    <div>
                      {{ m.message }}
                    </div>
                    <td v-if="hasPermissions">
                      <button @click="deleteMessage(m)" class="btn btn-danger btn-sm">DELETE</button>
                    </td>
                  </div>
                
              </div>
              </div>
            </div>
          </div>
          </div>
      </div>
    </div>
  </div>

</template>

<script lang="ts" type="text/typescript">

import { defineComponent } from 'vue'
import axios from 'axios';
import { Form, Field, ErrorMessage } from "vee-validate";
import * as yup from "yup";
export default defineComponent({
  name: "Message_Board",
  components: {
    Form,
    Field,
    ErrorMessage
  },
  data() {
    type Message = {
      title: string,
      messageToPost: string,
      dateSubmitted: string,
      username: string,
      show: boolean,
    };
    const dataSchema = yup.object().shape({
      title: yup
        .string(),
      messageToPost: yup
        .string()
    });
    return {
      messages: [{title: "", message: "", dateSubmitted: "", username: "", show: false}],
      rerender: 0,
      show: false,
      successful: false,
      loading: false,
      errorMessage: "",
      dataSchema,
      hasPermissions: false
    };
  },
  mounted() {
    this.getMessages();
    let token = JSON.parse(localStorage.getItem('user')!);
    if(token.roles[0].authority == "ROLE_ADMIN" || token.roles[0].authority == "HOSPITALADMN"){
      this.hasPermissions = true;
    }
  },
  methods: {
    getMessages(): void {
      let token = JSON.parse(localStorage.getItem('user')!);
      axios.get("/api/messages", {
          headers: {
              'Authorization': `Bearer ${token.jwt}`
          }
      }).then(response=> {
        this.messages = response.data;
        this.rerender += 1;
      });
    },

    showMessage(message): void {
      message.show = !message.show;
    },
    handleData(entry): void {
      let token = JSON.parse(localStorage.getItem('user')!);
      entry.departmentname = token.department;
      this.$axios.post("/api/messageboard/submit", entry, {
          headers: {
              'Authorization': `Bearer ${token.jwt}`
          }
      }).then(response => {
        this.successful = true;
        this.loading = false;
        this.getMessages();
      }).catch((error: any) => {
            this.errorMessage =
                (error.response &&
                error.response.data &&
                error.response.data.message) ||
                error.message;
            this.successful = false;
            this.loading = false;
            alert("entry could not be submitted / l'entrée n'a pas pu être soumise");
      });
    },

    deleteMessage(message){
      let token = JSON.parse(localStorage.getItem('user')!);
      this.$axios.delete("/api/messages/delete", {
        headers: {
            'Authorization': `Bearer ${token.jwt}`,
        },
        params: {
            id: message.id
        }
      }).then(response => {
        this.successful = true;
        this.loading = false;
        this.getMessages();
      }).catch((error: any) => {
        this.errorMessage =
            (error.response &&
            error.response.data &&
            error.response.data.message) ||
            error.message;
        this.successful = false;
        this.loading = false;
        alert("message could not be deleted / le message n'a pas pu être supprimé");
      });
    }

  }
});

</script>


