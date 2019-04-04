import java.util.*;
public class Radix{

  public static void radixsort(int[] data){
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    double max = getMaxdigit(data);
  //  MyLinkedList<Integer> holder = new MyLinkedList<>();
    // buckets initialization
    for (int i = 0; i < 20; i++){
      buckets[i] = new MyLinkedList<Integer>();
    }
    //the first iteration of bucket -- sort the onesdigit
    for(int t = 0; t < max + 1; t++){
      if (t == 0) {
        for (int i = 0; i < data.length; i++){
        int onesDigit = data[i] % 10;
      // if(data[i] < 0){
      //   buckets[9 - Math.abs(onesDigit)].add(data[i]);
      // }
      // else{
        buckets[10 + onesDigit].add(data[i]);
      }
    }
      // for (int k = 1; k < buckets.length; k++){
      //   buckets[0].extend(buckets[k]);
      // }
      else{
      // after the first iteration
      for (int j = 0; j < data.length; j++){
        int val = buckets[0].removeFront();
        int digitindex = (val / (int) Math.pow(10,t)) % 10;
        // if (val < 0){
        //   buckets[9 - Math.abs(digitindex)].add(val);
        // }
        // else{
          buckets[10 + digitindex].add(val);
        }
      }
    //extend after you assign value to bucket
    //extend to buckets so that clear up the old buckets
    for (int k = 1; k < buckets.length; k++){
      buckets[0].extend(buckets[k]);
    }
  }

  //copying onto the data from the sorted buckets;
  for (int i = 0; i < data.length; i++){
    data[i] = buckets[0].removeFront();
  }
}

public static double getMaxdigit(int[] data){
  double maxvalue = 0;
  for (int i = 0; i < data.length; i++){
    if (Math.log10(Math.abs(data[i])) > maxvalue){
      maxvalue = Math.log10(Math.abs(data[i]));
    }
  }
  return maxvalue;
}


    public static void main(String[] args) {
        Random gen = new Random();
        System.out.println("Size\t\tMax Value\tradix/builtin ratio ");
        int[] MAX_LIST = {1000000000, 500, 10};
        for (int MAX : MAX_LIST) {
            for (int size = 31250; size < 2000001; size *= 2) {
                long qtime = 0;
                long btime = 0;
                //average of 5 sorts.
                for (int trial = 0; trial <= 5; trial++) {
                    int[] data1 = new int[size];
                    int[] data2 = new int[size];
                    for (int i = 0; i < data1.length; i++) {
                        data1[i] = Math.abs(gen.nextInt()) % (MAX + 1);
                        data2[i] = data1[i];
                    }
                    long t1, t2;
                    t1 = System.currentTimeMillis();
                    Radix.radixsort(data2);
                    t2 = System.currentTimeMillis();
                    qtime += t2 - t1;
                    t1 = System.currentTimeMillis();
                    Arrays.sort(data1);
                    t2 = System.currentTimeMillis();
                    btime+= t2 - t1;
                    if (!Arrays.equals(data1, data2)) {
                        System.out.println("FAIL TO SORT!");
                        System.exit(0);
                    }
                }
                System.out.println(size + "\t\t" + MAX + "\t" + 1.0 * qtime / btime);
            }
            System.out.println();
        }
    }
}
