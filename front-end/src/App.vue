<template>
   <div class="container-fluid">
    
    <nav class="navbar navbar-expand-md navbar-light bg-light">
      <router-link to="/" class="navbar-brand active">
        <img src="@/assets/logo.png" width="140" alt=""/>
      </router-link>
      <button class="navbar-toggler p-0 border-0" type="button" data-toggle="offcanvas">
        <span class="navbar-toggler-icon" />
      </button>
      <div class="text-end" style="margin-left:auto; margin-left: 0;">
        <button class="btn btn-light" @click="changeToEnglish">English</button>
        <button class="btn btn-light" @click="changeToFrench">Français</button>
      </div>
      <div class="navbar-collapse offcanvas-collapse" >
          <div class="text-end" style="margin-left:auto; margin-right: 0;">
            
            <button class="btn btn-light" @click="goToAddAnnouncement">Add announcement
            </button>
            <button class="btn btn-light" @click="addTestMessage">Add message
            </button>
            <button class="btn btn-light" @click="loginOrLogout">{{ $t('header.loginOut') }}
            </button>
            <button class="btn btn-light" @click="goToRegister">{{ $t('header.register') }}
            </button>
          </div>
      </div>
    </nav>
  </div>
  <router-view />
</template>

<script lang="ts">
import { Vue } from "vue-class-component";
import i18n from "./i18n";

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
  }

  goToAddAnnouncement(): void {
    let tempThis = this;
    tempThis.$router.push('/announcement');
  }

  addTestMessage(): void {
    let tempThis = this;
    let token = JSON.parse(localStorage.getItem('user')!);
    type Entry = {
      title: string,
      message: string,
      departmentname: string
    }
    var entry:Entry = {
        title: "TEST TITLE",
        message: "TEST MESSAGE",
        departmentname: token.department
    };
    tempThis.$axios.post("/api/messageboard/submit", entry, {
        headers: {
            'Authorization': `Bearer ${token.jwt}`
        }
    }).then(response => {
          console.log(response.data);
          return JSON.stringify(response.data);
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
            return JSON.stringify(response.data);
      });
  }
  
  changeToEnglish(): void {
    i18n.global.locale = 'en';
  }
  changeToFrench(): void {
    i18n.global.locale = 'fr';
  }

  // force push 3 case studies to test leadersboard implementation
  getLeadersboard(): void {
      let tempThis = this;
      let token = JSON.parse(localStorage.getItem('user')!);
      tempThis.$axios.get("/api/casestudy", {
          headers: {
              'Authorization': `Bearer ${token.jwt}`
          }
      }).then(response => {
            console.log(response.data);
      });
  }
};
</script>