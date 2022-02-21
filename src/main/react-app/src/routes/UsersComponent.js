import React from 'react'
import axios from 'axios';
import { Spinner, Table } from 'reactstrap'

class UsersComponent extends React.Component {

    constructor(props) {
        super(props)
        
        this.state = {
             userDTOs: [],
             isLoaded: false
        };
    }

    componentDidMount() {
        const url = 'http://localhost:8080/api/users';
        axios
            .get(url)
            .then(({ data }) => {
                this.setState({
                    userDTOs: data._embedded.userDtoList,
                    isLoaded: true
                })
            })
            .catch((err) => {})

    }

    render() {
        const { isLoaded, userDTOs } = this.state;
        if(!isLoaded) {
            return (
                <div>
                    <h1>Loading...</h1>
                    <Spinner></Spinner>
                </div>
            )
        }
        return(
            <div>
                <h1> LOADED! </h1>
                <Table>
                    <thead>
                        <tr>
                            <th>
                                ID #
                            </th>
                            <th>
                                Username
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                    {userDTOs.map((user) => {
                    return(
                        <tr key={ user.id }>
                            <th> { user.id } </th>
                            <td> { user.username } </td>
                        </tr>
                    )
                })}
                    </tbody>
                </Table>
            </div>
        );
    }
}

export default UsersComponent;