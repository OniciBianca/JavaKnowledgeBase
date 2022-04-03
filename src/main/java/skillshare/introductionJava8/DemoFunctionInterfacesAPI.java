package skillshare.introductionJava8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DemoFunctionInterfacesAPI {

    public static void main(String[] args) {
        Consumer<String> greeterFn = greeting -> System.out.println(greeting);
        Consumer<String> greeterFn2 = System.out::println; // refactored to use method references
        greeterFn2.accept("Hello there from a method reference!");

        Consumer<String> consumer = fruit -> System.out.println("My favourite fruit is: " + fruit);
        consumer.accept("pear");

        Supplier<Integer> supplier = () -> 42;
        System.out.println("Value returned: " + supplier.get());

        Function<Integer, String> function = age -> age > 21 ? "You can drive!" : "Looks like you're walking!";
        System.out.println("The result of the function is: " + function.apply(17));

        Predicate<Person> isInFrontPhoneDirectory = person -> person.name.substring(0,1).toUpperCase().equals("A");
        System.out.println(isInFrontPhoneDirectory.test(new Person("Adam", 17)));
        System.out.println(isInFrontPhoneDirectory.test(new Person("Zoe", 81)));

        Predicate<Person> isRetirementAge = person -> person.age >= 65;
        System.out.println("Is Zoe retired: " + isRetirementAge.test(new Person("Zoe", 81)));
    }

    static class Person {
        String name;
        int age;

        public Person(String s, int age) {
            this.name = s;
            this.age = age;
        }
    }
}
