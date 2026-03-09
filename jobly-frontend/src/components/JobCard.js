import React from 'react';
import {Button, Card, CardActions, CardContent, Typography} from "@mui/material";

const JobCard = ({ job }) => {
    return (
        <Card sx={{ height: "100%", display: "flex", flexDirection: "column", boxShadow: 3 }}>
            <CardContent sx={{ flexGrow: 1 }}>
                <Typography variant="h6" gutterBottom>
                    {job.title}
                </Typography>
                <Typography variant="subtitle2" color="text.secondary">
                    {job.company}
                </Typography>
                <Typography variant="body2" color="text.secondary">
                    {job.location} | {job.salary || "Salary N/A"}
                </Typography>
                <Typography variant="body2" color="text.secondary">
                    Source: {job.source}
                </Typography>
                <Typography variant="body2" color="text.secondary">
                    Valid Until: {job.validUntil || "N/A"}
                </Typography>
            </CardContent>
            <CardActions>
                <Button size="small" href={job.url} target="_blank">
                    View Job
                </Button>
            </CardActions>
        </Card>
    );
};

export default JobCard;