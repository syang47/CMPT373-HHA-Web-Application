
<style scoped>
  .background {
    background: url('../assets/project_photos/BidiBidi health centre zone 1 where we are building disability centre.jpeg') no-repeat;
    height: 100%;
    width: 100%;
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
    position: absolute;
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
</style>

<template>
<div class="background">
  <div class="home container-fluid justify-content-center">
    <div class="row justify-content-center">
      <button class="button" @click.prevent="goToLeadersBoard">
        <h1 class="rectangle-leader-board">{{ $t('homePage.leaderBoard') }}</h1>
      </button>

    </div>
    <div class="row justify-content-center">
      <div class="row" >
        <div class="col" v-if="showNICU">
          <button style="display:inline-block;" class="button" @click.prevent="goToNICUPAED" >
            <h1 class="rectangle-sky-blue-buttons">{{ $t('homePage.nicuPaed') }}</h1>
          </button>
        </div>
        <div class="col" v-if="showMaternity">
          <button style="display:inline-block;" class="button" @click.prevent="goToMaternity">
            <h1 class="rectangle-sky-blue-buttons">{{ $t('homePage.maternity') }}</h1>
          </button>
        </div>
      </div>
      <div class="row">
        <div class="col" v-if="showRehab">
          <button style="display:inline-block;" class="button" @click.prevent="goToRehab">
            <h1 class="rectangle-sky-blue-buttons">{{ $t('homePage.rehab') }}</h1>
          </button>
        </div>
        <div class="col" v-if="showComHealth">
          <button style="display:inline-block;" class="button" @click.prevent="goToCommunityHealth">
            <h1 class="rectangle-sky-blue-buttons">{{ $t('homePage.communityHealth') }}</h1>
          </button>
        </div>
      </div>
    </div>
    <div class="row justify-content-center">
      <button class="button" style="display:inline-block;" @click.prevent="goToMessageBoard">
        <h1 class="rectangle-msg-board">{{ $t('homePage.messageBoard') }}</h1>
      </button>
    </div>
    <div class="row justify-content-center">
      <button class="button">
        <h1 class="rectangle-case-studies">{{ $t('homePage.caseStudy') }}</h1>
      </button>
    </div>
  </div>
</div>
</template>

<script lang="ts" type="text/typescript">
import { defineComponent } from 'vue'
export default defineComponent({
  name: "Home",
  mounted() {
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

    goToLeadersBoard(){
      this.$router.push('/leadersboard');
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
      this.$router.push('/message_board');
    }

  }
});
</script>
