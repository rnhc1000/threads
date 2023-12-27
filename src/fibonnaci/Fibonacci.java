package fibonnaci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Fibonacci {
  public static void main(String[] args) {

    int a = 10;
    System.out.println(calculaFibonacci(a));
    int x = fatorial(a);
    System.out.println(x);
    Random random = new Random();
    Integer[] nums = new Integer[random.nextInt(0, 10)];
    System.out.println(nums.length);
    for (int i = 0; i < nums.length; i++) {
      nums[i] = random.nextInt(100, 200);
    }
    List<Integer> listOfNums = Arrays.asList(nums);
    List<Integer> even = listOfNums.stream().filter((element) -> element % 2 == 0).map(element -> element * 2).sorted().toList();
    List<Integer> odd = listOfNums.stream().filter((element) -> element % 2 == 1).map(element -> element * 3).sorted().toList();
    odd.forEach(item -> System.out.print(item + " "));
    even.forEach(item -> System.out.print(item + " "));

    int middle = even.size() / 2;
    int forward = even.size() / 2 + 1;
    int reverse = even.size() / 2 - 1;
    try {
      if (even.get(middle) > even.get(forward)) {
        System.out.println("Number of the middle..." + even.get(middle));
        System.out.println("Number is forward... " + even.get(forward));
      } else {
        System.out.println("Number of the middle..." + even.get(middle));
        System.out.println("Number is down..." + even.get(reverse));
      }
    } catch (ArrayIndexOutOfBoundsException ex) {
      System.out.println("Error: " + ex.getMessage());
    }
  }

  public static List<Integer> calculaFibonacci(int seed) {
    List<Integer> list = new ArrayList<>();

    if (seed == 1) {
      list.add(1);
      return list;
    }
    int anterior=0;
    int atual=1;
    int proximo=1;

    list.add(proximo);

    for (int i = 0; i < seed; i++) {
      proximo = anterior + atual ;
      list.add(proximo);
      anterior=atual;
      atual = proximo;
    }

//    System.out.println(list);
    return list;
  }

  public static int fatorial(int n) {

    if (n == 0)
      return 1;

    return  n * fatorial(n - 1);
  }
}
