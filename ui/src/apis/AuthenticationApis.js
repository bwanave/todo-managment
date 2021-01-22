export const USERNAME = 'authenticatedUser'

class AuthenticationApis {

    registerSuccessfulLogin(username, password) {
        sessionStorage.setItem(USERNAME, username);
    }

    isUserLoggedIn() {
        let user = sessionStorage.getItem(USERNAME)
        return user !== null;
    }

    loggedInUser() {
        return sessionStorage.getItem(USERNAME)
    }

    logout() {
        sessionStorage.removeItem(USERNAME);
    }
}

export default new AuthenticationApis();