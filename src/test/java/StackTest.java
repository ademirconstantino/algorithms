import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class StackTest {

   private Stack stack;

   @Before public void setUp() {
      stack = new Stack();
   }

   @Test public void defaultTest() {
   
      stack.push(15);
      stack.push(45);
      stack.push(85);
   
      Assert.assertEquals(stack.pop(), 85);
      Assert.assertEquals(stack.pop(), 45);
      Assert.assertEquals(stack.isEmpty(), false);
      Assert.assertEquals(stack.pop(), 15);
      Assert.assertEquals(stack.isEmpty(), true);
   }
}
