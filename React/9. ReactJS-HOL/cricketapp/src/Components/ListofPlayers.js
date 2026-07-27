// ListofPlayers.js
// This component displays all players with their names and scores

import React from 'react';

// This is a functional component that receives 'players' as props
function ListofPlayers({ players }) {
    return (
        <div>
            {/* 
                .map() is an ES6 array method that loops through each item in the array
                For each player, it creates a div with their name and score
                'item' represents each player object in the array
                'index' is the position of the item in the array (0, 1, 2, ...)
            */}
            {players.map((item, index) => {
                return (
                    // key={index} helps React identify which items have changed
                    // It should be unique for each item
                    <div key={index} style={{ padding: '5px 0' }}>
                        {/* Display player name with "Mr." prefix */}
                        <span>Mr. {item.name}</span>
                        {/* Display player score */}
                        <span> {item.score}</span>
                    </div>
                );
            })}
        </div>
    );
}

// Export the component so it can be used in other files
export default ListofPlayers;