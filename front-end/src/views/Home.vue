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
      width: 590px;
      height: 95px;
      padding: 2px 2px 2px 2px;
      border-radius: 10px;
      border: 1px solid #797979;
      background-color: #008eaa;
      box-sizing: border-box;
      box-shadow: 5px 5px 5px 0px rgba(0, 0, 0, 0.35);
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
    }

</style>

<template>
  <div class="home">
  <h1 class="rectangle-leader-board">LEADER BOARD</h1>
  <h1 class="rectangle-sky-blue-buttons">NICU/PAED</h1>
  <h1 class="rectangle-sky-blue-buttons">MATERNITY</h1>
  <h1 class="rectangle-sky-blue-buttons">REHAB</h1>
  <h1 class="rectangle-sky-blue-buttons">COMMUNITY HEALTH</h1>
  <h1 class="rectangle-msg-board">MESSAGE BOARD</h1>
  <h1 class="rectangle-case-studies">CASE STUDY</h1>
  </div>
</template>

<script lang="ts">
import { Options, Vue } from "vue-class-component";
import HelloWorld from "@/components/HelloWorld.vue"; // @ is an alias to /src

@Options({
  components: {
    HelloWorld,
  },
})
export default class Home extends Vue {}
</script>


