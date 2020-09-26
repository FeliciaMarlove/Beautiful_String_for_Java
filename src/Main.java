/*
Short demo of the use of BeautifulString abstract class on the ExampleClass
 */

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<String> aList = List.of("what", "e", "ver");
        Map<Integer, String> aMap = Map.of(1, "first", 2,"second", 3, "third");
        double[] anArray = {5.0, 2.3, 52.2};

        ExampleThing dummyExample = new ExampleThing(5, true, false, "blablabla", new ExampleThing(), anArray, aList, aMap);
        BeautifulString.show(dummyExample);
    }
}
