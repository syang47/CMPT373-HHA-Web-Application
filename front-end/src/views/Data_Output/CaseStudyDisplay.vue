<template>
    <div class="signup-form text-monospace">
        <div class="text-center container-fluid">
            <h2 class="font-weight-bold display-5 text-dark text-monospace col">Display Data</h2>
            <div class="row">
                <div class="form-group col">
                    <button class="btn btn-secondary" v-on:click="showCaseStudyTypes">Case Study Types</button>
                </div>
                <div class="col">
                    <button class="btn btn-secondary" v-on:click="showAllCaseStudies">All Case Studies</button>
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
            this.message = "Displaying existing case study data types";
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
                    alert("no data in case study can be fetched...");
                }
            }).catch((error: any) => {
                this.message =
                    (error.response &&
                    error.response.data &&
                    error.response.data.message) ||
                    error.message;
                
                alert("failed to fetch casestudy data types");
            });
        },
        showAllCaseStudies() {
            let token = JSON.parse(localStorage.getItem('user')!);
            this.message = "Displaying employee of the month data";
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
                    alert("no data in case study can be fetched...");
                }
            }).catch((error: any) => {
                this.message =
                    (error.response &&
                    error.response.data &&
                    error.response.data.message) ||
                    error.message;
                
                alert("failed to fetch casestudy data entries");
            });
        },
    }
    
});

</script>

<style scoped>
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