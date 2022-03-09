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
    private Map<String, Boolean> getIsGoingForward = new HashMap<String, Boolean>() {{
        put("b1", false);
        put("f1", true);
        put("b2", true);
        put("f2", false);
        put("b3", true);
        put("f3", false);
        put("b4", false);
        put("f4", true);
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

    private void turnRoverInDirection(Direction currentDirection, int turn, String turningDirection) {
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

        roverPosition.setDirection(getDirectionDict.get(newDirection));
    }

    private void moveRoverForwardsOrBackwards(int moveAmount, String moveDirection) {
        String key = moveDirection + roverPosition.getDirection().getDirectionNumber();
        if(roverPosition.getDirection() == Direction.North || roverPosition.getDirection() == Direction.South){
            roverPosition.setXCoordinate(moveRover(roverPosition.getXCoordinate(), moveAmount, getIsGoingForward.get(key)));
        }
        else{
            roverPosition.setYCoordinate(moveRover(roverPosition.getXCoordinate(), moveAmount, getIsGoingForward.get(key)));
        }
    }

    private int moveRover(int coordinate, int moveAmount, boolean forwards) {
        int newCoordinate = coordinate;
        for (int i = 0; i != moveAmount; i++) {
            if (forwards) {
                newCoordinate += 1;
            } else {
                newCoordinate -= 1;
            }

            if (newCoordinate > 5) {
                newCoordinate = 1;
            }
            if (newCoordinate < 1) {
                newCoordinate = 5;
            }
        }
        return newCoordinate;
    }

    public RoverPosition moveRover(String commandStr) throws Exception {

        if (!validateCommandString(commandStr)) throw new Exception("Invalid command string");

        String[] commands = commandStr.split(",");

        for (String command : commands) {
            if (command.startsWith("f") || command.startsWith("b")) {
                int moveAmount = Integer.parseInt(command.substring(1));
                String moveDirection = command.substring(0, 1);
                moveRoverForwardsOrBackwards(moveAmount, moveDirection);
            }
            if (command.startsWith("l") || command.startsWith("r")) {
                int turnMovement = Integer.parseInt(command.substring(1));
                String turnDirection = command.substring(0, 1);
                turnRoverInDirection(roverPosition.getDirection(), turnMovement, turnDirection);
            }
        }
        return roverPosition;
    }
}
