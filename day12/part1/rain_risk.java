import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class rain_risk {
  static int[] coord;
  static int dir;
  public static void main(String[] args){
      File f = new File("input.txt");
      coord = new int[2];
      dir = 0;
      try{
          Scanner sc = new Scanner(f);
          while(sc.hasNext()){
            String next_move = sc.next();
            move_boat(next_move);
          }
      }catch (FileNotFoundException e){
          System.out.println("Error: file not found");
      }
      System.out.println(Math.abs(coord[0]) + Math.abs(coord[1]));
  }

  static void move_boat(String move){
    char c = move.charAt(0);
    int spaces = Integer.parseInt(move.substring(1));
    if(c == 'N'){
      coord[1] += spaces;
    }else if(c == 'S'){
      coord[1] -= spaces;
    }else if(c == 'E'){
      coord[0] += spaces;
    }else if(c == 'W'){
      coord[0] -= spaces;
    }else if(c == 'L'){
      dir -= spaces;
      if(dir < 0){
        dir += 360;
      }
    }else if(c == 'R'){
      dir += spaces;
      if(dir >= 360){
        dir -= 360;
      }
    }else{ //move forward
      if(dir == 0){
        coord[0] += spaces;
      }else if(dir == 90){
        coord[1] -= spaces;
      }else if(dir == 180){
        coord[0] -= spaces;
      }else{
        coord[1] += spaces;
      }
    }
  }
}
