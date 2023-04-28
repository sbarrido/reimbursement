import React, { Component } from 'react';
import {
    Nav,
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
            <Nav vertical tabs navbar>
                <NavbarBrand>Reimbursement App</NavbarBrand>
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
            <DropdownMenu down="true">
                <DropdownItem href="/mileages">
                    Mileages
                </DropdownItem>
                <DropdownItem href="/otherExps">
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
                    Users
                </NavLink>
            </NavItem>
            <NavItem>
                <NavLink>
                    Logout
                </NavLink>
            </NavItem>
        </Nav>
        )
    }
}

export default GlobalNav;