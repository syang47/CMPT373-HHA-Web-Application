import { createApp } from "vue";
import i18n from './i18n'
import App from "./App.vue";
import router from "./router";
import store from "./store";
import axios, { AxiosInstance } from "axios";
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import Equal from "equal-vue";
import 'equal-vue/dist/style.css';

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
app.use(i18n);

app.config.globalProperties.$axios = axios;
axios.defaults.baseURL = "http://localhost:8080";
app.use(Equal);
router.isReady().then(()=>app.mount("#app")).catch(onerror);

i18n.global.locale = 'fr';