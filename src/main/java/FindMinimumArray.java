public class FindMinimumArray {

   int[] values;

   public FindMinimumArray() {
      values = new int[] {3,9,4,8,1};
   }
   
   public int findMinimum(int[] values) {
      int minimum = values[0];
      for(int i = 0; i < values.length; i++) {
         int valuei = values[i];
         for(int j = 0; j < values.length; j++) {
            int valuej = values[j];
            if(valuei < valuej && valuei < minimum) {
               minimum = valuei;
            }
         }
      }
      return minimum;
   }
   
   public int[] getValues() {
      return this.values;
   }

}