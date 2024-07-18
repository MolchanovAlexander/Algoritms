package org.example.techcheck;

import java.util.List;

public class Student {
  private final int groupId;
  private final String name;
  private final List<Integer> grades;

  public Student(int groupId, String name, List<Integer> grades) {
    this.groupId = groupId;
    this.name = name;
    this.grades = grades;
  }

  public int getGroupId() {
    return groupId;
  }
  
  public String getName() {
    return name;
  }
  
  public List<Integer> getGrades() {
    return grades;
  }
}