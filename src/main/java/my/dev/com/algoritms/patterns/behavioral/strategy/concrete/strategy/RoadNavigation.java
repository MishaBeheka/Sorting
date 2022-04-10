package my.dev.com.algoritms.patterns.behavioral.strategy.concrete.strategy;

import my.dev.com.algoritms.patterns.behavioral.strategy.NavigationStrategy;

public class RoadNavigation implements NavigationStrategy {
    @Override
    public void buildWay(String from, String to) {
        System.out.println("Build way from " + from + " to " + to + " by road!");
    }
}
