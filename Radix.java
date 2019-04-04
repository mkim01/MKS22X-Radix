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

  int max = getMaxdigit(data);
  // for(int i = 1; i < 20; i++){
  //   // after the first iteration
  //   for (j = 0; j < holder.length; j++){
  //
  //     int digitindex = holder[i] /
  //     if (holder[i] < 0){
  //       buckets[9 - Math.abs(digitindex)].add(holder[i]);
  //     }
  //     else{
  //       buckets[10 + digitindex].add(holder[i]);
  //     }
  //   //extend after you assign value to bucket
  //   for (int i = 0; i < buckets.length; i++){
  //     holder.extend(buckets[i]);
  //   }
  // }

public static int getMaxdigit(int[] data){
  int maxvalue = 0;
  for (int i = 0; i < data.length; i++){
    if (Math.log10(Math.abs(data[i]) > maxvalue)){
      maxvalue = (Math.log10(Math.abs(data[i]));
    }
  }
  return maxvalue;
}


public static void main(String[] args){
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
                    radixsort(data2);
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
