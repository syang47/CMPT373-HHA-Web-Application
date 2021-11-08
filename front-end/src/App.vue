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

            <button class="btn btn-light" @click="goToAddAnnouncement">
              <p class="text-dark">{{ $t('header.addAnnouncement') }}</p>
            </button>
            <button class="btn btn-light" @click="loginOrLogout">
              <p class="text-dark">{{ $t('header.loginOut') }}</p>
            </button>
            <button class="btn btn-light" @click="goToRegister">
              <p class="text-dark">{{ $t('header.register') }}</p>
            </button>
          </div>
      </div>
    </nav>
  </div>
  <router-view />
</template>

<script lang="ts">
import { defineComponent } from 'vue'
import i18n from "./i18n";

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

    changeLang(choice: string): void {
      if(choice == "Français"){
        i18n.global.locale = 'fr';
      }
      else if(choice == "English"){
        i18n.global.locale = 'en';
      }
    }
  }
})

</script>