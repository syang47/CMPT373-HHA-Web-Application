<style>
  .button{
    color:black;
  }
</style>

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
        <select v-model="l" name="languages" as="select" @change="changeLang(l)">
          <option v-for="language in languages" :key="language" :value="language"> {{ language }} </option>
        </select>
        <!-- <button class="btn btn-light" @click="changeToFrench">
          <p class="text-dark">Français</p>
        </button>
        <button class="btn btn-light" @click="changeToEnglish">
          <p class="text-dark">English</p>
        </button> -->
      </div>
      <div class="navbar-collapse offcanvas-collapse" >
          <div class="text-end" style="margin-left:auto; margin-right: 0;">
            <button class="btn btn-light" @click="loginOrLogout">
              <p class="text-dark">{{ $t('header.loginOut') }}</p>
            </button>
            <button class="btn btn-light" @click="goToRegister">
              <p class="text-dark">{{ $t('header.register') }}</p>
            </button>
            <button class="btn btn-light" @click="getData">
              <p class="text-dark">{{ $t('header.showData') }}</p>
            </button>
            <button class="btn btn-light" @click="goToAddAnnouncement">
              <p class="text-dark">{{ $t('header.addAnnouncement') }}</p>
            </button>
          </div>
      </div>
    </nav>
  </div>
  <router-view />
</template>

<script lang="ts">
import { Vue } from "vue-class-component";
import { defineComponent } from 'vue'
import i18n from "./i18n";
import { LOCALES } from "./i18n/locales";

export default defineComponent({
  name: "App",  
  data: function() {


    return{
      languages: ["Français", "English"],
      l: "Français",
    };
  },
  methods: {
    loginOrLogout(): void {
      let tempThis = this;
      if(tempThis.$store.state.auth.status.loggedIn) {
        tempThis.$store.dispatch('auth/logout');
      }
      tempThis.$router.push('/login');
    },

    goToRegister(): void {
      let tempThis = this;
      tempThis.$router.push('/register');
    },

    goToAddAnnouncement(): void {
      let tempThis = this;
      tempThis.$router.push('/announcement');
    },

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
    },

    changeLang(choice: string): void {
      if(choice == "Français"){
        i18n.global.locale = 'fr';
      }
      else if(choice == "English"){
        i18n.global.locale = 'en';
      }
    },

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
  }
})

</script>