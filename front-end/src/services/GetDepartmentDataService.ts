import axios from "axios";
import authHeader from "./auth-header";
const API_URL = "http://localhost:8080/api/";
import router from '../router';

class GetDepartmentDataService {
    getByDepartment(department) {
        return axios.get(API_URL+'user'+`${department}`, {headers: authHeader()});
    }
}



export default new GetDepartmentDataService();