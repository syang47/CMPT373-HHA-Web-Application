import axios from "axios";

const API_URL = "http://localhost:8080/api/";
import router from '../router';

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
    logout() {
        localStorage.removeItem('user');
    }
    register(user) {
        const token = JSON.parse(localStorage.getItem('user')!);
        let role = "ROLE_USER";
        if(user.head) {
            role = "ROLE_HEAD";
        }
        return axios.post(API_URL + 'register', {
            username: user.username,
            password: user.password,
            department: user.departments,
            role: role,
        }, {
           headers: {
               'Authorization': `Bearer ${token.jwt}`
           }
        });
    }
}

export default new AuthService();