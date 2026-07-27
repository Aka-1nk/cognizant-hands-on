// ListofIndianPlayers.js
// This component displays all merged Indian players

import React from 'react';

function ListofIndianPlayers({ IndianPlayers }) {
    return (
        <div>
            {/* Loop through the merged Indian players array */}
            {IndianPlayers.map((item, index) => {
                return (
                    <div key={index} style={{ padding: '5px 0' }}>
                        <span>Mr. {item}</span>
                    </div>
                );
            })}
        </div>
    );
}

export default ListofIndianPlayers;