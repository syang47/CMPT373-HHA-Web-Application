<template xmlns:th="https://www.thymeleaf.org">
    <h1 style="color:#000000;">Awards</h1>
    <Form th:object="{datainput}" method="post">
        <p>Monthly Prize: <input name="monthly" id="monthly" type="text" th:field="*{monthly}"> </p>
        <p>Annual Prize: <input name="annual" id="annual" type="text" th:field="*{annual}"> </p>
        <br>
        <p><input @click="goToLeadersBoard" type="submit" value="Submit"/></p>
    </Form>
</template>

<script lang="ts" type="text/typescript">
import { defineComponent } from 'vue'
import axios from 'axios';
export default defineComponent({
    goToLeadersBoard(): void {
        this.$router.push('/leadersboard')
    }
});

</script>