/*
Patrick Quan 10152770
CPSC 319 Assignment 2
LinkedList file
*/

public class LinkedList{
  public Node head;
  private Node tail;
  private static Sort sorting = new Sort();

  public LinkedList(){
    head = null;
    tail = null;
  }

  public Node getHead(){
    return head;
  }

  public void setHead(Node h){
    head = h;
  }

  public void add(String s){
    Node newNode = new Node(s, null);
    if(head == null){
      head = newNode;
      tail = head;
    }
    else{
      tail.setNext(newNode);
      tail = newNode;
    }
  }

  public String printTo(){
    String tempString = "";
    if (head.getNext() == null) {
      return head.getData();
    }
    Node temp = head;
    while(temp.getNext() != null){
      tempString = tempString + temp.getData() + " ";
      temp = temp.getNext();
    }
      tempString = tempString + temp.getData() + " ";
    return tempString;
  }

   public void alphaSort(){
     if (head.getNext() != null) {
       head = sorting.insertionSort(head);
     }
   }
}
