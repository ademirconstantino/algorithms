import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class BubbleSortTest {

   private BubbleSort bubble;

   @Before public void setUp() {
      bubble = new BubbleSort();
      bubble.printArray(bubble.getNumbers());
   }

   @Test public void defaultTest() {
   
      int[] ordered = bubble.bubble(bubble.getNumbers());
      bubble.printArray(ordered);
      
      boolean existsMinor = false;
      
      for(int i = 1; i < ordered.length; i++) {
         if(ordered[i-1] > ordered[i]) {
            existsMinor = true;
         }
      }
      
      Assert.assertFalse(existsMinor);
   }


}
