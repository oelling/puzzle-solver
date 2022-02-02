
import junit.framework.TestCase;

public class PuzzleBitTest extends TestCase {


    public void testOrderValue(){
        PuzzleBit myBit = new PuzzleBit(Side.values()[0],Side.values()[0],Side.values()[0],Side.values()[0]);
        assertEquals(0,myBit.orderValue());
        myBit = new PuzzleBit(Side.values()[0],Side.values()[0],Side.values()[2],Side.values()[0]);
        assertEquals(3*2,myBit.orderValue());
    }

    public void testOrderReversibility(){
        PuzzleBit myBit;
        int expectedOrderValue = 0;
        for (int i = 0; i < 81; i++) {
            myBit = new PuzzleBit(expectedOrderValue);
            assertEquals(expectedOrderValue, myBit.orderValue());
            expectedOrderValue++;
        }
    }

}