package my.dev.com.algoritms.patterns.structural.facade.librares;

public class ShowerLibrary  {

    public static <T> void showSomething(T object) {
        System.out.println("Class " + object.getClass().getSimpleName() + " with value: " + object.toString());
    }
}
