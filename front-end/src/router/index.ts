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

import Message_Board from "@/views/Message_Board/Message_Board.vue";

import newStore from "@/store";

const routes: Array<RouteRecordRaw> = [
  // Basic components
  {
    path: "/login",
    name: "Login",
    component: Login,
    meta: {
      requiresAuth: false,
    },
  },
  {
    path: "/register",
    component: Register,
    meta: {
      requiresAuth: true,
    },
  },
  {
    path: "/",
    component: Home,
    meta: {
      requiresAuth: true,
    },
  },
  //leaders board
  {
    path: "/leadersboard",
    name: "LeadersBoard",
    component: LeadersBoard,
    meta: {
      requiresAuth: true,
    },
  },

  {
    path: "/casestudy",
    component: Case_Study,
    meta: {
      requiresAuth: true,
    },
  },

  {
    path: "/announcement",
    component: Announcement,
    meta: {
      requiresAuth: true,
    },
  },

  // NICU/PAED
  {
    path: "/nicu_paed",
    name: "NICU_PAED",
    component: NICU_PAED,
    meta: {
      requiresAuth: true,
    },
  },
  { 
    path: "/nicu_paed/submit",
    name: "NICU_PAED_Data",
    component: NICU_PAED_Data,
    meta: {
      requiresAuth: true,
    },
  },

  // Maternity
  {
    path: "/maternity",
    name: "Maternity",
    component: Maternity,
    meta: {
      requiresAuth: true,
    },
  },

  {
    path: "/maternity/submit",
    name: "Maternity_Data",
    component: Maternity_Data,
    meta: {
      requiresAuth: true,
    },
  },

  // Rehab
  {
    path: "/rehab",
    name: "Rehab",
    component: Rehab,
    meta: {
      requiresAuth: true,
    },
  },
  {
    path: "/rehab/submit",
    name: "Rehab_Data",
    component: Rehab_Data,
    meta: {
      requiresAuth: true,
    },
  },


  // Community_Health
  {
    path: "/community_health",
    name: "Community_Health",
    component: Community_Health,
    meta: {
      requiresAuth: true,
    },
  },
  {
    path: "/community_health/submit",
    name: "Community_Health_Data",
    component: Community_Health_Data,
    meta: {
      requiresAuth: true,
    },
  },
  {
    path: "/datainput",
    name: "DataInput",
    component: DataInput,
    meta: {
      requiresAuth: true,
    },
  },
  {
    path: "/dataDisplay",
    name: "DataDisplay",
    component: DataDisplay,
    meta: {
      requiresAuth: true,
    },
  },

  {
    path: "/message_board",
    name: "Message_Board",
    component: Message_Board,
    meta: {
      requiresAuth: true,
    },
  },
];


const router = createRouter({
  history: createWebHistory(),
  routes,
});

// router.beforeEach((to, from, next) => {
//   if (to.matched.some((record) => record.meta.requiresAuth)) {
//     newStore.dispatch("auth/isTokenValid").then(response => {
//       const s: any = newStore.state;
//       if(!s.auth.status.loggedIn) {
//         next('/login');
//       } else {
//         next();
//       }
//     });
//   } else {
//     next();
//   }
// })


export default router;
