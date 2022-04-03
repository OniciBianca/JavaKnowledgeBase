package Interviu;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;


/**
 * We have a list of persons. A person has the following fields: name, age, address.
 * An address has the following fields: street, streetNumber, city.
 *
 * Requirements:
 * 1. Implement a method that returns the average age of the persons above a certain age that live in a certain city.
 * The solution preferably uses Java Streams.
 * Print the average age of the people above 35 years old that live in Bucuresti.
 * 2. Apply the encapsulation and immutability concepts where you see fit, and modify the code accordingly.
 */
class Address {
    private String street;
    private int streetNumber;
    public String city;
    public boolean primary;

    public Address(String street, int streetNumber, String city, boolean primary) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        this.primary = primary;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }
}

class Person {
    public String name;
    public int age;
    public List<Address> addresses;

    public Person(String name, int age, List<Address> addresses) {
        this.name = name;
        this.age = age;
        this.addresses = addresses;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}

public class Solution {
    private static List<Person> getInputData(){
        List<Person> persons = new ArrayList<>();

        //Input Addresses
        Address add1 = new Address("Galaxiei", 4, "Brasov", true);
        Address add2 = new Address("Neptun", 5, "Bucuresti", true);
        Address add3 = new Address("Bradului", 6,"Constanta", false);

        List<Address> addressList1 = new ArrayList<>();
        addressList1.add(add1);

        List<Address> addressList2 = new ArrayList<>();
        addressList2.add(add2);
        addressList2.add(add3);

        //Input persons;
        Person pers1 = new Person("Ion Creanga", 44, addressList1);
        Person pers2 = new Person("Mihai Eminescu", 30, addressList2);
        Person pers3 = new Person("Valeriu Mitrea", 35, addressList2);
        Person pers4 = new Person("Valentin Cristea", 38, addressList2);
        Person pers5 = new Person("Camil Petrescu", 40, addressList2);

        persons.add(pers1);
        persons.add(pers2);
        persons.add(pers3);
        persons.add(pers4);
        persons.add(pers5);

        return persons;
    }
    private static double getAverage(List<Person> persons, int ageLimit, String city){
        double avg =  persons.stream()
                .filter(person -> isValid(ageLimit, person, city))
                .collect(Collectors.averagingDouble(Person::getAge));
        return avg;
    }

    private static boolean isValid(int ageLimit, Person person, String city) {
        return person.age > ageLimit && person.addresses.stream().filter(a -> a.isPrimary() && a.getCity().equals(city)).findAny().isPresent();
    }

    public static void main(String[] args) {
        List<Person> persons = getInputData();
        //Add your code here - Print the average age of the people above 35 years old that live in Bucuresti
        System.out.println(getAverage(persons, 35, "Bucuresti"));
    }
}