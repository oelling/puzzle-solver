public class Order {
    private Position currentPosition;
    private Position originalPosition;
    private Position finalPosition;
    private int rows;
    private int cols;

    public Order(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        currentPosition = new Position(0 , 0);
        originalPosition = new Position(0,0);
        finalPosition = new Position(rows-1, cols-1);
    }

    public Position getCurrentPosition(){
        return currentPosition;
    }
    public Position getOriginalPosition(){
        return originalPosition;
    }

    public Position getFinalPosition(){
        return finalPosition;
    }

    public void incrementPosition(){
        if ((currentPosition.row == finalPosition.row)&(currentPosition.col == finalPosition.col) ){
            return;
        }
        Position nextPosition = currentPosition;
        nextPosition.row++;
        if (nextPosition.row ==rows){
            nextPosition.row = 0;
            nextPosition.col++;
        }
        this.currentPosition = nextPosition;
    }

    public void decrementPosition(){
        if ((currentPosition.row == originalPosition.row)&(currentPosition.col == originalPosition.col) ){
            return;
        }
        Position previousPosition = currentPosition;
        previousPosition.row--;
        if (previousPosition.row<0){
            previousPosition.row = rows -1;
            previousPosition.col--;
        }
        this.currentPosition = previousPosition;
    }
}
