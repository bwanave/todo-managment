import React, { Component } from 'react';
import AgGrid from '../util/AgGrid';
import CrudAction from '../util/CrudAction';
import moment from 'moment'

class Todos extends Component {

    constructor(props) {
        super(props);
        this.add = this.add.bind(this);
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
            { headerName: 'Description', colId: 'description', field: 'description' },
            { headerName: 'Target Date', colId: 'targetDate', field: 'targetDate' },
            { headerName: 'Is Completed?', colId: 'completed', field: 'completed' },
            { headerName: 'Action', colId: 'action', cellRenderer: 'crudAction', maxWidth: 200, filter: false, sortable: false }];
        const todos = [
            { id: 1, description: 'Learn ReactJs UI technology', targetDate: moment(new Date()).format("YYYY-MM-DD"), completed: false }];

        return (
            <>
                <br />
                <h2> Todo List </h2>
                <br />
                <div className="pb-2">
                    <button className="btn btn-dark float-right" title="Add the new Todo item into list" onClick={this.add}> Add New Todo </button>
                </div>
                <AgGrid columnDefs={columnDefs}
                    rowData={todos}
                    context={{ parentComponent: this }}
                    frameworkComponents={{ crudAction: CrudAction }} />
            </>
        )
    }
}

export default Todos;