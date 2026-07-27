import React from 'react';
import LoginButton from './LoginButton';
import LogoutButton from './LogoutButton';

function Navbar({ isLoggedIn, onLogin, onLogout }) {
  return (
    <nav style={styles.navbar}>
      <div style={styles.logo}>
        <span style={styles.logoText}>✈️ TicketBooking</span>
      </div>
      <div style={styles.buttons}>
        {isLoggedIn ? (
          <LogoutButton onClick={onLogout} />
        ) : (
          <LoginButton onClick={onLogin} />
        )}
      </div>
    </nav>
  );
}

const styles = {
  navbar: {
    backgroundColor: '#2c3e50',
    padding: '15px 30px',
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center',
    boxShadow: '0 2px 10px rgba(0,0,0,0.2)'
  },
  logo: {
    display: 'flex',
    alignItems: 'center'
  },
  logoText: {
    color: 'white',
    fontSize: '24px',
    fontWeight: 'bold'
  },
  buttons: {
    display: 'flex',
    gap: '10px'
  }
};

export default Navbar;