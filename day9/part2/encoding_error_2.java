import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class encoding_error_2{
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
    int goal = 177777905;
    int p1=0;
    int p2=1;
    int sum = nums.get(p1) + nums.get(p2);
    while(sum != goal){
      if(sum < goal){
        p2++;
        sum += nums.get(p2);
      }else{
        sum -= nums.get(p1);
        p1++;
      }
    }
    ArrayList<Integer> res = new ArrayList<>();
    for(int i=p1; i<=p2; i++){
      res.add(nums.get(i));
    }
    Collections.sort(res);
    int min = res.get(0);
    int max = res.get(res.size()-1);
    System.out.println(min+max);
  }
}
