<style>
    .col-md-6{padding-left: 0;}
    .col-md-12 .col-md-6 input{width: 100%;}
</style>

<template>
    <div>
        <div class="container">
			<div class="row">
				<form class="col">
                    <!-- TODO: need to fix: can't display the h1 text -->
					<h1>NICUPaeds data input</h1>
					<label class="control-label">Beds available</label>
					<input v-model="msppRequirement.bedsAvailable" class="form-control" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<br>
                    <label class="control-label">Bed days</label>
					<input v-model="msppRequirement.bedDays" class="form-control" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<br>
                    <label class="control-label">Patient days</label>
					<input v-model="msppRequirement.patientDays" class="form-control" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<br>
                    <label class="control-label">Hospitalized</label>
					<input v-model="msppRequirement.hospitalized" class="form-control" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<br>
                    <label class="control-label">Discharged alive</label>
					<input v-model="msppRequirement.dischargedAlive" class="form-control" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<br>
                    <label class="control-label">Died before 48h</label>
					<input v-model="msppRequirement.diedBefore48h" class="form-control" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<br>
                    <label class="control-label">Died after 48h</label>
					<input v-model="msppRequirement.diedAfter48h" class="form-control" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<br>
                    <label class="control-label">Days hospitalised</label>
					<input v-model="msppRequirement.daysHospitalised" class="form-control" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<br>
                    <label class="control-label">Referrals</label>
					<input v-model="msppRequirement.referrals" class="form-control" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<br>
                    <label class="control-label">Transfers</label>
					<input v-model="msppRequirement.transfers" class="form-control" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<br>
                    <label class="control-label">Self-discharged</label>
					<input v-model="msppRequirement.selfDischarged" class="form-control" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<br>
                    <label class="control-label">Stayed in the ward</label>
					<input v-model="msppRequirement.stayedInTheWard" class="form-control" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<br>
                    <label class="control-label">Admissions</label>
					<input v-model="msppRequirement.admissions" class="form-control" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<br>
                    
					<!-- <label class="control-label">Test for letter and number</label>
                    <input class="form-control" onKeyUp="value=value.replace(/[^\w\.\/]/ig,'')"> <br> -->
                    <button class="btn btn-primary" @click="submitData">Submit</button>
                </form>
			</div>
		</div>
        <div style="text-align:center;"></div>
    </div>
</template>

<script lang="ts">
    import { Vue } from "vue-class-component";
    import { MSPPRequirement } from "../../models/MSPPRequirement"
    
    export default class InputData extends Vue {
        msppRequirement: MSPPRequirement = new MSPPRequirement();
        $axios: any;
        $router: any;

        mounted() {
            let tempThis = this;
            document.onkeydown = function (e) {
                if(e.key == 'Enter'){
                    // tempThis.$router.push("/nicu_paed");
                    tempThis.submitData();
                }
            }
        };


        submitData(): void {
            this.$router.push("/nicu_paed");
            // TODO: need an interface from back-end
            // let tempThis = this;
            // tempThis.$axios.post("/nicu_paed/inputdata", tempThis.msppRequirement)
            // .then(response => {
            //     console.log(response);
            //     let data = response.data;
            //     tempThis.$router.push("/nicu_paed");
            //     if (data.code == 200) {
            //         // TODO: Add a dialog to let the user know data submits successfully
            //         setTimeout(() => {
            //             tempThis.$router.push("/nicu_paed");
            //         }, 3000)
            //     } 
            // })
            // .catch((failResponse: any) => {
            //     console.log(failResponse);
            // })
        };
    }   
</script>