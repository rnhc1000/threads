/*
 * @(#)CheckPairs({},[],()).java
 * @author  Ricardo Ferreira
 * @version 1.0
 * @since   2023-03-31
 * Copyright (c) 2005-2023 Datagen1x.
 * Santo Agapito, 7, Imperatriz - MA, BR.
 * All rights reserved.
 * @param Input a string of brackets, parenthesis
 * and curly braces in any order.
 * @return true if all pairs are ok, false otherwise.
 *
 */
package CheckParenthesis;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class HandlingParenthesis {

  public static boolean isValid(String s) {
    Map<Character, Character> dictionary = new HashMap<>();
    dictionary.put('(', ')');
    dictionary.put('[', ']');
    dictionary.put('{', '}');

    char[] receiver = new char[s.length()];
    receiver = s.toCharArray();
    Stack<Character> stack = new Stack<>();
    for (char c : receiver) {
      if (dictionary.containsKey(c)) {
        stack.push(c);
      } else if (dictionary.containsValue(c)) {
        if (!stack.isEmpty() && dictionary.get(stack.peek()) == c) {
          stack.pop();
        } else {
          return false;
        }
      }
    }
    return stack.empty();
  }

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    System.out.print("Input the sequence of '(', ')', '{', '}', '[', ']' characters: ");
    String sequence = input.nextLine();
    boolean result = isValid(sequence);
    input.close();
    if (result) {
      System.out.println("The sequence has all opening and closing brackets, parenthesis and curly braces!");
    } else {
      System.out.println("The sequence is missing some brackets,parenthesis or curly braces!");
    }
  }
}
