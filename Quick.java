import java.util.*;
public class Quick {

  /*
  public static int partition (int[] data, int start, int end){
    Random random = new Random();
    int index = random.nextInt(end-start+1) + start; //random index from start to end, inclusive
    int pivot = data[index]; //sets the pivot value of the data
    swap(index, end, data); //moves the pivot value to the back of the array
    index = end; //now, the index of the pivot value is the end of the array
    end--; //decrease the end by 1 because we won't be looking at the last value of the array, which is the pivot
    while (start <= end) { //while we can still loop through until the end value of array
      if (data[start] == pivot) { //if the current value is == to the pivot,
        start++; //disregard it and look at next one
      }
      else {
        if (data[start] < pivot) { //if current value is < pivot
          start++; //increment
        }
        else {
          swap(start, end, data); //if current value is > pivot
          end--; //decrease the end index to narrow down the range
        }
      }
    }
    swap(index, start, data); //lastly, place the pivot value back to its place
    index = start; //new index of the pivot is the index of start after the while loop is over
    return index; //returns the index of the pivot
  }
  */


  public static void swap(int index1, int index2, int[] data) {
    int temp = data[index1]; //assigns temp value
    data[index1] = data[index2]; //swapping
    data[index2] = temp; //swapping
  }

  //return the value that is the kth smallest value of the array.
  public static int quickselect(int[] data, int k) {
    int start = 0; //start is the first value of the array
    int end = data.length - 1; //end is the last value of the array
    for (int i = 0; i < data.length; i++) { //looping through the array
      int index = partition(data, start, end); //partition the data and get the index of the pivot value
      if (index > k) //if the index of the pivot is greater than k,
        end = index; //new end value is the index and narrow down the range
      if (index < k) //if the index of the pivot is less than k,
        start = index; //new start value is index and narrow down the range
      if (index == k) //if they are equal
        return data[k]; //then we found the k'th smallest value of the array!
    }
    return data[k]; //returns the k'th smallest value of the array
  }


  //improved partition
  public static int partition(int[] data, int start, int end) {
    Random random = new Random();
    int lo = data[start];
    int hi = data[end];
    int mid = data[(start+end)/2];
    int index = 0;
    int pivot = 0;
    if (lo > hi && lo < mid || lo > mid && lo < hi) {
      index = start;
      pivot = lo;
    }
    else if (hi > lo && hi < mid || hi > mid && hi < lo) {
      index = end;
      pivot = hi;
    }
    else {
      index = (start+end)/2;
      pivot = mid;
    }
    swap(index, end, data);
    index = end;
    int i = start;
    int j = end-1;
    while (i <= j) {
      if (data[i] < pivot) {
        i++;
      }
      else {
        if (data[i] > pivot) {
          swap(i, j, data);
          j--;
        }
        else {
          int rand = random.nextInt(100);
          if (rand < 50) {
            swap(i, j, data);
            j--;
          }
          else i++;
        }
      }
    }
    swap(end, i, data);
    index = i;
    return index;
  }


  public static String printArray(int[] data) {
    String result = "[";
    for (int i = 0; i < data.length; i++) {
      if (i != data.length - 1)
        result += data[i] + ", ";
      else result += data[i] + "]";
    }
    return result;
  }

  /*
  public static void main (String[] args) {
    int[] quick = {100, 1519438594, -2342342, 4, 4, 3, 3, 2, 2, 1, 1};
    //int i = Quick.partition(quick, 0, 12);
    //System.out.println(i);
    //System.out.println(printArray(quick));
    quicksort(quick, 0, 10);
    System.out.println(printArray(quick));
  }
  */

  public static void quicksort(int[] data) {
    quicksort(data, 0, data.length-1);
  }

  public static void insertionsort(int[] data, int lo, int hi) {
    int temp = 0;
    for (int i = lo+1; i < hi+1; i++) {
      temp = data[i];
      while (i > lo && temp < data[i-1]) {
        data[i] = data[i-1];
        i--;
      }
      data[i] = temp;
    }
  }

  public static void quicksort(int[] data, int lo, int hi) {
    if (lo < hi) {
      if (hi-lo <= 10) {
        insertionsort(data, lo, hi);
      }
      else {
        int pivotIndex = partition(data, lo, hi);
        quicksort(data, lo, pivotIndex-1);
        quicksort(data, pivotIndex+1, hi);
      }
    }
  }

  public static void main(String[]args){
    System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          Quick.quicksort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }
  }

}
