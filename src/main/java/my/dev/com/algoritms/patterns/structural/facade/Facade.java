package my.dev.com.algoritms.patterns.structural.facade;

import my.dev.com.algoritms.patterns.structural.facade.librares.IntegerLibrary;
import my.dev.com.algoritms.patterns.structural.facade.librares.ShowerLibrary;
import my.dev.com.algoritms.patterns.structural.facade.librares.StringLibrary;

public class Facade {

    //Here a difficult method where we use a lot of other libraries and writing hard logic (for example).
    // But client won't know about this logic. He will just use main logic this method without implementation details.

    public void doingSomethingHardLogicWithString(String str) {

        ShowerLibrary.showSomething(str);

        var reversedString = StringLibrary.reverseString(str);

        ShowerLibrary.showSomething(reversedString);

        var reversedInt = IntegerLibrary.parseStringToInt(reversedString);

        ShowerLibrary.showSomething(reversedInt);
    }
}
