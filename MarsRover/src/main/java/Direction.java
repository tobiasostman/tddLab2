import java.util.Dictionary;

public enum Direction {
    North(1),
    East(2),
    South(3),
    West(4);

    private final int directionNumber;

    Direction(int i) {
        this.directionNumber = i;
    }

    public int getDirectionNumber() {
        return directionNumber;
    }
}
