import { createApp } from "vue";
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
const app = createApp(App).use(store);
app.use(store);
app.use(router);
app.config.globalProperties.$axios = axios;
axios.defaults.baseURL = "http://localhost:8088/api";
app.use(Equal);
app.mount("#app");

