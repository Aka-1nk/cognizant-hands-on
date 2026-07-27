import React from 'react';

function LogoutButton(props) {
  return (
    <button onClick={props.onClick} style={styles.logoutButton}>
      Logout
    </button>
  );
}

const styles = {
  logoutButton: {
    backgroundColor: '#dc3545',
    color: 'white',
    border: 'none',
    padding: '12px 30px',
    borderRadius: '5px',
    fontSize: '16px',
    cursor: 'pointer',
    margin: '5px',
    transition: 'background-color 0.3s'
  }
};

export default LogoutButton;