import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class report_repair{
   public static void main(String[] args){
      File f = new File("input.txt");
      HashSet<Integer> h = new HashSet<Integer>();
      try{
          Scanner sc = new Scanner(f);
          while(sc.hasNextLine()){
            int val = sc.nextInt();
            if(h.contains(2020-val)){
               System.out.println(val * (2020-val));
               return;
            }
            h.add(val);
          }
      }catch(FileNotFoundException e){
          System.out.println("Error: File not found");
      }
   }

}
