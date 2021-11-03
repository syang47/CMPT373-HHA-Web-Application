import { createApp } from "vue";
// import Vue from 'vue'
import VueI18n from "vue-i18n";
import Vue from 'vue/dist/vue';
// import { messages, defaultLocale } from "@/i18n";
import i18n from './i18n'
import App from "./App.vue";
import router from "./router";
import store from "./store";
import axios, { AxiosInstance } from "axios";
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import Equal from "equal-vue";
import 'equal-vue/dist/style.css';

// Vue.use(VueI18n)

// const i18n = new VueI18n({
//   messages,
//   locale: defaultLocale,
//   fallbackLocale: defaultLocale
// });

// new Vue({
//   i18n,
//   render: h => h(App)
// }).$mount("#app");

declare module "@vue/runtime-core" {
  interface ComponentCustomProperties {
    $axios: AxiosInstance;
  }
}

// const i18n = new VueI18n({
//   messages,
//   locale: defaultLocale,
//   fallbackLocale: defaultLocale
// });

const app = createApp(App);
app.config.globalProperties.$store = store;
app.provide("$store", store);

app.use(store);
app.use(router);
app.use(i18n);



// new Vue({
//   i18n,
//   render: h => h(App)
// }).$mount("#app");

app.config.globalProperties.$axios = axios;
axios.defaults.baseURL = "http://localhost:8080";
app.use(Equal);
router.isReady().then(()=>app.mount("#app")).catch(onerror);

