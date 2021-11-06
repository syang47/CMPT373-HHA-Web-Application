<template>
   <div class="container-fluid">
    
    <nav class="navbar navbar-expand-md navbar-light bg-light">
      <router-link to="/" class="navbar-brand active">
        <img src="@/assets/logo.png" width="140" alt=""/>
      </router-link>
      <button class="navbar-toggler p-0 border-0" type="button" data-toggle="offcanvas">
        <span class="navbar-toggler-icon" />
      </button>

      <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <router-link to="/nicu_paed" class="nav-link">NICU / PAED</router-link>
            <router-link to="/maternity" class="nav-link">Maternity</router-link>
            <router-link to="/rehab" class="nav-link">Rehab</router-link>
            <router-link to="/communityhealth" class="nav-link">Community Health</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/leadersboard" class="nav-link">Leaders Board</router-link>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="#">Case Study</a>
          </li>
          <li class="nav-item">
            <router-link to="/datainput" class="nav-link">Data Input</router-link>
          </li>
        </ul>
        
        <form class="col-12 col-lg-auto mb-2 mb-lg-0 me-lg-auto">
          <input type="search" class="form-control" placeholder="Search..." aria-label="Search">
        </form>
        <div class="text-end">
          <button class="btn btn-light" @click="loginOrLogout">Log In/Log Out
          </button>
          <button class="btn btn-light" @click="goToRegister">Register
          </button>
        </div>

      </div>
    </nav>
  </div>
  <router-view />
</template>

<script lang="ts">
import { Vue } from "vue-class-component";
export default class App extends Vue{

    loginOrLogout(): void {
        let tempThis = this;
        if(tempThis.$store.state.auth.status.loggedIn) {
            tempThis.$store.dispatch('auth/logout');
        }
        tempThis.$router.push('/login');
    }

    goToRegister(): void {
        let tempThis = this;
        tempThis.$router.push('/register');
    };
};
</script>