import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class handheld_halting_2{
  static ArrayList<String> instructions;
  static ArrayList<Integer> moves;
  static int res;
  public static void main(String[] args){
    int count = 0;
    int iterator = 0;
    HashSet<Integer> h = new HashSet<>();
    instructions = new ArrayList<>();
    moves = new ArrayList<>();
    Stack<Integer> index = new Stack<>();
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
      if(temp.equals("nop") || temp.equals("acc")){
        if(temp.equals("acc")){
          count += moves.get(curr);
        }else{
          index.push(curr);
        }
        curr++;
      }else{
        index.push(curr);
        curr += moves.get(curr);
      }
    }
    for(int i=index.size()-1; i>=0; i--){
      boolean b = helper(index.get(i));
      if(b) break;
      index.pop();
    }
    System.out.println(res);
  }

  static boolean helper(int index){
    int count = 0;
    HashSet<Integer> h = new HashSet<Integer>();
    String orig = instructions.get(index);
    if(orig.equals("nop")){
      instructions.set(index, "jmp");
    }else{
      instructions.set(index, "nop");
    }
    int curr = 0;
    while(!h.contains(curr) && curr < instructions.size()){
      h.add(curr);
      String temp = instructions.get(curr);
      if(temp.equals("nop") || temp.equals("acc")){
        if(temp.equals("acc")){
          count += moves.get(curr);
        }
        curr++;
      }else{
        curr += moves.get(curr);
      }
    }
    instructions.set(index, orig);
    if(curr < instructions.size()) return false;
    res = count;
    return true;
  }


}
