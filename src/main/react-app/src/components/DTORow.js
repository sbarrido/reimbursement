import { Component } from 'react'

class DTORow extends Component {
    constructor(props) {
        super(props)

        this.state = {
            dto: props
        }
    }
    
    render() {
        const { dto }= this.state;
        return(
            <tr>
                {dto.map(( data ) => {
                    return(
                        <td key={ data }>
                            { dto[data] }
                        </td>
                    )
                })}
            </tr>
        );
    }
}

export default DTORow;