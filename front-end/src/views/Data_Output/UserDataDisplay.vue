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

<template>

    <div class="signup-form text-monospace">
        <div class="text-center container-fluid">
            <h2 class="font-weight-bold display-5 text-dark text-monospace col">Display Data</h2>
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
                                <button class="btn btn-warning px-2">Edit</button>
                            </td>
                            <td>
                                <button @click="deleteUser(user)" class="btn btn-danger px-2">Delete</button>
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
                console.log(response.data);
                if(response != null) {
                    console.log("successfully deleted user");
                    this.$nextTick(() => {
                        this.fetchAllUserData();
                    })
                } else {
                    alert("no user was deleted...");
                }
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

