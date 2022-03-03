import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverTests {

    MarsRover rover = new MarsRover(new RoverPosition(1, 1, Direction.North));

    @Test
    @DisplayName("Should have start coordinates")
    public void shouldHaveStartCoordinates() {
        assertEquals(1, rover.getRoverPosition().xCoordinate);
        assertEquals(1, rover.getRoverPosition().yCoordinate);
        assertEquals(Direction.North, rover.getRoverPosition().direction);
    }
}
