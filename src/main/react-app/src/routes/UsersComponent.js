import React from 'react'
import axios from 'axios';

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
        const numbers = [1, 2, 3];
        if(!isLoaded) {
            return (
                <h1>Loading...</h1>
            )
        }
        return(
            <div>
                <h1> LOADED! </h1>
                {userDTOs.map((user) => {
                    return(
                        <li key={user.id}>{user.username}</li>
                    )
                })}
            </div>
        );
    }
}

export default UsersComponent;