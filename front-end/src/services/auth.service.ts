import axios from "axios";

const API_URL = "/api/";

class AuthService {
    login(user) {
        return axios.post(API_URL + 'login', {
            username: user.username,
            password: user.password
        }).then(response => {
            localStorage.setItem('user', JSON.stringify(response.data));
            return response.data;
        }).catch((failResponse: any) => {
            console.log(failResponse.status);
        });
    }
    isTokenValid() {
        const token = JSON.parse(localStorage.getItem('user')!);
        const t = token == null ? "" : token.jwt;
        return axios.get(API_URL + 'checktoken', {
            headers: {
                'Authorization': `Bearer ${t}`
            }
        }).then(response => {
            return response;
        },
        error => {
            return error;
        }).catch((failResponse: any) => {
            console.log(failResponse);
        });
    }
    logout() {
        localStorage.removeItem('user');
    }
    getCurrentUser() {
        return JSON.parse(localStorage.getItem('user')!);
    }
}

export default new AuthService();