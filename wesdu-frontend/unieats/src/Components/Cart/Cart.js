import React from 'react';
import './Cart.css'
import {Button} from "react-bootstrap";
import RightCart from "../RightCart/RightCart";
import ProductCard from "../ProductCard/ProductCard";
import Doner from '../../Image/Doner.jpg'
import Samsa from '../../Image/samsa.png'
import Donut from '../../Image/donut.jpg'
import Burger from '../../Image/Burger.jpg'

const Cart = () => {

    const data = [
        {name: "Doner", price: 1290, location: "Belka Food", count: 1, productImage: Doner},
        {name: "Samsa", price: 320, location: "AC cafeteria F-Block", count: 1, productImage: Samsa},
        {name: "Burger", price: 990, location: "Doner House", count: 1, productImage: Burger},
        {name: "Donut", price: 160, location: "AC cafeteria H-Block", count: 1, productImage: Donut}
    ]

    return (
        <div className="content container-fluid d-flex flex-row justify-content-between align-items-top">
            <div className="left-cart col-6 mt-3" style={{width: "70%"}}>
                <div className="row" style={{fontFamily: 'Inter', textAlign: 'center'}}>
                    <div className="col-4 text-success">
                        <span className="text-center">Корзина</span>
                        <hr className="bg-success mt-1"/>
                    </div>
                    <div className="col-4">
                        <a className="text-center" style={{color: "white"}}
                           href="http://localhost:3000/cart/confirmation">Оформление</a>
                        <hr style={{color: "white"}} className="bg-secondary mt-1"/>
                    </div>
                    <div className="col-4">
                        <a className="text-center" style={{color: "white"}} href="http://localhost:3000/cart/status">Заказ
                            принят</a>
                        <hr style={{color: "white"}} className="bg-secondary mt-1"/>
                    </div>
                </div>
                <div style={{display: "flex", flexWrap: "wrap"}}>
                    {data.map((order) => (
                        <div style={{marginLeft: "5px"}}>
                            <ProductCard name={order.name} location={order.location} price={order.price} id={order.id}
                                         productImage={order.productImage}/>
                        </div>
                    ))}
                </div>
            </div>
            {/* Cart item */}
                <RightCart  status="Дальше"/>
        </div>
    );
};

export default Cart;
