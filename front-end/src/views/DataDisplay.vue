<style scoped>
    .box {
        width: 100%;
        height: 100%;
        position: absolute;
        background: #fff;
        box-sizing: border-box;
        padding: 40px;
    }

</style>

<template>
<div class="main-content">
    <div class="card shadow-none">
        <div class="card-body">
            <div class="card has-bg">
                <div class="card-body">
                <div class="text-center mb-3">
                <h2 class="font-weight-bold display-5 text-dark col">{{ $t("dataDisplay.displayData") }}</h2>
                <div class="row">
                    <div class="form-group col">
                        <button class="btn btn-secondary btn-lg" v-on:click="showCaseStudyData">{{ $t("dataDisplay.caseStudyOTM") }}</button>
                    </div>
                    <div class="col">
                        <button class="btn btn-secondary btn-lg" v-on:click="showEmployeeOfTheMonthData">{{ $t("dataDisplay.employeeOTM") }}</button>
                    </div>
                    <div class="col">
                        <button class="btn btn-secondary btn-lg" v-on:click="showDepartmentData">{{ $t("dataDisplay.departmentDataDisplay") }}</button> 
                    </div>
                    <div class="col">
                        <button class="btn btn-secondary btn-lg" v-on:click="showAllUserData">{{ $t("dataDisplay.userDataDisplay") }}</button> 
                    </div>
                </div>
            </div>
            <b-container class="mt-3">
                <h2 class="text-center text-dark mb-3">{{ message }}</h2>
                <first-component v-if="showComponentOne" />
                <second-component v-else-if="showComponentTwo" />
                <user-data-component v-else-if="showUserDataComponent" />
                <employee-of-the-month v-else-if="showEmployeeOfTheMonthComponent" />
            </b-container>
            </div>
            </div>
        </div>
    </div>
</div>

</template>

<script lang="ts" type="text/typescript">

import { defineComponent } from 'vue'
import CaseStudyDisplay from "./Data_Output/CaseStudyDisplay.vue";
import DepartmentDataDisplay from "./Data_Output/DepartmentDataDisplay.vue";
import UserDataDisplay from "./Data_Output/UserDataDisplay.vue";
import EmployeesOfTheMonths from "./Data_Output/EmployeesOfTheMonths.vue";
export default defineComponent({
    name: "DataDisplay",
    components: {
        'first-component': CaseStudyDisplay,
        'second-component': DepartmentDataDisplay,
        'user-data-component': UserDataDisplay,
        'employee-of-the-month': EmployeesOfTheMonths,
    },
    data: function() {
        return {
            message: "",
            showComponentOne: false,
            showComponentTwo: false,
            showUserDataComponent: false,
            showEmployeeOfTheMonthComponent: false
        };
    },
    methods: {
        showCaseStudyData() {
            this.message = "Displaying case study data / Affichage des données des études de cas";
            this.showComponentOne = !this.showComponentOne;
            this.showComponentTwo = false;
            this.showUserDataComponent = false; 
        },
        showEmployeeOfTheMonthData() {
            this.message = "Displaying employee of the month data to be implemented / Affichage des données de l'employé du mois à mettre en œuvre";
            this.showComponentOne = false;
            this.showComponentTwo = false;
            this.showUserDataComponent = false;
            this.showEmployeeOfTheMonthComponent = !this.showEmployeeOfTheMonthComponent;
        },
        showDepartmentData() {
            this.message = "Displaying department input data / Affichage des données d'entrée du département";
            this.showComponentOne = false;
            this.showComponentTwo = !this.showComponentTwo;
            this.showUserDataComponent = false;
            this.showEmployeeOfTheMonthComponent = false;          
        },
        showAllUserData() {
            this.message = "Displaying user data / Affichage des données utilisateur";
            this.showComponentOne = false;
            this.showComponentTwo = false;
            this.showUserDataComponent = !this.showUserDataComponent;
            this.showEmployeeOfTheMonthComponent = false;   
        }
    }
});

</script>

