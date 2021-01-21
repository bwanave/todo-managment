import React, { Component } from 'react';
import { Link } from 'react-router-dom';

class Home extends Component {

    render() {
        return (
            <div>
                <br />
                <br />
                <h3>  Welcome {this.props.match.params.name}</h3>
                <br />
                <span>  You can manage your todos <Link to="/todos">here</Link> </span>
            </div>
        )
    }
}

export default Home;