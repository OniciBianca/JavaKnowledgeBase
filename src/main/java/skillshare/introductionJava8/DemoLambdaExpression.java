package skillshare.introductionJava8;

public class DemoLambdaExpression {
    public static void main(String[] args) {
//        () -> System.out.println("Hello!");  - This throws compiler error because a lambda expression standalone like this needs to have a return type

          Runnable runnable = () -> {
              String name = "Matt";
              System.out.println("Hello " + name + " !");
          };
          Executor executor = () -> {
              String name = "Matt";
              System.out.println("Hello " + name + " !");
          }; // you can assign the same lambda expression to many functional interfaces
          runnable.run();


//        Runnable runnable = (name) -> {
//            System.out.println("Hello " + name + " !");
//        };  -  if I add one input parameter the function descriptor is not compatible with the Runnable anymore

        StringRunnable stringRunnable  = (name) -> {
            System.out.println("Hello " + name + " !");
        };
        stringRunnable.run("James");
    }

    @FunctionalInterface
    public interface StringRunnable {
        public abstract void run(String s);
    }

    @FunctionalInterface
    public interface Executor {
        void execute();
    }
}


