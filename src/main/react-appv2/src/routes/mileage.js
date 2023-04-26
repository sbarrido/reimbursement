import React from 'react'
import axios from 'axios';
import { Spinner,
         Table,
         Button,
         ButtonGroup} from 'reactstrap'
import {Link} from "react-router-dom";

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
                    <Head data={mileageDTOs}/>
                    <tbody>
                    {mileageDTOs.map((mileage, index) => {
                        return <Row key={index} data={mileage}/>
                    })}
                    </tbody>
                </Table>
                <Link to={"/createForm"}>
                    <Button>Create
                    </Button>
                </Link>
            </div>
        );
    }
}

class Head extends React.Component {
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

class Row extends React.Component{
    constructor(props){
        super(props)

        this.state = {
            data: props.data
        }
    }

    render() {
        const dataItem = Object.keys(this.state.data);
        return(
            <tr>
                {dataItem.map((key, index) => {
                    if(index < 6) {
                        if(index == 4) {
                            return <td key={index}>{this.state.data[key].destination} </td>
                        } else if(index == 5) {
                            return(
                            <ButtonGroup>
                                    <Button key={index} data={dataItem[0]}>Edit</Button>
                                    <Button key={index} data={dataItem[0]}>Delete</Button>
                            </ButtonGroup>)
                        }
                        else {
                            return <td key={index}>{this.state.data[key]}</td>
                        }
                    }
                })}
            </tr>
        )
    }
}
export default mileage;