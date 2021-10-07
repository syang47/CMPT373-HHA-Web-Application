import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import Home from "../views/Home.vue";
import Login from '../views/Login.vue'
import DataNICUPAED from "../views/InputData.vue"


const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "Login",
    component: Login,
  },
  {
    path: "/home",
    name: "Home",
    component: Home,
  },
  {
    path:"/NICUPAED/data",
    name: "Input data - NICU/PAED",
    component: DataNICUPAED,
  }

];


const router = createRouter({
  history: createWebHistory(),
  routes,
});

/*
router.beforeEach((to, from, next) => {
  const publicPages = ['/login', '/register', '/home'];
  const authRequired = !publicPages.includes(to.path);
  const loggedIn = localStorage.getItem('user');

  // trying to access a restricted page + not logged in
  // redirect to login page
  if (authRequired && !loggedIn) {
    next('/login');
  } else {
    next();
  }
});*/

export default router;
