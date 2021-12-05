
<style scoped>

    .background {
        background: url('../assets/project_photos/register_bg.jpg');
        /* filter:"progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale')"; */
        /* -moz-background-size:100% 100%; */
        position: fixed;
        /* background-size: 100% 100%; */
        height: 100%;
        position: absolute;
        background-position: center;
        background-repeat: no-repeat;
        background-size:cover;
    }
    .box {
        width: 100%;
        height: 100%;
        background: #00000060;
        position: relative;
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
        width: 400px;
        margin: 0 auto;
        padding: 30px 0;
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
<div class="main-content">
    <div class="card shadow-none">
      <div class="card-body">
        <Form @submit="handleRegister" :validation-schema="userSchema">

        <div class="box">
            <div class="text-monospace">
                <div class="text-center">
                    <img class="mb-4" src="@/assets/logo.png" width="300" alt="">
                    <h2 class="font-weight-bold display-5 text-dark text-monospace">{{ $t('registerPage.registration') }}</h2>
                </div>
                <div v-if="!successful">
                    <div class="form-group mb-3">
                        <label class="mb-2" for="username">{{ $t('registerPage.username') }}</label>
                        <Field name="username" type="text" class="form-control" />
                        <div class="mt-2">
                            <ErrorMessage name="username" class="error-feedback" />
                        </div>
                    </div>
                    
                    <div class="form-group mb-3">
                        <label class="mb-2" for="password">{{ $t('registerPage.password') }}</label>
                        <Field name="password" type="password" class="form-control" />
                        <div class="mt-2">
                        <ErrorMessage name="password" class="error-feedback" />
                        </div>
                    </div>

                    <div class="form-group mb-3">
                        <label class="mb-2" for="departments">{{ $t('registerPage.selectDept') }}</label>
                        <Field v-slot="{ value }" name="departments" as="select">
                        <option v-for="d in departments" :key="d" :value="d" :selected="value && value.includes(d)">{{ d }}</option>
                        </Field>

                    </div>
                    <div class="form-group" v-if="isAdmin()">
                        <div>
                            <Field name="hospitalAdmin" type="checkbox" :value="true"/>
                            <label for="hospitalAdmin">{{ $t('registerPage.hospitalAdmin') }}</label>
                        </div>
                        <div>
                            <Field name="head" type="checkbox" :value="true"/>
                            <label for="head">{{ $t('registerPage.deptHeadMedDir') }}</label>
                        </div>
                        
                    </div>
                    <div class="form-group">
                        <button class="btn btn-secondary btn-block" :disabled="loading">
                            <span v-show="loading" class="spinner-border spinner-border-sm"></span>
                            {{ $t('registerPage.signUp') }}
                        </button>
                    </div>
                </div>
            </div>
            </div>
        </Form>

        <div v-if="message" style="width: 60%; margin:0 auto;" class="alert text-center" :class="successful ? 'alert-success' : 'alert-danger'">
            {{ message }}
        </div>
      </div>
    </div>
</div>
    

</template>

<script lang="ts" type="text/typescript">

import { defineComponent } from 'vue'
import { Form, Field, ErrorMessage } from "vee-validate";
import * as yup from "yup";
import axios from 'axios';
export default defineComponent({
    name: "Register",
    components: {
        Form,
        Field,
        ErrorMessage,
    },
    data: function() {
        const userSchema = yup.object().shape({ //need translation handling for err messages
            username: yup
                .string()
                .required("Username is required! / Nom d'utilisateur est nécessaire!")
                .min(4, "Must be at least 4 characters! / Doit comporter au moins 4 caractères !")
                .max(20, "Must be maximum 20 characters! / Doit contenir au maximum 20 caractères !"),
            password: yup
                .string()
                .required("Password is required! / Mot de passe requis!")
                .min(6, "Must be at least 6 characters! / Doit être au moins 6 caractères!")
                .max(40, "Must be maximum 40 characters! / Doit contenir au maximum 40 caractères !"),
            departments: yup
                .string()
                .required("Must select a department for the user. / Doit sélectionner un département pour l'utilisateur."),
            hospitalAdmin:yup
                .boolean(),
            head: yup
                .boolean()
        });

        return {
            successful: false,
            loading: false,
            message: "",
            departments: [],
            d: null,
            userSchema,
        };

    },
    mounted() {
        this.getDepartments();
    },
    methods: {
        isAdmin(): boolean {
            const token = JSON.parse(localStorage.getItem('user')!);
            if(token.roles[0].authority == 'ROLE_ADMIN') {
                return true;
            }
            return false;
        },

        getDepartments(): void {
            const token = JSON.parse(localStorage.getItem('user')!);
            axios.get("/api/departments", {
            headers: {
                'Authorization': `Bearer ${token.jwt}`
            }
            }).then(response => {
                this.departments = response.data;
            });
        },

        handleRegister(user) {
            this.message = "";
            this.successful = false;
            this.loading = true;
            const token = JSON.parse(localStorage.getItem('user')!);
            let role = "ROLE_USER";
            if(user.hospitalAdmin){
                role = "ROLE_HOSPITALADMN";
            } else if(user.head) {
                role = "ROLE_HEAD";
            }
            return axios.post('/api/register', {
                username: user.username,
                password: user.password,
                department: user.departments,
                role: role,
            }, {
                headers: {
                    'Authorization': `Bearer ${token.jwt}`
                }
            }).then(response => {
                this.message = "registration successful with username: " + response.data.username;
                this.successful = true;
                this.loading = false;
            }).catch(error => {
                this.message =
                    (error.response &&
                    error.response.data &&
                    error.response.data.message) ||
                    error.message || error.toString();
                this.successful = false;
                this.loading = false;
            });
        },

    }


});

</script>

