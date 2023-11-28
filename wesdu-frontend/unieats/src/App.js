import React from 'react'
import './App.css';
import Navbar from './Components/NavBar/Navbar'
import ProductCard from "./Components/ProductCard/ProductCard";
import Filter from "./Components/Filter/Filter";
import Detail from "./Components/Detail/Detail";
import Cart from './Components/Cart/Cart'
import Receipt from "./Components/Receipt/Receipt";
import Checkout from "./Components/Checkout/Checkout";
import OrderDetails from "./Components/OrderDetails/OrderDetails";
import SDUNavbar from "./Components/NavBar/Navbar";
import ProductsUi from "./Components/ProductsUi/ProductsUi";
import {
    createBrowserRouter,
    RouterProvider
} from "react-router-dom";
import PlaceCards from "./Components/ProductCards/PlaceCards";

const router = createBrowserRouter([
    {
        path: "/",
        element: <>
            <SDUNavbar />
            <ProductsUi />
        </>,
    },
    {
        path: "/product-detail/:id",
        element: <>
            <SDUNavbar />
            <Detail />
        </>
    },
    {
        path: "/cart",
        element: <>
            <SDUNavbar/>
            <Cart/>
        </>
    },
    {
        path: "/cart/confirmation",
        element: <>
            <SDUNavbar />
            <Checkout />
        </>
    },
    {
        path: "/cart/confirmation/cheque",
        element: <>
            <SDUNavbar />
            <Receipt />
        </>
    },
    {
        path: "/places",
        element: <>
            <SDUNavbar />
            <PlaceCards />
        </>
    }
]);
let App = () => {
    return (
        <RouterProvider router={router}>
            {/*<SDUNavbar/>*/}
            {/* <Filter/>
          <ProductCard/>
          <Detail/>
          <Cart/>
          <Receipt/>
          <Checkout/>
          <OrderDetails/>
          */}
            {/*<ProductsUi/>*/}

        </RouterProvider>
    );
}

export default App;
