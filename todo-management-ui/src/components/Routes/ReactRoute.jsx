import React, { Component } from 'react';
import { Redirect, Route } from 'react-router-dom';
import AuthenticationService from '../../apis/AuthenticationService';

class ReactRoute extends Component {

    render() {
        if (this.props.authenticationRequired) {
            return (AuthenticationService.isUserLoggedIn()
                ? <Route {...this.props} />
                : <Redirect to="/login" />)
        }
        else {
            return <Route {...this.props} />
        }
    }
}

export default ReactRoute;