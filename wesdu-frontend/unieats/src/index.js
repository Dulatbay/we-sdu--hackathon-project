import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import './index.css'
import {ReactKeycloakProvider} from '@react-keycloak/web'
/*
React Bootstrap configuration
 */
import "../node_modules/react-bootstrap/dist/react-bootstrap.min";
import "../node_modules/bootstrap/dist/css/bootstrap.css";
import {Provider} from "react-redux";
import {store} from "./Store";
import Keycloak from "keycloak-js";
import keycloak from "./keycloak";


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <ReactKeycloakProvider authClient={keycloak}>
        <Provider store={store}>
            <App/>
        </Provider>
    </ReactKeycloakProvider>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
