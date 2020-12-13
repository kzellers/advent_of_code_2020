import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class encoding_error{
  public static void main(String[] args){
    ArrayList<Integer> nums = new ArrayList<Integer>();
    File f = new File("input.txt");
    try{
      Scanner sc = new Scanner(f);
      while(sc.hasNextInt()){
        nums.add(sc.nextInt());
      }
    }catch(FileNotFoundException e){
      System.out.println("Error: file not found");
    }
    HashSet<Integer> h = new HashSet<Integer>();
    int limit = 25;
    for(int i=0; i<limit; i++){
      h.add(nums.get(i));
    }
    boolean done = false;
    for(int i=limit; i<nums.size(); i++){
      for(int j=i-limit; j<i; j++){
        int temp = nums.get(i) - nums.get(j);
        if(h.contains(temp)){
          h.remove(nums.get(i-limit));
          break;
        }
        if(j == i-1){
          done = true;
          System.out.println(nums.get(i)); //prints out answer
          break;
        }
      }
      if(done) break;
      h.add(nums.get(i));
    }
  }
}
