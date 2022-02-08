import React, { Component } from 'react';
import {
    Nav,
    Navbar,
    NavbarBrand,
    NavLink,
    NavItem,
    UncontrolledDropdown,
    DropdownToggle,
    DropdownMenu,
    DropdownItem,
} from 'reactstrap';

class GlobalNav extends Component {

    render() {
        return (
            <Navbar>
                <NavbarBrand>Reimb Tracker</NavbarBrand>
                <Nav vertical tabs>
                <UncontrolledDropdown
                    inNavbar
                    nav
                >
                <DropdownToggle
                    caret
                    nav
                >
                    Reimbursements
                </DropdownToggle>
                <DropdownMenu right>
                    <DropdownItem a href="/mileages">
                       Mileages
                    </DropdownItem>
                    <DropdownItem a href="/otherExps">
                        Other Expense
                    </DropdownItem>
                    <DropdownItem divider />
                    <DropdownItem>
                        Form Report
                    </DropdownItem>
                </DropdownMenu>
                </UncontrolledDropdown>
                <NavItem>
                    <NavLink href="/users">
                        users
                    </NavLink>
                </NavItem>
            </Nav>
            </Navbar>
        )
    }
}

export default GlobalNav;