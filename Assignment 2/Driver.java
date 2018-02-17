/*
Patrick Quan 10152770
CPSC 319 Assignment 2
Driver file
*/

import java.io.*;

public class Driver{
  public static void main(String[] args){
    String inputFile = args[0];
    String outputFile = args[1];
    FileIO io = new FileIO();
    Sort sorting = new Sort();
    String inputWords = null;
    String[] wordArr;
    LinkedList[] wordList;
    LinkedList[] sortedList;
    double startTime = 0;
    double elapsedTime = 0;
    double opStartTime = 0;
    int size = 0;

    startTime = System.nanoTime();
    try{
      inputWords = io.readFile(inputFile);
    }
    catch(IOException e){
      System.out.println("Error reading file");
    }
    elapsedTime = System.nanoTime() - startTime;
    System.out.println("Reading input file duration: " + (elapsedTime / 1000000000)  + " seconds");

    io.createFile(outputFile);

    wordArr = inputWords.split("\\s+");

    opStartTime = System.nanoTime();
    sorting.quickSort(wordArr, 0, wordArr.length - 1);
    elapsedTime = System.nanoTime() - opStartTime;
    System.out.println("Quicksort proccessing duration: " + (elapsedTime / 1000000000)  + " seconds");

    wordList = new LinkedList[wordArr.length];

    char[] tempI, tempJ;
    opStartTime = System.nanoTime();
    String tempStringOne, tempStringTwo;

    opStartTime = System.nanoTime();
    for (int i = 0;i < wordArr.length; i++) {
      if(wordArr[i] != ""){
        wordList[i] = new LinkedList();
        wordList[i].add(wordArr[i]);
        size++;
        for (int j = i + 1; j < wordArr.length; j++) {
          tempI = wordArr[i].toCharArray();
          tempJ = wordArr[j].toCharArray();
          sorting.insertionSort(tempI);
          sorting.insertionSort(tempJ);
          tempStringOne = new String(tempI);
          tempStringTwo = new String(tempJ);
          if(tempStringOne.equals(tempStringTwo)) {
            wordList[i].add(wordArr[j]);
            wordArr[j] = "";
            }
          }
            wordList[i].alphaSort();
      }
      }
      elapsedTime = System.nanoTime() - opStartTime;
      System.out.println("Anagram insertion sort proccessing duration: " + (elapsedTime / 1000000000)  + " seconds");

      sortedList = new LinkedList[size];
      for(int j = 0; j < sortedList.length; j++){
        sortedList[j] = wordList[j];
      }
      //sorting.quickSort(sortedList, 0, sortedList.length - 1); Not used due to nullPointerException error for larger input files



      String stringToPrint = "";
      for(int i = 0; i < sortedList.length; i++){
        if(sortedList[i] != null){
          stringToPrint += sortedList[i].printTo() + "\n";
        }
      }
      io.writeTo(stringToPrint);
      elapsedTime = System.nanoTime() - startTime;
      System.out.println("Total proccessing duration: " + (elapsedTime / 1000000000)  + " seconds");

    }
}
