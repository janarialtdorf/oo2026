import { useEffect, useState } from "react";

type Arvuti = {
    id: number;
    tootja: string;
    mudel: string;
    muutamaht: number;
    protsessor: string;
    tyyp: string;
};

function Sylearvutid() {
    const [arvutid, setArvutid] = useState<Arvuti[]>([]);

    useEffect(() => {
        fetch("http://localhost:5050/arvuti")
            .then(res => res.json())
            .then(json => {
                const syle = json.filter((a: Arvuti) => a.tyyp === "SYLE");
                setArvutid(syle);
            });
    }, []);

    const deleteArvuti = (id: number) => {
        fetch("http://localhost:5050/arvuti/" + id, {
            method: "DELETE"
        })
            .then(res => res.json())
            .then(json => {
                const syle = json.filter((a: Arvuti) => a.tyyp === "SYLE");
                setArvutid(syle);
            });
    };

    return (
        <div>
            <h2>Sülearvutid</h2>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Tootja</th>
                        <th>Mudel</th>
                        <th>RAM</th>
                        <th>Protsessor</th>
                        <th>Kustuta</th>
                    </tr>
                </thead>
                <tbody>
                    {arvutid.map(a => (
                        <tr key={a.id}>
                            <td>{a.id}</td>
                            <td>{a.tootja}</td>
                            <td>{a.mudel}</td>
                            <td>{a.muutamaht}</td>
                            <td>{a.protsessor}</td>
                            <td>
                                <button onClick={() => deleteArvuti(a.id)}>X</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default Sylearvutid;