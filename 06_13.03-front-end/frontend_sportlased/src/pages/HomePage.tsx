import { useEffect, useState } from "react"
import type { Athlete } from "../models/Athlete";

function HomePage() {
    const [athletes, setAthletes] = useState<Athlete[]>([]);

    useEffect(() => {
        fetch("http://localhost:5050/athletes")
            .then(res => res.json())
            .then(json => setAthletes(json))
    }, []);

    return (
        <div>
            {athletes.map(athlete => <div>{athlete.firstName} {athlete.lastName}</div>)}
        </div>
    )
}

export default HomePage