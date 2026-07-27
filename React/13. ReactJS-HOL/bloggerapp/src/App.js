import React, { useState } from 'react';
import './App.css';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';

function App() {
    // State to control which component is shown
    const [showComponent, setShowComponent] = useState('all');
    
    // ============================================
    // CONDITIONAL RENDERING EXAMPLES
    // ============================================
    
    // Method 1: Using if-else
    const renderWithIfElse = () => {
        if (showComponent === 'books') {
            return <BookDetails />;
        } else if (showComponent === 'blogs') {
            return <BlogDetails />;
        } else if (showComponent === 'courses') {
            return <CourseDetails />;
        } else {
            return (
                <div>
                    <BookDetails />
                    <BlogDetails />
                    <CourseDetails />
                </div>
            );
        }
    };
    
    // Method 2: Using switch statement
    const renderWithSwitch = () => {
        switch (showComponent) {
            case 'books':
                return <BookDetails />;
            case 'blogs':
                return <BlogDetails />;
            case 'courses':
                return <CourseDetails />;
            default:
                return (
                    <div>
                        <BookDetails />
                        <BlogDetails />
                        <CourseDetails />
                    </div>
                );
        }
    };
    
    // Method 3: Using ternary operator
    const renderWithTernary = () => {
        return (
            <div>
                {showComponent === 'all' ? (
                    <div>
                        <BookDetails />
                        <BlogDetails />
                        <CourseDetails />
                    </div>
                ) : showComponent === 'books' ? (
                    <BookDetails />
                ) : showComponent === 'blogs' ? (
                    <BlogDetails />
                ) : (
                    <CourseDetails />
                )}
            </div>
        );
    };
    
    // Method 4: Using logical AND operator
    const renderWithLogicalAnd = () => {
        return (
            <div>
                {showComponent === 'all' && (
                    <div>
                        <BookDetails />
                        <BlogDetails />
                        <CourseDetails />
                    </div>
                )}
                {showComponent === 'books' && <BookDetails />}
                {showComponent === 'blogs' && <BlogDetails />}
                {showComponent === 'courses' && <CourseDetails />}
            </div>
        );
    };
    
    // Method 5: Using element variables
    let componentToRender;
    if (showComponent === 'books') {
        componentToRender = <BookDetails />;
    } else if (showComponent === 'blogs') {
        componentToRender = <BlogDetails />;
    } else if (showComponent === 'courses') {
        componentToRender = <CourseDetails />;
    } else {
        componentToRender = (
            <div>
                <BookDetails />
                <BlogDetails />
                <CourseDetails />
            </div>
        );
    }
    
    return (
        <div className="App">
            <h1>Blogger App - Conditional Rendering Examples</h1>
            
            {/* Navigation Buttons */}
            <div className="nav-buttons">
                <button onClick={() => setShowComponent('all')}>Show All</button>
                <button onClick={() => setShowComponent('books')}>Show Books</button>
                <button onClick={() => setShowComponent('blogs')}>Show Blogs</button>
                <button onClick={() => setShowComponent('courses')}>Show Courses</button>
            </div>
            
            <hr />
            
            {/* 
                ==========================================
                METHOD 1: IF-ELSE RENDERING
                ==========================================
            */}
            <div className="method-section">
                <h2>Method 1: If-Else Rendering</h2>
                {renderWithIfElse()}
            </div>
            
            <hr />
            
            {/* 
                ==========================================
                METHOD 2: SWITCH RENDERING
                ==========================================
            */}
            <div className="method-section">
                <h2>Method 2: Switch Rendering</h2>
                {renderWithSwitch()}
            </div>
            
            <hr />
            
            {/* 
                ==========================================
                METHOD 3: TERNARY RENDERING
                ==========================================
            */}
            <div className="method-section">
                <h2>Method 3: Ternary Operator Rendering</h2>
                {renderWithTernary()}
            </div>
            
            <hr />
            
            {/* 
                ==========================================
                METHOD 4: LOGICAL AND RENDERING
                ==========================================
            */}
            <div className="method-section">
                <h2>Method 4: Logical AND Rendering</h2>
                {renderWithLogicalAnd()}
            </div>
            
            <hr />
            
            {/* 
                ==========================================
                METHOD 5: ELEMENT VARIABLE RENDERING
                ==========================================
            */}
            <div className="method-section">
                <h2>Method 5: Element Variable Rendering</h2>
                {componentToRender}
            </div>
        </div>
    );
}

export default App;