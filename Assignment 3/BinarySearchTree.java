public class BinarySearchTree{ //Code sourced from geeksforgeeks.org

  public Node root;
  public String data;

  public BinarySearchTree(){
    root = null;
  }

  public void insert(String studentInfo){
    root = insertRec(root, studentInfo);
  }

  private Node insertRec(Node root, String studentInfo){
    String temp[] = studentInfo.split("[^A-Za-z0-9]+|(?<=[A-Za-z])(?=[0-9])|(?<=[0-9])(?=[A-Za-z])"); //regex splitting code sourced from stackoverflow.com
    String n = temp[1];
    String lN = temp[2];
    String hD = temp[3];
    String p = temp[4];
    String y = temp[5];

    if(root == null){
      root = new Node(n, lN, hD, p, y);
      return root;
    }

    if(lN.compareToIgnoreCase(root.getLastName()) < 0){
      root.left = insertRec(root.left, studentInfo);
    }

    else if(lN.compareToIgnoreCase(root.getLastName()) > 0){
      root.right = insertRec(root.right, studentInfo);
    }

    return root;
  }

  public void inOrder(){
    //data = "ID      Student Last Name         Home Prog Year\n--      -----------------         ---- ---- ----\n";
    data = ""; //Clear the previously sorted tree data
    inOrderRec(root);
  }

  private void inOrderRec(Node root){
    if(root != null){
      inOrderRec(root.left);
      data += root.getData() + "\n";
      inOrderRec(root.right);
    }
  }

  public String getTree(){
    return data;
  }

  private int height(Node root){
    if(root == null){
      return 0;
    }
    else{
      int lHeight = height(root.left);
      int rHeight = height(root.right);

      if(lHeight > rHeight){
        return(lHeight + 1);
      }

      else{
        return(rHeight + 1);
      }
    }
  }

  public void breadthFirst(){
    //data = "ID      Student Last Name         Home Prog Year\n--      -----------------         ---- ---- ----\n";
    data = "";
    int h = height(root);
    for (int i = 1; i <= h; i++) {
      breadthFirstRec(root, i);
    }
  }

  private void breadthFirstRec(Node root, int level){
    if(root == null){
      return;
    }
    if(level == 1){
      data += root.getData() + "\n";
    }

    else if(level > 1){
      breadthFirstRec(root.left, level - 1);
      breadthFirstRec(root.right, level - 1);
    }
  }

  public void delete (String studentInfo){
    root = deleteRec(root, studentInfo);
  }

  private Node deleteRec(Node root, String studentInfo){
    String temp[] = studentInfo.split("[^A-Za-z0-9]+|(?<=[A-Za-z])(?=[0-9])|(?<=[0-9])(?=[A-Za-z])"); //regex splitting code sourced from stackoverflow.com
    String lN = temp[2];

    if(root == null){
      return root;
    }

    if (lN.compareToIgnoreCase(root.getLastName()) < 0){
      root.left = deleteRec(root.left, studentInfo);
    }
    else if (lN.compareToIgnoreCase(root.getLastName()) > 0){
      root.right = deleteRec(root.right, studentInfo);
    }
    else{
      if(root.left == null){
        return root.right;
      }
      else if (root.right == null){
        return root.left;
      }
      Node tempNode = getMin(root.right);
      String tempNumber = tempNode.getNumber();
      String tempLastName = tempNode.getLastName();
      String tempHomeDept = tempNode.getHomeDept();
      String tempProgram = tempNode.getProgram();
      String tempYear = tempNode.getYear();
      root.setStudentData(tempNumber, tempLastName, tempHomeDept, tempProgram, tempYear);

      String tempS = "D";
      tempS += tempNode.getData();
      root.right = deleteRec(root.right, tempS);
    }
    return root;
  }

  public Node getMin(Node root){
    Node temp = root;
    while(temp.left != null){
      temp = temp.left;
    }
    return temp;
  }


}
