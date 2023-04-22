import React from "react";
import {Button, Col, Form, FormGroup, Input, Label, Row} from "reactstrap";

class createForm extends React.Component {
    constructor(props) {
        super(props)

        this.state = {
        };
    }

    render(){
        return(
            <Form>
                <Row>
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
                    <Col md={6}>
                        <FormGroup>
                            <Label for="location">
                                Location
                            </Label>
                            <Input
                                id="locationData"
                                name="location"
                                placeholder="Location Information"
                                type="location"
                            />
                        </FormGroup>
                    </Col>
                </Row>
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
                <Row>
                    <Col md={6}>
                        <FormGroup>
                            <Label for="exampleCity">
                                City
                            </Label>
                            <Input
                                id="exampleCity"
                                name="city"
                            />
                        </FormGroup>
                    </Col>
                    <Col md={4}>
                        <FormGroup>
                            <Label for="exampleState">
                                State
                            </Label>
                            <Input
                                id="exampleState"
                                name="state"
                            />
                        </FormGroup>
                    </Col>
                    <Col md={2}>
                        <FormGroup>
                            <Label for="exampleZip">
                                Zip
                            </Label>
                            <Input
                                id="exampleZip"
                                name="zip"
                            />
                        </FormGroup>
                    </Col>
                </Row>
                <FormGroup check>
                    <Input
                        id="exampleCheck"
                        name="check"
                        type="checkbox"
                    />
                    <Label
                        check
                        for="exampleCheck"
                    >
                        Check me out
                    </Label>
                </FormGroup>
                <Button>
                    Sign in 
                </Button>
            </Form>
        );
    }
}

export default createForm;