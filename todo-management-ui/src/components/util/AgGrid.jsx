import React, { Component } from 'react';
import { AgGridReact } from 'ag-grid-react';
import 'ag-grid-community/dist/styles/ag-grid.css';
import 'ag-grid-community/dist/styles/ag-theme-alpine.css';
import './AgGrid.css'

class AgGrid extends Component {

    constructor(props) {
        super(props);

        this.state = {
            gridOptions: {
                defaultColDef: {
                    filter: 'agTextColumnFilter',
                    floatingFilter: false,
                    resizable: true,
                    sortable: true,
                    filterParams: {
                        buttons: ['apply', 'clear', 'reset'],
                        closeOnApply: true
                    },
                    cellStyle: { textAlign: 'left', 'vertical-align': 'middle' }
                },
                columnTypes: {
                    numberColumn: { width: 130, filter: 'agNumberColumnFilter' },
                    nonEditableColumn: { editable: false },
                    dateColumn: {
                        filter: 'agDateColumnFilter',
                        filterParams: {
                            comparator: function (filterLocalDateAtMidnight, cellValue) {
                                var dateParts = cellValue.split('/');
                                var day = Number(dateParts[0]);
                                var month = Number(dateParts[1]) - 1;
                                var year = Number(dateParts[2]);
                                var cellDate = new Date(year, month, day);

                                if (cellDate < filterLocalDateAtMidnight)
                                    return -1;
                                else if (cellDate > filterLocalDateAtMidnight)
                                    return 1;
                                else
                                    return 0;
                            },
                        },
                    },
                },
                domLayout: 'autoHeight',
                animateRows: true,
                rowHeight: 60
            }
        };
    }

    onGridReady = params => {
        this.gridApi = params.api;
        this.gridColumnApi = params.columnApi;
        params.api.sizeColumnsToFit();
    };

    onFirstDataRendered = params => {
        params.api.sizeColumnsToFit();
    };

    render() {
        return (
            <div className="ag-theme-alpine">
                <AgGridReact {...this.props}
                    gridOptions={this.state.gridOptions}
                    onGridReady={this.props.onGridReady === undefined ? this.onGridReady : this.props.onGridReady}
                    onFirstDataRendered={this.props.onFirstDataRendered === undefined ? this.onFirstDataRendered : this.props.onFirstDataRendered}>
                </AgGridReact>
            </div>
        )
    }
}

export default AgGrid;