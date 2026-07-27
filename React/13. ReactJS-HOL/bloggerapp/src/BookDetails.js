import React from 'react';

// Books data array
const books = [
    { id: 101, bname: 'Master React', price: 670 },
    { id: 102, bname: 'Deep Dive into Angular 11', price: 800 },
    { id: 103, bname: 'Mongo Essentials', price: 450 },
];

function BookDetails() {
    // Using map to render book details
    const bookdet = (
        <ul style={{ listStyle: 'none', padding: 0 }}>
            {books.map((book) => (
                <div key={book.id} style={{
                    border: '1px solid #ddd',
                    borderRadius: '5px',
                    padding: '10px',
                    margin: '10px 0',
                    backgroundColor: '#f9f9f9'
                }}>
                    <h3 style={{ color: '#2c3e50' }}>{book.bname}</h3>
                    <h4 style={{ color: '#e74c3c' }}>Price: ${book.price}</h4>
                </div>
            ))}
        </ul>
    );

    return (
        <div style={{
            border: '2px solid #3498db',
            borderRadius: '10px',
            padding: '20px',
            margin: '10px',
            backgroundColor: '#f0f8ff'
        }}>
            <h1 style={{ color: '#2980b9', textAlign: 'center' }}>Book Details</h1>
            {bookdet}
        </div>
    );
}

export default BookDetails;