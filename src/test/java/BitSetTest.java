import junit.framework.TestCase;

public class BitSetTest extends TestCase {
     public void testStandardConstructor(){
         BitSet mySet = new BitSet();
         }

     public void testConstructor(){
         String pathway = "C:\\Users\\oscar\\IdeaProjects\\puzzle-solving\\src\\test\\resources\\pusselindata.txt";
         BitSet mySet = new BitSet(pathway);
         assertEquals(20,mySet.getCardinality());
         assertEquals(18, mySet.getCircumference());
         mySet.showAvailableBits();
     }
}