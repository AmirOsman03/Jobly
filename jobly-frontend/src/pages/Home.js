import React, {useEffect, useState} from 'react';
import {getJobs} from "../services/jobService";
import JobLIst from "../components/JobLIst";

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
        <div>
            <h1>Active Jobs</h1>
            <JobLIst jobs={jobs}/>
        </div>
    );
};

export default Home;