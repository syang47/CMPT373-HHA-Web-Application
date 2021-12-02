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
    p{
        font-family: "Arial";
        font-weight: normal;
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
                <tbody v-for="entry in Object.entries(caseStudyAllData)" :key="entry">
                    <tr>
                        <td>
                            <div>
                                {{entry[1].id}}
                            </div>
                        </td>
                        <td>
                            <div>
                                {{entry[1].date}}
                            </div>
                        </td>
                        <td>
                            <div>
                                {{entry[1].csType}}
                            </div>
                        </td>
                        <td>
                            <div>
                                {{entry[1].username}}
                            </div>
                        </td>
                        <td>
                            <button @click="showCaseStudy(entry)" class="btn btn-info">Expand</button>
                        </td>
                        <td v-if="hasPermissions">
                            <button @click="deleteCaseStudy(entry)" class="btn btn-danger">Delete</button>
                        </td>
                    </tr>
                    <tr v-if="entry[1].showData">
                        <td class="container" colspan=6>
                            <div class="row">
                                <div class="card w-25" v-for="ad in Object.entries(entry[1].additionalData)" :key="ad">
                                    <div class="col-auto">
                                        <h1 class="card-title text-primary"> {{ad[0]}} </h1>
                                        <div class="card-body"> 
                                            <p>{{ad[1]}}</p>
                                        </div>
                                    </div>
                                </div>
                                <div v-if="entry[1].photo != ''">
                                    <img :src="entry[1].photo" />
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
            tableHeaders: ["ID", "Date Submitted", "Case Study Type", "Submitted By"],
            expandedHeaders: [],
            csEntries: [],
            caseStudyAllData: {},
            hasPermissions: false
        };
    },
    mounted() {
        "#v-for-object";
        this.$nextTick(() => {
            this.showAllCaseStudies();
        })
        let token = JSON.parse(localStorage.getItem('user')!);
        if(token.roles[0].authority == "ROLE_ADMIN" || token.roles[0].authority == "ROLE_HOSPITALADMN"){
            this.hasPermissions = true
        }
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
                    var ph = '';
                    if(response.data[d][4]) {
                        ph = "data:" + response.data[d][5] + ";base64," + response.data[d][4];
                    } 
                    var obj = {
                        id: response.data[d][0],
                        date: response.data[d][1],
                        csType: response.data[d][2],
                        username: response.data[d][3],
                        photo: ph,
                        additionalData: response.data[d][6],
                        showData: false
                    };
                    this.caseStudyAllData[response.data[d][0]] = obj;
                }
            }).catch((error: any) => {
                alert("failed to fetch casestudy data entries");
            });
        },

        showCaseStudy(entry) {
            this.caseStudyAllData[entry[0]].showData = !this.caseStudyAllData[entry[0]].showData;
        },

        deleteCaseStudy(entry){
            let token = JSON.parse(localStorage.getItem('user')!);

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
                alert("error occurred when deleting user");
            });
        }
    }
    
});

</script>

