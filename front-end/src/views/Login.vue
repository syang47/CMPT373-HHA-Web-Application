<style>
    .background {
        background: url('../assets/IsaacCBRManager.jpeg') no-repeat;
        /* filter:"progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale')"; */
        /* -moz-background-size:100% 100%; */
        position: relative;
        /* background-size: 100% 100%; */
        height: 100%;
        background-position: center;
        background-repeat: no-repeat;
        background-size:cover;
    } 
    *{
        margin: 0;
        padding: 0;
    }
    h2 {
        font-family: "Arial Bold";
        text-align: center;
        color: #fff;
        margin-bottom: 30px;
    }
    .page {
        height: 100vh; 
        display: flex;
        justify-content: center;
        font-size: 16px;
        align-items: center;
        flex-shrink: 1;
    }
    .box{
        width: 400px;
        height: 364px;
        background: #00000060;
        position: relative;
        box-sizing: border-box;
        padding: 40px;
    }
    .item{
        height: 45px;
        border-bottom: 1px solid #fff;
        margin-bottom: 40px;
        position: relative;
    }
    .item input {
        width:100%;
        height: 100%;
        color: black;
        padding-top: 20px;
        box-sizing: border-box;
    }
    .item input:focus+label ,.item input:valid+label{
        top: 0px;
        font-size: 12px;
        transition: all 0.5 linear;
    }
    .item label {
        position: absolute;
        left: 0;
        top: 12px;
        transition: all 0.5s linear;
    }
    input,button {
        background: transparent;
        border: none;
        outline: none;
    }
    .btn{
        padding: 10px 20px;
        /* background: floralwhite; */
        /* border: 1px solid #fff; */
        margin-top: 30px;
        color: black;
        position:relative;
        overflow: hidden;
        text-transform: uppercase;
        letter-spacing: 2px;
    }
    .btn:hover{
        border-radius: 5px;
        color: #fff;
        box-shadow: 0 0 5px 0 black,
        0 0 25px 0 black,
        0 0 50px 0 black,
        0 0 100px 0 black;
    }
</style>

<template>
    <div class="background">

        <div class="page">
            <div class="box">
                <h2>{{ $t('loginPage.login') }}</h2>
                <div class="item">
                    <input v-model="username" type="text" required @keyup.enter="login">
                    <label for="username">{{ $t('loginPage.username') }}</label>
                </div>
                <div class="item">
                    <input v-model="password" type="password" required @keyup.enter="login">
                    <label for="password">{{ $t('loginPage.password') }}</label>
                </div>
                <div class="row">
                    <div class="col">
                        <button class="btn btn-light" @click="login">{{ $t('loginPage.submit') }}
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script lang="ts" type="text/typescript">
import { defineComponent } from 'vue'
export default defineComponent({
    name: "Login",
    mounted() {
        this.$store.dispatch("auth/isTokenValid").then(response => {
            if(this.$store.state.auth.status.loggedIn) {
                this.$router.push('/');
            }
        });
    },
    data: function() {
        return {
            username: "",
            password: ""
        }
    },
    methods: {
        login(): void {
            this.$store.dispatch("auth/login", {username: this.username, password: this.password}).then( response => {
                    if(response != null) {
                        let token = JSON.parse(localStorage.getItem('user')!);
                        console.log(token.roles[0].authority);
                        this.$router.push("/");
                    } else {
                        alert("invalid credentials");
                    }
                },
                (error) => {
                    console.log(error);
                    alert("invalid credentials");
                }
            );
        }
    }
});

</script>
