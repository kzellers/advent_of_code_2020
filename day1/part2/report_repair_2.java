import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class report_repair_2{
   static ArrayList<Integer> nums;
   static boolean done = false;

   public static void main(String[] args){

     //set up file and list
      File f = new File("input.txt");
      nums = new ArrayList<>();

      //get input from file
      try{
          Scanner sc = new Scanner(f);
          while(sc.hasNextInt()){
            nums.add(sc.nextInt());
          }
      }catch(FileNotFoundException e){
          System.out.println("Error: File not found");
      }

      //sort list and search for values that add to 2020
      Collections.sort(nums);
      search(0, 1, nums.size()-1);

    }


    static void search(int i, int j, int k){
          if(i >= j || j >= k || done == true) return;
          int sum = nums.get(i) + nums.get(j) + nums.get(k);
          if(sum == 2020){
            System.out.println(nums.get(i) * nums.get(j) * nums.get(k));
            done = true;
            return;
          }
          if(sum > 2020){
            search(i, j, k-1);
          }else{
            search(i+1, j, k);
            search(i, j+1, k);
          }

      }
}
