import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { withRouter } from 'react-router'
import AuthenticationService from '../apis/AuthenticationService';

class Header extends Component {
    render() {
        const isUserLoggedIn = AuthenticationService.isUserLoggedIn();
        return (
            <header>
                <nav className="navbar navbar-expand-md navbar-dark">
                    <div>
                        <a href="/todos" className="navbar-brand">TODO MANAGEMENT APP</a>
                    </div>
                    <ul className="navbar-nav navbar-collapse justify-content-end">
                        {!isUserLoggedIn && <li> <Link to="/login" className="nav-link" > Login </Link> </li>}
                        {isUserLoggedIn && <li> <Link to="/logout" className="nav-link" onClick={AuthenticationService.logout}> Logout </Link> </li>}
                    </ul>
                </nav>
            </header>
        )
    }
}

export default withRouter(Header);