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
<div class="signup-form main-content">
    <div class="text-center container-fluid">
        <h2 class="font-weight-bold display-5 text-dark col">{{ $t("dataDisplay.displayData") }}</h2>
        <div class="row">
            <div class="form-group col">
                <button class="btn btn-secondary" v-on:click="showCaseStudyTypes">{{ $t("dataDisplay.caseStudyTypes") }}</button>
            </div>
            <div class="col">
                <button class="btn btn-secondary" v-on:click="showAllCaseStudies">{{ $t('dataDisplay.allCaseStudies') }}</button>
            </div>
        </div>
        <div v-if="showComponentOne"> 
            <ul class="text-left" style="list-style-type:none;">
                <li v-for="(value) in caseStudyTypes" :key="value">
                    <button class="btn btn-primary"> {{ value }} </button>
                </li>
            </ul>
        </div>
        <div v-else-if="showComponentTwo">
            <div v-for="(p) in photos" :key="p">
                <img :src="p" />
            </div>
            <ul class="text-left">
                <li v-for="(name) in caseStudyAllData" :key="name"> {{name}}</li>
            </ul>
        </div>
    </div>
</div>

</template>

<script lang="ts" type="text/typescript">

import { defineComponent } from 'vue'
export default defineComponent({
    name: "CaseStudyDisplay",
    data: function() {
        return {
            message: "",
            caseStudyTypes: [],
            caseStudyAllData: [],
            photos: [""],
            showComponentOne: false,
            showComponentTwo: false,
            
        };
    },
    mounted() {
        "#v-for-object";
    },
    methods: {
        showCaseStudyTypes() {
            let token = JSON.parse(localStorage.getItem('user')!);
            this.message = "Displaying existing case study data types / Affichage des types de données d'études de cas existants";
            this.showComponentOne = !this.showComponentOne;
            this.showComponentTwo = false;
            this.$axios.get("/api/casestudy/types", {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`,
                }
            }).then(response => {
                // this.caseStudyTypes = JSON.stringify(response.data);
                this.caseStudyTypes = response.data;
                if(response != null) {
                    console.log("getting casestudy types successful");
                } else {
                    alert("no data in case study can be fetched / aucune donnée dans l'étude de cas ne peut être récupérée");
                }
            }).catch((error: any) => {
                this.message =
                    (error.response &&
                    error.response.data &&
                    error.response.data.message) ||
                    error.message;
                
                alert("failed to fetch casestudy data types / échec de la récupération des types de données d'étude de cas");
            });
        },
        showAllCaseStudies() {
            let token = JSON.parse(localStorage.getItem('user')!);
            this.message = "Displaying employee of the month data / Affichage des données de l'employé du mois";
            this.showComponentOne = false;
            this.showComponentTwo = !this.showComponentTwo;
            this.$axios.get("/api/casestudy/entry", {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`,
                }
            }).then(response => {
                this.caseStudyAllData=response.data;
                var d: any;
                for(d in response.data){
                    const obj = response.data[d];
                    if(obj.photo) {
                        this.photos.push("data:" + obj.photoType + ";base64," + obj.photo);
                    }
                }
                console.log(this.photos);
                if(response != null) {
                    console.log("getting casestudy data successful");
                        
                } else {
                    alert("no data in case study can be fetched / aucune donnée dans l'étude de cas ne peut être récupérée");
                }
            }).catch((error: any) => {
                this.message =
                    (error.response &&
                    error.response.data &&
                    error.response.data.message) ||
                    error.message;
                
                alert("failed to fetch casestudy data entries / n'a pas réussi à récupérer les entrées de données de l'étude de cas");
            });
        },
    }
    
});

</script>

