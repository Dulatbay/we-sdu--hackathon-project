import React from 'react';
import {useGetAllPlacesQuery} from "../../Services/place";
import PlaceCard from "../PlaceCard/PlaceCard";

function PlaceCards() {
    const {data, error, isLoading} = useGetAllPlacesQuery();
    if (isLoading) return <></>
    return (
        <div>
            {
                data.map(i => {
                        console.log(i)
                        return <PlaceCard title={i.name} description={i.description}/>
                    }
                )
            }
        </div>
    );
}

export default PlaceCards;