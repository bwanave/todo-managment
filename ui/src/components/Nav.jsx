import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { withRouter } from 'react-router';
import AuthenticationService from '../apis/AuthenticationService';

class Nav extends Component {
    render() {
        if (AuthenticationService.isUserLoggedIn())
            return this.renderNavbar()
        else
            return "";
    }

    renderNavbar() {
        return (
            <nav className="navbar navbar-expand-md bg-light border-bottom w-100">
                <ul className="navbar-nav">
                    <li><Link to="/home/Balaji" className="nav-link"> Home </Link></li>
                    <li><Link to="/todos" className="nav-link"> Todos </Link></li>
                </ul>
            </nav>
        )
    }
}

export default withRouter(Nav);