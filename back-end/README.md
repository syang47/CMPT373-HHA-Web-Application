login works with one user (username: user; password: pass)

on successful login, server sends back a response object including username and JWT

UI team needs to:
 - take this JWT and save it using vuex or localstorage
 - restrict all other pages except for the login page
 - make it so every time an axios request is called, send this JWT in the authorization bearer header for server to authorize whether the user can look at this page
 - send the user back to the login page if the server sends back a status code other than 200