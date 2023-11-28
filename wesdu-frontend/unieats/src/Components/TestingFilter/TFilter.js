import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css'; // Import Bootstrap CSS
import './TFilter.css'; // Import your custom CSS for additional styling if needed

const LocationFilter = () => {
    const [selectedLocation, setSelectedLocation] = useState('');

    const locations = [
        'New York',
        'San Francisco',
        'London',
        'Tokyo',
        'Sydney',
        // Add more locations as needed
    ];

    const handleLocationChange = (event) => {
        setSelectedLocation(event.target.value);
    };

    const applyLocationFilter = () => {
        console.log('Filtering content for location:', selectedLocation);
        // Add your filtering logic here based on the selectedLocation value
    };

    return (
        <div className="location-filter-container">
            <h1>Location-based Filter</h1>
            <form>
                {locations.map((location) => (
                    <div key={location} className="form-check">
                        <input
                            className="form-check-input"
                            type="radio"
                            name="locationRadio"
                            id={`location${location}`}
                            value={location}
                            checked={selectedLocation === location}
                            onChange={handleLocationChange}
                        />
                        <label className="form-check-label" htmlFor={`location${location}`}>
                            {location}
                        </label>
                    </div>
                ))}
            </form>
            <button className="btn btn-primary" onClick={applyLocationFilter}>
                Apply Filter
            </button>
        </div>
    );
};

export default LocationFilter;
