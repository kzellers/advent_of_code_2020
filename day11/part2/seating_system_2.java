import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class seating_system_2 {
  static ArrayList<List<Integer>> rows;
  static int count;
  static int occ;
  static boolean changed;
  public static void main(String[] args){
      File f = new File("input.txt");
      count = 2;
      rows = new ArrayList<List<Integer>>();

      //get input and put in arraylist
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

      //loop through each seat in the row, changing as necessary
      //if no seats were changed in the grid, exit the loop
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

      //count number of occupied seats
      int res = 0;
      for(int i=0; i<rows.size(); i++){
        for(int j=0; j<rows.get(i).size(); j++){
          if(rows.get(i).get(j) > 0) res++;
        }
      }
      System.out.println(res);
  }

  static int checker(int x, int y){
      occ = 0;
      int num = rows.get(x).get(y);
      boolean a = empty(x-1, y-1, -1, -1);
      boolean b = empty(x-1, y+1, -1, 1);
      boolean c = empty(x+1, y-1, 1, -1);
      boolean d = empty(x+1, y+1, 1, 1);
      boolean e = empty(x-1, y, -1, 0);
      boolean f = empty(x+1, y, 1, 0);
      boolean g = empty(x, y-1, 0, -1);
      boolean h = empty(x, y+1, 0, 1);
      if(num < 0 && a && b && c && d && e && f && g && h){
        changed = true;
        return count;
      }else if(num < 0){
        return num;
      }else if(occ >= 5){
        changed = true;
        return count*-1;
      }else{
        return num;
      }

  }

  static boolean empty(int x, int y, int d1, int d2){
    if(x < 0 || y < 0 || x >= rows.size() || y >= rows.get(x).size()) return true;
    if(rows.get(x).get(y) == (count*-1) || (rows.get(x).get(y) > 0 && rows.get(x).get(y) != count)){
      occ++;
      return false;
    }
    if(rows.get(x).get(y) != 0) return true;
    return empty(x+d1, y+d2, d1, d2);
  }


}
