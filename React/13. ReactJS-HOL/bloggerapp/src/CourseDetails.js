import React from 'react';

// Course data array
const courses = [
    { id: 301, name: 'Angular', rating: '4.5/5' },
    { id: 302, name: 'Master React', rating: '4.8/5' },
    { id: 303, name: 'React Learning', rating: '4.6/5' },
];

function CourseDetails() {
    // Using map to render course details
    const coursedet = (
        <ul style={{ listStyle: 'none', padding: 0 }}>
            {courses.map((course) => (
                <div key={course.id} style={{
                    border: '1px solid #ddd',
                    borderRadius: '5px',
                    padding: '10px',
                    margin: '10px 0',
                    backgroundColor: '#fff'
                }}>
                    <h3 style={{ color: '#2c3e50' }}>{course.name}</h3>
                    <h4 style={{ color: '#f39c12' }}>Rating: {course.rating}</h4>
                </div>
            ))}
        </ul>
    );

    return (
        <div style={{
            border: '2px solid #e74c3c',
            borderRadius: '10px',
            padding: '20px',
            margin: '10px',
            backgroundColor: '#fff5f5'
        }}>
            <h1 style={{ color: '#c0392b', textAlign: 'center' }}>Course Details</h1>
            {coursedet}
        </div>
    );
}

export default CourseDetails;