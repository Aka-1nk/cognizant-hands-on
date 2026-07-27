import React, { useState } from 'react';
import './App.css';

function App() {
    // ============================================
    // STATE VARIABLES
    // ============================================
    
    // State for counter
    const [count, setCount] = useState(0);
    
    // State for currency converter
    const [amount, setAmount] = useState('');
    const [currency, setCurrency] = useState('USD');
    const [convertedAmount, setConvertedAmount] = useState(null);
    
    // ============================================
    // 1. INCREMENT AND DECREMENT BUTTONS
    // ============================================
    
    // Method 1a: Increment the value
    const incrementCounter = () => {
        setCount(count + 1);
    };
    
    // Method 1b: Say Hello with static message
    const sayHello = () => {
        alert('Hello! Welcome to Event Examples App');
    };
    
    // Method that invokes multiple methods (1a and 1b together)
    const handleIncrement = () => {
        incrementCounter();  // Increment the counter
        sayHello();          // Show hello message
    };
    
    // Decrement the value
    const decrementCounter = () => {
        setCount(count - 1);
    };
    
    // ============================================
    // 2. SAY WELCOME BUTTON WITH ARGUMENT
    // ============================================
    
    // Function that takes "welcome" as an argument
    const sayWelcome = (message) => {
        alert(message + '! Welcome to our application!');
    };
    
    // ============================================
    // 3. SYNTHETIC EVENT - OnPress (Click)
    // ============================================
    
    // Function that displays "I was clicked"
    const handleClickMe = () => {
        alert('I was clicked');
    };
    
    // ============================================
    // 4. CURRENCY CONVERTER
    // ============================================
    
    // Handle amount input change
    const handleAmountChange = (event) => {
        setAmount(event.target.value);
    };
    
    // Handle currency selection change
    const handleCurrencyChange = (event) => {
        setCurrency(event.target.value);
    };
    
    // Handle form submission - Convert currency
    const handleSubmit = (event) => {
        event.preventDefault(); // Prevent page refresh
        
        // Conversion rates (1 INR to other currencies)
        const conversionRates = {
            USD: 0.012,
            EUR: 0.011,
            GBP: 0.0095,
            JPY: 1.78,
            AUD: 0.018
        };
        
        const rate = conversionRates[currency];
        if (rate && amount) {
            const result = parseFloat(amount) * rate;
            setConvertedAmount(result.toFixed(2));
        } else {
            alert('Please enter a valid amount');
        }
    };
    
    // ============================================
    // RENDER THE COMPONENT
    // ============================================
    
    return (
        <div className="App">
            <h1>Event Examples App</h1>
            
            {/* ==========================================
                SECTION 1: INCREMENT / DECREMENT
                ========================================== */}
            <div className="section">
                <h2>Counter Example</h2>
                <p>Counter Value: <strong>{count}</strong></p>
                
                {/* 
                    Button 1: Increment - invokes multiple methods
                    onClick calls handleIncrement which calls both 
                    incrementCounter() and sayHello()
                */}
                <button onClick={handleIncrement}>Increment</button>
                
                {/* Button 2: Decrement - just decrements the counter */}
                <button onClick={decrementCounter}>Decrement</button>
            </div>
            
            <hr />
            
            {/* ==========================================
                SECTION 2: SAY WELCOME WITH ARGUMENT
                ========================================== */}
            <div className="section">
                <h2>Welcome Example</h2>
                {/* 
                    Button that calls sayWelcome with "welcome" as argument
                    Uses arrow function to pass the argument
                */}
                <button onClick={() => sayWelcome('welcome')}>
                    Say Welcome
                </button>
            </div>
            
            <hr />
            
            {/* ==========================================
                SECTION 3: SYNTHETIC EVENT - Click
                ========================================== */}
            <div className="section">
                <h2>Synthetic Event Example</h2>
                {/* 
                    Button that displays "I was clicked" when clicked
                    This is a synthetic event (React's wrapper around native event)
                */}
                <button onClick={handleClickMe}>Click on me</button>
            </div>
            
            <hr />
            
            {/* ==========================================
                SECTION 4: CURRENCY CONVERTER
                ========================================== */}
            <div className="section">
                <h2>Currency Converter!!!</h2>
                
                <form onSubmit={handleSubmit}>
                    <div className="form-group">
                        <label>Amount:</label>
                        <input 
                            type="number" 
                            value={amount} 
                            onChange={handleAmountChange}
                            placeholder="Enter amount in INR"
                            step="0.01"
                        />
                    </div>
                    
                    <div className="form-group">
                        <label>Currency:</label>
                        <select value={currency} onChange={handleCurrencyChange}>
                            <option value="USD">USD - US Dollar</option>
                            <option value="EUR">EUR - Euro</option>
                            <option value="GBP">GBP - British Pound</option>
                            <option value="JPY">JPY - Japanese Yen</option>
                            <option value="AUD">AUD - Australian Dollar</option>
                        </select>
                    </div>
                    
                    <button type="submit">Convert</button>
                </form>
                
                {/* Display converted amount */}
                {convertedAmount !== null && (
                    <div className="result">
                        <h3>Converted Amount:</h3>
                        <p>{amount} INR = {convertedAmount} {currency}</p>
                    </div>
                )}
            </div>
        </div>
    );
}

export default App;