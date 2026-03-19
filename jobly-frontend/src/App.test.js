import { render, screen, fireEvent } from '@testing-library/react';
import '@testing-library/jest-dom';
import App from './App';

beforeEach(() => {
  localStorage.clear();
});

test('renders theme toggle button', () => {
  render(<App />);
  const toggleButton = screen.getByRole('button', { name: /switch to dark mode/i });
  expect(toggleButton).toBeInTheDocument();
});

test('toggles theme on click', () => {
  render(<App />);
  const toggleButton = screen.getByRole('button', { name: /switch to dark mode/i });
  fireEvent.click(toggleButton);
  expect(screen.getByRole('button', { name: /switch to light mode/i })).toBeInTheDocument();
});

test('persists theme mode in localStorage', () => {
  const { unmount } = render(<App />);
  const toggleButton = screen.getByRole('button', { name: /switch to dark mode/i });
  
  // Switch to dark mode
  fireEvent.click(toggleButton);
  expect(localStorage.getItem('themeMode')).toBe('dark');
  
  // Unmount and remount to simulate refresh
  unmount();
  render(<App />);
  expect(screen.getByRole('button', { name: /switch to light mode/i })).toBeInTheDocument();
});
