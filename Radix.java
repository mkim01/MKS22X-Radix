import java.util.*;
public class Radix{

public static void radixsort(int[] data){
  @SuppressWarnings("unchecked")
  MyLinkedList<Integer>[] bucket = new MyLinkedList[20];
  for (int i = 0; i < 20; i++){
    bucket[i] = new MyLinkedList<Integer>();
  } // 20 buckets for negative numbers 0 - 19

  // int max = getMax()
  }


public static int getMax(int[] data){
  int maxdigit = 0;
  for (int i = 0; i < data.length; i++){
    if (data[i] > maxdigit){
      maxdigit = data[i];
    }
  }
  return maxdigit;
}



  // MyLinkedList<
  // for(int i = 0; i <= 9; i++){
  //   bucket.add(i);
  // }
  //
  // for(int i = 0; i < data.length; i++){
  //   int remain = data[i] % 10;
  //   if (remain >)
  //   bucket.add(data){
  //   }
  // }
}
