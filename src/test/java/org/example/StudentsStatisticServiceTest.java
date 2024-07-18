package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.techcheck.Student;
import org.example.techcheck.StudentsStatisticService;
import org.junit.Assert;
import org.junit.Test;

public class StudentsStatisticServiceTest {

  @Test
  public void shouldHandleEmptyList() {
    Assert.assertEquals(
      Collections.emptyMap(), 
      StudentsStatisticService.averageGroupGrades(Collections.emptyList())
    );
  }

  @Test
  public void shouldHandleOneStudent() {
    List<Student> student = List.of(
      new Student(1, "Student 1", Arrays.asList(85, 92, 78))
    );
    Map<Integer, Double> expected = new HashMap<>();
    expected.put(1, 85.0);
    Assert.assertEquals(expected, StudentsStatisticService.averageGroupGrades(student));
  }

  @Test
  public void shouldHandleStudentsOfOneGroup() {
    List<Student> students = Arrays.asList(
      new Student(1, "Student 1", Arrays.asList(85, 90, 78)),
      new Student(1, "Student 2", Arrays.asList(92, 91, 94)),
      new Student(1, "Student 3", Arrays.asList(75, 81, 79))
    );
    Map<Integer, Double> expected = new HashMap<>();
    expected.put(1, 85.0);
    Assert.assertEquals(expected, StudentsStatisticService.averageGroupGrades(students));
  }

  @Test
  public void shouldHandleOneStudentPerGroup() {
    List<Student> students = Arrays.asList(
      new Student(1, "Student 1", Arrays.asList(85, 89, 78)),
      new Student(2, "Student 2", Arrays.asList(92, 88, 93)),
      new Student(3, "Student 3", Arrays.asList(75, 83, 79))
    );
    Map<Integer, Double> expected = new HashMap<>();
    expected.put(1, 84.0);
    expected.put(2, 91.0);
    expected.put(3, 79.0);
    Assert.assertEquals(expected, StudentsStatisticService.averageGroupGrades(students));
  }

  @Test
  public void shouldHandleStudentsWithNoGrades() {
    List<Student> students = Arrays.asList(
      new Student(1, "Student 1", List.of()),
      new Student(2, "Student 2", List.of())
    );
    Map<Integer, Double> expected = new HashMap<>();
    expected.put(1, 0.0);
    expected.put(2, 0.0);
    Assert.assertEquals(expected, StudentsStatisticService.averageGroupGrades(students));
  }

  @Test
  public void shouldHandleStudentsWithDifferentNumberOfGrades() {
    List<Student> students = Arrays.asList(
      new Student(1, "Student 1", Arrays.asList(85, 90, 75)),
      new Student(2, "Student 2", Arrays.asList(92, 88, 94)),
      new Student(1, "Student 3", Arrays.asList(75, 82, 79)),
      new Student(3, "Student 4", List.of()),
      new Student(2, "Student 5", Arrays.asList(89, 95, 91)),
      new Student(1, "Student 6", List.of()),
      new Student(4, "Student 7", Arrays.asList(100, 98)),
      new Student(5, "Student 8", List.of(47)),
      new Student(5, "Student 9", Arrays.asList(99, 100, 98, 97, 96))
    );
    Map<Integer, Double> expected = new HashMap<>();
    expected.put(1, 54.0);
    expected.put(2, 91.5);
    expected.put(3, 0.0);
    expected.put(4, 99.0);
    expected.put(5, 72.5);
    Assert.assertEquals(expected, StudentsStatisticService.averageGroupGrades(students));
  }
}
