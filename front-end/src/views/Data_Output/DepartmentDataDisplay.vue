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
        <h2 class="font-weight-bold display-5 text-dark col">Display Data</h2>
        <table class="table table-bordered table-striped table-hover">
            <thead class="thead-dark">
                <th scope="col" v-for="header in dataListHeaders" :key="header"> {{header}}</th>
            </thead>
            <tbody v-for="data in Object.entries(msppAllData)" :key="data">
                <tr>
                    <td v-for="attribute in data[1]" :key="attribute">
                        {{attribute}}
                    </td>
                    <td>
                        <button @click="showDataDetail(data[1].id)" class="btn btn-info">View</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
    <div v-if="showMSPPOnly" class="text-center container-fluid">
        <!--<table class="table table-bordered table-striped table-hover">
            <thead class="thead-dark">
                <th scope="col" v-for="header in dataListHeaders" :key="header"> {{header}}</th>
            </thead>
            <tbody>
                <tr v-for="data in msppOnlyData" :key="data">
                    <td v-for="attribute in data" :key="attribute">
                        {{attribute}}
                    </td>
                </tr>
            </tbody>
        </table>-->
        <button class="btn btn-outline-primary justify-content-md-end" @click="getAdditionalData">Additional HHA Data</button>
        <b-table hover :items="msppOnlyData" :fields="fields">
        </b-table>

        <div v-if="showAdditionalData" class="text-center container-fluid">
        <b-table hover :items="msppAddData('1')" :fields="fields">
        </b-table>
        
    </div>
        
    </div>
    
</div>

</template>
s
<script lang="ts" type="text/typescript">

import { defineComponent } from 'vue'
export default defineComponent({
    name: "DepartmentDataDisplay",
    
    data: function() {
        return {
            showMSPPOnly:false,
            showAdditionalData:false,
            message: "",
            msppAllData: {},
            msppOnlyDataObj: {},
            msppOnlyData: [] as any,
            msppAddData: [] as any,
            columnName: [] as any,
            columnKeyValue: [] as any,
            msppAddColumnName: [] as any,
            msppAddColumnKeyValue: [] as any,
            fields: ["name","value"],
            dataListHeaders: ["ID", "Date Submitted", "Department"],

        };
    },
    mounted() {
        "#v-for-object";
        this.showAllMsppData();
    },
    methods: {
        showAllMsppData() {
            let token = JSON.parse(localStorage.getItem('user')!);
            this.message = "Displaying existing mspp only data";            
            this.$axios.get("/api/mspp/data/all", {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`,
                }
            }).then(response => {
                for(var d in response.data) {
                    var ph = '';
                    if(response.data[d][4]) {
                        ph = "data:" + response.data[d][5] + ";base64," + response.data[d][4];
                    } 
                    var obj = {
                        id: response.data[d][0],
                        date: response.data[d][1],
                        department: response.data[d][2],
                    };
                    this.msppAllData[response.data[d][0]] = obj;
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
        
        showDataDetail(id) {
            this.showMSPPOnly = true;
            let token = JSON.parse(localStorage.getItem('user')!);
            this.message = "Displaying existing mspp only data";            
            this.$axios.get(`/api/mspp/${id}`, {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`,
                }
            }).then(response => {
                this.msppOnlyData = response.data.requiredMSPPData;
                for(var key in this.msppOnlyData ) {
                    this.columnName.push(key);
                    this.columnKeyValue.push(this.msppOnlyData[key]);
                };
                const temp = this.columnName.map((name, index) => {
                    return {
                        'name': name,
                        'value': this.columnKeyValue[index]
                    }
                });
                this.msppOnlyData = temp;
            }).catch((error: any) => {
                alert("failed to fetch additional data");
            });
        },

        getAdditionalData(id) {
            console.log("getting additional data");
            this.showAdditionalData = true;
            let token = JSON.parse(localStorage.getItem('user')!);
            this.message = "Displaying existing additional mspp data";            
            this.$axios.get(`/api/msppadditional/${id}`, {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`,
                }
            }).then(response => {
                this.msppAddData = response.data.additionalMSPPData;
                for(var key in this.msppAddData ) {
                    
                    this.msppAddColumnName.push(key);
                    this.msppAddColumnKeyValue.push(this.msppAddData[key]);
                    console.log(this.msppAddColumnName);
                    console.log(this.msppAddColumnKeyValue);
                    
                }
                const temp = this.msppAddColumnName.map((name, index) => {
                    return {
                        'name': name,
                        'value': this.msppAddColumnKeyValue[index]
                    }
                })
                console.log(temp);
                this.msppAddData = temp;
            }).catch((error: any) => {
                this.message =
                    (error.response &&
                    error.response.data &&
                    error.response.data.message) ||
                    error.message;
                alert("failed to fetch department data");
            });
        }

    }
    
});

</script>

