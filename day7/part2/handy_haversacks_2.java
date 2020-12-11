import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
class handy_haversacks_2{
  static HashMap<String, ArrayList<String>> h;
  public static void main(String[] args){
    h = new HashMap<>();
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
    ArrayList<String> al = h.get("shiny gold");
    //System.out.println("initial list: " + al);
    while(al.size() > 0){
      //System.out.println(al);
      String temp = al.get(0);
      al.remove(0);
      String[] words = temp.split(" ");
      int num = Integer.parseInt(words[0]);
      String type = words[1] + " " + words[2];
      //System.out.println("NUM: " + num);
      count += num;
      ArrayList<String> temp2 = h.get(type);
      if(!h.containsKey(type)) continue;
      for(int i=0; i<temp2.size(); i++){
        String[] words2 = temp2.get(i).split(" ");
        String type2 = words2[1] + " " + words2[2];
        int num2 = Integer.parseInt(words2[0]);
        num2 *= num;
        al.add(num2 + " " + type2);
        //System.out.println(num2);
        //System.out.println(type + " -> " + type2);
      }
    }
    System.out.println(count);


  }

  //split input and put in hashtable h
  static void line_splitter(String line){
    String[] words = line.split(" ");
    String type1 = words[0] + " " + words[1];
    ArrayList<String> type2 = new ArrayList<>();
    if(words.length <= 7) return;
    for(int i=5; i<words.length; i+=4){
      int temp = Integer.parseInt(words[i-1]);
      type2.add(words[i-1] + " " + words[i] + " " + words[i+1]);
    }
    h.put(type1, type2);
  }





}
