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

        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
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
        assertEquals(5, rover.moveRover("b1").xCoordinate);
    }

    @Test
    @DisplayName("Should move forwards and backwards")
    public void shouldMoveForwardAndBackward() throws Exception {
        assertEquals(3, rover.moveRover("f4,b2").xCoordinate);
    }

    @Test
    @DisplayName("Should rotate left 90*")
    public void shouldRotateLeft90() throws Exception {
        assertEquals(Direction.West, rover.moveRover("l1").getDirection());
    }

    @Test
    @DisplayName("Should roate left 180*")
    public void shouldRotateLeft180() throws Exception {
        assertEquals(Direction.South, rover.moveRover("l2").getDirection());
    }

    @Test
    @DisplayName("Should roate left 270*")
    public void shouldRotateLeft270() throws Exception {
        assertEquals(Direction.East, rover.moveRover("l3").getDirection());
    }

    @Test
    @DisplayName("Should roate left 360*")
    public void shouldRotateLeft360() throws Exception {
        assertEquals(Direction.North, rover.moveRover("l4").getDirection());
    }

    @Test
    @DisplayName("Should roate left 630*")
    public void shouldRotateLeft630() throws Exception {
        assertEquals(Direction.East, rover.moveRover("l7").getDirection());
    }

    @Test
    @DisplayName("Should roate right 90*")
    public void shouldRotateRight90() throws Exception {
        assertEquals(Direction.East, rover.moveRover("r1").getDirection());
    }

    @Test
    @DisplayName("Should roate right 180*")
    public void shouldRotateRight180() throws Exception {
        assertEquals(Direction.South, rover.moveRover("r2").getDirection());
    }

    @Test
    @DisplayName("Should roate right 270*")
    public void shouldRotateRight270() throws Exception {
        assertEquals(Direction.West, rover.moveRover("r3").getDirection());
    }

    @Test
    @DisplayName("Should roate right 360*")
    public void shouldRotateRight360() throws Exception {
        assertEquals(Direction.North, rover.moveRover("r4").getDirection());
    }

    @Test
    @DisplayName("Should roate right 540")
    public void shouldRotateRight540() throws Exception {
        assertEquals(Direction.South, rover.moveRover("r6").getDirection());
    }

    @Test
    @DisplayName("Should move to xCoordinate 5m facing north")
    public void shouldMoveToXCoordinate5FacingNorth() throws Exception {
        assertEquals(5, rover.moveRover("b1").xCoordinate);
    }

    @Test
    @DisplayName("Should move to xCoordinate 1, facing north")
    public void shouldMoveToXCoordinate1FacingNorth() throws Exception {
        assertEquals(1, rover.moveRover("f5").xCoordinate);
    }

    @Test
    @DisplayName("Should move to yCoordinate 5, facing east")
    public void shouldMoveToYCoordinate5FacingEast() throws Exception {
        assertEquals(5, rover.moveRover("l1,b1").yCoordinate);
    }

    @Test
    @DisplayName("Should move to yCoordinate 1, facing east")
    public void shouldMoveToYCoordinate1FacingEast() throws Exception {
        assertEquals(1, rover.moveRover("l1,f5").yCoordinate);
    }

    @Test
    @DisplayName("Should move to xCoordinate 3, facing south")
    public void shouldMoveToXCoordinate3FacingSouth() throws Exception {
        assertEquals(3, rover.moveRover("l2,b2").xCoordinate);
    }
    @Test
    @DisplayName("Should move to xCoordinate 4, facing south")
    public void shouldMoveToXCoordinate4FacingSouth() throws Exception {
        assertEquals(4, rover.moveRover("l2,f2").xCoordinate);
    }

    @Test
    @DisplayName("Should move to xCoordinate 4, facing west")
    public void shouldMoveToXCoordinate2FacingWest() throws Exception {
        assertEquals(4, rover.moveRover("r1,f2").yCoordinate);
    }

    @Test
    @DisplayName("Should move to xCoordinate 5, facing west")
    public void shouldMoveToXCoordinate4FacingWest() throws Exception {
        assertEquals(5, rover.moveRover("r1,b4").yCoordinate);
    }
}
