import React from 'react';
import Post from './Post';

class Posts extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: [],
            error: null            
        };
    }
    loadPosts = async() => {
        try {
            const response = await fetch('https://jsonplaceholder.typicode.com/posts');
            if (!response.ok) {
                throw new Error('Failed to fetch posts');
            }
            const data = await response.json();
            const posts = data.map(
                (post) => new Post(post.id, post.title, post.body)
            );
            this.setState({ posts });
        } catch (error) {
            this.setState({ error });
        }
    }
    componentDidMount() {
        this.loadPosts();
    }
    render() {
        const { posts, error } = this.state;
        if (error) {
            return <p>Error: {error.message}</p>;
        }
        return (
            <div>
                {posts.map((post) => (
                    <div key={post.id}>
                        <h2>{post.title}</h2>
                        <p>{post.body}</p>
                        <hr />
                    </div>
                ))}
            </div>
        );
    }
    componentDidCatch() {
        alert('An error occurred');
    }
}
export default Posts;