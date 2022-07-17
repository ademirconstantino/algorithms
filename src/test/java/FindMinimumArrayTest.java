import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class FindMinimumArrayTest {

   private FindMinimumArray findMinimum;

   @Before public void setUp() {
      findMinimum = new FindMinimumArray();
   }

   @Test public void defaultTest() {
      int[] values = findMinimum.getValues();
      int minimum = findMinimum.findMinimum(values);
      Assert.assertEquals(minimum, 1);
   }
}
