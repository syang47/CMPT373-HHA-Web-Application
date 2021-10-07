import Vue, { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import axios, { AxiosInstance } from "axios";
import Equal from "equal-vue";

declare module "@vue/runtime-core" {
  interface ComponentCustomProperties {
    $axios: AxiosInstance;
  }
}

const app = createApp(App);
app.config.globalProperties.$store = store;
app.provide("$store", store);

app.use(store);
app.use(router);
app.config.globalProperties.$axios = axios;
axios.defaults.baseURL = "http://localhost:8080";
app.use(Equal);
app.mount("#app");

