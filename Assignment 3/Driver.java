/*
Patrick Quan 10152770
CPSC 319 Assignment 3
Driver file
*/

import java.io.*;

public class Driver{
  public static void main(String args[]){

    if(args.length != 3){
      System.out.println("Invalid command line arguments");
      System.out.println("Command line format: java Driver inputFile output1 output2");
      System.exit(0);
    }

    String inputFile = args[0];
    String outputFileOne = args[1];
    String outputFileTwo = args[2];
    FileIO io = new FileIO();
    String input = "";
    String inputArr[];
    String temp[];
    BinarySearchTree bst = new BinarySearchTree();

    try{
      input = io.readFile(inputFile);
    }
    catch(IOException e){
      System.out.println("Error reading file");
    }

    inputArr = input.split("\n");

    for (int i = 0; i < inputArr.length; i++) {
      if(inputArr[i].charAt(0) == 'I'){
        bst.insert(inputArr[i]);
      }
      else if (inputArr[i].charAt(0) == 'D') {
        bst.delete(inputArr[i]);
      }
      else{
        System.out.println("Invalid operation choice");
      }
    }

    bst.inOrder();
    io.createFile(outputFileOne);
    io.writeTo(bst.getTree());

    bst.breadthFirst();
     io.createFile(outputFileTwo);
     io.writeTo(bst.getTree());
  }
}
