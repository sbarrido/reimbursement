import React from "react";
import {Button, Col, Form, FormGroup, Input, Label, Row} from "reactstrap";
import axios from "axios";

class createForm extends React.Component {
    constructor(props) {
        super(props)

        this.state = {
            destinationDTOs: [],
            isLoaded: false
        };
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    handleSubmit(event) {
        const { destinationDTOs} = this.state;
        let newDate = new Date(event.target.date.value);
        let destinationString = event.target.destination.value;
        let destination = JSON.parse(destinationString);
        let targetID = event.target.id.value;
        let description = event.target.description.value;
        const formatDate =
            newDate.getFullYear() + "-" +
            newDate.getMonth() + "-" +
            newDate.getDay();
        let destinationDTO = {};
        destinationDTO.id = destination.id;
        destinationDTO.destination = destination.destination;
        destinationDTO.distance = destination.distance;


        let mileageDTO = {};
        mileageDTO.id = targetID;
        mileageDTO.date = newDate;
        mileageDTO.description = description;
        mileageDTO.destination = destinationDTO;

        const url = 'http://localhost:8080/api/mileages';
        axios({
            method: 'post',
            url: url,
            data: mileageDTO
        });
        alert("SUCCESS");
    };
    componentDidMount() {
        const url = 'http://localhost:8080/api/destinations';
        axios
            .get(url)
            .then(({ data }) => {
            this.setState({
                destinationDTOs: data._embedded.destinationDtoList,
                isLoaded: true
            })
        })
        .catch((err) => {})
    }
    render(){
        const { destinationDTOs } = this.state;

        return(
            <Form onSubmit={this.handleSubmit}>
                <h1>Mileage Form</h1>
                <Row>
                    <Col md={6}>
                        <FormGroup>
                            <Label for="id">
                                ID
                            </Label>
                            <Input
                                id="mileageID"
                                name="id"
                                placeholder="0"
                            />
                        </FormGroup>
                    </Col>
                    <Col md={6}>
                        <FormGroup>
                            <Label for="Date">
                                Date
                            </Label>
                            <Input
                                id="mileageDate"
                                name="date"
                                placeholder="MM/DD/YYYY"
                                type="date"
                            />
                        </FormGroup>
                    </Col>
                </Row>
                <FormGroup>
                    <Label for="destinationSelect">
                        Select Destination
                    </Label>
                    <Input
                        id="destinationSelect"
                        name="destination"
                        type="select">
                        {destinationDTOs.map((destination, index) => {
                            return <option key={index} data={destination} value={JSON.stringify(destination)}>{destination.destination}</option>
                        })}
                    </Input>
                </FormGroup>
                <FormGroup>
                    <Label for="description">
                        Description
                    </Label>
                    <Input
                        id="description"
                        name="description"
                        placeholder="Basic Description of Reimbursement"
                    />
                </FormGroup>
                <Button type="submit">
                    Create
                </Button>
            </Form>
        );
    }
}

export default createForm;