

public class PuzzleBit {
    private final Side topSide;
    private final Side rightSide;
    private final Side botSide;
    private final Side leftSide;
    public final static int maximumOrderValue = 80; // 3^4 -1 = 80;

    public PuzzleBit(Side topSide,
                     Side rightSide,
                     Side botSide,
                     Side leftSide){
        this.topSide = topSide;
        this.rightSide = rightSide;
        this.botSide = botSide;
        this.leftSide = leftSide;
    }
    public PuzzleBit(int orderValue){
        // see member function orderValue
        int ordinalTopSide = orderValue/(3*3*3);
        int residual = orderValue - (3*3*3)*ordinalTopSide;
        int ordinalRightSide = residual/(3*3);
        residual -= (3*3) * ordinalRightSide;
        int ordinalBotSide = residual / 3;
        residual -= 3 * ordinalBotSide;
        int ordinalLeftSide = residual;


        this.topSide =Side.values()[ordinalTopSide];
        this.rightSide = Side.values()[ordinalRightSide];
        this.botSide = Side.values()[ordinalBotSide];
        this.leftSide = Side.values()[ordinalLeftSide];
    }

    public PuzzleBit(String representation){
        char topRep = representation.charAt(0);
        char rightRep = representation.charAt(1);
        char botRep = representation.charAt(2);
        char leftRep = representation.charAt(3);

        this.topSide = Side.decode(topRep);
        this.rightSide = Side.decode(rightRep);
        this.botSide = Side.decode(botRep);
        this.leftSide = Side.decode(leftRep);
    }

    public String toString(){
        char firstChar = Side.encode(topSide);
        char secondChar = Side.encode(rightSide);
        char thirdChar = Side.encode(botSide);
        char forthChar = Side.encode(leftSide);
        String s = String.valueOf(firstChar);
        return s+secondChar + thirdChar + forthChar;
    }

    public int orderValue(){
        // this function helps us order solutions to the Puzzle
        // based on a 3-base number system
        return (3*3*3)* topSide.ordinal()+
                (3*3) * rightSide.ordinal()+
                (3) * botSide.ordinal()+
                leftSide.ordinal();
    }

    public boolean isSide(Side side, Offset offset){
        return switch (offset) {
            case UP -> this.topSide == side;
            case RIGHT -> this.rightSide == side;
            case DOWN -> this.botSide == side;
            case LEFT -> this.leftSide == side;
        };
    }

    public Side getTopSide(){
        return this.topSide;
    }
    public Side getRightSide(){
        return this.rightSide;
    }
    public Side getBotSide(){
        return this.botSide;
    }
    public Side getLeftSide(){
        return this.leftSide;
    }

    public Side getSide(Offset offset){
        return switch (offset) {
            case UP -> this.topSide;
            case RIGHT -> this.rightSide;
            case DOWN -> this.botSide;
            case LEFT -> this.leftSide;
        };
    }

    public Side getOppositeSide(Offset offset) {
        return switch (offset) {
            case UP -> getSide(Offset.DOWN);
            case RIGHT -> getSide(Offset.LEFT);
            case DOWN -> getSide(Offset.UP);
            case LEFT -> getSide(Offset.RIGHT);
        };
    }
}


