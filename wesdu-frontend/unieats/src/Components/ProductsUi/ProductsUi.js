import React, {useState} from 'react'
import './ProductsUi.css';
import SDUNavbar from "../NavBar/Navbar";
import Filter from "../Filter/Filter";
import ProductCard from "../ProductCard/ProductCard";
import {useGetAllPlacesQuery} from "../../Services/place";
import {Form} from "react-bootstrap";
import TFilter from "../TestingFilter/TFilter";
import LocationFilter from "../TestingFilter/TFilter";

let ProductsUi = () => {
    const [selectedPlaceIndex, setSelectedPlaceIndex] = useState(0);
    const {data, error, isLoading} = useGetAllPlacesQuery();
    console.log(data)
    if (isLoading) return "..."

    return (
        <div className={"m-5 text-white"}>
            <h3>All places</h3>
            <Form>
                {
                    data.map((i, index) =>
                        <Form.Check
                            onChange={() => setSelectedPlaceIndex(index)}
                            className={"text-white"}
                            type={"radio"}
                            id={`default-${i.id}`}
                            checked={index === selectedPlaceIndex}
                            label={`${i.name} - ${i.product_dto_list.length}`}
                        />)
                }
            </Form>
            {/*<Filter/>*/}
            <div className="col mt-3 m-3" style={{
                color: '#FFF',
                fontFamily: 'Inter',
                fontSize: '32px',
                fontStyle: 'normal',
                fontWeight: '600',
                lineHeight: 'normal',
                textAlign: 'start'
            }}>
                Товары
            </div>
            <div className="product-cards">
                {
                    data[selectedPlaceIndex]
                        .product_dto_list
                        .map(i =>
                            <div className="product-card">
                                <ProductCard productImage={i.image_url} name={i.name} location={i.location} price={i.price} id={i.id}/>
                            </div>
                        )
                }
            </div>
        </div>
    );
}

export default ProductsUi;
