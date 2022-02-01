import React from 'react'

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
        fetch(url, {
            method: 'GET',
            mode: 'no-cors',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            }
        })
        .then(data => {
            // this.setState({
            //     userDTOs: data,
            //     isLoaded: true
            // })
            console.log(data);
        });
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
                {numbers.map(number => {
                    return(
                        <li key={number}>{number}</li>
                    )
                })}
            </div>
        );
    }
}

export default UsersComponent;