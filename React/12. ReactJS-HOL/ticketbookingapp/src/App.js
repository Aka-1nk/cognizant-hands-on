import React, { useState } from 'react';
import Navbar from './Components/Navbar';
import Greeting from './Components/Greeting';
import FlightList from './Components/FlightList';
import './App.css';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLogin = () => {
    setIsLoggedIn(true);
  };

  const handleLogout = () => {
    setIsLoggedIn(false);
  };

  return (
    <div className="App">
      <Navbar 
        isLoggedIn={isLoggedIn}
        onLogin={handleLogin}
        onLogout={handleLogout}
      />
      
      <main style={styles.main}>
        <Greeting isLoggedIn={isLoggedIn} />
        <FlightList isLoggedIn={isLoggedIn} />
      </main>
    </div>
  );
}

const styles = {
  main: {
    padding: '20px',
    maxWidth: '1200px',
    margin: '0 auto',
    backgroundColor: '#f8f9fa',
    minHeight: 'calc(100vh - 80px)'
  }
};

export default App;