import junit.framework.TestCase;

public class Solver2Test extends TestCase {
    public void testSinglet(){
        Solver mySolver = new Solver("C:\\Users\\oscar\\IdeaProjects\\puzzle-solving\\src\\test\\resources\\singlet.txt");
        mySolver.calculateNrSolutions();
        int expected = 1 ;
        int actual = mySolver.getNrSolutions();
        assertEquals(expected,actual);
    }
     // does not work at the moment with an empty input data
    public void testEmpty(){
        Solver mySolver = new Solver("C:\\Users\\oscar\\IdeaProjects\\puzzle-solving\\src\\test\\resources\\empty.txt");
        mySolver.calculateNrSolutions();
        int expected = 0 ;
        int actual = mySolver.getNrSolutions();
        assertEquals(expected,actual);
    }

    public void testFourPices(){
        Solver mySolver = new Solver("C:\\Users\\oscar\\IdeaProjects\\puzzle-solving\\src\\test\\resources\\testPusselData.txt");
        mySolver.calculateNrSolutions();
        int expected = 1 ;
        int actual = mySolver.getNrSolutions();
        assertEquals(expected,actual);
    }

    public void testStandardInput(){
        Solver mySolver = new Solver("C:\\Users\\oscar\\IdeaProjects\\puzzle-solving\\src\\test\\resources\\pusselIndataRecovered.txt");
        mySolver.calculateNrSolutions();
        int expected = 1 ;
        int actual = mySolver.getNrSolutions();
        assertEquals(expected,actual);
    }

    public void testPopLowestPlaceableBitLargerThan(){
        Solver mySolver = new Solver("C:\\Users\\oscar\\IdeaProjects\\puzzle-solving\\src\\test\\resources\\pusselindata.txt");
        PuzzleBit toPlace = mySolver.popLowestPlaceable(0);
        assertEquals("RUIR", toPlace.toString());
        mySolver.place(toPlace);
        mySolver.order.incrementPosition();
        toPlace = mySolver.popLowestPlaceable(0);
        assertEquals("UUUR",toPlace.toString());
        int initialOrderValue = toPlace.orderValue();
        toPlace = mySolver.popLowestPlaceable(initialOrderValue);
        System.out.println(toPlace);

    }
}