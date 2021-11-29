<style scoped>

    .btn {
    }
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
            <div class="row">
                <div class="form-group col">
                    <button class="btn btn-secondary" v-on:click="showCaseStudyData">Case Study of the Month</button>
                    <!-- <button class="btn btn-secondary" type="radio" id="showCaseStudyQuery" value = "ShowCaseStudyQuery" v-model="dataDisplaySelected" />
                    <label for="showCaseStudyQuery">Case Study of the Month</label> -->
                </div>
                <div class="col">
                    <button class="btn btn-secondary" v-on:click="showEmployeeOfTheMonthData">Employee of the Month</button>
                    <!-- <button class="btn btn-secondary"  type="radio" id="showEmployeeOfTheMonthQuery" value = "ShowEmployeeOfTheMonthQuery" v-model="dataDisplaySelected" />
                    <label for="showEmployeeOfTheMonthQuery">Employee of the Month</label> -->
                </div>
                <div class="col">
                    <button class="btn btn-secondary" v-on:click="showDepartmentData">Department Data Display</button> 
                    <!-- <button class="btn btn-secondary" type="radio" id="showDepartmentDataQuery" value = "ShowDepartmentDataQuery" v-model="dataDisplaySelected" />
                    <label for="showDepartmentDataQuery">Department Data Display</label> -->
                </div>
                <div class="col">
                    <button class="btn btn-secondary" v-on:click="showAllUserData">User Data Display</button> 
                    <!-- <button class="btn btn-secondary" type="radio" id="showDepartmentDataQuery" value = "ShowDepartmentDataQuery" v-model="dataDisplaySelected" />
                    <label for="showDepartmentDataQuery">Department Data Display</label> -->
                </div>
            </div>
            <div>{{ message }}</div>
            <first-component v-if="showComponentOne" />
            <second-component v-else-if="showComponentTwo" />
            <user-data-component v-else-if="showUserDataComponent" />
        </div>
    </div>

</template>

<script lang="ts" type="text/typescript">

import { defineComponent } from 'vue'
import CaseStudyDisplay from "./Data_Output/CaseStudyDisplay.vue";
import DepartmentDataDisplay from "./Data_Output/DepartmentDataDisplay.vue";
import UserDataDisplay from "./Data_Output/UserDataDisplay.vue";
export default defineComponent({
    name: "DataDisplay",
    components: {
        'first-component': CaseStudyDisplay,
        'second-component': DepartmentDataDisplay,
        'user-data-component': UserDataDisplay
    },
    data: function() {
        return {
            message: "",
            showComponentOne: false,
            showComponentTwo: false,
            showUserDataComponent: false,
        };
    },
    methods: {
        showCaseStudyData() {
            this.message = "Displaying case study data";
            this.showComponentOne = !this.showComponentOne;
            this.showComponentTwo = false;
            this.showUserDataComponent = false; 
        },
        showEmployeeOfTheMonthData() {
            this.message = "Displaying employee of the month data to be implemented...";
            this.showComponentOne = false;
            this.showComponentTwo = false;
            this.showUserDataComponent = false; 
        },
        showDepartmentData() {
            this.message = "Displaying department input data";
            this.showComponentOne = false;
            this.showComponentTwo = !this.showComponentTwo;             
        },
        showAllUserData() {
            this.message = "Displaying user data";
            this.showComponentOne = false;
            this.showComponentTwo = false;
            this.showUserDataComponent = !this.showUserDataComponent;
        }
    }
});

</script>

