import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class QuickSortTest {

   private QuickSort qs;

   @Before public void setUp() {
      qs = new QuickSort(new int[] {6, 3, 4, 5, 7, 10, 20, 40});
   }

   @Test public void defaultTest() {
      int[] sorted = qs.doQuickSort();
      qs.printArray(sorted);
   }
}
