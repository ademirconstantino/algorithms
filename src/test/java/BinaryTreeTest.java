import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class BinaryTreeTest {

   private BinaryTree bt;

   @Before public void setUp() {
      bt = new BinaryTree();
   }

   @Test public void defaultTest() {
      bt.add(6);
      bt.add(4);
      bt.add(8);
      bt.add(3);
      bt.add(5);
      bt.add(7);
      bt.add(9);
      
      bt.depthFirstSearch();
      bt.breadthFirstSearch();
      
      Assert.assertEquals(bt.contains(6), true);
      Assert.assertEquals(bt.contains(4), true);
      Assert.assertEquals(bt.contains(8), true);
      Assert.assertEquals(bt.contains(3), true);
      Assert.assertEquals(bt.contains(5), true);
      Assert.assertEquals(bt.contains(7), true);
      Assert.assertEquals(bt.contains(9), true);
      
      bt.delete(8);
      
      Assert.assertEquals(bt.contains(6), true);
      Assert.assertEquals(bt.contains(4), true);
      Assert.assertEquals(bt.contains(8), false);
      Assert.assertEquals(bt.contains(3), true);
      Assert.assertEquals(bt.contains(5), true);
      Assert.assertEquals(bt.contains(7), false);
      Assert.assertEquals(bt.contains(9), true);
   }
}
