<style>
    .col-md-6{padding-left: 0;}
    .col-md-12 .col-md-6 input{width: 100%;}
</style>

<template>
    <div>
        <div class="container">
			<div class="row">
				<form class="col-md-8 col-lg-offset-2">
					<h2>NICUPaeds data input</h2>
					<label class="control-label">Beds available</label>
					<input v-model="test1" class="form-control" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<br>
                    <label class="control-label">Beds days</label>
					<input v-model="test2" class="form-control" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<br>
                    <label class="control-label">Patient days</label>
					<input v-model="test3" class="form-control" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<br>
                    <label class="control-label">Hospitalized</label>
					<input v-model="test4" class="form-control" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<br>
                    <label class="control-label">Discharged alive</label>
					<input v-model="test5" class="form-control" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<br>
                    <label class="control-label">Died before 48h</label>
					<input v-model="test6" class="form-control" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<br>
                    <label class="control-label">Died after 48h</label>
					<input v-model="test7" class="form-control" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<br>
                    <label class="control-label">Days hospitalised</label>
					<input v-model="test8" class="form-control" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<br>
                    <label class="control-label">Referrals</label>
					<input v-model="test9" class="form-control" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<br>
                    <label class="control-label">Transfers</label>
					<input v-model="test10" class="form-control" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<br>
                    <label class="control-label">Self-discharged</label>
					<input v-model="test11" class="form-control" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<br>
                    <label class="control-label">Stayed in the ward</label>
					<input v-model="test12" class="form-control" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<br>
                    <label class="control-label">Admissions</label>
					<input v-model="test13" class="form-control" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<br>
                    
					<!-- <label class="control-label">Test for letter and number</label>
                    <input class="form-control" onKeyUp="value=value.replace(/[^\w\.\/]/ig,'')"> <br> -->
                    <button type="button" class="btn btn-primary">Submit</button>
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