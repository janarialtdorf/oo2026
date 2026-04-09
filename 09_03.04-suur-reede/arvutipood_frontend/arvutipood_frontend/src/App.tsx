import './App.css'
import { Link, Route, Routes } from 'react-router-dom'
import HomePage from './pages/HomePage'
import Arvutid from './pages/Arvutid'
import Sylearvutid from './pages/Sylearvutid'
import Lauaarvutid from './pages/Lauaarvutid'

function App() {
  return (
    <>
      <Link to="/">
        <button>Avaleht</button>
      </Link>

      <Link to="/arvutid">
        <button>Lisa / kustuta arvuteid</button>
      </Link>

      <Link to="/lisa-syle">
        <button>Sülearvutid</button>
      </Link>

      <Link to="/lisa-laua">
        <button>Lauaarvutid</button>
      </Link>

      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/arvutid" element={<Arvutid />} />
        <Route path="/lisa-syle" element={<Sylearvutid />} />
        <Route path="/lisa-laua" element={<Lauaarvutid />} />
      </Routes>
    </>
  )
}

export default App
