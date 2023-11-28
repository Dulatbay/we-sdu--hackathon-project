import React, { useState } from 'react';
import {Button, ButtonGroup, ToggleButton} from "react-bootstrap";
import './Checkout.css'
import RightCart from "../RightCart/RightCart";

const Checkout = () => {
    const [selectedAddress, setSelectedAddress] = useState('');
    const [selectedTime, setSelectedTime] = useState('');
    const [selectedPayment, setSelectedPayment] = useState('');

    const times = [
        { name: '09:00-10:00'},
        { name: '10:00-11:00'},
        { name: '11:00-12:00'},
        { name: '12:00-13:00'},
        { name: '13:00-14:00'},
        { name: '14:00-15:00'},
        { name: '15:00-16:00'},
        { name: '16:00-17:00'},
        { name: '17:00-18:00'},
    ];

    const payments = [
        {name: "Наличные"},
        {name: "kaspi"}
    ]

    const addresses = [
        {name: "AC cafeteria Блок H"},
        {name: "AC cafeteria Блок F"},
        {name: "Belka Food Блок F"},
        {name: "Doner House Блок F"},
    ]
    const handleAddressSelection = (address) => {
        setSelectedAddress(address);
    };

    const handleTimeSelection = (time) => {
        setSelectedTime(time);
    };

    const handlePaymentSelection = (paymentType) => {
        setSelectedPayment(paymentType);
    };

    return (
        <div className="content container-fluid d-flex flex-row justify-content-between ">
            <div className="left-cart col-6 mt-3">

                <div className="row" style={{ fontFamily: 'Inter', textAlign: 'center' }}>
                    <div className="col-4">
                        <a className="text-center" style = {{color: "white"}} href="http://localhost:3000/cart">Корзина</a>
                        <hr className="bg-secondary mt-1" style = {{color: "white"}}/>
                    </div>
                    <div className="col-4 text-success">
                        <span className="text-center">Оформление</span>
                        <hr className="bg-success mt-1"/>
                    </div>
                    <div className="col-4">
                        <span className="text-center" style = {{color: "white"}}>Заказ принят</span>
                        <hr className="bg-secondary mt-1" style = {{color: "white"}} />
                    </div>
                </div>

                <div className="col mt-3">
                    {/* Heading */}
                    <span style={{ color: '#FFF', fontFamily: 'Inter', fontSize: '32px', fontWeight: '600' }}>
              Оформление заказа
            </span>

                    {/* Address selection */}
                    <div className="adresses col mt-3" style={{
                        borderRadius: '30px',
                        display: 'flex',
                        flexDirection: 'column',
                        color: '#FFF',
                        fontFamily: 'Inter',
                        fontSize: '24px',
                        padding: '20px',
                        fontWeight: '600',
                        lineHeight: 'normal',
                        background: '#222',
                    }}>
                        <span style={{ marginBottom: '15px' }}>Адресы:</span>

                        <ButtonGroup className="mb-2">
                            {addresses.map((address, idx) => (
                                <ToggleButton
                                    size = "lg"
                                    key={idx}
                                    id={`address-${idx}`}
                                    type="radio"
                                    variant='outline-success'
                                    name="radio"
                                    value={address.name}
                                    checked={selectedAddress === address.name}
                                    onChange={(e) => handleAddressSelection(e.currentTarget.value)}
                                >
                                    {address.name}
                                </ToggleButton>
                            ))}
                        </ButtonGroup>
                        <p>Selected Address: {selectedAddress}</p>
                    </div>

                    {/* Time selection */}
                    <div className="time col mt-3" style={{
                        borderRadius: '30px',
                        display: 'flex',
                        flexDirection: 'column',
                        color: '#FFF',
                        fontFamily: 'Inter',
                        fontSize: '24px',
                        padding: '20px',
                        fontWeight: '600',
                        lineHeight: 'normal',
                        background: '#222',
                    }}>
                        <span style={{ marginBottom: '15px' }}>Время доставки/самовывоза</span>
                        <form className="col">
                            <ButtonGroup className="mb-2 btn-group">
                                {times.map((time, idx) => (
                                    <ToggleButton
                                        size = "lg"
                                        key={idx}
                                        id={`radio-${idx}`}
                                        type="radio"
                                        variant='outline-success'
                                        name="radio"
                                        value={time.name}
                                        checked={selectedTime === time.name}
                                        onChange={(e) => handleTimeSelection(e.currentTarget.value)}
                                    >
                                        {time.name}
                                    </ToggleButton>
                                ))}
                            </ButtonGroup>
                        </form>
                        <p>Selected Time: {selectedTime}</p>
                    </div>

                    {/* Payment selection */}
                    <div className="paymentType col mt-3" style={{
                        borderRadius: '30px',
                        display: 'flex',
                        flexDirection: 'column',
                        color: '#FFF',
                        fontFamily: 'Inter',
                        fontSize: '24px',
                        padding: '20px',
                        fontWeight: '600',
                        lineHeight: 'normal',
                        background: '#222',
                    }}>
                        <span style={{ marginBottom: '15px' }}>Способ оплаты</span>
                        <form className="col">

                            <ButtonGroup className="mb-2">
                                {payments.map((payment, idx) => (
                                    <ToggleButton
                                        size = "lg"
                                        key={idx}
                                        id={`payment-${idx}`}
                                        type="radio"
                                        variant='outline-success'
                                        name="radio"
                                        value={payment.name}
                                        checked={selectedPayment === payment.name}
                                        onChange={(e) => handlePaymentSelection(e.currentTarget.value)}
                                    >
                                        {payment.name}
                                    </ToggleButton>
                                ))}
                            </ButtonGroup>
                        </form>
                        <p>Selected Payment: {selectedPayment}</p>
                    </div>

                    {/* Add a button to submit the order */}
                </div>

            </div>
            <RightCart status="Оформить заказ"/>
        </div>
    );
};

export default Checkout;
