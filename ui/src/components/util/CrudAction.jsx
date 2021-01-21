import React, { Component } from 'react';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

export default class CrudAction extends Component {

  constructor(props) {
    super(props);
    this.peformEditAction = this.peformEditAction.bind(this);
    this.peformDeleteAction = this.peformDeleteAction.bind(this);
  }

  peformEditAction() {
    this.props.context.parentComponent.edit(this.props.node.data);
  }

  peformDeleteAction() {
    this.props.context.parentComponent.delete(this.props.node.data);
  }

  render() {
    return (
      <span>
        <button className="btn btn-sm btn-primary" onClick={this.peformEditAction}> <FontAwesomeIcon icon="edit" /> Edit </button>
        <button className="btn btn-sm btn-danger ml-3" onClick={this.peformDeleteAction}> <FontAwesomeIcon icon="trash-alt" /> Delete </button>
      </span>
    );
  }
}
