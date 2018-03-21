/*
Patrick Quan 10152770
CPSC 319 Assignment 3
Node file
*/

public class Node{

  private String number;
  private String lastName;
  private String homeDept;
  private String program;
  private String year;

  public Node left, right;

  public Node(String n, String lN, String hD, String p, String y){
    number = n;
    lastName = lN;
    homeDept = hD;
    program = p;
    year = y;
    left = null;
    right = null;
  }

  public String getNumber(){
    return number;
  }

  public String getLastName(){
    return lastName;
  }

  public String getHomeDept(){
    return homeDept;
  }

  public String getProgram(){
    return program;
  }
  public String getYear(){
    return year;
  }

  public String getData(){
    String temp = "";
    temp += properFormat(number, 7);
    temp += properFormat(lastName, 25);
    temp += properFormat(homeDept, 4);
    temp += properFormat(program, 4);
    temp += properFormat(year, 1);
    return temp;
  }

  public void setStudentData(String n, String lN, String hD, String p, String y){
    number = n;
    lastName = lN;
    homeDept = hD;
    program = p;
    year = y;
  }

  private String properFormat(String data, int length){
    String temp = data;
    for(int i = length - data.length(); i >= 0; i--){
      temp += " ";
    }
    return temp;
  }
}
