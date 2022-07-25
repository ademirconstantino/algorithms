public class QuickSort {

   private int[] numbers;
   
   public QuickSort(int[] numbers) {
      this.numbers = numbers;
   }
   
   public int[] doQuickSort() {
      int pivot = findPivot(this.numbers);
      int[] minor = splitMinor(this.numbers, pivot);
      int[] greater = splitGreater(this.numbers, pivot);
      minor = quickSort(minor, 0, 1);
      greater = quickSort(greater, 0 , 1);
      int sorted[] = join(minor, greater);
      printArray(sorted);
      return sorted;
   }
   
   public int[] join(int[] first, int[] second) {
      int[] returnValue = new int[0];
      
      for(int i = 0; i < first.length;  i++) {
         returnValue = increaseArray(returnValue);
         returnValue[i] = first[i];
      }
      
      int index = first.length;
      for(int i = 0; i < second.length; i++) {
         returnValue = increaseArray(returnValue);
         returnValue[index] = second[i];
         index++;
      }
      
      return returnValue;
   }
   
   public int[] quickSort(int numbers[], int start, int end) {
   
      if(end >= numbers.length) {
         boolean existsUnsorted = existsUnsorted(numbers);
         if(existsUnsorted) {
            printArray(numbers);
            return quickSort(numbers, 0, 1);
         } else {
            return numbers;
         }
      }  
      
      if(numbers[end] < numbers[start]) {
         int swap = numbers[end];
         numbers[end] = numbers[start];
         numbers[start] = swap;
         printArray(numbers);
      }
      
        return quickSort(numbers, start + 1, end + 1);
   }
   
   public boolean existsUnsorted(int[] numbers) {
      boolean returnValue = false;
      
      for(int i = numbers.length - 1; i > 0; i--) {
         if(numbers[i] < numbers[i - 1]) {
            returnValue = true;
            break;
         }
      }
      
      return returnValue;
   }
   
   public int[] increaseArray(int[] numbers) {
      int[] increased = new int[numbers.length + 1];
      for(int i = 0; i < numbers.length; i++) {
         increased[i] = numbers[i];
      }
      
      return increased;
   }
   
   public int[] splitGreater(int[] numbers, int pivot) {
   
      int[] greater = new int[0];
      int count = 0;
      for(int i = 0; i < numbers.length; i++) {
         if(numbers[i] >= pivot) {
            greater = increaseArray(greater);
            greater[count] = numbers[i];
            count++;
         }
      }
   
      return greater;
   }
   
   public int[] splitMinor(int[] numbers, int pivot) {
      int[] minor = new int[0];
      boolean foundPivot = false;
      int count = 0;
      for(int i = 0; i < numbers.length; i++) {
            
         if(numbers[i] == pivot) {
            foundPivot = true;
            continue;
         }
         
         if(numbers[i] < pivot) {
            minor = increaseArray(minor);
            minor[count] = numbers[i];
            count++;
         }
      }
   
      return minor;
   }
   
   public int findPivot(int[] numbers) {

      int pivot = numbers[0];
      int higher = numbers[0];
      int lower = numbers[0];
      
      for(int i = 1; i < numbers.length; i++) {
        if(numbers[i] > higher)
            higher = numbers[i];
           
        if(numbers[i] < lower)
            lower = numbers[i];
      }
      
      for(int i = 0; i < numbers.length; i++) {
         if(numbers[i] <= higher && numbers[i] > lower) {
            pivot = numbers[i];
            break;
         }
      }
      
      System.out.println("Pivot: " + pivot);
      return pivot;
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