package skillshare.introductionJava8;

import java.io.PrintStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class DemoMethodReference {

    public static void main(String[] args) {
        //INSTANCE METHOD REFERENCES
        //Bounded method reference
        Consumer<String> greeterFn2 = System.out::println;
        greeterFn2.accept("Hello there from a bounded instance method reference!");

        //Unbounded method reference - the consumer expects two input params because the method ref is unbounded
        BiConsumer<PrintStream, String> greeter = PrintStream::println;
        greeter.accept(System.out, "Hello there from an unbound instance method reference!");


        //STATIC METHOD REFERENCES
        Supplier<Thread> currentThread = Thread::currentThread;
        System.out.println("Current thread= " + currentThread);


        //CONSTRUCTOR METHOD REFERENCES
        Supplier<Calendar> calendarSupplier = GregorianCalendar::new;
        Calendar cal = calendarSupplier.get();
        System.out.println("Calendar: " + cal);
    }
}
