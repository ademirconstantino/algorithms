import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class LinkedListTest {

   private LinkedList linkedList;

   @Before public void setUp() {
      linkedList = new LinkedList();
   }


   @Test public void defaultTest() {
     
      ItemLinked item1 = new ItemLinked("Ademir");
      ItemLinked item2 = new ItemLinked("Constantino");
      ItemLinked item3 = new ItemLinked("Filho");
      
      linkedList.add(item1, 0);
      linkedList.add(item2, 1);
      linkedList.add(item3, 2);
      
      Assert.assertEquals(item1, linkedList.get(0));
      Assert.assertEquals(item2, linkedList.get(1));
      Assert.assertEquals(item3, linkedList.get(2));

      linkedList.remove(1);
      
      Assert.assertEquals(linkedList.size(), 2);
      
      Assert.assertEquals(item3, linkedList.get(1));
   }
}
