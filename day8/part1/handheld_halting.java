import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class handheld_halting{
  public static void main(String[] args){
    int count = 0;
    int iterator = 0;
    HashSet<Integer> h = new HashSet<>();
    ArrayList<String> instructions = new ArrayList<>();
    ArrayList<Integer> moves = new ArrayList<>();
    File f = new File("input.txt");
    try{
      Scanner sc = new Scanner(f);
      while(sc.hasNext()){
        String next = sc.next();
        if(iterator%2 == 0){
          instructions.add(next);
        }else{
          String neg = next.substring(0,1);
          next = next.substring(1);
          int val = Integer.parseInt(next);
          if(neg.equals("-")) val *= -1;
          moves.add(val);
        }
        iterator++;
      }
    }catch(FileNotFoundException e){
      System.out.println("Error: file not found");
    }
    int curr = 0;
    while(!h.contains(curr)){
      h.add(curr);
      String temp = instructions.get(curr);
      if(temp.equals("nop")|| temp.equals("acc")){
        if(temp.equals("acc")){
          count += moves.get(curr);
        }
        curr++;
      }else{
        curr += moves.get(curr);
      }
    }
    System.out.println(count);

  }


}
