
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


<div id="carouselExampleFade" class="carousel slide carousel-fade" data-bs-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="../assets/project_photos/pic1.jpeg" class="d-block vw-100 vh-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="../assets/project_photos/pic2.jpg" class="d-block vw-100 vh-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="../assets/project_photos/pic3.jpeg" class="d-block vh-100 vw-100" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
</template>
<script lang="ts" type="text/typescript">
import { defineComponent } from 'vue'
import {KeyboardArrowDownOutlined as ArrowIcon} from "@vicons/material"
import SideMenu from "./SideMenu.vue";
export default defineComponent({
  name: "Home_fe",
});
</script>