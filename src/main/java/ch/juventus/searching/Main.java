package ch.juventus.searching;

import ch.juventus.sorting.Person;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Person, String> personPhoneMap = new HashMap<>();
        personPhoneMap.put(new Person("Hans", "Muster"), "0791234567");
        personPhoneMap.put(new Person("Peter", "Keller"), "0798901234");
        personPhoneMap.put(new Person("Peter", "Kuster"), "0795678901");
        personPhoneMap.put(new Person("Lisa", "Muster"), "0792345678");

        System.out.println(findByPhoneNumber(personPhoneMap, "0798901234"));
        System.out.println(findByPhoneNumber(personPhoneMap, "000"));
    }

    private static Person findByPhoneNumber(Map<Person, String> personPhoneMap, String phoneNumber) {
        if(personPhoneMap.containsValue(phoneNumber)) {
            for (Map.Entry<Person,String> entry : personPhoneMap.entrySet()) {
                if(entry.getValue().equals(phoneNumber)) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }
}
