import React from 'react';
import './Receipt.css'
import {Button} from "react-bootstrap";
import RightCart from "../RightCart/RightCart";

const Receipt = () => {
    return (
        <div className="content container-fluid d-flex flex-row justify-content-center align-items-center">
            {/* Left Cart */}
            <div className="left-cart col-6 mt-3">
                {/* Stages */}
                <div className="row" style={{ fontFamily: 'Inter', textAlign: 'center' }}>
                    <div className="col-4">
                        <span className="text-center" style = {{color: "white"}}>Корзина</span>
                        <hr className="bg-secondary mt-1" style = {{color: "white"}}/>
                    </div>
                    <div className="col-4">
                        <span className="text-center" style = {{color: "white"}}>Оформление</span>
                        <hr className="bg-secondary mt-1" style = {{color: "white"}}/>
                    </div>
                    <div className="col-4 text-success">
                        <span className="text-center" >Заказ принят</span>
                        <hr className="bg-success mt-1" />
                    </div>
                </div>

                {/* Payment Details */}
                <div
                    className="col mt-3"
                    style={{
                        borderRadius: '30px',
                        display: 'flex',
                        flexDirection: "column",
                        color: '#FFF',
                        fontFamily: 'Inter',
                        fontSize: '24px',
                        padding: '20px 40px',
                        fontStyle: 'normal',
                        fontWeight: '600',
                        lineHeight: 'normal',
                        background: '#222',
                    }}
                >
                    <span className="mb-3 text-center">Чек:</span>
                    {/* Payment information */}
                    <div className="mb-3" style = {{display: "flex", justifyContent: "space-between"}}>
                        <span>Номер заказа:</span>
                        <span className="col-4">3226</span>
                    </div>
                    <div className="mb-3" style = {{display: "flex", justifyContent: "space-between"}}>
                        <span>Дата:</span>
                        <span className="col-4">26.11.2023</span>
                    </div>
                    <div className="mb-3" style = {{display: "flex", justifyContent: "space-between"}}>
                        <span>Время:</span>
                        <span className="col-4">09:00</span>
                    </div>
                    <div className="mb-3" style = {{display: "flex", justifyContent: "space-between"}}>
                        <span>Форма оплаты:</span>
                        <span className="col-4">Наличные</span>
                    </div>
                    <div className="mb-3" style = {{display: "flex", justifyContent: "space-between"}}>
                        <span>Сумма оплаты:</span>
                        <span className="col-4">2760 тенге</span>
                    </div>
                    <div className="mb-3" style = {{display: "flex", justifyContent: "space-between"}}>
                        <span>Время доставки/самовывоза:</span>
                        <span className="col-4">10:00 - 11:00</span>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Receipt;
