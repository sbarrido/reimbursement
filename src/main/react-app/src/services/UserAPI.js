const USER_API = 'http://localhost:8080/api/users';
class UserAPI {
    getUsers() {
        return fetch(USER_API, {
            method: 'get',
            headers: {
                'Accept': 'application/json, text/plain,',
                'Content-Type': 'application/json',
            }
        })
        .then(res => res.json());
    }
}

export default new UserAPI();