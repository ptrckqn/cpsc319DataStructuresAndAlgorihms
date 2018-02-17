//Patrick Quan, 10152770
//Assignment 1
//CPSC 319

import java.io.*; //Importing FileWriter and PrintWriter functions
import java.util.Random; //Importing Random function

public class assignment1{

  public static void main(String args[]){ //Driver function
    String order = args[0]; //Parsing the first command line argument as the order the array should be created in
    int userSize = Integer.parseInt(args[1]); //Parsing the second command line argument as the size of the array
    String sortChoice = args[2]; //Parsing the third command line argument as which sorting method to use
    String fileName = args[3]; //Parsing fourth command line argument as the output file name

    if(userSize <= 0){ //If statement used to determine if the array is invalid (ie. negative or zero). If true then the user is prompted and the program is exited.
      System.out.println("Invalid array size. Aborting program");
      System.exit(0);
    }

    int[] userArray = new int[userSize]; //Creating a new array empty with the specified size

    userArray = createArray(userSize, order); //Calling the creatArray function with arguments userSize and order. Then storing the new array in the userArray variable
    sortOp(sortChoice, userArray, fileName); //Calling the sortOp function with arguments of sortChoice, userArray and fileName
    System.out.println("The sorted array has been printed to: " + fileName + ".txt"); //Printing the name of the output file with the sorted array
  }

  //Fuction used to create an array with a specified size and order
  private static int[] createArray(int userSize, String order){
    int[] tempArr = new int[userSize];
    Random rand = new Random();
    int count = 0;
    int temp;

    //First index filled prior to the while loop in case the array only has 1 index
    tempArr[count] = rand.nextInt(10);
    count++;

    //While loop to fill the array depending on if the array should be ascending, descending or random
    while(count < userSize - 1){
      temp = rand.nextInt(10);
      if(order.equals("ascending")){
        temp = tempArr[count - 1] + temp;
        tempArr[count] = temp;
        count++;
      }
      else if (order.equals("descending")){
        temp = tempArr[count - 1] - temp;
        tempArr[count] = temp;
        count++;
      }
      else if (order.equals("random")){
        temp = rand.nextInt(1000);
        tempArr[count] = temp;
        count++;
      }
    }
    return tempArr; //Returning the created array
  }

  //Function used to determine which type of sorting method to use, timing how long the sorting operation takes, and printing the sorted array to an output file specified by the user, and printing the time required to run each sort
  private static void sortOp(String sortChoice, int[] arr, String fileName){
    double startTime = 0;
    double elapsedTime = 0;
    PrintWriter pw = null;
    FileWriter fw = null;
    int tempArr[] = new int[arr.length];
    int count = 0;

    if(sortChoice.equals("selection")){
      startTime = System.nanoTime();
      tempArr = selectionSort(arr);
      elapsedTime = System.nanoTime() - startTime;
    }
    else if(sortChoice.equals("insertion")){
      startTime = System.nanoTime();
      tempArr = insertionSort(arr);
      elapsedTime = System.nanoTime() - startTime;
    }
    else if(sortChoice.equals("merge")){
      startTime = System.nanoTime();
      mergeSort(arr, 0, arr.length - 1);
      elapsedTime = System.nanoTime() - startTime;
      tempArr = arr;
    }
    else if(sortChoice.equals("quick")){
      startTime = System.nanoTime();
      quickSort(arr, 0, arr.length - 1);
      elapsedTime = System.nanoTime() - startTime;
      tempArr = arr;
    }
    else
      System.out.println("Invalid sorting choice");
    try{
      fw = new FileWriter(fileName + ".txt");
      pw = new PrintWriter(fw);
      for(int i = 0; i < tempArr.length; i++)
        pw.println(tempArr[i]);
      fw.close();
    }

    catch(IOException e){
      System.out.println("Error writing to file");
    }
      System.out.println("Sorting duration: " + (elapsedTime / 1000000000)  + "seconds");
  }

  //Function used to sort the array using the selection sort method
  private static int[] selectionSort(int[] arr){ //Code sourced from Dr. Manzara
    for(int i = 0; i < arr.length - 1; i++){
      int min = i;
      for(int j = i + 1; j < arr.length; j++){
        if(arr[j] < arr[min]){
          min = j;
        }
        int temp = arr[min];
        arr[min] = arr[i];
        arr[i] = temp;
      }
    }
    return arr;
  }

  //Function used to sort the array using the insertion sort method
  private static int[] insertionSort(int[] arr){ //Code sourced from Dr. Manzara
    for(int i = 1, j; i < arr.length; i++){
      int temp = arr[i];
      for(j = i; j > 0 && temp < arr[j-1]; j--){
        arr[j] = arr[j-1];
      }
      arr[j] = temp;
    }
    return arr;
  }

  //Function used to sort the array using the merge sort method
  private static void mergeSort(int[] arr, int first, int last){ //Code sourced from https://www.geeksforgeeks.org/merge-sort/
    if(first < last){
      int mid = (first + last) / 2;
      mergeSort(arr, first, mid);
      mergeSort(arr, mid + 1, last);
      merge(arr, first, mid, last);
    }
  }

  //Function used to merge the given arrays from the merge sort into a single array
  public static void merge(int arr[], int l, int m, int r){
    //Code sourced from https://www.geeksforgeeks.org/merge-sort/
      int n1 = m - l + 1;
      int n2 = r - m;

      int L[] = new int [n1];
      int R[] = new int [n2];

      for (int i=0; i<n1; ++i)
          L[i] = arr[l + i];
      for (int j=0; j<n2; ++j)
          R[j] = arr[m + 1+ j];

      int i = 0, j = 0;

      int k = l;
      while (i < n1 && j < n2){
          if (L[i] <= R[j]){
              arr[k] = L[i];
              i++;
          }
          else{
              arr[k] = R[j];
              j++;
          }
          k++;
      }
      while (i < n1){
          arr[k] = L[i];
          i++;
          k++;
      }

      while (j < n2){
          arr[k] = R[j];
          j++;
          k++;
      }
  }

  //Function used to sort the array using the quick sort method
  public static void quickSort(int[] arr, int low, int high) {
  //Code sourced from https://www.programcreek.com/2012/11/quicksort-array-in-java/
    int middle = low + (high - low) / 2;
    int pivot = arr[middle];

    int i = low, j = high;
    while (i <= j) {
      while (arr[i] < pivot) {
        i++;
      }

      while (arr[j] > pivot) {
        j--;
      }

      if (i <= j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
      }
    }

    if (low < j)
      quickSort(arr, low, j);

      if (high > i)
      quickSort(arr, mid, high);
  }

}
