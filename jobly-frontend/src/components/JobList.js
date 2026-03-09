import React from 'react';
import JobCard from "./JobCard";
import {Grid} from "@mui/material";

const JobList = ({jobs}) => {
    return (
        <Grid container spacing={3}>
            {jobs.map((job) => (
                <Grid item key={job.url} xs={12} sm={6} md={4} lg={3}>
                    <JobCard job={job} />
                </Grid>
            ))}
        </Grid>
    );
};

export default JobList;