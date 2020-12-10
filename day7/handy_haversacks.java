import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
class handy_haversacks{
  static HashMap<String, ArrayList<String>> h;
  static ArrayList<String> bags;
  static HashMap<String, Boolean> golds;
  public static void main(String[] args){
    h = new HashMap<>();
    bags = new ArrayList<>();
    golds = new HashMap<>();
    File f = new File("input.txt");
    try{
      Scanner sc = new Scanner(f);
      while(sc.hasNext()){
        String line = sc.nextLine();
        line_splitter(line);
      }
    }catch(FileNotFoundException e){
      System.out.println("Error: file not found");
    }
    int count = 0;
    for(int i=0; i<bags.size(); i++){
      if(!h.containsKey(bags.get(i))) continue;
      ArrayList<String> temp = h.get(bags.get(i));
      for(int j=0; j<temp.size(); j++){
        boolean b = finder(temp.get(j));
        if(b){
          if(!golds.containsKey(temp.get(j))){
            golds.put(temp.get(j), true);
          }
          count++;
          break;
        }else{
          if(!golds.containsKey(temp.get(j))){
            golds.put(temp.get(j), false);
          }
        }
      }
    }
    System.out.println(count);

  }

  static void line_splitter(String line){
    String[] words = line.split(" ");
    String type1 = words[0] + " " + words[1];
    bags.add(type1);
    ArrayList<String> type2 = new ArrayList<>();
    if(words.length <= 7) return;
    for(int i=5; i<words.length; i+=4){
      type2.add(words[i] + " " + words[i+1]);
    }
    h.put(type1, type2);
  }

  static boolean finder(String bag){
    if(golds.containsKey(bag)) return golds.get(bag);
    if(bag.equals("shiny gold")) return true;
    if(!h.containsKey(bag)) return false;
    ArrayList<String> temp = h.get(bag);
    for(int i=0; i<temp.size(); i++){
      if(finder(temp.get(i)) == true) return true;
    }
    return false;

  }

}
