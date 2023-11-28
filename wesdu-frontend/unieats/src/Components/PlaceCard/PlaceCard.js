import React from 'react';

const PlaceCard = ({title, description}) => {
    return (
        <div className="card">
            <img src="..." className="card-img-top" alt="..."/>
            <div className="card-body">
                <h5 className="card-title">{title}</h5>
                <p className="card-text text-black">{description}</p>
                <a href="#" className="btn btn-primary">Купить что-то у магазина</a>
            </div>
        </div>
    );
};

export default PlaceCard;