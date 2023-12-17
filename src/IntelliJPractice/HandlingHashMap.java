/*
 * @(#)HandlingHashMap.java
 * @author  Ricardo Ferreira
 * @version 1.0
 * @since   2023-03-31
 * Copyright (c) 2005-2023 Datagen1x.
 * Santo Agapito, 7, Imperatriz - MA, BR.
 * All rights reserved.
 * @param Given a list of Studentes and grades
 * @return Student with the largest average.
 *
 */
package IntelliJPractice;

import java.util.HashMap;
import java.util.Map;

class TestMap {
  public static Map<String,Integer> bestAverage(String[][] grades) {
    Integer average = Integer.MIN_VALUE;
    Map<String, Integer> map = new HashMap<>();
    Map<String, Integer> result = new HashMap<>();
    for (String[] s : grades) {
      String name = s[0];
      Integer grade = Integer.parseInt(s[1]);
      if (map.containsKey(name)) {
        grade += map.get(name);
        map.put(name, grade);
      } else {
        map.put(name,grade);
      }
    }
    Integer max = Integer.MIN_VALUE;
    String name = "";
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (entry.getValue() > max) {
        max = entry.getValue();
        name = entry.getKey();
      }
    }
    result.put(name, max);
    return result;
  }
}

public class HandlingHashMap {

  public static void main(String[] args) {
    String[][] averages = {
            {"John", "96"},
            {"Peter", "85"},
            {"Mark", "100"},
            {"John", "100"},
            {"Mark", "95"},
            {"Isabel", "89"},
            {"Isabel", "97"},
            {"Peter", "81"}
    };
    Map<String,Integer> response = new HashMap<>();
    response = TestMap.bestAverage(averages);
    System.out.printf("Average: " + response);
  }

}
