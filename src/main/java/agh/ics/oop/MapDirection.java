package agh.ics.oop;

enum MapDirection {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    public String toString() {
        return switch (this) {
            case NORTH -> "Północ";
            case SOUTH -> "Południe";
            case EAST -> "Wschód";
            case WEST -> "Zachód";
        };
    }

    public MapDirection next() {
        return switch (this) {
            case NORTH -> EAST;
            case SOUTH -> WEST;
            case EAST -> SOUTH;
            case WEST -> NORTH;
        };
    }

    public MapDirection previous() {
        return switch (this) {
            case NORTH -> WEST;
            case SOUTH -> EAST;
            case EAST -> NORTH;
            case WEST -> SOUTH;
        };
    }

    public String toUnitVector() {
        return switch (this) {
            case NORTH -> "(1,0)";
            case SOUTH -> "(-1,0)";
            case EAST -> "(0,1)";
            case WEST -> "(0,-1)";
        };
    }
}
