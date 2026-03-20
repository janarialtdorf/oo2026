import type { Result } from "./Result"

export type Athlete = {
    id: number,
    firstName: string,
    lastName: string,
    country: string,
    age: number
    result?: Result[]
}