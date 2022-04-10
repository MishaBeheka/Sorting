package my.dev.com.algoritms.patterns.behavioral.strategy;

public class Navigator {

    private final NavigationStrategy navigationStrategy;

    public Navigator(NavigationStrategy navigationStrategy) {
        this.navigationStrategy = navigationStrategy;
    }

    public void showMyWay(String from, String to) {
        navigationStrategy.buildWay(from, to);
    }
}
