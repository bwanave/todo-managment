import React from 'react';
import moment from 'moment'
import { Formik, Form, Field, ErrorMessage } from 'formik';
const ADD = 'ADD';
const EDIT = 'EDIT';

class Todo extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            id: parseInt(this.props.match.params.id),
            description: '',
            targetDate: moment(new Date()).format('YYYY-MM-DD'),
            operationMode: parseInt(this.props.match.params.id) === 0 ? ADD : EDIT
        }
    }

    validate(values) {
        let errors = {}
        if (!values.description)
            errors.description = 'Enter a Description'
        else if (values.description.length < 5)
            errors.description = 'Enter atleast 5 Characters in Description'


        if (!moment(values.targetDate).isValid())
            errors.targetDate = 'Enter a valid Target Date'
        return errors
    }

    onSubmit(values) {
        console.log(values);
    }

    render() {
        return (
            <>
                <br />
                {this.state.operationMode === ADD ? <h1>Add Todo</h1> : <h1>Edit Todo</h1>}
                <br />
                <div className="container pl-5 pr-5 text-left">
                    <Formik initialValues={this.state}
                        onSubmit={this.onSubmit}
                        validateOnChange={true}
                        validateOnBlur={true}
                        validate={this.validate}
                        enableReinitialize={true}>
                        {
                            (props) => (
                                <Form>
                                    <ErrorMessage name="description" component="div" className="alert alert-warning" />
                                    <ErrorMessage name="targetDate" component="div" className="alert alert-warning" />
                                    <fieldset className="form-group">
                                        <label>Description</label>
                                        <Field className="form-control" type="text" name="description" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Target Date</label>
                                        <Field className="form-control" type="date" name="targetDate" />
                                    </fieldset>
                                    <button className="btn btn-dark" type="submit">Save</button>
                                </Form>
                            )
                        }
                    </Formik>
                </div>
            </>
        )
    }
}

export default Todo;