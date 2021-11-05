<template>
   <div class="container-fluid">
    
    <nav class="navbar navbar-expand-md navbar-light bg-light">
      <router-link to="/" class="navbar-brand active">
        <img src="@/assets/logo.png" width="140" alt=""/>
      </router-link>

      <div class="navbar-collapse offcanvas-collapse" >

        <div class="text-end" style="margin-left:auto; margin-left: 0;">
          <button class="btn btn-light" @click="changeToFrench">Français</button>
          <button class="btn btn-light" @click="changeToEnglish">English</button>
        </div>

        <div class="text-end" style="margin-left:auto; margin-right: 0;">          
          <button class="btn btn-light" @click="loginOrLogout">{{ $t('header.loginOut') }}
          </button>
          <button class="btn btn-light" @click="goToRegister">{{ $t('header.register') }}
          </button>
          <button class="btn btn-light" @click="getDepartments">{{ $t('header.showDepartments') }}
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

    changeToFrench(): void {
      i18n.global.locale = 'fr';
    }

    changeToEnglish(): void {
      i18n.global.locale = 'en';
    }
};
</script>