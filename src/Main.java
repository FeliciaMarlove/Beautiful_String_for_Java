/*
Short demo of the use of BeautifulString
 */

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        ExampleThing[] exampleThings = ExampleThing.dummyPopulate();
        BeautifulString.show(exampleThings[0]);
    }
}
