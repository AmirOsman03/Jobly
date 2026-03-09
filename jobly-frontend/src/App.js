import React, {useMemo, useState} from 'react';
import Home from "./pages/Home";
import {Button, createTheme, CssBaseline, ThemeProvider} from "@mui/material";
import BrightnessHighIcon from '@mui/icons-material/BrightnessHigh';
import Brightness3Icon from '@mui/icons-material/Brightness3';

const App = () => {
    const [mode, setMode] = useState("light");

    const theme = useMemo(() =>
        createTheme({
            palette: {
                mode: mode,
            },
        }), [mode]
    );

    const toggleTheme = () => {
        setMode(prev => (prev === "light" ? "dark" : "light"));
    }

    return (
        <ThemeProvider theme={theme}>
            <CssBaseline/>
            <div style={{padding: 20}}>
                <Button
                variant="contained"
                startIcon={mode === "light" ? <Brightness3Icon/> : <BrightnessHighIcon/>}
                onClick={toggleTheme}
                >
                    {mode === "light" ? "Dark Mode" : "Light Mode"}
                </Button>
                <Home/>
            </div>
        </ThemeProvider>
    );
};

export default App;