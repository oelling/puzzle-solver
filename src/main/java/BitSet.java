import java.io.File;
import java.util.Scanner;

public class BitSet {
    private final int[] numberOfBitType;
    private int cardinality;
    private int nrPermutations;
    private int rows;
    private int cols;

    public BitSet(){
        cardinality = 0;
        numberOfBitType = new int[PuzzleBit.maximumOrderValue +1];
    }
    public BitSet(String pathToPuzzleBitData){
        this();
        File file = new File(pathToPuzzleBitData);
        try{
            Scanner sc = new Scanner(file);
            readAndAdaptToFile(sc);
        }catch (Exception e){
            System.out.println("There was an exception in BitSets attempt to read the data from :" + pathToPuzzleBitData);
        }
    }


    public int getCardinality() {
        return cardinality;
    }

    public int getCircumference(){
        return 2*rows + 2*cols;
    }

    public int getRows(){
        return rows;
    }

    public int getCols(){
        return cols;
    }

    public int getNrPermutations(){return nrPermutations;}

    public void put(PuzzleBit bit){
        if (bit == null){
            return;
        }
        numberOfBitType[bit.orderValue()]++;
    }

    public PuzzleBit pop(int orderValue){
        if (numberOfBitType[orderValue]>0){
            numberOfBitType[orderValue]--;
            return new PuzzleBit(orderValue);
        }
        return null;
    }

    public boolean doWehaveBit(int orderValue){
        return numberOfBitType[orderValue]>0;
    }

    public boolean isEmpty(){
        for (int i = 0 ; i< numberOfBitType.length ; i++){
            if (numberOfBitType[i]>0) {
                return false;
            }
        }
        return true;
    }

    public PuzzleBit getBit(String representation){
        PuzzleBit helpBit = new PuzzleBit(representation);
        if (numberOfBitType[helpBit.orderValue()]>0){
            numberOfBitType[helpBit.orderValue()]--;
            return helpBit ;
        }
        return null;
    }

    private void readAndAdaptToFile(Scanner sc){
        String numberLine = sc.nextLine();
        cardinality = Integer.parseInt(numberLine);
        nrPermutations = 1;
        for (int i = 0 ; i<this.cardinality; i++) {
            String representation = sc.nextLine();
            incrementRows(representation);
            incrementCols(representation);
            PuzzleBit helperBit = new PuzzleBit(representation);
            int indexToIncrement = helperBit.orderValue();
            numberOfBitType[indexToIncrement]++;
            int multiplicand = numberOfBitType[indexToIncrement];
            nrPermutations = multiplicand * nrPermutations; // this builds up all the factorial multiplication
        }
    }

    private void incrementRows(String representation){
        if (representation.charAt(3)=='R'){
            rows++;
        }
    }

    private void incrementCols(String representation){
        if (representation.charAt(0)=='R'){
            cols++;
        }
    }

    public boolean isThereAGreaterBit(PuzzleBit bit){
        int startOrderValue = bit.orderValue();
        for (int i =startOrderValue; i < PuzzleBit.maximumOrderValue ; i++ ){
            if (numberOfBitType[i] > 0){
                return true;
            }
        }
        return false;
    }

    // dessa bör byta namn till pop för att förtydliga att vi tar bort en bitS
    public PuzzleBit getGreaterBit(PuzzleBit bit){
        int startOrderValue = bit.orderValue();
        int orderValueCounter = startOrderValue;
        for (int i = startOrderValue; i< PuzzleBit.maximumOrderValue; i++){
            if(numberOfBitType[i]>0){
                numberOfBitType[i]--;
                return new PuzzleBit(orderValueCounter);
            }
            orderValueCounter++;
        }
        throw new IllegalArgumentException();
    }

    public PuzzleBit getLowestBit(int lowerBound){
        int valueCounter = lowerBound+1 ;
        for(int i = lowerBound+1 ; i<PuzzleBit.maximumOrderValue; i++){
            if (numberOfBitType[i]>0){
                numberOfBitType[i] --;
                return new PuzzleBit(valueCounter);
            }
            valueCounter ++;
        }

        return null;

    }

    public void showAvailableBits(){
        int orderValue = 0;
        for (int j : numberOfBitType) {
            if (j != 0) {
                PuzzleBit helperBit = new PuzzleBit(orderValue);
                System.out.println(j + " : " + helperBit);
            }
            orderValue++;
        }
    }
}
