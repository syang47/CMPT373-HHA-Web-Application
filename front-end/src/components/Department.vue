<template>
  <div class="container-fluid"> 
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand" href="#" >
        <img src="../assets/logo.png" width="140" alt=""/>
        
      </a>
      <h1>Department</h1>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link" href="#">Link</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              Dropdown
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="#">Action</a>
              <a class="dropdown-item" href="#">Another action</a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="#">Something else here</a>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="#">Disabled</a>
          </li>
        </ul>

        <form class="form-inline my-2 my-lg-0 ml-auto">
          <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-primary my-2 my-sm-2 margin-right" type="submit">Search</button>
        </form>
      </div>
    </nav>
    <div class="container">
        <div class="row">
            <div class="col">
              <div class="row-6">
                <div class="card text-center text-white mb-3 mt-3 " style="background: #7A4183">
                  <div class="card-body">
                    <h2 class="card-title w-70">Case Study</h2>
                    <h4 class="card-text">Due Date:...</h4>
                    <button class="btn">
                      <img src="../assets/add_button.png"  class="rounded-circle" alt="">
                    </button>
                  </div>
                </div>
              </div>
              <div class="row-6"> 
                <div class="card text-center text-white mb-3 mt-3 " style="background: #008eaa">
                  <div class="card-body">
                    <h2 class="card-title w-40">Data Input</h2>
                    <h4 class="card-text">Due Date:...</h4>    
                    <button class="btn">
                      <img src="../assets/add_button.png"  class="rounded-circle" alt="">
                    </button>
                  </div>
                </div>
                
              </div>
            </div>
            <div class="col mb-3 mt-3" style="background: #F59A23" >
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
              <button class="btn">
                <img src="../assets/add_button.png"  class="rounded-circle" alt="">
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

<script lang="ts">
import { Vue } from "vue-class-component";
import "bootstrap/dist/css/bootstrap.css";
import 'bootstrap-vue/dist/bootstrap-vue.css';

export default class Login extends Vue {
  
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
