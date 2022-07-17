import java.util.List;
import java.util.ArrayList;

public class Queue {

   private List items = new ArrayList<Object>(); 

   public void enQueue(Object o) {
      items.add(o);
   }
   
   public Object deQueue() {
      if(!isEmpty()) {
         Object returnObject = items.get(0);
         items.remove(0);
         return returnObject;
      }
      
      return null;
   }
   
   public int queueSize() {
      return items.size();
   }
   
   public boolean isEmpty() {
      return items.isEmpty();
   }

}