import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class adapter_array {
  public static void main(String[] args){
      File f = new File("input.txt");
      ArrayList<Integer> nums = new ArrayList<Integer>();
      try{
          Scanner sc = new Scanner(f);
          nums.add(0);
          while(sc.hasNextInt()){
            int temp = sc.nextInt();
            nums.add(temp);
          }
      }catch (FileNotFoundException e){
          System.out.println("Error: file not found");
      }
      Collections.sort(nums);
      nums.add(nums.get(nums.size()-1) + 3);
      int[] diffs = new int[4];
      for(int i=1; i<nums.size(); i++){
        int num0 = nums.get(i-1);
        int num1 = nums.get(i);
        diffs[num1-num0]++;
      }
      System.out.println(diffs[1] + " " + diffs[3]);
      System.out.println(diffs[1] * diffs[3]);
  }

}
