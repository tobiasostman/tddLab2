public class MarsRover {
    RoverPosition roverPosition;

    public MarsRover(RoverPosition roverPosition) {
        this.roverPosition = roverPosition;
    }

    public RoverPosition getRoverPosition() {
        return roverPosition;
    }

    public RoverPosition moveRover(String commandStr) {
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
        }

        return roverPosition;
    }
}
