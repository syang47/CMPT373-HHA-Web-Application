<template>
   <div class="container-fluid">
    
    <nav class="navbar navbar-expand-md navbar-light bg-light">
      <router-link to="/" class="navbar-brand active">
        <img src="@/assets/logo.png" width="140" alt=""/>
      </router-link>
      <button class="navbar-toggler p-0 border-0" type="button" data-toggle="offcanvas">
        <span class="navbar-toggler-icon" />
      </button>

      <div class="navbar-collapse offcanvas-collapse" >

        <div class="text-end" style="margin-left:auto; margin-right: 0;">
          <button class="btn btn-light" @click="loginOrLogout">Log In/Log Out
          </button>
          <button class="btn btn-light" @click="goToRegister">Register
          </button>
          <button class="btn btn-light" @click="getDepartments">Show Departments
          </button>
          <button class="btn btn-light" @click="getData">Show Data
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

    getDepartments(): void {
        let tempThis = this;
        let token = JSON.parse(localStorage.getItem('user')!);
        tempThis.$axios.get("/api/mspp/department", {
            headers: {
                'Authorization': `Bearer ${token.jwt}`
            }
        }).then(response => {
              console.log(response.data);
        });
    }

    getData(): void {
        let tempThis = this;
        let token = JSON.parse(localStorage.getItem('user')!);
        tempThis.$axios.get("/api/mspp/data", {
            headers: {
                'Authorization': `Bearer ${token.jwt}`
            }
        }).then(response => {
              console.log(response.data);
        });
    }
};
</script>