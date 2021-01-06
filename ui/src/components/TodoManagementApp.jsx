import React, { Component } from 'react';
import './TodoManagementApp.css';
import './Bootstrap.css';
import { BrowserRouter as Router, Switch } from 'react-router-dom'
import Home from './home/Home';
import Footer from './Footer';
import Header from './Header';
import Login from './Login';
import Nav from './Nav';
import Todos from './todo/Todos';
import Error404 from './Error404';
import Logout from './Logout';
import ReactRoute from './Routes/ReactRoute';

// Preload required icons
import { library } from '@fortawesome/fontawesome-svg-core';
import { faCartPlus, faChartBar, faChartLine, faCog, faEdit, faEye, faHome, faLock, faPlusCircle, faPrint, faSearch, faSignOutAlt, faSpinner, faTrashAlt, faUser, faPhoneSquare, faPlay, faRobot, faQuestionCircle, faUserPlus } from '@fortawesome/free-solid-svg-icons';
library.add(faUser, faUserPlus, faPhoneSquare, faQuestionCircle, faRobot, faPlay, faLock, faSearch, faHome, faEye, faChartBar, faCog, faSignOutAlt, faPlusCircle, faSpinner, faChartLine, faCartPlus, faPrint, faEdit, faTrashAlt);

class TodoManagementApp extends Component {
    render() {
        return (
            <div className="todo-management-app">
                <Router>
                    <table className="layout">
                        <thead>
                            <tr>
                                <th className="header">
                                    <div className="main-header"> <Header /> </div>
                                    <div className="navigation-bar"> <Nav /> </div>
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td className="body">
                                    <Switch>
                                        <ReactRoute path="/" exact component={Login} isAuthenticationRequired={false} />
                                        <ReactRoute path="/login" exact component={Login} isAuthenticationRequired={false} />
                                        <ReactRoute path="/home/:name" exact component={Home} isAuthenticationRequired={true} />
                                        <ReactRoute path="/todos" exact component={Todos} isAuthenticationRequired={true} />
                                        <ReactRoute path="/logout" exact component={Logout} isAuthenticationRequired={false} />
                                        <ReactRoute component={Error404} isAuthenticationRequired={false} />
                                    </Switch>
                                </td>
                            </tr>
                        </tbody>
                        <tfoot>
                            <tr> <td className="footer"> <Footer /> </td> </tr>
                        </tfoot>
                    </table>

                </Router>

            </div>
        )
    }
}

export default TodoManagementApp;

