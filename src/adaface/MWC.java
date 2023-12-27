package adaface;
/**
 * If you add '0' with int variable, it will return actual value in the char
 * variable. The ASCII value of '0' is 48. So, if you add 1 with 48, it becomes
 * 49 which is equal to 1. The ASCII character of 49 is 1.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MWC {

  public MWC() {
  }

  public ArrayList<Character> Crowd(String crowd) {
    Map<String, Integer> map = getStringIntegerMap();
    System.out.println(map);
    int count = 1;
    int countM = 0, countW = 0, countC = 0;
    ArrayList<Character> people = new ArrayList<>();
    Map<String, Integer> counter = new HashMap<>();
    char[] c = crowd.toCharArray();
    counter.put(String.valueOf(c[0]), 1);
    for (char s : c) {
//      count = map.get(String.valueOf(s));
      if (map.containsKey(String.valueOf(s))) {
        count=counter.get(String.valueOf(s));
        counter.put(String.valueOf(s), ++count);
      } else {
        counter.put(String.valueOf(s), 1);
      }
      switch (s) {
        case 'M' -> countM += 1;
        case 'W' -> countW += 1;
        case 'C' -> countC += 1;
      }
    }
    System.out.println(counter);
    people.add((char) (countM + '0'));
    people.add('M');
    people.add((char) (countW + '0'));
    people.add('W');

    if (countC == 0) {
      return people;
    } else {
      people.add((char) (countC + '0'));
      people.add('C');
    }
    return people;
  }

  private static Map<String, Integer> getStringIntegerMap() {
    String path = "/home/rferreira/dev/advancedJava/src/letters.txt";
    List<String> characters = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      String line = "";
      while ((line = br.readLine()) != null) {
        characters.add(line);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    Map<String, Integer> map = new HashMap<>();
    int sizeOfCharacters = characters.size();
    for (String character : characters) {
      map.put((character), 1);
    }
    return map;
  }

  public static void main(String[] args) {
    String s = "MMMWWC";
    MWC str = new MWC();
    ArrayList<Character> rsp = new ArrayList<>();
    rsp = str.Crowd(s);
    for (char x : rsp) {
      System.out.print(String.valueOf(x));
    }
  }
}

/**
 * for (Map.Entry<K,V> entry : map.entrySet() ) {
 *   System.out.print("\n\n entry.getKey() + " " + entry.getValue());
 * }
 */