import java.util.*;
public class Quick {

  public static int partition (int[] data, int start, int end){
    Random random = new Random();
    int index = random.nextInt(end-start+1) + start; //random index from start to end, inclusive
    int pivot = data[index]; //sets the pivot value of the data
    int temp = start; //a counter variable
    swap(index, end, data); //moves the pivot value to the back of the array
    index = end; //now, the index of the pivot value is the end of the array
    end--; //decrease the end by 1 because we won't be looking at the last value of the array, which is the pivot
    while (start <= end) { //while we can still loop through until the end value of array
      if (data[start] == pivot) { //if the current value is == to the pivot,
        start++; //disregard it and look at next one
      }
      else {
        if (data[start] < pivot) { //if current value is < pivot
          swap(start, temp, data); //swap current value and value at temp counter index
          start++; //increment
          temp++; //increment
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

  public static int newPartition(int[] data, int start, int end) {
    int lo = data[0];
    int hi = data[data.length-1];
    int mid = data[(data.length-1)/2];
    int index = 0;
    int pivot = 0;
    if (lo > hi && lo < mid || lo > mid && lo < hi) {
      index = 0;
      pivot = lo;
    }
    else if (hi > lo && hi < mid || hi > mid && hi < lo) {
      index = data.length-1;
      pivot = hi;
    }
    else {
      index = (data.length-1)/2;
      pivot = mid;
    }
    swap(index, start, data);
    int i = start+1;
    int j = end;
    while (i <= j) {
      if (data[i] < pivot) {
        swap(i, )
      }
    }










}
