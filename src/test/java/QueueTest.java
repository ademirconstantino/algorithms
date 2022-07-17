import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class QueueTest {
  
   private Queue queue;

   @Before public void setUp() {
      queue = new Queue();
   }


   @Test public void defaultTest() {
   
      Object o = new Object();
      Object o1 = new Object();
      
      queue.enQueue(o);
      queue.enQueue(o1);
         
      Assert.assertEquals(o, queue.deQueue());
      Assert.assertEquals(o1, queue.deQueue());
   }
}
