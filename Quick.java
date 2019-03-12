import java.util.*;
public class Quick {
  /*
  Choose a random pivot element between the start and end index inclusive,
  Then modify the array such that:
  *1. Only the indices from start to end inclusive are considered in range
  *2. A random index from start to end inclusive is chosen, the corresponding
  *   element is designated the pivot element.
  *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
  *4. all elements in range that are larger than the pivot element are placed after the pivot element.
  *@return the index of the final position of the pivot element.
  */

  public static int partition (int[] data, int start, int end){
    Random random = new Random();
    int index = random.nextInt(end-start+1) + start;
    int pivot = data[index];
    int temp = start;
    swap(index, end, data);
    index = end;
    end--;
    while (start <= end) {
      if (data[start] == pivot) {
        start++;
      }
      else {
        if (data[start] < pivot) {
          swap(start, temp, data);
          start++;
          temp++;
        }
        else {
          swap(start, end, data);
          end--;
        }
      }
    }
    swap(index, start, data);
    index = start;
    return index;
  }

  public static void swap(int index1, int index2, int[] data) {
    int temp = data[index1];
    data[index1] = data[index2];
    data[index2] = temp;
  }
  /*
  //return the value that is the kth smallest value of the array.
  public static int quickselect(int[] data, int k) {

  }
  */
}