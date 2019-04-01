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
  }
