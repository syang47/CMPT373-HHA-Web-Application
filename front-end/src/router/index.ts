import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import Login from "@/views/Login.vue";
import Register from "@/views/Register.vue";
import Home from "@/views/Home.vue";

import NICU_PAED from "@/views/NICU_PAED/NICU_Dep.vue";
import NICU_PAED_Data from "@/views/NICU_PAED/NICUPAEDData.vue"

import Maternity from "@/views/Maternity/Maternity_Dep.vue";

import Rehab from "@/views/Rehab/Rehab_Dep.vue";

import CommunityHealth from "@/views/Com_Heal/Community_Dep.vue";





const routes: Array<RouteRecordRaw> = [
  // Basic components
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
    path: "/",
    component: Home,
  },

  // NICU/PAED
  {
    path: "/nicu_paed",
    name: "NICU_PAED",
    component: NICU_PAED,
  },
  { 
    path: "/nicu_paed/inputdata",
    name: "NICU_PAED_data",
    component: NICU_PAED_Data,
  },

  // Maternity
  {
    path: "/maternity",
    name: "Maternity",
    component: Maternity,
  },

  // Rehab
  {
    path: "/rehab",
    name: "Rehab",
    component: Rehab,
  },

  // Community_Health
  {
    path: "/communityhealth",
    name: "CommunityHealth",
    component: CommunityHealth,
  },


  // Other components

];


const router = createRouter({
  history: createWebHistory(),
  routes,
});


export default router;
