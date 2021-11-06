<template>
<div class = "background">
    <div class="container-fluid">
        <h1 class="display-2 text-center text-dark">Leaders Board</h1>
        <div class="container">
            <div class="row">
                <div class="col">
                        <div class="card rounded text-center text-white mb-3 mt-3" style="background: lightblue;">
                            <div class="card-body">
                                <h2 style="color:#000000;" class="card-title w-70">Monthly Award</h2>
                                <ul>
                                    <li v-for="prize in MonthlyPrize" :key="prize">
                                        {{ prize }}
                                    </li>
                                </ul>
                            </div>
                        </div>

                </div>
                <div class="col" >
                    <div class="card w-100 text-center text-white mb-3 mt-3" style="background:#C0C0C0;">
                        <div class="card-body">
                            <h2 style="color:#000000;" class="card-title w-40">Annual Award</h2>
                            <ul>
                                <li v-for="prize in AnnualPrize" :key="prize">
                                    {{ prize }}
                                </li>
                            </ul>
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
                                    <thead>
                                        <tr>
                                            <th>Pos</th>
                                            <th>Department</th>
                                            <th>Points</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr v-for="(points, dep, index) in departmentPoints" :key="index">
                                            <th>{{ index + 1 }}</th>
                                            <td>{{ dep }}</td>
                                            <td>{{ points }}</td>
                                        </tr>
                                    </tbody>
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
        this.getMonthlyPrize();
        this.getAnnualPrize();
        this.getDepartmentPoints();
    },
    data: function() {
        return {
            departmentPoints: {},
            departments: [""],
            MonthlyPrize: [""],
            AnnualPrize: [""]
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
            axios.get("/api/announcements", {
                params: {
                    field: "monthly"
                }
            }).then(response=> {
                this.MonthlyPrize = response.data;
            });
        },
        getAnnualPrize(): void{
            axios.get("/api/announcements", {
                params: {
                    field: "annual"
                }
            }).then(response=> {
                this.AnnualPrize = response.data;
            });
        },
        getDepartmentPoints(): void {
            axios.get("/api/departments/points").then(response=> {
                var departmentPointsData = response.data;
                
                this.departmentPoints = Object.keys(departmentPointsData).sort().reduce(function (result, key) {
                                            result[key] = departmentPointsData[key];
                                            return result;
                                        }, {});
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
        position: absolute;
        /* background-size: 100% 100%; */
        height: 100%;
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