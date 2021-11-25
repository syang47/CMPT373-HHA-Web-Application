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
import { ref, onBeforeMount, defineComponent } from 'vue'

export default defineComponent({
  name: "Home",
  // mounted() {
  //   this.rerender();
  // },
  // methods: {
  //   rerender(): void{
  //     const token = JSON.parse(localStorage.getItem('user')!);
  //     if(token != null) {
  //         this.$forceUpdate();
  //     } 
  //   }
  // }
});
</script>
