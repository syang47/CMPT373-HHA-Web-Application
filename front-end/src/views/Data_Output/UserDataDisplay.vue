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
            <div v-if="showComponentOne"> 
                <table class="table table-bordered table-striped table-hover">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col" v-for="header in tableHeaders" :key="header">{{header}}</th>
                        </tr>
                    </thead>    
                    <tbody>
                        <tr v-for="user in userAllData" :key="user">
                            <td v-for="attribute in user" :key="attribute"> {{attribute}} </td>
                            <td>
                                <button class="btn btn-warning px-2">{{ $t("dataDisplay.edit") }}</button>
                            </td>
                            <td>
                                <button @click="deleteUser(user)" class="btn btn-danger px-2">{{ $t("dataDisplay.delete") }}</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <h3>{{finalmessage}}</h3>
    </div>

</template>

<script lang="ts" type="text/typescript">

import { defineComponent } from 'vue'
export default defineComponent({
    name: "UserDataDisplay",
    data: function() {
        return {
            message: "",
            userAllData: [],
            tableHeaders: [this.$t('dataDisplay.id'), this.$t('dataDisplay.username'), this.$t('dataDisplay.department'), this.$t('dataDisplay.role')],
            showComponentOne: true,
            finalmessage: "",
        };
    },
    mounted() {
        "#v-for-object";
        this.$nextTick(() => {
            this.fetchAllUserData();
        })
    },
    methods: {
        fetchAllUserData() {
            let token = JSON.parse(localStorage.getItem('user')!);
            this.message = "Displaying all user data / Affichage de toutes les données utilisateur";
            
            this.$axios.get("/api/user/all", {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`,
                }
            }).then(response => {
                this.userAllData = response.data;
                if(response != null) {
                    console.log("getting all user data successful");
                } else {
                    alert("no data in user data can be fetched / aucune donnée dans les données utilisateur ne peut être récupérée");
                }
            }).catch((error: any) => {
                this.message =
                    (error.response &&
                    error.response.data &&
                    error.response.data.message) ||
                    error.message;
                
                alert("failed to fetch user data types / échec de la récupération des types de données utilisateur");
            });
        },
        // editUser() {
        //     this.finalmessage = "trying to edit user...";
        // },
        deleteUser(tuple) {
            var id = tuple[0];
            console.log(id);
            console.log(typeof id);
            let token = JSON.parse(localStorage.getItem('user')!);
            this.message = "Displaying all user data / Affichage de toutes les données utilisateur";
            
            this.$axios.delete(`/api/user/delete/${id}`, {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`,
                }
            }).then(response => {
                this.finalmessage = response.data;
                console.log(response.data);
                if(response != null) {
                    console.log("successfully deleted user");
                    this.$nextTick(() => {
                        this.fetchAllUserData();
                    })
                } else {
                    alert("no user was deleted / aucun utilisateur n'a été supprimé");
                }
            }).catch((error: any) => {
                this.message =
                    (error.response &&
                    error.response.data &&
                    error.response.data.message) ||
                    error.message;
                
                alert("error occurred when deleting user / une erreur s'est produite lors de la suppression de l'utilisateur");
            });
        }
        
    }
    
});

</script>

