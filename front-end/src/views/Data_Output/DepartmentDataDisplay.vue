<template>
    <div class="signup-form text-monospace">
        <div class="text-center container-fluid">
            <h2 class="font-weight-bold display-5 text-dark text-monospace col">Display Data</h2>
            <div class="row">
                <div class="form-group col">
                    <button class="btn btn-secondary" v-on:click="switch_msppAll">All Department's MSPP Data</button>
                </div>
                <div class="form-group col">
                    <button class="btn btn-secondary" v-on:click="switch_msppAllDate">MSPP Data List By Dates</button>
                </div>
            </div>
            <div v-if="showAllMspp"> 
                <ul class="text-left">
                    <li v-for="(name) in msppAllData" :key="name"> {{ name }}</li>
                </ul>
            </div>
            <div v-else-if="showAllMsppDate">
                <ul class="text-left" style="list-style-type:none;">
                    <li v-for="(value, name) in msppAllData" :key="name">
                        <button class="btn btn-primary" v-on:click="querySelectedDate(value.id, value.dateSubmitted)">
                        {{ value.id }}-{{ value.dateSubmitted }}</button>
                    </li>
                </ul>
            </div> 
            <div v-if="showSelectedMsppByDate"> 
                <table class="table table-bordered table-striped table-hover" v-for="(name) in selectedMsppDataByDate" :key="name">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">Data Type</th>
                            <th scope="col">Data Value</th>
                        </tr>
                    </thead>    
                    <tr>

                        <th scope="row">Date Submitted</th>
                        <td>{{name.dateSubmitted}}</td>
                    </tr>
                    <tr>
                        <th scope="row">Beds Available</th>
                        <td>{{name.bedsAvailable}}</td>
                    </tr>
                    <tr>
                        <th scope="row">Bed Days</th>
                        <td>{{name.bedDays}}</td>
                    </tr>
                    <tr>
                        <th scope="row">Patient Days</th>
                        <td>{{name.patientDays}}</td>
                    </tr>
                    <tr>
                        <th scope="row">Hospitalized</th>
                        <td>{{name.hospitalized}}</td>
                    </tr>
                    <tr>
                        <th scope="row">Discharged Alive</th>
                        <td>{{name.dischargedAlive}}</td>
                    </tr>
                    <tr>
                        <th scope="row">Died Before 48h</th>
                        <td>{{name.diedBefore48h}}</td>
                    </tr>
                    <tr>
                        <th scope="row">Died After 48h</th>
                        <td>{{name.diedAfter48h}}</td>
                    </tr>
                    <tr>
                        <th scope="row">Days Hospitalised</th>
                        <td>{{name.daysHospitalised}}</td>
                    </tr>
                    <tr>
                        <th scope="row">Referrals</th>
                        <td>{{name.referrals}}</td>
                    </tr>
                    <tr>
                        <th scope="row">Transfers</th>
                        <td>{{name.transfers}}</td>
                    </tr>
                    <tr>
                        <th scope="row">Self Discharged</th>
                        <td>{{name.selfDischarged}}</td>
                    </tr>
                    <tr>
                        <th scope="row">StayedInTheWard</th>
                        <td>{{name.stayedInTheWard}}</td>
                    </tr>
                    <tr>
                        <th scope="row">Admissions</th>
                        <td>{{name.admissions}}</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</template>

<script lang="ts" type="text/typescript">
import { defineComponent } from 'vue'

export default defineComponent({
    name: "DepartmentDataDisplay",
    
    data: function() {
        return {
            message: "",
            msppAllData: [],
            msppAllDataDate: [],
            selectedMsppDataByDate: [],
            showAllMspp: false,
            showAllMsppDate: false,     
            showSelectedMsppByDate: false      
        };
    },
    mounted() {
        "#v-for-object";
    },
    methods: {
        switch_msppAll() {
            this.showAllMspp = true;
            this.showAllMsppDate = false;
            this.showSelectedMsppByDate = false;
            this.showAllMsppData();
        },
        switch_msppAllDate() {
            this.showAllMspp = false;
            this.showAllMsppDate = true;
            this.showSelectedMsppByDate = false;
            this.showAllMsppData();
            console.log("getting date only")
        },
        showAllMsppData() {
            let token = JSON.parse(localStorage.getItem('user')!);
            this.message = "Displaying existing mspp only data";
            
            this.$axios.get("/api/mspp/data", {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`,
                }
            }).then(response => {
                this.msppAllData = response.data;
                if(response != null) {
                    console.log("getting department data successful");
                } else {
                    alert("no data in mspp data can be fetched...");
                }
            }).catch((error: any) => {
                this.message =
                    (error.response &&
                    error.response.data &&
                    error.response.data.message) ||
                    error.message;
                
                alert("failed to fetch department data");
            });
        },
        querySelectedDate(id, datedate) {
            let token = JSON.parse(localStorage.getItem('user')!);
            this.message = "Displaying existing mspp only data by date";
            this.showSelectedMsppByDate = true;
            this.$axios.get(`/api/mspp/data/${datedate}/${id}`, {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`,
                }
            }).then(response => {
                this.selectedMsppDataByDate = response.data;
                // let temp = JSON.stringify(response.data);
                // temp = temp.replace("[","").replace("{","").replace("}","").replace("}","");
                // let dataToArray = temp.split(',').map(item=>item.trim());
                // console.log(dataToArray);
                // this.selectedMsppDataByDate=dataToArray.join("\n");

                if(response != null) {                    
                    console.log("getting deparment data by date successful");
                } else {
                    alert("no data in mspp can be fetched...");
                }
            }).catch((error: any) => {
                this.message =
                    (error.response &&
                    error.response.data &&
                    error.response.data.message) ||
                    error.message;
                
                alert("failed to fetch department data by date");
            });
        }
        
    }
    
});

</script>

<style scoped>
    .btn {
    }
    .box {
        width: 100%;
        height: 100%;
        background: #00000060;
        position: absolute;
        box-sizing: border-box;
        padding: 40px;
    }
    .form-control{
        height: 40px;
        box-shadow: none;
        color: #969fa4;
    }
    .form-control:focus{
        border-color: #5cb85c;
    }
    .signup-form{
        width: 1000px;
        margin: 0 auto;
        padding: 50px 0;
        position: relative;
        overflow-y: auto;
    }
    .signup-form h2{
        color: #636363;
        margin: 0 0 15px;
        position: relative;
        text-align: center;
    }
    .signup-form .form-group{
        margin-bottom: 20px;
    }
</style>