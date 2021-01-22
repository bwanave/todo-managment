import React, { Component } from 'react';
import { Redirect, Route } from 'react-router-dom';
import AuthenticationApis from '../../apis/AuthenticationApis';

class ReactRoute extends Component {

    render() {
        if (this.props.authenticationRequired) {
            return (AuthenticationApis.isUserLoggedIn()
                ? <Route {...this.props} />
                : <Redirect to="/login" />)
        }
        else {
            return <Route {...this.props} />
        }
    }
}

export default ReactRoute;