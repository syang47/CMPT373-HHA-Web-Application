<template>
   <div class="container-fluid sticky-top "> 
    
    <nav class="navbar navbar-expand-md navbar-light bg-light">
      <router-link to="/home" class="navbar-brand active">
        <img src="@/assets/logo.png" width="140" alt=""/>
      </router-link>
      <button class="navbar-toggler p-0 border-0" type="button" data-toggle="offcanvas">
        <span class="navbar-toggler-icon" />
      </button>

      <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <router-link to="/department" class="nav-link">Department</router-link>
            <router-link to="/nicu_paed" class="nav-link">NICU / PAED</router-link>
            <router-link to="/maternity" class="nav-link">Maternity</router-link>
            <router-link to="/rehab" class="nav-link">Rehab</router-link>
            <router-link to="/communityhealth" class="nav-link">Community Health</router-link>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled"  href="#">Leaders Board</a>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="#">Case Study</a>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="#">Data Input</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" @click.prevent="logout">Log Out</a>
          </li>
        </ul>
        
        <form class="col-12 col-lg-auto mb-2 mb-lg-0 me-lg-auto">
          <input type="search" class="form-control" placeholder="Search..." aria-label="Search">
        </form>
        <div class="text-end">
          <button type="button" class="btn btn-dark me-2">
            <router-link to="/login" class="nav-link active text-light bg-dark">Login</router-link>
            
          </button>
          <button type="button" class="btn btn-light">
            <router-link to="/register" class="nav-link active bg-light text-dark">Register</router-link>
          </button>
        </div>
      </div>
    </nav>
  </div>
  <router-view />
</template>

<script>
export default {
  
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    }
  },
  methods: {
    logout() {
      this.$store.dispatch('auth/logout');
      this.$router.push('/login');
    },
    goToDepartment() {
      this.$router.push('/department');
    },
    goToLogin() {
      this.$router.push('/login');
    },
    goToRegister() {
      this.$router.push('/register');
    },
    goToHome() {
      this.$router.push('/home');    
    }
  }

};



</script>