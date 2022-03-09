public class RoverPosition {

    int xCoordinate = 0;
    int yCoordinate = 0;
    Direction direction = Direction.North;

    public RoverPosition(int xCoordinate, int yCoordinate, Direction direction) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.direction = direction;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int xCoordinate) {
        if(xCoordinate > 5){
            this.xCoordinate = 1;
            return;
        }
        if(xCoordinate < 1 ){
            this.xCoordinate = 5;
            return;
        }
        this.xCoordinate = xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        if(yCoordinate > 5){
            this.yCoordinate = 1;
            return;
        }
        if(yCoordinate < 1){
            this.yCoordinate = 5;
            return;
        }
        this.yCoordinate = yCoordinate;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
