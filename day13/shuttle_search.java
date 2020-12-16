import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class shuttle_search {
  public static void main(String[] args){
      File f = new File("input.txt");
      String buses = "";
      int goal_dep = 0;
      try{
          Scanner sc = new Scanner(f);
          while(sc.hasNext()){
            goal_dep = Integer.parseInt(sc.next());
            buses = sc.next();
          }
      }catch (FileNotFoundException e){
          System.out.println("Error: file not found");
      }
      String[] bus = buses.split("\\,");
      int min_time = Integer.MAX_VALUE;
      int bus_id = -1;
      for(int i=0; i<bus.length; i++){
        if(bus[i].equals("x")){
          continue;
        }
        int b = Integer.parseInt(bus[i]);
        int time = goal_dep % b;
        time = b-time;
        if(time < min_time){
          min_time = time;
          bus_id = b;
        }
      }
      System.out.println(min_time * bus_id);
  }



}
