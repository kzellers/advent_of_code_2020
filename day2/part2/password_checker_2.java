import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class password_checker_2 {
  public static void main(String[] args){
      File f = new File("input.txt");
      int count = 0;
      try{
          Scanner sc = new Scanner(f);
          while(sc.hasNext()){
            String range = sc.next();
            String letter = sc.next();
            String password = sc.next();
            count += is_valid(range, letter, password);
          }
      }catch (FileNotFoundException e){
          System.out.println("Error: file not found");
      }
      System.out.println(count);
  }

  static int is_valid(String range, String letter, String password){
      String[] ranges = range.split("\\-");
      int r1 = Integer.parseInt(ranges[0])-1; //subtract 1 since we are indexing from 1
      int r2 = Integer.parseInt(ranges[1])-1;
      char c = letter.charAt(0);
      int count = 0;
      if(r1 < password.length() && password.charAt(r1) == c) count++;
      if(r2 < password.length() && password.charAt(r2) == c) count++;
      if(count != 1) return 0;
      return 1;
  }
}
