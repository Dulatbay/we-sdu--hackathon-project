import React from 'react';
import './Detail.css'
import {useParams} from "react-router-dom";
import {useGetProductDetailByIdQuery} from "../../Services/place";

const Detail = () => {
    const {id} = useParams()
    const {data, error, isLoading} = useGetProductDetailByIdQuery(id)
    if(isLoading) return <>loading</>
    console.log(data)
    return (
        <>
            <div className="card mb-3 w-50 m-auto">
                <img
                    src="https://primebeef.ru/images/cms/thumbs/a5b0aeaa3fa7d6e58d75710c18673bd7ec6d5f6d/img_3911_500_306_5_100.jpg"
                    className="card-img-top" alt="..."/>
                <div className="card-body">
                    <h5 className="card-title">{
                        data.name
                    }</h5>
                    <p className="card-text text-black">{
                        data.description
                    }</p>
                    <p className="card-text"><small className="text-muted">Created 5 days ago</small></p>
                </div>
            </div>
        </>
    );
};

export default Detail;