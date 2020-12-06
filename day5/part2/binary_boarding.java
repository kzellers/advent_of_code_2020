import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class binary_boarding{
  static int max_value;
  static int[][] grid;
  public static void main(String[] args){
    max_value = 0;
    grid = new int[128][8];
    File f = new File("input.txt");
    try{
      Scanner sc = new Scanner(f);
      while(sc.hasNextLine()){
        String line = sc.nextLine();
        check_value(line);
      }
    }catch(FileNotFoundException e){
      System.out.println("Error: file not found");
    }
    for(int i=0; i<grid.length; i++){
      for(int j=0; j<grid[i].length; j++){
        if(j > 0 && (j < grid[i].length-1) && grid[i][j+1] > 0 && grid[i][j-1] > 0 && grid[i][j] == 0) System.out.println((i*8)+j);
      }
    }
  }

  static void check_value(String s){
    int lo = 0;
    int hi = 127;
    for(int i=0; i<7; i++){
      if(s.charAt(i) == 'F'){
        hi = (hi-lo)/2 + lo;
      }else{
        lo = (hi-lo)/2 + lo+1;
      }
    }
    int row = lo; //set row value

    lo = 0;
    hi = 7;
    for(int i=7; i<s.length(); i++){
      if(s.charAt(i) == 'L'){
        hi = (hi-lo)/2 + lo;
      }else{
        lo = (hi-lo)/2 + lo+1;
      }
    }
    int col = lo; //set column value

    //put value in grid
    grid[row][col]++;

    int num = (row*8) + col;
    if(num > max_value) max_value = num;

  }
}
