// EvenPlayers.js
// This component displays players at even positions (2nd, 4th, 6th)

import React from 'react';

// Use different variable names for skipped positions
// Instead of using _ multiple times, use different names
export function EvenPlayers([, second, , fourth, , sixth]) {
    //          Notice: Just commas with nothing between them!
    //          This skips the elements we don't need
    return (
        <div>
            <li>Second : {second}</li>
            <li>Fourth : {fourth}</li>
            <li>Sixth : {sixth}</li>
        </div>
    );
}