<template>
    <div>
        <Form class="background" @submit="handleRegister" :validation-schema="schema">
            
            <div class="signup-form text-monospace">
                <div class="text-center">
                    <img class="mb-4" src="@/assets/logo.png" width="300" alt="">
                    <h2 class="font-weight-bold display-5 text-dark text-monospace">Registration</h2>
                </div>
                <div v-if="!successful">
                    <div class="form-group">
                        <label for="username">Username</label>
                        <Field name="username" type="text" class="form-control" />
                        <ErrorMessage name="username" class="error-feedback" />
                    </div>
                    
                    <div class="form-group">
                        <label for="password">Password</label>
                        <Field name="password" type="password" class="form-control" />
                        <ErrorMessage name="password" class="error-feedback" />
                    </div>
                    <div class="form-group">
                        <label for="role">Role</label>
                        <Field name="role" type="text" class="form-control" />
                        <ErrorMessage name="role" class="error-feedback" />
                    </div>
                    <div class="form-group">
                        <button class="btn btn-outline-light btn-block" :disabled="loading">
                            <span v-show="loading" class="spinner-border spinner-border-sm"></span>
                            Sign Up
                        </button>
                    </div>
                </div>
            </div>
        </Form>

        <div
        v-if="message"
        class="alert alert-danger"
        :class="successful ? 'alert-success' : 'alert-danger'"
        >
            {{ message }}
        </div>
    </div>
</template>


<script>
// TODO: need to switch the language to ts
// https://www.bezkoder.com/vue-3-authentication-jwt/

import { Form, Field, ErrorMessage } from "vee-validate";
import * as yup from "yup";
export default {
    name: "Register",
    components: {
        Form,
        Field,
        ErrorMessage,
    },
    data() {
        const schema = yup.object().shape({
            username: yup
                .string()
                .required("Username is required!")
                .min(4, "Must be at least 4 characters!")
                .max(20, "Must be maximum 20 characters!"),
            role: yup
                .string()
                .required("role is required!"),
            password: yup
                .string()
                .required("Password is required!")
                .min(6, "Must be at least 6 characters!")
                .max(40, "Must be maximum 40 characters!"),
        });

        return {
            successful: false,
            loading: false,
            message: "",
            schema,
        };
    },
    computed: {
        loggedIn() {
            console.log("user logged in?");
            console.log(this.$store.state.auth.status.loggedIn);
            return this.$store.state.auth.status.loggedIn;
        },
    },
    mounted() {
        if (this.loggedIn == true) {
            this.$router.push("/");
        } else {
            this.$router.push("/register");
        }
    },
    methods: {
        handleRegister(user) {
            this.message = "";
            this.successful = false;
            this.loading = true;

            this.$store.dispatch("auth/register", user).then(
                (data) => {
                    this.message = data.message;
                    this.successful = true;
                    this.loading = false;
                    console.log("registration successful: " + this.successful);
                    this.$router.push('/');
                },
                (error) => {
                    this.message =
                        (error.response &&
                        error.response.data &&
                        error.response.data.message) ||
                        error.message || error.toString();
                    this.successful = false;
                    this.loading = false;
                    console.log("registration failed: " + this.successful);
                    console.log(user);
                }
            );
        },
    },
};
</script>

<style scoped>
    .background {
        background: url('../assets/project_photos/register_bg.jpg');
        /* filter:"progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale')"; */
        /* -moz-background-size:100% 100%; */
        background-size:100% 100%;
        position: fixed;
        /* background-size: 100% 100%; */
        height: 100%;
        position: fixed;
        width: 100%;    
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
    }
    .signup-form h2{
        color: #636363;
        margin: 0 0 15px;
        position: realtive;
        text-align: center;
    }
    .signup-form .form-group{
        margin-bottm: 20px;
    }
</style>