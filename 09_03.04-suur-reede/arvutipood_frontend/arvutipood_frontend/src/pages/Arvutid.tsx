import { useEffect, useState } from "react";

type Arvuti = {
    id: number;
    tootja: string;
    mudel: string;
    muutamaht: number;
    protsessor: string;
    tyyp: string;
};

function Arvutid() {
    const [arvutid, setArvutid] = useState<Arvuti[]>([]);

    const [newArvuti, setNewArvuti] = useState<Omit<Arvuti, "id" | "tyyp">>({
        tootja: "",
        mudel: "",
        muutamaht: 0,
        protsessor: ""
    });

    useEffect(() => {
        fetch("http://localhost:5050/arvuti")
            .then(res => res.json())
            .then(json => setArvutid(json));
    }, []);

    const deleteArvuti = (id: number) => {
        fetch("http://localhost:5050/arvuti/" + id, {
            method: "DELETE"
        })
            .then(res => res.json())
            .then(json => setArvutid(json));
    };

    const addSyle = () => {
        fetch("http://localhost:5050/arvuti/syle", {
            method: "POST",
            body: JSON.stringify({
                ...newArvuti,
                kaal: 2,
                akuKestvus: 5
            }),
            headers: {
                "Content-Type": "application/json"
            }
        })
            .then(res => res.json())
            .then(json => setArvutid(json));
    };

    const addLaua = () => {
        fetch("http://localhost:5050/arvuti/laua", {
            method: "POST",
            body: JSON.stringify({
                ...newArvuti,
                korpuseTyyp: "ATX",
                eraldiGPU: true
            }),
            headers: {
                "Content-Type": "application/json"
            }
        })
            .then(res => res.json())
            .then(json => setArvutid(json));
    };

    return (
        <div>
            <h2>Lisa uus arvuti</h2>

            <label>Tootja:</label> <br />
            <input
                type="text"
                value={newArvuti.tootja}
                onChange={e => setNewArvuti({ ...newArvuti, tootja: e.target.value })}
            /> <br />

            <label>Mudel:</label> <br />
            <input
                type="text"
                value={newArvuti.mudel}
                onChange={e => setNewArvuti({ ...newArvuti, mudel: e.target.value })}
            /> <br />

            <label>RAM:</label> <br />
            <input
                type="number"
                value={newArvuti.muutamaht}
                onChange={e => setNewArvuti({ ...newArvuti, muutamaht: Number(e.target.value) })}
            /> <br />

            <label>Protsessor:</label> <br />
            <input
                type="text"
                value={newArvuti.protsessor}
                onChange={e => setNewArvuti({ ...newArvuti, protsessor: e.target.value })}
            /> <br />

            <button onClick={addSyle}>Lisa sülearvuti</button>
            <button onClick={addLaua}>Lisa lauaarvuti</button>

            <h2>Kõik arvutid</h2>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Tootja</th>
                        <th>Mudel</th>
                        <th>RAM</th>
                        <th>Protsessor</th>
                        <th>Tüüp</th>
                        <th>Kustuta</th>
                    </tr>
                </thead>
                <tbody>
                    {Array.isArray(arvutid) ? arvutid.map(a => (
                        <tr key={a.id}>
                            <td>{a.id}</td>
                            <td>{a.tootja}</td>
                            <td>{a.mudel}</td>
                            <td>{a.muutamaht}</td>
                            <td>{a.protsessor}</td>
                            <td>{a.tyyp}</td>
                            <td>
                                <button onClick={() => deleteArvuti(a.id)}>X</button>
                            </td>
                        </tr>
                    )) : (
                        <tr>
                            <td colSpan={7}>Puuduvad arvutid</td>
                        </tr>
                    )}
                </tbody>
            </table>
        </div>
    );
}

export default Arvutid;