<template>
    <h1 style="color:#000000;">Awards</h1>
    <p>Please Select One of the Award Types</p>
    <form action="#" th:action="@{/datainput}" th:object="{/datainput}" method="post">
        <label>Choose a award type:</label>
        <select name="award" id="award" th:field="*{type}">
            <option value = "annual">Annual Award</option>
            <option value = "monthly">Monthly Award</option>
        </select>
        <br><br>
        <p>Message: <input type="text" th:field="*{award}"> </p>
        <br>
        <input type="submit" value="Submit">
    </form>

</template>

