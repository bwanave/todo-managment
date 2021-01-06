import React, { Component } from 'react';
import { Link } from 'react-router-dom';

class Logout extends Component {
    render() {
        return (
            <div className="container text-center pt-5">
                <h3>You have successfully logged out. Thank you!!</h3>
                <br />
                <br />
                <Link to="/login"> Click here </Link> to re-login.
            </div>
        )
    }
}

export default Logout;