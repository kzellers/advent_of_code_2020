import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class custom_customs_2{
  public static void main(String[] args){
    int count = 0;
    int line_num = 0;
    File f = new File("input.txt");
    try{
      Scanner sc = new Scanner(f);
      String s = "";
      while(sc.hasNext()){
        String line = sc.nextLine();
        if(line.isEmpty()){
          count += counter(s, line_num);
          s = "";
          line_num = 0;
        }else{
          s += line;
          line_num++;
        }
      }
      count += counter(s, line_num);
    }catch (FileNotFoundException e){
      System.out.println("Error: File not found");
    }
    System.out.println(count);
  }

  static int counter(String s, int line_num){
    int[] alpha = new int[26];
    int count = 0;
    for(int i=0; i<s.length(); i++){
      int index = s.charAt(i) - 'a';
      alpha[index]++;
    }
    for(int i=0; i<alpha.length; i++){
      if(alpha[i] == line_num) count++;
    }
    return count;
  }
}
