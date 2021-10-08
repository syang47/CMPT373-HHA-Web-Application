import Vue, { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import axios, { AxiosInstance } from "axios";
import Equal from "equal-vue";
import 'equal-vue/dist/style.css';
import "bootstrap/dist/css/bootstrap.css";
import 'bootstrap-vue/dist/bootstrap-vue.css';

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
router.isReady().then(()=>app.mount("#app")).catch(onerror);

