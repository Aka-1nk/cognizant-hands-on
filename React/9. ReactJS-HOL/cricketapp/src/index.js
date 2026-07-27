// index.js - Entry point of the application
// This file tells React where to render the App

import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';

// Find the root element in index.html and create a React root
const root = ReactDOM.createRoot(document.getElementById('root'));

// Render the App component inside the root
root.render(
    // React.StrictMode helps catch potential problems during development
    <React.StrictMode>
        <App />
    </React.StrictMode>
);