import java.util.*;
public class Radix{

public static void radixsort(int[] data){
  @SuppressWarnings("unchecked")
  MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
  MyLinkedList<Integer> holder = new MyLinkedList<Integer>();
  // buckets initialization
  for (int i = 0; i < 20; i++){
    buckets[i] = new MyLinkedList<Integer>();
  }
  //the first iteration of bucket -- sort the onesdigit
  for (int i = 0; i < data.length; i++){
    int onesDigit = data[i] % 10;
    if(data[i] < 0){
      buckets[9 - Math.abs(onesDigit)].add(data[i]);
    }
    else{
      buckets[10 + onesDigit].add(data[i]);
    }
  }
  //extend to buckets so that clear up the old buckets
  for (int i = 0; i < buckets.length; i++){
    holder.extend(buckets[i]);
  }

  // after the first iteration
  // for(int i = 0; i < data.length; i++){
  //   int digitindex = data[index]

  }

  // int max = getMax()



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
