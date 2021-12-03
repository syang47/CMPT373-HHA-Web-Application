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
            <div>
                <table class="table table-bordered table-striped table-hover">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col" v-for="header in tableHeaders" :key="header">{{header}}</th>
                        </tr>
                    </thead>    
                    <tbody>
                        <tr v-for="user in userAllData" :key="user">
                            <td v-for="attribute in user" :key="attribute"> {{attribute}} </td>

                            <td v-if="hasPermissions">
                                <button @click="setEmployeeOfTheMonth(user)" class="btn btn-secondary">Set Employee Of The Month</button>
                            </td>
                            <!-- <td>
                                <button class="btn btn-warning px-2">Edit</button>
                            </td> -->
                            <td v-if="hasPermissions">
                                <button @click="deleteUser(user)" class="btn btn-danger">Delete</button>
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
            tableHeaders: ["ID", "USERNAME", "DEPARTMENT", "ROLE"],
            finalmessage: "",
            hasPermissions: false
        };
    },
    mounted() {
        "#v-for-object";
        this.$nextTick(() => {
            this.fetchAllUserData();
        })
        let token = JSON.parse(localStorage.getItem('user')!);
        if(token.roles[0].authority == "ROLE_ADMIN" || token.roles[0].authority == "ROLE_HOSPITALADMN"){
            this.hasPermissions = true
        }
    },
    methods: {
        fetchAllUserData() {
            let token = JSON.parse(localStorage.getItem('user')!);
            this.message = "Displaying all user data";
            
            this.$axios.get("/api/user/all", {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`,
                }
            }).then(response => {
                this.userAllData = response.data;
                if(response != null) {
                    console.log("getting all user data successful");
                } else {
                    alert("no data in user data can be fetched...");
                }
            }).catch((error: any) => {
                this.message =
                    (error.response &&
                    error.response.data &&
                    error.response.data.message) ||
                    error.message;
                
                alert("failed to fetch user data types");
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
            this.message = "Displaying all user data";
            
            this.$axios.delete(`/api/user/delete/${id}`, {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`,
                }
            }).then(response => {
                this.finalmessage = response.data;
                alert("user was deleted");
                this.$nextTick(() => {
                    this.fetchAllUserData();
                })
            }).catch((error: any) => {
                this.message =
                    (error.response &&
                    error.response.data &&
                    error.response.data.message) ||
                    error.message;
                
                alert("error occurred when deleting user");
            });
        },

        setEmployeeOfTheMonth(user){
            let token = JSON.parse(localStorage.getItem('user')!);
            var months = ['January', 'February', 'March',
               'April', 'May', 'June', 'July',
               'August', 'September', 'October', 'November', 'December'];
            this.$axios.post("/api/user/employeeofthemonth/submit", {}, {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`
                },
                params: {
                    userId: user[0],
                    month: months[new Date().getMonth()] + " " + new Date().getFullYear()
                }
            }).then(response => {
                alert(response.data);
            });
        },
        
    }
    
});

</script>

