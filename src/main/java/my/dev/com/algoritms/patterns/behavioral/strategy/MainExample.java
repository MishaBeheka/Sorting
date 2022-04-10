package my.dev.com.algoritms.patterns.behavioral.strategy;

import my.dev.com.algoritms.patterns.behavioral.strategy.concrete.strategy.RoadNavigation;
import my.dev.com.algoritms.patterns.behavioral.strategy.concrete.strategy.WalkNavigation;

public class MainExample {
    public static void main(String[] args) {

        Navigator roadNavigator = new Navigator(new RoadNavigation());
        Navigator walkNavigator = new Navigator(new WalkNavigation());

        roadNavigator.showMyWay("Kyiv", "Lviv");
        walkNavigator.showMyWay("Zhahiv", "Staviche");

    }
}
