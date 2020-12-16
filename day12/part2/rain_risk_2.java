import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class rain_risk_2 {
  static int[] boat;
  static int[] wp;
  public static void main(String[] args){
      File f = new File("input.txt");
      boat = new int[2];
      wp = new int[2];
      wp[0] = 10;
      wp[1] = 1;
      try{
          Scanner sc = new Scanner(f);
          while(sc.hasNext()){
            String next_move = sc.next();
            move_boat(next_move);
          }
      }catch (FileNotFoundException e){
          System.out.println("Error: file not found");
      }
      System.out.println(Math.abs(boat[0]) + Math.abs(boat[1]));
  }

  static void move_boat(String move){
    char c = move.charAt(0);
    int spaces = Integer.parseInt(move.substring(1));
    if(c == 'N'){
      wp[1] += spaces;
    }else if(c == 'S'){
      wp[1] -= spaces;
    }else if(c == 'E'){
      wp[0] += spaces;
    }else if(c == 'W'){
      wp[0] -= spaces;
    }else if(c == 'R'){
      while(spaces > 0){
          int temp = wp[1];
          wp[1] = wp[0];
          wp[0] = temp;
          wp[1] *= -1;
          spaces -= 90;
      }
    }else if(c == 'L'){
      while(spaces > 0){
        int temp = wp[1];
        wp[1] = wp[0];
        wp[0] = temp;
        wp[0] *= -1;
        spaces -= 90;
      }
    }else{ //move forward
      boat[0] += (spaces * wp[0]);
      boat[1] += (spaces * wp[1]);
    }
  }
}
