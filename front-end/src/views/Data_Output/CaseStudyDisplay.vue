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
<div>
    <div class="text-center">
        <h2 class="font-weight-bold display-5 text-dark col">{{ $t('dataDisplay.caseStudies') }}</h2>
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
                            <button @click="showCaseStudy(entry)" class="btn btn-info mb-4">{{ $t('dataDisplay.expand') }}</button>
                        </td>
                        <td v-if="hasPermissions">
                            <button @click="setCaseStudyOfTheMonth(entry)" class="btn btn-secondary mb-4">{{ $t('dataDisplay.caseStudyOTM') }}</button>
                        </td>
                        <td v-if="hasPermissions">
                            <button @click="deleteCaseStudy(entry)" class="btn btn-danger mb-4">{{ $t('dataDisplay.delete') }}</button>
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
            tableHeaders: [this.$t('dataDisplay.id'), this.$t('dataDisplay.dateSubmitted'), this.$t('dataDisplay.caseStudyType'), this.$t('dataDisplay.submittedBy')],
            expandedHeaders: [],
            csEntries: [],
            caseStudyAllData: {},
            hasPermissions: false,
        };
    },
    mounted() {
        "#v-for-object";
        this.showAllCaseStudies();
        
        let token = JSON.parse(localStorage.getItem('user')!);
        if(token.roles[0].authority == "ROLE_ADMIN" || token.roles[0].authority == "ROLE_HOSPITALADMN"){
            this.hasPermissions = true
        }
    },
    methods: {
        showAllCaseStudies() {
            let token = JSON.parse(localStorage.getItem('user')!);
            this.$axios.get("/api/casestudy/all", {
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
                alert("failed to fetch casestudy data entries / n'a pas réussi à récupérer les entrées de données de l'étude de cas");
            });
        },

        showCaseStudy(entry) {
            this.caseStudyAllData[entry[0]].showData = !this.caseStudyAllData[entry[0]].showData;
        },

        setCaseStudyOfTheMonth(entry){
            let token = JSON.parse(localStorage.getItem('user')!);
            var months = ['January', 'February', 'March',
               'April', 'May', 'June', 'July',
               'August', 'September', 'October', 'November', 'December'];
            this.$axios.post("/api/casestudy/casestudyofthemonth/submit", {}, {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`
                },
                params: {
                    id: entry[0],
                    month: months[new Date().getMonth()] + " " + new Date().getFullYear()
                }
            }).then(response => {
                alert(response.data);
            });
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
                this.showAllCaseStudies();
            }).catch((error: any) => {                
                alert("error occurred when deleting user / une erreur s'est produite lors de la suppression de l'utilisateur");
            });
        }
    }
    
});

</script>

