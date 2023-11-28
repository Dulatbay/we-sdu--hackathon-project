import React from 'react';
import './Filter.css'

const Filter = () => {
    return (
        <div className="card bg-dark col mt-3 p-3 d-flex flex-row justify-content-between">
            <form className="d-flex flex-column col" action="/action_page.php" method="get">
                <div className="inputs d-flex flex-row justify-content-between">
                    <div className="place-select col-5">
                        <h5 className="card-title" style = {{color: "white"}}>Место</h5>
                        <select className="custom-select">
                            <option selected>Все</option>
                            <option value="1">Место 1</option>
                            <option value="2">Место 2</option>
                        </select>
                    </div>
                    <div className="price-select col-4">
                        <h5 className="card-title" style = {{color: "white"}}>Цена</h5>
                        <div className="pricecontainer d-flex flex-column">
                            {/* min max */}
                            <label htmlFor="minprice">Мин</label>
                            <input type="number" id="minprice" name="minprice" defaultValue="0" min="0" max="100000" />
                            <label htmlFor="maxprice">Макс</label>
                            <input type="number" id="maxprice" name="maxprice" defaultValue="100000" min="0" max="100000" />
                        </div>
                    </div>
                </div>
                <div className="col-3">
                    <button type="submit" className="btn btn-primary">Применить</button>
                </div>
            </form>
        </div>
    );
};

export default Filter;
