import { createApp } from "vue";
import i18n from './i18n'
import App from "./App.vue";
import router from "./router";
import store from "./store";
import axios, { AxiosInstance } from "axios";
import Equal from "equal-vue";
import 'equal-vue/dist/style.css';
import BootstrapVue3 from 'bootstrap-vue-3';
import VueSideBarMenu from "vue-sidebar-menu";
import 'vue-sidebar-menu/dist/vue-sidebar-menu.css';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue-3/dist/bootstrap-vue-3.css';
import { VuesticPlugin } from 'vuestic-ui'; // <-
import 'vuestic-ui/dist/vuestic-ui.css'; // <-
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
app.use(BootstrapVue3);
app.use(VueSideBarMenu);
app.use(VuesticPlugin);
app.config.globalProperties.$axios = axios;
axios.defaults.baseURL = "http://localhost:8080";
app.use(Equal);
router.isReady().then(()=>app.mount("#app")).catch(onerror);

i18n.global.locale = 'fr';