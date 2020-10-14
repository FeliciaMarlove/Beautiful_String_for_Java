/*
Short demo of the use of BeautifulString abstract class on the ExampleClass
 */

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        ExampleThing[] exampleThings = ExampleThing.dummyPopulate();
        BeautifulString.show(exampleThings[0]);
    }
}
