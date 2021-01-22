import React, { Component } from 'react';
import AgGrid from '../util/AgGrid';
import CrudAction from '../util/CrudAction';
import moment from 'moment'
import TodoApis from '../../apis/TodoApis';
import AuthenticationApis from '../../apis/AuthenticationApis';

class Todos extends Component {

    constructor(props) {
        super(props);
        this.state = {
            todos: []
        }
        this.add = this.add.bind(this);
    }

    componentDidMount() {
        TodoApis.getTodos(AuthenticationApis.loggedInUser())
            .then(response => this.setState({ todos: response.data }))
            .catch(error => console.log('Failed to get todos'))
    }

    add() {
        this.props.history.push('/todos/0');
    }

    edit(todo) {
        this.props.history.push(`/todos/${todo.id}`)
    }

    delete(todo) {
        alert(`In progress feature: Deleting todo - ${todo.id}`)
    }

    render() {
        const columnDefs = [
            {
                headerName: 'Description',
                colId: 'description',
                field: 'description'
            },
            {
                headerName: 'Target Date',
                colId: 'targetDate',
                valueGetter: params => moment(params.data.targetDate).format("DD-MMM-YYYY")
            },
            {
                headerName: 'Is Completed?',
                colId: 'completed',
                field: 'completed'
            },
            {
                headerName: 'Action',
                colId: 'action',
                cellRenderer: 'crudAction',
                maxWidth: 200,
                filter: false,
                sortable: false
            }];
        return (
            <>
                <br />
                <h2> Todo List </h2>
                <br />
                <div className="pb-2">
                    <button className="btn btn-dark float-right" title="Add the new Todo item into list" onClick={this.add}> Add New Todo </button>
                </div>
                <AgGrid columnDefs={columnDefs}
                    rowData={this.state.todos}
                    context={{ parentComponent: this }}
                    frameworkComponents={{ crudAction: CrudAction }} />
            </>
        )
    }
}

export default Todos;