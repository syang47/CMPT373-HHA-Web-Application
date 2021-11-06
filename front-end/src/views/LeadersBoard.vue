<template>
<div class = "background">
    <div class="container-fluid">
        <h1 class="display-2 text-center text-dark">Leaders Board</h1>
        <div class="container">
            <div class="row">
                <div class="col">
                        <div class="card rounded text-center text-white mb-3 mt-3" style="background: lightblue;">
                            <div class="card-body">
                                <h2 style="color:#000000;" class="card-title w-70">Montly Award</h2>
                                <p style="color:#000000;" class="card-text"> {{ MonthlyPrize }} </p>
                            </div>
                        </div>

                </div>
                <div class="col" >
                    <div class="card w-100 text-center text-white mb-3 mt-3" style="background:#C0C0C0;">
                        <div class="card-body">
                            <h2 style="color:#000000;" class="card-title w-40">Annual Award</h2>
                            <p style="color:#000000;" class="card-text">{{ AnnualPrize }}</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <div class="row-6 rounded-left">
                        <div class="card rounded text-center text-white mb-3 mt-3" style="background:#7fffd4">
                            <div class="card-body">
                                <table>
                                    <tr>
                                        <th>Pos</th>
                                        <th>Department</th>
                                        <th>Points</th>
                                    </tr>
                                    <tr>
                                        <th>1</th>
                                        <th>Maternity</th>
                                        <th>...</th>
                                    </tr>
                                    <tr>
                                        <th>2</th>
                                        <th>Rehab</th>
                                        <th>...</th>
                                    </tr>
                                    <tr>
                                        <th>3</th>
                                        <th>NICU / PAED</th>
                                        <th>...</th>
                                    </tr>
                                    <tr>
                                        <th>4</th>
                                        <th>Community Health</th>
                                        <th>...</th>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="row-6">
                        <div class="card text-center text-white mb-3 mt-3" style="background:#7cfc00;">
                            <div class="card-body">
                                <table>
                                    <tr>
                                        <th> Submitted Reports: </th>
                                        <td> {{ submittedReports }} </td>
                                    </tr>
                                    <tr></tr>
                                    <tr>
                                        <th> Quality of Most Recent Report: </th>
                                        <td> {{ bestReportPoints }} </td>
                                    </tr>
                                    <tr></tr>
                                    <tr>
                                        <th> Current Submission Status: </th>
                                        <td> {{ reportSubmissionStatus }} </td>
                                    </tr>
                                    <tr></tr>
                                </table>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="col rounded mb-3 mt-3" style="background: #F59A23">
                    <div class="card w-100 text-center text-white mb-3 mt-3 " style="background: #F59A23; height:93%">
                        <div class="card-body">
                            <h2 style="color:#000000;">Case Study of the Month</h2>
                            
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
import authHeader from '../services/auth-header';
import axios from 'axios';

export default defineComponent({
    name: "LeadersBoard",
    mounted() {
        this.getSubmittedReports();
        this.getBestReportPoints();
        this.getReportSubmissionStatus();
        this.getMonthlyPrize();
        this.getAnnualPrize();
    },
    data: function() {
        return {
            submittedReports: 0,
            bestReportPoints: 0,
            reportSubmissionStatus: false,
            departments: [],
            MonthlyPrize: "",
            AnnualPrize: ""
        }
    },
    methods: {
        getMonthlyPrize(): void {
            axios.get("/datainput/monthly").then(response => {
                this.MonthlyPrize = response.data;
            });
        },
        getAnnualPrize(): void{
            axios.get("/datainput/annual").then(response=> {
                this.AnnualPrize = response.data;
            });
        },
        isAdmin(): boolean {
            const token = JSON.parse(localStorage.getItem('user')!);
            if(token.roles[0].authority == 'ROLE_ADMIN') {
                return true;
            }
            return false;
        },

        getSubmittedReports(): void {
            const token = JSON.parse(localStorage.getItem('user')!);
            this.$axios.get("/api/departments/totalreports", {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`
                },
                params: {
                    department: token.department
                }
            }).then(response => {
                console.log(response.data);
                this.submittedReports = response.data;
            }).catch((error: any) => {
                alert("could not get submitted reports");
            });
        },

        getBestReportPoints(): void {
            const token = JSON.parse(localStorage.getItem('user')!);
            this.$axios.get("/api/casestudy/points", {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`
                }
            }).then(response => {
                this.bestReportPoints = response.data;
            }).catch((error: any) => {
                      alert("could not get best report points");
            });
        },
        getReportSubmissionStatus(): void {
            const token = JSON.parse(localStorage.getItem('user')!);
            axios.get("/api/casestudy/submissionstatus", {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`
                }
            }).then(response => {
                this.reportSubmissionStatus = response.data;
            }).catch((error: any) => {
                alert("could not get submission status");
            });
        }
    }
});
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
}

.btn:hover {
  border-radius: 10px;
  color: #fff;
  box-shadow: 0 0 5px 0 #c6fafe, 0 0 25px 0 #c6fafe, 0 0 50px 0 #c6fafe,
    0 0 100px 0 #c6fafe;
}
    .background {
        background: url('../assets/project_photos/leaders_board_background.jpeg') no-repeat;
        /* filter:"progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale')"; */
        /* -moz-background-size:100% 100%; */
        position: relative;
        /* background-size: 100% 100%; */
        height: 100%;
        position: relative;
        background-position: center;
        background-repeat: no-repeat;
        background-size:cover;
    }

@import url('https://fonts.googleapis.com/css?family=Rubik:300,400,500');

* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}
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
</style>