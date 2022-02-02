import junit.framework.TestCase;

public class OrderTest extends TestCase {

    public void testSimplest(){
        Order myOrder = new Order(2,2);
        myOrder.incrementPosition();
        Position expectedPosition = new Position(1,0);
        Position actualPosition = myOrder.getCurrentPosition();
        assertEquals(expectedPosition,actualPosition);
    }

    public void testOverShoot(){
        Order myOrder = new Order(2,2);
        myOrder.incrementPosition();
        myOrder.incrementPosition();
        Position expectedPosition = new Position(0,1);
        Position actualPosition = myOrder.getCurrentPosition();
        assertEquals(expectedPosition,actualPosition);
    }

    public void testInversabilityOfIncrement(){
        Order myOrder = new Order(2,2);
        Position expectedPosition = myOrder.getCurrentPosition();
        myOrder.incrementPosition();
        myOrder.incrementPosition();
        myOrder.decrementPosition();
        myOrder.decrementPosition();
        Position actualPosition = myOrder.getCurrentPosition();
        assertEquals(expectedPosition,actualPosition);
    }

    public void testMaximumIncrement(){
        Order myOrder = new Order(2,2);
        myOrder.incrementPosition();
        myOrder.incrementPosition();
        myOrder.incrementPosition();
        myOrder.incrementPosition();
        myOrder.incrementPosition();
        myOrder.incrementPosition();
        Position expectedPosition = new Position(1,1);
        Position actualPosition = myOrder.getCurrentPosition();
        System.out.println("actualPosition");
        System.out.println(actualPosition);
        assertEquals(expectedPosition,actualPosition);
    }

}