import './App.css'
import { Link, Route, Routes } from 'react-router-dom'
import HomePage from './pages/HomePage'
import Athlete from './pages/Athlete'
import Result from './pages/Result'
import Sport from './pages/Sport'
import AddResult from './pages/AddResult'

function App() {

  return (
    <>
      <Link to="/">
        <button>Avalehele</button>
      </Link>

      <Link to="/athlete">
        <button>Lisa Sportlane</button>
      </Link>

      <Link to="/sport">
        <button>Spordialad</button>
      </Link>

      <Link to="/result">
        <button>Tulemused</button>
      </Link>

      <Link to="/addresult">
        <button>Lisa Tulemus</button>
      </Link>

      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/athlete" element={<Athlete />} />
        <Route path="/sport" element={<Sport />} />
        <Route path="/result" element={<Result />} />
        <Route path="/addresult" element={<AddResult />} />
      </Routes>
    </>
  )
}

export default App
