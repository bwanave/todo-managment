import axios from 'axios';
const BASE_URL = "http://localhost:8080/api/v1";

class TodoApis {

    getTodos(username) {
        return axios.get(`${BASE_URL}/users/${username}/todos`);
    }

    getTodos(username, isCompleted) {
        return axios.get(`${BASE_URL}/users/${username}/todos?isCompleted=${isCompleted}`);
    }

    getTodo(username, id) {
        return axios.get(`${BASE_URL}/users/${username}/todos/${id}`);
    }
}

export default new TodoApis();