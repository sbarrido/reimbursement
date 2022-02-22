import { Component } from 'react'

class DTOHead extends Component {
    constructor(props) {
        super(props)

        this.state = {
            headers: []
        }
    }
    
    render() {
        const { headers } = this.state;
        return(
            <thead>
                <tr>
                {headers.map(( data ) => {
                    return(
                        <th>
                            { headers[data] }
                        </th>
                    )
                })}
                </tr>
            </thead>
        );
    }
}

export default DTOHead;