package my.dev.com.algoritms.patterns.structural.facade.librares;

public class StringLibrary {

    public static String reverseString(String string) {
        return new StringBuilder(string).reverse().toString();
    }
}
