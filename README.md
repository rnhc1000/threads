## Java Coding Daily - @Ricardo Ferreira
The more senior you are the more you're involved with mentoring, helping, monitoring and discussing ideas, you have less time dedicated to code what is the most important activity for a programmer.
To keep up with the recent developments and evolution of Java language there is no other solution than coding as much as you can, revisiting concepts, ideas, suggestions, doubts etc...
Here I have met my peace of mind and happiness in coding as much as I can.
There are a bunch of challenges resolved my way. What I mean by that? No copy/paste from anywhere, doesn't matter the outcome of my solution. Sometimes you will find O(1) solutions but sometimes you will find some O(n2). So the deal is... Try to improve it and open up a PR...

## _Tools_
- Java 17
- IntelliJ Community Edition

## _Table of contents_
- [Java Coding Daily - @Ricardo Ferreira](#java-coding-daily---ricardo-ferreira)
- [_Tools_](#tools)
- [_Table of contents_](#table-of-contents)
- [_Screenshot_](#screenshot)
- [_Links_](#links)
- [_Built with_](#built-with)
- [_What I practiced_](#what-i-practiced)
- [_Continued development_](#continued-development)
  - [_Useful resources_](#useful-resources)
- [_Author_](#author)
- [Acknowledgments](#acknowledgments)


## _Screenshot_
[![](./carbon.png)]()
## _Links_
- Live Site URL: [] 
## _Built with_

 ![](https://ferreiras.dev.br/assets/images/icons/java-icon.svg)| ![](https://ferreiras.dev.br/assets/images/icons/git-scm-icon.svg) | ![](https://ferreiras.dev.br/assets/images/icons/icons8-intellij-idea.svg) | ![](https://ferreiras.dev.br/assets/images/icons/linux-original.svg) | ![](https://ferreiras.dev.br/assets/images/icons/icons8-visual-studio-code.svg)

 ## _What I practiced_
```java
/*
 * @(#)CheckPairs({},[],()).java
 * @author  Ricardo Ferreira
 * @version 1.0
 * @since   2023-03-31
 * Copyright (c) 2005-2023 Datagen1x.
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
        if (!stack.isEmpty() && dictionary.get(stack.peek()).equals(c)) {
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


``` 

## _Continued development_
- Next step: Java 21 Virtual Threads.
- 
### _Useful resources_
- [https://docs.oracle.com/en/java/] Always trust and read the official documentation!

## _Author_
- Website - [https://ferreiras.dev.br] 
## Acknowledgments
