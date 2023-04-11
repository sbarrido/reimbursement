import { Component } from 'react'
import { Table } from 'reactstrap'

export default class DTOTable extends Component {
    constructor(props) {
        super(props)

        this.state = {
            data : props.data
        }
    }

    render() {
        return(
            <Table>
               <Head data={ this.state.data }/>
                <tbody>
                    <td>stuff</td>
                </tbody>
            </Table>
        )
    }
}

class Head extends Component {
    constructor(props){
        super(props);

        this.state = {
            data: props.data
        }

    }

    render() {
        const headers = Object.keys(this.state.data[0]);
        return(
            <thead>
                <tr>
                    {headers.map((headerItem, index) => {
                        if(index < 5) {
                            return <td key={headerItem}>{headerItem.toUpperCase()}</td>
                        }
                    })}
                </tr>
            </thead>
        )
    }
}