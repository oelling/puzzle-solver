public class Position{
    int row;
    int col;
    public Position(int row , int col){
        this.row = row ;
        this.col = col ;
    }

    public String toString(){
        return "row:"+this.row +"  col:" +this.col;
    }

/*
    public boolean equals(Object other){
        if( other == null | (getClass() != other.getClass())){
            return false;
        }
        Position otherPosition = (Position) other;
        return (this.row == otherPosition.row) & (this.col == otherPosition.col);
    }

 */

    public boolean isEquals(Position otherPosition){
        return (this.row == otherPosition.row) & (this.col == otherPosition.col);
    }
}

