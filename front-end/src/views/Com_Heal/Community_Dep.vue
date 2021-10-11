<template>
  
  <div class="container-fluid">
    <h1 class="display-2 text-center text-dark">Community Health</h1> 
    <div class="container">
        <div class="row">
            <div class="col">
              <div class="row-6 rounded-left">
                <div class="card rounded text-center text-white mb-3 mt-3 " style="background: #7A4183">
                  <div class="card-body">
                    <h2 class="card-title w-70">Case Study</h2>
                    <h4 class="card-text">Due Date:...</h4>
                    <button class="btn" @click="goToCaseStudy">
                      <img src="../../assets/add_button.png"  class="rounded-circle" alt="" />
                    </button>
                  </div>
                </div>
              </div>
              <div class="row-6"> 
                <div class="card text-center text-white mb-3 mt-3 " style="background: #008eaa">
                  <div class="card-body">
                    <h2 class="card-title w-40">Data Input</h2>
                    <h4 class="card-text">Due Date:...</h4>    
                    <button class="btn" @click="goToDataInput">
                      <img src="../../assets/add_button.png"  class="rounded-circle" alt="" />
                    </button>
                  </div>
                </div>
                
              </div>
            </div>
            <div class="col rounded mb-3 mt-3" style="background: #F59A23" >
              <div class="card w-100 text-center text-white mb-3 mt-3 " style="background: #F59A23; height:93%">
                <div class="card-body">
                  <h2 class="card-title w-40">Employee of the month</h2>
                  <p class="card-text">somewords.....</p>
                </div>
              </div>  
            </div>
        </div>
        <div class="row">
          <div class="card w-100 text-center text-white mb-3 mt-3 " style="background: #64a70b">
            <div class="card-body">
              <h2 class="card-title">Biomechanic Support</h2>
              <button class="btn" @click="gotoBiomech">
                <img src="../../assets/add_button.png"  class="rounded-circle" alt="">
              </button>
            </div>
          </div>      
        </div>
        <div class="row">
          <div class="card w-100 text-center text-white mb-3 mt-3 " style="background: #8C8C8C">
              <h2 class="card-title p-3">Department Points</h2>
              <div class="row p-3" >
                <div class="col-sm-6 p-3" style="border-radius:5px;">
                  Monthly: ... 
                </div>
                <div class="col-sm-6 p-3" style="border-radius:5px;">
                  <span> Annually: ... </span>
                 
                </div>          
              </div>             
          </div>      
        </div>
    </div>
  </div>
</template>

<script lang="ts" type="text/typescript">
import { Vue } from "vue-class-component";

export default class CommunityHealth extends Vue {
  // goToDataInput(): void {
  //   this.$router.push('/datainput');
  // };
  // goToCaseStudy(): void {
  //   this.$router.push('/casestudy');
  // };
  // gotoBiomech(): void {
  //   this.$router.push('/biomech');
  // }
}
</script>

<style>
* {
  margin: 0;
  padding: 0;
}

.btn:hover {
  border-radius: 10px;
  color: #fff;
  box-shadow: 0 0 5px 0 #c6fafe, 0 0 25px 0 #c6fafe, 0 0 50px 0 #c6fafe,
    0 0 100px 0 #c6fafe;
}
</style>
