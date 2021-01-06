import React, { Component } from 'react';
import { Redirect, Route } from 'react-router-dom';
import AuthenticationService from '../../apis/AuthenticationService';

class ReactRoute extends Component {
    render() {
        return (
            <>
                {
                    this.props.isAuthenticationRequired
                        ? (AuthenticationService.isUserLoggedIn() ? <Route {...this.props} /> : <Redirect to="/login" />)
                        : <Route {...this.props} />
                }
            </>
        )
    }
}

export default ReactRoute;