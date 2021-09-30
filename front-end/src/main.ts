import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import axios, { AxiosInstance } from "axios";

declare module "@vue/runtime-core" {
    interface ComponentCustomProperties {
        $axios: AxiosInstance;
        }
    }
const app = createApp(App);
app.use(store);
app.use(router);
app.config.globalProperties.$axios = axios;
axios.defaults.baseURL = 'http://localhost:8088/api'
app.mount("#app");
