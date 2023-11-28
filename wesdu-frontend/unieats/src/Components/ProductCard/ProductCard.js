import React, {useState} from 'react';
import './ProductCard.css'
import {Card, Button} from 'react-bootstrap';
import {useKeycloak} from "@react-keycloak/web";
import Banana from '../../Image/Banana.png'

const ProductCard = ({id, name, location, price, count, productImage}) => {
    const [counter, setCounter] = useState(1);
    const {keycloak, initialized} = useKeycloak()
    console.log(productImage)

    return (
        <Card bg="dark" style={{width: '16rem'}}>
            <Card.Img variant="top" src={productImage ? productImage : Banana}
                      style={{height: "230px", objectFit: "cover", objectPosition: "0% 77%"}}/>
            <Card.Body>
                <Card.Title className="title" style={{fontSize: "20px", color: "white", display: "flex", justifyContent: "center"}}>{name}</Card.Title>
                <Card.Text className="location" style={{fontSize: "12px"}}>
                    {location}
                </Card.Text>
                <Card.Text className="price" style = {{display: "flex", justifyContent: "center"}}>
                    {price}
                </Card.Text>
                <div className="row-decision">
                    <div className="row-price">

                        <div style={{display: "flex", alignItems: "baseline"}}>
                            <Button style={{marginRight: "5px"}} variant="outline-primary" onClick={() => {
                                if (counter > 0) setCounter(counter - 1)
                            }}>
                                -
                            </Button>
                            <span style={{color: "white", margin: "5px"}}>{counter}</span>
                            <Button style={{marginLeft: "5px"}} variant="outline-primary"
                                    onClick={() => setCounter(counter + 1)}>
                                +
                            </Button>
                        <   /div>
                    </div>
                    <Button size="sm"
                            variant="primary"
                            style={{marginLeft: "20px"}}
                            onClick={() => console.log("adding")}
                    >В корзину</Button>
                </div>
            </Card.Body>
        </Card>
    );
};

export default ProductCard;