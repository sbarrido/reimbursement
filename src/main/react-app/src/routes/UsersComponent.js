import React, {Component} from 'react'
import axios from 'axios'
import { Spinner,
    ListGroup,
    ListGroupItem,
    Collapse,
    Card,
    CardBody,
    Button,
    ButtonGroup  } from 'reactstrap'
import { connectTable } from '../util/TableUTils.js'
import DTOTable from '../components/DTOTable.js'

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
        return(
            <ButtonTable/>
        )
    }
    // constructor(props) {
    //     super(props)
        
    //     this.state = {
    //          userDTOs: [],
    //          isLoaded: false
    //     };
    // }

    // componentDidMount() {
    //     const url = 'http://localhost:8080/api/users';
    //     axios
    //         .get(url)
    //         .then(({ data }) => {
    //             this.setState({
    //                 userDTOs: data._embedded.userDtoList,
    //                 isLoaded: true
    //             })
    //         })
    //         .catch((err) => {})

    // }
    
    // render() {
    //     const { isLoaded, userDTOs } = this.state;
    //     if(!isLoaded) {
    //         return (
    //             <div>
    //                 <h1>Loading...</h1>
    //                 <Spinner></Spinner>
    //             </div>
    //         )
    //     }
    //     return(
    //         <div>
    //             <h1> LOADED! </h1>
    //             <Table>
    //                 <thead>
    //                     <tr>
    //                         <th>
    //                             ID #
    //                         </th>
    //                         <th>
    //                             Username
    //                         </th>
    //                     </tr>
    //                 </thead>
    //                 <tbody>
    //                 {userDTOs.map((user) => {
    //                 return(
    //                     <tr key={ user.id }>
    //                         <th> { user.id } </th>
    //                         <td> { user.username } </td>
    //                     </tr>
    //                 )
    //             })}
    //                 </tbody>
    //             </Table>
    //         </div>
    //     );
    // }
}
class ButtonTable extends Component {
    constructor(props){
        super(props)
        
        this.state = {
            showFirst: false,
            showSecond: false,
            showThird: false
        };
    }

    toggle() {
        this.setState({
            showFirst: !this.state.showFirst
        })
    }
    render() {
        return(
            <ListGroup>
                <ListGroupItem
                 action
                 tag="a"
                 active={this.state.showFirst}
                 onClick={()=> this.toggle()}
                >
                    Item
                    <Collapse isOpen = { this.state.showFirst }>
                        <Card>
                            <ButtonGroup>
                                <Button>Edit</Button>
                                <Button>Remove</Button>
                            </ButtonGroup>
                        </Card>
                    </Collapse>
                </ListGroupItem>
                <ListGroupItem
                 action
                 tag="button"
                >
                    Item
                    <Collapse>
                        <Card>
                            <CardBody>
                                Collapse Card
                            </CardBody>
                        </Card>
                    </Collapse>
                </ListGroupItem>
            </ListGroup>
        )
    }
}
export default UsersComponent;