"use strict";

const login = new Vue({
    el: "#loginWeb",
    data: {
        username: '',
        password: '',
        loginFlag: '',
    },
    method: {
        acceptLogin: function () {
            passUserAccount (
                login.username,
                login.password
            );
        }
    }
});

function pageToMain() {
    axios.get('/hha/login', {})
        .then(function (response) {
            console.log(response);
            window.location.href = '/hha/main'
        })
        .catch(function (error) {
            console.log(error);
        });

}

function acceptLogin (username, password) {
    axios.post('/hha/login', {
        username: username,
        password: password
    })
        .then(function (response) {
            console.log(response);
            pageToMain();
        })
        .catch(function (error) {
            console.log(error);
            window.alert("Invalid user");
        });

}