//import java.util.Arrays;

public class SolutionAttempt {
    private final PuzzleBit[][] puzzle;
    private final int ROWS;
    private final int COLS;

    public SolutionAttempt(int nrRows, int nrCols){
        ROWS = nrRows;
        COLS = nrCols;
        puzzle = new PuzzleBit[nrRows][nrCols];

    }

    public String toString(){
        String representation = "";
        for (PuzzleBit[] row : puzzle) {
            for (PuzzleBit bit : row) {
                if (bit == null){
                    representation += "NULL"  + " ";
                    continue;
                }
                representation += bit.toString() + " ";
            }
            representation+="\n";
        }
        return representation;
    }

    public void setPuzzleBit(PuzzleBit bit , int row, int col){
        puzzle[row][col] = bit;
    }



    public PuzzleBit getPuzzleBit(Position position){
        return puzzle[position.row][position.col];
    }


    public void setPuzzleBit(Position position, PuzzleBit bit){//controll should be made in this function
        puzzle[position.row][position.col] = bit;
    }


    private boolean matchUp(PuzzleBit bit,Position position){
        int row = position.row - 1;
        if (row < 0){
            return  (bit.getTopSide()==Side.FLAT);
            }
        Position newPosition = new Position(row,position.col);
        PuzzleBit aboveBit = getPuzzleBit(newPosition);

        if (aboveBit==null){
            if (bit.getTopSide() != Side.FLAT){
                return true;
            }
            else{
                return false;
            }
        }

        if (aboveBit.getBotSide()==Side.IN){
            return bit.getTopSide()== Side.OUT;
        }
        if (aboveBit.getBotSide()==Side.OUT){
            return bit.getTopSide()==Side.IN;
        }
        return false;
    }

    private boolean mathLeft(PuzzleBit bit,Position position){
        int col = position.col - 1;
        if (col < 0){
            return  (bit.getLeftSide()==Side.FLAT);
        }
        Position newPosition = new Position(position.row, col);
        PuzzleBit bitToTheLeft = getPuzzleBit(newPosition);

        if (bitToTheLeft==null){
            if (bit.getLeftSide() != Side.FLAT){
                return true;
            }
            else{
                return false;
            }
        }

        if (bitToTheLeft.getRightSide()==Side.IN){
            return bit.getLeftSide()== Side.OUT;
        }
        if (bitToTheLeft.getRightSide()==Side.OUT){
            return bit.getLeftSide()==Side.IN;
        }
        return false;
    }

    private boolean matchDown(PuzzleBit bit , Position position){
        int row = position.row + 1;
        if (row >= ROWS){
            return  (bit.getBotSide()==Side.FLAT);
        }
        Position newPosition = new Position(row,position.col);
        PuzzleBit belowBit = getPuzzleBit(newPosition);

        if (belowBit==null){
            if (bit.getBotSide() != Side.FLAT){
                return true;
            }
            else{
                return false;
            }
        }

        if (belowBit.getTopSide()==Side.IN){
            return bit.getBotSide()== Side.OUT;
        }
        if (belowBit.getTopSide()==Side.OUT){
            return bit.getBotSide()==Side.IN;
        }
        return false;
    }

    private boolean matchRight(PuzzleBit bit , Position position){
        int col = position.col + 1;
        if (col >= COLS){
            Side rightSide = bit.getRightSide();
            return  (rightSide==Side.FLAT);
        }
        Position newPosition = new Position(position.row, col);
        PuzzleBit bitToTheRight = getPuzzleBit(newPosition);

        if (bitToTheRight==null){
            if (bit.getRightSide() != Side.FLAT){
                return true;
            }
            else{
                return false;
            }
        }

        if (bitToTheRight.getLeftSide()==Side.IN){
            return bit.getRightSide()== Side.OUT;
        }
        if (bitToTheRight.getLeftSide()==Side.OUT){
            return bit.getRightSide()==Side.IN;
        }
        return false;
    }

    public boolean isEmpty(Position position){
        return getPuzzleBit(position)==null;
    }

    public boolean possibleToInsertBit(PuzzleBit bit, Position position){
        //boolean matchUp = sideMatch(bit,position , Offset.UP);
        //boolean matchRight = sideMatch(bit,position, Offset.RIGHT);
        //boolean matchDown = sideMatch(bit,position, Offset.DOWN);
        //boolean matchLeft = sideMatch(bit,position, Offset.LEFT);
        boolean isEmpty = isEmpty(position);
        boolean matchUp = matchUp(bit,position);
        boolean matchRight = matchRight(bit,position);
        boolean matchDown = matchDown(bit,position);
        boolean matchLeft = mathLeft(bit,position);
        return   matchUp &
                 matchRight &
                 matchDown &
                 matchLeft &
                 isEmpty;
    }
}

