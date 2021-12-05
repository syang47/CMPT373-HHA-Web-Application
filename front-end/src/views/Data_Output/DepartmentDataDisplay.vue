<style scoped>
    .box {
        width: 100%;
        height: 100%;
        position: absolute;
        box-sizing: border-box;
        padding: 40px;
    }
    .signup-form{
        width: 1000px;
        margin: 0 auto;
        padding: 50px 0;
        position: relative;
        overflow-y: auto;
        text-align: center;
        margin-bottom: 20px;
    }
    h2{
        color: #636363;
        margin: 0 0 15px;
        position: relative;
        text-align: center;
    }
</style>

<template>

    <div>
        <div class="text-center">
            <h2 class="font-weight-bold display-5 text-dark col">{{ $t("dataDisplay.displayData") }}</h2>
            <div class="row">
                <div class="form-group col">
                    <button class="btn btn-secondary" v-on:click="switch_msppAll">{{ $t("dataDisplay.allDepartmentMSPPData") }}</button>
                </div>
                <div class="form-group col">
                    <button class="btn btn-secondary" v-on:click="switch_msppAllDate">{{ $t("dataDisplay.MSPPDataListByDates") }}</button>
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
                            <th scope="col">{{ $t("dataDisplay.dataType") }}</th>
                            <th scope="col">{{ $t("dataDisplay.dataValue") }}</th>
                        </tr>
                    </thead>    
                    <tr>

                        <th scope="row">{{ $t("dataDisplay.dateSubmitted") }}</th>
                        <td>{{name.dateSubmitted}}</td>
                    </tr>
                    <tr>
                        <th scope="row">{{ $t("msppData.bedsAvailable") }}</th>
                        <td>{{name.bedsAvailable}}</td>
                    </tr>
                    <tr>
                        <th scope="row">{{ $t("msppData.bedDays") }}</th>
                        <td>{{name.bedDays}}</td>
                    </tr>
                    <tr>
                        <th scope="row">{{ $t("msppData.patientDays") }}</th>
                        <td>{{name.patientDays}}</td>
                    </tr>
                    <tr>
                        <th scope="row">{{ $t("msppData.hospitalised") }}</th>
                        <td>{{name.hospitalized}}</td>
                    </tr>
                    <tr>
                        <th scope="row">{{ $t("msppData.dischargedAlive") }}</th>
                        <td>{{name.dischargedAlive}}</td>
                    </tr>
                    <tr>
                        <th scope="row">{{ $t("msppData.diedBefore48h") }}</th>
                        <td>{{name.diedBefore48h}}</td>
                    </tr>
                    <tr>
                        <th scope="row">{{ $t("msppData.diedAfter48h") }}</th>
                        <td>{{name.diedAfter48h}}</td>
                    </tr>
                    <tr>
                        <th scope="row">{{ $t("msppData.daysHospitalised") }}</th>
                        <td>{{name.daysHospitalised}}</td>
                    </tr>
                    <tr>
                        <th scope="row">{{ $t("msppData.referrals") }}</th>
                        <td>{{name.referrals}}</td>
                    </tr>
                    <tr>
                        <th scope="row">{{ $t("msppData.transfers") }}</th>
                        <td>{{name.transfers}}</td>
                    </tr>
                    <tr>
                        <th scope="row">{{ $t("msppData.selfDischarged") }}</th>
                        <td>{{name.selfDischarged}}</td>
                    </tr>
                    <tr>
                        <th scope="row">{{ $t("msppData.stayedInTheWard") }}</th>
                        <td>{{name.stayedInTheWard}}</td>
                    </tr>
                    <tr>
                        <th scope="row">{{ $t("msppData.admissions") }}</th>
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
            this.message = "Displaying existing mspp only data / Affichage des données mspp existantes uniquement";
            
            this.$axios.get("/api/mspp/data", {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`,
                }
            }).then(response => {
                this.msppAllData = response.data;
                if(response != null) {
                    console.log("getting department data successful");
                } else {
                    alert("no data in mspp data can be fetched / aucune donnée dans mspp ne peut être récupérée");
                }
            }).catch((error: any) => {
                this.message =
                    (error.response &&
                    error.response.data &&
                    error.response.data.message) ||
                    error.message;
                
                alert("failed to fetch department data / n'a pas réussi à récupérer les données du département");
            });
        },
        querySelectedDate(id, datedate) {
            let token = JSON.parse(localStorage.getItem('user')!);
            this.message = "Displaying existing mspp only data by date / Affichage des données mspp existantes uniquement par date";
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
                    alert("no data in mspp can be fetched / aucune donnée dans mspp ne peut être récupérée");
                }
            }).catch((error: any) => {
                this.message =
                    (error.response &&
                    error.response.data &&
                    error.response.data.message) ||
                    error.message;
                
                alert("failed to fetch department data by date / n'a pas réussi à récupérer les données du service par date");
            });
        }
        
    }
    
});

</script>

