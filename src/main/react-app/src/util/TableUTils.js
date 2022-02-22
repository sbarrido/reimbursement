import { Component } from 'react'
import axios from 'axios'

export function connectTable(Table) {
    return class extends Component {
        constructor(props){
            super(props)

            this.state = {
                data: [],
                isLoaded: false
            }
        }

        componentDidMount() {
            const url = 'http://localhost:8080/api/mileages';
            axios.get(url).then((info) => {
                this.setState({
                    data: info,
                    isLoaded: true
                })
            })
        }
        render() {
            const{ isLoaded } = this.state;
            if(isLoaded) {
                return (
                <div>
                    <h1> loaded </h1>
                    <Table data={ this.state.data } {...this.props} /> 
                </div>
                )
            } else {
                return <h1> Loading </h1>
            }
        }
    }
}