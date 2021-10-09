import axios from "axios";

const API_URL = "http://localhost:8080/api/";
import router from '../router';

class AuthService {
    login(user) {
        return axios.post(API_URL + 'login', {
            username: user.username,
            password: user.password
        }).then(response => {
            console.log(response);
            const data = response.data;
            localStorage.setItem('user', JSON.stringify(response.data));
            return response.data;
        });
    }
    logout() {
        console.log("logged out");
        localStorage.removeItem('user');
    }
    register(user) {
        return axios.post(API_URL + 'register', {
            username: user.username,
            password: user.password,
            role: user.role,
        });
    }
}

export default new AuthService();