import junit.framework.TestCase;

public class SolutionAttemptTest extends TestCase {

    public void testStringRep(){
        SolutionAttempt mySolution = new SolutionAttempt(2,4);
        System.out.println(mySolution);
    }

    public void testPossibleToInsertBitSimplest(){
        SolutionAttempt mySolution = new SolutionAttempt(1,1);
        PuzzleBit testBit = new PuzzleBit("RRRR");
        Position testPosition = new Position(0,0);
        assertTrue(mySolution.possibleToInsertBit(testBit,testPosition));

        testBit = new PuzzleBit("RUUI");
        assertFalse(mySolution.possibleToInsertBit(testBit, testPosition));
    }
    public void testPossibleToInsertExtra(){
        SolutionAttempt mySolution = new SolutionAttempt(2,1);
        mySolution.setPuzzleBit(new PuzzleBit("RRIR"), 0,0);
        PuzzleBit testBit = new PuzzleBit("URRR");
        System.out.println(mySolution);
        Position testPosition = new Position(1,0);
        assertTrue(mySolution.possibleToInsertBit(testBit,testPosition));

    }


    public void testProblematicPossibleToInsertBit(){
        SolutionAttempt mySolution = new SolutionAttempt(3,3);
        System.out.println(mySolution);
        PuzzleBit testBit = new PuzzleBit("RUIR");
        Position testPosition = new Position(0,0);
        Position testPosition2 = new Position(0,0);
        PuzzleBit testBit2 = new PuzzleBit("RUIR");
        assertTrue(mySolution.possibleToInsertBit(testBit,testPosition));
        mySolution.setPuzzleBit(testPosition,testBit);
        assertFalse(mySolution.possibleToInsertBit(testBit2,testPosition2));
    }


}