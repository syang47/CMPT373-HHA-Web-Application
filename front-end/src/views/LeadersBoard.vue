
<style scoped>


.btn:hover {
  border-radius: 10px;
  color: #fff;
  box-shadow: 0 0 5px 0 #c6fafe, 0 0 25px 0 #c6fafe, 0 0 50px 0 #c6fafe,
    0 0 100px 0 #c6fafe;
}

@import url('https://fonts.googleapis.com/css?family=Rubik:300,400,500');

body {
  border-top: 4px solid #DC0000;
  background: #15151E;
  color: #fff;
  font-family: 'Rubik', sans-serif;
  /* center the table horizontally */
  display: flex;
  flex-direction: column;
  align-items: center;
}

table {
  width: calc(90vw - 2rem);
  max-width: 500px;
  border-spacing: 0 1rem;
}

table tr > * {
  text-align: center;
  padding: 0.5rem;
}

table tr > *:nth-child(2) {
  text-align: left;
}

table th {
  font-weight: 3;
  letter-spacing: 0.04rem;
  font-size: 0.9rem;
  color: #000000;
}

table td.gap span {
  background: #38383F;
  border-radius: 30px;
  padding: 0.5rem 0.75rem;
  font-size: 0.8rem;
  text-transform: uppercase;
}

@media (max-width: 500px) {
  table tr > *:nth-child(3) {
    display: none;
  }
}

.min-100vh{
    min-height: 100vh;
}
.bg-none{
    background-color: transparent;
}

</style>

<template>

<div class="main-content has-bg min-100vh">
    <div class="main-wrapper">
    <div class="card shadow-none bg-none">
        <div class="card-body">
            <div class="card has-bg">
                <div class="card-body">
                    <div class="container-fluid">
                <h1 class="display-2 text-center text-dark">{{ $t('leaderBoard.leaderBoard') }}</h1>
                <button v-if="hasPermissions" class="btn btn-secondary" @click="goToAddAnnouncement"> {{$t("announcementPage.addAnnouncement")}} </button>
                <div class="container-fluid">
                    <div class="row">
                        <div class="col" v-if="MonthlyPrize.length != 0">
                                <div class="card shadow-none rounded text-left text-white mb-3 mt-3" style="background: lightblue;">
                                    <div class="card-body">
                                        <h2 style="color:#000000;" class="card-title w-70">{{ $t('leaderBoard.monthlyAward') }}</h2>
                                        <table class="mx-auto table table-bordered table-striped table-hover">
                                            <tbody>
                                                <tr v-for="field in MonthlyPrize" :key="field">
                                                    <td>
                                                        <div class="mb-3">
                                                            <h3 class="fw-light mb-3">
                                                                Posted On {{field[1]}} for {{field[2]}}
                                                            </h3>
                                                            <p class="fw-light">
                                                                {{field[5]}}
                                                            </p>
                                                        </div>
                                                        <div class="mb-3" v-if="field[3]">
                                                            <img :src="'data:' + field[3] + ';base64,' + field[4]" />
                                                        </div>
                                                        <button v-if="hasPermissions" class="btn btn-danger" @click="deleteMonthlyAnnouncement(field)"> {{$t("announcementPage.deleteAnnouncement")}} </button>
                                                
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                        </div>
                        <div class="col" v-if="employeeofthemonth.length != 0">
                            <div class="card shadow-none w-100 text-left text-white mb-3 mt-3" style="background:#C0C0C0;">
                                <div class="card-body">
                                    <h2 style="color:#000000;" class="card-title w-40">{{$t('dataDisplay.employeeOTM')}}</h2>
                                    <div class="justify-content-center">
                                        <table class="mx-auto table table-bordered table-striped table-hover">
                                            <tbody>
                                                <tr v-for="field in employeeofthemonth" :key="field">
                                                    <td>
                                                        {{field}}
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="row-6 rounded-left">
                                <div class="card shadow-none rounded text-center text-white mb-3 mt-3" style="background:#7fffd4">
                                    <div class="card-body">
                                        <div class="row justify-content-center">
                                            <div class="col-auto">
                                                <table class="table table-bordered table-striped table-hover">
                                                    <thead>
                                                        <tr>
                                                            <th>{{ $t('leaderBoard.position') }}</th>
                                                            <th>{{ $t('leaderBoard.department') }}</th>
                                                            <th>{{ $t('leaderBoard.points') }}</th>
                                                            <th>{{ $t('leaderBoard.reportsSubmittedMonth') }}</th>
                                                            <th>{{ $t('leaderBoard.reportsSubmittedYear') }}</th>

                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr v-for="(points, dep, index) in departmentPoints" :key="index">
                                                            <th>{{ index + 1 }}</th>
                                                            <td>{{ dep }}</td>
                                                            <td>{{ points }}</td>
                                                            <td v-if="msppReportsSubmittedMonthAndYear[dep] && caseStudyReportsSubmittedMonthAndYear[dep]">{{ msppReportsSubmittedMonthAndYear[dep][0] + caseStudyReportsSubmittedMonthAndYear[dep][0] }}</td>
                                                            <td v-if="msppReportsSubmittedMonthAndYear[dep] && caseStudyReportsSubmittedMonthAndYear[dep]">{{ msppReportsSubmittedMonthAndYear[dep][1] + caseStudyReportsSubmittedMonthAndYear[dep][1] }}</td>
                                                            
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div v-if="caseStudyOfTheMonth.length != 0" class="col rounded mb-3 mt-3" style="background: #F59A23">
                            <div class="card shadow-none w-100 text-center text-white mb-3 mt-3 " style="background: #F59A23; height:93%">
                                <div class="card-body">
                                    <h2 style="color:#000000;">{{ $t('leaderBoard.caseStudyOTM') }}</h2>
                                    <table class="mx-auto table table-bordered table-striped table-hover">
                                        <tbody>
                                            <tr>
                                                <div class="mb-3">
                                                    <h3 class="fw-light">
                                                        Posted On {{caseStudyOfTheMonth[0]}} by {{caseStudyOfTheMonth[2]}}
                                                    </h3>
                                                    <h3 class="fw-light">
                                                        Type: {{caseStudyOfTheMonth[1]}}
                                                    </h3>
                                                    <img v-if="caseStudyOfTheMonth[3] != null" :src="'data:' + caseStudyOfTheMonth[4] + ';base64,' + caseStudyOfTheMonth[3]" />
                                                </div>
                                            </tr>
                                            <tr>
                                                <table class="mx-auto table table-bordered table-striped table-hover">

                                                    <thead>
                                                        <tr>
                                                            <th v-for="header in Object.keys(caseStudyOfTheMonth[5])" :key="header">{{header}}</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td v-for="field in caseStudyOfTheMonth[5]" :key="field">
                                                                <div class="mx-auto text-wrap justify-content-center" style="width: 6rem; text-align: center">
                                                                    {{field}}
                                                                </div>

                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
                </div>
            </div>
        </div>
    </div>
    </div>
</div>

</template>

<script lang="ts" type="text/typescript">

import { defineComponent } from 'vue';
import axios from 'axios';
export default defineComponent({
    name: "LeadersBoard",
    mounted() {
        let token = JSON.parse(localStorage.getItem('user')!);
        if(token.roles[0].authority == "ROLE_ADMIN" || token.roles[0].authority == "ROLE_HOSPITALADMN"){
            this.hasPermissions = true
        }
        this.getMonthlyPrize();
        this.getEmployeeoftheMonth();
        this.getDepartmentPoints();
        this.getMSPPReportsForMonthAndYear();
        this.getCaseStudyReportsForMonthAndYear();
        this.getCaseStudyOfTheMonth();
    },
    data: function() {
        return {
            departmentPoints: {},
            departments: [""],
            MonthlyPrize: [""],
            AnnualPrize: [""],
            employeeofthemonth: [],
            caseStudyOfTheMonth: [] as any,
            hasPermissions: false,
            msppReportsSubmittedMonthAndYear: {},
            caseStudyReportsSubmittedMonthAndYear: [] as any
        }
    },
    methods: {
        isAdmin(): boolean {
            const token = JSON.parse(localStorage.getItem('user')!);
            if(token.roles[0].authority == 'ROLE_ADMIN') {
                return true;
            }
            return false;
        },
        getMonthlyPrize(): void {
            var months = ['January', 'February', 'March',
                'April', 'May', 'June', 'July',
                'August', 'September', 'October', 'November', 'December'];
            let token = JSON.parse(localStorage.getItem('user')!);
            
            axios.get("/api/announcements", {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`,
                },
                params: {
                    month: months[new Date().getMonth()] + " " + new Date().getFullYear()
                }
            }).then(response=> {
                this.MonthlyPrize = response.data;
            });
        },
        getEmployeeoftheMonth(): void {
            let token = JSON.parse(localStorage.getItem('user')!);
            var months = ['January', 'February', 'March',
                'April', 'May', 'June', 'July',
                'August', 'September', 'October', 'November', 'December'];
            this.$axios.get("/api/user/employeeofthemonth", {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`
                },
                params: {
                    month: months[new Date().getMonth()] + " " + new Date().getFullYear()
                }
            }).then(response => {
                this.employeeofthemonth = response.data;
            })
        },
        getDepartmentPoints(): void {
            let token = JSON.parse(localStorage.getItem('user')!);
            axios.get("/api/departments/points", {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`
                },
            }).then(response=> {
                var departmentPointsData = response.data;
                
                //https://stackoverflow.com/questions/5467129/sort-javascript-object-by-key
                this.departmentPoints = Object.keys(departmentPointsData).sort().reduce(function (result, key) {
                                result[key] = departmentPointsData[key];
                                return result;
                            }, {});
            }).catch((error: any) => {
                alert("could not get department points");
            });
        },
        getCaseStudyOfTheMonth(): void {
            let token = JSON.parse(localStorage.getItem('user')!);
            var months = ['January', 'February', 'March',
                'April', 'May', 'June', 'July',
                'August', 'September', 'October', 'November', 'December'];
            axios.get("/api/casestudy/entry", {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`
                },
                params: {
                    month: months[new Date().getMonth()] + " " + new Date().getFullYear()
                }
            }).then(response=> {
                this.caseStudyOfTheMonth = response.data;
            })
        },

        goToAddAnnouncement(): void {
            this.$router.push('/announcement');
        },

        deleteMonthlyAnnouncement(announcement): void {
            let token = JSON.parse(localStorage.getItem('user')!);

            this.$axios.delete("/api/announcements/delete", {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`,
                },
                params: {
                    id: announcement[0]
                }
            }).then(response => {
                alert(response.data);
                this.getMonthlyPrize();
            }).catch((error: any) => {                
                alert("error occurred when deleting user / une erreur s'est produite lors de la suppression de l'utilisateur");
            });
        },

        getMSPPReportsForMonthAndYear(): void {
            let token = JSON.parse(localStorage.getItem('user')!);

            this.$axios.get("/api/mspp/totalreports", {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`,
                },
                params: {
                    month: new Date().getMonth(),
                    year: new Date().getFullYear(),
                }
            }).then(response => {
                this.msppReportsSubmittedMonthAndYear = response.data;
            });
        },

        getCaseStudyReportsForMonthAndYear(): void {
            let token = JSON.parse(localStorage.getItem('user')!);

            this.$axios.get("/api/casestudy/totalreports", {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`,
                },
                params: {
                    month: new Date().getMonth(),
                    year: new Date().getFullYear(),
                }
            }).then(response => {
                this.caseStudyReportsSubmittedMonthAndYear = response.data;
            });
        }
    }
});

</script>

