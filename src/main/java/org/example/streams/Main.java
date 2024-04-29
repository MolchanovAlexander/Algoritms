package org.example.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String input = "a1b2c3d4e5";
        String re123 = FilterAndModifyLetters.filterLetters("HelloWorld");
        System.out.println(re123);
        char ch1 = 'A';
        char ch2 = '5';
        char ch3 = '+';
        int resp = Character.getType(ch1);
        System.out.println(Character.getType(ch2) == Character.UPPERCASE_LETTER);
        System.out.println("Type of " + ch1 + ": " + Character.getType(ch1));
        System.out.println("Type of " + ch2 + ": " + Character.getType(ch2));
        System.out.println("Type of " + ch3 + ": " + Character.getType(ch3));
        /*Character.UPPERCASE_LETTER: for uppercase letters
Character.LOWERCASE_LETTER: for lowercase letters
Character.DECIMAL_DIGIT_NUMBER: for numeric digits
Character.OTHER_LETTER: for other letters, such as ideographs
Character.OTHER_PUNCTUATION: for punctuation characters*/

        Predicate<User> userPredicate = user -> user.getName().startsWith("y");
        for (int i = 0; true; i++) {
            System.out.println("welcom");
            break;
        }
        List<User> users = new ArrayList<>();
        users.add(new User(1, "gufr"));
        users.add(new User(2, "asdd"));
        users.add(new User(71, "dsdf"));
        users.add(new User(5, "ytrz"));

        users.stream().filter(userPredicate).forEach(user -> System.out.println(user.getName()));

        List<String> names = List.of("22:guf", "11:dgdu", "33:peregnoi");
        Stream<String> nameStream = names.stream();
        //IntStream, Long / DoubleStream
        IntStream intStream = nameStream.mapToInt(String::length);
        System.out.println(intStream.max());
        names.stream().forEach(System.out::println);
        Stream.of("guf", "dgdu", "peregnoi").forEach(System.out::println);
        int[] digits = new int[]{1, 43, 53, 2, 89, 0};
        Arrays.stream(digits).forEach(System.out::println);
        String guf = "hello newb";
        System.out.println(guf.chars());
        Stream.generate(new Random()::nextInt).limit(5).forEach(System.out::println);
        Stream.iterate(0, i -> i+ 2).limit(6).forEach(System.out::println);
        IntStream.range(4, 17).forEach(System.out::println);
        // 1. using .stream() method from collecti onCollection.stream()
        // 2. Stream.of()
        // 3. Arrays.stream([]).forEach
        // 4. from string.chars();
        // 5. Stream.generate(new Random()::nextInt).limit(5).forEach(System.out::println)
        // 6. Stream.iterate(0, i -> i+ 2).limit(6).forEach(System.out::println);
        // 7. IntStream.range(4, 17).forEach(System.out::println);


        // Create a map from the string where letters are keys and numbers are values
        Map<Character, Integer> resultMap = input.chars()
                .mapToObj(c -> (char) c) // Convert int stream to stream of characters
                .filter(Character::isLetterOrDigit) // Filter out non-letter/digit characters
                .collect(Collectors.toMap(
                        c -> c, // Key is character
                        c -> Character.isDigit(c) ? Character.getNumericValue(c) : c // Value is numeric value of character or character itself
                ));
        System.out.println(FilterAndModifyLettersMap.filterLetters("6el1oWir3d"));
        // Print the resulting map
        resultMap.forEach((key, value) -> System.out.println(key + " -> " + value));
        // usefull .collect(Collectors.groupingBy (Class:: getThing, Collectors.tolist())
        // usefull .collect(Collectors.mapping (Class:: getThing, Collectors.tolist())
        /*/ usefull  IntStream::boxed. mapToInt(i -> i).mapToObj(i-> (char) i).collect(Collectors.toSet())
        The .boxed() method in Java Stream API is used to convert a
        primitive stream (such as IntStream, LongStream, DoubleStream)
        to a Stream of their corresponding wrapper classes
        (Stream<Integer>, Stream<Long>, Stream<Double>). Here's an example:
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        Stream<Integer> boxedStream = intStream.boxed();
        boxedStream.forEach(System.out::println);
         */
        // .findFirst() -> obj from list /findAny / anyMatch-> boolean
        List<Integer> i112 = List.of(1, 3, 345, 34, 7);
        System.out.println(convertAndModifyNumbers(i112));
        TestApp app = new TestApp();
        System.out.println(app.x + "__ " + app.y + app.a1 );
        App2 aaa = new App2(3);
        System.out.println(aaa.index);
        System.out.println(charsIncrementation("abc", 1));
        System.out.println(getOldestPersonAge(names));
        // map test
        List<Person> people = new ArrayList<>();
        Person jess = new Person("Jess", 48, Person.Sex.WOMAN, initCatList());
        people.add(jess);
        Person nick = new Person("Nick", 22, Person.Sex.MAN, initCatList());
        people.add(nick);
        Person joe = new Person("Joe", 25, Person.Sex.MAN, Collections.emptyList());
        people.add(joe);
        Person mary = new Person("Mary", 16, Person.Sex.WOMAN, initCatList());
        people.add(mary);
        Person susy = new Person("Susy", 37, Person.Sex.WOMAN, List.of(new Cat("Kitty", 5)));
        people.add(susy);
        Person barry = new Person("Barry", 29, Person.Sex.MAN, initCatList());
        people.add(barry);
        Person hillary = new Person("Hillary", 48, Person.Sex.WOMAN, List.of(new Cat("Chris", 13)));
        people.add(hillary);
        System.out.println(groupByAge(people) + " map");
        List<String> words = List.of("apple", "banana", "orange", "grape,", "melon", "peach?");
        System.out.println(groupWordsByLastChar(words));

    }
    public static Map<Character, List<String>> groupWordsByLastChar(List<String> words) {
        return words.stream()
                .filter(word -> Character.isLetter(word.charAt(word.length() - 1)))
                .collect(Collectors.groupingBy(word -> word.charAt(word.length() - 1), Collectors.toList()));
    }
    public static String convertAndModifyNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(i ->System.lineSeparator() + "(" + Integer.toBinaryString(i) + ")")
                .reduce((str2, str3) -> str2 + str3)
                .map(Object::toString).orElse(null);
    }
    public static String charsIncrementation(String string, int increment) {
        return string.chars()
                .map(i -> i + increment)
                .mapToObj(i -> String.valueOf((char) i))
                .reduce("",(a, b) -> (a + b));
    }
    public static Long getOldestPersonAge(List<String> people) {
        return people.stream()
                .map(p -> p.substring(0, 2))
                .sorted(Comparator.reverseOrder())
                .mapToLong(Long::valueOf)
                .findFirst().orElse(0);
    }
    public static Map<Integer, List<Person>> groupByAge(List<Person> people) {

        return people.stream()
                .filter(p -> p.getSex() == Person.Sex.WOMAN)
                .collect(Collectors.groupingBy(
                        Person::getAge,
                        Collectors.toList()
                ));
    }
    public static List<Cat> initCatList() {
        Cat tommy = new Cat("Tommy", 5);
        Cat snow = new Cat("Snow", 2);
        Cat jackie = new Cat("Jackie", 15);
        return List.of(tommy, snow, jackie);
    }
}