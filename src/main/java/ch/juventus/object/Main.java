package ch.juventus.object;

public class Main {

    public static void main(String[] args) {
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
    }

}
