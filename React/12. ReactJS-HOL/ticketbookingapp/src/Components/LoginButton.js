import React from 'react';

function LoginButton(props) {
  return (
    <button onClick={props.onClick} style={styles.loginButton}>
      Login
    </button>
  );
}

const styles = {
  loginButton: {
    backgroundColor: '#007bff',
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

export default LoginButton;