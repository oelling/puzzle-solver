public class Solver {
    public final BitSet bitSet;
    public final SolutionAttempt currentSolution;
    public final Order order;
    public final int originalNrBits;
    private int nrSolutions;

    public Solver(String filepath){
        bitSet = new BitSet(filepath);
        currentSolution = new SolutionAttempt(bitSet.getRows(), bitSet.getCols());
        originalNrBits = bitSet.getCardinality();
        order = new Order(bitSet.getRows(),bitSet.getCols());
        nrSolutions = 0;
    }

    int getNrSolutions(){
        return bitSet.getNrPermutations() * nrSolutions ;
    }

    // den här blir som ett steg till vänster i grafen
    public PuzzleBit popLowestPlaceable(int initialOrderValue){
        Position position = order.getCurrentPosition();
        int valueCount = initialOrderValue;
        for (int i= initialOrderValue ; i< PuzzleBit.maximumOrderValue +1 ; i++){
            if (bitSet.doWehaveBit(valueCount))
                if (currentSolution.possibleToInsertBit(new PuzzleBit(valueCount),position)){
                    return bitSet.pop(valueCount);
                }
            valueCount++;
        }
        return null;
    }

    public boolean doWeHaveASolution(){
        return bitSet.isEmpty();
    }

    public boolean StopCriteria(){
        PuzzleBit bitAtStart = currentSolution.getPuzzleBit(order.getOriginalPosition());
        return bitAtStart==null;
    }

    // när ska den anropas ? endast när vi inte kan lägga
    // returnerar ordervalue av biten som togs bort. Informationen can användas för att
    // se till att den biten man placerar har ett större ordervalue ; popLowestPlaceableBitLargerThan
    public int removeBit(){
        PuzzleBit removed = currentSolution.getPuzzleBit(order.getCurrentPosition());
        currentSolution.setPuzzleBit(order.getCurrentPosition(),null);
        bitSet.put(removed);
        return removed.orderValue();
    }

    // ska inte kallas när vi redan är klara
    // Positionen vi står på ska alltid vara nullS
    public void place(PuzzleBit toPlace){

        if (toPlace == null){
            throw new IllegalArgumentException("cannot place PuzzleBit that is null");
        }
        currentSolution.setPuzzleBit(order.getCurrentPosition(),toPlace);
    }


    public void calculateNrSolutions(){
        nrSolutions = 0;
        int orderValueLowerBound = -1;
        if (bitSet.isEmpty()){
            return;
        }
        while (true){

            // if we have a solution we remove and record the last orderValue
            if (doWeHaveASolution()){
                //System.out.println(currentSolution);
                nrSolutions++;
                // here we should be at the last position aswell;
                orderValueLowerBound = removeBit();
            }
            //System.out.println(currentSolution);
            // if we can place part we do so
            PuzzleBit toPlace = popLowestPlaceable( orderValueLowerBound+1);
            if (toPlace != null){
                place(toPlace);
                //System.out.println("bitPlaced =" +toPlace.toString());
                //System.out.println("orderValue = " + toPlace.orderValue());
                order.incrementPosition();
                orderValueLowerBound = -1;
            }else{
                //if we are at the initial position and could not place . We know that we are done
                if (order.getCurrentPosition().isEquals(order.getOriginalPosition())){
                    return;
                }
                // when we cannot place (but are not at the inital position) we take a step back and remove a bit
                order.decrementPosition();
                orderValueLowerBound = removeBit(); // returns the value of the bit being removed
            }

        }
    }
}
