<style>
  body {
    height: 100%;
    width: 100%;
    min-height: 100%;
    margin: 0;
    padding: 0;
    position: relative;
  }
  .container-fluid {height:inherit;}
  .pad {
    padding-left: 25px;
    padding-left: 25px;
  }
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
  <header class="w-100 navbar navbar-expand-md navbar-light bg-light sticky-top flex-wrap flex-sm-nowrap">
      <ul class="d-flex justify-content-end navbar-nav ml-auto">
        <!--<li class="nav-item">
          <button class="btn btn-secondary" @click="goToDataDisplay">
            Data Display
          </button>
        </li>
        <li class="nav-item">
          <button class="btn btn-secondary" @click="goToAddAnnouncement">
            {{ $t('header.addAnnouncement') }}
          </button>
        </li>-->
        <li class="my-auto nav-item pad">
          <select class="btn btn-sm btn-secondary dropdown-toggle" v-model="l" name="languages" as="select" @change="changeLang(l)">
              <option class="dropdown-item" v-for="language in languages" :key="language" :value="language"> 
                {{ language }}
              </option>
          </select>
        </li>
        <li class="my-auto nav-item pad">
          <button class="btn btn-sm btn-outline-secondary" @click="loginOrLogout">
            {{ $t('header.loginOut') }}
          </button>
        </li>
        
      </ul>
      <a class="my-auto navbar-brand justify-content-end pad" href="/">
        <img src="@/assets/logo.png" width="140" alt=""/>
      </a>
  </header>
  
  <div class="container-fixed">
      <div class="col min-vh-100">
        <router-view />
      </div>
  </div>
  <SideMenu v-if="showSideBar"/>

  
</template>

<script lang="ts">
import { defineComponent } from 'vue'
import i18n from "./i18n";
import SideMenu from "@/views/sidebar/SideMenu.vue";

export default defineComponent({
  name: "App",
  components: {
    SideMenu,
  },
  
  data: function() {
    return{
      languages: ["Français", "English"],
      l: "Français",
      showSideBar: false,
    };
  },
  mounted() {
    if(this.$store.state.auth.status.loggedIn) {
        this.showSideBar = true;
    }
  },
  methods: {
    loginOrLogout(): void {
      if(this.$store.state.auth.status.loggedIn) {
        this.$store.dispatch('auth/logout');
        this.showSideBar = true;
      }
      this.$router.push('/login');
      this.showSideBar = false;
    },

    // goToRegister(): void {
    //   this.$router.push('/register');
    // },

    // goToDataDisplay(): void {
    //   this.$router.push('/dataDisplay');
    // },
    
    // goToAddAnnouncement(): void {
    //   this.$router.push('/announcement');
    // },

    changeLang(choice: string): void {
      if(choice == "Français"){
        i18n.global.locale = 'fr';
      }
      else if(choice == "English"){
        i18n.global.locale = 'en';
      }
    }
  },
 
});

</script>