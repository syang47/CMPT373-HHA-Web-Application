import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import Login from "@/views/Login.vue";
import Register from "@/views/Register.vue";
import Department from "@/components/Department.vue";
import Home from "@/views/Home.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "home",
    component: Home,
  },
  {
    path: "/login",
    name: "Login",
    component: Login,
  },
  {
    path: "/register",
    component: Register,
  },
  {
    path: "/home",
    component: Home,
  },
  {
    path: "/department",
    name: "Department",
    component: Department,
  },
];

const router = createRouter({
  history: createWebHistory("/"),
  routes,
});

export default router;
