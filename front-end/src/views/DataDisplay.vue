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
                    <div class="col" v-if="hasPermissions">
                        <button class="btn btn-secondary btn-lg" v-on:click="showAllUserData">{{ $t("dataDisplay.userDataDisplay") }}</button> 
                    </div>
                </div>
            </div>
            <b-container class="mt-3">
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
    mounted() {
        let token = JSON.parse(localStorage.getItem('user')!);
        if(token.roles[0].authority == "ROLE_ADMIN" || token.roles[0].authority == "ROLE_HOSPITALADMN"){
            this.hasPermissions = true
        }
    },
    data: function() {
        return {
            message: "",
            showComponentOne: false,
            showComponentTwo: false,
            showUserDataComponent: false,
            showEmployeeOfTheMonthComponent: false,
            hasPermissions: false
        };
    },
    methods: {
        showCaseStudyData() {
            this.message = "Displaying case study data / Affichage des donn??es des ??tudes de cas";
            this.showComponentOne = !this.showComponentOne;
            this.showComponentTwo = false;
            this.showUserDataComponent = false; 
        },
        showEmployeeOfTheMonthData() {
            this.message = "Displaying employee of the month data to be implemented / Affichage des donn??es de l'employ?? du mois ?? mettre en ??uvre";
            this.showComponentOne = false;
            this.showComponentTwo = false;
            this.showUserDataComponent = false;
            this.showEmployeeOfTheMonthComponent = !this.showEmployeeOfTheMonthComponent;
        },
        showDepartmentData() {
            this.message = "Displaying department input data / Affichage des donn??es d'entr??e du d??partement";
            this.showComponentOne = false;
            this.showComponentTwo = !this.showComponentTwo;
            this.showUserDataComponent = false;
            this.showEmployeeOfTheMonthComponent = false;          
        },
        showAllUserData() {
            this.message = "Displaying user data / Affichage des donn??es utilisateur";
            this.showComponentOne = false;
            this.showComponentTwo = false;
            this.showUserDataComponent = !this.showUserDataComponent;
            this.showEmployeeOfTheMonthComponent = false;   
        }
    }
});

</script>

