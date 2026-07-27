// App.js - Office Space Rental Application
// This file demonstrates JSX, attributes, expressions, and inline CSS

import React from 'react';
import './App.css';

function App() {
    // ============================================
    // 1. JSX ELEMENT FOR HEADING
    // ============================================
    
    // Creating an element variable for the heading
    // This is a string that will be displayed in the h1 tag
    const element = "Office Space";
    
    // ============================================
    // 2. JSX ATTRIBUTE FOR IMAGE
    // ============================================
    
    // Image source URL - using a free office space image
    const sr = "https://images.unsplash.com/photo-1497366216548-37526070297c?w=500&h=300&fit=crop";
    
    // Creating JSX for image with attributes
    // width and height are set to 25% using inline styling
    const jsxatt = (
        <img 
            src={sr} 
            width="25%" 
            height="25%" 
            alt="Office Space" 
        />
    );
    
    // ============================================
    // 3. JSX OBJECT FOR SINGLE OFFICE
    // ============================================
    
    // Creating an object for a single office space
    // This object has three properties: Name, Rent, Address
    const ItemName = {
        Name: "DBS", 
        Rent: 50000, 
        Address: 'Chennai'
    };
    
    // ============================================
    // 4. JSX LIST OF OFFICE SPACES
    // ============================================
    
    // Creating an array of office space objects
    // Each object has Name, Rent, and Address properties
    const officeSpaces = [
        { Name: "DBS", Rent: 50000, Address: 'Chennai' },
        { Name: "TCS", Rent: 65000, Address: 'Mumbai' },
        { Name: "Infosys", Rent: 45000, Address: 'Bangalore' },
        { Name: "Wipro", Rent: 70000, Address: 'Hyderabad' },
        { Name: "HCL", Rent: 55000, Address: 'Noida' }
    ];
    
    // ============================================
    // 5. RENDER THE COMPONENT
    // ============================================
    
    return (
        <div className="App">
            {/* 
                ==========================================
                SECTION 1: HEADING WITH JSX EXPRESSION
                ==========================================
                Using curly braces to embed JavaScript expression
                The element variable contains the heading text
            */}
            <h1>{element}, at Affordable Range</h1>
            
            {/* 
                ==========================================
                SECTION 2: IMAGE WITH JSX ATTRIBUTES
                ==========================================
                The jsxatt variable contains the img element
                with src, width, height, and alt attributes
            */}
            {jsxatt}
            
            {/* 
                ==========================================
                SECTION 3: SINGLE OFFICE DETAILS
                ==========================================
                Displaying details of a single office space
                Using dot notation to access object properties
            */}
            <h2>Name: {ItemName.Name}</h2>
            <h3>Rent: Rs. {ItemName.Rent}</h3>
            <h3>Address: {ItemName.Address}</h3>
            
            {/* Horizontal line separator */}
            <hr />
            
            {/* 
                ==========================================
                SECTION 4: LIST OF OFFICE SPACES
                ==========================================
                Using map() to loop through the array
                For each office space, we display its details
                The key attribute helps React identify items
            */}
            <h2>Available Office Spaces:</h2>
            
            {officeSpaces.map((office, index) => {
                // ==========================================
                // CONDITIONAL STYLING FOR RENT
                // ==========================================
                // Following the hint exactly:
                // If Rent is <= 60000, use 'textRed' class
                // If Rent is > 60000, use 'textGreen' class
                
                let colors = [];
                if (office.Rent <= 60000) {
                    colors.push('textRed');
                } else {
                    colors.push('textGreen');
                }
                
                // Return JSX for each office
                return (
                    <div key={index} className="office-card">
                        <h3>Name: {office.Name}</h3>
                        {/* 
                            Applying conditional CSS class
                            The className uses the colors array
                            colors[0] will be either 'textRed' or 'textGreen'
                        */}
                        <h3 className={colors[0]}>Rent: Rs. {office.Rent}</h3>
                        <h3>Address: {office.Address}</h3>
                        <hr />
                    </div>
                );
            })}
        </div>
    );
}

export default App;