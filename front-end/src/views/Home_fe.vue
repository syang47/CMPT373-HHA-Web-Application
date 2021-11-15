
<style scoped>
  *{
      margin: 0;
      padding: 0;
  }

  h1, h2 {
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
    padding: 2px 2px 2px 2px;
    border-radius: 10px;
    border: 1px solid #797979;
    background-color: #ffffff;
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

    background-color: #ffffff;
  }
  .leader-board_button {

    background-color: #ffffff;
  }

  .rectangle-leader-board {
    width: 100%;
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

    background-color: #ffffff;
  }

  .maternity_button {

    background-color: #ffffff;
    align-content: center;
  }

  .rehab_button {

    background-color: #ffffff;
  }

  .community-health_button {

    background-color: #ffffff;
  }

  .rectangle-sky-blue-buttons {
    padding: 2px 2px 2px 2px;

    width:100%;
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
    background-color: #ffffff;
  }

  .rectangle-msg-board {
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
    background-color: #ffffff;
  }

  .rectangle-case-studies {
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
  .carousel-img {
    width: 90%;
    height: 100%;
    object-fit: cover;
  }

  .button {
      height:80px;
      padding: 2px 2px 2px 2px;
  }
</style>

<template>  
  <n-space vertical justify="center space-between space-around" size="large">
    <n-grid :cols="2" >
        <n-grid-item :offset="0">
            <n-carousel autoplay>
                <img class="carousel-img" src="../assets/project_photos/pic1.jpeg" />
                <img class="carousel-img" src="../assets/project_photos/pic2.jpg" />
                <img class="carousel-img" src="../assets/project_photos/pic3.jpeg" />
            </n-carousel>
        </n-grid-item>
        <n-grid-item :offset="0">
            <n-collapse arrow-placement="right">
                <n-card class="rectangle-leader-board">
                    <n-collapse-item name="expandLeadersBoard">
                        <template #arrow>
                        <n-icon size="40" color="white" depth="2">
                            <ArrowIcon />
                        </n-icon>
                        </template>
                        <template #header>
                            <button @click.prevent="goToLeadersBoard">
                                <h1>{{ $t('homePage.leaderBoard') }}</h1>
                            </button>                
                        </template>
                        <h1>okay</h1>
                    </n-collapse-item>
                </n-card>
            </n-collapse>
        
            <div class="row justify-content-center">
                <n-grid :cols="2" item-responsive>
                    <n-grid-item span="1">
                        <n-collapse class="col justify-content-center" arrow-placement="right">
                            <n-card class="rectangle-sky-blue-buttons" v-if="showNICU">
                                <n-collapse-item name="expandDepartment">
                                <template #arrow>
                                    <n-icon size="40" color="white" depth="2">
                                        <ArrowIcon />
                                    </n-icon>
                                </template>
                                <template #header>
                                    <button class="button" @click.prevent="goToNICUPAED" >
                                        <h1>{{ $t('homePage.nicuPaed') }}</h1>
                                    </button>                
                                </template>
                                <h1>okay</h1>
                                </n-collapse-item>
                            </n-card>
                        </n-collapse>
                    </n-grid-item>
                    <n-grid-item span="1">
                        <n-collapse class="col justify-content-center" arrow-placement="right">
                            <n-card class="rectangle-sky-blue-buttons" v-if="showMaternity">
                                <n-collapse-item name="expandDepartment">
                                <template #arrow>
                                    <n-icon size="40" color="white" depth="2">
                                    <ArrowIcon />
                                    </n-icon>
                                </template>
                                <template #header>
                                    <button class="button" @click.prevent="goToMaternity" >
                                        <h1>{{ $t('homePage.maternity') }}</h1>
                                    </button>                
                                </template>
                                <h1>okay</h1>
                                </n-collapse-item>
                            </n-card>
                        </n-collapse>
                    </n-grid-item>
                </n-grid>
                <n-grid :cols="2"  item-responsive>
                    <n-grid-item span="1">
                        <n-collapse class="col justify-content-center" arrow-placement="right">
                            <n-card class="rectangle-sky-blue-buttons" v-if="showRehab">
                                <n-collapse-item name="expandDepartment">
                                    <template #arrow>
                                        <n-icon size="40" color="white" depth="2">
                                            <ArrowIcon />
                                        </n-icon>
                                    </template>
                                    <template #header>
                                        <button class="button" @click.prevent="goToRehab" >
                                            <h1>{{ $t('homePage.rehab') }}</h1>
                                        </button>                
                                    </template>
                                    <h1>okay</h1>
                                </n-collapse-item>
                            </n-card>
                        </n-collapse>
                    </n-grid-item>

                    <n-grid-item span="1">   
                        <n-collapse class="col justify-content-center" arrow-placement="right">
                            <n-card class="rectangle-sky-blue-buttons" v-if="showComHealth">
                                <n-collapse-item name="expandDepartment">
                                    <template #arrow>
                                        <n-icon size="40" color="white" depth="2">
                                            <ArrowIcon />
                                        </n-icon>
                                    </template>
                                    <template #header>
                                        <button class="button" @click.prevent="goToCommunityHealth" >
                                            <h1>{{ $t('homePage.communityHealth') }}</h1>
                                        </button>                
                                    </template>
                                    <h1>okay</h1>
                                    <h1>okay</h1><h1>okay</h1><h1>okay</h1><h1>okay</h1><h1>okay</h1>
                                </n-collapse-item>
                            </n-card>
                        </n-collapse>
                    </n-grid-item>
                </n-grid>
            </div>
            <n-card class="rectangle-msg-board">
                <button class="button" style="display:inline-block;" @click.prevent="goToMessageBoard">
                    <h1>{{ $t('homePage.messageBoard') }}</h1>
                </button>
            </n-card>
            <n-card class="rectangle-case-studies">
                <button class="button">
                    <h1>{{ $t('homePage.caseStudy') }}</h1>
                </button>
            </n-card>
    
        </n-grid-item>
        
    </n-grid>
  </n-space>
</template>

<script lang="ts" type="text/typescript">
import { defineComponent } from 'vue'
import {KeyboardArrowDownOutlined as ArrowIcon} from "@vicons/material"
export default defineComponent({
  name: "Home_fe",
  components: {
    ArrowIcon
  },
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