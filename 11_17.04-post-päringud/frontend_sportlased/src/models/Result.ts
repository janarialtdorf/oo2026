export type Result = {
    id: number;
    results: number;
    athlete: {
        id: number;
        firstName?: string;
        lastName?: string;
    };
    sport: {
        id: number;
        name?: string;
        scoringType?: string;
    };
}