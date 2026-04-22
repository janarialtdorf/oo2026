import { useEffect, useState } from "react"
import type { Sport } from "../models/Sport"
function Sport() {
  const [sports, setSports] = useState<Sport[]>([]);

  useEffect(() => {
    fetch("http://localhost:5050/sports")
      .then(res => res.json())
      .then(json => setSports(json));
  }, []);

  return (
    <div>
      <h1>Spordialad</h1>
      <table>
        <thead>
          <tr>
            <th>Spordialad</th>
          </tr>
        </thead>
        <tbody>
          {sports.map(sport => (
            <tr key={sport.id}>
              <td>{sport.name}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  )
}

export default Sport