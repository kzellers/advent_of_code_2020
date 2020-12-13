import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class adapter_array_2 {
  static int count;
  public static void main(String[] args){
      File f = new File("input.txt");
      count = 0;
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
      nums.add(nums.get(nums.size()-1)+3);
      int[] ones = new int[5];
      int curr = 0;
      for(int i=1; i<nums.size(); i++){
        if(nums.get(i) - nums.get(i-1) == 1){
          curr++;
        }else{
          ones[curr]++;
          curr = 0;
        }
      }
      long total = (long) Math.pow(2, ones[2]);
      total *= (long) Math.pow(4, ones[3]);
      total *= (long) Math.pow(7, ones[4]);
      System.out.println(total);

    }



}
