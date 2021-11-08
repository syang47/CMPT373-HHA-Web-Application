import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import Login from "@/views/Login.vue";
import Register from "@/views/Register.vue";
import Home from "@/views/Home.vue";
import Case_Study from "@/views/Case_Study.vue";

import LeadersBoard from "@/views/LeadersBoard.vue"
import NICU_PAED from "@/views/NICU_PAED/NICU_Dep.vue";
import NICU_PAED_Data from "@/views/NICU_PAED/NICU_PAED_Data.vue"

import Maternity from "@/views/Maternity/Maternity_Dep.vue";
import Maternity_Data from "@/views/Maternity/Maternity_Data.vue";

import Rehab from "@/views/Rehab/Rehab_Dep.vue";
import Rehab_Data from "@/views/Rehab/Rehab_Data.vue";

import Community_Health from "@/views/Community_Health/Community_Dep.vue";
import Community_Health_Data from "@/views/Community_Health/Community_Health_Data.vue";

import DataInput from "@/views/DataInput.vue";

import Announcement from "@/views/Announcement.vue";

import DataDisplay from "@/views/DataDisplay.vue";


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
    beforeEnter: (to, from, next) => {
      const token = JSON.parse(localStorage.getItem('user')!);
      if (token.roles[0].authority == 'ROLE_USER') {
        next(false);
      } else {
        next();
      }
    },
  },
  {
    path: "/",
    component: Home,
  },
  //leaders board
  {
    path: "/leadersboard",
    name: "LeadersBoard",
    component: LeadersBoard,
  },

  {
    path: "/casestudy",
    component: Case_Study,
  },

  {
    path: "/announcement",
    component: Announcement,
  },

  // NICU/PAED
  {
    path: "/nicu_paed",
    name: "NICU_PAED",
    component: NICU_PAED,
  },
  { 
    path: "/nicu_paed/submit",
    name: "NICU_PAED_Data",
    component: NICU_PAED_Data,
  },

  // Maternity
  {
    path: "/maternity",
    name: "Maternity",
    component: Maternity,
  },

  {
    path: "/maternity/submit",
    name: "Maternity_Data",
    component: Maternity_Data,
  },

  // Rehab
  {
    path: "/rehab",
    name: "Rehab",
    component: Rehab,
  },
  {
    path: "/rehab/submit",
    name: "Rehab_Data",
    component: Rehab_Data,
  },


  // Community_Health
  {
    path: "/community_health",
    name: "Community_Health",
    component: Community_Health,
  },
  {
    path: "/community_health/submit",
    name: "Community_Health_Data",
    component: Community_Health_Data,
  },
  {
    path: "/datainput",
    name: "DataInput",
    component: DataInput,
  },
  {
    path: "/dataDisplay",
    name: "DataDisplay",
    component: DataDisplay,
  },

  // Other components

];


const router = createRouter({
  history: createWebHistory(),
  routes,
});


export default router;
