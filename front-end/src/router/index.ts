import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import { Locales } from "@/i18n/locales";
import Login from "@/views/Login.vue";
import Register from "@/views/Register.vue";
import Home from "@/views/Home.vue";

import NICU_PAED from "@/views/NICU_PAED/NICU_Dep.vue";
import MSPPData from "@/views/MSPPData.vue"

import Maternity from "@/views/Maternity/Maternity_Dep.vue";
import Maternity_Data from "@/views/Maternity/MaternityData.vue";

import Rehab from "@/views/Rehab/Rehab_Dep.vue";

import CommunityHealth from "@/views/Com_Heal/Community_Dep.vue";

import en from "@/i18n/en.json";
import fr from "@/i18n/fr.json";

export const messages = {
  [Locales.EN]: en,
  [Locales.FR]: fr
};

export const defaultLocale = Locales.EN;


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
    path: "/inputdata",
    name: "inputdata",
    component: MSPPData,
  },

  // Maternity
  {
    path: "/maternity",
    name: "Maternity",
    component: Maternity,
  },

  {
    path: "/maternity/inputdata",
    name: "Maternity_Data",
    component: Maternity_Data,
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
