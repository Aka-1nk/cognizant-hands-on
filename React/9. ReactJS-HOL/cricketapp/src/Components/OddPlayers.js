// OddPlayers.js
// This component displays players at odd positions (1st, 3rd, 5th)
// Using ES6 Destructuring to extract specific elements from the array

import React from 'react';

// Destructuring the array directly in the function parameters
// [first, third, fifth] extracts the 1st, 3rd, and 5th elements from the array
// The array is passed as a parameter
export function OddPlayers([first, third, fifth]) {
    return (
        <div>
            {/* Display the extracted players */}
            <li>First : {first}</li>
            <li>Third : {third}</li>
            <li>Fifth : {fifth}</li>
        </div>
    );
}

// This is the same component written in a simpler way:
// function OddPlayers(props) {
//     const [first, third, fifth] = props.teamArray;
//     return (
//         <div>
//             <li>First : {first}</li>
//             <li>Third : {third}</li>
//             <li>Fifth : {fifth}</li>
//         </div>
//     );
// }