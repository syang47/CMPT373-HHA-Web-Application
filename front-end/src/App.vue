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
  /* header */
  .header-fixed{
    position: fixed !important;
    top:0;
    left: 0;
    z-index: 999999;
    box-shadow: 0px 1px 8px rgb(0 0 0 / 25%);
    background-color: #dddddd;
  }
  .menu{
    position: fixed;
    z-index: 9999;
    padding-top: 107px;
    height: 100vh;
    overflow: auto;
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
  .main-content{
    margin-left: 290px;
    padding-top: 107px;
  }
  .main-wrapper{
    height: calc(100vh - 140px);
  }
  .vsm--toggle-btn{
    display: none !important;
  }

  /* form box */
.card.form-box{
  max-width: 600px;
    background-color: #f6f9f9;
    margin: 0 auto;
}

/* box style */
.card{
  box-shadow: none !important;
}
.card.has-bg{
    background-color: #edf2f9;
    box-shadow: none !important;
}
.btn:hover{
  box-shadow: none !important;
}
/* global style */
.font-weight-normal{
  font-weight: 400;
}

</style>

<template>
  <nav class="w-100 navbar navbar-expand-sm navbar-light header-fixed">
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
        <li class="my-auto nav-item">
          <button class="btn btn-sm btn-outline-secondary" @click="gettestemployee">
            get employeeofthemonth
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
    },
    gettestemployee(): void {
      let token = JSON.parse(localStorage.getItem('user')!);
      var months = ['January', 'February', 'March',
        'April', 'May', 'June', 'July',
        'August', 'September', 'October', 'November', 'December'];
      this.$axios.get("/api/user/employeeofthemonth", {
        headers: {
          'Authorization': `Bearer ${token.jwt}`
        },
        params: {
          month: months[new Date().getMonth()] + " " + new Date().getFullYear()
        }
      }).then(response => {
        console.log(response.data);
      });
    }

  },
 
});

</script>