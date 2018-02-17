/*
Patrick Quan 10152770
CPSC 319 Assignment 2
Sort file
*/

public class Sort{

  public void quickSort(String arr[], int low, int high){ //Sourced from www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html
    if (arr == null || arr.length == 0)
        return;
    if (low >= high)
        return;
    int middle = low + (high - low) / 2;
    String pivot = arr[middle];
    int i = low, j = high;
    while (i <= j) {
        while (arr[i].compareTo(pivot) < 0) {
            i++;
        }
        while (arr[j].compareTo(pivot) > 0) {
            j--;

        }

        if (i <= j) {
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    if (low < j)
    quickSort(arr, low, j);
    if (high > i)
    quickSort(arr, i, high);
}

/* LinkedList quick sorting yielded a nullPointerException for all the example input files except example_1.txt thus this method of quicksort was not utilzed */
  public void quickSort(LinkedList arr[], int low, int high){ //Sourced from www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html
    if (arr == null || arr.length == 0)
        return;
    if (low >= high)
        return;
    int middle = low + (high - low) / 2;
    String pivot = arr[middle].head.getData();
    int i = low, j = high;
    while (i <= j) {
        while (arr[i].head.getData().compareTo(pivot) < 0) {
            i++;
        }
        while (arr[j].head.getData().compareTo(pivot) > 0) {
            j--;

        }

        if (i <= j) {
            LinkedList temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    if (low < j)
    quickSort(arr, low, j);
    if (high > i)
    quickSort(arr, i, high);
}


  public void insertionSort(char[] array){
    char temp;
    for(int i = 0; i < array.length; i++){
    int j = 0;
      for(j = i; j < array.length; j++){
        if(array[j] < array[i]){
          temp = array[j];
          array[j] = array[i];
          array[i] = temp;
        }
      }
    }
  }

  public static Node insertionSort(Node initial){
      LinkedList list = new LinkedList();
      list.add(initial.getData());
      Node nextNode = initial;
      while(nextNode.getNext() != null){
          Node compareNode = nextNode;
          Node key = compareNode.getNext();
          while(compareNode.getData().compareTo(key.getData()) < 0 && key.getNext() != null){
              key = key.getNext();
          }
          if(compareNode.getData().compareTo(key.getData()) < 0 && key.getNext() == null){
              nextNode = nextNode.getNext();
              list.add(key.getData());
          } else{
              nextNode = nextNode.getNext();
              Node temp = new Node(key.getData(), list.getHead());
              list.setHead(temp);
          }
      }
      return list.getHead();
  }
}
