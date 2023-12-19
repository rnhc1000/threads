package streamHandling.application;
/*
 * @(#)StreamHandling.java
 * @author  Ricardo Ferreira
 * @version 1.0
 * @since   2023-03-31
 * Copyright (c) 2005-2023 Datagen1x.
 * All rights reserved.
 * @param Given a list of Objects
 * @return:
 * true if all pairs are ok, false otherwise.
 * 1- Find list of students whose first name starts with alphabet A
 * 2- Group The Student By Department Names
 * 3 - Older student
 * Based on:
 * https://medium.com/illumination/java-8-stream-api-commonly-asked-interview-questions-2a57081044ef
 */

import streamHandling.entities.Student;

import java.util.*;
import java.util.stream.Collectors;

public class StreamHandling {

  public static void main(String[] args) {

    long start = System.currentTimeMillis();
    Scanner input = new Scanner(System.in);
    System.out.print("Input the Initial Character of Student First Name: ");
    char initial = input.next().charAt(0);
    System.out.print("Input Student Department: ");
    input.nextLine();
    String department = input.nextLine();
    List<Student> students = populateList();

    List<Student> studentFirstCharacterOfName = startsWithACertainCharacter(students, initial);
    System.out.println(studentFirstCharacterOfName);

    double average = averageAgeOfStudents(students);
    System.out.println("Average age: " + String.format("%.2f", average));

    List<Student> studentsByDepartment = groupByDepartment(students, department);
    for (Student s : studentsByDepartment) {
      System.out.println(s);
    }

    System.out.println("Grouped by Department...");
    Map<String, List<Student>> allStudentsGroupedByDepartment = groupedAllByDepartment(students);
    for (Map.Entry<String, List<Student>> entry : allStudentsGroupedByDepartment.entrySet()) {
      System.out.print("\n" + entry.getKey() + ": \n" + entry.getValue().toString());
    }

    OptionalInt olderStudent = olderStudent(students);
    System.out.print("\n\nOlder Student has : " + olderStudent + " years old!\n");

    System.out.println("List of Departments: " + departmentId(students));

    System.out.print("\nStudents Count by Department:\n");
    Map<String, Long> studentCount = studentCountByDepartment(students);
    for (Map.Entry<String, Long> entry : studentCount.entrySet()) {
      System.out.println("Department: " + entry.getKey() + " --- Count: " + entry.getValue());
    }
    System.out.println("Sorted List Of Students per Rank: ");
    List<Student> rankedStudents = highestRanked(students);
    for (Student s : rankedStudents) {
      System.out.print("\n" + s);
    }

    System.out.print("\nAverage Rank By Department: ");
    Map<String,Double> averageRank = averageRankByDepartment(students);
    for (Map.Entry<String,Double> entry : averageRank.entrySet()) {
      System.out.println("Department-> " + entry.getKey() + " - Rank: " + entry.getValue());
    }
    long end = System.currentTimeMillis();
    System.out.println("Time to compute list of students: " + (end - start) + " ms!");
    input.close();
  }

  public static Map<String, Double> averageRankByDepartment(List<Student> students) {
    Map<String, Double> averageRank = new HashMap<>();
    averageRank = students.stream()
            .collect(Collectors.groupingBy(Student::department, Collectors.averagingDouble(Student::rank)));
    return averageRank;
  }
  public static List<Student> highestRanked(List<Student> students) {
    List<Student> highestRankedStudent = students.stream()
            .sorted(Comparator.comparing(Student::rank)).toList();
    return highestRankedStudent;
  }

  public static Map<String, Long> studentCountByDepartment(List<Student> students) {
    Map<String, Long> returnMap = new HashMap<>();
    returnMap = students.stream()
            .collect(Collectors
                    .groupingBy(Student::department, Collectors.counting())
            );
    return returnMap;
  }

  public static Set<String> departmentId(List<Student> students) {
    System.out.println(students.stream().filter(x -> x.age() > 30).toList());
    return students.stream().map(x -> x.department()).collect(Collectors.toSet());
  }

  public static OptionalInt olderStudent(List<Student> students) {
    return students.stream().mapToInt(Student::age).max();
  }

  public static List<Student> startsWithACertainCharacter(List<Student> students, char c) {
    return students.stream().filter(s -> s.firstName().startsWith(String.valueOf(c))).toList();
  }

  public static double averageAgeOfStudents(List<Student> students) {
    double totalAge = students.stream().map(Student::age).reduce(0, (a, b) -> a + b);
    double count = students.stream().count();
    return totalAge / count;
  }

  public static List<Student> groupByDepartment(List<Student> students, String department) {
    return students.stream().filter(d -> d.department().equals(department)).toList();
  }

  public static Map<String, List<Student>> groupedAllByDepartment(List<Student> students) {
    return students.stream().collect(Collectors.groupingBy(Student::department));
  }

  public static List<Student> populateList() {

    return Arrays.asList(
            new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
            new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
            new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
            new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
            new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
            new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
            new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
            new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
            new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
            new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98)
    );
  }
}
