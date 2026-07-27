// Scorebelow70.js
// This component filters and displays players with scores below or equal to 70

import React from 'react';

function Scorebelow70({ players }) {
    // Create an empty array to store players with score <= 70
    let players70 = [];

    // .map() loops through each player
    players.map((item) => {
        // Check if player's score is less than or equal to 70
        if (item.score <= 70) {
            // If true, add the player to the players70 array
            // .push() adds an item to the end of an array
            players70.push(item);
        }
        // Return nothing (we just want to filter, not display here)
        return null;
    });

    return (
        <div>
            {/* Display the filtered players */}
            {players70.map((item, index) => {
                return (
                    <div key={index} style={{ padding: '5px 0' }}>
                        <span>Mr. {item.name}</span>
                        <span> {item.score}</span>
                    </div>
                );
            })}
        </div>
    );
}

export default Scorebelow70;