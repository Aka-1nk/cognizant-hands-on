// App.js - Main Application
// This is the main component that displays everything

import React from 'react';
import './App.css';

// Import all components
import ListofPlayers from './Components/ListofPlayers';
import Scorebelow70 from './Components/Scorebelow70';
import { OddPlayers } from './Components/OddPlayers';
import { EvenPlayers } from './Components/EvenPlayers';
import ListofIndianPlayers from './Components/ListofIndianPlayers';
import { IndianPlayers } from './Components/IndianPlayers';

function App() {
    // ============================================
    // DATA DECLARATION
    // ============================================
    
    // Array of 11 players with their names and scores
    // Each player is an object with 'name' and 'score' properties
    const players = [
        { name: 'Jack', score: 50 },
        { name: 'Michael', score: 70 },
        { name: 'John', score: 40 },
        { name: 'Ann', score: 61 },
        { name: 'Elisabeth', score: 61 },
        { name: 'Sachin', score: 95 },
        { name: 'Dhoni', score: 100 },
        { name: 'Virat', score: 84 },
        { name: 'Jadeja', score: 64 },
        { name: 'Raina', score: 75 },
        { name: 'Rohit', score: 80 }
    ];

    // Indian team array for odd/even players
    // These are the names of Indian players at different positions
    const IndianTeam = [
        'Sachin1',   // Position 1
        'Dhoni2',    // Position 2
        'Virat3',    // Position 3
        'Rohit4',    // Position 4
        'Yuvaraj5',  // Position 5
        'Raina6'     // Position 6
    ];

    // ============================================
    // FLAG VARIABLE (Controls which view to show)
    // ============================================
    
    // When flag = true, show the players list with scores
    // When flag = false, show the Indian team with odd/even players
    var flag = true;
    
    // ============================================
    // RENDERING BASED ON FLAG
    // ============================================
    
    // if-else condition to decide which view to display
    if (flag === true) {
        // When flag is true: Show players list and scores below 70
        return (
            <div style={{ padding: '20px', fontFamily: 'Arial' }}>
                {/* Display heading */}
                <h1>List of Players</h1>
                
                {/* Pass 'players' array as props to ListofPlayers component */}
                <ListofPlayers players={players} />
                
                {/* Horizontal line separator */}
                <hr />
                
                {/* Display heading for filtered players */}
                <h1>List of Players having Scores Less than 70</h1>
                
                {/* Pass 'players' array to Scorebelow70 component */}
                <Scorebelow70 players={players} />
            </div>
        );
    } else {
        // When flag is false: Show Indian team details
        return (
            <div style={{ padding: '20px', fontFamily: 'Arial' }}>
                {/* Main heading */}
                <h1>Indian Team</h1>
                
                {/* Odd Players Section */}
                <h1>Odd Players</h1>
                {/* Pass IndianTeam array to OddPlayers component */}
                {/* Destructuring will extract 1st, 3rd, 5th elements */}
                {OddPlayers(IndianTeam)}
                
                <hr />
                
                {/* Even Players Section */}
                <h1>Even Players</h1>
                {/* Pass IndianTeam array to EvenPlayers component */}
                {/* Destructuring will extract 2nd, 4th, 6th elements */}
                {EvenPlayers(IndianTeam)}
                
                <hr />
                
                {/* Merged Indian Players Section */}
                <h1>List of Indian Players Merged:</h1>
                {/* Pass merged IndianPlayers array to ListofIndianPlayers */}
                <ListofIndianPlayers IndianPlayers={IndianPlayers} />
            </div>
        );
    }
}

// Export the App component so it can be used in index.js
export default App;