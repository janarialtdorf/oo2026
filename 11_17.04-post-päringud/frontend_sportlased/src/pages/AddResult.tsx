import { useState } from "react"
import type { Result } from "../models/Result"

function AddResult() {
    const [result, setResult] = useState<Result>({
        id: 0,
        results: 0,
        athlete: {
            id: 0
        },
        sport: {
            id: 0
        }
    })

    const AddResult = () => {
        fetch("http://localhost:5050/results", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(result)
        })
    }

    return (
        <div>
            <label>Result:</label>
            <input
                type="number"
                onChange={(e) =>
                    setResult((prev) => ({
                        ...prev,
                        results: Number(e.target.value)
                    }))
                }
            />

            <br />

            <label>Athlete ID:</label>
            <input
                type="number"
                onChange={(e) =>
                    setResult((prev) => ({
                        ...prev,
                        athlete: { id: Number(e.target.value) }
                    }))
                }
            />

            <br />

            <label>Sport ID:</label>
            <input
                type="number"
                onChange={(e) =>
                    setResult((prev) => ({
                        ...prev,
                        sport: { id: Number(e.target.value) }
                    }))
                }
            />

            <br />

            <button onClick={AddResult}>Add Result</button>
        </div>
    );
}

export default AddResult