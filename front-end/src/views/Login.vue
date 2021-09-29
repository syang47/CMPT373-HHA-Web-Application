<style>
    .background {
        background: url('../assets/Isaac CBR Manager.jpeg') no-repeat;
        /* filter:"progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale')"; */
        /* -moz-background-size:100% 100%; */
        background-size:100% 100%;
        position: fixed;
        /* background-size: 100% 100%; */
        height: 100%;
        position: fixed;
        width: 100%;    
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
        position: fixed;
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
        color: #fff;
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
        color: #c6fafe;
        position:relative;
        overflow: hidden;
        text-transform: uppercase;
        letter-spacing: 2px;
    }
    .btn:hover{
        border-radius: 5px;
        color: #fff;
        box-shadow: 0 0 5px 0 #c6fafe,
        0 0 25px 0 #c6fafe,
        0 0 50px 0 #c6fafe,
        0 0 100px 0 #c6fafe;
    }
</style>

<template>
    <div class="background">
    </div>
    <div class="page">
        <div class="box">
            <h2>Login</h2>
            <div class="item">
                <input v-model="username" type="text" required>
                <label for="">UserName</label>
            </div>
            <div class="item">
                <input v-model="password" type="password" required>
                <label for="">PassWord</label>
            </div>
            <button class="btn" @click="login">submit
                <span></span>
                <span></span>
                <span></span>
                <span></span>
            </button>
        </div>
    </div>
</template>

<script lang="ts">
    import { Vue } from "vue-class-component";
    import {LoginInfo} from "../models/LoginInfo";
    
    export default class Login extends Vue {
        username = '';
        password = '';

        mounted() {
            let tempThis = this;
            document.onkeydown = function (e) {
                if(e.key == 'Enter'){
                    // tempThis.$router.push({path: '/home'})
                    tempThis.login();
                }
            }
        };
        

        login(): void{
            let tempThis = this;
            tempThis.$axios.post('/login', {
                username: tempThis.username,
                password: tempThis.password,
            })
            .then(response => {
                console.log(response);
                let data = response.data;
                // tempThis.$router.push({path: '/home'})
                  if (data.code != 404) {
                      tempThis.$router.push({path: '/home'})
                  }
            })
            .catch(failResponse => {
                console.log(failResponse);
            })
        };
    }

</script>
