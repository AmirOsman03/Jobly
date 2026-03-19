import React, {useMemo, useState, useEffect} from 'react';
import Home from "./pages/Home";
import {Box, createTheme, CssBaseline, IconButton, ThemeProvider} from "@mui/material";
import Brightness4Icon from '@mui/icons-material/Brightness4';
import Brightness7Icon from '@mui/icons-material/Brightness7';

const App = () => {
    const [mode, setMode] = useState(() => {
        return localStorage.getItem('themeMode') || 'light';
    });

    useEffect(() => {
        localStorage.setItem('themeMode', mode);
    }, [mode]);

    const theme = useMemo(() =>
        createTheme({
            palette: {
                mode: mode,
            },
        }), [mode]
    );

    const toggleTheme = () => {
        setMode(prev => (prev === 'light' ? 'dark' : 'light'));
    }

    return (
        <ThemeProvider theme={theme}>
            <CssBaseline/>
            <Box sx={{
                display: 'flex',
                flexDirection: 'column',
                minHeight: '100vh',
                position: 'relative',
                p: 2
            }}>
                <Box sx={{
                    position: 'fixed',
                    top: 16,
                    right: 16,
                    zIndex: 1100
                }}>
                    <IconButton 
                        onClick={toggleTheme} 
                        color="inherit"
                        aria-label={`Switch to ${mode === 'light' ? 'dark' : 'light'} mode`}
                    >
                        {mode === 'dark' ? <Brightness7Icon /> : <Brightness4Icon />}
                    </IconButton>
                </Box>
                <Home/>
            </Box>
        </ThemeProvider>
    );
};

export default App;