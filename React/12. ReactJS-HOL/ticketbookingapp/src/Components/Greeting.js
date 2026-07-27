import React from 'react';

function UserGreeting() {
  return (
    <div style={styles.userContainer}>
      <h2>Welcome back, User! 🎉</h2>
      <p>You can now book flight tickets.</p>
    </div>
  );
}

function GuestGreeting() {
  return (
    <div style={styles.guestContainer}>
      <h2>Please sign up.</h2>
      <p>Sign up or login to book flight tickets.</p>
    </div>
  );
}

function Greeting(props) {
  const isLoggedIn = props.isLoggedIn;
  if (isLoggedIn) {
    return <UserGreeting />;
  }
  return <GuestGreeting />;
}

// Styling
const styles = {
  userContainer: {
    backgroundColor: '#d4edda',
    padding: '20px',
    borderRadius: '8px',
    marginBottom: '20px',
    textAlign: 'center'
  },
  guestContainer: {
    backgroundColor: '#fff3cd',
    padding: '20px',
    borderRadius: '8px',
    marginBottom: '20px',
    textAlign: 'center'
  }
};

export default Greeting;