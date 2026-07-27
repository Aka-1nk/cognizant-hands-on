import React from 'react';

function FlightList({ isLoggedIn }) {
  const flights = [
    { id: 1, airline: 'Emirates', from: 'New York', to: 'Dubai', price: '$850', time: '10:00 AM' },
    { id: 2, airline: 'Singapore Airlines', from: 'London', to: 'Singapore', price: '$720', time: '11:30 AM' },
    { id: 3, airline: 'Qatar Airways', from: 'Paris', to: 'Doha', price: '$680', time: '2:15 PM' },
    { id: 4, airline: 'Delta Airlines', from: 'Los Angeles', to: 'Tokyo', price: '$950', time: '4:45 PM' },
    { id: 5, airline: 'British Airways', from: 'Chicago', to: 'London', price: '$590', time: '6:20 PM' }
  ];

  return (
    <div style={styles.container}>
      <h2 style={styles.title}>✈️ Available Flights</h2>
      <div style={styles.flightGrid}>
        {flights.map(flight => (
          <div key={flight.id} style={styles.flightCard}>
            <h3 style={styles.airline}>{flight.airline}</h3>
            <div style={styles.route}>
              <span>{flight.from}</span>
              <span style={styles.arrow}> → </span>
              <span>{flight.to}</span>
            </div>
            <div style={styles.details}>
              <span>💰 {flight.price}</span>
              <span>🕐 {flight.time}</span>
            </div>
            {isLoggedIn ? (
              <button style={styles.bookButton}>Book Now</button>
            ) : (
              <button style={styles.disabledButton} disabled>
                Login to Book
              </button>
            )}
          </div>
        ))}
      </div>
    </div>
  );
}

const styles = {
  container: {
    padding: '20px',
    maxWidth: '1200px',
    margin: '0 auto'
  },
  title: {
    textAlign: 'center',
    color: '#333',
    marginBottom: '30px'
  },
  flightGrid: {
    display: 'grid',
    gridTemplateColumns: 'repeat(auto-fill, minmax(250px, 1fr))',
    gap: '20px'
  },
  flightCard: {
    backgroundColor: 'white',
    padding: '20px',
    borderRadius: '10px',
    boxShadow: '0 2px 10px rgba(0,0,0,0.1)',
    textAlign: 'center',
    transition: 'transform 0.3s, box-shadow 0.3s'
  },
  airline: {
    color: '#007bff',
    marginBottom: '10px'
  },
  route: {
    fontSize: '18px',
    fontWeight: 'bold',
    margin: '10px 0',
    color: '#333'
  },
  arrow: {
    margin: '0 10px',
    color: '#007bff'
  },
  details: {
    display: 'flex',
    justifyContent: 'space-around',
    margin: '10px 0',
    fontSize: '14px',
    color: '#666'
  },
  bookButton: {
    backgroundColor: '#28a745',
    color: 'white',
    border: 'none',
    padding: '10px 20px',
    borderRadius: '5px',
    cursor: 'pointer',
    width: '100%',
    marginTop: '10px',
    fontSize: '14px',
    fontWeight: 'bold'
  },
  disabledButton: {
    backgroundColor: '#ccc',
    color: '#666',
    border: 'none',
    padding: '10px 20px',
    borderRadius: '5px',
    cursor: 'not-allowed',
    width: '100%',
    marginTop: '10px',
    fontSize: '14px'
  }
};

export default FlightList;