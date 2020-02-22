package ch.juventus.object;

public class Main {

    public static void main(String[] args) {

        // toString exercise

        Person person = new Person();
        Address address = new Address();

        address.setStreet("Rötelsteig");
        address.setNumber(6);
        address.setZip(8037);
        address.setCity("Zürich");

        person.setFirstName("Linda");
        person.setLastName("Krüger");
        person.setAddress(address);
        person.setHasKids(false);

        System.out.println(person);

        // equals & hashCode exercise

        Person p1 = new Person();
        Address a1 = new Address();

        a1.setStreet("Rötelsteig");
        a1.setNumber(6);
        a1.setZip(8037);
        a1.setCity("Zürich");

        p1.setFirstName("Linda");
        p1.setLastName("Krüger");
        p1.setAddress(address);
        p1.setHasKids(false);

        Person p2 = new Person();
        Address a2 = new Address();

        a2.setStreet("Rötelsteig");
        a2.setNumber(6);
        a2.setZip(8037);
        a2.setCity("Zürich");

        p2.setFirstName("Linda");
        p2.setLastName("Krüger");
        p2.setAddress(address);
        p2.setHasKids(false);

        System.out.println("P1 equals P2: " + p1.equals(p2));
    }

}
