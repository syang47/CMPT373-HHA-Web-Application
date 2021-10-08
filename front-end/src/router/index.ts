import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import Login from "@/views/Login.vue";
import Register from "@/views/Register.vue";
import Department from "@/views/Department.vue";
import Home from "@/views/Home.vue";
import DataInput from "@/views/DataInput.vue";
import CaseStudy from "@/views/CaseStudy.vue";
import NICU_PAED from "@/views/NICU_Dep.vue";
import Rehab from "@/views/Rehab_Dep.vue";
import CommunityHealth from "@/views/Community_Dep.vue";
import Maternity from "@/views/Maternity_Dep.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "Login",
    component: Login,
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
  {
    path: "/nicu_paed",
    name: "NICU_PAED",
    component: NICU_PAED,
  },
  {
    path: "/maternity",
    name: "Maternity",
    component: Maternity,
  },
  {
    path: "/rehab",
    name: "Rehab",
    component: Rehab,
  },
  {
    path: "/communityhealth",
    name: "CommunityHealth",
    component: CommunityHealth,
  },
  { path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue"),
  },
  {
    path: "/datainput",
    component: DataInput,
  },
  {
    path: "/casestudy",
    component: CaseStudy,
  }

];


const router = createRouter({
  history: createWebHistory(),
  routes,
});


export default router;
