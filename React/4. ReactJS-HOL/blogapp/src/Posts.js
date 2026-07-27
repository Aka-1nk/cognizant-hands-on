import React from 'react';
import Post from './Post';

class Posts extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: []
        };
    }

    loadPosts() {
        fetch('https://jsonplaceholder.typicode.com/posts')
            .then(response => response.json())
            .then(data => {
                const posts = data.map(item => 
                    new Post(item.id, item.title, item.body)
                );
                this.setState({ posts: posts });
            })
            .catch(error => {
                console.log('Error fetching posts:', error);
                throw error;
            });
    }

    componentDidMount() {
        this.loadPosts();
    }

    render() {
        return (
            <div style={{ padding: '20px' }}>
                <h1 style={{ textAlign: 'center', color: '#333' }}>
                    Blog Posts
                </h1>
                <hr />
                {this.state.posts.map(post => (
                    <div key={post.id} style={{
                        border: '1px solid #ddd',
                        borderRadius: '8px',
                        padding: '15px',
                        margin: '10px 0',
                        backgroundColor: '#f9f9f9'
                    }}>
                        <h3 style={{ color: '#2c3e50' }}>
                            {post.id}. {post.title}
                        </h3>
                        <p style={{ color: '#555', lineHeight: '1.6' }}>
                            {post.body}
                        </p>
                    </div>
                ))}
            </div>
        );
    }

    componentDidCatch(error, info) {
        alert('An error occurred: ' + error.message);
        console.log('Error:', error);
        console.log('Info:', info);
    }
}
 
export default Posts;