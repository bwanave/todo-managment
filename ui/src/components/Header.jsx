import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { withRouter } from 'react-router'
import AuthenticationApis from '../apis/AuthenticationApis';

class Header extends Component {
    render() {
        const isUserLoggedIn = AuthenticationApis.isUserLoggedIn();
        return (
            <header>
                <nav className="navbar navbar-expand-md navbar-dark">
                    <div>
                        <a href="/todos" className="navbar-brand">TODO MANAGEMENT</a>
                    </div>
                    <ul className="navbar-nav navbar-collapse justify-content-end">
                        {!isUserLoggedIn && <li> <Link to="/login" className="nav-link" > Login </Link> </li>}
                        {isUserLoggedIn && <li> <Link to="/logout" className="nav-link" onClick={AuthenticationApis.logout}> Logout </Link> </li>}
                    </ul>
                </nav>
            </header>
        )
    }
}

export default withRouter(Header);