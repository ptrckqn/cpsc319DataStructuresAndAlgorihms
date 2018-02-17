/*
Patrick Quan 10152770
CPSC 319 Assignment 2
FileIO file
*/

import java.io.*;

public class FileIO{

  private FileWriter fw = null;
  private BufferedReader br = null;
  private PrintWriter pw = null;

  public void createFile(String outputFile){
    try{
      fw = new FileWriter(outputFile + ".txt");
      pw = new PrintWriter(fw);
    }
    catch(IOException e){
      System.out.println("Error creating output file");
    }
  }

  public void writeTo(String words){
    try{
      pw.print(words);
      pw.print("\n");
      fw.close();
    }

    catch(IOException e){
      System.out.println("Error writing to file");
    }
  }

  public String readFile(String inputFile) throws IOException{//Code sourced from http://www.gitlab.com
    String inputWords = "";
    try{
      br = new BufferedReader(new FileReader(inputFile + ".txt"));
      String str;
      while((str = br.readLine()) != null){
        inputWords = inputWords + str + " ";
      }
    }
    catch(IOException err){
      System.out.println("No such input file exists");
    }
    finally{
      if(br != null){
        br.close();
      }
      else{
        System.out.println("BufferReader did not open");
      }
    }
    return inputWords;
    }
}
