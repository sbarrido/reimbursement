import { Component } from 'react'
import { Table } from 'reactstrap'
import Row from './DTORow.js'
import Head from './DTOHead.js'

class DTOTable extends Component {
    constructor(props) {
        super(props)

        this.state ={
            name: '',
            data: props
        };
    }

    render(){
        const { data } = this.state;
        const headers = Object.keys(data);

        return(
            <Table>
                <Head headers={ headers }/>
                <tbody>
                {data.map(( dto ) => {
                    return(
                        <Row dto = { dto }/>
                    )
                })}
                </tbody>
            </Table>
        )
    }
}

export default DTOTable;