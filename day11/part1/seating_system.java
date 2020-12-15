import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class seating_system {
  static ArrayList<List<Integer>> rows;
  static int count;
  static boolean changed;
  public static void main(String[] args){
      File f = new File("input.txt");
      count = 2;
      rows = new ArrayList<List<Integer>>();
      try{
          Scanner sc = new Scanner(f);
          while(sc.hasNextLine()){
            String line = sc.nextLine();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i=0; i<line.length(); i++){
              if(line.charAt(i) == 'L'){
                temp.add(-1);
              }else if(line.charAt(i) == '#'){
                temp.add(1);
              }else{
                temp.add(0);
              }
            }
            rows.add(temp);
          }
      }catch (FileNotFoundException e){
          System.out.println("Error: file not found");
      }

      changed = true;
      while(changed == true){
        changed = false;
        for(int i=0; i<rows.size(); i++){
          for(int j=0; j<rows.get(i).size(); j++){
              if(rows.get(i).get(j) == 0) continue;
              int num = checker(i, j);
              if(num * rows.get(i).get(j) > 0) continue;
              if(rows.get(i).get(j) < 0){
                rows.get(i).set(j, count);
              }else{
                rows.get(i).set(j, (count * -1));
              }
          }
        }
        count++;
      }
      int res = 0;
      for(int i=0; i<rows.size(); i++){
        for(int j=0; j<rows.get(i).size(); j++){
          if(rows.get(i).get(j) > 0) res++;
        }
      }
      System.out.println(res);
  }

  static int checker(int x, int y){
      int num = rows.get(x).get(y);

      //check to make sure all adj. seats are empty
      if(num < 0){
        if(x-1 >= 0 && (rows.get(x-1).get(y) > 0 && rows.get(x-1).get(y) != count)){
          return num;
        }
        if(y-1 >= 0 && (rows.get(x).get(y-1) > 0 && rows.get(x).get(y-1) != count)){
          return num;
        }
        if(x+1 < rows.size() && (rows.get(x+1).get(y)) > 0 && rows.get(x+1).get(y) != count){
          return num;
        }
        if(y+1 < rows.get(x).size() && (rows.get(x).get(y+1) > 0 && rows.get(x).get(y+1) != count)){
          return num;
        }
        if(x-1 >= 0 && y-1 >= 0 && (rows.get(x-1).get(y-1) > 0 && rows.get(x-1).get(y-1) != count)){
          return num;
        }
        if(x-1 >= 0 && y+1 < rows.get(x-1).size() && (rows.get(x-1).get(y+1) > 0 && rows.get(x-1).get(y+1) != count)){
          return num;
        }
        if(x+1 < rows.size() && y-1 >= 0 && (rows.get(x+1).get(y-1)) > 0 && rows.get(x+1).get(y-1) != count){
          return num;
        }
        if(x+1 < rows.size() && y+1 < rows.get(x+1).size() && (rows.get(x+1).get(y+1)) > 0 && rows.get(x+1).get(y+1) != count){
          return num;
        }
        changed = true;
        return count;
      }
      int adj = 0;
      if(x-1 >= 0 && ((rows.get(x-1).get(y) > 0 || rows.get(x-1).get(y) == (count*-1)) && rows.get(x-1).get(y) != count)){
        adj++;
      }
      if(y-1 >= 0 && ((rows.get(x).get(y-1) > 0 || rows.get(x).get(y-1) == (count*-1))) && rows.get(x).get(y-1) != count){
        adj++;
      }
      if(x+1 < rows.size() && ((rows.get(x+1).get(y)) > 0 || rows.get(x+1).get(y) == (count*-1)) && rows.get(x+1).get(y) != count){
        adj++;
      }
      if(y+1 < rows.get(x).size() && (rows.get(x).get(y+1) > 0 || rows.get(x).get(y+1) == (count*-1)) && rows.get(x).get(y+1) != count){
        adj++;
      }
      if(x-1 >= 0 && y-1 >= 0 && (rows.get(x-1).get(y-1) > 0 || rows.get(x-1).get(y-1) == (count*-1)) && rows.get(x-1).get(y-1) != count){
        adj++;
      }
      if(x-1 >= 0 && y+1 < rows.get(x-1).size() && (rows.get(x-1).get(y+1) > 0 || rows.get(x-1).get(y+1) == (count*-1)) && rows.get(x-1).get(y+1) != count){
        adj++;
      }
      if(x+1 < rows.size() && y-1 >= 0 && ((rows.get(x+1).get(y-1)) > 0 || (rows.get(x+1).get(y-1) == (count*-1))) && rows.get(x+1).get(y-1) != count){
        adj++;
      }
      if(x+1 < rows.size() && y+1 < rows.get(x+1).size() && (rows.get(x+1).get(y+1) > 0 || (rows.get(x+1).get(y+1)) == (count *-1)) && rows.get(x+1).get(y+1) != count){
        adj++;
      }
      if(adj >= 4){
        changed = true;
        return (count * -1);
      }
      return num;
  }
}
