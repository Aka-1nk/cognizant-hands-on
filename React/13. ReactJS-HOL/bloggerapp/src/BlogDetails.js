import React from 'react';

// Blog data array
const blogs = [
    { id: 201, title: 'React Learning', date: '4/5/2021', author: 'Stephen Biz' },
    { id: 202, title: 'Welcome to learning React!', date: '6/3/2021', author: 'React Team' },
    { id: 203, title: 'Installation Guide', date: '6/3/2021', author: 'React Team' },
];

function BlogDetails() {
    // Using map to render blog details
    const content = (
        <ul style={{ listStyle: 'none', padding: 0 }}>
            {blogs.map((blog) => (
                <div key={blog.id} style={{
                    border: '1px solid #ddd',
                    borderRadius: '5px',
                    padding: '10px',
                    margin: '10px 0',
                    backgroundColor: '#fff'
                }}>
                    <h3 style={{ color: '#2c3e50' }}>{blog.title}</h3>
                    <p><strong>Date:</strong> {blog.date}</p>
                    <p><strong>Author:</strong> {blog.author}</p>
                </div>
            ))}
        </ul>
    );

    return (
        <div style={{
            border: '2px solid #2ecc71',
            borderRadius: '10px',
            padding: '20px',
            margin: '10px',
            backgroundColor: '#f0fff0'
        }}>
            <h1 style={{ color: '#27ae60', textAlign: 'center' }}>Blog Details</h1>
            {content}
        </div>
    );
}

export default BlogDetails;