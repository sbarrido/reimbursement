import { Component } from 'react';

export function connectTable(Table) {
    return class extends Component {
        constructor(props){
            super(props)

            this.state = {
                data: props.data
            }
        }

        render() {
            return <Table data={this.state.data} {...this.props}/>
        }
    }
}