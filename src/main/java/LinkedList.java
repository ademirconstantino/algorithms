public class LinkedList {

   private int counter;
   private ItemLinked head;
   
   public void add(ItemLinked o, Integer index) {
      if(get(index) != null) {
         throw new RuntimeException("Element already exists");
      } else {
      
      if(index.equals(0)) {
         this.head = o;
         this.incrementCounter();
      } else {
         ItemLinked cursor = this.get(index -1);
         cursor.setProssimo(o);
         this.incrementCounter();
      }
    }
   }
   
   public ItemLinked get(Integer index) {
   
      ItemLinked cursor = head;
            
      if (index.equals(0))
         return cursor;
      
      for(int i = 1; i <= index; i++) { 
         if(cursor != null) {
            cursor = cursor.getProssimo();
            if(index.equals(i))
              return cursor;
              
         }
      }
      return null;
   }
   
   public void remove(int i) {
    if(get(i) != null) {
       if(i==0) {
        ItemLinked previous = get(1);
        ItemLinked next = get(2);
        if(previous != null) {
           previous.setProssimo(next);
           this.head = previous;
         } else {
            this.head = null;
         }
         
         decrementCounter();
     
       } else {
         ItemLinked previous = get(i-1);
         ItemLinked next = get(i+1);
         previous.setProssimo(next);
         decrementCounter();
      }
    } else {
         throw new RuntimeException("Element nor found");
      }
   }
   
   public int size() {
      return this.counter;
   }
   
   public void incrementCounter() {
      this.counter = this.counter + 1;
   }
   public void decrementCounter() {
      this.counter = this.counter - 1;
   }

}