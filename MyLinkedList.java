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

    private int length ;
    private Node start,end;

    public MyLinkedList(){
      start = null;
      end = start;
      length = 0;
    }

    public String toString(){
      String output = "";
      try{
        Node current = start;
        while (current.next() != null){
          output += current.getData() + ", ";
          current = current.next();
        }
        output += current.getData();
        return "[" + output + "]";
      }
     catch (NullPointerException e){
       return "[]";
     }
   }

    public void clear(){
      length = 0;
      start = null;
      end = null;
    }

    public boolean add(E element){
      if (length == 0){
        start = new Node(element, null, null);
        end = start;
      }
      else{
        Node current = new Node(element, end, null);
        end.setNext(current);
        end = current;
      }
      length++;
      return true;
    }

    public int size(){
      return length;
    }


    public void extend (MyLinkedList<E> other){
        if (other.size() != 0){
          if(size() == 0){
            start = other.start;
            end = other.end;
          }
          else{
            other.start.setPrev(end);
            end.setNext(other.start);
          }
          end = other.end;
          length += other.size();
          other.clear();
        }
    }

    private Node getNthNode(int N){
      Node current = start;
      for (int i = 0; i < N; i++) {
        current = current.next();
      }
      return current;
    }

    public E removeFront(){
      E val = getNthNode(0).getData();
      if (length == 1){
        start = null;
        end = start;
      }
      else{
        start = getNthNode(1);
        start.prev().setPrev(null);
      }
      length--;
      return val;
    }

    public static void main(String[] args){
      }

    }
