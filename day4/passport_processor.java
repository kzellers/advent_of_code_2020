import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class passport_processor {
  static ArrayList<String> lines;
  public static void main(String[] args){
    File f = new File("input.txt");
    lines = new ArrayList<>();
    try{
      Scanner sc = new Scanner(f);
      String curr = "";
      while(sc.hasNextLine()){
        String line = sc.nextLine();
        if(line.isEmpty()){
          lines.add(curr);
          curr = "";
        }else{
          curr += (line + " ");
        }
      }
      lines.add(curr);
    }catch(FileNotFoundException e){
      System.out.println("Error: file not found");
    }
    int count = 0;
    for(int i=0; i<lines.size(); i++){
      System.out.println(lines.get(i));
      count += checker(lines.get(i));
      System.out.println("count: " + count);
    }
    System.out.println(count);
  }

  static int checker(String s){
    String[] pairs = s.split(" ");
    System.out.println("len: " + pairs.length);
    if(pairs.length < 7) return 0;
    if(pairs.length == 8) return 1;
    for(int i=0; i<pairs.length; i++){
      String[] temp = pairs[i].split(":");
      System.out.println("temp: " + temp[0]);
      if(temp[0].equals("cid")) return 0;
    }
    return 1;
  }
}
