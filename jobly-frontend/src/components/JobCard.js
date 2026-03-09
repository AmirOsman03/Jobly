import React from 'react';

const JobCard = ({job}) => {
    return (
        <div className={"job-card"}
             style={{
                 borderBottom: "1px solid #ccc",
                 padding: "10px 0"
             }}>
            <h3>job.title</h3>
            <p><strong>Company:</strong> {job.company}</p>
            <p><strong>Title:</strong> {job.title}</p>
            <p><strong>Location:</strong> {job.location}</p>
            <p><strong>Salary:</strong> {job.salary || "No data"}</p>
            <p><strong>Source:</strong> {job.source}</p>
            <p><strong>Valid until:</strong> {job.validUntil || "N/A"}</p>
            <a href={job.url} target={"_blank"} rel={"noopener noreferrer"}>View Job</a>
        </div>
    );
};

export default JobCard;