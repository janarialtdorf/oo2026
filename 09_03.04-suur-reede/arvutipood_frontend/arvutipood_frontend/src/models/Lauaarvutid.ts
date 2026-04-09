import type { Arvuti } from "./Arvutid"

export type Lauaarvuti = Arvuti & {
    korpuseTyyp: string,
    eraldiGPU: boolean
}