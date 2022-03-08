public class MarsRover {
    RoverPosition roverPosition;

    public MarsRover(RoverPosition roverPosition) {
        this.roverPosition = roverPosition;
    }

    public RoverPosition getRoverPosition() {
        return roverPosition;
    }

    private boolean validateCommandString(String commandStr){

        return commandStr.matches("^[fb]+[0-9]+(?:,[fb]+[0-9]+)*$");
    }

    public RoverPosition moveRover(String commandStr) throws Exception {

        if(!validateCommandString(commandStr)) throw new Exception("Invalid command string");

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
