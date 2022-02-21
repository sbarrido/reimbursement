import React from 'react'
import axios from 'axios';
import { Spinner, Table } from 'reactstrap'

class mileage extends React.Component {

    constructor(props) {
        super(props)

        this.state = {
            mileageDTOs: [],
            isLoaded: false
        };
    }
    componentDidMount() {
        const url = 'http://localhost:8080/api/mileages';
        axios
            .get(url)
            .then(({ data }) => {
                this.setState({
                    mileageDTOs: data._embedded.mileageDtoList,
                    isLoaded: true
                })
            })
            .catch((err) => {})
    }
    render() {
        const { isLoaded, mileageDTOs } = this.state;
        
        if(!isLoaded) {
            return (
                <div>
                    <h1>Mileages Loading...</h1>
                    <Spinner/>
                </div>
            )
        }
        return (
            <div>
                <h1>LOADED!</h1>
                <Table>
                    <thead>
                        <tr>
                            <th>
                                ID #
                            </th>
                            <th>
                                Date
                            </th>
                            <th>
                                Destination
                            </th>
                        </tr>
                    </thead>
                    {mileageDTOs.map((mileage) => {
                        return(
                            <tbody>
                                <tr>
                                    <th> { mileage.id } </th>
                                    <td> { mileage.date } </td>
                                    <td> { mileage.destination.destination } </td>
                                </tr>
                            </tbody>
                        )
                    })}
                </Table>
            </div>
        );
    }
}

export default mileage;