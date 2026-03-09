import React, {useEffect, useState} from 'react';
import {getJobs} from "../services/jobService";
import JobList from "../components/JobList";
import {Container, Typography} from "@mui/material";

const Home = () => {
    const [jobs, setJobs] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        getJobs()
            .then(data => setJobs(data))
            .catch(err => setError(err.message))
            .finally(() => setLoading(false));
    }, []);

    if (loading) return <p>Loading jobs...</p>;
    if (error) return <p>Error: {error}</p>;

    return (
        <Container sx={{ py: 5 }}>
            <Typography variant="h4" gutterBottom>
                Active Jobs
            </Typography>
            <JobList jobs={jobs} />
        </Container>
    );
};

export default Home;