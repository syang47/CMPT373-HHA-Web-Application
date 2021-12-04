<style>
.img-wrap{
  height:calc(100vh - 140px);
}
.img-wrap img{
  width: 100%;
  height: 100%;
  object-fit: cover;
}
</style>
<template>
  <div class="main-content">
    <div class="card">
      <div class="card-body">
        <div id="carouselExampleFade" class="carousel slide carousel-fade" data-bs-ride="carousel">
    <div class="carousel-inner">
      
      <div class="carousel-item active">
        <div class="img-wrap">
          <img src="../assets/project_photos/pic10.jpg" class="img-fluid" alt="..."> 
        </div>
      </div>

      <div class="carousel-item">
        <div class="img-wrap">
          <img src="../assets/project_photos/pic5.jpeg" class="img-fluid" alt="...">
        </div>

      </div>
      <div class="carousel-item">
        <div class="img-wrap">
          <img src="../assets/project_photos/pic3.jpeg" class="img-fluid" alt="...">
        </div>
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
      </div>
    </div>
  </div>
</template>
<script lang="ts" type="text/typescript">
import { defineComponent } from 'vue'
export default defineComponent({
  name: "Home",
});
</script>
