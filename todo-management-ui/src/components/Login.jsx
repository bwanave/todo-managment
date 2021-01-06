import React, { Component } from 'react';
import AuthenticationService from '../apis/AuthenticationService';

class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username: 'Balaji',
            password: 'dummy',
            hasLoginFailed: false,
            loginFailedMessage: null
        }
        this.handleChange = this.handleChange.bind(this);
        this.handleLogin = this.handleLogin.bind(this);
    }

    handleChange(event) {
        this.setState({ [event.target.name]: event.target.value })
    }

    handleLogin(event) {
        event.preventDefault();
        if (this.state.username === 'Balaji' && this.state.password === 'dummy') {
            AuthenticationService.registerSuccessfulLogin(this.state.username, this.state.password);
            this.props.history.push(`/home/${this.state.username}`);
        }
        else {
            this.setState({ hasLoginFailed: true });
            this.setState({ loginFailedMessage: 'Login failed: Invalid credentials' });
        }
    }

    render() {
        return (
            <>
                <br />
                <br />
                <br />
                <br />
                <div className="container text-left w-50">
                    <h1> Login </h1>
                    {this.state.hasLoginFailed && <div className="alert alert-warning">{this.state.loginFailedMessage}</div>}
                    <br />
                    <form>
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <input type="text" name="username" className="form-control" value={this.state.username} placeholder="Username" onChange={this.handleChange} />
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-10">

                                <input type="password" name="password" className="form-control" value={this.state.password} placeholder="Password" onChange={this.handleChange} />
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <input type="button" value="Login" className="btn btn-success" onClick={this.handleLogin} />
                            </div>
                        </div>
                    </form>
                </div>
            </>
        )
    }
}

export default Login;