public class Rover {

    private int x;
    private int y;
    private String direction;
    private int yMax;
    private int xMax;
    private String instructions;


    public Rover() {
    }

    /*
    find direction
     */
    public String getDirection(String direction, String action) {

        try {
            if (!action.equalsIgnoreCase(null) && !direction.equalsIgnoreCase(null)) {
                switch (direction)
                {
                    case "N":
                        if (Action.L.toString().equalsIgnoreCase(action)){
                            this.direction = Direction.W.toString();
                        }else if (Action.R.toString().equalsIgnoreCase(action)){
                            this.direction = Direction.E.toString();
                        }
                        break;
                    case "S":
                        if (Action.L.toString().equalsIgnoreCase(action)){
                            this.direction = Direction.E.toString();
                        }else if (Action.R.toString().equalsIgnoreCase(action)){
                            this.direction = Direction.W.toString();
                        }
                        break;
                    case "E":
                        if (Action.L.toString().equalsIgnoreCase(action)){
                            this.direction = Direction.N.toString();
                        }else if (Action.R.toString().equalsIgnoreCase(action)){
                            this.direction = Direction.S.toString();
                        }
                        break;
                    case "W":
                        if (Action.L.toString().equalsIgnoreCase(action)){
                            this.direction = Direction.S.toString();
                        }else if (Action.R.toString().equalsIgnoreCase(action)){
                            this.direction = Direction.N.toString();
                        }
                        break;
                }
            }
        }catch (Exception e){
        }

        return this.direction;
    }

    /*
    find position when direction change
     */
    public String getPosition (String direction, int xMax, int yMax) throws Exception{

                switch (direction)
                {
                    case "N":
                        this.y = this.y + 1;
                        break;
                    case "S":
                        this.y = this.y - 1;
                        break;
                    case "E":
                        this.x = this.x + 1;
                        break;
                    case "W":
                        this.x = this.x - 1;
                        break;
                }

                if (x < 0 || x > xMax){
                    throw new NullPointerException();
                }

                if (y < 0 || y > yMax){
                    throw new NullPointerException();
                }

        return this.x+" "+this.y+" "+ direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
