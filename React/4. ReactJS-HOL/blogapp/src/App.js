import React from 'react';
import './App.css';
import Posts from './Posts';

console.log('App.js is loading!');  // ← Add this line

function App() {
    console.log('App component is rendering!');  // ← Add this line
    return (
        <div className="App">
            <Posts />
        </div>
    );
}

export default App;