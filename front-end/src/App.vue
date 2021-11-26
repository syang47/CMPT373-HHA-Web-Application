<style>
  body {
    height: 100%;
    width: 100%;
    min-height: 100%;
    margin: 0;
    padding: 0;
    position: relative;
  }
  .container-fluid {
    height: inherit;
  }
  .menu{
    float: left;
    position: fixed;
    z-index: 9999;
  }
  .nav-item {
    padding-left: 10px;
    padding-right: 10px;
  }
  .viewWithSideBar {
    position: fixed;
    display:flex;
    top: 105px;
    object-fit: contain;
    height: auto;
    width: calc(100%-100px);
    overflow: auto;
    margin-left:65px;
    margin-right:-65px;
  }
  .viewWithoutSideBar {
    position: fixed;
    top: 105px;
    object-fit: contain;
    height: 100%;
    width: 100vw;
    overflow: auto;
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
  <nav class="w-100 navbar navbar-expand-sm navbar-light bg-light sticky-top">
      <router-link to="/" class="navbar-brand active px-3">
        <img src="@/assets/logo.png" width="140" alt=""/>
      </router-link>
      <ul class="d-flex justify-content-end navbar-nav ml-auto">
        <li class="my-auto nav-item">
          <select class="btn btn-sm btn-secondary dropdown-toggle" v-model="l" name="languages" as="select" @change="changeLang(l)">
              <option class="dropdown-item" v-for="language in languages" :key="language" :value="language"> 
                {{ language }}
              </option>
          </select>
        </li>
        <li class="my-auto nav-item">
          <button class="btn btn-sm btn-outline-secondary" @click="loginOrLogout">
            {{ $t('header.loginOut') }}
          </button>
        </li>
      </ul>
  </nav>
  <div class="menu" v-if="showSidebar" :key="reloadSidebar">
    <SideMenu />
  </div>
  
  <router-view /> 
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
      showSidebar: false,
      reloadSidebar: 0
    };
  },
  watch: {
    '$store.state.auth.status.loggedIn': function() {
      console.log(this.$store.state.auth.status.loggedIn);
      if(this.$store.state.auth.status.loggedIn){
        this.showSidebar = true;
        this.reloadSidebar += 1
      } else {
        this.showSidebar = false;
        this.reloadSidebar += 1
      }
    }
  },
  beforeMount() {
    if(this.$store.state.auth.status.loggedIn){
        this.showSidebar = true;
      } else {
        this.showSidebar = false;
      }
  },
  methods: {
    loginOrLogout(): void {
      if(this.$store.state.auth.status.loggedIn) {
        this.$store.dispatch('auth/logout');
      }
      this.$router.push('/login');
    },

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