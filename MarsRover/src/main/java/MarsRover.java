import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MarsRover {

    RoverPosition roverPosition;
    private Map<Integer, Direction> getDirectionDict = new HashMap<Integer, Direction>() {{
        put(1, Direction.North);
        put(2, Direction.East);
        put(3, Direction.South);
        put(4, Direction.West);
    }};

    public MarsRover(RoverPosition roverPosition) {
        this.roverPosition = roverPosition;
    }

    public RoverPosition getRoverPosition() {
        return roverPosition;
    }

    private boolean validateCommandString(String commandStr) {

        return commandStr.matches("^[f|b|l|r][0-9]+(?:,[f|b|l|r][0-9]+)*$");
    }

    private Direction turnRoverInDirection(Direction currentDirection, int turn, String turningDirection) {
        int newDirection = currentDirection.getDirectionNumber();


        for (int i = 0; i != turn; i++) {

            if (Objects.equals(turningDirection, "l")) {
                newDirection -= 1;
            } else {
                newDirection += 1;
            }

            if (newDirection > 4) {
                newDirection = 1;
            }
            if (newDirection < 1) {
                newDirection = 4;
            }
        }

        return getDirectionDict.get(newDirection);
    }

    public RoverPosition moveRover(String commandStr) throws Exception {

        if (!validateCommandString(commandStr)) throw new Exception("Invalid command string");

        String[] commands = commandStr.split(",");

        for (String command : commands) {
            if (command.startsWith("f")) {
                int forwardAmount = Integer.parseInt(command.substring(1));
                roverPosition.setXCoordinate(getRoverPosition().xCoordinate + forwardAmount);
            }
            if (command.startsWith("b")) {
                int backwardAmount = Integer.parseInt(command.substring(1));
                roverPosition.setXCoordinate(getRoverPosition().xCoordinate - backwardAmount);
            }
            if (command.startsWith("l")) {
                int leftMovement = Integer.parseInt(command.substring(1));
                Direction newDirection = turnRoverInDirection(roverPosition.getDirection(), leftMovement, command.substring(0, 1));
                roverPosition.setDirection(newDirection);
            }
            if (command.startsWith("r")) {
                int rightMovement = Integer.parseInt(command.substring(1));
                Direction newDirection = turnRoverInDirection(roverPosition.getDirection(), rightMovement, command.substring(0, 1));
                roverPosition.setDirection(newDirection);
            }
        }
        return roverPosition;
    }
}
