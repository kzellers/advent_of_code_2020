import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class toboggan_trajectory_2{
  static ArrayList<String> slopes;
  public static void main(String[] args){
    File f = new File("input.txt");
    int count = 0;
    int pos = 0;
    slopes = new ArrayList<>();
    try{
      Scanner sc = new Scanner(f);
      while(sc.hasNextLine()){
        slopes.add(sc.nextLine());
      }
    }catch(FileNotFoundException e){
      System.out.println("Error: file not found");
    }
    long a = slope(1, 1);
    long b = slope(3, 1);
    long c = slope(5, 1);
    long d = slope(7, 1);
    long e = slope(1, 2);
    long res = a*b*c*d*e;
    System.out.println(a + " " + b + " " + c + " " + d + " " + e);
    System.out.println(res);
  }

  static int slope(int right, int down){
    int count = 0;
    int r = right;
    for(int i=down; i<slopes.size(); i+=down){
        if(r >= slopes.get(i).length()) r %= slopes.get(i).length();
        if(slopes.get(i).charAt(r) == '#'){
          count++;
        }
        r += right;
    }
    return count;
  }
}
