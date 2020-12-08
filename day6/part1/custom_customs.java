import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class custom_customs{
  public static void main(String[] args){
    int count = 0;
    File f = new File("input.txt");
    try{
      Scanner sc = new Scanner(f);
      String s = "";
      while(sc.hasNext()){
        String line = sc.nextLine();
        if(line.isEmpty()){
          count += counter(s);
          s = "";
        }else{
          s += line;
        }
      }
      count += counter(s);
    }catch (FileNotFoundException e){
      System.out.println("Error: File not found");
    }
    System.out.println(count);
  }

  static int counter(String s){
    int count = 0;
    HashSet<Character> h = new HashSet<Character>();
    for(int i=0; i<s.length(); i++){
      if(h.contains(s.charAt(i))) continue;
      h.add(s.charAt(i));
      count++;
    }
    return count;
  }
}
