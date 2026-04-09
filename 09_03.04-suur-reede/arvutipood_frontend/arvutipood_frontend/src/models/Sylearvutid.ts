import type { Arvuti } from "./Arvutid"

export type Sylearvuti = Arvuti & {
    kaal: number,
    akuKestvus: number
}