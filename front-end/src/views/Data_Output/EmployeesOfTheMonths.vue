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
            <h2 class="font-weight-bold display-5 text-dark col">Display All Employees Of The Months</h2>
            <div> 
                <table class="table table-bordered table-striped table-hover">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col" v-for="header in tableHeaders" :key="header">{{header}}</th>
                        </tr>
                    </thead>    
                    <tbody>
                        <tr v-for="user in allEmployeesOfTheMonths" :key="user">
                            <td v-for="attribute in user" :key="attribute"> {{attribute}} </td>
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
    name: "EmployeesOfTheMonths",
    data: function() {
        return {
            message: "",
            allEmployeesOfTheMonths: [],
            tableHeaders: ["USERNAME", "DEPARTMENT", "MONTH"],
            finalmessage: "",
            hasPermissions: false
        };
    },
    mounted() {
        this.getAllEmployeesOfTheMonths();
    },
    methods: {
        getAllEmployeesOfTheMonths(): void {
            let token = JSON.parse(localStorage.getItem('user')!);
            this.$axios.get("/api/user/allemployeesofthemonths", {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`
                },
            }).then(response => {
                this.allEmployeesOfTheMonths = response.data;
            });
        }
    }
});

</script>