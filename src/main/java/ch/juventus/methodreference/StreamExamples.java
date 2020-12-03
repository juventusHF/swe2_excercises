package ch.juventus.methodreference;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExamples {

    public static void main(String[] args) {
        exerciseOne();
        exerciseTwo();
    }

    private static void exerciseOne() {
        List<Integer> numbers1 = Arrays.asList(1,2,4,6,10,15,30);
        List<Integer> numbers2 = Arrays.asList(3,7,8,12,17,18,22);
        List<Integer> numbers3 = Arrays.asList(0,33,2,16,9,9,21);
        List<List<Integer>> numberLists = new ArrayList<>();
        numberLists.add(numbers1);
        numberLists.add(numbers2);
        numberLists.add(numbers3);

        List<Integer> result = numberLists.stream()
                .flatMap(List::stream)
                .map(number -> number*2)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }

    private static void exerciseTwo() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Anna", 16));
        people.add(new Person("Bob", 18));
        people.add(new Person("Carl", 20));
        people.add(new Person("Daniel", 25));

        boolean result = people.stream()
                .filter(person -> !person.getName().toLowerCase().startsWith("a"))
                .map(Person::getAge)
                .allMatch(age -> age > 18);

        System.out.println(result);

    }

}
