/*
Patrick Quan 10152770
CPSC 319 Assignment 2
Node file
*/

public class Node{

  private String word;
  private Node next;

  public Node(String s, Node n){
    word = s;
    next = n;
  }

  public void setNext(Node n){
    next = n;
  }

  public String getData(){
    return word;
  }

  public void setData(String s){
    word = s;
  }

  public Node getNext(){
    return next;
  }
}
