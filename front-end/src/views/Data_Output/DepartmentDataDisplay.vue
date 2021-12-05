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

<div >
    <div class="text-center">
        <h2 class="font-weight-bold display-5 text-dark col">{{ $t("dataDisplay.displayData") }}</h2>
        <table v-if="showAllListTable" class="table table-bordered table-striped table-hover">
            <thead class="thead-dark">
                <th scope="col" v-for="header in dataListHeaders" :key="header"> {{header}}</th>
            </thead>
            <tbody v-for="data in Object.entries(msppAllData)" :key="data">
                <tr>
                    <td v-for="attribute in data[1]" :key="attribute">
                        {{attribute}}
                    </td>
                    <td>
                        <button @click="showDataDetail(data[1].id)" class="btn btn-info btn-sm">MSPP ONLY</button>
                    </td>
                    <td>
                        <button @click="getCombined(data[1].id)" class="btn btn-info btn-sm">MSPP/ADDITONAL</button>
                    </td>
                    <td v-if="hasPermissions">
                        <button @click="deleteDataEntry(data)" class="btn btn-danger btn-sm">DEL</button>
                    </td>
                </tr>
            </tbody>
        </table>
        <b-container v-if="!showAllListTable" class="text-center" >
            <b-row>
                <b-button pill @click="showAllMsppData" variant="outline-primary" size="sm" align-v="end">Return to Previous</b-button>
            </b-row>
            <b-row>
                <b-table v-if="showMSPPOnly" hover :items="msppOnlyData" :fields="fields">
                </b-table>

                <b-table v-if="showMSPPAddData" hover :items="msppAndAddData" :fields="fields">
                </b-table>
            </b-row>
        </b-container>    
    </div>
    
</div>

</template>

<script lang="ts" type="text/typescript">

import { defineComponent , nextTick} from 'vue'
export default defineComponent({
    name: "DepartmentDataDisplay",
    
    data: function() {
        return {
            showMSPPOnly: false,
            showMSPPAddData: false,
            showAllListTable: true,
            hasPermissions: false,

            msppAllData: {},
            msppOnlyData: [] as any,
            msppAddData: [] as any,
            msppAndAddData: [] as any,

            columnName: [] as any,
            columnKeyValue: [] as any,
            addColumnName: [] as any,
            addColumnKeyValue: [] as any,

            fields: ["name","value"],
            dataListHeaders: ["ID", "Date Submitted", "Department"],
            message:"",
        };
    },
    mounted() {
        "#v-for-object";
        this.$nextTick(() => {
            this.showAllMsppData();
        });        
        let token = JSON.parse(localStorage.getItem('user')!);
        if(token.roles[0].authority == "ROLE_ADMIN" || token.roles[0].authority == "ROLE_HOSPITALADMN"){
            this.hasPermissions = true
        }
    },
    methods: {
        showAllMsppData() {
            this.showAllListTable = true;
            this.showMSPPOnly = false;
            this.showMSPPAddData = false;
            let token = JSON.parse(localStorage.getItem('user')!);
            this.message = "Displaying existing mspp only data / Affichage des données mspp existantes uniquement";
            
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
                alert("failed to fetch department data / n'a pas réussi à récupérer les données du département");
            });
        },
        
        getCombined(id) {
            this.showDataDetail(id);
            this.getAdditionalData(id);
            this.showAllListTable = false;
            this.showMSPPOnly = false;
            this.showMSPPAddData = true;  
        },

        showDataDetail(id) {
            this.showAllListTable = false;
            this.showMSPPOnly = true;
            this.showMSPPAddData = false;
            let colName = [] as any;
            let colKey = [] as any;
            let token = JSON.parse(localStorage.getItem('user')!);
            this.message = "Displaying existing mspp only data by date / Affichage des données mspp existantes uniquement par date";
            this.$axios.get(`/api/mspp/${id}`, {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`,
                }
            }).then(response => {
                this.msppOnlyData = response.data.requiredMSPPData;
                for(var key in this.msppOnlyData ) {
                    colName.push(key);
                    colKey.push(this.msppOnlyData[key]);
                };
                
                const temp = colName.map((name, index) => {
                    return {
                        'name': this.formatDataHeaders(name),
                        'value': colKey[index]
                    }
                });
                this.msppOnlyData = temp;
                this.columnName = colName;
                this.columnKeyValue = colKey;
            }).catch((error: any) => {
                alert("failed to fetch additional data");
            });
        },

        getAdditionalData(id) {
            let token = JSON.parse(localStorage.getItem('user')!);
            
            let colName = [] as any;
            let colKey = [] as any;

            this.message = "Displaying existing additional mspp data";            
            this.$axios.get(`/api/msppadditional/${id}`, {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`,
                }
            }).then(response => {
                this.msppAddData = response.data.additionalMSPPData;
                for(var key in this.msppAddData ) {
                    colName.push(key);
                    colKey.push(this.msppAddData[key]);
                    
                }
                const temp = colName.map((name, index) => {
                    return {
                        'name': this.formatDataHeaders(name),
                        'value': colKey[index]
                    }
                });

                this.msppAddData = temp;
                this.addColumnName = colName;
                this.addColumnKeyValue = colKey;
                this.msppAndAddData = this.msppOnlyData.concat(this.msppAddData);

            }).catch((error: any) => {
                alert("failed to fetch department data by date / n'a pas réussi à récupérer les données du service par date");
            });
        },
        
        deleteDataEntry(entry) {
            let token = JSON.parse(localStorage.getItem('user')!);
            this.$axios.delete("/api/mspp/data/delete", {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`,
                },
                params: {
                    id: entry[0]
                }
            }).then(response => {
                alert(response.data);
                // window.location.reload();      
                this.$nextTick(() => {
                    this.showAllMsppData();
                })                     
            }).catch((error: any) => {                
                alert("error occurred when deleting user");
            });
        },

        formatDataHeaders(str) {
            let str2 = str.replace(/([a-z])([A-Z])/g, '$1 $2').trim().replace(/(\D)(\d)/, '$1 $2');
            str = str2.replace(/([A-Z])([A-Z])([a-z])/g, '$1 $2')
            str = str2.charAt(0).toUpperCase()+str2.slice(1);
            return str;
        }
    }
    
});

</script>

