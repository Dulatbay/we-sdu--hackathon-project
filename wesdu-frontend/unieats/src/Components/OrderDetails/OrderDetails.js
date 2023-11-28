import React from 'react';
import './OrderDetails.css'
import { CheckCircleFill, XCircleFill } from 'react-bootstrap-icons';

const OrderDetails = () => {
    return (
        <div className="content container-fluid d-flex flex-column justify-content-start">
            <div className="col mt-3" style={{ color: '#FFF', fontFamily: 'Inter', fontSize: '32px', fontStyle: 'normal', fontWeight: '600', lineHeight: 'normal', textAlign: 'center' }}>
                Подробности заказа
            </div>

            <div className="col-6 mt-3" style = {{marginLeft: "20px"}} >
                <div className="rounded " style={{ borderRadius: '30px', width: '40%', background: '#222', color: '#FFF', fontFamily: 'Inter', fontSize: '28px', fontStyle: 'normal', fontWeight: '600', lineHeight: 'normal', textAlign: 'center', padding: '10px 0'}}>
                    Заказ #12123
                </div>

                <div className="col mt-3">
                    <div className="rounded" style={{ borderRadius: '30px', fontFamily: 'Inter', fontSize: '28px', fontStyle: 'normal', fontWeight: '600', lineHeight: 'normal' }}>
                        <div className="check">
                            <CheckCircleFill className="text-success" />
                            <span className="m-4 text-white">Заказ оплачен</span>
                        </div>
                    </div>
                </div>

                <div className="col mt-3">
                    <div className="rounded" style={{ borderRadius: '30px', fontFamily: 'Inter', fontSize: '28px', fontStyle: 'normal', fontWeight: '600', lineHeight: 'normal' }}>
                        <div className="check">
                            <CheckCircleFill className="text-success" />
                            <span className="m-4 text-white">Заказ в очереди</span>
                        </div>
                    </div>
                </div>

                <div className="col mt-3">
                    <div className="rounded" style={{ fontFamily: 'Inter', fontSize: '28px', fontStyle: 'normal', fontWeight: '600', lineHeight: 'normal' }}>
                        <div className="check">
                            <XCircleFill className="text-danger" />
                            <span className="m-4 text-white">Заказ готовится</span>
                        </div>
                    </div>
                </div>

                <div className="col mt-3">
                    <div className="rounded" style={{ borderRadius: '30px', fontFamily: 'Inter', fontSize: '28px', fontStyle: 'normal', fontWeight: '600', lineHeight: 'normal' }}>
                        <div className="check">
                            <XCircleFill className="text-danger" />
                            <span className="m-4 text-white">Заберите заказ</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default OrderDetails;
