package IntelliJPractice;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


class CamelHumps {

  private int limit;
  private String name;

  public CamelHumps(int limit, String name) {
    this.limit = limit;
    this.name = name;
  }

  /**
   * Use a shortcut tp have access to the
   * real name of a class or a method..
   * Ex... LDT -> LocalDateTime
   */
  public CamelHumps() {
  }
}

public class HandlingIntelliJ {
  void methodB() {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    for (Integer j : list) {
      System.out.println("j: " + j);
    }
    for (int i = 0; i < 5; i++) {
      System.out.println("i: " + i);
    }

    List<String> l = Arrays.asList("a", "b");

    //language=JSON Lines
    String x = "{\n" +
            "  \"name\": \"John\",\n" +
            "\"age\":  30\n" +
            "}";

    String regex = "[a-zA-Z]*";

  }

  /**
   * public void methodC() {
   * ExecutorService service = new ThreadPoolExecutor();
   * System.out.println();
   * }
   */

  public void methodD(Collection<String> s) {
    if (s == null) {
      System.out.println("s is null");
    }

    if (s != null) {
      System.out.println("s is not null");
    }
    try {
      System.out.println("Yep");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    String[] str = {"a", "b", "c"};
    for (String string : str) {
      System.out.println(string);
    }

    for (int i = 0; i < str.length; i++) {
      System.out.println("i=: " + i);
    }
    for (int i = str.length - 1; i >= 0; i--) {
      System.out.println("i: " + i);
    }
  }

  void methodA() {
    LocalDateTime date = LocalDateTime.now();
  }
}
