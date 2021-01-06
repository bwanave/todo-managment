import React, { Component } from 'react';
import AgGrid from '../util/AgGrid';
import CrudAction from '../util/CrudAction';

class Todos extends Component {

    render() {
        const columnDefs = [
            { headerName: 'Todo', colId: 'todo', field: 'todo' },
            { headerName: 'Description', colId: 'description', field: 'description' },
            { headerName: 'Target Date', colId: 'targetDate', field: 'targetDate' },
            { headerName: 'Action', colId: 'action', cellRenderer: 'crudAction', maxWidth: 200, filter: false, sortable: false }];
        const todos = [
            { todo: 'Learn ReactJs', description: 'Learn ReactJs UI technology', targetDate: new Date() },
            { todo: 'Learn ReactJs', description: 'Learn ReactJs UI technology', targetDate: new Date() },
            // { todo: 'Learn ReactJs', description: 'Learn ReactJs UI technology', targetDate: new Date() }, { todo: 'Learn ReactJs', description: 'Learn ReactJs UI technology', targetDate: new Date() },
            // { todo: 'Learn ReactJs', description: 'Learn ReactJs UI technology', targetDate: new Date() },
            // { todo: 'Learn ReactJs', description: 'Learn ReactJs UI technology', targetDate: new Date() }, { todo: 'Learn ReactJs', description: 'Learn ReactJs UI technology', targetDate: new Date() },
            // { todo: 'Learn ReactJs', description: 'Learn ReactJs UI technology', targetDate: new Date() },
            // { todo: 'Learn ReactJs', description: 'Learn ReactJs UI technology', targetDate: new Date() }, { todo: 'Learn ReactJs', description: 'Learn ReactJs UI technology', targetDate: new Date() },
            // { todo: 'Learn ReactJs', description: 'Learn ReactJs UI technology', targetDate: new Date() },
            // { todo: 'Learn ReactJs', description: 'Learn ReactJs UI technology', targetDate: new Date() }, { todo: 'Learn ReactJs', description: 'Learn ReactJs UI technology', targetDate: new Date() },
            // { todo: 'Learn ReactJs', description: 'Learn ReactJs UI technology', targetDate: new Date() },
            // { todo: 'Learn ReactJs', description: 'Learn ReactJs UI technology', targetDate: new Date() }, { todo: 'Learn ReactJs', description: 'Learn ReactJs UI technology', targetDate: new Date() },
            // { todo: 'Learn ReactJs', description: 'Learn ReactJs UI technology', targetDate: new Date() },
            // { todo: 'Learn ReactJs', description: 'Learn ReactJs UI technology', targetDate: new Date() }, { todo: 'Learn ReactJs', description: 'Learn ReactJs UI technology', targetDate: new Date() },
            // { todo: 'Learn ReactJs', description: 'Learn ReactJs UI technology', targetDate: new Date() },
            { todo: 'Learn ReactJs', description: 'Learn ReactJs UI technology', targetDate: new Date() },
            { todo: 'Learn SpringBoot', description: 'Learn SpringBoot framework', targetDate: new Date() }];

        return (
            <>
                <br />
                <h2> Todo List </h2>
                <br />
                <div className="pb-2">
                    <button className="btn btn-dark float-right" title="Add the new Todo item into list"> Add New Todo </button>
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