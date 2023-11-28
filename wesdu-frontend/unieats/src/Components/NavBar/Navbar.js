import React from 'react';
import {Navbar, Nav, NavItem, Badge, Button} from 'react-bootstrap';
import {useKeycloak} from "@react-keycloak/web";

const SDUNavbar = () => {
    const {keycloak, initialized} = useKeycloak()
    if (!initialized) return <>loading</>
    return (
        <Navbar bg="dark" expand="lg" variant="dark" className={"justify-content-between"}>
            <Navbar.Brand href="#" style={{marginLeft: "20px"}}>SDU-EATS</Navbar.Brand>
            <Navbar.Toggle aria-controls="navbarNavAltMarkup"/>
            <Navbar.Collapse id="navbarNavAltMarkup">
                <Nav className="mr-auto">
                    <Nav.Link href="http://localhost:3000/">Меню</Nav.Link>
                    <Nav.Link href="/places">Места</Nav.Link>
                    <Nav.Link href="#">Акции</Nav.Link>
                </Nav>
                <Nav>
                    <Nav.Link href="http://localhost:3000/cart">Корзина <Badge variant="light">0</Badge></Nav.Link>
                    {
                        keycloak.authenticated ?
                            <>
                                <Nav.Link href="#"
                                          style={{marginRight: "20px"}}
                                          onClick={() => keycloak.accountManagement()}
                                >Профиль</Nav.Link>
                                <Nav.Item>
                                    <Button onClick={() => keycloak.logout()}>Logout</Button>
                                </Nav.Item>
                            </>
                            :
                            <>
                                <Nav.Item>
                                    <Button onClick={() => keycloak.login()}>Login</Button>
                                </Nav.Item>
                            </>
                    }

                </Nav>
            </Navbar.Collapse>


        </Navbar>
    );
};

export default SDUNavbar;
