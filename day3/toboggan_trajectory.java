import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class toboggan_trajectory{
  public static void main(String[] args){
    File f = new File("input.txt");
    int count = 0;
    int pos = 0;
    try{
      Scanner sc = new Scanner(f);
      sc.nextLine(); //skip the first line
      while(sc.hasNextLine()){
        pos += 3;
        String line = sc.nextLine();
        if(pos >= line.length()) pos = pos%line.length();
        if(line.charAt(pos) == '#'){
          count++;
        }
      }
    }catch(FileNotFoundException e){
      System.out.println("Error: file not found");
    }
    System.out.println(count);
  }
}
