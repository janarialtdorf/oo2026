import { useEffect, useState } from "react";

type Arvuti = {
    id: number;
    tootja: string;
    mudel: string;
    tyyp: string;
};

function HomePage() {
    const [arvutid, setArvutid] = useState<Arvuti[]>([]);

    useEffect(() => {
        fetch("http://localhost:5050/arvuti")
            .then(res => res.json())
            .then(json => setArvutid(json));
    }, []);

    return (
        <div>
            <h2>Avaleht</h2>

            <h3>Kõik arvutid:</h3>

            {arvutid.length === 0 ? (
                <p>Arvuteid pole</p>
            ) : (
                arvutid.map(a => (
                    <div key={a.id}>
                        {a.tootja} {a.mudel} ({a.tyyp})
                    </div>
                ))
            )}
        </div>
    );
}

export default HomePage;