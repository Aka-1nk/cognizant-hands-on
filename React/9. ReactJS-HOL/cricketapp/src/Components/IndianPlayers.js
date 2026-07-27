// IndianPlayers.js
// This file contains the data for Indian players
// Using ES6 Spread Operator (...) to merge arrays

import React from 'react';

// Array of T20 players
const T20Players = ['First Player', 'Second Player', 'Third Player'];

// Array of Ranji Trophy players
const RanjiTrophyPlayers = ['Fourth Player', 'Fifth Player', 'Sixth Player'];

// Merge both arrays using the Spread Operator (...)
// The spread operator (...) takes all elements from an array and puts them into a new array
// This is like copying all items from one array into another
export const IndianPlayers = [...T20Players, ...RanjiTrophyPlayers];

// Alternative way without spread operator:
// const IndianPlayers = T20Players.concat(RanjiTrophyPlayers);