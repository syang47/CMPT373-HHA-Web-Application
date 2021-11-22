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
        <select class="btn btn-light dropdown-toggle" v-model="l" name="languages" as="select" @change="changeLang(l)">
            <option class="dropdown-item" v-for="language in languages" :key="language" :value="language"> 
              {{ language }}
            </option>
        </select>
        
      </div>
      <div class="navbar-collapse offcanvas-collapse" >
          <div class="text-end" style="margin-left:auto; margin-right: 0;">
            <button class="btn btn-light" @click="testDelete">
              TestDelete
            </button>
            <button class="btn btn-light" @click="goToDataDisplay">
              <p class="text-dark">Data Display</p>
            </button>
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
      if(this.$store.state.auth.status.loggedIn) {
        this.$store.dispatch('auth/logout');
      }
      this.$router.push('/login');
    },

    goToRegister(): void {
      this.$router.push('/register');
    },

    goToDataDisplay(): void {
      this.$router.push('/dataDisplay');
    },
    
    goToAddAnnouncement(): void {
      this.$router.push('/announcement');
    },
    changeLang(choice: string): void {
      if(choice == "Français"){
        i18n.global.locale = 'fr';
      }
      else if(choice == "English"){
        i18n.global.locale = 'en';
      }
    },

    testDelete() {
      let token = JSON.parse(localStorage.getItem('user')!);
      this.$axios.delete("/api/mspp/delete",{
        headers: {
          'Authorization': `Bearer ${token.jwt}`
        },
        params: {
          documentId: 1
        }
      }).then(response => {
        console.log(response);
      });
    },
    
  }
})

</script>