package ch.juventus.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        sortPeopleWithComparator();
        sortHousesImplementingComparable();
    }

    private static void sortPeopleWithComparator() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Hans", "Muster"));
        people.add(new Person("Peter", "Keller"));
        people.add(new Person("Peter", "Kuster"));
        people.add(new Person("Lisa", "Muster"));

        people.sort(new NameComparator());

        people.stream().forEach(person -> System.out.println(person));
    }

    private static void sortHousesImplementingComparable() {
        List<House> houses = new ArrayList<>();
        houses.add(new House(3, 1, 15, false));
        houses.add(new House(2, 1, 10, true));
        houses.add(new House(5, 2, 25, true));
        houses.add(new House(4, 2, 20, false));
        houses.add(new House(1, 1, 5, true));

        Collections.sort(houses);

        houses.stream().forEach(house -> System.out.println(house));
    }
}
