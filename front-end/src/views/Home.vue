<style>

    .background {
        background-color: rgb(253, 253, 253);
        height: 100%;
        position: fixed;
        width: 100%;    
    } 
    *{
        margin: 0;
        padding: 0;
    }

    h1 {
      background-color: white;
      color: white;
      text-align: center;
      vertical-align: text-bottom;
    }

    .logo {
      width: 417px;
      height: 264px;
      box-sizing: border-box;
    }

    .rectangle-logo {
      width: 1200px;
      height: 620px;
      padding: 2px 2px 2px 2px;
      border-radius: 10px;
      border: 1px solid #797979;
      background-color: #ffffff;
      box-sizing: border-box;
    }

    .image {
      width: 1200px;
      height: 469px;
      border-radius: 10px;
      box-sizing: border-box;
    }

    .rectangle {
      width: 1200px;
      height: 620px;
      padding: 2px 2px 2px 2px;
      border-radius: 10px;
      border: 1px solid #797979;
      background-color: #ffffff;
      box-sizing: border-box;
    }

    .home-p_button {
      width: 1200px;
      height: 683px;
      background-color: #ffffff;
    }

    .image {
      width: 1200px;
      height: 469px;
      border-radius: 10px;
      box-sizing: border-box;
    }

    .leader-board_button {
      width: 1200px;
      height: 100px;
      background-color: #ffffff;
    }

    .rectangle-leader-board {
      width: 1210px;
      height: 110px;
      padding: 2px 2px 2px 2px;
      border-radius: 10px;
      border: 1px solid #797979;
      background-color: #7a4183;
      box-sizing: border-box;
      box-shadow: 5px 5px 5px 0px rgba(0, 0, 0, 0.35);
      display: flex;
      align-items: center;
      justify-content: center;
    }

    .nicu-paed_button {
      width: 580px;
      height: 85px;
      background-color: #ffffff;
    }

    .maternity_button {
      width: 580px;
      height: 85px;
      background-color: #ffffff;
      align-content: center;
    }

    .rehab_button {
      width: 580px;
      height: 85px;
      background-color: #ffffff;
    }

    .community-health_button {
      width: 580px;
      height: 85px;
      background-color: #ffffff;
    }

    .rectangle-sky-blue-buttons {
      width: 550px;
      height: 85px;
      /* width: 590px;
      height: 95px; */
      padding: 2px 2px 2px 2px;
      border-radius: 10px;
      border: 1px solid #797979;
      background-color: #008eaa;
      box-sizing: border-box;
      box-shadow: 5px 5px 5px 0px rgba(0, 0, 0, 0.35);
      display: flex;
      align-items: center;
      justify-content: center;
    }

    .msg-board_button {
      width: 1200px;
      height: 100px;
      background-color: #ffffff;
    }

    .rectangle-msg-board {
      width: 1210px;
      height: 110px;
      padding: 2px 2px 2px 2px;
      border-radius: 10px;
      border: 1px solid #797979;
      background-color: #7a4183;
      box-sizing: border-box;
      box-shadow: 5px 5px 5px 0px rgba(0, 0, 0, 0.35);
      display: flex;
      align-items: center;
      justify-content: center;
    }

    .case-studies_button {
      width: 1200px;
      height: 100px;
      background-color: #ffffff;
    }

    .rectangle-case-studies {
      width: 1210px;
      height: 110px;
      padding: 2px 2px 2px 2px;
      border-radius: 10px;
      border: 1px solid #797979;
      background-color: #008eaa;
      box-sizing: border-box;
      box-shadow: 5px 5px 5px 0px rgba(0, 0, 0, 0.35);
      display: flex;
      align-items: center;
      justify-content: center;
    }

    .button {
      /* width: 550px; */
      /* height: 85px; */
      padding: 2px 2px 2px 2px;
      /* border-radius: 10px;
      border: 1px solid #797979;
      background-color: #008eaa;
      box-sizing: border-box;
      box-shadow: 5px 5px 5px 0px rgba(0, 0, 0, 0.35); */
      cursor: pointer;
      display: flex;
      align-items: center;
      justify-content: end;
    }


</style>

<template>
  <div class="home container-fluid justify-content-center">
    <div class="row justify-content-center">
      <button class="button">  
        <h1 class="rectangle-leader-board">LEADER BOARD</h1>
      </button>
    </div>
    <div class="row justify-content-center">
      <div class="row" >
        <div class="col" v-if="showNICU">
          <button style="display:inline-block;" class="button" @click.prevent="goToNICUPAED" > 
            <h1 class="rectangle-sky-blue-buttons">NICU/PAED</h1>
          </button>
        </div>
        <div class="col" v-if="showMaternity">
          <button style="display:inline-block;" class="button" @click.prevent="goToMaternity">
            <h1 class="rectangle-sky-blue-buttons">MATERNITY</h1>
          </button>
        </div>
      </div>
      <div class="row">
        <div class="col" v-if="showRehab">
          <button style="display:inline-block;" class="button" @click.prevent="goToRehab">
            <h1 class="rectangle-sky-blue-buttons">REHAB</h1>
          </button>
        </div>
        <div class="col" v-if="showComHealth">
          <button style="display:inline-block;" class="button" @click.prevent="goToCommunityHealth">
            <h1 class="rectangle-sky-blue-buttons">COMMUNITY HEALTH</h1>
          </button>
        </div>
      </div>
    </div>
    <div class="row justify-content-center">
      <button style="display:inline-block;" class="button" @click.prevent="goToMessageBoard">
        <h1 class="rectangle-msg-board">MESSAGE BOARD</h1>
      </button>
    </div>
    <div class="row justify-content-center">
      <button class="button">
        <h1 class="rectangle-case-studies">CASE STUDY</h1>
      </button>
    </div>
  </div>
</template>

<script lang="ts" type="text/typescript">
import { defineComponent } from 'vue'
export default defineComponent({
  name: "Home",
  mounted() {
      if(!this.$store.state.auth.status.loggedIn) {
          this.$router.push('/login');
      }
      this.showDepartments();
  },
  data: function() {

    return {
      showNICU: false,
      showComHealth: false,
      showMaternity: false,
      showRehab: false,
      
    }
  },
  methods: {
    showDepartments(): void {
      const token = JSON.parse(localStorage.getItem('user')!);
      if(token.roles[0].authority == 'ROLE_ADMIN' || token.roles[0].authority == 'ROLE_HEAD') {
        this.showNICU = true;
        this.showComHealth = true;
        this.showMaternity = true;
        this.showRehab = true;
      }
      if(token.department == "NICU_PAED") {
        this.showNICU = true;
      }
      if(token.department == "community_health") {
        this.showComHealth = true;
      }
      if(token.department == "maternity")  {
        this.showMaternity = true;
      }
      if(token.department == "rehab")  {
        this.showRehab = true;
      }
    },
    goToNICUPAED() {
      this.$router.push('/nicu_paed');
    },
    goToMaternity() {
      this.$router.push('/maternity');
    },
    goToRehab() {
      this.$router.push('/rehab');
    },
    goToCommunityHealth() {
      this.$router.push('/community_health');
    },
    goToMessageBoard() {
      this.$router.push('/Message_Board');
    }

  }
  
});
</script>


