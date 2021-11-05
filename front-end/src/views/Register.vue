<template>
    
    <Form class="background" @submit="handleRegister" :validation-schema="userSchema">
    <div class="box">
        <div class="signup-form text-monospace">
            <div class="text-center">
                <img class="mb-4" src="@/assets/logo.png" width="300" alt="">
                <h2 class="font-weight-bold display-5 text-dark text-monospace">{{ $t('registerPage.registration') }}</h2>
            </div>
            <div v-if="!successful">
                <div class="form-group">
                    <label for="username">{{ $t('registerPage.username') }}</label>
                    <Field name="username" type="text" class="form-control" />
                    <ErrorMessage name="username" class="error-feedback" />
                </div>
                
                <div class="form-group">
                    <label for="password">{{ $t('registerPage.password') }}</label>
                    <Field name="password" type="password" class="form-control" />
                    <ErrorMessage name="password" class="error-feedback" />
                </div>
                <div class="form-group">
                    <label for="role">{{ $t('registerPage.role') }}</label>
                    <Field name="role" type="text" class="form-control" />
                    <ErrorMessage name="role" class="error-feedback" />
                </div>
                <div class="form-group">
                    <button class="btn btn-outline-light btn-block" :disabled="loading">
                        <span v-show="loading" class="spinner-border spinner-border-sm"></span>
                        {{ $t('registerPage.signUp') }}
                    </button>
                </div>
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
</template>

<script lang="ts" type="text/typescript">
import { Vue } from "vue-class-component";
import { defineComponent } from 'vue'
import { Form, Field, ErrorMessage } from "vee-validate";
import * as yup from "yup";
export default defineComponent({
    name: "Register",
    components: {
        Form,
        Field,
        ErrorMessage,
    },
    data() {
        const userSchema = yup.object().shape({ //need translation handling for err messages
            username: yup
                .string()
                .required("Username is required!")
                .min(4, "Must be at least 4 characters!")
                .max(20, "Must be maximum 20 characters!"),
            role: yup
                .string()
                .required("Role is required!")
                .lowercase()
                .notOneOf(['admin']),
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
            userSchema,
        };

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
                    console.log("registration:" + this.successful);
                    console.log(user);
                }
            );
        },

    }


});
</script>

<style scoped>
    .background {
        background: url('../assets/project_photos/register_bg.jpg');
        /* filter:"progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale')"; */
        /* -moz-background-size:100% 100%; */
        position: fixed;
        /* background-size: 100% 100%; */
        height: 100%;
        position: relative;
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
        margin-bottm: 20px;
    }
</style>