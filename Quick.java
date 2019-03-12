import java.util.*;
public class Quick {

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

  //return the value that is the kth smallest value of the array.
  public static int quickselect(int[] data, int k) {
    int start = 0;
    int end = data.length - 1;
    for (int i = 0; i < data.length; i++) {
      int index = partition(data, start, end);
      if (index > k)
        end = index;
      if (index < k)
        start = index;
      if (index == k)
        return data[k];
    }
    return data[k];
  }
  
}
