import org.junit.jupiter.api.Assertions;
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
    @DisplayName("Should invalidate command string")
    public void shouldInvalidateCommandString() throws Exception {

        Exception thrown = Assertions.assertThrows(Exception.class,() ->{
            rover.moveRover("f1,b1,c2,d3,l,r,b1");
        });
        assertEquals("Invalid command string", thrown.getMessage());
    }

    @Test
    @DisplayName("Should move forward")
    public void shouldMoveForward() throws Exception {
        assertEquals(2, rover.moveRover("f1").xCoordinate);
    }

    @Test
    @DisplayName("Should move backward")
    public void shouldMoveBackward() throws Exception {
        assertEquals(0, rover.moveRover("b1").xCoordinate);
    }

    @Test
    @DisplayName("Should move forwards and backwards")
    public void shouldMoveForwardAndBackward() throws Exception {
        assertEquals(3, rover.moveRover("f4,b2").xCoordinate);
    }
}
