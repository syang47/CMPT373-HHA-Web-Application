<style>
  h1, h2, label, p {
    font-family: "Arial";
    font-weight: bold;
    
  }
  .btn{
    font-family: "Arial";
    font-weight: bold;
    border: 1px solid black;
    color: black;
    position: relative;
    overflow: hidden;
    text-transform: uppercase;
    letter-spacing: 2px;
  }
  .btn:hover{
    border-radius: 5px;
    color: #fff;
    box-shadow: 0 0 5px 0 black,
    0 0 25px 0 black,
    0 0 50px 0 black,
    0 0 100px 0 black;
  }
</style>

<template>
  <nav class="navbar navbar-expand-md navbar-light bg-light">
    <a class="navbar-brand" href="/">
      <img src="@/assets/logo.png" width="140" alt=""/>
    </a>
    
    <select class="dropdown-toggle" v-model="l" name="languages" as="select" @change="changeLang(l)">
        <option class="dropdown-item" v-for="language in languages" :key="language" :value="language"> 
          {{ language }}
        </option>
    </select>
    <ul class="navbar-nav ml-auto">
      
      <li class="nav-item">
        <button class="btn btn-secondary" @click="goToDataDisplay">
          Data Display
        </button>
      </li>
      <li class="nav-item">
        <button class="btn btn-secondary" @click="goToAddAnnouncement">
          {{ $t('header.addAnnouncement') }}
        </button>
      </li>
      <li class="nav-item">
        <button class="btn btn-secondary" @click="loginOrLogout">
          {{ $t('header.loginOut') }}
        </button>
      </li>
    </ul>
        <!--
          <li class="nav-item">
        <button class="btn btn-light" @click="goToRegister">
          <p class="text-dark">{{ $t('header.register') }}</p>
        </button>
      </li>
      <div class="navbar-collapse offcanvas-collapse" >
          <div class="text-end" style="margin-left:auto; margin-right: 0;">
             test button for data query 
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
      </div> -->
  </nav>
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

    goToDataDisplay(): void {
      let tempThis = this;
      tempThis.$router.push('/dataDisplay');
    },
  // force push 3 case studies to test leadersboard implementation
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