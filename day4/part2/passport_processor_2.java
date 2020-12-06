import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class passport_processor_2 {
  static ArrayList<String> lines;
  public static void main(String[] args){
    File f = new File("input.txt");
    lines = new ArrayList<>();
    try{
      Scanner sc = new Scanner(f);
      String curr = "";
      while(sc.hasNextLine()){
        String line = sc.nextLine();
        if(line.isEmpty()){
          lines.add(curr);
          curr = "";
        }else{
          curr += (line + " ");
        }
      }
      lines.add(curr);
    }catch(FileNotFoundException e){
      System.out.println("Error: file not found");
    }
    int count = 0;
    for(int i=0; i<lines.size(); i++){
      count += checker(lines.get(i));
    }
    System.out.println(count);
  }

  static int checker(String s){
    String[] pairs = s.split(" ");
    if(pairs.length < 7) return 0;
    if(pairs.length == 8) return validator(pairs);
    for(int i=0; i<pairs.length; i++){
      String[] temp = pairs[i].split(":");
      if(temp[0].equals("cid")) return 0;
    }
    return validator(pairs);
  }

  static int validator(String[] pairs){
     for(int i=0; i<pairs.length; i++){
       String[] temp = pairs[i].split(":");
       boolean b = true;
       if(temp[0].equals("byr")){
         b = check_num(temp[1], 1920, 2002);
       }else if(temp[0].equals("iyr")){
         b = check_num(temp[1], 2010, 2020);
       }else if(temp[0].equals("eyr")){
         b = check_num(temp[1], 2020, 2030);
       }else if(temp[0].equals("hgt")){
         b = check_height(temp[1]);
       }else if(temp[0].equals("hcl")){
         b = check_hair(temp[1]);
       }else if(temp[0].equals("ecl")){
         b = check_eye(temp[1]);
       }else if(temp[0].equals("pid")){
         b = check_pid(temp[1]);
       }
       if(b == false) return 0;
     }
     return 1;
  }

  static boolean check_num(String s, int low, int high){
    if(s.length() != 4) return false;
    int num = Integer.parseInt(s);
    if(num < low || num > high) return false;
    return true;
  }

  static boolean check_height(String s){
    if(s.length() < 4) return false;
    String unit = s.substring(s.length()-2);
    String val = s.substring(0, s.length()-2);
    int num = Integer.parseInt(val);
    if(unit.equals("cm")){
      if(num < 150 || num > 193) return false;
    }else if(unit.equals("in")){
      if(num < 59 || num > 76) return false;
    }else{
      return false;
    }
    return true;
  }

  static boolean check_hair(String s){
    if(s.charAt(0) != '#') return false;
    if(s.length() != 7) return false;
    for(int i=1; i<s.length(); i++){
      char c = s.charAt(i);
      if(c >= '0' && c <= '9') continue;
      if(c >= 'a' && c <= 'z') continue;
      return false;
    }
    return true;
  }

  static boolean check_eye(String s){
    if(s.equals("amb") || s.equals("blu") || s.equals("brn") || s.equals("gry") || s.equals("grn") || s.equals("hzl") || s.equals("oth")){
      return true;
    }
    return false;
  }

  static boolean check_pid(String s){
    if(s.length() != 9) return false;
    return true;
  }


}
