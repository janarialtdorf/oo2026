import { useEffect, useState } from "react"
import type { Athlete } from "../models/Athlete";
import type { Result } from "../models/Result";

function HomePage() {
    const [athletes, setAthletes] = useState<Athlete[]>([]);
    const [totalElements, setTotalElements] = useState(0);
    const [totalPages, setTotalPages] = useState(0);
    const [page, setPage] = useState(0);
    const [size, setSize] = useState(3);
    const [sort, setSort] = useState("result,asc");
    const [results, setResults] = useState<Result[]>([]);
    const [activeCountry, setActiveCountry] = useState<string>("all");

    useEffect(() => {
        fetch("http://localhost:5050/results")
            .then(res => res.json())
            .then(json => setResults(json))
    }, []);

    useEffect(() => {
        fetch(`http://localhost:5050/athletes?page=${page}&size=${size}&sort=${sort}&country=${activeCountry}`)
            .then(res => res.json())
            .then(json => {
                setAthletes(json.content);
                setTotalElements(json.totalElements);
                setTotalPages(json.totalPages);
            });
    }, [page, size, sort, activeCountry]);

    const countries = Array.from(
        new Set(athletes.map(a => a.country))
    );

    const sizeHandler = (newSize: number) => {
        setSize(newSize);
        setPage(0);
    };

    const sortHandler = (newSort: string) => {
        setSort(newSort);
        setPage(0);
    };

    const activeCountryHandler = (country: string) => {
        setActiveCountry(country);
        setPage(0);
    };

    return (
        <div>
            <div>
                {page * size + 1} - {(page + 1) * size > totalElements ? totalElements : (page + 1) * size}
                kuvatud {totalElements}st
            </div>

            <select defaultValue={3} onChange={(e) => sizeHandler(Number(e.target.value))}>
                <option>2</option>
                <option>3</option>
                <option>4</option>
            </select>

            <button onClick={() => sortHandler("results,asc")}>Sorteeri tulemused kasvavalt</button>
            <button onClick={() => sortHandler("results,desc")}>Sorteeri tulemused kahanevalt</button>

            {athletes.map(athlete =>
                <div>
                    {athlete.firstName} {athlete.lastName}
                </div>)}

            <button disabled={page === 0} onClick={() => setPage(page - 1)}>Eelmine</button>
            <span>{page + 1} / {totalPages}</span>
            <button disabled={page + 1 === totalPages} onClick={() => setPage(page + 1)}>Järgmine</button>

            <br /> <br />

            <button
                style={activeCountry === "all" ? { fontWeight: "bold" } : undefined}
                onClick={() => activeCountryHandler("all")}
            >
                All
            </button>

            {countries.map(country => (
                <button
                    key={country}
                    style={activeCountry === country ? { fontWeight: "bold" } : undefined}
                    onClick={() => activeCountryHandler(country)}
                >
                    {country}
                </button>
            ))}


            <button onClick={() => setActiveCountry("USA")}>USA</button>
            <button onClick={() => setActiveCountry("UK")}>UK</button>
            <button onClick={() => setActiveCountry("GER")}>GER</button>
            <button onClick={() => setActiveCountry("ESP")}>ESP</button>
        </div>
    )
}

export default HomePage