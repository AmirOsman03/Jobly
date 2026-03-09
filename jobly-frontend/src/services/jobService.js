const API_URL = 'http://localhost:8080/api/jobs';

export const getJobs = async () => {
    const response = await fetch(API_URL);
    if (!response.ok) {
        throw new Error('Failed to fetch jobs');
    }
    return response.json();
}

export default API_URL;