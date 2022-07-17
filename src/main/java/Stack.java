public class Stack  {

   int[] elements;
   
   public Stack() {
      elements = new int[0];
   }
   
   public void push(int element) {
      int[] newElements = new int[elements.length + 1];
      
      for (int i = 0; i < elements.length; i++) {
         newElements[i] = elements[i];
      }
      
      newElements[elements.length == 0 ? 0 : elements.length] = element;
      this.elements = newElements;
   }
   
   public int pop() {
      int returnValue = this.elements[elements.length - 1];
      
      int[] newElements = new int[elements.length - 1];
      
      for (int i = 0; i < elements.length - 1; i++) {
         newElements[i] = elements[i];
      }
      
      this.elements = newElements;
      
      return returnValue;
   }
   
   public int peek() {
      return elements[0];
   }
   
   public boolean isEmpty() {
      return elements.length < 1;
   }
   
   public void printArray() {
      for (int i = 0; i < elements.length; i++) {
         System.out.printf("elements[%d]:" + 
         elements[i] +"\r\n", i);
      }
   }


}