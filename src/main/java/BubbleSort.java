
public class BubbleSort {

   private int[] numbers;

   public BubbleSort() {
      this.numbers = new int[]{ 1, 5, 3, 2, 8, 7, 6, 4};
   }
   
   public int[] bubble(int[] values) {
   
      boolean exists = false;
      
      do {
         int swap;
         for(int i = 0; i < values.length; i++) {
            for(int j = 0; j < values.length; j++) {
               if(values[i] < values[j]) {
                  swap = values[i];
                  values[i] = values[j];
                  values[j] = swap;
               }
            }
         }
         
         exists = false;
         for(int i = 1; i < values.length; i++) {
            if(values[i-1] > values[i]) {
               exists = true;
            }
         }

      } while (exists);
      
      return values;
   }
   
   public void printArray(int values[]) {
      for(int i= 0; i < values.length; i++) {
         System.out.printf(" %d ", values[i]);
      }
      System.out.printf("\r\n");
   }
   
   public int[] getNumbers() {
      return this.numbers;
   }
   
   public void setNumbers(int[] numbers) {
      this.numbers = numbers;
   }
   
}