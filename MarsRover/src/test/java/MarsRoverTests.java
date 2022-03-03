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

    @Test
    @DisplayName("Should move forward")
    public void shouldMoveForward() {
        assertEquals(2, rover.moveRover("f1").xCoordinate);
    }

    @Test
    @DisplayName("Should move backward")
    public void shouldMoveBackward() {
        assertEquals(0, rover.moveRover("b1").xCoordinate);
    }

    @Test
    @DisplayName("Should move forwards and backwards")
    public void shouldMoveForwardAndBackward() {
        assertEquals(3, rover.moveRover("f4,b2").xCoordinate);
    }
}
