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
  <div class="box">
    <div class="text-center">
      <h2 class="font-weight-bold display-5 text-dark text-monospace">Message Board</h2>
    </div>
    <div>
      
      <button class="btn btn-light" @click="show = !show">Add message</button>
        <Form v-if="show" @submit="handleData" :validation-schema="dataSchema">
          <div class="form-group">
            <label for="title">Title</label>
            <Field name="title" type="text" class="form-control" />
            <ErrorMessage name="title" class="error-feedback" />
          </div>
          <div class="form-group">
            <label for="messageToPost">Message</label>
            <Field name="messageToPost" type="text" class="form-control" />
            <ErrorMessage name="messageToPost" class="error-feedback" />
          </div>
          <div class="form-group">
            <button class="btn btn-outline-light btn-block" :disabled="loading">
                <span v-show="loading" class="spinner-border spinner-border-sm"></span>
                {{ $t('msppData.submit') }}
            </button>
          </div>
        </Form>
      
    </div>
    <div :key="rerender">
      <div class="btn btn-light" v-for="m in messages" :key="m" @click="showMessage(m)">
        <h1 style="text-align:left">{{ m.title }}</h1>
        <div>
          {{"Posted on " + m.dateSubmitted.substring(0, 10) + " at " + m.dateSubmitted.substring(11, 16) + "GMT by " + m.username}}
        </div>
        <div v-if="m.show">
          <div>
            {{ m.message }}
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
  },
  data() {
    type Message = {
      title: string,
      messageToPost: string,
      dateSubmitted: string,
      username: string,
      show: boolean
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
      dataSchema,
    };
  },
  mounted() {
    this.getMessages();
  },
  methods: {
    getMessages(): void {
      axios.get("/api/messages").then(response=> {
        this.messages = response.data;
        this.rerender += 1;
        console.log(response.data);
      });
    },

    showMessage(message): void {
      message.show = !message.show;
    },
    handleData(entry): void {
      let token = JSON.parse(localStorage.getItem('user')!);
      if(token != null) {
        entry.departmentname = "NICU_PAED";
        this.$axios.post("/api/messageboard/submit", entry, {
            headers: {
                'Authorization': `Bearer ${token.jwt}`
            }
        }).then(response => {
                this.successful = true;
                this.loading = false;
                this.getMessages();
            }
        )
      }
    }
  }
});
</script>


