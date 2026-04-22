import type { Result } from "../models/Result";
import { useEffect, useState } from "react"


function Result() {
  const [results, setResults] = useState<Result[]>([]);

  
    useEffect(() => {
        fetch("http://localhost:5050/results")
            .then(res => res.json())
            .then(json => setResults(json))
    }, []);

  return (
    <div className ="page">
        <h1>Tulemused</h1>
      <table>
        <thead>
          <tr>
            <th>Sportlase id</th>
            <th>Spordiala</th>
            <th>Tulemus</th>
            <th>Skoorimine</th>
          </tr>
        </thead>
        <tbody>
          {Array.isArray(results) && results.map(result => (
            <tr key={result.id}>
              <td>{result.athlete.id}</td>
              <td>{result.sport.name}</td>
              <td>{result.results}</td>
              <td>{result.sport.scoringType}</td>
            </tr>
          ))}

        </tbody>
      </table>
    </div>
  )
}

export default Result