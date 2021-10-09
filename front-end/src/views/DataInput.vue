<template>
  <div class="col-md-12">
    <div class="card card-container">
        <Form @submit="handleRegister" :validation-schema="schema">
            <div class="page">
                <div class="box">
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
                        <button class="btn btn-primary btn-block" :disabled="loading">
                            <span v-show="loading" class="spinner-border spinner-border-sm"></span>
                            Sign Up
                        </button>
                        </div>
                    </div>
                </div>
            </div>
        </Form>

        <div
        v-if="message"
        class="alert"
        :class="successful ? 'alert-success' : 'alert-danger'"
        >
            {{ message }}
        </div>
    </div>
  </div>
</template>

<script lang="ts" type="text/typescript">

import { Form, Field, ErrorMessage } from "vee-validate";
import * as yup from "yup";
export default {

};
</script>