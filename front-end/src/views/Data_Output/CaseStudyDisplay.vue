<style scoped>

    .signup-form{
        width: 1000px;
        margin: 0 auto;
        padding: 50px 0;
        position: relative;
        overflow-y: auto;
        text-align: center;
        margin-bottom: 20px;
    }
    h1, h2{
        font-family: "Arial";
        font-weight: bold;
        text-align: center;
    }
    .box {
        width: 100%;
        height: 100%;
        background: #00000060;
        box-sizing: border-box;
        display: block;
        padding: 40px;
    }
</style>

<template>
<div class="signup-form main-content">
    <div class="text-center container-fluid">
        <h2 class="font-weight-bold display-5 text-dark col">Case Studies</h2>
        <div> 
            <table class="table table-bordered table-striped table-hover">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col" v-for="header in tableHeaders" :key="header">{{header}}</th>
                    </tr>
                </thead>    
                <tbody v-for="entry in caseStudyAllData" :key="entry">
                    <tr>
                        <td v-for="attribute in entry" :key="attribute">
                            <div>
                                {{attribute}} 
                            </div> 
                        </td>
                        <td>
                            <button @click="showCaseStudy(entry)" class="btn btn-info">Expand</button>
                        </td>
                        <td>
                            <button @click="deleteCaseStudy(entry)" class="btn btn-danger">Delete</button>
                        </td>

                    </tr>
                    <tr v-if="showData[entry[0] - 1]">
                        <td class="container" colspan=6>
                            <div class="row">
                                <div class="card w-25" v-for="ad in Object.entries(caseStudyExpandedData[entry[0] - 1])" :key="ad">
                                    <div class="col-auto">
                                        <h1 class="card-title text-primary"> {{ad[0]}} </h1>
                                        <p class="card-text"> {{ad[1]}}</p>
                                    </div>
                                </div>
                                <div>
                                    <img :src="photos[entry[0] - 1]" />
                                </div>
                            </div>
                            
                        </td>
                    </tr>
                </tbody>
            </table>
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
            tableHeaders: ["ID", "Date Submitted", "Case Study Type", "Submitted By"],
            expandedHeaders: [],
            caseStudyAllData: [] as any,
            photos: [] as any,
            caseStudyExpandedData: [] as any,
            showData: [] as any
        };
    },
    mounted() {
        this.showAllCaseStudies();
    },
    methods: {
        showAllCaseStudies() {
            let token = JSON.parse(localStorage.getItem('user')!);
            this.$axios.get("/api/casestudy/entry", {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`,
                }
            }).then(response => {                
                for(var d in response.data){
                    var obj = response.data[d];
                    if(obj[4]) {
                        this.photos.push("data:" + obj[5] + ";base64," + obj[4]);
                    }
                    this.caseStudyExpandedData.push(obj[6]);
                    obj = obj.slice(0, 4);
                    this.caseStudyAllData.push(obj);
                    this.showData.push(false);
                }
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

        showCaseStudy(entry){
            this.showData[entry[0] - 1] = !this.showData[entry[0] - 1];
        },

        deleteCaseStudy(entry){
            let token = JSON.parse(localStorage.getItem('user')!);
            this.message = "Displaying all user data";
            
            this.$axios.delete("/api/casestudy/delete", {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`,
                },
                params: {
                    id: entry[0]
                }
            }).then(response => {
                alert(response.data);
            }).catch((error: any) => {
                this.message =
                    (error.response &&
                    error.response.data &&
                    error.response.data.message) ||
                    error.message;
                
                alert("error occurred when deleting user");
            });
        }
    }
    
});

</script>

