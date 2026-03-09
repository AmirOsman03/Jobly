import React from 'react';
import JobCard from "./JobCard";

const JobLIst = ({jobs}) => {
    return (
        <div className={"job-list"}>
            {jobs.map(job =>
                <JobCard key={job.url} job={job}/>
            )}
        </div>
    );
};

export default JobLIst;