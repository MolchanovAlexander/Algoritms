package org.example.techcheck;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentsStatisticService {
    public static Map<Integer, Double> averageGroupGrades(List<Student> students) {
        Map<String, Double> studentAvgMarks = students.stream()
                .collect(Collectors.toMap(
                        Student::getName,
                        student -> student.getGrades().stream().mapToInt(Integer::intValue).average().orElse(0)
                ));

        Map<Integer, Double> groupAvgMarks = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGroupId,
                        Collectors.averagingDouble(student -> studentAvgMarks.get(student.getName()))
                ));

        return groupAvgMarks;
    }
}
/*
.collect(Collectors.toMap(
                        c -> c, // Key is character
                        c -> (int)c // Value is numeric value of character or character itself
                ));
*Маючи список студентів, де кожен студент має ідентифікатор групи, ім’я та список оцінок,
*  створіть метод averageGroupGrades у класі StudentsStatisticService,
*  який обчислює середню оцінку для кожної групи та повертає мапу
* з ідентифікатором групи як ключ і середню оцінку як значення.

Приклад:

List<Student> students = Arrays.asList(
    new Student(1, "Student 1", Arrays.asList(85, 90, 78)),
    new Student(2, "Student 2", Arrays.asList(92, 88, 94)),
    new Student(1, "Student 3", Arrays.asList(75, 82, 79)),
    new Student(3, "Student 4", Arrays.asList()),
    new Student(2, "Student 5", Arrays.asList(89, 95, 91)),
    new Student(1, "Student 6", Arrays.asList()),
    new Student(4, "Student 7", Arrays.asList(100, 98)),
    new Student(5, "Student 8", Arrays.asList(47)),
    new Student(5, "Student 9", Arrays.asList(99, 100, 98, 97, 96))
);

Map<Integer, Double> result = StudentsStatisticService.averageGroupGrades(students);
// Очікуваний результат: {1=81.5, 2=91.5, 3=0.0, 4=99.0, 5=89.5}
* */
