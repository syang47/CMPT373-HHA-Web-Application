<style>
    .col-md-6{padding-left: 0;}
    .col-md-12 .col-md-6 input{width: 100%;}
</style>

<template>
    <div>
        <div class="container">
			<div class="row">
				<form class="col-md-8 col-lg-offset-2">
					<h5>test</h5>
					<label class="control-label">Test for number</label>
					<input v-model="test" class="form-control" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<br>
					<!-- <label class="control-label">Test for </label>
					<input class="form-control" onKeyUp="value=value.replace(/[^\w\.\/]/ig,'')"> <br> -->
				</form>
			</div>
		</div>
        <div style="text-align:center;"></div>
    </div>
</template>

<script lang="ts">
    import { Vue } from "vue-class-component";
    
    export default class InputData extends Vue {
        test = "";
        $axios: any;
        $router: any;

    //     mounted() {
    //         let tempThis = this;
    //         document.onkeydown = function (e) {
    //             if(e.key == 'Enter'){
    //                 // tempThis.$router.push({path: '/home'})
    //                 tempThis.login();
    //             }
    //         }
    //     };


    //     login(): void{
    //         let tempThis = this;
    //         tempThis.$axios.post('/api/login', {
    //             username: tempThis.username,
    //             password: tempThis.password,
    //         })
    //         .then((response: { data: any; }) => {
    //             console.log(response);
    //             let data = response.data;
    //             localStorage.setItem('username', JSON.stringify(response.data));
    //             tempThis.$router.push('/home')
    //         })
    //         .catch((failResponse: any) => {
    //             console.log(failResponse);
    //         })
    //     };
    }   
</script>