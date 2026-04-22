import { useEffect, useState } from "react"
import type { Athlete } from "../models/Athlete";

function Athlete() {
    const [athletes, setAthletes] = useState<Athlete[]>([]);
    const [newAthlete, setNewAthlete] = useState<Omit<Athlete, "id" | "results">>({
        firstName: "",
        lastName: "",
        country: "",
        age: 0
    });
    useEffect(() => {
        fetch("http://localhost:5050/athletes")
            .then(res => res.json())
            .then(json => setAthletes(json))
    }, []);

    const deleteAthlete = (athleteId: number) => {
        fetch("http://localhost:5050/athletes/" + athleteId, {
            method: "DELETE"
        }).then(res => res.json())
            .then(json => setAthletes(json));
    }

    const addAthlete = () => {
        fetch("http://localhost:5050/athletes", {
            method: "POST",
            body: JSON.stringify(newAthlete),
            headers: {
                "Content-Type": "application/json"
            }
        }).then(() => {
            fetch("http://localhost:5050/athletes")
                .then(res => res.json())
                .then(json => setAthletes(json));
        });
    };

    return (
        <div>
            <h2>Lisa uus sportlane</h2>
            <label>First Name:</label> <br />
            <input
                type="text"
                value={newAthlete.firstName}
                onChange={e => setNewAthlete({ ...newAthlete, firstName: e.target.value })}
            /> <br />

            <label>Last Name:</label> <br />
            <input
                type="text"
                value={newAthlete.lastName}
                onChange={e => setNewAthlete({ ...newAthlete, lastName: e.target.value })}
            /> <br />

            <label>Country:</label> <br />
            <input
                type="text"
                value={newAthlete.country}
                onChange={e => setNewAthlete({ ...newAthlete, country: e.target.value })}
            /> <br />

            <label>Age:</label> <br />
            <input
                type="number"
                value={newAthlete.age}
                onChange={e => setNewAthlete({ ...newAthlete, age: Number(e.target.value) })}
            /> <br />

            <button onClick={addAthlete}>Add Athlete</button>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>firstName</th>
                        <th>lastName</th>
                        <th>country</th>
                        <th>age</th>
                        <th>result</th>
                    </tr>
                </thead>
                <tbody>
                    {Array.isArray(athletes) ? athletes.map(athlete => (
                        <tr key={athlete.id}>
                            <td>{athlete.id}</td>
                            <td>{athlete.firstName}</td>
                            <td>{athlete.lastName}</td>
                            <td>{athlete.country}</td>
                            <td>{athlete.age}</td>
                            <td><button>Edit</button></td>
                            <td><button onClick={() => deleteAthlete(Number(athlete.id))}>X</button></td>
                        </tr>
                    )) : <tr><td colSpan={8}>No athletes</td></tr>}
                </tbody>
            </table>
        </div>
    )
}

export default Athlete