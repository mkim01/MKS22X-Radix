public class MyLinkedList<E>{
  class Node{
    private E data;
    private Node next,prev;

    public Node(E value, Node prev, Node next) {
      data = value;
      this.next = next;
      this.prev = prev;
    }
    public void setNext(Node other){
      next = other;
    }
    public void setPrev(Node other){
      prev = other;
    }
    public Node next(){
      return next;
    }
    public Node prev(){
      return prev;
    }
    public E getData(){
      return data;
    }
    public E setData(E i) {
      E old = data;
      data = i;
      return old;
    }
  }

    private int length = 0;
    private Node start,end;

    public MyLinkedList(){
      length = 0;
    }

    public void clear(){

    }

    public boolean add(E element){
      if (length == 0){
        Node n = new Node(element, start, end);
        start.prev().setNext(n);
        end.next().setPrev(n);
        return true;
      }
      if (length >= 1){
        Node n = new Node(element, null, end);
        n.prev().setNext(n);
        return true;
      }
      length++;
      return true;
    }

    public void extend (MyLinkedList other){
      if (other.size()!= 0){
        this.end.setNext(other.start);
        other.start.setPrev(this.end);
        this.end = other.end;
        other.start = null;
        other.end = null;
        length += other.size();
        other.length = 0;
    }
  }


    // public static void radixsort(int[] data){
    //   MyLinkedList<Integer> bucket = new MyLinkedList();
    //
    // }

  }
