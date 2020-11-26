package ch.juventus.sorting;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int compareResult = o1.getFirstName().compareTo(o2.getFirstName());
        if(compareResult == 0) {
            return o1.getLastName().compareTo(o2.getLastName());
        }
        return compareResult;
    }
}
