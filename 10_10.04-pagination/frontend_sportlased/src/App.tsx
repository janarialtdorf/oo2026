import { useState } from 'react'
import './App.css'
import { Link, Route, Routes } from 'react-router-dom'
import HomePage from './pages/HomePage'
import Athlete from './pages/Athlete'
import Result from './pages/Result'
import Sport from './pages/Sport'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <Link to="/">
        <button>Avalehele</button>
      </Link>

      <Link to="/athlete">
        <button>Sportlased</button>
      </Link>

      <Link to="/sport">
        <button>Spordialad</button>
      </Link>

      <Link to="/result">
        <button>Tulemused</button>
      </Link>

      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/athlete" element={<Athlete />} />
        <Route path="/sport" element={<Sport />} />
        <Route path="/result" element={<Result />} />
      </Routes>
    </>
  )
}

export default App
