export type Result = {
    id: number;
    results: number;
    athlete: {
        id: number;
    };
    sport: {
        id: number;
        name?: string;
        scoringType?: string;
    };
}